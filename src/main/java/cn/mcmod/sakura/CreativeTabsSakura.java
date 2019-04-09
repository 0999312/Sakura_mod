package cn.mcmod.sakura;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CreativeTabsSakura extends CreativeTabs {

	public CreativeTabsSakura() {
		super(SakuraMain.MODID+"_tabs");
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack getTabIconItem() {
		// TODO Auto-generated method stub
		return new ItemStack(Items.FEATHER);
	}

}
