package cn.mcmod.sakura.tileentity;

import cn.mcmod.sakura.api.recipes.PotRecipes;
import cn.mcmod.sakura.block.BlockCampfirePot;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (this.isBurning()) {
            --this.burnTime;
        }
        //check can cook
        if (!this.world.isRemote) {
	        if (!isRecipes()) {
	            cookTime = 0;
	        } else {
        	  ItemStack itemstack = this.inventory.get(9);
              ItemStack result = getRecipesResult().getResultItemStack();
              	if(!itemstack.isEmpty()&&!itemstack.isItemEqual(result))  cookTime = 0;
              	else if (isBurning()) {
	                cookTime += 1;
	            }
	        }
	        if (cookTime >= maxCookTimer) {
	            cookTime = 0;
	            this.cooking();
	            flag1 = true;
	        }
	        if (flag != this.isBurning()) {
	           flag1 = true;
	           BlockCampfirePot.setState(this.isBurning(), this.world, this.pos);
	        }
	        if (flag1)
	        	this.markDirty();
      }
    }

    private void cooking() {
        ItemStack itemstack = this.inventory.get(9);
        ItemStack result = getRecipesResult().getResultItemStack();
        FluidStack fluidStack = getRecipesResult().getFluid();

        if (itemstack.isEmpty()) {
            this.inventory.set(9, result.copy());
        } else if (itemstack.isItemEqual(result)) {
            itemstack.grow(result.getCount());
        }
        
        //If pot is a recipe that uses a liquid, it consumes only that amount of liquid
        if (fluidStack != null && fluidStack.amount>0) {
            this.tank.drain(fluidStack, true);
        }
        
	    for(int i=0;i<9;i++){
	    	if(this.inventory.get(i).getCount()==1&&
	    	this.inventory.get(i).getItem().getContainerItem(this.inventory.get(i))!=null)
	    		this.inventory.set(i,
	    		this.inventory.get(i).getItem().getContainerItem(this.inventory.get(i)).copy());
	    	else this.decrStackSize(i, 1);
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

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int par1) {
        if (this.currentItemBurnTime == 0) 
            this.currentItemBurnTime = 200;
      
        return this.burnTime * par1 / this.currentItemBurnTime;
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
    public PotRecipes getRecipesResult() {
        if (this.getStackInSlot(0).isEmpty()) {
            return null;
        }
        
        for (PotRecipes recipes : PotRecipes.potRecipesList) {
            FluidStack tankStack = this.getTank().getFluid();
            ItemStack stack = recipes.getResult(this);
            if(recipes.getFluid()==null && !stack.isEmpty())
            	return recipes;
			if (tankStack == null && recipes.getFluid()!=null && recipes.getFluid().amount>0) 
			    return null;
			FluidStack fluidStack =(tankStack!=null)?recipes.getFluid():null;
			if ((fluidStack != null && recipes.getFluid().getFluid() == tankStack.getFluid()) && !stack.isEmpty()) 
			    return recipes;
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
        cmp.setInteger("BurnTime", this.burnTime);
        cmp.setInteger("CookTime", this.cookTime);
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