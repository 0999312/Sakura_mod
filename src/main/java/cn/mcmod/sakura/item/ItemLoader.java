package cn.mcmod.sakura.item;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.armors.ItemSamuraiArmors;
import cn.mcmod.sakura.item.armors.ItemStrawHat;
import cn.mcmod.sakura.item.drinks.DrinkBasic;
import cn.mcmod.sakura.util.JSON_Creator;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoader {
    public static final ItemArmor.ArmorMaterial STRAW_MATERIAL = EnumHelper.addArmorMaterial("STRAW_MATERIAL", SakuraMain.MODID + ":" + "textures/models/armor/strawhat.png", 6, new int[]{0, 0, 0, 1}, 30, net.minecraft.init.SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
    public static final ItemTool.ToolMaterial SAKURA_TOOLMATERIAL = EnumHelper.addToolMaterial("SAKURA_TOOLMATERIAL", 4, 1561, 8.5F, 4.0F, 12);
    public static final ItemTool.ToolMaterial TACHI_TOOLMATERIAL = EnumHelper.addToolMaterial("TACHI_TOOLMATERIAL", 3, 457, 7F, 3.0F, 18);
    public static final ItemArmor.ArmorMaterial SAMURAI_MATERIAL = EnumHelper.addArmorMaterial("SAMURAI_MATERIAL", SakuraMain.MODID + ":" + "textures/models/armor/samurai_armor.png", 6, new int[]{0, 0, 0, 1}, 30, net.minecraft.init.SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);
    public static ItemBase cup = new ItemBase("cup", 32, new String[]{
    		SakuraMain.MODID + "." + "cup"
    });
    
    public static Item SAMURAI_HELMET=new ItemSamuraiArmors("samurai_helmet", SAMURAI_MATERIAL, 0, EntityEquipmentSlot.HEAD);
    public static Item SAMURAI_CHEST=new ItemSamuraiArmors("samurai_chest", SAMURAI_MATERIAL, 0, EntityEquipmentSlot.CHEST);
    public static Item SAMURAI_PANTS=new ItemSamuraiArmors("samurai_pants", SAMURAI_MATERIAL, 0, EntityEquipmentSlot.LEGS);
    public static Item SAMURAI_SHOES=new ItemSamuraiArmors("samurai_shoes", SAMURAI_MATERIAL, 0, EntityEquipmentSlot.FEET);
    
    public static Item RICE_SEEDS = new ItemRiceSeeds();
    public static Item TOMATO = new ItemFood(2, false).setUnlocalizedName(SakuraMain.MODID + "." + "tomato");
    public static Item TOMATO_SEEDS = new ItemSeeds(BlockLoader.TOMATOCROP, Blocks.FARMLAND).setUnlocalizedName(SakuraMain.MODID + "." + "tomato_seeds");
    public static Item EGGPLANT = new ItemFood(2, false).setUnlocalizedName(SakuraMain.MODID + "." + "eggplant");
    public static Item EGGPLANT_SEEDS = new ItemSeeds(BlockLoader.EGGPLANTCROP, Blocks.FARMLAND).setUnlocalizedName(SakuraMain.MODID + "." + "eggplant_seeds");
    public static Item CABBAGE = new ItemFood(2, false).setUnlocalizedName(SakuraMain.MODID + "." + "cabbage");
    public static Item CABBAGE_SEEDS = new ItemSeeds(BlockLoader.CABBAGECROP, Blocks.FARMLAND).setUnlocalizedName(SakuraMain.MODID + "." + "cabbage_seeds");
    public static Item RADISH = new ItemFood(2, false).setUnlocalizedName(SakuraMain.MODID + "." + "radish");
    public static Item RADISH_SEEDS = new ItemSeeds(BlockLoader.RADISHCROP, Blocks.FARMLAND).setUnlocalizedName(SakuraMain.MODID + "." + "radish_seeds");
    public static Item RED_BEAN = new ItemSeeds(BlockLoader.REDBEANCROP, Blocks.FARMLAND).setUnlocalizedName(SakuraMain.MODID + "." + "red_bean");
    public static Item BUCKWHEAT = new ItemSeeds(BlockLoader.BUCKWHEATCROP, Blocks.FARMLAND).setUnlocalizedName(SakuraMain.MODID + "." + "buckwheat");
    public static Item RAPESEED = new ItemSeeds(BlockLoader.RAPESEEDCROP, Blocks.FARMLAND).setUnlocalizedName(SakuraMain.MODID + "." + "rapeseeds");
    public static Item ONION = new ItemFood(2, false).setUnlocalizedName(SakuraMain.MODID + "." + "onion");
    public static Item ONION_SEEDS = new ItemSeeds(BlockLoader.ONIONCROP, Blocks.FARMLAND).setUnlocalizedName(SakuraMain.MODID + "." + "onion_seeds");
    public static Item MAPLE_SYRUP = new ItemSeasoning(SakuraMain.MODID + "." + "maple_syrup", 15);
    public static ItemFoodBasic FOODSET = new ItemFoodBasic("foodset", 64,
            new int[]{
                    1, 3, 5,//2
                    4, 5, 2,
                    9, 4, 5,
                    7, 9, 7,
                    6, 5, 10,
                    9, 10, 9,
                    9, 4, 9,
                    6, 9, 10,
                    10, 14, 4,
                    9, 6, 9,
                    10, 10, 14,
                    8, 4, 9,
                    6, 9, 10,
                    10, 14, 8,
                    5, 6, 8,
                    7, 6, 10,
                    2, 8, 10,
                    7, 12, 12,
                    9, 14, 14,
                    5, 4, 6,
                    7, 8, 8,
                    2, 7, 9,
                    12, 12, 8,
                    7, 8, 10,
                    10, 3, 6,
                    6, 5, 8,
                    1, 5, 4,
                    2, 5, 6,
                    5, 5, 5,
                    4, 6, 6,
                    8, 6, 8,

                    8, 8, 8,
                    8, 8, 8,
                    4, 6, 6,
                    7, 5, 6,
                    6, 6, 4,//107
                    3, 6, 6,//110
                    6, 2, 6,
            },
            new float[]{
                    1F * 0.25F, 3F * 0.25F, 5F * 0.25F,
                    4F * 0.25F, 5F * 0.25F, 2F * 0.25F,
                    9F * 0.25F, 4F * 0.25F, 5F * 0.25F,
                    7F * 0.25F, 9F * 0.25F, 7F * 0.25F,
                    6F * 0.25F, 5F * 0.25F, 10F * 0.25F,
                    9F * 0.25F, 10F * 0.25F, 9F * 0.25F,
                    9F * 0.25F, 4F * 0.25F, 9F * 0.25F,
                    6F * 0.25F, 9F * 0.25F, 10F * 0.25F,
                    10F * 0.25F, 14F * 0.25F, 4F * 0.25F,
                    9F * 0.25F, 6F * 0.25F, 9F * 0.25F,
                    10F * 0.25F, 10F * 0.25F, 14F * 0.25F,
                    8F * 0.25F, 4F * 0.25F, 9F * 0.25F,
                    6F * 0.25F, 9F * 0.25F, 10F * 0.25F,
                    10F * 0.25F, 14F * 0.25F, 8F * 0.25F,
                    5F * 0.25F, 6F * 0.25F, 8F * 0.25F,
                    7F * 0.25F, 6F * 0.25F, 10F * 0.25F,
                    2F * 0.25F, 8F * 0.25F, 10F * 0.25F,
                    7F * 0.25F, 12F * 0.25F, 12F * 0.25F,
                    9F * 0.25F, 14F * 0.25F, 14F * 0.25F,
                    5F * 0.25F, 4F * 0.25F, 6F * 0.25F,
                    7F * 0.25F, 8F * 0.25F, 8F * 0.25F,
                    2F * 0.25F, 7F * 0.25F, 9F * 0.25F,
                    12F * 0.25F, 12F * 0.25F, 8F * 0.25F,
                    7F * 0.25F, 8F * 0.25F, 10F * 0.25F,
                    10F * 0.25F, 3F * 0.25F, 6F * 0.25F,
                    6F * 0.25F, 5F * 0.25F, 8F * 0.25F,
                    1F * 0.25F, 5F * 0.25F, 4F * 0.25F,
                    2F * 0.25F, 5F * 0.25F, 6F * 0.25F,
                    5F * 0.25F, 5F * 0.25F, 5F * 0.25F,
                    4F * 0.25F, 6F * 0.25F, 6F * 0.25F,
                    0.8F, 0.6F, 0.8F,
                    8F * 0.25F, 8F * 0.25F, 8F * 0.25F,
                    8F * 0.25F, 8F * 0.25F, 8F * 0.25F,
                    4F * 0.25F, 6F * 0.25F, 6F * 0.25F,
                    7F * 0.25F, 5F * 0.25F, 6F * 0.25F,
                    6F * 0.25F, 6F * 0.25F, 4F * 0.25F,//107
                    2F * 0.25F, 5F * 0.25F, 4F * 0.25F,//110
                    5F * 0.25F, 2F * 0.01F, 6F * 0.25F,
            },
            new String[]{
                    SakuraMain.MODID + "." + "grape",
                    SakuraMain.MODID + "." + "maple_cookie",
                    SakuraMain.MODID + "." + "rice_bread",
                    //1
                    SakuraMain.MODID + "." + "red_bean_paste",
                    SakuraMain.MODID + "." + "bun",
                    SakuraMain.MODID + "." + "cheese",
                    //2
                    SakuraMain.MODID + "." + "katsu",
                    SakuraMain.MODID + "." + "rice_cooked",
                    SakuraMain.MODID + "." + "rice_bamboo",
                    //3
                    SakuraMain.MODID + "." + "rice_fish",
                    SakuraMain.MODID + "." + "rice_beef",//7
                    SakuraMain.MODID + "." + "rice_pork",//8
                    //4
                    SakuraMain.MODID + "." + "rice_mushroom",//9
                    SakuraMain.MODID + "." + "rice_egg",//10
                    SakuraMain.MODID + "." + "rice_beef_egg",//11
                    //5
                    SakuraMain.MODID + "." + "rice_pork_egg",//12
                    SakuraMain.MODID + "." + "rice_pork_fried",//13
                    SakuraMain.MODID + "." + "rice_oyako",//14
                    //6
                    SakuraMain.MODID + "." + "rice_oyako_fish",//15
                    SakuraMain.MODID + "." + "ramen",//16
                    SakuraMain.MODID + "." + "ramen_beef",//17
                    //7
                    SakuraMain.MODID + "." + "ramen_egg",//18
                    SakuraMain.MODID + "." + "ramen_tempura",//19
                    SakuraMain.MODID + "." + "ramen_friedtofu",//20
                    //8
                    SakuraMain.MODID + "." + "ramen_katsu",//21
                    SakuraMain.MODID + "." + "ramen_large",//22
                    SakuraMain.MODID + "." + "udon",//23
                    //9
                    SakuraMain.MODID + "." + "udon_beef",//24
                    SakuraMain.MODID + "." + "udon_egg",//25
                    SakuraMain.MODID + "." + "udon_tempura",//26
                    //10
                    SakuraMain.MODID + "." + "udon_friedtofu",//27
                    SakuraMain.MODID + "." + "udon_katsu",//28
                    SakuraMain.MODID + "." + "udon_large",//29
                    //11
                    SakuraMain.MODID + "." + "yaki_udon",//30
                    SakuraMain.MODID + "." + "soba",//31
                    SakuraMain.MODID + "." + "soba_beef",//32
                    //12
                    SakuraMain.MODID + "." + "soba_egg",//33
                    SakuraMain.MODID + "." + "soba_tempura",//34
                    SakuraMain.MODID + "." + "soba_friedtofu",//35
                    //13
                    SakuraMain.MODID + "." + "soba_katsu",//36
                    SakuraMain.MODID + "." + "soba_large",//37
                    SakuraMain.MODID + "." + "soba_zaru",//38
                    //14
                    SakuraMain.MODID + "." + "onigiri",//39
                    SakuraMain.MODID + "." + "onigiri_bamboo",//40
                    SakuraMain.MODID + "." + "onigiri_fish",//41

                    SakuraMain.MODID + "." + "onigiri_mushroom",//39
                    SakuraMain.MODID + "." + "onigiri_seaweed",//40
                    SakuraMain.MODID + "." + "onigiri_tempura",//41

                    SakuraMain.MODID + "." + "burger_raw",//42
                    SakuraMain.MODID + "." + "burger",//43
                    SakuraMain.MODID + "." + "burger_dish",//44

                    SakuraMain.MODID + "." + "rice_curry",//45
                    SakuraMain.MODID + "." + "rice_curry_katsu",//46
                    SakuraMain.MODID + "." + "rice_curry_burger",//47

                    SakuraMain.MODID + "." + "rice_curry_cheese",//48
                    SakuraMain.MODID + "." + "rice_curry_cheese_katsu",//49
                    SakuraMain.MODID + "." + "rice_curry_cheese_burger",//50

                    SakuraMain.MODID + "." + "mashed_potato",//51
                    SakuraMain.MODID + "." + "mochi",//52
                    SakuraMain.MODID + "." + "mochi_toasted",//53

                    SakuraMain.MODID + "." + "mochi_sakura",//54
                    SakuraMain.MODID + "." + "ohagi",//55
                    SakuraMain.MODID + "." + "croquette",//56

                    SakuraMain.MODID + "." + "natto",//57
                    SakuraMain.MODID + "." + "rice_natto",//58
                    SakuraMain.MODID + "." + "rice_natto_egg",//59

                    SakuraMain.MODID + "." + "nikujaga",//60
                    SakuraMain.MODID + "." + "omurice",//61
                    SakuraMain.MODID + "." + "rice_fried",//62

                    SakuraMain.MODID + "." + "hamburger",//60
                    SakuraMain.MODID + "." + "cheese_burger",//61
                    SakuraMain.MODID + "." + "mabodofu",//62

                    SakuraMain.MODID + "." + "maboqiezi",//63
                    SakuraMain.MODID + "." + "chestnut_toasted",//64
                    SakuraMain.MODID + "." + "soup_red_bean",//65

                    SakuraMain.MODID + "." + "pound_cake",//63
                    SakuraMain.MODID + "." + "osuimono",//64
                    SakuraMain.MODID + "." + "ochazuke",//65

                    SakuraMain.MODID + "." + "shrimp",//77
                    SakuraMain.MODID + "." + "tempura",//78
                    SakuraMain.MODID + "." + "fishcake",//79

                    SakuraMain.MODID + "." + "tofu",//81
                    SakuraMain.MODID + "." + "tofu_fried",//82
                    SakuraMain.MODID + "." + "oden",//83

                    SakuraMain.MODID + "." + "dananko",//84
                    SakuraMain.MODID + "." + "danmitarashi",//85
                    SakuraMain.MODID + "." + "dansansyoku",//86

                    SakuraMain.MODID + "." + "eggplant_baked",//87
                    SakuraMain.MODID + "." + "fried_chicken",//88
                    SakuraMain.MODID + "." + "sashimi",//89

                    SakuraMain.MODID + "." + "beef_stick",//90
                    SakuraMain.MODID + "." + "chicken_stick",//91
                    SakuraMain.MODID + "." + "pork_stick",//92

                    SakuraMain.MODID + "." + "ramen_croquette",//93
                    SakuraMain.MODID + "." + "udon_croquette",//94
                    SakuraMain.MODID + "." + "soba_croquette",//95

                    SakuraMain.MODID + "." + "ramen_chicken",//96
                    SakuraMain.MODID + "." + "udon_chicken",//97
                    SakuraMain.MODID + "." + "soba_chicken",//98

                    SakuraMain.MODID + "." + "tamagoyaki",//99
                    SakuraMain.MODID + "." + "sushi",//100
                    SakuraMain.MODID + "." + "sushi_tamago",//101

                    SakuraMain.MODID + "." + "ehoumaki",//102
                    SakuraMain.MODID + "." + "pudding",//103
                    SakuraMain.MODID + "." + "pudding_maple",//104

                    SakuraMain.MODID + "." + "rice_redbean",//105
                    SakuraMain.MODID + "." + "fish_bake",//106
                    SakuraMain.MODID + "." + "fries",//107
                    
                    SakuraMain.MODID + "." + "furofuki_daikon",//108
                    SakuraMain.MODID + "." + "cabbage_roll",//109
                    SakuraMain.MODID + "." + "white_stew",//110
                    
                    SakuraMain.MODID + "." + "fruitsalad",//111
                    SakuraMain.MODID + "." + "raw_taiyaki",//112
                    SakuraMain.MODID + "." + "taiyaki",//113
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
            SakuraMain.MODID + "." + "lumber_bamboo",//24
            SakuraMain.MODID + "." + "lumber_sakura",
            SakuraMain.MODID + "." + "lumber_maple",//26
            SakuraMain.MODID + "." + "black_pepper",
            SakuraMain.MODID + "." + "white_pepper",//28
            SakuraMain.MODID + "." + "miso",
            SakuraMain.MODID + "." + "breadcrumbs",//30
            SakuraMain.MODID + "." + "chestnut",//31
            SakuraMain.MODID + "." + "noodle_soup",//32
            SakuraMain.MODID + "." + "soysause",//33
            SakuraMain.MODID + "." + "seaweed",//34
    });
    public static Item POT = new ItemPot();
    public static Item KNIFE_NOODLE = new ItemKnifeNoodle();
    public static Item SAKURA_DIAMOND = new ItemSakuraDiamond();
    public static Item KATANA = new ItemKatana(Item.ToolMaterial.IRON, "katana");
    public static Item TACHI = new ItemKatana(TACHI_TOOLMATERIAL, "tachi");
    public static Item KODACHI = new ItemKotachi(Item.ToolMaterial.IRON, "kodachi");
//    
    public static Item SHINAI = new ItemShinai("shinai");
    public static Item SAKURAKATANA = new ItemKatana(SAKURA_TOOLMATERIAL, "sakura_katana");
    public static Item SAKURAKODACHI = new ItemKotachi(SAKURA_TOOLMATERIAL, "sakura_kodachi");
    public static Item HYDRA_RAMEN = new ItemFood(20, 14F * 0.25F, false).setPotionEffect(new PotionEffect(MobEffects.REGENERATION, 220, 0), 1.0F).setPotionEffect(new PotionEffect(MobEffects.SATURATION, 80, 0), 0.4F);
    public static Item BUGGYS_MEAT = new ItemBuggysMeat(20, 22F * 0.25F, false).setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 2000, 0), 1.0F).setPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 2400, 1), 1.0F);


    public static Item STRAW_HAT = new ItemStrawHat();

    public ItemLoader(FMLPreInitializationEvent event) {
    	register(cup);
        register(POT);
        register(BAMBOO_DOOR.setUnlocalizedName(SakuraMain.MODID + "." + "bamboo_door"));
        register(TOMATO);
        register(TOMATO_SEEDS);
        register(EGGPLANT);
        register(EGGPLANT_SEEDS);
        register(CABBAGE);
        register(CABBAGE_SEEDS);
        register(ONION);
        register(ONION_SEEDS);
        register(RADISH);
        register(RADISH_SEEDS);
        register(RICE_SEEDS);
        register(RED_BEAN);
        register(BUCKWHEAT);
        register(RAPESEED);
        register(MAPLE_SYRUP);
        register(KNIFE_NOODLE);
        register(MATERIAL);
        register(FOODSET);
        register(HYDRA_RAMEN.setUnlocalizedName(SakuraMain.MODID + "." + "hydra_ramen"));
        register(BUGGYS_MEAT);
        register(STRAW_HAT);
        register(SAKURA_DIAMOND);
        register(SHINAI);
        register(KATANA);
        register(SAKURAKATANA);
        register(KODACHI);
        register(SAKURAKODACHI);
        register(TACHI);
        register(SAMURAI_HELMET);
        register(SAMURAI_CHEST);
        register(SAMURAI_PANTS);
        register(SAMURAI_SHOES);
        MinecraftForge.addGrassSeed(new ItemStack(TOMATO_SEEDS), 2);
        MinecraftForge.addGrassSeed(new ItemStack(EGGPLANT_SEEDS), 2);
        MinecraftForge.addGrassSeed(new ItemStack(CABBAGE_SEEDS), 2);
        MinecraftForge.addGrassSeed(new ItemStack(RADISH_SEEDS), 2);
        MinecraftForge.addGrassSeed(new ItemStack(RICE_SEEDS), 3);
        MinecraftForge.addGrassSeed(new ItemStack(BUCKWHEAT), 3);
        MinecraftForge.addGrassSeed(new ItemStack(RAPESEED), 2);
        MinecraftForge.addGrassSeed(new ItemStack(MATERIAL, 1, 23), 2);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
    	registerRender(SAMURAI_HELMET);
        registerRender(SAMURAI_CHEST);
        registerRender(SAMURAI_PANTS);
        registerRender(SAMURAI_SHOES);
    	registerRender(TACHI);
    	registerRender(ONION);
        registerRender(ONION_SEEDS);
    	registerRender(SHINAI);
    	registerRender(KODACHI);
        registerRender(SAKURAKODACHI);
        registerRender(KNIFE_NOODLE);
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
        registerRender(HYDRA_RAMEN);
        registerRender(BUGGYS_MEAT);
        registerRender(STRAW_HAT);
        registerRender(SAKURA_DIAMOND);
        registerRender(KATANA);
        registerRender(SAKURAKATANA);
        registerRender(cup);
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
