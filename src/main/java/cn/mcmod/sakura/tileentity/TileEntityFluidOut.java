package cn.mcmod.sakura.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import cn.mcmod.sakura.api.recipes.LiquidToItemRecipe;

public class TileEntityFluidOut extends TileEntity implements ITickable, IInventory {
	public FluidTank tank = new FluidTank(10000) {
		@Override
		protected void onContentsChanged() {
			TileEntityFluidOut.this.refresh();
		}

		@Override
		public boolean canFillFluidType(FluidStack fluid) {
			if (!canFill() || fluid.getFluid().isGaseous(fluid) || fluid.getFluid().isLighterThanAir()) {
				return false;
			}
			return fluid.getFluid().getTemperature(fluid) < 500;
		}
	};

	protected NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(),
			ItemStack.EMPTY);

	public TileEntityFluidOut() {
	}
	
	public FluidTank getTank() {
		return this.tank;
	}

	protected void refresh() {
		if (hasWorld() && !world.isRemote) {
			IBlockState state = world.getBlockState(pos);
			world.markAndNotifyBlock(pos, world.getChunkFromBlockCoords(pos), state, state, 11);
		}
	}

	@Override
	public void update() {
		if (!world.isRemote) {
			DrainInput();
		}
	}

	@Override
	public void markDirty() {
		super.markDirty();

	}

	@Override
	public String getName() {
		return "container.sakura.barrel_out";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public int getSizeInventory() {
		return 2;
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.inventory) {
			if (!itemstack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return inventory.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		ItemStack itemstack = ItemStackHelper.getAndSplit(inventory, index, count);

		if (!itemstack.isEmpty()) {
			this.markDirty();
		}

		return itemstack;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(inventory, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		inventory.set(index, stack);
		if (stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}
		this.markDirty();
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		if (this.world.getTileEntity(this.pos) != this) {
			return false;
		}
		return player.getDistanceSq(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		this.markDirty();
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		this.markDirty();
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return index == 0;
	}

	@Override
	public void clear() {
		inventory.clear();
	}

	public NonNullList<ItemStack> getInventory() {
		return inventory;
	}

	/**
	 * @return
	 */

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
	}

	@Override
	@Nullable
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
			return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(tank);
		}
		return super.getCapability(capability, facing);
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
		NBTTagCompound tankTag = this.tank.writeToNBT(new NBTTagCompound());
		ItemStackHelper.saveAllItems(cmp, this.inventory);
		cmp.setTag("Tank", tankTag);
	}

	public void readPacketNBT(NBTTagCompound cmp) {
		this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(cmp, this.inventory);
		this.tank.readFromNBT(cmp.getCompoundTag("Tank"));
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

	private void DrainInput() {
		ItemStack itemstack = this.inventory.get(0);
		ItemStack itemstack2 = this.inventory.get(1);
		if (this.getTank() != null) {
			FluidStack fluid = LiquidToItemRecipe.instance().getResultFluid(this.getTank().getFluid());
			if (fluid != null) {
				ItemStack itemstack1 = LiquidToItemRecipe.instance().getResultItemStack(this.getTank().getFluid(),
						itemstack);
				if (itemstack1.isEmpty())
					return;
				if (this.getTank().getFluid().amount < fluid.amount)
					return;
				boolean not_full = (itemstack2.getCount() + itemstack1.getCount() <= this.getInventoryStackLimit()
						&& itemstack2.getCount() + itemstack1.getCount() <= itemstack2.getMaxStackSize());
				if (!not_full)
					return;
				if (itemstack2.isEmpty()) {
					this.inventory.set(1, itemstack1.copy());
				} else if (itemstack2.getItem() == itemstack1.getItem()) {
					itemstack2.grow(itemstack1.getCount());
				}

				if (!itemstack.getItem().hasContainerItem(itemstack))
					itemstack.shrink(1);
				else
					this.inventory.set(0, new ItemStack(itemstack.getItem().getContainerItem()));

				this.getTank().drain(fluid, true);
			}
		}
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
