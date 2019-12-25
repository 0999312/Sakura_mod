package cn.mcmod.sakura.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockMagma;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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

import cn.mcmod.sakura.api.recipes.DistillationRecipes;
import cn.mcmod.sakura.api.recipes.LiquidToItemRecipe;

import java.util.ArrayList;
import java.util.List;

public class TileEntityDistillation extends TileEntity implements ITickable, IInventory {
    private static final String TAG_PROCESS = "processTimer";
    private static final String TAG_TOTAL = "maxTimer";
    public FluidTank tank = new FluidTank(3000) {
        @Override
        protected void onContentsChanged() {
            TileEntityDistillation.this.refresh();
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
            TileEntityDistillation.this.refresh();
        }
    };
    protected NonNullList<ItemStack> inventory =
            NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
    private int processTimer = 0;
    private int maxprocessTimer = 9000;

    public TileEntityDistillation() {
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
    	DrainInput();    	
        List<ItemStack> inputs = new ArrayList<>();
        inputs.add(inventory.get(0));
        inputs.add(inventory.get(1));
        inputs.add(inventory.get(2));
        List<DistillationRecipes> recipes = DistillationRecipes.getPossibleRecipes(tank.getFluid(), inputs);

        if (recipes.isEmpty()||getHeatStrength(getWorld(), getPos())<2) {
            processTimer = 0;
        } else {
            processTimer += 1;
            this.markDirty();
        }
        if (!world.isRemote) {
        	DistillationRecipes bestMatched = new DistillationRecipes(null, null, null, -1);
            for (DistillationRecipes br : recipes) {
                if (br.getAdditives().size() >= bestMatched.getAdditives().size())
                    if (resultTank.getFluid() == null ||
                            br.getOutput().getFluid().equals(
                                    resultTank.getFluid().getFluid()))
                        bestMatched = br;
            }

            if (bestMatched.getDuration() == -1) {
                processTimer = 0;
                return;
            }

            if (bestMatched.getDuration() != maxprocessTimer) {
                processTimer = 0;
                maxprocessTimer = bestMatched.getDuration();
            }
            if (processTimer >= maxprocessTimer) {
                processTimer = 0;

                FluidStack result = bestMatched.getOutput();
                FluidStack fluidStack = bestMatched.getInput();

                if (resultTank.getFluid() == null ||
                        result.getFluid().equals(resultTank.getFluid().getFluid())) {
                    this.tank.drain(fluidStack, true);
                    this.resultTank.fill(result, true);

                    if (bestMatched.getTransformed() != null) {
                        for (int i = 0; i < bestMatched.getTransformed().size(); i++) {
                            inventory.set(i, bestMatched.getTransformed().get(i));
                        }
                    }
                }

                this.markDirty();
            }
        }
    }

    @Override
    public void markDirty() {
        super.markDirty();

    }

    @Override
    public String getName() {
        return "container.sakura.barrel_distillation";
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
        cmp.setInteger(TAG_PROCESS, processTimer);
        cmp.setInteger(TAG_TOTAL, maxprocessTimer);
    }

    public void readPacketNBT(NBTTagCompound cmp) {
        this.inventory =
                NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(cmp, this.inventory);

        processTimer = cmp.getInteger(TAG_PROCESS);
        maxprocessTimer = cmp.getInteger(TAG_TOTAL);

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
    
    private int getHeatStrength(World par1World, BlockPos pos)
    {
        for (int i = 1; i < 5; i++)
        {
            Block block = par1World.getBlockState(pos.down(i)).getBlock();
            if (block instanceof BlockMagma||block instanceof BlockFire || block == Blocks.LAVA || block == Blocks.FLOWING_LAVA)
            {
                return i <= 2 ? 2 : 1;
            }
        }
        return 0;
    }
    
    private void DrainInput() {
       ItemStack itemstack = this.inventory.get(3);
       if(getRecipesResult()!=null){
    	   
    	   ItemStack itemstack1 = getRecipesResult().getResultItemStack();
           if(itemstack1!=null){
        	   ItemStack itemstack2 = this.inventory.get(4);
               boolean not_full=(itemstack2.getCount()<itemstack2.getMaxStackSize()
                   	 &&itemstack2.getCount()+itemstack1.getCount()<=itemstack2.getMaxStackSize());
               if(!(itemstack.isEmpty())&&!(itemstack1.isEmpty())
               &&not_full&&(itemstack2.isEmpty()||itemstack2.getItem() == itemstack1.getItem())){ 
            	   if (getRecipesResult().getResultFluid() != null && getRecipesResult().getResultFluid().amount>0) {
            	   if(resultTank.getFluidAmount()>getRecipesResult().getResultFluid().amount){
        		        if (itemstack2.isEmpty())
        		        {
        		            this.inventory.set(4, itemstack1.copy());
        		        }
        		        else if (itemstack2.getItem() == itemstack1.getItem())
        		        {
        		            itemstack2.grow(itemstack1.getCount());
        		        }
        		
        		        if(!itemstack.getItem().hasContainerItem(itemstack))
        		        	itemstack.shrink(1);
        		        else  this.inventory.set(3, new ItemStack(itemstack.getItem().getContainerItem()));
        		        resultTank.drain(getRecipesResult().getResultFluid().amount, true);
        	        }
           		}
           }
           }
       }
       
	}
    private LiquidToItemRecipe getRecipesResult() {
        if (this.getStackInSlot(3).isEmpty()) {
            return null;
        }
        
        for (LiquidToItemRecipe recipes : LiquidToItemRecipe.RecipesList) {
            if (this.getResultTank().getFluid() == null && recipes.getResultFluid().amount>0) 
                return null;
            FluidStack tankStack = this.getResultTank().getFluid();
            ItemStack stack = recipes.getResult(this,this.resultTank.getFluid(), 3);
            if(recipes.getResultFluid().amount<=0 && tankStack==null && !stack.isEmpty())
            	return recipes;
			FluidStack fluidStack =(tankStack!=null)?recipes.getResultFluid():null;
            if ((fluidStack != null && recipes.getResultFluid().getFluid() == tankStack.getFluid()) && !stack.isEmpty()) 
                return recipes;
        }
        return null;
    }
}
