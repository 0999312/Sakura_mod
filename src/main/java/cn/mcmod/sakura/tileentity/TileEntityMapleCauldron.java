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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.block.BlockMapleSpile;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.util.WorldUtil;

public class TileEntityMapleCauldron extends TileEntity implements ITickable, IInventory {

    public FluidTank tank = new FluidTank(5000) {
        @Override
        protected void onContentsChanged() {
            TileEntityMapleCauldron.this.refresh();
        }
    };

    private FluidStack liquidForRendering = null;
    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
    private int cookTime;
    private int mapleTime;

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
        return this.getTank().canDrainFluidType(new FluidStack(BlockLoader.MAPLE_SYRUP_FLUID, 500))
        		&&this.getTank().getFluidAmount()>=500
        		&&WorldUtil.getHeatStrength(getWorld(), getPos()) > 0;
    }

    public boolean canDraw() {
		if(getWorld().getBlockState(getPos().up()).getBlock() instanceof BlockMapleSpile){
			if(BlockMapleSpile.canWork(getWorld(), getPos().up(), getWorld().getBlockState(getPos().up())))
				return true;
		}
		return false;
	}
    
    public int getCookTime() {
        return this.cookTime;
    }
    
    public int getMapleTime() {
        return this.mapleTime;
    }

    protected void refresh() {
        if (hasWorld() && !world.isRemote) {
            IBlockState state = world.getBlockState(pos);
            world.markAndNotifyBlock(pos, world.getChunkFromBlockCoords(pos), state, state, 11);
        }
    }

    @Override
    public void update() {
        //check can cook
    	if (!this.world.isRemote) {
	    	this.drawing();
	    	this.cooking();
    	}
    }

    private void drawing() {
    	boolean flag = this.canDraw();
        boolean flag1 = false;
        
    	if (canDraw()) {
            mapleTime += getWorld().rand.nextInt(9)+1;
    	}
	    if (mapleTime >= 20) {
	    	mapleTime = 0;
	    	if(this.getTank().canFill())
	    		this.getTank().fill(new FluidStack(BlockLoader.MAPLE_SYRUP_FLUID, 10), true);
	        flag1 = true;
	    }
	    if (flag != this.canDraw()) {
	       flag1 = true;
	    }
	    if (flag1)
	    	this.markDirty();
	}
    
    private void cooking() {
    	boolean flag = this.isBurning();
        boolean flag1 = false;
        
    	if (isBurning()) {
            cookTime += 1;
    	}
	    if (cookTime >= 500) {
	        cookTime = 0;
            ItemStack itemstack = this.inventory.get(0);

            if (itemstack.isEmpty()) {
                this.inventory.set(0, new ItemStack(ItemLoader.MATERIAL, 8, 49).copy());
            } else {
            	itemstack.grow(8);
            }
            this.tank.drainInternal(500, true);
	        flag1 = true;
	    }
	    if (flag != this.isBurning()) {
	       flag1 = true;
	    }
	    if (flag1)
	    	this.markDirty();
	}

    @Override
    public void markDirty() {
        super.markDirty();

    }

    protected NonNullList<ItemStack> inventory =
            NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

    @Override
    public String getName() {
        return "container.sakura.maple_cauldron";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public int getSizeInventory() {
        return 1;
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
                return this.mapleTime;
            case 1:
                return this.cookTime;
            default:
                return 0;

        }
    }


    public void setField(int id, int value) {
        switch (id) {
            case 0:
                this.mapleTime = value;
                break;
            case 1:
                this.cookTime = value;
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
        cmp.setInteger("MapleTime", this.mapleTime);
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
        this.mapleTime = cmp.getInteger("MapleTime");
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