package cn.mcmod.sakura.block.noodles;

import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.item.ItemStack;

public class BlockSoba extends BlockNoodle {

	@Override
	public ItemStack getNoodle() {
		return new ItemStack(ItemLoader.MATERIAL,2,10);
	}

}
