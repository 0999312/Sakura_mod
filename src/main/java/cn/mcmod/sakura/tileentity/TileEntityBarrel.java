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

import cn.mcmod.sakura.api.recipes.BarrelRecipes;
import cn.mcmod.sakura.api.recipes.LiquidToItemRecipe;

public class TileEntityBarrel extends TileEntity implements ITickable, IInventory {
	private static final String TAG_PROCESS = "processTimer";
	public FluidTank tank = new FluidTank(3000) {
		@Override
		protected void onContentsChanged() {
			TileEntityBarrel.this.refresh();
		}

		@Override
		public boolean canFillFluidType(FluidStack fluid) {
			if (!canFill() || fluid.getFluid().isGaseous(fluid) || fluid.getFluid().isLighterThanAir()) {
				return false;
			}
			return fluid.getFluid().getTemperature(fluid) < 500;
		}
	};
	// This is a tank that accumulates liquid when the process is over
	public FluidTank resultTank = new FluidTank(3000) {
		@Override
		protected void onContentsChanged() {
			TileEntityBarrel.this.refresh();
		}
	};
	protected NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(),
			ItemStack.EMPTY);
	private int processTimer = 0;

	public TileEntityBarrel() {
	}

	public int getProcessTimer() {
		return processTimer;
	}

	public FluidTank getTank() {
		return this.tank;
	}

	public FluidTank getResultTank() {
		return this.resultTank;
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
			if (this.getTank() != null) {
				ItemStack[] iteminput = new ItemStack[] { this.inventory.get(0), this.inventory.get(1),
						this.inventory.get(2) };
				if (isRecipes(this.getTank().getFluid(), iteminput)) {
					FluidStack result = BarrelRecipes.getInstance().getResultFluidStack(this.getTank().getFluid(),
							iteminput);
					FluidStack fluidStack = BarrelRecipes.getInstance().getFluidStack(this.getTank().getFluid());
					if ((resultTank.getFluid() == null || resultTank.canFill() && result.getFluid().equals(resultTank.getFluid().getFluid()))) {
						processTimer += 1;
					} else
						processTimer = 0;

					if (processTimer >= 1000) {
						processTimer = 0;
						this.resultTank.fill(result, true);

						// If pot is a recipe that uses a liquid, it consumes
						// only that amount of liquid
						if (fluidStack != null && fluidStack.amount > 0) {
							this.tank.drain(fluidStack, true);
						}

						for (int i = 0; i < 3; i++) {
							if (this.inventory.get(i).getCount() == 1
									&& this.inventory.get(i).getItem().getContainerItem(this.inventory.get(i)) != null)
								this.inventory.set(i,
										this.inventory.get(i).getItem().getContainerItem(this.inventory.get(i)).copy());
							else
								this.decrStackSize(i, 1);
						}
						this.markDirty();
					}
				}
			}
		}
	}

	protected boolean isRecipes(FluidStack fluid, ItemStack[] items) {
		FluidStack result = BarrelRecipes.getInstance().getResultFluidStack(fluid, items);
		if (result != null){
			return true;
		}
		return false;
	}

	@Override
	public void markDirty() {
		super.markDirty();

	}

	@Override
	public String getName() {
		return "container.sakura.barrel";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public int getSizeInventory() {
		return 5;
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
		return index<3;
	}

	public int getField(int id) {
		switch (id) {
		case 0:
			return this.processTimer;
		default:
			return 0;
		}
	}

	public void setField(int id, int value) {
		switch (id) {
		case 0:
			this.processTimer = value;
			break;
		}
	}

	public int getFieldCount() {
		return 1;
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
		NBTTagCompound resultTankTag = this.resultTank.writeToNBT(new NBTTagCompound());
		cmp.setTag("ResultTank", resultTankTag);
		cmp.setInteger(TAG_PROCESS, processTimer);
	}

	public void readPacketNBT(NBTTagCompound cmp) {
		this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(cmp, this.inventory);

		processTimer = cmp.getInteger(TAG_PROCESS);

		this.tank.readFromNBT(cmp.getCompoundTag("Tank"));
		this.resultTank.readFromNBT(cmp.getCompoundTag("ResultTank"));
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
		ItemStack itemstack = this.inventory.get(3);
		ItemStack itemstack2 = this.inventory.get(4);
		if (this.getResultTank() != null) {
			FluidStack fluid = LiquidToItemRecipe.instance().getResultFluid(this.getResultTank().getFluid());
			if (fluid != null) {
				ItemStack itemstack1 = LiquidToItemRecipe.instance().getResultItemStack(this.getResultTank().getFluid(),
						itemstack);
				if (itemstack1.isEmpty())
					return;
				if (this.getResultTank().getFluid().amount < fluid.amount)
					return;
				boolean not_full = (itemstack2.getCount() + itemstack1.getCount() <= this.getInventoryStackLimit()
						&& itemstack2.getCount() + itemstack1.getCount() <= itemstack2.getMaxStackSize());
				if (!not_full)
					return;
				if (itemstack2.isEmpty()) {
					this.inventory.set(4, itemstack1.copy());
				} else if (itemstack2.getItem() == itemstack1.getItem()) {
					itemstack2.grow(itemstack1.getCount());
				}

				if (!itemstack.getItem().hasContainerItem(itemstack))
					itemstack.shrink(1);
				else
					this.inventory.set(3, new ItemStack(itemstack.getItem().getContainerItem()));

				this.getResultTank().drain(fluid, true);
			}
		}
	}

}
