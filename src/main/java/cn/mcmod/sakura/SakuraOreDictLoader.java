package cn.mcmod.sakura;

import java.util.Set;
import java.util.TreeSet;

import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SakuraOreDictLoader {
	public static final Set<String> OreList = new TreeSet<>();
	public SakuraOreDictLoader() {
		registerOre("cropRice", new ItemStack(ItemLoader.MATERIAL, 1, 1));
	}
	private static void registerOre(String string, Block itemStack) {
		OreList.add(string);
		OreDictionary.registerOre(string, itemStack);
	}

	private static void registerOre(String string, ItemStack itemStack) {
		OreList.add(string);
		OreDictionary.registerOre(string, itemStack);
	}

	private static void registerOre(String string, Item itemStack) {
		OreList.add(string);
		OreDictionary.registerOre(string, itemStack);
	}
}
