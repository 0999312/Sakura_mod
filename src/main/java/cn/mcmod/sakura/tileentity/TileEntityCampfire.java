package cn.mcmod.sakura.tileentity;

import cn.mcmod.sakura.block.BlockCampfire;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class TileEntityCampfire extends TileEntity implements ITickable {

    private ItemStackHandler inventory = new ItemStackHandler(1) {

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
    private int currentItemBurnTime;
    private int cookTime;
    private boolean isFinishedCook;

    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.burnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.isFinishedCook = compound.getBoolean("FinishCook");
        inventory.deserializeNBT(compound.getCompoundTag("Inventory"));

    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("BurnTime", (short) this.burnTime);
        compound.setInteger("CookTime", (short) this.cookTime);
        compound.setBoolean("FinishCook", this.isFinishedCook);
        compound.setTag("Inventory", inventory.serializeNBT());


        return compound;
    }


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

    @Override
    public void update() {
        ItemStack cookstack;
        boolean flag = this.isBurning();

        boolean flag1 = false;

        if (!world.isRemote) {
            //check can cook
            if (this.isBurning() & this.isFinishedCook()) {
                cookstack = this.inventory.getStackInSlot(0);

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

                cookstack = this.inventory.getStackInSlot(0);

                ItemStack itemstack1 = FurnaceRecipes.instance().getSmeltingResult(cookstack);
                if (this.cookTime >= 700) {
                    if (!cookstack.isEmpty()) {
                        if (!itemstack1.isEmpty()) {
                            this.inventory.setStackInSlot(0, new ItemStack(itemstack1.getItem(), cookstack.getCount()));

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

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T) inventory : super.getCapability(capability, facing);
    }
}