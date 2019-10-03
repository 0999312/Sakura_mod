package cn.mcmod.sakura.block.noodles;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockUdon extends BlockNoodle {

	@Override
	public ItemStack getNoodle() {
		return new ItemStack(ItemLoader.MATERIAL,2,9);
	}
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(BlockLoader.UDON_UNFINISHED);
	}
}
