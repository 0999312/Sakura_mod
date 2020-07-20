package cn.mcmod.sakura.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

import cn.mcmod.sakura.api.recipes.WebRecipe;

public class TileEntityWeb extends TileEntity implements ITickable {
	private int cookTime;

	public int getCookTime() {
		return this.cookTime;
	}

	private ItemStackHandler inventory = new ItemStackHandler() {
		@Override
		protected void onContentsChanged(int slot) {
			TileEntityWeb.this.refresh();
		}
        @Override
        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            return !(WebRecipe.getInstance().getResultItemStack(stack).isEmpty());
        }
	};

	public ItemStackHandler getInventory() {
		return this.inventory;
	}

	protected void refresh() {
		if (hasWorld() && !world.isRemote) {
			IBlockState state = world.getBlockState(pos);
			world.markAndNotifyBlock(pos, world.getChunkFromBlockCoords(pos), state, state, 11);
		}
	}

	@Override
	public boolean hasCapability(@Nonnull Capability<?> capability, EnumFacing facing) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing facing) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T) inventory
				: super.getCapability(capability, facing);
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, @Nonnull IBlockState oldState,
			@Nonnull IBlockState newState) {
		return oldState.getBlock() != newState.getBlock();
	}

	@Nonnull
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound par1nbtTagCompound) {
		NBTTagCompound ret = super.writeToNBT(par1nbtTagCompound);
		writePacketNBT(ret);
		return ret;
	}

	@Nonnull
	@Override
	public final NBTTagCompound getUpdateTag() {
		return writeToNBT(new NBTTagCompound());
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		readPacketNBT(par1nbtTagCompound);
	}

	public void writePacketNBT(NBTTagCompound cmp) {
		cmp.setTag("Inventory", inventory.serializeNBT());
	}

	public void readPacketNBT(NBTTagCompound cmp) {
		inventory.deserializeNBT(cmp.getCompoundTag("Inventory"));
	}

	@Override
	public final SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound tag = new NBTTagCompound();
		writePacketNBT(tag);
		return new SPacketUpdateTileEntity(pos, -999, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
		super.onDataPacket(net, packet);
		readPacketNBT(packet.getNbtCompound());
	}

	@Override
	public void update() {
		boolean flag = false;
		if (!this.world.isRemote) {
			if (isRecipes(this.inventory.getStackInSlot(0))) {
				this.cookTime += (1 * calcAdaptation(getWorld(), getPos()));
				if (cookTime >= 32000) {
					cookTime = 0;
					ItemStack result =WebRecipe.getInstance().getResultItemStack(this.inventory.getStackInSlot(0)).copy();
					result.setCount(result.getCount() * this.inventory.getStackInSlot(0).getCount());
					this.inventory.setStackInSlot(0,result);
					flag = true;
				}
		        if (flag)
		        	this.markDirty();
			} else
				cookTime = 0;
		}
	}

	/**
	 * @return
	 */
	protected boolean isRecipes(ItemStack items) {
		ItemStack result = WebRecipe.getInstance().getResultItemStack(items);
		if (!result.isEmpty())
			return true;
		return false;
	}

	private float calcAdaptation(World world, BlockPos pos) {
		Biome biome = world.getBiome(pos);
		boolean isUnderTheSun = world.canBlockSeeSky(pos);
		boolean isRaining = world.isRaining();
		boolean isDaytime = world.getWorldTime() % 24000 < 12000;
		float humidity = biome.getRainfall();
		float temperature = biome.getTemperature(pos);
		float rate;

		if (!isUnderTheSun || isRaining) {
			rate = 0.0F;
		} else {
			rate = isDaytime ? 2.0F : 1.0F;
			rate *= humidity < 0.2D ? 4.0D : humidity < 0.7D ? 2.0D : humidity < 0.9 ? 1.0D : 0.5D;
			rate *= temperature < 0.0D ? 1.0D : temperature < 0.6D ? 1.5D : temperature < 1.0D ? 2.0D : 4.0D;
		}
		return rate;
	}
}