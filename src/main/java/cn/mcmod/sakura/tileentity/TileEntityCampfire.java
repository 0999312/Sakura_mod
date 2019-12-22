package cn.mcmod.sakura.tileentity;

import cn.mcmod.sakura.block.BlockCampfire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class TileEntityCampfire extends TileEntity implements ITickable {

    private ItemStackHandler inventory = new ItemStackHandler() {
        @Override
        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            return FurnaceRecipes.instance().getSmeltingResult(stack).getItem() instanceof ItemFood;
        }

        @Override
        protected void onContentsChanged(int slot) {
            TileEntityCampfire.this.markDirty();
        }

        @Override
        public int getSlotLimit(int slot) {
            return 16;
        }
    };
    
    private int burnTime;
    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
    private int cookTime;
    private boolean isFinishedCook;

    public ItemStackHandler getInventory() {
        return this.inventory;
    }

    public boolean isBurning() {
        return this.burnTime > 0;
    }

    public void setBurningTime(int tick) {
        this.burnTime = tick;
    }

    public int getBurningTime() {
        return this.burnTime;
    }

    public int getCookTime() {
        return this.cookTime;
    }

    public boolean isFinishedCook() {
        return this.isFinishedCook;
    }

    public ItemStack getItemBurning() {
		return this.inventory.getStackInSlot(0);
	}
    
    @Override
    public void update() {
        ItemStack cookstack;
        boolean flag = this.isBurning();

        boolean flag1 = false;

        if (!world.isRemote) {
            //check can cook
            if (this.isBurning() & this.isFinishedCook()) {
                cookstack = getItemBurning();

                ItemStack itemstack1 = FurnaceRecipes.instance().getSmeltingResult(cookstack);

                if (!cookstack.isEmpty()) {
                    if (!itemstack1.isEmpty()) {

                        if (this.isBurning() && this.cookTime >= 0) {
                            this.isFinishedCook = false;
                            flag1 = true;
                        }
                    }
                }
            }

            //cook finished
            if (this.isBurning() & !this.isFinishedCook()) {
                ++this.cookTime;

                cookstack = getItemBurning();

                ItemStack itemstack1 = FurnaceRecipes.instance().getSmeltingResult(cookstack);
                if (this.cookTime >= 700) {
                    if (!cookstack.isEmpty()) {
                        if (!itemstack1.isEmpty()) {
                            this.inventory.setStackInSlot(0, new ItemStack(itemstack1.getItem(), cookstack.getCount(),itemstack1.getMetadata()));

                            this.cookTime = 0;
                            this.isFinishedCook = true;
                            flag1 = true;
                        }
                    }

                } else {
                    if (cookstack.isEmpty()) {
                        this.cookTime = 0;
                        this.isFinishedCook = true;
                    }
                    if (itemstack1.isEmpty()) {
                        this.cookTime = 0;
                        this.isFinishedCook = true;
                    }
                }

            }


            if (this.isBurning()) {
                --this.burnTime;
                flag1 = true;
            }

            if (flag) {
                BlockCampfire.setState(this.isBurning(), this.world, this.pos);
            }

            if (flag != this.isBurning()) {
                flag1 = true;

                BlockCampfire.setState(this.isBurning(), this.world, this.pos);
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

	@SuppressWarnings("unchecked")
	@Override
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T) inventory : super.getCapability(capability, facing);
    }
    

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, @Nonnull IBlockState oldState, @Nonnull IBlockState newState) {
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
		cmp.setInteger("BurnTime", (short) this.burnTime);
        cmp.setInteger("CookTime", (short) this.cookTime);
        cmp.setBoolean("FinishCook", this.isFinishedCook);
        cmp.setTag("Inventory", inventory.serializeNBT());
	}

	public void readPacketNBT(NBTTagCompound cmp) {
        this.burnTime = cmp.getInteger("BurnTime");
        this.cookTime = cmp.getInteger("CookTime");
        this.isFinishedCook = cmp.getBoolean("FinishCook");
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
}