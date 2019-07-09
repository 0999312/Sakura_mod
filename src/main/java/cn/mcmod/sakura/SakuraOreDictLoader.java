package cn.mcmod.sakura;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
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
		registerOre("foodFlour", new ItemStack(ItemLoader.MATERIAL, 1, 4));
		registerOre("foodBreadcrumbs", new ItemStack(ItemLoader.MATERIAL, 1, 30));
		registerOre("foodBlackpepper", new ItemStack(ItemLoader.MATERIAL, 1, 27));
		registerOre("dustSalt", new ItemStack(ItemLoader.MATERIAL, 1, 2));
		
		registerOre("bamboo", new ItemStack(BlockLoader.BAMBOO));

		registerOre("logWood", new ItemStack(Item.getItemFromBlock(BlockLoader.MAPLE_LOG), 1));
		registerOre("logWood", new ItemStack(Item.getItemFromBlock(BlockLoader.SAKURA_LOG), 1));
		
		registerVanillaFoods();
	}
	
	private static void registerVanillaFoods() {
		  registerOre("listAllchickenraw", Items.CHICKEN);
		  registerOre("listAllegg", Items.EGG);
		  registerOre("listAllchickencooked", Items.COOKED_CHICKEN);
		  registerOre("listAllporkraw", Items.PORKCHOP);
		  registerOre("listAllporkcooked", Items.COOKED_PORKCHOP);
		  registerOre("listAllbeefraw", Items.BEEF);
		  registerOre("listAllbeefcooked", Items.COOKED_BEEF);
		  registerOre("listAllmuttonraw", Items.MUTTON);
		  registerOre("listAllmuttoncooked", Items.COOKED_MUTTON);
		  registerOre("listAllrabbitraw", Items.RABBIT);
		  registerOre("listAllrabbitcooked", Items.COOKED_RABBIT);
		  registerOre("bread", Items.BREAD);
		  registerOre("foodBread", Items.BREAD);
		    
		  registerOre("cropCarrot", Items.CARROT);
		  registerOre("cropPotato", Items.POTATO);
		  registerOre("cropPumpkin", Blocks.PUMPKIN);
		  registerOre("cropWheat", Items.WHEAT);
		  registerOre("cropBeet", Items.BEETROOT);
		    
		  registerOre("listAllgrain", Items.WHEAT);
		  registerOre("cropApple", Items.APPLE);
		  registerOre("listAllfruit", Items.APPLE);
		  registerOre("listAllfruit", Items.CHORUS_FRUIT);
		    
		  registerOre("listAllmeatraw", Items.BEEF);
		  registerOre("listAllmeatraw", Items.CHICKEN);
		  registerOre("listAllmeatraw", Items.PORKCHOP);
		  registerOre("listAllmeatraw", Items.MUTTON);
		  registerOre("listAllmeatraw", Items.RABBIT);
		  registerOre("listAllmeatcooked", Items.COOKED_BEEF);
		  registerOre("listAllmeatcooked", Items.COOKED_CHICKEN);
		  registerOre("listAllmeatcooked", Items.COOKED_PORKCHOP);
		  registerOre("listAllmeatcooked", Items.COOKED_MUTTON);
		  registerOre("listAllmeatcooked", Items.COOKED_RABBIT);

		  registerOre("listAllfishraw", new ItemStack(Items.FISH, 1, 32767));
		  registerOre("listAllfishfresh", new ItemStack(Items.FISH, 1, 32767));
		  registerOre("listAllfishcooked", Items.COOKED_FISH);
		  registerOre("listAllfishcooked", new ItemStack(Items.COOKED_FISH, 1, 1));
		  registerOre("salmonRaw", new ItemStack(Items.FISH, 1));
		    
		  registerOre("listAllsugar", Items.SUGAR);
		  registerOre("cropBeet", Items.BEETROOT);
		  registerOre("seedBeet", Items.BEETROOT_SEEDS);
		  
		  registerOre("listAllwater", Items.WATER_BUCKET);
		  registerOre("listAllmilk", Items.MILK_BUCKET);
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
