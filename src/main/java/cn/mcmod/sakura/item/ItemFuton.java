package cn.mcmod.sakura.item;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.block.BlockFuton;
import cn.mcmod.sakura.block.BlockLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemFuton extends Item {
	public ItemFuton() {
		setUnlocalizedName(SakuraMain.MODID + "." + "futon");
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) {
			return EnumActionResult.SUCCESS;
		} else if (facing != EnumFacing.UP) {
			return EnumActionResult.FAIL;
		} else {
			IBlockState iblockstate = worldIn.getBlockState(pos);
			Block block = iblockstate.getBlock();
			boolean flag = block.isReplaceable(worldIn, pos);

			if (!flag) {
				pos = pos.up();
			}

			int i = MathHelper.floor(playerIn.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
			EnumFacing enumfacing = EnumFacing.getHorizontal(i);
			BlockPos blockpos = pos.offset(enumfacing);
			ItemStack itemstack = playerIn.getHeldItem(hand);

			if (playerIn.canPlayerEdit(pos, facing, itemstack) && playerIn.canPlayerEdit(blockpos, facing, itemstack)) {
				boolean flag1 = worldIn.getBlockState(blockpos).getBlock().isReplaceable(worldIn, blockpos);
				boolean flag2 = flag || worldIn.isAirBlock(pos);
				boolean flag3 = flag1 || worldIn.isAirBlock(blockpos);

				if (flag2 && flag3 && worldIn.getBlockState(pos.down()).isTopSolid()
						&& worldIn.getBlockState(blockpos.down()).isFullCube()) {
					IBlockState iblockstate1 = BlockLoader.FUTON.getDefaultState()
							.withProperty(BlockFuton.OCCUPIED, Boolean.valueOf(false))
							.withProperty(BlockHorizontal.FACING, enumfacing)
							.withProperty(BlockFuton.PART, BlockFuton.EnumPartType.FOOT);

					if (worldIn.setBlockState(pos, iblockstate1, 11)) {
						IBlockState iblockstate2 = iblockstate1.withProperty(BlockFuton.PART,
								BlockFuton.EnumPartType.HEAD);
						worldIn.setBlockState(blockpos, iblockstate2, 11);
					}

					SoundType soundtype = iblockstate1.getBlock().getSoundType(iblockstate1, worldIn, pos, playerIn);
					worldIn.playSound(null, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS,
							(soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
					itemstack.shrink(1);
					return EnumActionResult.SUCCESS;
				}
				return EnumActionResult.FAIL;
			}
			return EnumActionResult.FAIL;
		}
	}
}
