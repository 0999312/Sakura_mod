package cn.mcmod.sakura.tileentity;

import cn.mcmod.sakura.block.BlockCampfirePot;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class TileEntityCampfirePot extends TileEntity implements ITickable, IInventory {


    private int burnTime;
    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
    private int currentItemBurnTime;
    private int cookTime;
    private int maxCookTimer = 200;

    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.inventory =
                NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.inventory);

        this.burnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        ItemStackHelper.saveAllItems(compound, this.inventory);

        compound.setInteger("BurnTime", (short) this.burnTime);
        compound.setInteger("CookTime", (short) this.cookTime);

        return compound;
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

    @Override
    public void update() {
        ItemStack cookstack;
        boolean flag = this.isBurning();

        boolean flag1 = false;


        //check can cook
        if (!isRecipes()) {
            cookTime = 0;
        } else {
            cookTime += 1;
        }

        if (!world.isRemote) {

            if (this.isBurning()) {
                --this.burnTime;
                flag1 = true;
            }

            if (cookTime >= maxCookTimer) {

                cookTime = 0;


                ItemStack processStack = this.inventory.get(0);
                ItemStack itemstack = this.inventory.get(5);
                ItemStack result = getRecipesResult().getResultItemStack();


                if (itemstack.isEmpty()) {
                    this.inventory.set(1, result.copy());
                } else if (itemstack.getItem() == result.getItem()) {
                    itemstack.grow(result.getCount());
                }

                processStack.shrink(1);

                this.decrStackSize(1, 1);

                this.decrStackSize(2, 1);

                this.decrStackSize(3, 1);

                this.decrStackSize(4, 1);

            }

            if (flag) {
                BlockCampfirePot.setState(this.isBurning(), this.world, this.pos);
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
        return 6;
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

    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public void handleUpdateTag(NBTTagCompound tag) {
        this.readFromNBT(tag);
    }

    @Override
    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 0, this.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public void onDataPacket(net.minecraft.network.NetworkManager net, net.minecraft.network.play.server.SPacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.getNbtCompound());
    }

    public static ArrayList<PotRecipes> potRecipesList = new ArrayList<PotRecipes>();

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int par1) {

        if (this.currentItemBurnTime == 0) {

            this.currentItemBurnTime = 200;

        }


        return this.burnTime * par1 / this.currentItemBurnTime;

    }

    public static class PotRecipes {

        public ItemStack resultItem = null;
        public ItemStack mainItem = null;
        public ArrayList<ItemStack> subItems = new ArrayList<ItemStack>();
        public boolean enchantment = false;
        private static final PotRecipes MORTAR_RECIPES_BASE = new PotRecipes();

        public PotRecipes() {
        }


        public PotRecipes(ItemStack result, ItemStack main) {
            this.setPotRecipes(result, main, null, null, null, null);
        }

        public PotRecipes(ItemStack result, ItemStack main, ItemStack main2) {
            this.setPotRecipes(result, main, main2, null, null, null);
        }

        public PotRecipes(ItemStack result, ItemStack main, ItemStack main2, ItemStack main3) {
            this.setPotRecipes(result, main, main2, main3, null, null);
        }

        public PotRecipes(ItemStack result, ItemStack main, ItemStack main2, ItemStack main3, ItemStack main4) {
            this.setPotRecipes(result, main, main2, main3, main4, null);
        }

        public PotRecipes(ItemStack result, ItemStack main, ItemStack main2, ItemStack main3, ItemStack main4, ItemStack main5) {
            this.setPotRecipes(result, main, main2, main3, main4, main5);
        }

        public static PotRecipes instance() {
            return MORTAR_RECIPES_BASE;
        }

        public void setPotRecipes(ItemStack result, ItemStack main, ItemStack main2, ItemStack main3, ItemStack main4, ItemStack main5) {
            this.clear();
            mainItem = main;
            resultItem = result;
            if (!main2.isEmpty()) {

                subItems.add(main2);

            }

            if (!main3.isEmpty()) {

                subItems.add(main3);

            }

            if (!main4.isEmpty()) {

                subItems.add(main4);

            }
            if (!main5.isEmpty()) {

                subItems.add(main4);

            }
        }

        /**
         * 初期化
         */
        public void clear() {
            resultItem = ItemStack.EMPTY;
            mainItem = ItemStack.EMPTY;
            subItems = new ArrayList<ItemStack>();
        }

        public ItemStack getResultItemStack() {
            return resultItem.copy();
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
            for (int i = 1; i < 5; i++) {
                if (!inventory.getStackInSlot(i).isEmpty()) {
                    inventoryList.add(inventory.getStackInSlot(i).copy());
                }
            }

            if (inventoryList.size() != subItems.size()) {
                return retStack;
            }

            boolean flg1 = true;
            for (ItemStack stack1 : subItems) {

                boolean flg2 = false;
                for (int i = 0; i < inventoryList.size(); i++) {
                    if (ItemStack.areItemsEqual(stack1, inventoryList.get(i))) {
                        inventoryList.remove(i);
                        flg2 = true;
                        break;
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

        public static void addMortarRecipe(PotRecipes recipes) {
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

            ItemStack stack = recipes.getResult(this);

            if (!stack.isEmpty()) {
                return recipes;
            }
        }
        return null;
    }
}