package cn.mcmod.sakura.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWindBell extends BlockFacing {

	public BlockWindBell() {
		super(Material.WOOD, false);
		this.setTickRandomly(true);
		this.setSoundType(SoundType.CLOTH);
	}
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (rand.nextInt(500) == 0) {
           worldIn.playSound((float)pos.getX(), (float)pos.getY(), (float)pos.getZ(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS, 1F, 1.5F * ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.8F), 
        		   true);
        }
		super.updateTick(worldIn, pos, state, rand);
	}
	
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
    	return Block.NULL_AABB;
    }
    
	 @Override
	    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
	        if (!this.canBlockStay(worldIn, pos)) {
	            worldIn.destroyBlock(pos, true);
	        }
	    }

	    public boolean canBlockStay(World worldIn, BlockPos pos) {
	        IBlockState state = worldIn.getBlockState(pos.up());
	        return !worldIn.isAirBlock(pos.up())&&state.isFullBlock();
	    }
	    @Override
	    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
	    	return canBlockStay(worldIn, pos);
	    }
}
