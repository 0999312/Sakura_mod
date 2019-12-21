package cn.mcmod.sakura.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockGrassPath;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemBroom extends ItemSpade {

	public ItemBroom(ToolMaterial material) {
		super(material);
	}

    /**
     * Called when a Block is right-clicked with this Item
     */
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack))
        {
            return EnumActionResult.FAIL;
        }
		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();

		if (facing != EnumFacing.DOWN && worldIn.getBlockState(pos.up()).getMaterial() == Material.AIR && worldIn.getBlockState(pos).getMaterial() == Material.GROUND||!(block instanceof BlockFarmland||block instanceof BlockGrassPath))
		{
		    IBlockState iblockstate1 = Blocks.GRASS_PATH.getDefaultState();
		    worldIn.playSound(player, pos, SoundEvents.BLOCK_GRASS_STEP, SoundCategory.BLOCKS, 1.2F, 1.2F);
		    worldIn.playSound(player, pos, SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS, 1.2F, 1.2F);
		    if (!worldIn.isRemote)
		    {
		        worldIn.setBlockState(pos, iblockstate1, 11);
		        itemstack.damageItem(1, player);
		    }

		    return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.PASS;
    }
}
