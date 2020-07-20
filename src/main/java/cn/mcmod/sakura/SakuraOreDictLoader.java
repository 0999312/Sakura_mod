package cn.mcmod.sakura;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SakuraOreDictLoader {

	public SakuraOreDictLoader() {
		OreDictionary.registerOre("listAllsoup", new ItemStack(ItemLoader.FOODSET, 1, 74));
		OreDictionary.registerOre("listAllsoup", new ItemStack(ItemLoader.FOODSET, 1, 76));
		OreDictionary.registerOre("listAllsoup", new ItemStack(ItemLoader.FOODSET, 1, 77));
		OreDictionary.registerOre("listAllsoup", new ItemStack(ItemLoader.FOODSET, 1, 161));
		
		OreDictionary.registerOre("cropRice", new ItemStack(ItemLoader.MATERIAL, 1, 1));
		OreDictionary.registerOre("foodFlour", new ItemStack(ItemLoader.MATERIAL, 1, 4));
		OreDictionary.registerOre("foodBreadcrumbs", new ItemStack(ItemLoader.MATERIAL, 1, 30));
		OreDictionary.registerOre("foodBlackpepper", new ItemStack(ItemLoader.MATERIAL, 1, 27));
		OreDictionary.registerOre("foodKetchup", new ItemStack(ItemLoader.MATERIAL, 1, 12));
		OreDictionary.registerOre("dustSalt", new ItemStack(ItemLoader.MATERIAL, 1, 2));
		OreDictionary.registerOre("cropSeaweed", new ItemStack(ItemLoader.MATERIAL, 1, 34));
		OreDictionary.registerOre("cropBambooshoot", new ItemStack(BlockLoader.BAMBOOSHOOT));
		OreDictionary.registerOre("bamboo", new ItemStack(BlockLoader.BAMBOO));
		OreDictionary.registerOre("bamboo", new ItemStack(ItemLoader.MATERIAL,1,48));
		OreDictionary.registerOre("listAlltofu", new ItemStack(ItemLoader.FOODSET,1,81));
		OreDictionary.registerOre("listAllfishraw",  new ItemStack(ItemLoader.FOODSET,1,141));
//		OreDictionary.registerOre("listAllfishfresh",  new ItemStack(ItemLoader.FOODSET,1,141));
//		OreDictionary.registerOre("listAllmushroom", new ItemStack(ItemLoader.FOODSET,1,135));
		OreDictionary.registerOre("listAllmushroom", new ItemStack(ItemLoader.FOODSET,1,136));
		OreDictionary.registerOre("listAllmushroom", new ItemStack(ItemLoader.FOODSET,1,137));

		OreDictionary.registerOre("logWood", new ItemStack(Item.getItemFromBlock(BlockLoader.MAPLE_LOG), 1));
		OreDictionary.registerOre("logWood", new ItemStack(Item.getItemFromBlock(BlockLoader.SAKURA_LOG), 1));
		OreDictionary.registerOre("foodNatto", new ItemStack(ItemLoader.FOODSET, 1, 63));
		OreDictionary.registerOre("lumber", new ItemStack(ItemLoader.MATERIAL, 1, 24));
		OreDictionary.registerOre("lumber", new ItemStack(ItemLoader.MATERIAL, 1, 25));
		OreDictionary.registerOre("lumber", new ItemStack(ItemLoader.MATERIAL, 1, 26));

        OreDictionary.registerOre("plankWood", new ItemStack(BlockLoader.MAPLE_PLANK, 1));
        OreDictionary.registerOre("plankWood", new ItemStack(BlockLoader.SAKURA_PLANK, 1));
        OreDictionary.registerOre("plankWood", new ItemStack(BlockLoader.BAMBOO_PLANK, 1));

        OreDictionary.registerOre("treeLeaves", new ItemStack(BlockLoader.MAPLE_LEAVE_GREEN, 1));
        OreDictionary.registerOre("treeLeaves", new ItemStack(BlockLoader.MAPLE_LEAVE_ORANGE, 1));
        OreDictionary.registerOre("treeLeaves", new ItemStack(BlockLoader.MAPLE_LEAVE_RED, 1));
        OreDictionary.registerOre("treeLeaves", new ItemStack(BlockLoader.MAPLE_LEAVE_YELLOW, 1));
        OreDictionary.registerOre("treeLeaves", new ItemStack(BlockLoader.SAKURA_LEAVES, 1));
        OreDictionary.registerOre("sakuraLeaves", new ItemStack(BlockLoader.SAKURA_LEAVES, 1));
		OreDictionary.registerOre("cropMaplesyrup", new ItemStack(ItemLoader.MATERIAL, 1,49));
		OreDictionary.registerOre("listAllsugar", new ItemStack(ItemLoader.MATERIAL, 1,49));
		
		OreDictionary.registerOre("seedRice", new ItemStack(ItemLoader.RICE_SEEDS, 1));
		OreDictionary.registerOre("foodSoysauce", new ItemStack(ItemLoader.MATERIAL, 1,33));
		OreDictionary.registerOre("listAlltofuFried", new ItemStack(ItemLoader.FOODSET, 1,82));
		OreDictionary.registerOre("foodShrimpraw", new ItemStack(ItemLoader.FOODSET, 1,78));
		OreDictionary.registerOre("cropRadish", new ItemStack(ItemLoader.RADISH, 1));
		OreDictionary.registerOre("cropCabbage", new ItemStack(ItemLoader.CABBAGE, 1));
		OreDictionary.registerOre("cropEggplant", new ItemStack(ItemLoader.EGGPLANT, 1));
		OreDictionary.registerOre("cropTomato", new ItemStack(ItemLoader.TOMATO, 1));
		OreDictionary.registerOre("cropOnion", new ItemStack(ItemLoader.ONION, 1));
		OreDictionary.registerOre("cropBuckwheat", new ItemStack(ItemLoader.BUCKWHEAT, 1));
		OreDictionary.registerOre("seedBuckwheat", new ItemStack(ItemLoader.BUCKWHEAT, 1));
		OreDictionary.registerOre("seedOnion", new ItemStack(ItemLoader.ONION_SEEDS, 1));
		OreDictionary.registerOre("seedRadish", new ItemStack(ItemLoader.RADISH_SEEDS, 1));
		OreDictionary.registerOre("seedCabbage", new ItemStack(ItemLoader.CABBAGE_SEEDS, 1));
		OreDictionary.registerOre("seedEggplant", new ItemStack(ItemLoader.EGGPLANT_SEEDS, 1));
		OreDictionary.registerOre("seedTomato", new ItemStack(ItemLoader.TOMATO_SEEDS, 1));
		OreDictionary.registerOre("cropGrape", new ItemStack(ItemLoader.FOODSET, 1,0));
		OreDictionary.registerOre("cropGreengrape", new ItemStack(ItemLoader.FOODSET, 1,120));
		OreDictionary.registerOre("listAllfruit", new ItemStack(ItemLoader.FOODSET, 1,120));
		OreDictionary.registerOre("cropVanillabean", new ItemStack(ItemLoader.MATERIAL, 1,21));
		OreDictionary.registerOre("foodVanilla", new ItemStack(ItemLoader.MATERIAL, 1,22));
		OreDictionary.registerOre("cropPeppercorn", new ItemStack(ItemLoader.MATERIAL, 1,18));
		
		OreDictionary.registerOre("listAllgrain", new ItemStack(ItemLoader.MATERIAL, 1, 1));
		OreDictionary.registerOre("listAllgrain", new ItemStack(ItemLoader.BUCKWHEAT, 1));
		
		OreDictionary.registerOre("listAllveggie", new ItemStack(ItemLoader.RADISH, 1));
		OreDictionary.registerOre("listAllveggie", new ItemStack(ItemLoader.CABBAGE, 1));
		OreDictionary.registerOre("listAllveggie", new ItemStack(ItemLoader.EGGPLANT, 1));
		OreDictionary.registerOre("listAllveggie", new ItemStack(ItemLoader.TOMATO, 1));
		OreDictionary.registerOre("listAllveggie", new ItemStack(ItemLoader.ONION, 1));
		
		OreDictionary.registerOre("listAllseed", new ItemStack(ItemLoader.BUCKWHEAT, 1));
		OreDictionary.registerOre("listAllseed", new ItemStack(ItemLoader.RADISH_SEEDS, 1));
		OreDictionary.registerOre("listAllseed", new ItemStack(ItemLoader.CABBAGE_SEEDS, 1));
		OreDictionary.registerOre("listAllseed", new ItemStack(ItemLoader.EGGPLANT_SEEDS, 1));
		OreDictionary.registerOre("listAllseed", new ItemStack(ItemLoader.TOMATO_SEEDS, 1));
		OreDictionary.registerOre("listAllseed", new ItemStack(ItemLoader.RICE_SEEDS, 1));
		OreDictionary.registerOre("listAllseed", new ItemStack(ItemLoader.RAPESEED, 1));
		OreDictionary.registerOre("listAllseed", new ItemStack(ItemLoader.ONION_SEEDS, 1));
		
		OreDictionary.registerOre("cropTea", new ItemStack(ItemLoader.MATERIAL, 1, 39));
		
		OreDictionary.registerOre("foodMocha", new ItemStack(ItemLoader.MATERIAL, 1, 43));
		OreDictionary.registerOre("foodMiso", new ItemStack(ItemLoader.MATERIAL, 1, 29));
		
		OreDictionary.registerOre("bread", new ItemStack(ItemLoader.FOODSET, 1, 2));
		OreDictionary.registerOre("foodBread", new ItemStack(ItemLoader.FOODSET, 1, 2));
		OreDictionary.registerOre("bread", new ItemStack(ItemLoader.FOODSET, 1, 131));
		OreDictionary.registerOre("foodBread", new ItemStack(ItemLoader.FOODSET, 1, 131));
		OreDictionary.registerOre("foodWhitepepper", new ItemStack(ItemLoader.MATERIAL, 1, 28));
		OreDictionary.registerOre("foodCheese", new ItemStack(ItemLoader.FOODSET, 1, 5));
		OreDictionary.registerOre("foodYeast", new ItemStack(ItemLoader.MATERIAL, 1, 36));
		OreDictionary.registerOre("cropHops", new ItemStack(ItemLoader.MATERIAL, 1, 37));
		OreDictionary.registerOre("listAllfruit", new ItemStack(ItemLoader.FOODSET, 1, 0));
		OreDictionary.registerOre("listAllfruit", new ItemStack(ItemLoader.FOODSET, 1, 114));
		OreDictionary.registerOre("cropLemon", new ItemStack(ItemLoader.FOODSET, 1, 114));
		OreDictionary.registerOre("listAllcitrus", new ItemStack(ItemLoader.FOODSET, 1, 114));
		OreDictionary.registerOre("foodPeppermint", new ItemStack(ItemLoader.MATERIAL, 1, 45));
		OreDictionary.registerOre("foodLimejuice", new ItemStack(ItemLoader.FOODSET, 1, 115));
		OreDictionary.registerOre("foodBubblywater", new ItemStack(ItemLoader.FOODSET, 1, 116));
		OreDictionary.registerOre("cropAlmond", new ItemStack(ItemLoader.FOODSET, 1, 117));
		OreDictionary.registerOre("foodBlackberryjuice", new ItemStack(ItemLoader.FOODSET, 1, 118));
		OreDictionary.registerOre("foodOrangejuice", new ItemStack(ItemLoader.FOODSET, 1, 119));
		OreDictionary.registerOre("ingotSteel", new ItemStack(ItemLoader.MATERIAL, 1, 56));
		OreDictionary.registerOre("foodPasta", new ItemStack(ItemLoader.MATERIAL, 1, 57));
		OreDictionary.registerOre("foodDough", new ItemStack(ItemLoader.MATERIAL, 1, 6));
		OreDictionary.registerOre("foodDough", new ItemStack(ItemLoader.MATERIAL, 1, 7));
		
		OreDictionary.registerOre("foodHoisinsause", new ItemStack(ItemLoader.MATERIAL, 1, 60));
		OreDictionary.registerOre("foodMayo", new ItemStack(ItemLoader.MATERIAL, 1, 61));
		OreDictionary.registerOre("foodVinegar", new ItemStack(ItemLoader.MATERIAL, 1, 62));
		
		OreDictionary.registerOre("toolForginghammer", new ItemStack(ItemLoader.STONE_HAMMER, 1, Short.MAX_VALUE));
		OreDictionary.registerOre("toolForginghammer", new ItemStack(ItemLoader.IRON_HAMMER, 1, Short.MAX_VALUE));
		OreDictionary.registerOre("toolForginghammer", new ItemStack(ItemLoader.SAKURA_HAMMER, 1, Short.MAX_VALUE));
		OreDictionary.registerOre("toolKnifefish", new ItemStack(ItemLoader.KNIFE_FISH, 1, Short.MAX_VALUE));
		OreDictionary.registerOre("toolKnifefish", new ItemStack(ItemLoader.SAKURA_KNIFE_FISH, 1, Short.MAX_VALUE));
	}
	

}
