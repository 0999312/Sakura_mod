package cn.mcmod.sakura.block;

import java.util.Random;

import javax.annotation.Nullable;

import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod_mmf.mmlib.block.BlockFacing;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFuton extends BlockFacing {
	public static final PropertyEnum<EnumPartType> PART = PropertyEnum.create("part", EnumPartType.class);
	public static final PropertyBool OCCUPIED = PropertyBool.create("occupied");
	protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.28125D, 1.0D);

	public BlockFuton() {
		super(Material.CLOTH, false);
		this.setSoundType(SoundType.CLOTH);
		this.setHardness(0.2F);
		this.disableStats();
		this.setDefaultState(this.blockState.getBaseState().withProperty(PART, EnumPartType.FOOT).withProperty(OCCUPIED,false));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING,PART,OCCUPIED });
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) {
			return true;
		}
		if (state.getValue(PART) != EnumPartType.HEAD) {
			pos = pos.offset(state.getValue(FACING));
			state = worldIn.getBlockState(pos);

			if (state.getBlock() != this) {
				return true;
			}
		}

		if (worldIn.provider.canRespawnHere() && worldIn.getBiome(pos) != Biomes.HELL) {
			if (state.getValue(OCCUPIED).booleanValue()) {
				EntityPlayer entityplayer = this.getPlayerInBlanket(worldIn, pos);

				if (entityplayer != null) {
					playerIn.sendMessage(new TextComponentTranslation("tile.bed.occupied"));
					return true;
				}

				state = state.withProperty(OCCUPIED, Boolean.valueOf(false));
				worldIn.setBlockState(pos, state, 4);
			}

			EntityPlayer.SleepResult entityplayer$sleepresult = playerIn.trySleep(pos);

			if (entityplayer$sleepresult == EntityPlayer.SleepResult.OK) {
				state = state.withProperty(OCCUPIED, Boolean.valueOf(true));
				worldIn.setBlockState(pos, state, 4);
				return true;
			}
			if (entityplayer$sleepresult == EntityPlayer.SleepResult.NOT_POSSIBLE_NOW) {
				playerIn.sendMessage(new TextComponentTranslation("tile.bed.noSleep"));
			} else if (entityplayer$sleepresult == EntityPlayer.SleepResult.NOT_SAFE) {
				playerIn.sendMessage(new TextComponentTranslation("tile.bed.notSafe"));
			}

			return true;
		}
		worldIn.setBlockToAir(pos);
		BlockPos blockpos = pos.offset(state.getValue(FACING).getOpposite());

		if (worldIn.getBlockState(blockpos).getBlock() == this) {
			worldIn.setBlockToAir(blockpos);
		}

		worldIn.newExplosion(null, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, 5.0F, true, true);
		return true;
	}

	@Nullable
	private EntityPlayer getPlayerInBlanket(World worldIn, BlockPos pos) {
		for (EntityPlayer entityplayer : worldIn.playerEntities) {
			if (entityplayer.isPlayerSleeping() && entityplayer.bedLocation.equals(pos)) {
				return entityplayer;
			}
		}

		return null;
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		EnumFacing enumfacing = state.getValue(FACING);

		if (state.getValue(PART) == EnumPartType.HEAD) {
			if (worldIn.getBlockState(pos.offset(enumfacing.getOpposite())).getBlock() != this) {
				worldIn.setBlockToAir(pos);
			}
		} else if (worldIn.getBlockState(pos.offset(enumfacing)).getBlock() != this) {
			worldIn.setBlockToAir(pos);

			if (!worldIn.isRemote) {
				this.dropBlockAsItem(worldIn, pos, state, 0);
			}
		}
	}

	@Override
	@Nullable
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return state.getValue(PART) == EnumPartType.HEAD ? null : ItemLoader.FUTON;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB;
	}

	@Nullable
	public static BlockPos getSafeExitLocation(World worldIn, BlockPos pos, int tries) {
		EnumFacing enumfacing = worldIn.getBlockState(pos).getValue(FACING);
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();

		for (int l = 0; l <= 1; ++l) {
			int i1 = i - enumfacing.getFrontOffsetX() * l - 1;
			int j1 = k - enumfacing.getFrontOffsetZ() * l - 1;
			int k1 = i1 + 2;
			int l1 = j1 + 2;

			for (int i2 = i1; i2 <= k1; ++i2) {
				for (int j2 = j1; j2 <= l1; ++j2) {
					BlockPos blockpos = new BlockPos(i2, j, j2);

					if (hasRoomForPlayer(worldIn, blockpos)) {
						if (tries <= 0) {
							return blockpos;
						}

						--tries;
					}
				}
			}
		}

		return null;
	}

	protected static boolean hasRoomForPlayer(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).isTopSolid() && !worldIn.getBlockState(pos).getMaterial().isSolid()
				&& !worldIn.getBlockState(pos.up()).getMaterial().isSolid();
	}

	@Override
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
		if (state.getValue(PART) == EnumPartType.FOOT) {
			super.dropBlockAsItemWithChance(worldIn, pos, state, chance, 0);
		}
	}

	@Override
    public EnumPushReaction getMobilityFlag(IBlockState state) {
        return EnumPushReaction.DESTROY;
    }

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(ItemLoader.FUTON);
	}

	@Override
	public boolean isBed(IBlockState state, IBlockAccess world, BlockPos pos, @Nullable Entity player) {
		return true;
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		if (player.capabilities.isCreativeMode && state.getValue(PART) == EnumPartType.HEAD) {
			BlockPos blockpos = pos.offset(state.getValue(FACING).getOpposite());

			if (worldIn.getBlockState(blockpos).getBlock() == this) {
				worldIn.setBlockToAir(blockpos);
			}
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.getHorizontal(meta);
		return (meta & 8) > 0
				? this.getDefaultState().withProperty(PART, EnumPartType.HEAD).withProperty(FACING, enumfacing)
						.withProperty(OCCUPIED, Boolean.valueOf((meta & 4) > 0))
				: this.getDefaultState().withProperty(PART, EnumPartType.FOOT).withProperty(FACING, enumfacing);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		if (state.getValue(PART) == EnumPartType.FOOT) {
			IBlockState iblockstate = worldIn.getBlockState(pos.offset(state.getValue(FACING)));

			if (iblockstate.getBlock() == this) {
				state = state.withProperty(OCCUPIED, iblockstate.getValue(OCCUPIED));
			}
		}

		return state;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | state.getValue(FACING).getHorizontalIndex();

		if (state.getValue(PART) == EnumPartType.HEAD) {
			i |= 8;

			if (state.getValue(OCCUPIED).booleanValue()) {
				i |= 4;
			}
		}

		return i;
	}

	public enum EnumPartType implements IStringSerializable {
		HEAD("head"), FOOT("foot");

		private final String name;

		EnumPartType(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name;
		}

		@Override
		public String getName() {
			return this.name;
		}
	}
}
