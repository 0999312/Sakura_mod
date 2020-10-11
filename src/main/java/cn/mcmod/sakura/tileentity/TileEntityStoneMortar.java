package cn.mcmod.sakura.tileentity;

import cn.mcmod.sakura.api.recipes.MortarRecipes;
import cn.mcmod.sakura.inventory.ContainerStoneMortar;
import cn.mcmod_mmf.mmlib.util.RecipesUtil;
import net.minecraft.block.state.IBlockState;
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

import java.util.ArrayList;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

public class TileEntityStoneMortar extends TileEntity implements ITickable, IInventory {
    private int processTimer = 0;
    private int maxprocessTimer = 200;

    public int getProcessTimer() {
        return processTimer;
    }
    @Override
    public void update() {
        if (this.getWorld().isRemote) {
            return;
        }
    	ItemStack input1 = this.inventorySlotItemStack.get(0);
        ItemStack input2 = this.inventorySlotItemStack.get(1);
        ItemStack input3 = this.inventorySlotItemStack.get(2);
        ItemStack input4 = this.inventorySlotItemStack.get(3);
        ItemStack output1 = this.inventorySlotItemStack.get(4);
        ItemStack output2 = this.inventorySlotItemStack.get(5);
  
        ArrayList<ItemStack> inventoryList = Lists.newArrayList();
        for (int i = 0; i < 4; i++) {
          if (!this.inventorySlotItemStack.get(i).isEmpty()) {
            inventoryList.add(this.inventorySlotItemStack.get(i).copy());
          }
        }

        ItemStack[] result = MortarRecipes.instance().getResult(inventoryList);
        if (result.length>0) {
        	if(RecipesUtil.getInstance().canIncrease(result[0], output1)){
	        	if(result.length>1){
	        		if(RecipesUtil.getInstance().canIncrease(result[1], output2))
	        			processTimer += 1;
	        		else processTimer = 0;
	       		}else processTimer += 1;	
        	}else processTimer = 0;
        }else processTimer = 0;

        if (processTimer >= maxprocessTimer) {
            processTimer = 0;
            
            if (output1.isEmpty()) {
                this.inventorySlotItemStack.set(4, result[0].copy());
            } else if (output1.getItem() == result[0].getItem()) {
            	output1.grow(result[0].getCount());
            }
            if(result.length>1){
	            if (output2.isEmpty()) {
	                this.inventorySlotItemStack.set(5, result[1].copy());
	            } else if (output2.getItem() == result[1].getItem()) {
	            	output2.grow(result[1].getCount());
	            }
            }
            
            input1.shrink(1);
            input2.shrink(1);
            input3.shrink(1);
            input4.shrink(1);
            
            markDirty();
        }
    }
    
    protected void refresh() {
        if (hasWorld() && !world.isRemote) {
            IBlockState state = world.getBlockState(pos);
            world.markAndNotifyBlock(pos, world.getChunkFromBlockCoords(pos), state, state, 11);
        }
    }

    @Override
    public void markDirty() {
        super.markDirty();
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
        return 6;
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
        return index < 4;
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