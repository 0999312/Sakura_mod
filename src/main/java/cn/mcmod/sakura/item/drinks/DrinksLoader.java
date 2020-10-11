package cn.mcmod.sakura.item.drinks;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.potion.PotionLoader;
import cn.mcmod_mmf.mmlib.item.ItemMetaDurability;
import cn.mcmod_mmf.mmlib.item.food.FoodInfo;
import cn.mcmod_mmf.mmlib.item.food.ItemDrinkBase;
import cn.mcmod_mmf.mmlib.register.ItemRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DrinksLoader {
	private static final DrinksLoader instance = new DrinksLoader();
	
    public static ItemDrinkBase tea = new ItemDrinkBase(SakuraMain.MODID,"tea",
    		new FoodInfo[]{
    			new FoodInfo("black_tea", 1, 0.5F, false, 50F, 0, 0, 1F, 0, 0, 5F, 0, 0),
    			new FoodInfo("green_tea", 1, 0.5F, false, 50F, 0, 0, 1F, 0, 0, 5F, 0, 0),		
    			new FoodInfo("milk_tea", 1, 0.5F, false, 50F, 0, 0, 1F, 0, 1F, 5F, 0, 0),
    			new FoodInfo("milk_green_tea", 1, 0.5F, false, 50F, 0, 0, 1F, 0, 1F, 5F, 0, 0),
    			new FoodInfo("earl_grey", 1, 0.5F, false, 50F, 0, 0, 2F, 0, 0, 5F, 0, 0),
    			new FoodInfo("milk_earl_grey", 1, 0.5F, false, 50F, 0, 0, 2F, 0, 2F, 5F, 0, 0),	
    			new FoodInfo("fruit_tea", 1, 0.5F, false, 50F, 0, 2F, 2F, 0, 0, 5F, 0, 0),
    			new FoodInfo("milk_fruit_tea", 1, 0.5F, false, 50F, 0, 2F, 2F, 0, 2F, 5F, 0, 0),
    			new FoodInfo("lemon_black_tea", 1, 0.5F, false, 50F, 0, 2F, 2F, 0f, 0, 5F, 0, 0),
    			new FoodInfo("lemon_green_tea", 1, 0.5F, false, 50F, 0, 2F, 2F, 0f, 0, 5F, 0, 0),
    			new FoodInfo("mint_tea", 1, 0.5F, false, 50F, 0, 0F, 3F, 0f, 0, 5F, 0, 0),		
    			new FoodInfo("barley_tea", 1, 0.5F, false, 50F, 1f, 0, 2F, 0f, 0, 5F, 0, 0),
    			new FoodInfo("brown_rice_tea", 1, 0.5F, false, 50F, 1f, 0, 2F, 0f, 0, 5F, 0, 0),
    		},
    		new PotionEffect[][]{
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "instant_health")), 1, 0)		
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 600, 0)		
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "instant_health")), 1, 0),		
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "regeneration")), 200, 0)		
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 600, 0),
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "regeneration")), 200, 0)	
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "water_breathing")), 600, 0)		
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "water_breathing")), 1200, 1)		
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "jump_boost")), 600, 0)		
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "jump_boost")), 600, 0),
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "regeneration")), 200, 0)	
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "instant_health")), 1, 0),	
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "speed")), 400, 0)		
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 600, 0),	
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "speed")), 400, 0)				
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "night_vision")), 600, 0)		
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "resistance")), 600, 0)		
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "resistance")), 600, 0)		
	    		},
    		}, new ItemStack(ItemLoader.cup,1,0)
    );
    public static DrinksAlcoholic alcoholic = new DrinksAlcoholic("alcoholic",
    		new FoodInfo[]{
    			new FoodInfo("glass_beer", 2, 0.5F, false, 50F, 2F, 0, 0, 0, 0, 0, 0, 0),
    			new FoodInfo("glass_doburoku", 2, 0.5F, false, 50F, 2F, 0, 0, 0, 0, 0, 0, 0),
    			new FoodInfo("glass_sake", 2, 0.5F, false, 50F, 2F, 0, 0, 0, 0, 0, 0, 0),
    			new FoodInfo("glass_shouchu", 2, 0.5F, false, 50F, 2F, 0, 0, 0, 0, 0, 0, 0),
    			new FoodInfo("glass_red_wine", 2, 0.5F, false, 50F, 2F, 0, 0, 0, 0, 0, 0, 0),
    			new FoodInfo("glass_white_wine", 2, 0.5F, false, 50F, 2F, 0, 0, 0, 0, 0, 0, 0),
    			new FoodInfo("glass_champagne", 2, 0.5F, false, 50F, 2F, 0, 0, 0, 0, 0, 0, 0),
    			new FoodInfo("glass_rum", 2, 0.5F, false, 50F, 2F, 0, 0, 0, 0, 0, 0, 0),
    			new FoodInfo("glass_vodka", 2, 0.5F, false, 50F, 2F, 0, 0, 0, 0, 0, 0, 0),
    			new FoodInfo("glass_whiskey", 2, 0.5F, false, 50F, 2F, 0, 0, 0, 0, 0, 0, 0),
    			new FoodInfo("glass_brandy", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
    			new FoodInfo("glass_gin", 2, 0.5F, false, 50F, 2F, 0, 0, 0, 0, 0, 0, 0),
    			new FoodInfo("glass_tequila", 2, 0.5F, false, 50F, 2F, 0, 0, 0, 0, 0, 0, 0),
    			new FoodInfo("glass_liqueur", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
    			new FoodInfo("glass_cocoa_liqueur", 2, 0.5F, false, 5F, 2F, 1F, 0, 0F, 0, 0, 0, 0),
    		},
    		new PotionEffect[][]{
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "saturation")), 200, 0)		
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "resistance")), 200, 0)		
	    		},
	    		new PotionEffect[]{
		    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "resistance")), 400, 0),		
		    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "regeneration")), 100, 0)		
	    		},
	    		new PotionEffect[]{
    	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "resistance")), 600, 0),		
    	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "regeneration")), 200, 0)	
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "night_vision")), 400, 0)		
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "night_vision")), 400, 0)		
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "night_vision")), 600, 1)		
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "water_breathing")), 400, 0)	
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "strength")), 400, 0)		
	    		},
	    		new PotionEffect[]{
	    	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 400, 0)
		    	},
	    		new PotionEffect[]{
	    	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 400, 0)	
		    	},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 400, 0)	
	    		},
	    		new PotionEffect[]{	
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "fire_resistance")), 400, 0)		
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "jump_boost")), 400, 0)		
	    		},
	    		new PotionEffect[]{
	    		new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "jump_boost")), 400, 0),	
	    		}
    		}
    );
    public static DrinksAlcoholic cocktail = new DrinksAlcoholic("cocktail",
    		new FoodInfo[]{
				new FoodInfo("glass_kir", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_royal_kir", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_margarita", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_paradise", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_sidecar", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_french_sevenfive", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_john_collins", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_daiquiri", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_between_the_sheets", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_black_russian", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_godfather", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_godmother", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				
				new FoodInfo("glass_grasshopper", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				
				new FoodInfo("glass_mint_julep", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_mojito", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_rusty_nail", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_lemon_margarita", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_russian_spring", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_alexander", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_aviation", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_porto_flip", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_red_eyes", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_spritzer", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_panache", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_bloody_mary", 2, 0.5F, false, 50F, 2F, 1F, 1F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_screw_driver", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_saketini", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_boilermaker", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_beer_margarita", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_long_island_iced_tea", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_highball", 2, 0.5F, false, 50F, 2F, 0, 0,1F, 0, 0, 0, 0),
				new FoodInfo("glass_porchcrawler", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_stinger", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_negroni", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_old_fashioned", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_whiskey_sour", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_gimlet", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_tequila_sunrise", 2, 0.5F, false, 50F, 2F, 0, 0,1F, 0, 0, 0, 0),
				new FoodInfo("glass_flying_grasshopper", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_eggnog", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 1F, 0, 0, 0),
				new FoodInfo("glass_scorpion", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
				new FoodInfo("glass_moscow_mule", 2, 0.5F, false, 50F, 2F, 1F, 0F, 0F, 0, 0, 0, 0),
    		},
    		new PotionEffect[][]{
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "night_vision")), 200, 0),		
	    			new PotionEffect(PotionLoader.exp_up, 200, 0),
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "night_vision")), 400, 1),		
	    			new PotionEffect(PotionLoader.exp_up, 200, 0),
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "fire_resistance")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "speed")), 200, 0),		
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "instant_health")), 2, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "regeneration")), 100, 0),
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 200, 0),		
	    			new PotionEffect(PotionLoader.golden_heart, 2, 0),
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(PotionLoader.cannon, 200, 0),
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "resistance")), 200, 0),		
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "water_breathing")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "resistance")), 200, 0)
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 200, 0),		
	    			new PotionEffect(PotionLoader.fire_blade, 200, 0),
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "strength")), 200, 0),		
	    			new PotionEffect(PotionLoader.fire_blade, 200, 0),
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 200, 0),		
	    			new PotionEffect(PotionLoader.exp_up, 200, 0),
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "strength")), 200, 0),		
	    			new PotionEffect(PotionLoader.exp_up, 200, 0),
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "jump_boost")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "speed")), 200, 0),		
	    		},
	    		new PotionEffect[]{
    				new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "speed")), 200, 0),		
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "speed")), 200, 0),	
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "night_vision")), 200, 0),		
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "luck")), 200, 0)
	    		},
	    		
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "fire_resistance")), 400, 1),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "speed")), 400, 1),		
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "strength")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "resistance")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "regeneration")), 200, 0),
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "regeneration")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "hunger")), 200, 1),		
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "levitation")), 100, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "speed")), 200, 0),	
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 200, 0),	
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "night_vision")), 200, 0),
	    		},
	    		new PotionEffect[]{
    				new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "strength")), 200, 0),	
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "health_boost")), 200, 0),
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "night_vision")), 400, 0),				
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "saturation")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "levitation")), 100, 0)
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "strength")), 400, 1),		
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "strength")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "absorption")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "health_boost")), 200, 0)
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "instant_health")), 2, 1),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "regeneration")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "health_boost")), 200, 0)
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "saturation")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 200, 0),	
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "saturation")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "speed")), 200, 0),		
	    		},
	    		new PotionEffect[]{
    				new PotionEffect(PotionLoader.golden_heart, 200, 0),		
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 400, 0),			
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "strength")), 200, 0),	
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "saturation")), 200, 0)
	    		},
	    		
	    		new PotionEffect[]{
    				new PotionEffect(PotionLoader.poisom, 200, 0),	
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "resistance")), 200, 0),		
    				new PotionEffect(PotionLoader.golden_heart, 100, 0),	
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "speed")), 200, 0),	
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 200, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "night_vision")), 200, 0) 	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "speed")), 200, 0),	
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 200, 0),
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "speed")), 400, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "haste")), 400, 0),	
	    		},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "instant_health")), 2, 0),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "speed")), 200, 0),		
	    		},
	    		new PotionEffect[]{
    				new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "jump_boost")), 200, 5),		
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "speed")), 200, 1),			
		    	},
	    		new PotionEffect[]{
    				new PotionEffect(PotionLoader.poisom_big, 200, 0),
		    	},
	    		new PotionEffect[]{
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "strength")), 200, 0),	
	    			new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "saturation")), 200, 0)
	    		},
    		}
    );
    public static ItemMetaDurability bottle_alcoholic = new ItemMetaDurability(SakuraMain.MODID,
    		"bottle_alcoholic", 4, new ItemStack(ItemLoader.MATERIAL,1,47),
    		new String[]{
	    		"beer_bottle",
	    		"doburoku_bottle",
	    		"sake_bottle",
	    		"shouchu_bottle",
	    		"red_wine_bottle",
	    		"white_wine_bottle",
	    		"champagne_bottle",
	    		"rum_bottle",
	    		"vodka_bottle",
	    		"whiskey_bottle",
	    		"brandy_bottle",
	    		"gin_bottle",
	    		"tequila_bottle",
	    		"liqueur_bottle",
	    		"cocoa_liqueur_bottle",
			});
    public void registerItems() {
    	register(bottle_alcoholic);
		register(tea);
		register(alcoholic);
		register(cocktail);
	}
    private DrinksLoader() {

	}
    @SideOnly(Side.CLIENT)
    public void registerRender() {
    	ItemRegister.getInstance().registerRender(tea);
    	ItemRegister.getInstance().registerRender(alcoholic);
    	ItemRegister.getInstance().registerRender(cocktail);
    	ItemRegister.getInstance().registerRender(bottle_alcoholic);
	}
    private void register(Item item) {
        item.setCreativeTab(CommonProxy.tab);
        ItemRegister.getInstance().register(SakuraMain.MODID, item);
    }
	public static DrinksLoader getInstance() {
		return instance;
	}
 
}
