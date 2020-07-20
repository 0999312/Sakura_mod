package cn.mcmod.sakura.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemShoji extends ItemBlock {

	public ItemShoji(Block block) {
		super(block);
	}
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(worldIn.isAirBlock(pos.up(2)))
			return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
		return EnumActionResult.FAIL;
	}
}
