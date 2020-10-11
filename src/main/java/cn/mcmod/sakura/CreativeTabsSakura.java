package cn.mcmod.sakura;

import cn.mcmod.sakura.block.BlockLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabsSakura extends CreativeTabs {

	public CreativeTabsSakura() {
		super(SakuraMain.MODID+"_tabs");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(BlockLoader.SAKURA_LEAVES));
	}

}
