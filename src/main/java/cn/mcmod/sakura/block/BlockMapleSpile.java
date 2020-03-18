package cn.mcmod.sakura.block;

import java.util.Random;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.block.tree.BlockMapleSapLog;
import cn.mcmod.sakura.client.SakuraParticleType;
import cn.mcmod_mmf.mmlib.block.BlockFacing;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMapleSpile extends BlockFacing {
	private static final AxisAlignedBB AABB_N = new AxisAlignedBB(0.3125D, 0.1875D, 0.1875D, 0.6875D, 0.6875D, 1.0D);
	private static final AxisAlignedBB AABB_S = new AxisAlignedBB(0.3125D, 0.1875D, 0D, 0.6875D, 0.6875D, 0.8125D);
	private static final AxisAlignedBB AABB_W = new AxisAlignedBB(0.1875D, 0.1875D, 0.3125D, 1.0D, 0.6875D, 0.6875D);
	private static final AxisAlignedBB AABB_E = new AxisAlignedBB(0D, 0.1875D, 0.3125D, 0.8125D, 0.6875D, 0.6875D);
	public BlockMapleSpile() {
		super(Material.IRON,false);
		setTickRandomly(true);
	}
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
       switch (state.getValue(FACING)) {
		case EAST:
			return AABB_E;
		case NORTH:
			return AABB_N;
		case SOUTH:
			return AABB_S;
		case WEST:
			return AABB_W;
		default:
			break;
		}
       return AABB_N;
    }
	
    /**
     * Checks if this block can be placed exactly at the given position.
     */
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)  {
        for (EnumFacing enumfacing : FACING.getAllowedValues())
            if (this.canPlaceAt(worldIn, pos, enumfacing))
                return true;
        return false;
    }
	@Override
	public void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state) {
		 for (EnumFacing enumfacing : FACING.getAllowedValues())
	            if (this.canPlaceAt(worldIn, pos, enumfacing))
	                worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
	}
    private boolean canPlaceAt(World worldIn, BlockPos pos, EnumFacing facing) {
        BlockPos blockpos = pos.offset(facing.getOpposite());
        IBlockState iblockstate = worldIn.getBlockState(blockpos);
        Block block = iblockstate.getBlock();
        if (facing != EnumFacing.UP && facing != EnumFacing.DOWN) {
            boolean flag1 = !isExceptBlockForAttachWithPiston(block);
            boolean flag2 = block instanceof BlockMapleSapLog && iblockstate.getValue(BlockMapleSapLog.SAP_AGE).intValue()<5;
            return flag1&&flag2;
        }
		return false;
    }
    @Override
    public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
        if(canWork(worldIn, pos, state)){
        	EnumFacing facing = state.getValue(FACING);
        	BlockPos blockpos = pos.offset(facing.getOpposite());
            IBlockState iblockstate = worldIn.getBlockState(blockpos);
        	if(worldIn.rand.nextInt(5000)==0)
        		worldIn.setBlockState(blockpos, iblockstate.withProperty(BlockMapleSapLog.SAP_AGE, iblockstate.getValue(BlockMapleSapLog.SAP_AGE).intValue()+1));		
        }
    }
    
    public static boolean canWork(World worldIn, BlockPos pos, IBlockState state) {
    	EnumFacing facing = state.getValue(FACING);
    	BlockPos blockpos = pos.offset(facing.getOpposite());
        IBlockState iblockstate = worldIn.getBlockState(blockpos);
        Block block = iblockstate.getBlock();
        if(block instanceof BlockMapleSapLog&&iblockstate.getValue(BlockMapleSapLog.SAP_AGE).intValue()<5)
        	return true;
		return false;
	}
    
    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
    	if(canWork(worldIn, pos, stateIn)){
	    	if (rand.nextInt(10) == 0) {
	            double d0 = pos.getX() + 0.5D;
	            double d1 = pos.getY() - 0.15D;
	            double d2 = pos.getZ() + 0.5D;
	            double d3 = 0D;
	            double d4 = ((rand.nextFloat()) * 0.055D) + 0.015D;
	            double d5 = 0D;
	            SakuraMain.proxy.spawnParticle(SakuraParticleType.SYRUPDROP, d0, d1, d2, d3, -d4, d5);
	        }
        }
    }
}
