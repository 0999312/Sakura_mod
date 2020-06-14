package cn.mcmod.sakura.block;

import cn.mcmod_mmf.mmlib.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTatara extends BlockBase {
	public BlockTatara() {
		super(Material.ROCK,true);
		this.setHarvestLevel("forging_hammer", 1);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	    if (worldIn.isRemote) {
	    	worldIn.playSound(playerIn, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, 0.8F);
            return true;
        }
		ItemStack stack = playerIn.getHeldItem(hand);
		if (hand == EnumHand.MAIN_HAND) {
	        if (stack.getItem() == Items.FLINT_AND_STEEL) {
	            worldIn.setBlockState(pos, BlockLoader.TATARA_SMELTING.getDefaultState());
	            stack.damageItem(1, playerIn);
	            return true;
	        }
		}
		return true;
	}
	@Override
	public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
		// TODO Auto-generated method stub
		super.onNeighborChange(world, pos, neighbor);
	}

}
