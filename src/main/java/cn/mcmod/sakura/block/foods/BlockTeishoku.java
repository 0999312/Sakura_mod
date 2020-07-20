package cn.mcmod.sakura.block.foods;

import java.util.Random;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod_mmf.mmlib.block.BlockFacing;
import net.dries007.tfc.api.capability.food.FoodData;
import net.dries007.tfc.api.capability.food.IFoodStatsTFC;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional.Method;

public class BlockTeishoku extends BlockFacing {
	public static final PropertyInteger BITES = PropertyInteger.create("bites", 0, 3);
	public final int amount;
	public final float saturation;
	public final boolean isPlate;

	public BlockTeishoku(int amount, float saturation,boolean isPlate) {
		super(Material.WOOD, false);
		this.setSoundType(SoundType.WOOD);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(BITES,
				Integer.valueOf(0)));
		this.amount = amount;
		this.saturation = saturation;
		this.isPlate = isPlate;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
	}

	/**
	 * Called when the block is right clicked by a player.
	 */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			return this.eatGohan(worldIn, pos, state, playerIn);
		}
		ItemStack itemstack = playerIn.getHeldItem(hand);
		return this.eatGohan(worldIn, pos, state, playerIn) || itemstack.isEmpty();
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if (state.getValue(BITES) > 0)
			return new ItemStack(BlockLoader.OBON).getItem();
		return super.getItemDropped(state, rand, fortune);
	}

	private boolean eatGohan(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
//		if (!player.canEat(false)) {
//			return false;
//		}
		if (Loader.isModLoaded("tfc"))
			addTFCStats(player);
		else
			player.getFoodStats().addStats(amount, saturation);
		int i = state.getValue(BITES).intValue();
		worldIn.playSound(player, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_BURP,
				SoundCategory.PLAYERS, 0.4F, worldIn.rand.nextFloat() * 0.1F + 0.8F);
		if (i < 3) {
			worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 3);
		} else {
			worldIn.setBlockState(pos,
					BlockLoader.TEISHOKO_FINISHED.getDefaultState().withProperty(BlockTeishokoFinished.isPlate, this.isPlate).withProperty(FACING, state.getValue(FACING)), 3);
		}
		return true;
	}

	@Method(modid = "tfc")
	private void addTFCStats(EntityPlayer player) {
		((IFoodStatsTFC) player.getFoodStats()).getNutrition()
				.addNutrients(new FoodData(amount, 10F, saturation, 5F, 5F, 5F, 5F, 5F, 1F));
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		int facing_meta = meta & 12;
		EnumFacing facing;
		switch (facing_meta) {
		case 0:
			facing = EnumFacing.SOUTH;
			break;
		case 1:
			facing = EnumFacing.WEST;
			break;
		case 2:
			facing = EnumFacing.NORTH;
			break;
		case 3:
			facing = EnumFacing.EAST;
			break;
		default:
			facing = EnumFacing.NORTH;
			break;
		}
		return this.getDefaultState().withProperty(FACING, facing).withProperty(BITES, (meta & 3));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		return (state.getValue(FACING).getHorizontalIndex() << 2) + state.getValue(BITES).intValue();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, BITES });
	}
}
