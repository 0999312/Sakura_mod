package cn.mcmod.sakura.block;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod_mmf.mmlib.block.BlockFacing;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockNoren extends BlockFacing {
	protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.0625D, 0.125D, 0.4375D, 0.9375D, 1.0D, 0.5D);
	protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.0625D, 0.125D, 0.5D, 0.9375D, 1.0D, 0.5625D);
	protected static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.5D, 0.125D, 0.0625D, 0.5625D, 1.0D, 0.9375D);
	protected static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.4375D, 0.125D, 0.0625D, 0.5D, 1.0D, 0.9375D);

	public BlockNoren() {
		super(Material.CLOTH, false);
		this.setCreativeTab(CommonProxy.tab);

		this.setSoundType(SoundType.CLOTH);
		this.setTickRandomly(true);

		this.setResistance(0.5f);
		this.setHardness(0.5f);
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return super.canPlaceBlockAt(worldIn, pos) && this.canBlockStay(worldIn, pos)
				&& worldIn.getBlockState(pos).getBlock() != this;
	}

	protected boolean canSustainNoren(IBlockState state) {
		return state.isFullCube();
	}

	public boolean canBlockStay(World worldIn, BlockPos pos) {
		return this.canSustainNoren(worldIn.getBlockState(pos.up()));
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		this.checkAndDropBlock(world, pos, state);
	}

	@Override
	@Deprecated
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		super.neighborChanged(state, world, pos, block, fromPos);
		if (!this.canBlockStay(world, pos)) {
			this.checkAndDropBlock(world, pos, state);
		}
	}

	protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (!this.canBlockStay(worldIn, pos)) {
			worldIn.destroyBlock(pos, true);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos,
			EnumFacing side) {
		return false;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_,
			EnumFacing p_193383_4_) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = state.getActualState(source, pos);
		EnumFacing enumfacing = state.getValue(FACING);

		switch (enumfacing) {
		case EAST:
			return EAST_AABB;
		case SOUTH:
			return SOUTH_AABB;
		case WEST:
			return WEST_AABB;
		case NORTH:
		default:
			return NORTH_AABB;
		}
	}

}
