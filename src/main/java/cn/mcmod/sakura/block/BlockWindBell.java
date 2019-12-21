package cn.mcmod.sakura.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockWindBell extends BlockFacing {
	  protected static final AxisAlignedBB BAMBOO_AABB = new AxisAlignedBB(0.35D, 0.275D, 0.35D, 0.65D, 1D, 0.65D);
	public BlockWindBell() {
		super(Material.WOOD, false);
		this.setTickRandomly(true);
		this.setSoundType(SoundType.CLOTH);
	}
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (rand.nextInt(200) == 0) {
           worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS, 1F, 1.5F * ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.8F), 
        		   true);
        }
		super.updateTick(worldIn, pos, state, rand);
	}
	
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
    	return Block.NULL_AABB;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BAMBOO_AABB;
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
