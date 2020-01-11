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
		registerOre("foodKetchup", new ItemStack(ItemLoader.MATERIAL, 1, 12));
		registerOre("dustSalt", new ItemStack(ItemLoader.MATERIAL, 1, 2));
		registerOre("cropSeaweed", new ItemStack(ItemLoader.MATERIAL, 1, 34));
		registerOre("cropBambooshoot", new ItemStack(BlockLoader.BAMBOOSHOOT));
		registerOre("bamboo", new ItemStack(BlockLoader.BAMBOO));
		registerOre("bamboo", new ItemStack(ItemLoader.MATERIAL,1,48));
		registerOre("listAlltofu", new ItemStack(ItemLoader.FOODSET,1,81));

		registerOre("logWood", new ItemStack(Item.getItemFromBlock(BlockLoader.MAPLE_LOG), 1));
		registerOre("logWood", new ItemStack(Item.getItemFromBlock(BlockLoader.SAKURA_LOG), 1));
		registerOre("foodNatto", new ItemStack(ItemLoader.FOODSET, 1, 63));
		registerOre("woodLumber", new ItemStack(ItemLoader.MATERIAL, 1, 24));
		registerOre("woodLumber", new ItemStack(ItemLoader.MATERIAL, 1, 25));
		registerOre("woodLumber", new ItemStack(ItemLoader.MATERIAL, 1, 26));

        registerOre("plankWood", new ItemStack(BlockLoader.MAPLE_PLANK, 1));
        registerOre("plankWood", new ItemStack(BlockLoader.SAKURA_PLANK, 1));
        registerOre("plankWood", new ItemStack(BlockLoader.BAMBOO_PLANK, 1));

        registerOre("treeLeaves", new ItemStack(BlockLoader.MAPLE_LEAVE_GREEN, 1));
        registerOre("treeLeaves", new ItemStack(BlockLoader.MAPLE_LEAVE_ORANGE, 1));
        registerOre("treeLeaves", new ItemStack(BlockLoader.MAPLE_LEAVE_RED, 1));
        registerOre("treeLeaves", new ItemStack(BlockLoader.MAPLE_LEAVE_YELLOW, 1));
        registerOre("treeLeaves", new ItemStack(BlockLoader.SAKURA_LEAVES, 1));
        registerOre("sakuraLeaves", new ItemStack(BlockLoader.SAKURA_LEAVES, 1));
		registerOre("cropMaplesyrup", new ItemStack(ItemLoader.MATERIAL, 1,49));
		registerOre("listAllsugar", new ItemStack(ItemLoader.MATERIAL, 1,49));
		
		registerOre("seedRice", new ItemStack(ItemLoader.RICE_SEEDS, 1));
		registerOre("foodSoysauce", new ItemStack(ItemLoader.MATERIAL, 1,33));

		registerOre("cropRadish", new ItemStack(ItemLoader.RADISH, 1));
		registerOre("cropCabbage", new ItemStack(ItemLoader.CABBAGE, 1));
		registerOre("cropEggplant", new ItemStack(ItemLoader.EGGPLANT, 1));
		registerOre("cropTomato", new ItemStack(ItemLoader.TOMATO, 1));
		registerOre("cropOnion", new ItemStack(ItemLoader.ONION, 1));
		registerOre("cropBuckwheat", new ItemStack(ItemLoader.BUCKWHEAT, 1));
		registerOre("seedBuckwheat", new ItemStack(ItemLoader.BUCKWHEAT, 1));
		registerOre("seedOnion", new ItemStack(ItemLoader.ONION_SEEDS, 1));
		registerOre("seedRadish", new ItemStack(ItemLoader.RADISH_SEEDS, 1));
		registerOre("seedCabbage", new ItemStack(ItemLoader.CABBAGE_SEEDS, 1));
		registerOre("seedEggplant", new ItemStack(ItemLoader.EGGPLANT_SEEDS, 1));
		registerOre("seedTomato", new ItemStack(ItemLoader.TOMATO_SEEDS, 1));
		registerOre("cropGrape", new ItemStack(ItemLoader.FOODSET, 1,0));
		registerOre("cropGreengrape", new ItemStack(ItemLoader.FOODSET, 1,120));
		registerOre("cropVanillabean", new ItemStack(ItemLoader.MATERIAL, 1,21));
		registerOre("foodVanilla", new ItemStack(ItemLoader.MATERIAL, 1,22));
		registerOre("cropPeppercorn", new ItemStack(ItemLoader.MATERIAL, 1,18));
		
		registerOre("listAllgrain", new ItemStack(ItemLoader.MATERIAL, 1, 1));
		registerOre("listAllgrain", new ItemStack(ItemLoader.BUCKWHEAT, 1));
		
		registerOre("listAllveggie", new ItemStack(ItemLoader.RADISH, 1));
		registerOre("listAllveggie", new ItemStack(ItemLoader.CABBAGE, 1));
		registerOre("listAllveggie", new ItemStack(ItemLoader.EGGPLANT, 1));
		registerOre("listAllveggie", new ItemStack(ItemLoader.TOMATO, 1));
		registerOre("listAllveggie", new ItemStack(ItemLoader.ONION, 1));
		
		registerOre("listAllseed", new ItemStack(ItemLoader.BUCKWHEAT, 1));
		registerOre("listAllseed", new ItemStack(ItemLoader.RADISH_SEEDS, 1));
		registerOre("listAllseed", new ItemStack(ItemLoader.CABBAGE_SEEDS, 1));
		registerOre("listAllseed", new ItemStack(ItemLoader.EGGPLANT_SEEDS, 1));
		registerOre("listAllseed", new ItemStack(ItemLoader.TOMATO_SEEDS, 1));
		registerOre("listAllseed", new ItemStack(ItemLoader.RICE_SEEDS, 1));
		registerOre("listAllseed", new ItemStack(ItemLoader.RAPESEED, 1));
		registerOre("listAllseed", new ItemStack(ItemLoader.ONION_SEEDS, 1));
		
		registerOre("cropTea", new ItemStack(ItemLoader.MATERIAL, 1, 39));
		registerOre("bread", new ItemStack(ItemLoader.FOODSET, 1, 2));
		registerOre("foodBread", new ItemStack(ItemLoader.FOODSET, 1, 2));
		registerOre("foodWhitepepper", new ItemStack(ItemLoader.MATERIAL, 1, 28));
		registerOre("foodCheese", new ItemStack(ItemLoader.FOODSET, 1, 5));
		registerOre("foodYeast", new ItemStack(ItemLoader.MATERIAL, 1, 36));
		registerOre("cropHops", new ItemStack(ItemLoader.MATERIAL, 1, 37));
		registerOre("listAllfruit", new ItemStack(ItemLoader.FOODSET, 1, 0));
		registerOre("listAllfruit", new ItemStack(ItemLoader.FOODSET, 1, 114));
		registerOre("cropLemon", new ItemStack(ItemLoader.FOODSET, 1, 114));
		registerOre("listAllcitrus", new ItemStack(ItemLoader.FOODSET, 1, 114));
		registerOre("foodPeppermint", new ItemStack(ItemLoader.MATERIAL, 1, 45));
		registerOre("foodLimejuice", new ItemStack(ItemLoader.FOODSET, 1, 115));
		registerOre("foodBubblywater", new ItemStack(ItemLoader.FOODSET, 1, 116));
		registerOre("cropAlmond", new ItemStack(ItemLoader.FOODSET, 1, 117));
		registerOre("foodBlackberryjuice", new ItemStack(ItemLoader.FOODSET, 1, 118));
		registerOre("foodOrangejuice", new ItemStack(ItemLoader.FOODSET, 1, 119));
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
	      registerOre("listAllmushroom", Blocks.RED_MUSHROOM);
	      registerOre("listAllmushroom", Blocks.BROWN_MUSHROOM);
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
//		  listAllveggie
		  registerOre("listAllveggie", Items.CARROT);
		  registerOre("listAllveggie", Items.POTATO);
		  registerOre("listAllveggie", Blocks.PUMPKIN);
		  registerOre("listAllveggie", Items.BEETROOT);
		  registerOre("listAllsugar", Items.SUGAR);
		  registerOre("cropBeet", Items.BEETROOT);
		  registerOre("seedBeet", Items.BEETROOT_SEEDS);
		  
		  registerOre("listAllwater", Items.WATER_BUCKET);
		  registerOre("listAllmilk", Items.MILK_BUCKET);
		  registerOre("listAllsugar", Items.SUGAR);
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
