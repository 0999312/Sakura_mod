package cn.mcmod.sakura.tileentity;

import cn.mcmod.sakura.inventory.ContainerStoneMortar;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class TileEntityStoneMortar extends TileEntity implements ITickable, IInventory {

    private int processTimer = 0;

    private int maxprocessTimer = 200;

    private float progressOld;

    public int getProcessTimer() {
        return processTimer;
    }

    @Override
    public void update() {

        if (!isRecipes()) {
            processTimer = 0;
        } else {
            processTimer += 1;
        }

        updateAnimation();

        if (processTimer >= maxprocessTimer) {

            processTimer = 0;
            if (this.getWorld().isRemote) {

                return;
            }


            ItemStack processStack = this.inventorySlotItemStack.get(0);
            ItemStack itemstack = this.inventorySlotItemStack.get(1);
            ItemStack result = getRecipesResult().getResultItemStack();


            if (itemstack.isEmpty()) {
                this.inventorySlotItemStack.set(1, result.copy());
            } else if (itemstack.getItem() == result.getItem()) {
                itemstack.grow(result.getCount());
            }

            processStack.shrink(1);

        }
    }


    protected void updateAnimation() {
        this.progressOld = this.processTimer;
    }

    public float getProgress(float p_190585_1_) {
        return this.progressOld + (processTimer - this.progressOld) * p_190585_1_;
    }

    @Override
    public void markDirty() {
        super.markDirty();

    }


    public static ArrayList<MortarRecipes> mortarRecipesList = new ArrayList<MortarRecipes>();

    public static class MortarRecipes {

        public ItemStack resultItem = null;
        public ItemStack mainItem = null;
        public ArrayList<ItemStack> subItems = new ArrayList<ItemStack>();
        public boolean enchantment = false;
        private static final MortarRecipes MORTAR_RECIPES_BASE = new MortarRecipes();

        public MortarRecipes() {
        }


        public MortarRecipes(ItemStack result, ItemStack main) {
            this.setMortarRecipes(result, main);
        }

        public static MortarRecipes instance() {
            return MORTAR_RECIPES_BASE;
        }

        public void setMortarRecipes(ItemStack result, ItemStack main) {
            this.clear();
            mainItem = main;
            resultItem = result;
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
            for (int i = 1; i < 1; i++) {
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

        public static void addMortarRecipe(MortarRecipes recipes) {
            mortarRecipesList.add(recipes);
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
    protected MortarRecipes getRecipesResult() {
        if (this.getStackInSlot(0).isEmpty()) {
            return null;
        }
        for (MortarRecipes recipes : mortarRecipesList) {

            ItemStack stack = recipes.getResult(this);

            if (!stack.isEmpty()) {
                return recipes;
            }
        }
        return null;
    }


    protected NonNullList<ItemStack> inventorySlotItemStack =
            NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

    @Override
    public String getName() {
        return "container.sakura.stonemortar";
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
        for (ItemStack itemstack : this.inventorySlotItemStack) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return inventorySlotItemStack.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        ItemStack itemstack = ItemStackHelper.getAndSplit(inventorySlotItemStack, index, count);

        if (!itemstack.isEmpty()) {
            this.markDirty();
        }

        return itemstack;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(inventorySlotItemStack, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {

        inventorySlotItemStack.set(index, stack);
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
        inventorySlotItemStack.clear();
    }


    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.inventorySlotItemStack =
                NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.inventorySlotItemStack);

        this.maxprocessTimer = compound.getInteger("maxProcessTimer");
        this.processTimer = compound.getInteger("processTimer");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        ItemStackHelper.saveAllItems(compound, this.inventorySlotItemStack);

        compound.setInteger("maxProcessTimer", this.maxprocessTimer);
        compound.setInteger("processTimer", this.processTimer);
        return compound;
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public void handleUpdateTag(NBTTagCompound tag) {
        this.readFromNBT(tag);
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerStoneMortar(playerInventory, this);
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
}