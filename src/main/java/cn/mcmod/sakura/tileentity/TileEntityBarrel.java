package cn.mcmod.sakura.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
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
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;

public class TileEntityBarrel extends TileEntity implements ITickable, IInventory {
    private int processTimer = 0;
    private int maxprocessTimer = 9000;
    private float progressOld;

    public int getProcessTimer() {
        return processTimer;
    }

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

    //This is a tank that accumulates liquid when the process is over
    public FluidTank resultTank = new FluidTank(3000) {
        @Override
        protected void onContentsChanged() {
            TileEntityBarrel.this.refresh();
        }
    };

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
        if (!isRecipes()) {
            processTimer = 0;
        } else {
            processTimer += 1;
            this.markDirty();
        }
        if (!world.isRemote) {
            if (processTimer >= maxprocessTimer) {
                processTimer = 0;
                if (this.getWorld().isRemote) {
                    return;
                }

                FluidStack result = getRecipesResult().getResultFinishedFluid();
                FluidStack fluidStack = getRecipesResult().getResultFluid();

                if (fluidStack != null && fluidStack.amount > 0 && result.getFluid() == this.resultTank.getFluid().getFluid()) {
                    this.tank.drain(fluidStack, true);

                    this.resultTank.fill(result, true);
                }

                for (int i = 0; i < 3; i++) {
                    if (this.inventory.get(i).getCount() == 1 &&
                            this.inventory.get(i).getItem().getContainerItem(this.inventory.get(i)) != null)
                        this.inventory.set(i,
                                this.inventory.get(i).getItem().getContainerItem(this.inventory.get(i)).copy());
                    else this.decrStackSize(i, 1);
                }

                this.markDirty();
            }
        }
    }

    @Override
    public void markDirty() {
        super.markDirty();

    }

    protected NonNullList<ItemStack> inventory =
            NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);


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

        } else {

            return player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;

        }
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
        return true;
    }

    public int getField(int id) {

        switch (id) {

            case 0:
                return this.processTimer;
            case 1:
                return this.maxprocessTimer;
            default:
                return 0;

        }
    }


    public void setField(int id, int value) {
        switch (id) {
            case 0:
                this.processTimer = value;
                break;
            case 1:
                this.maxprocessTimer = value;
                break;
        }
    }

    public int getFieldCount() {

        return 2;

    }

    @Override
    public void clear() {
        inventory.clear();
    }

    public NonNullList<ItemStack> getInventory() {
        return inventory;
    }

    public static ArrayList<BarrelRecipes> potRecipesList = new ArrayList<BarrelRecipes>();


    public static class BarrelRecipes {

        public ItemStack mainItem = ItemStack.EMPTY;
        public FluidStack fluid = null;
        public FluidStack resultFluid = null;
        public ArrayList<Object> subItems = new ArrayList<Object>();
        public boolean enchantment = false;
        private static final BarrelRecipes BARREL_RECIPES_BASE = new BarrelRecipes();

        public BarrelRecipes() {
        }

        public BarrelRecipes(FluidStack result, ItemStack main, FluidStack fluidStack) {
            this.setBarrelRecipes(result, main, new Object[]{ItemStack.EMPTY}, fluidStack);
        }

        public BarrelRecipes(FluidStack result, ItemStack main, Object[] subList, FluidStack fluidStack) {
            this.setBarrelRecipes(result, main, subList, fluidStack);

        }

        public BarrelRecipes(FluidStack result, String main, FluidStack fluidStack) {
            this.setBarrelRecipes(result, main, new Object[]{ItemStack.EMPTY}, fluidStack);

        }

        public BarrelRecipes(FluidStack result, String main, Object[] subList, FluidStack fluidStack) {
            this.setBarrelRecipes(result, main, subList, fluidStack);

        }

        //still WIP
       /* public BarrelRecipes(ItemStack result, String main, String[] subList, FluidStack fluidStack) {
            this.setBarrelRecipes(result, main, subList, fluidStack);

        }*/

        public static BarrelRecipes instance() {
            return BARREL_RECIPES_BASE;
        }

        public void setBarrelRecipes(FluidStack result, ItemStack main, Object[] subList, FluidStack fluidStack) {
            this.clear();
            mainItem = main.copy();
            for (Object o : subList) {
                if (o instanceof ItemStack || o instanceof String)
                    subItems.add(o);
                else throw new IllegalArgumentException("Not a itemStack or od name");
            }
            resultFluid = result.copy();
            fluid = fluidStack.copy();
        }

        public void setBarrelRecipes(FluidStack result, String mainOreName, Object[] subList, FluidStack fluidStack) {
            if (!OreDictionary.getOres(mainOreName).isEmpty()) {
                for (int i2 = 0; i2 < OreDictionary.getOres(mainOreName).size(); i2++) {
                    this.clear();
                    mainItem = OreDictionary.getOres(mainOreName).get(i2).copy();
                    for (Object o : subList) {
                        if (o instanceof ItemStack || o instanceof String)
                            subItems.add(o);
                        else throw new IllegalArgumentException("Not a itemStack or od name");
                    }

                    resultFluid = result.copy();
                    fluid = fluidStack.copy();
                }
            } else throw new IllegalArgumentException("Invalid Main Ore Dictionary");
        }

        /**
         * 初期化
         */
        public void clear() {
            resultFluid = null;
            mainItem = ItemStack.EMPTY;
            fluid = null;
            subItems = new ArrayList<Object>();
        }

        public FluidStack getResultFinishedFluid() {
            return resultFluid.copy();
        }

        public FluidStack getResultFluid() {
            return fluid.copy();
        }

        public FluidStack getResultFluid(FluidStack fluidStack) {
            if (fluid.amount <= 0)
                return fluidStack;
            else if (fluidStack.isFluidEqual(fluid)) {
                return fluidStack;
            } else {
                return null;
            }
        }

        public FluidStack getResult(IInventory inventory) {

            FluidStack retStack = null;
            if (!ItemStack.areItemsEqual(mainItem, inventory.getStackInSlot(0))) {
                return retStack;
            }

            if (this.enchantment) {
                if (EnchantmentHelper.getEnchantments(inventory.getStackInSlot(0)).size() > 0) {
                    return retStack;
                }
            }

            ArrayList<ItemStack> inventoryList = new ArrayList<ItemStack>();
            for (int i = 1; i < 2; i++) {
                if (!inventory.getStackInSlot(i).isEmpty()) {
                    inventoryList.add(inventory.getStackInSlot(i).copy());
                }
            }

            if (subItems.size() == 1) {
                for (Object obj1 : subItems) {
                    if (obj1 instanceof ItemStack) {
                        ItemStack stack1 = (ItemStack) obj1;
                        if (stack1.isEmpty()) {
                            return resultFluid.copy();
                        }
                    }
                }
            }

            if (inventoryList.size() != subItems.size()) {
                return retStack;
            }

            boolean flg1 = true;
            for (Object obj1 : subItems) {

                boolean flg2 = false;
                for (int i = 0; i < inventoryList.size(); i++) {
                    if (obj1 instanceof ItemStack) {
                        ItemStack stack1 = (ItemStack) obj1;
                        if (ItemStack.areItemsEqual(stack1, inventoryList.get(i))) {
                            inventoryList.remove(i);
                            flg2 = true;
                            break;
                        }
                    } else if (obj1 instanceof String) {
                        String dict = (String) obj1;
                        ItemStack result = inventoryList.get(i);
                        NonNullList<ItemStack> ore = OreDictionary.getOres(dict);
                        if (ore.isEmpty()) return retStack;
                        if (OreDictionary.containsMatch(true, ore, result)) {
                            inventoryList.remove(i);
                            flg2 = true;
                            break;
                        }
                    }
                }
                if (!flg2) {
                    flg1 = false;
                    break;
                }
            }

            if (!flg1) {
                return retStack;
            }

            return resultFluid.copy();

        }

        public static void addBarrelRecipe(BarrelRecipes recipes) {
            potRecipesList.add(recipes);
        }


        /**
         * Compares two itemstacks to ensure that they are the same. This checks both the item and the metadata of the item.
         */
        private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
            return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
        }

    }

    /**
     * @return
     */
    protected boolean isRecipes() {
        if (getRecipesResult() == null) {
            return false;
        }
        return true;
    }

    /**
     * @return
     */
    protected BarrelRecipes getRecipesResult() {
        if (this.getStackInSlot(0).isEmpty()) {
            return null;
        }

        for (BarrelRecipes recipes : potRecipesList) {
            if (this.getTank().getFluid() == null && recipes.getResultFluid().amount > 0)
                return null;
            FluidStack tankStack = this.getTank().getFluid();
            FluidStack stack = recipes.getResult(this);
            if (recipes.getResultFluid().amount <= 0 && tankStack == null && stack.getFluid() != null)
                return recipes;
            else {

                FluidStack fluidStack = (tankStack != null) ? recipes.getResultFluid() : null;
                if ((fluidStack != null || recipes.getResultFluid() != tankStack) && stack.getFluid() != null)
                    return recipes;
            }
        }
        return null;
    }

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
        NBTTagCompound tankTag = this.tank.writeToNBT(new NBTTagCompound());
        ItemStackHelper.saveAllItems(cmp, this.inventory);

        cmp.setTag("Tank", tankTag);
        NBTTagCompound resultTankTag = this.resultTank.writeToNBT(new NBTTagCompound());
        cmp.setTag("ResultTank", resultTankTag);
    }

    public void readPacketNBT(NBTTagCompound cmp) {
        this.inventory =
                NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(cmp, this.inventory);

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

}
