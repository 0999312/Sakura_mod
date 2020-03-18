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
import cn.mcmod_mmf.mmlib.util.RecipesUtil;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import net.dries007.tfc.objects.fluids.FluidsTFC;
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
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.BEER_FLUID, 1000)), new FluidStack(BlockLoader.BEER_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.DOBUROKU_FLUID, 1000)), new FluidStack(BlockLoader.DOBUROKU_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.SAKE_FLUID, 1000)), new FluidStack(BlockLoader.SAKE_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.SHOUCHU_FLUID, 1000)), new FluidStack(BlockLoader.SHOUCHU_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.RED_WINE_FLUID, 1000)), new FluidStack(BlockLoader.RED_WINE_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.WHITE_WINE_FLUID, 1000)), new FluidStack(BlockLoader.WHITE_WINE_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.CHAMPAGNE_FLUID, 1000)), new FluidStack(BlockLoader.CHAMPAGNE_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.RUM_FLUID, 1000)), new FluidStack(BlockLoader.RUM_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.VODKA_FLUID, 1000)), new FluidStack(BlockLoader.VODKA_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.BRANDY_FLUID, 1000)), new FluidStack(BlockLoader.BRANDY_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.WHISKEY_FLUID, 1000)), new FluidStack(BlockLoader.WHISKEY_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.YEAST_FLUID, 1000)), new FluidStack(BlockLoader.YEAST_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.LIQUEUR_FLUID, 1000)), new FluidStack(BlockLoader.LIQUEUR_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(Items.BUCKET), FluidUtil.getFilledBucket(new FluidStack(BlockLoader.COCOA_LIQUEUR_FLUID, 1000)), new FluidStack(BlockLoader.COCOA_LIQUEUR_FLUID, 1000));
		
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,0), new FluidStack(BlockLoader.BEER_FLUID, 400));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,1), new FluidStack(BlockLoader.DOBUROKU_FLUID, 200));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,2), new FluidStack(BlockLoader.SAKE_FLUID, 200));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,3), new FluidStack(BlockLoader.SHOUCHU_FLUID, 200));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,4), new FluidStack(BlockLoader.RED_WINE_FLUID, 200));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,5), new FluidStack(BlockLoader.WHITE_WINE_FLUID, 200));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,6), new FluidStack(BlockLoader.CHAMPAGNE_FLUID, 200));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,7), new FluidStack(BlockLoader.RUM_FLUID, 200));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,8), new FluidStack(BlockLoader.VODKA_FLUID, 200));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,9), new FluidStack(BlockLoader.WHISKEY_FLUID, 200));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,10), new FluidStack(BlockLoader.BRANDY_FLUID, 200));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,13), new FluidStack(BlockLoader.LIQUEUR_FLUID, 200));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.cup,1,0), new ItemStack(DrinksLoader.alcoholic,1,14), new FluidStack(BlockLoader.COCOA_LIQUEUR_FLUID, 200));
	
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,0), new FluidStack(BlockLoader.BEER_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,1), new FluidStack(BlockLoader.DOBUROKU_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,2), new FluidStack(BlockLoader.SAKE_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,3), new FluidStack(BlockLoader.SHOUCHU_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,4), new FluidStack(BlockLoader.RED_WINE_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,5), new FluidStack(BlockLoader.WHITE_WINE_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,6), new FluidStack(BlockLoader.CHAMPAGNE_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,7), new FluidStack(BlockLoader.RUM_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,8), new FluidStack(BlockLoader.VODKA_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,9), new FluidStack(BlockLoader.WHISKEY_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,10), new FluidStack(BlockLoader.BRANDY_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,13), new FluidStack(BlockLoader.LIQUEUR_FLUID, 1000));
		LiquidToItemRecipe.instance().addRecipes(new ItemStack(ItemLoader.MATERIAL,1,47), new ItemStack(DrinksLoader.bottle_alcoholic,1,14), new FluidStack(BlockLoader.COCOA_LIQUEUR_FLUID, 1000));
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
		BarrelRecipes.getInstance().register(
				getWater( 100),
				new FluidStack(BlockLoader.YEAST_FLUID, 50), 
				new Object[]{
				"listAllfruit",
				"listAllgrain",
				"listAllsugar"
				});
		BarrelRecipes.getInstance().register(
				getWater( 100),
				new FluidStack(BlockLoader.BEER_FLUID, 100), 
				new Object[]{
				"cropWheat",
				"foodYeast",
				"cropHops"
				});
		BarrelRecipes.getInstance().register(
				new FluidStack(BlockLoader.GRAPE_FLUID, 100),
				new FluidStack(BlockLoader.RED_WINE_FLUID, 50), 
				new Object[]{
				"listAllsugar",	
				"foodYeast"
				});
		BarrelRecipes.getInstance().register(
				new FluidStack(BlockLoader.GREEN_GRAPE_FLUID, 100),
				new FluidStack(BlockLoader.WHITE_WINE_FLUID, 50), 
				new Object[]{
				"listAllsugar",	
				"foodYeast"
				});
		BarrelRecipes.getInstance().register(
				new FluidStack(BlockLoader.WHITE_WINE_FLUID, 100),
				new FluidStack(BlockLoader.CHAMPAGNE_FLUID, 50), 
				new Object[]{
				"listAllsugar",		
				"foodYeast"
				});
		BarrelRecipes.getInstance().register(
				getWater( 100),
				new FluidStack(BlockLoader.DOBUROKU_FLUID, 50), 
				new Object[]{
				new ItemStack(ItemLoader.FOODSET,1,7),
				"foodYeast"
				});
		BarrelRecipes.getInstance().register(
				new FluidStack(BlockLoader.DOBUROKU_FLUID, 100),
				new FluidStack(BlockLoader.SAKE_FLUID, 50));
		DistillationRecipes.getInstance().register(
				new FluidStack(BlockLoader.SAKE_FLUID, 100),
				new FluidStack(BlockLoader.SHOUCHU_FLUID, 50));
		DistillationRecipes.getInstance().register(
				getWater( 100),
				new FluidStack(BlockLoader.WHISKEY_FLUID, 50), 
				new Object[]{
				"listAllgrain",
				"listAllgrain",
				"listAllgrain"
				});
		DistillationRecipes.getInstance().register(
				new FluidStack(BlockLoader.RED_WINE_FLUID, 100),
				new FluidStack(BlockLoader.BRANDY_FLUID, 50), 
				new Object[]{
				"listAllsugar"
				});
		DistillationRecipes.getInstance().register(
				new FluidStack(BlockLoader.GREEN_GRAPE_FLUID, 100),
				new FluidStack(BlockLoader.BRANDY_FLUID, 50), 
				new Object[]{
				"listAllsugar"
				});
		DistillationRecipes.getInstance().register(
				getWater( 100),
				new FluidStack(BlockLoader.VODKA_FLUID, 50), 
				new Object[]{
				"cropPotato",
				"cropPotato",
				"cropPotato"
				});
		DistillationRecipes.getInstance().register(
				getWater( 100),
				new FluidStack(BlockLoader.RUM_FLUID, 50), 
				new Object[]{
				"sugarcane",
				"sugarcane",
				"sugarcane"
				});
		DistillationRecipes.getInstance().register(
				new FluidStack(BlockLoader.RUM_FLUID, 100),
				new FluidStack(BlockLoader.LIQUEUR_FLUID, 100), 
				new Object[]{
				"listAllfruit",
				"listAllfruit",
				"listAllsugar"
				});
		DistillationRecipes.getInstance().register(
				new FluidStack(BlockLoader.VODKA_FLUID, 100),
				new FluidStack(BlockLoader.LIQUEUR_FLUID, 100), 
				new Object[]{
				"listAllfruit",
				"listAllfruit",
				"listAllsugar"
				});
		DistillationRecipes.getInstance().register(
				new FluidStack(BlockLoader.WHISKEY_FLUID, 100),
				new FluidStack(BlockLoader.LIQUEUR_FLUID, 100), 
				new Object[]{
				"listAllfruit",
				"listAllfruit",
				"listAllsugar"
				});
		
		DistillationRecipes.getInstance().register(
				new FluidStack(BlockLoader.RUM_FLUID, 100),
				new FluidStack(BlockLoader.COCOA_LIQUEUR_FLUID, 100), 
				new Object[]{
				new ItemStack(Items.DYE,1,3),
				new ItemStack(Items.DYE,1,3),
				"listAllsugar"
				});
		DistillationRecipes.getInstance().register(
				new FluidStack(BlockLoader.VODKA_FLUID, 100),
				new FluidStack(BlockLoader.COCOA_LIQUEUR_FLUID, 100), 
				new Object[]{
				new ItemStack(Items.DYE,1,3),
				new ItemStack(Items.DYE,1,3),
				"listAllsugar"
				});
		DistillationRecipes.getInstance().register(
				new FluidStack(BlockLoader.WHISKEY_FLUID, 100),
				new FluidStack(BlockLoader.COCOA_LIQUEUR_FLUID, 100), 
				new Object[]{
				new ItemStack(Items.DYE,1,3),
				new ItemStack(Items.DYE,1,3),
				"listAllsugar"
				});
	}
    
    public static void mortarRegister() {
    	MortarRecipes.instance().addMortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.MATERIAL, 6, 43)},
    			new Object[]{
    					"cropTea",
    					"cropTea",
    					"cropTea",
    					"cropTea"
    					});
    	MortarRecipes.instance().addMortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.MATERIAL, 1, 1)},
    			new ItemStack[]{
    					new ItemStack(ItemLoader.RICE_SEEDS),
    					new ItemStack(ItemLoader.RICE_SEEDS),
    					new ItemStack(ItemLoader.RICE_SEEDS),
    					new ItemStack(ItemLoader.RICE_SEEDS)
    					});
    	MortarRecipes.instance().addMortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.MATERIAL, 1, 16)},
    			new ItemStack[]{
    					new ItemStack(ItemLoader.MATERIAL, 1, 1),
    					new ItemStack(ItemLoader.MATERIAL, 1, 1)
    					});
    	MortarRecipes.instance().addMortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.MATERIAL, 1, 5)},
    			new Object[]{
    					"cropBuckwheat",
    					"cropBuckwheat"
    					});
    	MortarRecipes.instance().addMortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.MATERIAL, 1, 4)},
    			new Object[]{
    					"cropWheat",
    					"cropWheat"
    					});
    	MortarRecipes.instance().addMortarRecipes(
    			new ItemStack[]{new ItemStack(Blocks.GRAVEL),new ItemStack(ItemLoader.MATERIAL, 1, 2)},
    			new Object[]{
    					"cobblestone"
    					});
    	MortarRecipes.instance().addMortarRecipes(
    			new ItemStack[]{new ItemStack(Blocks.COBBLESTONE),new ItemStack(ItemLoader.MATERIAL, 2, 35)},
    			new Object[]{
    					"stone"
    					});
    	MortarRecipes.instance().addMortarRecipes(
    			new ItemStack[]{new ItemStack(Blocks.SAND),new ItemStack(Items.FLINT)},
    			new Object[]{
    					"gravel"
    					});
    	MortarRecipes.instance().addMortarRecipes(
    			new ItemStack[]{new ItemStack(Items.DYE,6,2)},
    			new Object[]{
    					"treeLeaves",
    					"treeLeaves",
    					"treeLeaves",
    					"treeLeaves"
    					});
    	MortarRecipes.instance().addMortarRecipes(
    			new ItemStack[]{new ItemStack(Items.BLAZE_POWDER,3),new ItemStack(Items.BLAZE_POWDER,2)},
    			new Object[]{
    					new ItemStack(Items.BLAZE_ROD)
    					});
    	MortarRecipes.instance().addMortarRecipes(
    			new ItemStack[]{new ItemStack(Items.DYE,3,15),new ItemStack(Items.DYE,2,15)},
    			new Object[]{
    					"bone"
    					});

    	MortarRecipes.instance().addMortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.MATERIAL,4,30)},
    			new Object[]{
    					new ItemStack(ItemLoader.FOODSET,1,4)
    					});
    	MortarRecipes.instance().addMortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.MATERIAL,2,30)},
    			new Object[]{
    					"bread"
    					});

    	MortarRecipes.instance().addMortarRecipes(
    			new ItemStack[]{new ItemStack(ItemLoader.FOODSET,6,80)},
    			new Object[]{
    					"cropPotato",
    					"listAllfishfresh",
    					"listAllfishfresh",
    					"listAllegg"
    					});
    }

    public static void potRegister() {
        PotRecipes.getInstance().addRecipes(new ItemStack(ItemLoader.FOODSET, 2, 129),
                new Object[]{
                		"listAllegg",
                		"listAllegg",
                },
                getWater(200));
        PotRecipes.getInstance().addRecipes(new ItemStack(ItemLoader.FOODSET, 2, 130),
                new Object[]{
                		"listAllegg",
                		"listAllegg",
                		"foodSoysauce",
                		"listAllsugar",
                },
                getWater(200));
        PotRecipes.getInstance().addRecipes(new ItemStack(ItemLoader.FOODSET, 2, 76),
                new Object[]{
                		"foodSoysauce",
                		"listAllsugar",
                },
                getWater(200));
        PotRecipes.getInstance().addRecipes(new ItemStack(ItemLoader.FOODSET, 1, 126),
                new Object[]{
                		"foodPasta",
                		"foodKetchup"
                },
                getWater( 200));
        PotRecipes.getInstance().addRecipes(new ItemStack(ItemLoader.FOODSET, 1, 127),
                new Object[]{
                		"foodPasta",
                		"listAllmushroom",
                		"listAllmushroom"
                },
                getWater( 200));
        PotRecipes.getInstance().addRecipes(new ItemStack(ItemLoader.FOODSET, 1, 128),
                new Object[]{
                		"foodPasta",
                		 new ItemStack(ItemLoader.MATERIAL, 1, 13)
                },
                getWater( 200));
        PotRecipes.getInstance().addRecipes(new ItemStack(DrinksLoader.tea, 1, 0),
                        new Object[]{
                        		new ItemStack(ItemLoader.cup, 1, 0),
                        		new ItemStack(ItemLoader.MATERIAL, 1, 40),
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(new ItemStack(DrinksLoader.tea, 1, 1),
                        new Object[]{
                        	new ItemStack(ItemLoader.cup, 1, 0),
                        	"cropTea"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(new ItemStack(DrinksLoader.tea, 1, 2),
                        new Object[]{
                        		new ItemStack(ItemLoader.cup, 1, 0),
                        		new ItemStack(ItemLoader.MATERIAL, 1, 40),
                        		"listAllmilk"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(new ItemStack(DrinksLoader.tea, 1, 3),
                        new Object[]{
                        		new ItemStack(ItemLoader.cup, 1, 0),
                        		"cropTea",
                        		"listAllmilk"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(new ItemStack(DrinksLoader.tea, 1, 4),
                        new Object[]{
                        		new ItemStack(ItemLoader.cup, 1, 0),
                        		new ItemStack(ItemLoader.MATERIAL, 1, 41)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(new ItemStack(DrinksLoader.tea, 1, 5),
                        new Object[]{
                        		new ItemStack(ItemLoader.cup, 1, 0),
                        		new ItemStack(ItemLoader.MATERIAL, 1, 41),
                        		"listAllmilk"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(new ItemStack(DrinksLoader.tea, 1, 6),
                        new Object[]{
                        		new ItemStack(ItemLoader.cup, 1, 0),
                        		new ItemStack(ItemLoader.MATERIAL, 1, 42)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(new ItemStack(DrinksLoader.tea, 1, 7),
                        new Object[]{
                        		new ItemStack(ItemLoader.cup, 1, 0),
                        		new ItemStack(ItemLoader.MATERIAL, 1, 42),
                        		"listAllmilk"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(new ItemStack(DrinksLoader.tea, 1, 8),
                        new Object[]{
                        		new ItemStack(ItemLoader.cup, 1, 0),
                        		new ItemStack(ItemLoader.MATERIAL, 1, 40),
                        		"cropLemon"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(new ItemStack(DrinksLoader.tea, 1, 9),
                        new Object[]{
                        		new ItemStack(ItemLoader.cup, 1, 0),
                        		"cropTea",
                        		"cropLemon"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(new ItemStack(DrinksLoader.tea, 1, 10),
                        new Object[]{
                        		new ItemStack(ItemLoader.cup, 1, 0),
                        		new ItemStack(ItemLoader.MATERIAL, 1, 46)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(new ItemStack(DrinksLoader.tea, 1, 11),
                        new Object[]{
                        		new ItemStack(ItemLoader.cup, 1, 0),
                        		"listAllgrain",
                        		"listAllgrain"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(new ItemStack(DrinksLoader.tea, 1, 12),
                        new Object[]{
                        		new ItemStack(ItemLoader.cup, 1, 0),
                        		new ItemStack(ItemLoader.MATERIAL, 1, 44)
                        },
                        getWater( 200));
        
    	 PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 82),
                        new Object[]{"listAlltofu"},
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 99),
                        new Object[]{
                        		"listAllegg",
                                "listAllegg",
                                "listAllsugar"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 100));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.MATERIAL, 1, 12),
                        new Object[]{
                        	"cropTomato",
                        	"cropTomato",
                        	"listAllsugar"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 90),
                        new Object[]{
                        		"listAllbeefraw",
                                "bamboo"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 100));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 91),
                        new Object[]{
                        		"listAllchickenraw",
                                "bamboo"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 100));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 92),
                        new Object[]{
                                "listAllporkraw",
                                "bamboo"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 100));

        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 7),
                        new Object[]{
                        		"cropRice"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 10),
                        new Object[]{
                        		"cropRice",
                                "listAllbeefraw"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 8),
                        new Object[]{
                    		"cropRice",
                            "cropBambooshoot"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 9),
                        new Object[]{
                    		"cropRice",
                            "listAllfishraw"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 11),
                        new Object[]{
                    		"cropRice",
                            "listAllporkraw"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 12),
                        new Object[]{
                    		"cropRice",
                            "listAllmushroom"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 13),
                        new Object[]{
                    		"cropRice",
                            "listAllegg"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 14),
                        new Object[]{
                    		"cropRice",
                            "listAllbeefraw",
                            "listAllegg"
                        },
                        getWater( 200));

        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 15),
                        new Object[]{
                    		"cropRice",
                            "listAllporkraw",
                            "listAllegg"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 16),
                        new Object[]{
                    		"cropRice",
                            new ItemStack(ItemLoader.FOODSET, 1, 6),
                            "listAllegg"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 17),
                        new Object[]{
                    		"cropRice",
                            "listAllchickenraw",
                            "listAllegg"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 18),
                        new Object[]{
                    		"cropRice",
                            "listAllfishraw",
                            "listAllegg"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 65),
                        new Object[]{
                    		"cropRice",
                    		"foodNatto",
                            "listAllegg"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 64),
                        new Object[]{
                        	"cropRice",
                        	"foodNatto"
                        },
                        getWater( 200));
        
        //fantuan
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 42),
                        new Object[]{
                        		"cropRice",
                        		"cropSeaweed"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 43),
                        new Object[]{
                        		"cropRice",
                        		"cropSeaweed",
                                "cropBambooshoot"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 44),
                        new Object[]{
                        		"cropRice",
                        		"cropSeaweed",
                                "listAllfishraw"
                        },
                        getWater( 200));

        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 45),
                        new Object[]{
                        		"cropRice",
                        		"cropSeaweed",
                                "listAllmushroom"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 46),
                        new Object[]{
                        		"cropRice",
                        		"cropSeaweed",
                                "cropSeaweed"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 47),
                        new Object[]{
                        		"cropRice",
                        		"cropSeaweed",
                        		new ItemStack(ItemLoader.FOODSET, 1, 79),
                        },
                        getWater( 200));
        //
        /*
         * RAMEN
         */
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 19),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 8),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 20),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 8),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllbeefraw"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 21),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 8),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllegg"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 22),
                        new Object[]{
                        		 new ItemStack(ItemLoader.MATERIAL, 1, 8),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 79)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 23),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 8),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 81)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 24),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 8),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 6)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 25),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 8),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllmeatraw",
                                "listAllveggie",
                                "listAllegg"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 93),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 8),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 62),
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 96),
                        new Object[]{
                        		new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        		new ItemStack(ItemLoader.MATERIAL, 1, 32),
                        		new ItemStack(ItemLoader.FOODSET, 1, 88),
                        },
                        getWater( 200));
        /*
         * UDON
         */
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 94),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 9),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 62),
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 26),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 9),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 27),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 9),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllbeefraw"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 28),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 9),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllegg"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 29),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 9),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 79)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 30),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 9),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 81)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 31),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 9),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 6)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 32),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 9),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllmeatraw",
                                "listAllveggie",
                                "listAllegg"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 97),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        		new ItemStack(ItemLoader.MATERIAL, 1, 32),
                        		new ItemStack(ItemLoader.FOODSET, 1, 88),
                        },
                        getWater( 200));
        /*
         * SOBA
         */
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 95),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 10),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 62),
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 98),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        		new ItemStack(ItemLoader.MATERIAL, 1, 32),
                        		new ItemStack(ItemLoader.FOODSET, 1, 88),
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 34),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 10),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 35),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 10),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllbeefraw"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 36),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 10),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllegg"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 37),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 10),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 79)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 38),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 10),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 81)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 39),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 10),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 6)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 40),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 10),
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllmeatraw",
                                "listAllveggie",
                                "listAllegg"
                        },
                        getWater( 200));
       
        //others
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 3),
                        new Object[]{
                                new ItemStack(ItemLoader.RED_BEAN, 1),
                                "listAllsugar",
                                "listAllsugar"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 6),
                        new Object[]{
                                "listAllporkraw",
                                "foodFlour",
                                "listAllegg",
                                "foodBreadcrumbs",
                                "dustSalt",
                                "foodBlackpepper"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 3, 88),
                        new Object[]{
                                "listAllchickencooked",
                                "foodFlour",
                                "listAllegg",
                                "foodBreadcrumbs",
                                "dustSalt",
                                "foodBlackpepper"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 4, 62),
                        new Object[]{
                                new ItemStack(ItemLoader.FOODSET, 1, 48),
                        		new ItemStack(ItemLoader.FOODSET, 1, 57),
                                "listAllegg",
                                "dustSalt",
                                "foodBlackpepper"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 79),
                        new Object[]{
                                "foodShrimpraw",
                                new ItemStack(ItemLoader.MATERIAL, 1, 14),
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 68),
                        new Object[]{
                                "cropRice",
                        		"listAllmeatraw",
                        		"listAllegg",
                        		"listAllveggie"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 107),
                        new Object[]{
                                "cropPotato",
                        		"dustSalt",
                        		"foodBlackpepper"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 4, 57),
                        new Object[]{
                                "cropPotato",
                        		"cropPotato",
                        		"dustSalt"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 105),
                        new Object[]{
                                "cropRice",
                                new ItemStack(ItemLoader.FOODSET, 1, 3),
                                "dustSalt",
                                "listAllsugar"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 67),
                        new Object[]{
                                "cropRice",
			                    "cropTomato",
			                    "listAllmeatraw",
			                    "foodKetchup"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 77),
                        new Object[]{
                                "cropRice",
                        "listAllegg",
                        "foodWhitepepper",
                        "foodSoysauce",
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 66),
                        new Object[]{
                                "listAllbeefraw",
                                "cropPotato",
                                "cropCarrot",
                                "foodSoysauce",
                                "listAllsugar"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 74),
                        new Object[]{
                                new ItemStack(ItemLoader.FOODSET, 1, 59),
                                new ItemStack(ItemLoader.RED_BEAN, 1)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 83),
                        new Object[]{
                        "stickWood",
                        new ItemStack(ItemLoader.FOODSET, 1, 80),
                        "cropRadish",
                        "listAllegg"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.MATERIAL, 2, 11),
                        new Object[]{
                        new ItemStack(ItemLoader.MATERIAL, 1, 3),
                        "cropOnion",
                        "cropTomato",
                        "cropPotato",
                        "cropCarrot",
                        "listAllmeatraw"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.MATERIAL, 2, 13),
                        new Object[]{
                        "listAllmilk",
                        "foodFlour",
                        "dustSalt",
                        "foodWhitepepper"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 110),
                        new Object[]{
                        new ItemStack(ItemLoader.MATERIAL, 1, 13),
                        "listAllchickenraw",
                        "cropCarrot",
                        "cropPotato",
                        "listAllmushroom"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 109),
                        new Object[]{
                        "cropCabbage",
                        new ItemStack(ItemLoader.FOODSET, 1, 48),
                        "dustSalt",
                        "foodKetchup",
                        "foodWhitepepper"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 108),
                        new Object[]{
                        "cropRadish",
                        new ItemStack(ItemLoader.MATERIAL, 1, 29),
                        "dustSalt"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 103),
                        new Object[]{
                        "listAllmilk",
                        "listAllsugar",
                        "listAllegg",
                        "foodVanilla"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 104),
                        new Object[]{
                        "listAllmilk",
                        "listAllsugar",
                        "listAllegg",
                        "foodVanilla",
                        "cropMaplesyrup"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 106),
                        new Object[]{
                        "listAllfishfresh",		
                        "foodSoysauce",
                        "listAllsugar",
                        "dustSalt"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200));

        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.MATERIAL, 2, 32),
                        new Object[]{
                                "foodSoysauce",
                                "listAllsugar",
                                "dustSalt"
                        },
                        getWater( 200));
		PotRecipes.getInstance().addRecipes(
						new ItemStack(ItemLoader.FOODSET, 2, 111),
						new Object[]{
								new ItemStack(Items.APPLE),
								"listAllsugar",
								"listAllfruit"
						},
						getWater( 100));
		PotRecipes.getInstance().addRecipes(
						new ItemStack(ItemLoader.FOODSET, 2, 111),
						new Object[]{
								new ItemStack(Items.CHORUS_FRUIT),
								"listAllsugar",
								"listAllfruit"
						},
						getWater( 100));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 47),
                        new Object[]{
                                "cropRice",
                        		"cropSeaweed",
                        		new ItemStack(ItemLoader.FOODSET, 1, 79),
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 84),
                        new Object[]{
                                new ItemStack(ItemLoader.FOODSET, 1, 7),
                        		"bamboo",
                        		new ItemStack(ItemLoader.FOODSET, 1, 3),
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 85),
                        new Object[]{
                                new ItemStack(ItemLoader.FOODSET, 1, 7),
                        		"bamboo",
                        		"listAllsugar",
                        		"listAllsugar"
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 86),
                        new Object[]{
                                new ItemStack(ItemLoader.FOODSET, 1, 7),
                        		"bamboo",
                        		"listAllsugar",
                        		 new ItemStack(BlockLoader.SAKURA_LEAVES),
                        		 new ItemStack(Blocks.TALLGRASS,1,1)
                        },
                        getWater( 200));
        PotRecipes.getInstance().addRecipes(
		                new ItemStack(ItemLoader.FOODSET, 2, 86),
		                new Object[]{
		                        new ItemStack(ItemLoader.FOODSET, 1, 7),
		                		"bamboo",
		                		"listAllsugar",
		                		 new ItemStack(BlockLoader.SAKURA_LEAVES),
		                		 new ItemStack(Blocks.TALLGRASS,1,2)
		                },
		                getWater( 200));
    }
    private static FluidStack getWater(int amount){
    	if(Loader.isModLoaded("tfc"))
    		return new FluidStack(FluidsTFC.FRESH_WATER.get(), amount);
		return new FluidStack(FluidRegistry.WATER, amount);
    }
}
