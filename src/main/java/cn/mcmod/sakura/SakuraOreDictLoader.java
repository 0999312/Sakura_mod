package cn.mcmod.sakura;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Set;
import java.util.TreeSet;

public class SakuraOreDictLoader {
	public static final Set<String> OreList = new TreeSet<>();
	public SakuraOreDictLoader() {
		registerOre("cropRice", new ItemStack(ItemLoader.MATERIAL, 1, 1));
		registerOre("listAllfishfresh", new ItemStack(Items.FISH, 1));
		registerOre("listAllfishraw", new ItemStack(Items.FISH, 1));
		registerOre("listAllfishfresh", new ItemStack(Items.FISH, 1, 1));
		registerOre("listAllfishraw", new ItemStack(Items.FISH, 1, 1));
		registerOre("listAllfishfresh", new ItemStack(Items.FISH, 1, 2));
		registerOre("listAllfishraw", new ItemStack(Items.FISH, 1, 2));

		registerOre("logWood", new ItemStack(Item.getItemFromBlock(BlockLoader.MAPLE_LOG), 1));
		registerOre("logWood", new ItemStack(Item.getItemFromBlock(BlockLoader.SAKURA_LOG), 1));
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
