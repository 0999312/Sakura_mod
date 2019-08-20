package cn.mcmod.sakura.item.drinks;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.item.ItemBase;
import cn.mcmod.sakura.item.ItemFoodBasic;
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
    public static DrinkBasic tea = new DrinkBasic("tea", 2,
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
    		}
    );
    
    public DrinksLoader() {
		register(tea);
	}
    @SideOnly(Side.CLIENT)
    public static void registerRender() {
		registerRender(tea);
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
