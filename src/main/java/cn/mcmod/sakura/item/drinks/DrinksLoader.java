package cn.mcmod.sakura.item.drinks;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.item.ItemBase;
import cn.mcmod.sakura.potion.PotionLoader;
import cn.mcmod.sakura.util.JSON_Creator;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DrinksLoader {
    public static DrinkBasic tea = new DrinkBasic("tea",
    		new String[]{
    		SakuraMain.MODID + "." +"black_tea",
    		SakuraMain.MODID + "." +"green_tea",
    		SakuraMain.MODID + "." +"milk_tea",
    		SakuraMain.MODID + "." +"milk_green_tea",
    		SakuraMain.MODID + "." +"earl_grey",
    		SakuraMain.MODID + "." +"milk_earl_grey",
    		SakuraMain.MODID + "." +"fruit_tea",
    		SakuraMain.MODID + "." +"milk_fruit_tea",
    		SakuraMain.MODID + "." +"lemon_black_tea",
    		SakuraMain.MODID + "." +"lemon_green_tea",
    		SakuraMain.MODID + "." +"mint_tea",
    		SakuraMain.MODID + "." +"barley_tea",
    		SakuraMain.MODID + "." +"brown_rice_tea",
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
    		}
    );
    public static DrinksAlcoholic alcoholic = new DrinksAlcoholic("alcoholic",
    		new String[]{
    		SakuraMain.MODID + "." +"glass_beer",
    		SakuraMain.MODID + "." +"glass_doburoku",
    		SakuraMain.MODID + "." +"glass_sake",
    		SakuraMain.MODID + "." +"glass_shouchu",
    		SakuraMain.MODID + "." +"glass_red_wine",
    		SakuraMain.MODID + "." +"glass_white_wine",
    		SakuraMain.MODID + "." +"glass_champagne",
    		SakuraMain.MODID + "." +"glass_rum",
    		SakuraMain.MODID + "." +"glass_vodka",
    		SakuraMain.MODID + "." +"glass_whiskey",
    		SakuraMain.MODID + "." +"glass_brandy",
    		SakuraMain.MODID + "." +"glass_gin",
    		SakuraMain.MODID + "." +"glass_tequila",
    		SakuraMain.MODID + "." +"glass_liqueur",
    		SakuraMain.MODID + "." +"glass_cocoa_liqueur",
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
    		new String[]{
				SakuraMain.MODID + "." +"glass_kir",
	    		SakuraMain.MODID + "." +"glass_royal_kir",
	    		SakuraMain.MODID + "." +"glass_margarita",
	    		SakuraMain.MODID + "." +"glass_paradise",
	    		SakuraMain.MODID + "." +"glass_sidecar",
	    		SakuraMain.MODID + "." +"glass_french_sevenfive",
	    		SakuraMain.MODID + "." +"glass_john_collins",
	    		SakuraMain.MODID + "." +"glass_daiquiri",
	    		SakuraMain.MODID + "." +"glass_between_the_sheets",
	    		SakuraMain.MODID + "." +"glass_black_russian",
	    		SakuraMain.MODID + "." +"glass_godfather",
	    		SakuraMain.MODID + "." +"glass_godmother",
	    		SakuraMain.MODID + "." +"glass_grasshopper",
	    		SakuraMain.MODID + "." +"glass_mint_julep",
	    		SakuraMain.MODID + "." +"glass_mojito",	
	    		SakuraMain.MODID + "." +"glass_rusty_nail",
	    		SakuraMain.MODID + "." +"glass_lemon_margarita",
	    		SakuraMain.MODID + "." +"glass_russian_spring",
	    		SakuraMain.MODID + "." +"glass_alexander",
	    		SakuraMain.MODID + "." +"glass_aviation",
	    		SakuraMain.MODID + "." +"glass_porto_flip",
	    		SakuraMain.MODID + "." +"glass_red_eyes",
	    		SakuraMain.MODID + "." +"glass_spritzer",
	    		SakuraMain.MODID + "." +"glass_panache",
	    		SakuraMain.MODID + "." +"glass_screw_driver",
	    		SakuraMain.MODID + "." +"glass_bloody_mary",
	    		SakuraMain.MODID + "." +"glass_saketini",
	    		SakuraMain.MODID + "." +"glass_boilermaker",
	    		SakuraMain.MODID + "." +"glass_beer_margarita",
	    		SakuraMain.MODID + "." +"glass_long_island_iced_tea",
	    		SakuraMain.MODID + "." +"glass_highball",
	    		SakuraMain.MODID + "." +"glass_porchcrawler",
	    		SakuraMain.MODID + "." +"glass_stinger",
	    		SakuraMain.MODID + "." +"glass_negroni",
	    		SakuraMain.MODID + "." +"glass_old_fashioned",
	    		SakuraMain.MODID + "." +"glass_whiskey_sour",
	    		SakuraMain.MODID + "." +"glass_gimlet",
	    		SakuraMain.MODID + "." +"glass_tequila_sunrise",
	    		SakuraMain.MODID + "." +"glass_flying_grasshopper",
	    		SakuraMain.MODID + "." +"glass_eggnog",
	    		SakuraMain.MODID + "." +"glass_scorpion",
	    		SakuraMain.MODID + "." +"glass_moscow_mule"
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
    public static ItemBottleDrink bottle_alcoholic = new ItemBottleDrink("bottle_alcoholic",
    		new String[]{
	    		SakuraMain.MODID + "." +"beer_bottle",
	    		SakuraMain.MODID + "." +"doburoku_bottle",
	    		SakuraMain.MODID + "." +"sake_bottle",
	    		SakuraMain.MODID + "." +"shouchu_bottle",
	    		SakuraMain.MODID + "." +"red_wine_bottle",
	    		SakuraMain.MODID + "." +"white_wine_bottle",
	    		SakuraMain.MODID + "." +"champagne_bottle",
	    		SakuraMain.MODID + "." +"rum_bottle",
	    		SakuraMain.MODID + "." +"vodka_bottle",
	    		SakuraMain.MODID + "." +"whiskey_bottle",
	    		SakuraMain.MODID + "." +"brandy_bottle",
	    		SakuraMain.MODID + "." +"gin_bottle",
	    		SakuraMain.MODID + "." +"tequila_bottle",
	    		SakuraMain.MODID + "." +"liqueur_bottle",
	    		SakuraMain.MODID + "." +"cocoa_liqueur_bottle",
			});
    public DrinksLoader() {
    	register(bottle_alcoholic);
		register(tea);
		register(alcoholic);
		register(cocktail);
	}
    @SideOnly(Side.CLIENT)
    public static void registerRender() {
		registerRender(tea);
		registerRender(alcoholic);
		registerRender(cocktail);
		registerRender(bottle_alcoholic);
	}
    private static void register(Item item) {
        item.setCreativeTab(CommonProxy.tab);
        ForgeRegistries.ITEMS.register(item.setRegistryName(item.getUnlocalizedName().substring(5 + SakuraMain.MODID.length() + 1)));
    }
    @SideOnly(Side.CLIENT)
    private static void registerRender(ItemBase item) {
        registerRender(item, false);
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(DrinkBasic item) {
        registerRender(item, false);
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(ItemBase item, boolean json_create) {
        for (int i = 0; i < item.getSubNames().length; i++) {
            String name = item.getSubNames()[i].substring(SakuraMain.MODID.length() + 1);
            if (json_create) JSON_Creator.genItem(name, name, "json_create");
            ModelResourceLocation model = new ModelResourceLocation(new ResourceLocation(SakuraMain.MODID, name), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, i, model);
        }
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(DrinkBasic item, boolean json_create) {

        for (int i = 0; i < item.getSubNames().length; i++) {
            String name = item.getSubNames()[i].substring(SakuraMain.MODID.length() + 1);
            if (json_create) JSON_Creator.genDrink(name, name, "json_create");
            ModelResourceLocation model = new ModelResourceLocation(new ResourceLocation(SakuraMain.MODID, name), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, i, model);
        }
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item, int meta, String name) {
        ModelResourceLocation model = new ModelResourceLocation(name, "inventory");
        ModelLoader.setCustomModelResourceLocation(item, meta, model);
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item, int meta, String name, String textureName) {
        JSON_Creator.genItem(name, textureName, "json_create");
        ModelResourceLocation model = new ModelResourceLocation(name, "inventory");
        ModelLoader.setCustomModelResourceLocation(item, meta, model);
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item, String textureName) {
        JSON_Creator.genItem(item.getRegistryName().toString().substring(SakuraMain.MODID.length() + 1), textureName, "json_create");
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, model);
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item) {
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, model);
    }
}
