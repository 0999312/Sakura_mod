package cn.mcmod.sakura.block.foods;

import java.util.Random;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod_mmf.mmlib.block.BlockFacing;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTeishokoFinished extends BlockFacing {
	public static final PropertyBool isPlate = PropertyBool.create("is_plate");
	public BlockTeishokoFinished() {
		super(Material.WOOD, false);
		this.setSoundType(SoundType.WOOD);
		this.setDefaultState(getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(isPlate, false));
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
	}
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(BlockLoader.OBON);
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return new ItemStack(BlockLoader.OBON).getItem();
	}
	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		boolean isplate = ((meta & 4) == 1);
		EnumFacing enumfacing = EnumFacing.getHorizontal(meta);

		return this.getDefaultState().withProperty(isPlate, isplate).withProperty(FACING, enumfacing);
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		return (state.getValue(isPlate).booleanValue()? 4 : 0)+state.getValue(FACING).getHorizontalIndex();
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, isPlate });
	}
}
