package cn.mcmod.sakura.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;

import cn.mcmod.sakura.SakuraConfig;
import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.api.recipes.BarrelRecipes;
import cn.mcmod.sakura.api.recipes.DistillationRecipes;
import cn.mcmod.sakura.api.recipes.LiquidToItemRecipe;
import cn.mcmod.sakura.api.recipes.MortarRecipes;
import cn.mcmod.sakura.api.recipes.PotRecipes;
import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.item.drinks.DrinksLoader;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional.Method;
import net.minecraftforge.oredict.OreDictionary;

public class SakuraRecipeRegister {
	public static List<IAction> actions = new ArrayList<IAction>();
	
	public static void Init() {
		barrelRegister();
		furnaceRegister();
		L2ISRegister();
		mortarRegister();
		potRegister();
		if (Loader.isModLoaded("crafttweaker"))
            doDelayTask();
		actions = null;
	}

	public static void addAction(IAction action) {
        actions.add(action);
    }

    @Method(modid = "crafttweaker")
    public static void doDelayTask() {
        for (IAction act : actions) {
            CraftTweakerAPI.apply(act);
            if (act.describe() != null)
            	SakuraMain.logger.log(Level.INFO, act.describe());
        }
        actions.clear();
    }
	
	public static void L2ISRegister() {
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.BEER_FLUID, 1000)), new FluidStack(BlockLoader.BEER_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.DOBUROKU_FLUID, 1000)), new FluidStack(BlockLoader.DOBUROKU_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.SAKE_FLUID, 1000)), new FluidStack(BlockLoader.SAKE_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.SHOUCHU_FLUID, 1000)), new FluidStack(BlockLoader.SHOUCHU_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.RED_WINE_FLUID, 1000)), new FluidStack(BlockLoader.RED_WINE_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.WHITE_WINE_FLUID, 1000)), new FluidStack(BlockLoader.WHITE_WINE_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.CHAMPAGNE_FLUID, 1000)), new FluidStack(BlockLoader.CHAMPAGNE_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.RUM_FLUID, 1000)), new FluidStack(BlockLoader.RUM_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.VODKA_FLUID, 1000)), new FluidStack(BlockLoader.VODKA_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.BRANDY_FLUID, 1000)), new FluidStack(BlockLoader.BRANDY_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.WHISKEY_FLUID, 1000)), new FluidStack(BlockLoader.WHISKEY_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.YEAST_FLUID, 1000)), new FluidStack(BlockLoader.YEAST_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.LIQUEUR_FLUID, 1000)), new FluidStack(BlockLoader.LIQUEUR_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.COCOA_LIQUEUR_FLUID, 1000)), new FluidStack(BlockLoader.COCOA_LIQUEUR_FLUID, 1000)));
		
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,0), new FluidStack(BlockLoader.BEER_FLUID, 400)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,1), new FluidStack(BlockLoader.DOBUROKU_FLUID, 200)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,2), new FluidStack(BlockLoader.SAKE_FLUID, 200)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,3), new FluidStack(BlockLoader.SHOUCHU_FLUID, 200)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,4), new FluidStack(BlockLoader.RED_WINE_FLUID, 200)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,5), new FluidStack(BlockLoader.WHITE_WINE_FLUID, 200)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,6), new FluidStack(BlockLoader.CHAMPAGNE_FLUID, 200)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,7), new FluidStack(BlockLoader.RUM_FLUID, 200)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,8), new FluidStack(BlockLoader.VODKA_FLUID, 200)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,9), new FluidStack(BlockLoader.WHISKEY_FLUID, 200)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,10), new FluidStack(BlockLoader.BRANDY_FLUID, 200)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,13), new FluidStack(BlockLoader.LIQUEUR_FLUID, 200)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,14), new FluidStack(BlockLoader.COCOA_LIQUEUR_FLUID, 200)));
	
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,0), new FluidStack(BlockLoader.BEER_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,1), new FluidStack(BlockLoader.DOBUROKU_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,2), new FluidStack(BlockLoader.SAKE_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,3), new FluidStack(BlockLoader.SHOUCHU_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,4), new FluidStack(BlockLoader.RED_WINE_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,5), new FluidStack(BlockLoader.WHITE_WINE_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,6), new FluidStack(BlockLoader.CHAMPAGNE_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,7), new FluidStack(BlockLoader.RUM_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,8), new FluidStack(BlockLoader.VODKA_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,9), new FluidStack(BlockLoader.WHISKEY_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,10), new FluidStack(BlockLoader.BRANDY_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,13), new FluidStack(BlockLoader.LIQUEUR_FLUID, 1000)));
		LiquidToItemRecipe.addRecipe(new LiquidToItemRecipe(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,14), new FluidStack(BlockLoader.COCOA_LIQUEUR_FLUID, 1000)));
	}
	
    public static void furnaceRegister() {
    	FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(BlockLoader.IRON_SAND), new ItemStack(Items.IRON_INGOT), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.MATERIAL, 1, 1), new ItemStack(ItemLoader.MATERIAL, 1, 38), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.MATERIAL, 1, 21), new ItemStack(ItemLoader.MATERIAL, 1, 22), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.EGGPLANT, 1), new ItemStack(ItemLoader.FOODSET, 1, 87), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.MATERIAL, 1, 17), new ItemStack(ItemLoader.FOODSET, 1, 2), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.FOODSET, 1, 48), new ItemStack(ItemLoader.FOODSET, 1, 49), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.FOODSET, 1, 58), new ItemStack(ItemLoader.FOODSET, 1, 59), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.MATERIAL, 1, 6), new ItemStack(ItemLoader.FOODSET, 1, 4), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.FOODSET, 1, 112), new ItemStack(ItemLoader.FOODSET, 1, 113), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.MATERIAL, 1, 31), new ItemStack(ItemLoader.FOODSET, 1, 73), 0.1F);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(BlockLoader.MAPLE_LOG, 1), new ItemStack(Items.COAL, 1, 1), 0.1F);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(BlockLoader.SAKURA_LOG, 1), new ItemStack(Items.COAL, 1, 1), 0.1F);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(BlockLoader.BAMBOO_BLOCK, 1), new ItemStack(BlockLoader.BAMBOO_CHARCOAL_BLOCK), 0.1F);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(BlockLoader.BAMBOO, 1), new ItemStack(ItemLoader.MATERIAL, 1, 51), 0.1F);
    	if(SakuraConfig.harder_iron_recipe)
		FurnaceRecipes.instance().getSmeltingList().forEach((key,value) ->{
    		if(RecipesUtil.containsMatch(false, OreDictionary.getOres("ingotIron"), value))
    			FurnaceRecipes.instance().getSmeltingList().put(key, new ItemStack(ItemLoader.MATERIAL,1,52));
    	});
    }

    public static void barrelRegister() {
		BarrelRecipes.register(
				new BarrelRecipes(
				new FluidStack(FluidRegistry.WATER, 100),
				new FluidStack(BlockLoader.YEAST_FLUID, 50), 
				new Object[]{
				"listAllfruit",
				"listAllgrain",
				"listAllsugar"
				}, 600));
		BarrelRecipes.register(
				new BarrelRecipes(
				new FluidStack(FluidRegistry.WATER, 100),
				new FluidStack(BlockLoader.BEER_FLUID, 100), 
				new Object[]{
				"cropWheat",
				"foodYeast",
				"cropHops"
				}, 800));
		BarrelRecipes.register(
				new BarrelRecipes(
				new FluidStack(BlockLoader.GRAPE_FLUID, 100),
				new FluidStack(BlockLoader.RED_WINE_FLUID, 50), 
				new Object[]{
				"listAllsugar",	
				"foodYeast"
				}, 1200));
		BarrelRecipes.register(
				new BarrelRecipes(
				new FluidStack(BlockLoader.GREEN_GRAPE_FLUID, 100),
				new FluidStack(BlockLoader.WHITE_WINE_FLUID, 50), 
				new Object[]{
				"listAllsugar",	
				"foodYeast"
				}, 1200));
		BarrelRecipes.register(
				new BarrelRecipes(
				new FluidStack(BlockLoader.WHITE_WINE_FLUID, 100),
				new FluidStack(BlockLoader.CHAMPAGNE_FLUID, 50), 
				new Object[]{
				"listAllsugar",		
				"foodYeast"
				}, 1200));
		BarrelRecipes.register(
				new BarrelRecipes(
				new FluidStack(FluidRegistry.WATER, 100),
				new FluidStack(BlockLoader.DOBUROKU_FLUID, 50), 
				new Object[]{
				new ItemStack(ItemLoader.FOODSET,1,7),
				"foodYeast"
				}, 1200));
		BarrelRecipes.register(
				new BarrelRecipes(
				new FluidStack(BlockLoader.DOBUROKU_FLUID, 100),
				new FluidStack(BlockLoader.SAKE_FLUID, 50), 1200));
		DistillationRecipes.register(
				new DistillationRecipes(
				new FluidStack(BlockLoader.SAKE_FLUID, 100),
				new FluidStack(BlockLoader.SHOUCHU_FLUID, 50), 100));
		DistillationRecipes.register(
				new DistillationRecipes(
				new FluidStack(FluidRegistry.WATER, 100),
				new FluidStack(BlockLoader.WHISKEY_FLUID, 50), 
				new Object[]{
				"listAllgrain",
				"listAllgrain",
				"listAllgrain"
				}, 1200));
		DistillationRecipes.register(
				new DistillationRecipes(
				new FluidStack(BlockLoader.RED_WINE_FLUID, 100),
				new FluidStack(BlockLoader.BRANDY_FLUID, 50), 
				new Object[]{
				"listAllsugar"
				}, 1200));
		DistillationRecipes.register(
				new DistillationRecipes(
				new FluidStack(BlockLoader.GREEN_GRAPE_FLUID, 100),
				new FluidStack(BlockLoader.BRANDY_FLUID, 50), 
				new Object[]{
				"listAllsugar"
				}, 1200));
		DistillationRecipes.register(
				new DistillationRecipes(
				new FluidStack(FluidRegistry.WATER, 100),
				new FluidStack(BlockLoader.VODKA_FLUID, 50), 
				new Object[]{
				"cropPotato",
				"cropPotato",
				"cropPotato"
				}, 1200));
		DistillationRecipes.register(
				new DistillationRecipes(
				new FluidStack(FluidRegistry.WATER, 100),
				new FluidStack(BlockLoader.RUM_FLUID, 50), 
				new Object[]{
				"sugarcane",
				"sugarcane",
				"sugarcane"
				}, 1200));
		DistillationRecipes.register(
				new DistillationRecipes(
				new FluidStack(BlockLoader.RUM_FLUID, 100),
				new FluidStack(BlockLoader.LIQUEUR_FLUID, 100), 
				new Object[]{
				"listAllfruit",
				"listAllfruit",
				"listAllsugar"
				}, 1200));
		DistillationRecipes.register(
				new DistillationRecipes(
				new FluidStack(BlockLoader.VODKA_FLUID, 100),
				new FluidStack(BlockLoader.LIQUEUR_FLUID, 100), 
				new Object[]{
				"listAllfruit",
				"listAllfruit",
				"listAllsugar"
				}, 1200));
		DistillationRecipes.register(
				new DistillationRecipes(
				new FluidStack(BlockLoader.WHISKEY_FLUID, 100),
				new FluidStack(BlockLoader.LIQUEUR_FLUID, 100), 
				new Object[]{
				"listAllfruit",
				"listAllfruit",
				"listAllsugar"
				}, 1200));
		
		DistillationRecipes.register(
				new DistillationRecipes(
				new FluidStack(BlockLoader.RUM_FLUID, 100),
				new FluidStack(BlockLoader.COCOA_LIQUEUR_FLUID, 100), 
				new Object[]{
				new ItemStack(Items.DYE,1,3),
				new ItemStack(Items.DYE,1,3),
				"listAllsugar"
				}, 1200));
		DistillationRecipes.register(
				new DistillationRecipes(
				new FluidStack(BlockLoader.VODKA_FLUID, 100),
				new FluidStack(BlockLoader.COCOA_LIQUEUR_FLUID, 100), 
				new Object[]{
				new ItemStack(Items.DYE,1,3),
				new ItemStack(Items.DYE,1,3),
				"listAllsugar"
				}, 1200));
		DistillationRecipes.register(
				new DistillationRecipes(
				new FluidStack(BlockLoader.WHISKEY_FLUID, 100),
				new FluidStack(BlockLoader.COCOA_LIQUEUR_FLUID, 100), 
				new Object[]{
				new ItemStack(Items.DYE,1,3),
				new ItemStack(Items.DYE,1,3),
				"listAllsugar"
				}, 1200));
	}
    
    public static void mortarRegister() {
    	MortarRecipes.addRecipe(new MortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.MATERIAL, 6, 43)},
    			new Object[]{
    					"cropTea",
    					"cropTea",
    					"cropTea",
    					"cropTea"
    					})
    			);
    	MortarRecipes.addRecipe(new MortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.MATERIAL, 1, 1)},
    			new ItemStack[]{
    					new ItemStack(ItemLoader.RICE_SEEDS),
    					new ItemStack(ItemLoader.RICE_SEEDS),
    					new ItemStack(ItemLoader.RICE_SEEDS),
    					new ItemStack(ItemLoader.RICE_SEEDS)
    					})
    			);
    	MortarRecipes.addRecipe(new MortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.MATERIAL, 1, 16)},
    			new ItemStack[]{
    					new ItemStack(ItemLoader.MATERIAL, 1, 1),
    					new ItemStack(ItemLoader.MATERIAL, 1, 1)
    					})
    			);
    	MortarRecipes.addRecipe(new MortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.MATERIAL, 1, 5)},
    			new Object[]{
    					"cropBuckwheat",
    					"cropBuckwheat"
    					})
    			);
    	MortarRecipes.addRecipe(new MortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.MATERIAL, 1, 4)},
    			new Object[]{
    					"cropWheat",
    					"cropWheat"
    					})
    			);
    	MortarRecipes.addRecipe(new MortarRecipes(
    			new ItemStack[]{new ItemStack(Blocks.GRAVEL),new ItemStack(ItemLoader.MATERIAL, 1, 2)},
    			new Object[]{
    					"cobblestone"
    					})
    			);
    	MortarRecipes.addRecipe(new MortarRecipes(
    			new ItemStack[]{new ItemStack(Blocks.COBBLESTONE),new ItemStack(ItemLoader.MATERIAL, 2, 35)},
    			new Object[]{
    					"stone"
    					})
    			);
    	MortarRecipes.addRecipe(new MortarRecipes(
    			new ItemStack[]{new ItemStack(Blocks.SAND),new ItemStack(Items.FLINT)},
    			new Object[]{
    					"gravel"
    					})
    			);
    	MortarRecipes.addRecipe(new MortarRecipes(
    			new ItemStack[]{new ItemStack(Items.DYE,6,2)},
    			new Object[]{
    					"treeLeaves",
    					"treeLeaves",
    					"treeLeaves",
    					"treeLeaves"
    					})
    			);
    	MortarRecipes.addRecipe(new MortarRecipes(
    			new ItemStack[]{new ItemStack(Items.BLAZE_POWDER,3),new ItemStack(Items.BLAZE_POWDER,2)},
    			new Object[]{
    					new ItemStack(Items.BLAZE_ROD)
    					})
    			);
    	MortarRecipes.addRecipe(new MortarRecipes(
    			new ItemStack[]{new ItemStack(Items.DYE,3,15),new ItemStack(Items.DYE,2,15)},
    			new Object[]{
    					"bone"
    					})
    			);

    	MortarRecipes.addRecipe(new MortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.MATERIAL,4,30)},
    			new Object[]{
    					new ItemStack(ItemLoader.FOODSET,1,4)
    					})
    			);
    	MortarRecipes.addRecipe(new MortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.MATERIAL,2,30)},
    			new Object[]{
    					"bread"
    					})
    			);
    	MortarRecipes.addRecipe(new MortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.FOODSET,6,80)},
    			new Object[]{
    					"cropPotato",
    					"listAllfishfresh",
    					"listAllfishfresh",
    					"listAllegg"
    					})
    			);
    }

    public static void potRegister() {
        PotRecipes.addRecipe(
                new PotRecipes(new ItemStack(DrinksLoader.tea, 1, 0),
                		new ItemStack(ItemLoader.cup, 1, 0),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 40),
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(new ItemStack(DrinksLoader.tea, 1, 1),
                		new ItemStack(ItemLoader.cup, 1, 0),
                        new Object[]{
                        	"cropTea"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(new ItemStack(DrinksLoader.tea, 1, 2),
                		new ItemStack(ItemLoader.cup, 1, 0),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 40),
                        		"listAllmilk"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(new ItemStack(DrinksLoader.tea, 1, 3),
                		new ItemStack(ItemLoader.cup, 1, 0),
                        new Object[]{
                        		"cropTea",
                        		"listAllmilk"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(new ItemStack(DrinksLoader.tea, 1, 4),
                		new ItemStack(ItemLoader.cup, 1, 0),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 41)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(new ItemStack(DrinksLoader.tea, 1, 5),
                		new ItemStack(ItemLoader.cup, 1, 0),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 41),
                        		"listAllmilk"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(new ItemStack(DrinksLoader.tea, 1, 6),
                		new ItemStack(ItemLoader.cup, 1, 0),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 42)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(new ItemStack(DrinksLoader.tea, 1, 7),
                		new ItemStack(ItemLoader.cup, 1, 0),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 42),
                        		"listAllmilk"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(new ItemStack(DrinksLoader.tea, 1, 8),
                		new ItemStack(ItemLoader.cup, 1, 0),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 40),
                        		"cropLemon"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(new ItemStack(DrinksLoader.tea, 1, 9),
                		new ItemStack(ItemLoader.cup, 1, 0),
                        new Object[]{
                        		"cropTea",
                        		"cropLemon"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(new ItemStack(DrinksLoader.tea, 1, 10),
                		new ItemStack(ItemLoader.cup, 1, 0),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 46)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(new ItemStack(DrinksLoader.tea, 1, 11),
                		new ItemStack(ItemLoader.cup, 1, 0),
                        new Object[]{
                        		"listAllgrain",
                        		"listAllgrain"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(new ItemStack(DrinksLoader.tea, 1, 12),
                		new ItemStack(ItemLoader.cup, 1, 0),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 44)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        
    	 PotRecipes.addRecipe(
                 new PotRecipes(
                         new ItemStack(ItemLoader.FOODSET, 1, 82),
                         "listAlltofu",
                         new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 99),
                        "listAllegg",
                        new Object[]{
                                "listAllegg",
                                "listAllsugar"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 100)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.MATERIAL, 1, 12),
                        "cropTomato",
                        new Object[]{
                        	"cropTomato",
                        	"listAllsugar"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 90),
                        "listAllbeefraw",
                        new Object[]{
                                "bamboo"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 100)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 91),
                        "listAllchickenraw",
                        new Object[]{
                                "bamboo"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 100)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 92),
                        "listAllporkraw",
                        new Object[]{
                                "bamboo"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 100)));

        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 7),
                        "cropRice",
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 10),
                        "cropRice",
                        new Object[]{
                                "listAllbeefraw"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 8),
                        "cropRice",
                        new Object[]{
                                "cropBambooshoot"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 9),
                        "cropRice",
                        new Object[]{
                                "listAllfishraw"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 11),
                        "cropRice",
                        new Object[]{
                                "listAllporkraw"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 12),
                        "cropRice",
                        new Object[]{
                                "listAllmushroom"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 13),
                        "cropRice",
                        new Object[]{
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 14),
                        "cropRice",
                        new Object[]{
                                "listAllbeefraw",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));

        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 15),
                        "cropRice",
                        new Object[]{
                                "listAllbeefraw",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 16),
                        "cropRice",
                        new Object[]{
                                new ItemStack(ItemLoader.FOODSET, 1, 6),
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 17),
                        "cropRice",
                        new Object[]{
                                "listAllchickenraw",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 18),
                        "cropRice",
                        new Object[]{
                                "listAllfishraw",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 65),
                        "cropRice",
                        new Object[]{
                        "foodNatto",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 64),
                        "cropRice",
                        new Object[]{
                        "foodNatto"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        
        //fantuan
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 42),
                        "cropRice",
                        new Object[]{
                        		"cropSeaweed"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 43),
                        "cropRice",
                        new Object[]{
                        		"cropSeaweed",
                                "cropBambooshoot"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 44),
                        "cropRice",
                        new Object[]{
                        		"cropSeaweed",
                                "listAllfishraw"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));

        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 45),
                        "cropRice",
                        new Object[]{
                        		"cropSeaweed",
                                "listAllmushroom"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 46),
                        "cropRice",
                        new Object[]{
                        		"cropSeaweed",
                                "cropSeaweed"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 47),
                        "cropRice",
                        new Object[]{
                        		"cropSeaweed",
                        		new ItemStack(ItemLoader.FOODSET, 1, 79),
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        //
        /*
         * RAMEN
         */
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 19),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 20),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllbeefraw"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 21),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 22),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 79)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 23),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 81)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 24),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 6)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 25),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllmeatraw",
                                "listAllveggie",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 93),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 62),
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 96),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 32),
                        		new ItemStack(ItemLoader.FOODSET, 1, 88),
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        /*
         * UDON
         */
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 94),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 62),
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 26),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 27),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllbeefraw"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 28),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 29),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 79)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 30),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 81)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 31),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 6)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 32),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllmeatraw",
                                "listAllveggie",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 97),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 32),
                        		new ItemStack(ItemLoader.FOODSET, 1, 88),
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        /*
         * SOBA
         */
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 95),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 62),
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 98),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 32),
                        		new ItemStack(ItemLoader.FOODSET, 1, 88),
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 34),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 35),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllbeefraw"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 36),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 37),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 79)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 38),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 81)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 39),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 6)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 40),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllmeatraw",
                                "listAllveggie",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
       
        //others
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 3),
                        new ItemStack(ItemLoader.RED_BEAN, 1),
                        new Object[]{
                                "listAllsugar",
                                "listAllsugar"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 6),
                        "listAllporkraw",
                        new Object[]{
                                "foodFlour",
                                "listAllegg",
                                "foodBreadcrumbs",
                                "dustSalt",
                                "foodBlackpepper"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 88),
                        "listAllchickencooked",
                        new Object[]{
                                "foodFlour",
                                "listAllegg",
                                "foodBreadcrumbs",
                                "dustSalt",
                                "foodBlackpepper"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 4, 62),
                        new ItemStack(ItemLoader.FOODSET, 1, 48),
                        new Object[]{
                        		 new ItemStack(ItemLoader.FOODSET, 1, 57),
                                "listAllegg",
                                "dustSalt",
                                "foodBlackpepper"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 79),
                        "foodShrimpraw",
                        new Object[]{
                        new ItemStack(ItemLoader.MATERIAL, 1, 14),
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 68),
                        "cropRice",
                        new Object[]{
                        		"listAllmeatraw",
                        		"listAllegg",
                        		"listAllveggie"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 107),
                        "cropPotato",
                        new Object[]{
                        		"dustSalt",
                        		"foodBlackpepper"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 4, 57),
                        "cropPotato",
                        new Object[]{
                        		"cropPotato",
                        		"dustSalt"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 105),
                        "cropRice",
                        new Object[]{	
                        new ItemStack(ItemLoader.FOODSET, 1, 3),
                        "dustSalt",
                        "listAllsugar"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 67),
                        "cropRice",
                        new Object[]{
                        "cropTomato",
                        "listAllmeatraw",
                        "foodKetchup"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 77),
                        "cropRice",
                        new Object[]{
                        "listAllegg",
                        "foodWhitepepper",
                        "foodSoysauce",
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 66),
                        "listAllbeefraw",
                        new Object[]{
                        "cropPotato",
                        "cropCarrot",
                        "foodSoysauce",
                        "listAllsugar"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 74),
                        new ItemStack(ItemLoader.FOODSET, 1, 59),
                        new Object[]{
                        new ItemStack(ItemLoader.RED_BEAN, 1)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 83),
                        "stickWood",
                        new Object[]{
                        new ItemStack(ItemLoader.FOODSET, 1, 80),
                        "cropRadish",
                        "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.MATERIAL, 2, 11),
                        new ItemStack(ItemLoader.MATERIAL, 1, 3),
                        new Object[]{
                        "cropOnion",
                        "cropTomato",
                        "cropPotato",
                        "cropCarrot",
                        "listAllmeatraw"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.MATERIAL, 2, 13),
                        "listAllmilk",
                        new Object[]{
                        "foodFlour",
                        "dustSalt",
                        "foodWhitepepper"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 110),
                        new ItemStack(ItemLoader.MATERIAL, 1, 13),
                        new Object[]{
                        "listAllchickenraw",
                        "cropCarrot",
                        "cropPotato",
                        "listAllmushroom"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 109),
                        "cropCabbage",
                        new Object[]{
                        new ItemStack(ItemLoader.FOODSET, 1, 48),
                        "dustSalt",
                        "foodKetchup",
                        "foodWhitepepper"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 108),
                        "cropRadish",
                        new Object[]{
                        new ItemStack(ItemLoader.MATERIAL, 1, 29),
                        "dustSalt"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 103),
                        "listAllmilk",
                        new Object[]{
                        "listAllsugar",
                        "listAllegg",
                        "foodVanilla"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 104),
                        "listAllmilk",
                        new Object[]{
                        "listAllsugar",
                        "listAllegg",
                        "foodVanilla",
                        "cropMaplesyrup"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 106),
                        "listAllfishfresh",
                        new Object[]{
                        "foodSoysauce",
                        "listAllsugar",
                        "dustSalt"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));

        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.MATERIAL, 2, 32),
                        "foodSoysauce",
                        new Object[]{
                                "listAllsugar",
                                "dustSalt"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
		PotRecipes.addRecipe(
				new PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 2, 111),
						new ItemStack(Items.APPLE),
						new Object[]{
								"listAllsugar",
								"listAllfruit"
						},
						new FluidStack(FluidRegistry.WATER, 100)));
		PotRecipes.addRecipe(
				new PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 2, 111),
						new ItemStack(Items.CHORUS_FRUIT),
						new Object[]{
								"listAllsugar",
								"listAllfruit"
						},
						new FluidStack(FluidRegistry.WATER, 100)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 47),
                        "cropRice",
                        new Object[]{
                        		"cropSeaweed",
                        		new ItemStack(ItemLoader.FOODSET, 1, 79),
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 84),
                        new ItemStack(ItemLoader.FOODSET, 1, 7),
                        new Object[]{
                        		"bamboo",
                        		new ItemStack(ItemLoader.FOODSET, 1, 3),
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 85),
                        new ItemStack(ItemLoader.FOODSET, 1, 7),
                        new Object[]{
                        		"bamboo",
                        		"listAllsugar",
                        		"listAllsugar"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        PotRecipes.addRecipe(
                new PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 86),
                        new ItemStack(ItemLoader.FOODSET, 1, 7),
                        new Object[]{
                        		"bamboo",
                        		"listAllsugar",
                        		 new ItemStack(BlockLoader.SAKURA_LEAVES),
                        		 new ItemStack(Blocks.TALLGRASS)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
    }

}
