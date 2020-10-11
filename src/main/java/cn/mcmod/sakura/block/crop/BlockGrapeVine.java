package cn.mcmod.sakura.block.crop;

import java.util.Random;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod_mmf.mmlib.block.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGrapeVine extends BlockBase implements IPlantable, IGrowable {
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);

	public BlockGrapeVine() {
		super(Material.WOOD,false);
		this.setDefaultState(this.blockState.getBaseState().withProperty(this.getAgeProperty(), Integer.valueOf(0)));
		this.setTickRandomly(true);
		this.setCreativeTab((CreativeTabs) null);
		this.setHardness(2.0F);
		this.setSoundType(SoundType.WOOD);
	}

	protected PropertyInteger getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return 7;
	}

	protected int getAge(IBlockState state) {
		return state.getValue(this.getAgeProperty()).intValue();
	}

	public IBlockState withAge(int age) {
		return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age));
	}

	public boolean isMaxAge(IBlockState state) {
		return state.getValue(this.getAgeProperty()).intValue() >= this.getMaxAge();
	}

	/**
	 * Whether this IGrowable can grow
	 */
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return !this.isMaxAge(state);
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}

	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		this.grow(worldIn, pos, state);
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta) {
		return this.withAge(meta);
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state) {
		return this.getAge(state);
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { AGE });
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return new AxisAlignedBB(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(BlockLoader.GRAPE_SPLINT_STAND);
	}

	@Override
	public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world,
			BlockPos pos, IBlockState state, int fortune) {
		drops.clear();
		drops.add(new ItemStack(BlockLoader.GRAPE_SPLINT_STAND));
	}

	/**
	 * Spawns this Block's drops into the World as EntityItems.
	 */
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
		if (!worldIn.isRemote) {
			spawnAsEntity(worldIn, pos, new ItemStack(BlockLoader.GRAPE_SPLINT_STAND));
		}
	}

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(BlockLoader.GRAPE_SPLINT_STAND);
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
			IPlantable plantable) {
		return true;
	}

	public void grow(World worldIn, BlockPos pos, IBlockState state) {
		int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
		int j = this.getMaxAge();
		if (i >= 2 && worldIn.getBlockState(pos.up()).getBlock() == BlockLoader.GRAPE_SPLINT_STAND)
			worldIn.setBlockState(pos.up(), this.withAge(0), 2);
		if (i >= 5 && worldIn.getBlockState(pos.east()).getBlock() == BlockLoader.GRAPE_SPLINT)
			worldIn.setBlockState(pos.east(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
		if (i >= 5 && worldIn.getBlockState(pos.north()).getBlock() == BlockLoader.GRAPE_SPLINT)
			worldIn.setBlockState(pos.north(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
		if (i >= 5 && worldIn.getBlockState(pos.west()).getBlock() == BlockLoader.GRAPE_SPLINT)
			worldIn.setBlockState(pos.west(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
		if (i >= 5 && worldIn.getBlockState(pos.south()).getBlock() == BlockLoader.GRAPE_SPLINT)
			worldIn.setBlockState(pos.south(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
		if (i > j)
			i = j;

		worldIn.setBlockState(pos, this.withAge(i), 2);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);

		if (!worldIn.isAreaLoaded(pos, 1))
			return; // Forge: prevent loading unloaded chunks when checking
					// neighbor's light
		if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {
			int i = this.getAge(state);
			if (i >= 2 && worldIn.getBlockState(pos.up()).getBlock() == BlockLoader.GRAPE_SPLINT_STAND)
				worldIn.setBlockState(pos.up(), this.withAge(0), 2);
			if (i >= 5 && worldIn.getBlockState(pos.east()).getBlock() == BlockLoader.GRAPE_SPLINT)
				worldIn.setBlockState(pos.east(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
			if (i >= 5 && worldIn.getBlockState(pos.north()).getBlock() == BlockLoader.GRAPE_SPLINT)
				worldIn.setBlockState(pos.north(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
			if (i >= 5 && worldIn.getBlockState(pos.west()).getBlock() == BlockLoader.GRAPE_SPLINT)
				worldIn.setBlockState(pos.west(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
			if (i >= 5 && worldIn.getBlockState(pos.south()).getBlock() == BlockLoader.GRAPE_SPLINT)
				worldIn.setBlockState(pos.south(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
			if (i < this.getMaxAge()) {

				float f = getGrowthChance(this, worldIn, pos);

				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state,
						rand.nextInt((int) (25.0F / f) + 1) == 0)) {
					worldIn.setBlockState(pos, this.withAge(i + 1), 2);
					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state,
							worldIn.getBlockState(pos));
				}
			}
		}
	}

	protected int getBonemealAgeIncrease(World worldIn) {
		return MathHelper.getInt(worldIn.rand, 2, 5);
	}

	protected static float getGrowthChance(Block blockIn, World worldIn, BlockPos pos) {
		float f = 1.0F;
		BlockPos blockpos = pos.down();

		for (int i = -1; i <= 1; ++i) {
			for (int j = -1; j <= 1; ++j) {
				float f1 = 0.0F;
				IBlockState iblockstate = worldIn.getBlockState(blockpos.add(i, 0, j));

				if (iblockstate.getBlock().canSustainPlant(iblockstate, worldIn, blockpos.add(i, 0, j),
						net.minecraft.util.EnumFacing.UP, (net.minecraftforge.common.IPlantable) blockIn)) {
					f1 = 1.0F;

					if (iblockstate.getBlock().isFertile(worldIn, blockpos.add(i, 0, j))) {
						f1 = 3.0F;
					}
				}

				if (i != 0 || j != 0) {
					f1 /= 4.0F;
				}

				f += f1;
			}
		}

		BlockPos blockpos1 = pos.north();
		BlockPos blockpos2 = pos.south();
		BlockPos blockpos3 = pos.west();
		BlockPos blockpos4 = pos.east();
		boolean flag = blockIn == worldIn.getBlockState(blockpos3).getBlock()
				|| blockIn == worldIn.getBlockState(blockpos4).getBlock();
		boolean flag1 = blockIn == worldIn.getBlockState(blockpos1).getBlock()
				|| blockIn == worldIn.getBlockState(blockpos2).getBlock();

		if (flag && flag1) {
			f /= 2.0F;
		} else {
			boolean flag2 = blockIn == worldIn.getBlockState(blockpos3.north()).getBlock()
					|| blockIn == worldIn.getBlockState(blockpos4.north()).getBlock()
					|| blockIn == worldIn.getBlockState(blockpos4.south()).getBlock()
					|| blockIn == worldIn.getBlockState(blockpos3.south()).getBlock();

			if (flag2) {
				f /= 2.0F;
			}
		}

		return f;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Plains;
	}

	@Override
	public IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		if (state.getBlock() != this)
			return getDefaultState();
		return state;
	}
}
