package cn.mcmod.sakura.block;

import cn.mcmod.sakura.tileentity.TileEntityWeb;
import cn.mcmod_mmf.mmlib.block.BlockFacing;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class BlockStrawWeb extends BlockFacing implements ITileEntityProvider  {
	protected static final AxisAlignedBB CARPET_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
	public BlockStrawWeb() {
		super(Material.WOOD, false);
		this.setSoundType(SoundType.WOOD);
	}
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
    
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CARPET_AABB;
	}
	@Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntityWeb te = (TileEntityWeb) worldIn.getTileEntity(pos);
	    IItemHandler inventory = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
	
	    if (inventory != null && inventory.getStackInSlot(0) != ItemStack.EMPTY) {
	        Block.spawnAsEntity(worldIn, pos, inventory.getStackInSlot(0));
	        ((IItemHandlerModifiable) inventory).setStackInSlot(0, ItemStack.EMPTY);
	    }
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityWeb();
    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote)
            return true;
        
		ItemStack stack = playerIn.getHeldItem(hand);
		TileEntity tile = worldIn.getTileEntity(pos);
		if (hand == EnumHand.MAIN_HAND) {
		    if (tile instanceof TileEntityWeb) {
		    	TileEntityWeb tileEntity = (TileEntityWeb) tile;
		        if(!(tileEntity.getInventory().getStackInSlot(0)).isEmpty()&&!(stack.equals(tileEntity.getInventory().getStackInSlot(0)))){
		            Block.spawnAsEntity(worldIn, pos, tileEntity.getInventory().getStackInSlot(0));
		            tileEntity.getInventory().setStackInSlot(0, ItemStack.EMPTY);
		            tileEntity.markDirty();
		            return true;
		        }
				ItemStack campfireStack=stack.copy();
				campfireStack.setCount(1);
				stack.shrink(1);
				tileEntity.getInventory().insertItem(0,campfireStack,false);
				tileEntity.markDirty();
				return true;
		    }
		}

		return true;
    }
}
