package cn.mcmod.sakura.tileentity;

import cn.mcmod.sakura.block.BlockCampfirePot;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.CrashReport;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;

public class TileEntityCampfirePot extends TileEntity implements ITickable, IInventory {


    public FluidTank tank = new FluidTank(2000) {
        @Override
        protected void onContentsChanged() {
            TileEntityCampfirePot.this.refresh();
        }
    };

    private FluidStack liquidForRendering = null;

    private int burnTime;
    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
    private int currentItemBurnTime;
    private int cookTime;
    private int maxCookTimer = 200;

    @SideOnly(Side.CLIENT)
    public FluidTank getTank() {
        return this.tank;
    }

    //Render only
    @SideOnly(Side.CLIENT)
    public FluidStack getFluidForRendering(float partialTicks) {
        final FluidStack actual = tank.getFluid();

        int actualAmount;

        if (actual != null && !actual.equals(liquidForRendering)) {
            liquidForRendering = new FluidStack(actual, 0);
        }

        if (liquidForRendering == null) {
            return null;
        }

        actualAmount = actual == null ? 0 : actual.amount;

        int delta = actualAmount - liquidForRendering.amount;

        if (Math.abs(delta) <= 40) {
            liquidForRendering.amount = actualAmount;
        } else {
            int i = (int) (delta * partialTicks * 0.1);

            if (i == 0) {
                i = delta > 0 ? 1 : -1;
            }

            liquidForRendering.amount += i;
        }

        if (liquidForRendering.amount == 0) {

            liquidForRendering = null;

        }
        return liquidForRendering;
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


    protected void refresh() {
        if (hasWorld() && !world.isRemote) {

            IBlockState state = world.getBlockState(pos);

            world.markAndNotifyBlock(pos, world.getChunkFromBlockCoords(pos), state, state, 11);

        }
    }

    @Override
    public void update() {
        ItemStack cookstack;
        boolean flag = this.isBurning();
        boolean flag1 = false;
        //check can cook
        if (!isRecipes()) {
            cookTime = 0;
        } else {
            if (isBurning()) {
                cookTime += 1;
            }
        }

        if (!world.isRemote) {
            if (this.isBurning()) {
                --this.burnTime;
                flag1 = true;
            }

            if (cookTime >= maxCookTimer) {
                cookTime = 0;
                ItemStack processStack = this.inventory.get(0);
                ItemStack itemstack = this.inventory.get(9);
                ItemStack result = getRecipesResult().getResultItemStack();
                FluidStack fluidStack = getRecipesResult().getResultFluid();

                if (itemstack.isEmpty()) {
                    this.inventory.set(9, result.copy());
                } else if (itemstack.getItem() == result.getItem()) {
                    itemstack.grow(result.getCount());
                }
                
                //If pot is a recipe that uses a liquid, it consumes only that amount of liquid
                if (fluidStack != null && fluidStack.amount>0) {
                    this.tank.drain(fluidStack, true);
                }

                processStack.shrink(1);
                this.decrStackSize(1, 1);
                this.decrStackSize(2, 1);
                this.decrStackSize(3, 1);
                this.decrStackSize(4, 1);
                this.decrStackSize(5, 1);
                this.decrStackSize(6, 1);
                this.decrStackSize(7, 1);
                this.decrStackSize(8, 1);

            }

            if (flag != this.isBurning()) {
                flag1 = true;

                BlockCampfirePot.setState(this.isBurning(), this.world, this.pos);
            }
        }

        if (flag1) {
            this.markDirty();
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
        return "container.sakura.campfirepot";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public int getSizeInventory() {
        return 10;
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
                return this.burnTime;
            case 1:
                return this.cookTime;
            case 2:
                return this.maxCookTimer;
            default:
                return 0;

        }
    }


    public void setField(int id, int value) {
        switch (id) {
            case 0:
                this.burnTime = value;
                break;
            case 1:
                this.cookTime = value;
                break;
            case 2:
                this.maxCookTimer = value;
                break;
        }
    }

    public int getFieldCount() {

        return 3;

    }

    @Override
    public void clear() {
        inventory.clear();
    }

    public NonNullList<ItemStack> getInventory() {
        return inventory;
    }

    public static ArrayList<PotRecipes> potRecipesList = new ArrayList<PotRecipes>();

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int par1) {
        if (this.currentItemBurnTime == 0) 
            this.currentItemBurnTime = 200;
      
        return this.burnTime * par1 / this.currentItemBurnTime;
    }

    public static class PotRecipes {

        public ItemStack resultItem = ItemStack.EMPTY;
        public ItemStack mainItem = ItemStack.EMPTY;
        public FluidStack fluid = null;
        public ArrayList<Object> subItems = new ArrayList<Object>();
        public boolean enchantment = false;
        private static final PotRecipes POT_RECIPES_BASE = new PotRecipes();

        public PotRecipes() {
        }

        public PotRecipes(ItemStack result, ItemStack main, FluidStack fluidStack) {
            this.setPotRecipes(result, main, new Object[]{ItemStack.EMPTY}, fluidStack);
        }

        public PotRecipes(ItemStack result, ItemStack main, Object[] subList, FluidStack fluidStack) {
            this.setPotRecipes(result, main, subList, fluidStack);

        }

        public PotRecipes(ItemStack result, String main, FluidStack fluidStack) {
            this.setPotRecipes(result, main, new Object[]{ItemStack.EMPTY}, fluidStack);

        }

        public PotRecipes(ItemStack result, String main, Object[] subList, FluidStack fluidStack) {
            this.setPotRecipes(result, main, subList, fluidStack);

        }

        //still WIP
       /* public PotRecipes(ItemStack result, String main, String[] subList, FluidStack fluidStack) {
            this.setPotRecipes(result, main, subList, fluidStack);

        }*/

        public static PotRecipes instance() {
            return POT_RECIPES_BASE;
        }

        public void setPotRecipes(ItemStack result, ItemStack main, Object[] subList, FluidStack fluidStack) {
            this.clear();
            mainItem = main.copy();
        	for (Object o : subList) {
    			if(o instanceof ItemStack||o instanceof String)
    				subItems.add(o);
    			else throw new IllegalArgumentException("Not a itemStack or od name");
            }
            resultItem = result.copy();
            fluid = fluidStack.copy();
        }

        public void setPotRecipes(ItemStack result, String mainOreName, Object[] subList, FluidStack fluidStack) {
            if(!OreDictionary.getOres(mainOreName).isEmpty()){
        	for (int i2 = 0; i2 < OreDictionary.getOres(mainOreName).size(); i2++) {
                this.clear();
                mainItem = OreDictionary.getOres(mainOreName).get(i2).copy();
                	for (Object o : subList) {
            			if(o instanceof ItemStack||o instanceof String)
            				subItems.add(o);
            			else throw new IllegalArgumentException("Not a itemStack or od name");
                    }

                resultItem = result.copy();
                fluid = fluidStack.copy();
            }
            }else throw new IllegalArgumentException("Invalid Main Ore Dictionary");
        }

        /**
         * 初期化
         */
        public void clear() {
            resultItem = ItemStack.EMPTY;
            mainItem = ItemStack.EMPTY;
            fluid = null;
            subItems = new ArrayList<Object>();
        }

        public ItemStack getResultItemStack() {
            return resultItem.copy();
        }

        public FluidStack getResultFluid() {
            return fluid.copy();
        }

        public FluidStack getResultFluid(FluidStack fluidStack) {
        	if(fluid.amount<=0) 
        		return fluidStack;
        	else
            if (fluidStack.isFluidEqual(fluid)) {
                return fluidStack;
            } else {
                return null;
            }
        }

        public ItemStack getResult(IInventory inventory) {

            ItemStack retStack = ItemStack.EMPTY;
            if (!ItemStack.areItemsEqual(mainItem, inventory.getStackInSlot(0))) {
                return retStack;
            }

            if (this.enchantment) {
                if (EnchantmentHelper.getEnchantments(inventory.getStackInSlot(0)).size() > 0) {
                    return retStack;
                }
            }

            ArrayList<ItemStack> inventoryList = new ArrayList<ItemStack>();
            for (int i = 1; i < 9; i++) {
                if (!inventory.getStackInSlot(i).isEmpty()) {
                    inventoryList.add(inventory.getStackInSlot(i).copy());
                }
            }

            if (inventoryList.size() != subItems.size()) {
                return retStack;
            }

            boolean flg1 = true;
            for (Object obj1 : subItems) {

                boolean flg2 = false;
                for (int i = 0; i < inventoryList.size(); i++) {
                	if(obj1 instanceof ItemStack){
                		ItemStack stack1 = (ItemStack) obj1;
                    if (ItemStack.areItemsEqual(stack1, inventoryList.get(i))) {
                        inventoryList.remove(i);
                        flg2 = true;
                        break;
                    }
                    }else if(obj1 instanceof String){
                    	String dict = (String) obj1;
                    	ItemStack result = inventoryList.get(i);
                    	NonNullList<ItemStack> ore =OreDictionary.getOres(dict);
                    	if(ore.isEmpty())return retStack;
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

            return resultItem.copy();

        }

        public static void addPotRecipe(PotRecipes recipes) {
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
    protected PotRecipes getRecipesResult() {
        if (this.getStackInSlot(0).isEmpty()) {
            return null;
        }

        for (PotRecipes recipes : potRecipesList) {
            if (this.getTank().getFluid() == null && recipes.getResultFluid().amount>0) 
                return null;
            FluidStack tankStack = this.getTank().getFluid();
            ItemStack stack = recipes.getResult(this);
            if(recipes.getResultFluid().amount<=0 && tankStack==null && !stack.isEmpty())
            	return recipes;
            else{

            FluidStack fluidStack =(tankStack!=null)?recipes.getResultFluid():null;
            if ((fluidStack != null || recipes.getResultFluid() != tankStack) && !stack.isEmpty()) 
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
        ItemStackHelper.saveAllItems(cmp, this.inventory);
        cmp.setInteger("BurnTime", (short) this.burnTime);
        cmp.setInteger("CookTime", (short) this.cookTime);

        NBTTagCompound tankTag = this.tank.writeToNBT(new NBTTagCompound());

        cmp.setTag("Tank", tankTag);

        if (tank.getFluid() != null) {
            liquidForRendering = tank.getFluid().copy();
        }
    }

    public void readPacketNBT(NBTTagCompound cmp) {
        this.inventory =
                NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(cmp, this.inventory);

        this.burnTime = cmp.getInteger("BurnTime");
        this.cookTime = cmp.getInteger("CookTime");

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

}