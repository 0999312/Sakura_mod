package cn.mcmod.sakura.item;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.item.Item;

public class ItemPot extends Item {
	public ItemPot() {
		setUnlocalizedName(SakuraMain.MODID + "." + "cooking_pot");
		setMaxStackSize(1);
	}

}
