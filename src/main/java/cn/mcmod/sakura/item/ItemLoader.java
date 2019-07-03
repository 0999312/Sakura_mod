package cn.mcmod.sakura.item;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.util.JSON_Creator;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoader {
    public static Item RICE_SEEDS = new ItemRiceSeeds();
    public static Item TOMATO = new ItemFood(2,false).setUnlocalizedName(SakuraMain.MODID + "." + "tomato");
    public static Item TOMATO_SEEDS = new ItemSeeds(BlockLoader.TOMATOCROP, Blocks.FARMLAND).setUnlocalizedName(SakuraMain.MODID + "." + "tomato_seeds");
    public static Item EGGPLANT = new ItemFood(2,false).setUnlocalizedName(SakuraMain.MODID + "." + "eggplant");
    public static Item EGGPLANT_SEEDS = new ItemSeeds(BlockLoader.EGGPLANTCROP, Blocks.FARMLAND).setUnlocalizedName(SakuraMain.MODID + "." + "eggplant_seeds");
    public static Item CABBAGE = new ItemFood(2,false).setUnlocalizedName(SakuraMain.MODID + "." + "cabbage");
    public static Item CABBAGE_SEEDS = new ItemSeeds(BlockLoader.CABBAGECROP, Blocks.FARMLAND).setUnlocalizedName(SakuraMain.MODID + "." + "cabbage_seeds");
    public static Item RADISH = new ItemFood(2,false).setUnlocalizedName(SakuraMain.MODID + "." + "radish");
    public static Item RADISH_SEEDS = new ItemSeeds(BlockLoader.RADISHCROP, Blocks.FARMLAND).setUnlocalizedName(SakuraMain.MODID + "." + "radish_seeds");
    public static Item RED_BEAN = new ItemSeeds(BlockLoader.REDBEANCROP, Blocks.FARMLAND).setUnlocalizedName(SakuraMain.MODID + "." + "red_bean");
    public static Item BUCKWHEAT = new ItemSeeds(BlockLoader.BUCKWHEATCROP, Blocks.FARMLAND).setUnlocalizedName(SakuraMain.MODID + "." + "buckwheat");
    public static Item RAPESEED = new ItemSeeds(BlockLoader.RAPESEEDCROP, Blocks.FARMLAND).setUnlocalizedName(SakuraMain.MODID + "." + "rapeseeds");
    public static Item MAPLE_SYRUP = new ItemSeasoning(SakuraMain.MODID + "." + "maple_syrup", 15);
    public static ItemFoodBasic FOODSET = new ItemFoodBasic("foodset", 64,
            new int[]{1, 3, 4, 5, 7, 9, 5, 5, 5, 9, 10},
            new float[]{0.05f, 0.22F, 0.3F, 0.5F, 0.68F, 0.88F, 0.6F, 0.65F, 0.65F, 0.85F, 0.95F},
            new String[]{
            		SakuraMain.MODID + "." + "grape",
            		SakuraMain.MODID + "." + "maple_cookie",
                    SakuraMain.MODID + "." + "rice_cooked",
                    SakuraMain.MODID + "." + "rice_bamboo",
                    SakuraMain.MODID + "." + "rice_fish",
                    SakuraMain.MODID + "." + "rice_beef",//5
                    SakuraMain.MODID + "." + "rice_bread",
                    SakuraMain.MODID + "." + "rice_egg",
                    SakuraMain.MODID + "." + "ramen",
                    SakuraMain.MODID + "." + "ramen_beef",
                    SakuraMain.MODID + "." + "rice_beef_egg",//10
            });
    public static ItemDoor BAMBOO_DOOR = new ItemDoor(BlockLoader.BAMBOODOOR);
    public static ItemBase MATERIAL = new ItemBase("materials", 64, new String[]{
    		SakuraMain.MODID + "." + "straw",//0
    		SakuraMain.MODID + "." + "rice",//1
    		SakuraMain.MODID + "." + "salt",
    		SakuraMain.MODID + "." + "curry_powder",
    		SakuraMain.MODID + "." + "flour",
    		SakuraMain.MODID + "." + "flour_buckwheat",
    		SakuraMain.MODID + "." + "dough",
    		SakuraMain.MODID + "." + "dough_buckwheat",
    		SakuraMain.MODID + "." + "ramen_raw",
    		SakuraMain.MODID + "." + "udon_raw",
            SakuraMain.MODID + "." + "soba_raw",//10
    		SakuraMain.MODID + "." + "curry_sauce",
    		SakuraMain.MODID + "." + "tomato_sauce",
    		SakuraMain.MODID + "." + "white_sauce",
    		SakuraMain.MODID + "." + "tempura_batter",
            SakuraMain.MODID + "." + "chestnut_burrs",//15
            SakuraMain.MODID + "." + "flour_rice",
            SakuraMain.MODID + "." + "dough_rice",//17
            SakuraMain.MODID + "." + "peppercorn_green",
            SakuraMain.MODID + "." + "peppercorn_red",//19
            SakuraMain.MODID + "." + "vanilla_seeds",
            SakuraMain.MODID + "." + "vanilla",//21
            SakuraMain.MODID + "." + "vanilla_roast",
            SakuraMain.MODID + "." + "grape_seeds",//23
    });
    public static Item POT = new ItemPot();
    public ItemLoader(FMLPreInitializationEvent event) {
        register(POT);
        register(BAMBOO_DOOR.setUnlocalizedName(SakuraMain.MODID + "." + "bamboo_door"));
        register(TOMATO);
        register(TOMATO_SEEDS);
        register(EGGPLANT);
        register(EGGPLANT_SEEDS);
        register(CABBAGE);
        register(CABBAGE_SEEDS);
        register(RICE_SEEDS);
        register(RADISH);
        register(RADISH_SEEDS);
        register(RED_BEAN);
        register(BUCKWHEAT);
        register(RAPESEED);
        register(MAPLE_SYRUP);
        register(MATERIAL);
        register(FOODSET);
        MinecraftForge.addGrassSeed(new ItemStack(TOMATO_SEEDS), 3);
        MinecraftForge.addGrassSeed(new ItemStack(EGGPLANT_SEEDS), 3);
        MinecraftForge.addGrassSeed(new ItemStack(CABBAGE_SEEDS), 3);
        MinecraftForge.addGrassSeed(new ItemStack(RADISH_SEEDS), 3);
        MinecraftForge.addGrassSeed(new ItemStack(RICE_SEEDS), 3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
    	registerRender(POT);
    	registerRender(CABBAGE);
        registerRender(CABBAGE_SEEDS);
    	registerRender(TOMATO);
        registerRender(TOMATO_SEEDS);
        registerRender(EGGPLANT);
        registerRender(EGGPLANT_SEEDS);
        registerRender(RADISH);
        registerRender(RADISH_SEEDS);
        registerRender(BUCKWHEAT);
        registerRender(MATERIAL);
        registerRender(RAPESEED);
        registerRender(RICE_SEEDS);
        registerRender(RED_BEAN);
        registerRender(BAMBOO_DOOR);
        registerRender(MAPLE_SYRUP);
        registerRender(FOODSET);

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
    private static void registerRender(ItemFoodBasic item) {
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
    private static void registerRender(ItemFoodBasic item, boolean json_create) {

        for (int i = 0; i < item.getSubNames().length; i++) {
            String name = item.getSubNames()[i].substring(SakuraMain.MODID.length() + 1);
            if (json_create) JSON_Creator.genItem(name, name, "json_create");
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
