package cn.mcmod.sakura.block.noodles;

import cn.mcmod.sakura.block.BlockLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockUdonUnfinished extends Block {
	
	public BlockUdonUnfinished() {
		super(Material.CAKE);
	}
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return BlockNoodle.Noodle_AABB;
	}
	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos) {
		return BlockNoodle.Noodle_AABB;
	}
    /**
     * Block's chance to react to an entity falling on it.
     */
    @Override
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
    	if(worldIn.isRemote) return;
        if (worldIn.rand.nextInt(80)==0) {
            worldIn.setBlockState(pos, BlockLoader.UDON_BLOCK.getDefaultState());
        }
    }
	  @Override
	    public boolean isFullCube(IBlockState state) {
	        return false;
	    }

	    @SideOnly(Side.CLIENT)
	    public BlockRenderLayer getBlockLayer() {
	        return BlockRenderLayer.CUTOUT;
	    }

	    @Override
	    public boolean isOpaqueCube(IBlockState state) {
	        return false;
	    }
}
