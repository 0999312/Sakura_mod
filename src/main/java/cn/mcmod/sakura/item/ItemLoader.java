package cn.mcmod.sakura.item;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.armors.ItemHaori;
import cn.mcmod.sakura.item.armors.ItemKimono;
import cn.mcmod.sakura.item.armors.ItemSamuraiArmors;
import cn.mcmod.sakura.item.armors.ItemStrawHat;
import cn.mcmod.sakura.item.katana.ItemKatana;
import cn.mcmod.sakura.item.katana.ItemKotachi;
import cn.mcmod.sakura.item.katana.ItemSheath;
import cn.mcmod.sakura.item.katana.ItemSheathKatana;
import cn.mcmod.sakura.item.katana.ItemShinai;
import cn.mcmod.sakura.item.tool.ItemBroom;
import cn.mcmod.sakura.item.tool.ItemHammer;
import cn.mcmod.sakura.item.tool.ItemKnifeNoodle;
import cn.mcmod_mmf.mmlib.item.ItemBase;
import cn.mcmod_mmf.mmlib.item.food.FoodInfo;
import cn.mcmod_mmf.mmlib.item.food.ItemFoodBase;
import cn.mcmod_mmf.mmlib.item.food.ItemFoodContain;
import cn.mcmod_mmf.mmlib.register.ItemRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoader {
    public static final ItemArmor.ArmorMaterial STRAW_MATERIAL = EnumHelper.addArmorMaterial("STRAW_MATERIAL", SakuraMain.MODID + ":" + "textures/models/armor/strawhat.png", 6, new int[]{0, 0, 0, 1}, 30, net.minecraft.init.SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
    public static final ItemTool.ToolMaterial SAKURA_TOOLMATERIAL = EnumHelper.addToolMaterial("SAKURA_TOOLMATERIAL", 4, 1561, 8.5F, 4.0F, 12);
    public static final ItemTool.ToolMaterial TACHI_TOOLMATERIAL = EnumHelper.addToolMaterial("TACHI_TOOLMATERIAL", 3, 457, 7F, 3.0F, 18);
    public static final ItemTool.ToolMaterial STRAW_TOOLMATERIAL = EnumHelper.addToolMaterial("STRAW_TOOLMATERIAL", 0, 256, 2F, 1.0F, 8);
    public static final ItemArmor.ArmorMaterial SAMURAI_MATERIAL = EnumHelper.addArmorMaterial("SAMURAI_MATERIAL", SakuraMain.MODID + ":" + "textures/models/armor/samurai_armor.png", 33, new int[]{5, 8, 9, 5}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F);
    public static final ItemArmor.ArmorMaterial KIMONO_MATERIAL = EnumHelper.addArmorMaterial("KIMONO_MATERIAL", SakuraMain.MODID + ":" + "textures/models/armor/kimono.png", -1, new int[]{0, 0, 0, 0}, 0, net.minecraft.init.SoundEvents.BLOCK_CLOTH_PLACE, 0);
    public static ItemBase cup = new ItemBase(SakuraMain.MODID,"cup", 32, new String[]{
    		SakuraMain.MODID + "." + "cup"
    });
    
    public static Item BROOM = new ItemBroom(STRAW_TOOLMATERIAL).setUnlocalizedName(SakuraMain.MODID + "." + "broom");
    
    public static Item SAMURAI_HELMET=new ItemSamuraiArmors("samurai_helmet", SAMURAI_MATERIAL, 0, EntityEquipmentSlot.HEAD);
    public static Item SAMURAI_CHEST=new ItemSamuraiArmors("samurai_chest", SAMURAI_MATERIAL, 0, EntityEquipmentSlot.CHEST);
    public static Item SAMURAI_PANTS=new ItemSamuraiArmors("samurai_pants", SAMURAI_MATERIAL, 0, EntityEquipmentSlot.LEGS);
    public static Item SAMURAI_SHOES=new ItemSamuraiArmors("samurai_shoes", SAMURAI_MATERIAL, 0, EntityEquipmentSlot.FEET);
    
    public static Item RICE_SEEDS = new ItemRiceSeeds();
    
    public static Item SEAWEED_RAW = new ItemSeaweed();
    
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
    
    public static ItemFoodBase FOODSET = new ItemFoodBase(SakuraMain.MODID,"foodset", 64,
           new FoodInfo[]{
        		new FoodInfo(SakuraMain.MODID + "." + "grape", 1, 0.25f, false, 4F, 0.25F, 0F, 1F, 0F, 0F, 5F, 0, -1),  
        		new FoodInfo(SakuraMain.MODID + "." + "maple_cookie", 3, 0.25f, false, 0.75F, 2F, 0F, 0F, 0F, 0.2F, 0.8F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "rice_bread", 5, 0.6f, false, 0f, 2f, 0f, 0f, 0f, 0f, 0f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "red_bean_paste", 4, 0.25f, false, 4F, 0.25F, 0F, 1F, 0F, 0F, 4F, 0, -1),  
        		new FoodInfo(SakuraMain.MODID + "." + "bun", 5, 0.6f, false, 0F, 2F, 0F, 0F, 0F, 0F, 0.8F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "cheese", 2, 0.2f, false, 1f, 0f, 0f, 0f, 0f, 2f, 2f, 0, -1),	
        		new FoodInfo(SakuraMain.MODID + "." + "katsu", 9, 0.6f, false, 4F, 0.25F, 0F, 0F, 3F, 0F, 1.25F, 0, -1),  
        		new FoodInfo(SakuraMain.MODID + "." + "rice_cooked", 4, 0.5f, false, 0.5F, 1.5F, 0F, 0F, 0F, 0F, 2F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "rice_bamboo", 5, 0.6f, false, 0.5F, 1.5F, 1f, 0f, 0f, 0f, 2.25f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "rice_fish", 7, 0.7f, false, 0.5F, 1.5F, 0f, 0f, 2f, 0f, 2.25f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "rice_beef", 9, 0.8f, false, 0.5F, 1.5F, 0F, 0F, 3F, 0F, 2.25f, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "rice_pork", 7, 0.7f, false, 0.5F, 1.5F, 0F, 0F, 3F, 0F, 2.25f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "rice_mushroom", 6, 0.6f, false, 0.5F, 1.5F, 0F, 2F, 0F, 0F, 2F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "rice_egg", 5, 0.6f, false, 0.5F, 1.5F, 0f, 0f, 0f, 2f, 2.25f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "rice_beef_egg", 10, 1f, false, 0.5F, 1.5F, 0f, 0f, 3.5f, 2f, 2.25f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "rice_pork_egg", 9, 0.8f, false, 0.5F, 1.5F, 0f, 0F, 3.5f, 2f, 2.25f, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "rice_pork_fried", 10, 1f, false, 0.5F, 2F, 0F, 0F, 4F, 4F, 2.25f, 1f, 480f),	
        		new FoodInfo(SakuraMain.MODID + "." + "rice_oyako", 9, 0.8f, false, 0.5F, 1.5F, 0f, 0f, 3.5f, 2f, 2.25f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "rice_oyako_fish", 9, 0.8f, false, 0.5F, 1.5F, 0f, 0f, 3.5f, 2f, 2.25f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "ramen", 4, 0.5f, false, 35F, 1.5F, 0F, 0F, 0F, 0F, 0F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "ramen_beef", 9, 0.8f, false, 35F, 1.5F, 0F, 0F, 3F, 0F, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "ramen_egg", 5, 0.6f, false, 35F, 1.5F, 0f, 0f, 0f, 2f, 5f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "ramen_tempura", 9, 0.8f, false, 35F, 2F, 0F, 0F, 3F, 0F, 5f, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "ramen_friedtofu", 9, 0.7f, false, 35F, 2F, 0F, 2F, 0F, 0F, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "ramen_katsu", 10, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "ramen_large", 12, 1f, false, 35F, 2F, 0F, 5F, 5F, 2F, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "udon", 4, 0.5f, false, 35F, 1.5F, 0F, 0F, 0F, 0F, 4F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "udon_beef", 9, 0.8f, false, 35F, 1.5F, 0F, 0F, 3F, 0F, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "udon_egg", 5, 0.6f, false, 35F, 1.5F, 0f, 0f, 0f, 2f, 5f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "udon_tempura", 9, 0.8f, false, 35F, 2F, 0F, 0F, 3F, 0F, 5f, 1f, 480f),           
        		new FoodInfo(SakuraMain.MODID + "." + "udon_friedtofu", 9, 0.7f, false, 35F, 2F, 0F, 2F, 0F, 0F, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "udon_katsu", 10, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "udon_large", 12, 1f, false, 35F, 2F, 0F, 5F, 5F, 2F, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "yaki_udon", 9, 0.7f, false, 2.5F, 1.5F, 0F, 4F, 2F, 2F, 3.5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "soba", 4, 0.5f, false, 35F, 1.5F, 0F, 0F, 0F, 0F, 4F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "soba_beef", 9, 0.8f, false, 35F, 1.5F, 0F, 0F, 3F, 0F, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "soba_egg", 5, 0.6f, false, 35F, 1.5F, 0f, 0f, 0f, 2f, 5f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "soba_tempura", 9, 0.8f, false, 35F, 2F, 0F, 0F, 3F, 0F, 5f, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "soba_friedtofu", 9, 0.7f, false, 35F, 2F, 0F, 2F, 0F, 0F, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "soba_katsu", 10, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),          
        		new FoodInfo(SakuraMain.MODID + "." + "soba_large", 12, 1f, false, 35F, 2F, 0F, 5F, 5F, 2F, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "soba_zaru", 6, 0.7f, false, 5F, 2F, 0F, 0.5F, 0F, 0F, 3.5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "onigiri", 6, 0.6f, false, 0.5F, 2F, 0F, 1F, 0F, 0F, 2F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "onigiri_bamboo", 7, 0.7f, false, 0.5F, 2F, 0f, 2f, 0f, 0f, 2.25f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "onigiri_fish", 8, 0.7f, false, 0.5F, 2F, 0f, 1f, 2f, 0f, 2.25f, 1f, 480f), 
        		new FoodInfo(SakuraMain.MODID + "." + "onigiri_mushroom", 7, 0.7f, false, 0.5F, 2F, 0F, 2F, 0F, 0.5F, 2F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "onigiri_seaweed", 7, 0.7f, false, 0.5F, 2F, 0F, 2F, 0F, 0.5F, 2.25F, 1f, 480f), 
        		new FoodInfo(SakuraMain.MODID + "." + "onigiri_tempura", 10, 0.8f, false, 0.5F, 2F, 0F, 2F, 4F, 1F, 2.25f, 1f, 480f), 
        		new FoodInfo(SakuraMain.MODID + "." + "burger_raw", 2, 0.2f, false, 1f, 0.5f, 0f, 0f, 3f, 0f, 2f, 1f, 200f),         
        		new FoodInfo(SakuraMain.MODID + "." + "burger", 6, 0.6f, false, 2f, 0.5f, 0f, 0f, 4f, 0f, 2f, 1f, 200f), 
        		new FoodInfo(SakuraMain.MODID + "." + "burger_dish", 10, 0.8f, false, 2.5F, 0.5F, 0F, 2F, 4F, 0F, 2.5f, 1f, 480f), 
        		new FoodInfo(SakuraMain.MODID + "." + "rice_curry", 6, 0.6f, false, 0.5F, 2.5F, 0f, 1f, 1f, 1f, 2.25f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "rice_curry_katsu", 10, 0.8f, false, 0.5F, 3F, 0f, 1f, 4f, 1f, 2.25f, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "rice_curry_burger", 10, 0.8f, false, 0.5F, 3F, 0f, 1f, 4f, 1f, 2.25f, 1f, 480f),      
        		new FoodInfo(SakuraMain.MODID + "." + "rice_curry_cheese", 8, 0.8f, false, 0.5F, 2.5F, 0f, 1f, 1f, 4f, 2.25f, 1f, 480f),   
        		new FoodInfo(SakuraMain.MODID + "." + "rice_curry_cheese_katsu", 12, 0.8f, false, 0.5F, 3F, 0f, 1f, 4f, 3f, 2.25f, 1f, 480f),               
        		new FoodInfo(SakuraMain.MODID + "." + "rice_curry_cheese_burger", 12, 0.8f, false, 0.5F, 3F, 0f, 1f, 4f, 3f, 2.25f, 1f, 480f),      
        		new FoodInfo(SakuraMain.MODID + "." + "mashed_potato", 5, 0.6f, false, 0.5F, 2F, 0f, 2f, 0f, 0.5f, 4f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "mochi", 2, 0.5f, false, 0.5F, 2F, 0f, 0f, 0f, 0f, 2f, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "mochi_toasted", 4, 0.6f, false, 0.5F, 3F, 0f, 0f, 0f, 0f, 1.5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "mochi_sakura", 4, 0.6f, false, 0.5F, 3F, 0f, 1f, 0f, 0.5f, 2f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "ohagi", 6, 0.6f, false, 0.5F, 3F, 0f, 0.5f, 0f, 0.5f, 2.25f, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "croquette", 6, 0.6f, false, 2f, 2f, 0f, 2.5f, 2f, 0f, 1.5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "natto", 2, 0.5f, false, 0.5F, 1F, 0f, 2f, 0f, 0f, 2f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "rice_natto", 5, 0.6f, false, 0.5F, 2.5F, 0f, 2f, 0f, 0f, 2.25f, 1f, 480f),     
        		new FoodInfo(SakuraMain.MODID + "." + "rice_natto_egg", 6, 0.6f, false, 0.5F, 2.5F, 0f, 3f, 0f, 3f, 2.25f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "nikujaga", 8, 0.6f, false, 0.5F, 2F, 0f, 3f, 4f, 2f, 3f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "omurice", 8, 0.6f, false, 0.5F, 2F, 0f, 3f, 3f, 2f, 2.5f, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "rice_fried", 8, 0.6f, false, 0.5F, 1.5F, 0f, 2f, 2f, 0f, 2.5f, 1f, 480f), 
        		new FoodInfo(SakuraMain.MODID + "." + "hamburger", 8, 0.6f, false, 0.5F, 2F, 0f, 2f, 4f, 1f, 3f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "cheese_burger", 10, 0.8f, false, 0.5F, 2F, 0f, 2f, 4f, 3f, 3f, 1f, 480f),   
        		new FoodInfo(SakuraMain.MODID + "." + "mabodofu", 8, 0.6f, false, 1F, 1F, 0f, 3f, 1f, 0f, 4f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "maboqiezi", 8, 0.6f, false, 1F, 1F, 0f, 4f, 0f, 0f, 4f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "chestnut_toasted", 4, 0.4f, false, 0.5F, 2F, 0f, 2f, 0f, 0f, 2.5f, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "soup_red_bean", 6, 0.6f, false, 5F, 2F, 0f, 2f, 0f, 2f, 5f, 0f, 0f), 
        		new FoodInfo(SakuraMain.MODID + "." + "pound_cake", 5, 0.6f, false, 0.5F, 4F, 2f, 0f, 0f, 4f, 3f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "osuimono", 4, 0.5f, false, 50F, 0F, 0f, 0f, 0f, 0f, 5f, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "ochazuke", 6, 0.6f, false, 50F, 0F, 0f, 2f, 2f, 2f, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "shrimp", 2, 0.6f, false, 0.5F, 0F, 0f, 0f, 2f, 0f, 2f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "tempura", 5, 0.6f, false, 0F, 1F, 0f, 0f, 2f, 0f, 1.5f, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "fishcake", 4, 0.6f, false, 1f, 1f, 0f, 1f, 2f, 0f, 1.5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "tofu", 2, 0.4f, false, 0.5F, 0F, 0f, 2f, 0f, 0.5f, 3f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "tofu_fried", 4, 0.5f, false, 0.5F, 0.5F, 0f, 3f, 0f, 0.5f, 2f, 1f, 480f),     
        		new FoodInfo(SakuraMain.MODID + "." + "oden", 8, 0.6f, false, 1F, 1F, 0f, 3f, 3f, 0f, 4f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "dananko", 6, 0.6f, false, 1F, 3F, 0f, 0f, 0f, 1f, 2f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "danmitarashi", 6, 0.4f, false, 1F, 3F, 0f, 0f, 0f, 1f, 2f, 1f, 480f),        
        		new FoodInfo(SakuraMain.MODID + "." + "dansansyoku", 6, 0.6f, false, 1F, 3F, 0f, 0f, 0f, 1f, 2f, 1f, 480f),   
        		new FoodInfo(SakuraMain.MODID + "." + "eggplant_baked", 4, 0.5f, false, 1F, 0F, 0f, 3f, 0f, 0f, 3f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "fried_chicken", 6, 0.6f, false, 2f, 1f, 0f, 0f, 4f, 0f, 1.5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "sashimi", 6, 0.6f, false, 1F, 0F, 0f, 1f, 3f, 0f, 4f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "beef_stick", 8, 0.8f, false, 2f, 0f, 0f, 0f, 4f, 0f, 1.5f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "chicken_stick", 6, 0.4f, false, 2f, 0f, 0f, 0f, 4f, 0f, 1.5f, 1f, 480f),          
        		new FoodInfo(SakuraMain.MODID + "." + "pork_stick", 6, 0.6f, false, 2f, 0f, 0f, 0f, 4f, 0f, 1.5f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "ramen_croquette", 9, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "udon_croquette", 9, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),                
        		new FoodInfo(SakuraMain.MODID + "." + "soba_croquette", 9, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),               
        		new FoodInfo(SakuraMain.MODID + "." + "ramen_chicken", 9, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),             
        		new FoodInfo(SakuraMain.MODID + "." + "udon_chicken", 9, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),                    
        		new FoodInfo(SakuraMain.MODID + "." + "soba_chicken", 9, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),            
        		new FoodInfo(SakuraMain.MODID + "." + "tamagoyaki", 6, 0.6f, false, 0.5F, 2F, 0f, 0f, 0f, 3f, 3f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "sushi", 5, 0.6f, false, 1F, 2F, 0f, 0f, 2f, 0f, 4f, 1f, 480f),     
        		new FoodInfo(SakuraMain.MODID + "." + "sushi_tamago", 4, 0.6f, false, 1F, 2F, 0f, 0f, 0f, 2f, 4f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "ehoumaki", 8, 0.6f, false, 1F, 2F, 0f, 3f, 3f, 2f, 4f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "pudding", 4, 0.4f, false, 2F, 2F, 0f, 0f, 0f, 2f, 2.5f, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "pudding_maple", 6, 0.6f, false, 2F, 3F, 0f, 0f, 0f, 2f, 2.5f, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "rice_redbean", 6, 0.6f, false, 0.5F, 4F, 0f, 2f, 0f, 0f, 3f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "fish_bake", 8, 0.8f, false, 0.5F, 0F, 0f, 0f, 4f, 0f, 3f, 1f, 480f),     
        		new FoodInfo(SakuraMain.MODID + "." + "fries", 5, 0.6f, false, 1F, 2F, 0f, 2f, 0f, 0f, 1f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "furofuki_daikon", 5, 0.6f, false, 25F, 0F, 0f, 4f, 0f, 0f, 5f, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "cabbage_roll", 4, 0.4f, false, 25F, 0F, 0f, 4f, 0f, 0f, 5f, 1f, 480f),           
        		new FoodInfo(SakuraMain.MODID + "." + "white_stew", 6, 0.6f, false, 35F, 2F, 2f, 2f, 2f, 2f, 5f, 0f, 0f), 
        		new FoodInfo(SakuraMain.MODID + "." + "fruitsalad", 6, 0.6f, false, 15F, 2F, 4f, 0f, 0f, 2f, 5.5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "raw_taiyaki", 2, 0.2f, false, 0.5F, 0.5F, 0f, 0f, 0f, 0f, 2f, 1f, 480f),     
        		new FoodInfo(SakuraMain.MODID + "." + "taiyaki", 6, 0.6f, false, 0.5F, 4F, 0f, 0f, 0f, 4f, 1f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "lemon",  1, 0.1f, false, 5f, 0f, 2f, 0f, 0f, 0f, 3.5f, 1f, 480f),     
        		new FoodInfo(SakuraMain.MODID + "." + "lemon_juice",  1, 0.1f, false, 40F, 0F, 2f, 0f, 0f, 0f, 5f, 0f, 0f),            
        		new FoodInfo(SakuraMain.MODID + "." + "soda_water", 1, 0.1f, false, 50F, 0F, 0f, 0f, 0f, 0f, 5f, 0f, 0f), 
        		new FoodInfo(SakuraMain.MODID + "." + "almond", 1, 0.1f, false, 0F, 0F, 0f, 0f, 0f, 0f, 2f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "blackcurrant_juice", 1, 0.1f, false, 40F, 0F, 2f, 0f, 0f, 0f, 5f, 0f, 0f),     
        		new FoodInfo(SakuraMain.MODID + "." + "orange_juice", 1, 0.1f, false, 40F, 0F, 2f, 0f, 0f, 0f, 5f, 0f, 0f),      
        		new FoodInfo(SakuraMain.MODID + "." + "grape_green", 2, 0.2f, false, 4F, 0F, 2F, 0F, 0.5F, 0F, 5F, 0f, 0f),  
        		new FoodInfo(SakuraMain.MODID + "." + "sliced_cabbage", 2, 0.2f, false, 5f, 0f, 0f, 2f, 0f, 0f, 2.5f, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "sushi_shrimp", 5, 0.6f, false, 1F, 2F, 0f, 0f, 2f, 0f, 4f, 1f, 480f),     
        		new FoodInfo(SakuraMain.MODID + "." + "curry_omurice", 8, 0.6f, false, 0.5F, 3F, 0f, 1f, 4f, 3f, 2.25f, 1f, 480f), 
        		new FoodInfo(SakuraMain.MODID + "." + "katsu_dish", 10, 0.8f, false, 0.5F, 0.5F, 0f, 2f, 5f, 1f, 3f, 1f, 480f),     
        		new FoodInfo(SakuraMain.MODID + "." + "croquette_dish", 8, 0.6f, false, 0.5F, 0.5F, 0f, 2f, 5f, 1f, 3f, 1f, 480f), 
        		new FoodInfo(SakuraMain.MODID + "." + "pasta_tomato", 9, 0.8f, false, 1.5F, 2F, 0F, 4F, 4F, 2F, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "pasta_mushroom", 9, 0.8f, false, 1.5F, 2F, 0F, 4F, 4F, 2F, 5f, 1f, 480f),        
        		new FoodInfo(SakuraMain.MODID + "." + "pasta_whitesauce", 9, 0.8f, false, 1.5F, 2F, 0F, 4F, 4F, 2F, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "egg_soft", 2, 0.6F, false, 1F, 0F, 0F, 0F, 0.0F, 3.0F, 2F, 1f, 480f), 
        		new FoodInfo(SakuraMain.MODID + "." + "egg_soysauce", 4, 0.6F, false, 1F, 0F, 0F, 0F, 0.0F, 3.5F, 1.0F, 1f, 480f), 
        		new FoodInfo(SakuraMain.MODID + "." + "buckwheat_bread", 5, 0.6f, false, 0f, 2f, 0f, 0f, 0f, 0f, 0.5f, 1f, 480f),
        		
        		new FoodInfo(SakuraMain.MODID + "." + "chawanmushi", 6, 0.5f, false, 5f, 0f, 0f, 3f, 3f, 3f, 5f, 2f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "dorayaki", 6, 0.6f, false, 1f, 5f, 2f, 2f, 0f, 0f, 2f, 2f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "machined_fish", 1, 0.2f, false, 1f, 0f, 0f, 0f, 2f, 2f, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "matsutake", 1, 0.2f, false, 1f, 0f, 0f, 2f, 0f, 0f, 2f, 2f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "edodes", 1, 0.2f, false, 1f, 0f, 0f, 2f, 0f, 0f, 2f, 2f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "shimeji", 1, 0.2f, false, 1f, 0f, 0f, 2f, 0f, 0f, 2f, 2f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "roast_matsutake", 5, 0.6f, false, 0f, 0f, 0f, 3f, 0f, 0f, 1f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "rice_matsutake", 8, 0.6f, false, 0.5F, 2F, 0F, 3F, 0F, 1F, 2F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "onigiri_matsutake",9, 0.7f, false, 0.5F, 2F, 0F, 4F, 0F, 1F, 2F, 1f, 480f),   
        		
        		new FoodInfo(SakuraMain.MODID + "." + "bonito", 2, 0.2f, false, 1f, 0f, 0f, 0f, 2f, 2f, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "machined_bonito", 1, 0.2f, false, 1f, 0f, 0f, 0f, 2f, 2f, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "boiled_bonito", 2, 0.2f, false, 3f, 0f, 0f, 0f, 2f, 2f, 5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "smoked_bonito", 3, 0.3f, false, 0f, 0f, 0f, 0f, 2f, 2f, 3f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "dried_bonito", 3, 0.3f, false, 0f, 0f, 0f, 0f, 2f, 2f, 0f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "bonito_shaving", 1, 0.1f, false, 0f, 0f, 0f, 0f, 2f, 2f, 0f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "dough_okinoyaki", 2, 0.2f, false, 0F, 2F, 0F, 2F, 2F, 2F, 0F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "okinoyaki",8, 0.8f, false, 0.5F, 2F, 0F, 3F, 3F, 3F, 1F, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "okinoyaki_plus", 10, 1f, false, 1F, 3F, 3F, 3F, 3F, 3F, 1F, 1f, 480f),    
        		new FoodInfo(SakuraMain.MODID + "." + "okinoyaki_final", 12, 1f, false, 1F, 5F, 5F, 5F, 5F, 5F, 1F, 1f, 480f),    
        		
        		new FoodInfo(SakuraMain.MODID + "." + "nimono_pumpkin", 6, 0.5f, false, 5F, 2F, 0F, 2F, 0F, 0F, 5F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "nimono_radish", 6, 0.5f, false, 5F, 2F, 0F, 2F, 0F, 0F, 5F, 1f, 480f),  
        		new FoodInfo(SakuraMain.MODID + "." + "nimono_fish", 8, 1f, false, 6F, 0F, 0F, 0F, 3F, 3F, 5F, 1f, 480f),    
        		new FoodInfo(SakuraMain.MODID + "." + "chikuzenni", 12, 1f, false, 5F, 0F, 5F, 5F, 5F, 5F, 5F, 1f, 480f),
        		
        		new FoodInfo(SakuraMain.MODID + "." + "yaki_soba", 9, 0.7f, false, 2.5F, 1.5F, 0F, 4F, 2F, 2F, 3.5f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "yaki_pasta", 9, 0.7f, false, 2.5F, 1.5F, 0F, 4F, 2F, 2F, 3.5f, 1f, 480f),
        		
        		new FoodInfo(SakuraMain.MODID + "." + "taiyaki_mocha", 8, 0.6f, false, 0.5F, 4F, 0f, 0f, 0f, 4f, 1f, 1f, 480f),
        		new FoodInfo(SakuraMain.MODID + "." + "mocha_cookie",  5, 0.25f, false, 0.75F, 2F, 0F, 0F, 0F, 0.2F, 0.8F, 1f, 480f),         
        		new FoodInfo(SakuraMain.MODID + "." + "pudding_mocha", 6, 0.6f, false, 2F, 3F, 0f, 0f, 0f, 2f, 2.5f, 1f, 480f),    
        		new FoodInfo(SakuraMain.MODID + "." + "pound_cake_mocha", 7, 0.6f, false, 0.5F, 4F, 2f, 0f, 0f, 4f, 3f, 1f, 480f),  
        		
        		new FoodInfo(SakuraMain.MODID + "." + "soup_miso", 5, 0.5f, false, 50F, 0F, 0f, 0f, 0f, 0f, 5f, 1f, 480f),         
    	}
    );
    public static ItemDoor BAMBOO_DOOR = new ItemDoor(BlockLoader.BAMBOODOOR);
    public static ItemBase MATERIAL = new ItemBase(SakuraMain.MODID,"materials", 64, new String[]{
            SakuraMain.MODID + "." + "straw",//0
            SakuraMain.MODID + "." + "rice",//1
            SakuraMain.MODID + "." + "salt",//2
            SakuraMain.MODID + "." + "curry_powder",//3
            SakuraMain.MODID + "." + "flour",//4
            SakuraMain.MODID + "." + "flour_buckwheat",//5
            SakuraMain.MODID + "." + "dough",//6
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
            SakuraMain.MODID + "." + "alkaline",//35
            SakuraMain.MODID + "." + "yeast",//36
            SakuraMain.MODID + "." + "hop",//37
            SakuraMain.MODID + "." + "brown_rice",//38
            SakuraMain.MODID + "." + "green_tea_leaves",//39
            SakuraMain.MODID + "." + "black_tea_leaves",//40
            SakuraMain.MODID + "." + "earl_grey_leaves",//41
            SakuraMain.MODID + "." + "fruit_tea_leaves",//42
            SakuraMain.MODID + "." + "mocha",//43
            SakuraMain.MODID + "." + "rice_tea_leaves",//44
            SakuraMain.MODID + "." + "mint",//45
            SakuraMain.MODID + "." + "mint_tea_leaves",//46
            SakuraMain.MODID + "." + "empty_bottle",//47
            SakuraMain.MODID + "." + "bamboo_sunburnt",//48
            SakuraMain.MODID + "." + "maple_syrup",//49
            SakuraMain.MODID + "." + "coin",//50
            SakuraMain.MODID + "." + "bamboo_charcoal",//51
            
            SakuraMain.MODID + "." + "zuku",//52
            SakuraMain.MODID + "." + "zuku_ingot",//53
            SakuraMain.MODID + "." + "sagegane",//54
            SakuraMain.MODID + "." + "tamahagane",//55
            SakuraMain.MODID + "." + "steel_ingot",//56
            SakuraMain.MODID + "." + "pasta_raw",//57
            
            SakuraMain.MODID + "." + "bento_box",//58
            SakuraMain.MODID + "." + "silk",//59
            
            SakuraMain.MODID + "." + "worcester_sauce",//60
            SakuraMain.MODID + "." + "mayo",//61
            SakuraMain.MODID + "." + "vinegar",//62
            
            });
    public static Item POT = new ItemPot();
    public static Item KNIFE_NOODLE = new ItemKnifeNoodle(ToolMaterial.IRON);
    public static Item KNIFE_FISH = new ItemKnifeNoodle(ToolMaterial.IRON).setUnlocalizedName(SakuraMain.MODID+"."+"knife_fish");
    public static Item SAKURA_DIAMOND = new ItemSakuraDiamond();
    public static Item KATANA = new ItemKatana(Item.ToolMaterial.IRON, "katana");
    public static Item TACHI = new ItemKatana(TACHI_TOOLMATERIAL, "tachi");
    public static Item KODACHI = new ItemKotachi(Item.ToolMaterial.IRON, "kodachi");
    public static ItemSheath SHEATH = new ItemSheath();
    public static Item SHINAI = new ItemShinai("shinai");
    public static Item SAKURAKATANA = new ItemKatana(SAKURA_TOOLMATERIAL, "sakura_katana");
    public static Item SAKURAKODACHI = new ItemKotachi(SAKURA_TOOLMATERIAL, "sakura_kodachi");
    public static Item HYDRA_RAMEN = new ItemFood(20, 14F * 0.25F, false).setPotionEffect(new PotionEffect(MobEffects.REGENERATION, 220, 0), 1.0F).setPotionEffect(new PotionEffect(MobEffects.SATURATION, 80, 0), 0.4F);
    public static Item BUGGYS_MEAT = new ItemBuggysMeat(20, 22F * 0.25F, false).setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 2000, 0), 1.0F).setPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 2400, 1), 1.0F);
    public static Item STRAW_HAT = new ItemStrawHat();
    public static Item KIMONO = new ItemKimono();
    public static Item HAORI = new ItemHaori();
    public static Item FUTON = new ItemFuton();
    public static ItemSheathKatana KATANA_SHEATH = new ItemSheathKatana(KATANA);
    public static ItemSheathKatana SAKURAKATANA_SHEATH = new ItemSheathKatana(SAKURAKATANA);
    public static Item STONE_HAMMER = new ItemHammer(ToolMaterial.STONE).setUnlocalizedName(SakuraMain.MODID + "." + "stone_hammer");
    public static Item IRON_HAMMER = new ItemHammer(ToolMaterial.IRON).setUnlocalizedName(SakuraMain.MODID + "." + "iron_hammer");
    public static Item SAKURA_HAMMER = new ItemHammer(SAKURA_TOOLMATERIAL).setUnlocalizedName(SakuraMain.MODID + "." + "sakura_hammer");
   
    public static Item SAKURA_KNIFE_NOODLE = new ItemKnifeNoodle(SAKURA_TOOLMATERIAL).setMaxDamage(SAKURA_TOOLMATERIAL.getMaxUses()).setUnlocalizedName(SakuraMain.MODID+"."+"sakura_knife_noodle");
    public static Item SAKURA_KNIFE_FISH = new ItemKnifeNoodle(SAKURA_TOOLMATERIAL).setMaxDamage(SAKURA_TOOLMATERIAL.getMaxUses()).setUnlocalizedName(SakuraMain.MODID+"."+"sakura_knife_fish");
    
    public static ItemFoodBase BENTO = new ItemFoodContain(SakuraMain.MODID, "bento", 1,
    new FoodInfo[]{
    	new FoodInfo(SakuraMain.MODID + "." + "bento_0", 14, 0.8F, false, 10F, 10F, 10F, 10F, 10F, 10F, 2, 0F, 480),
    	new FoodInfo(SakuraMain.MODID + "." + "bento_1", 16, 0.8F, false, 10F, 10F, 10F, 10F, 10F, 10F, 2, 0F, 480),
    	new FoodInfo(SakuraMain.MODID + "." + "bento_2", 14, 0.8F, false, 10F, 10F, 10F, 10F, 10F, 10F, 2, 0F, 480),
    	new FoodInfo(SakuraMain.MODID + "." + "bento_3", 14, 0.8F, false, 10F, 10F, 10F, 10F, 10F, 10F, 2, 0F, 480),
    },new ItemStack[]{
    	new ItemStack(MATERIAL,1,58),
    	new ItemStack(MATERIAL,1,58),
    	new ItemStack(MATERIAL,1,58),
    	new ItemStack(MATERIAL,1,58),
    });
    
    public ItemLoader(FMLPreInitializationEvent event) {
    	register(cup);
        register(POT);
        register(KIMONO);
        register(HAORI);
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
        register(SEAWEED_RAW);
        register(KNIFE_NOODLE);
        register(KNIFE_FISH);
        register(SAKURA_DIAMOND);
        register(SAKURA_KNIFE_NOODLE);
        register(SAKURA_KNIFE_FISH);
        register(MATERIAL);
        register(FOODSET);
        register(HYDRA_RAMEN.setUnlocalizedName(SakuraMain.MODID + "." + "hydra_ramen"));
        register(BUGGYS_MEAT);
    	register(BENTO);
    	register(FUTON);
        register(STRAW_HAT);
        register(BROOM);
        register(SHINAI);
        register(KATANA);
        register(SAKURAKATANA);
        register(SHEATH);
        register(KATANA_SHEATH);
        register(SAKURAKATANA_SHEATH);
        register(KODACHI);
        register(SAKURAKODACHI);
        register(TACHI);
        register(SAMURAI_HELMET);
        register(SAMURAI_CHEST);
        register(SAMURAI_PANTS);
        register(SAMURAI_SHOES);
    	register(STONE_HAMMER);
        register(IRON_HAMMER);
        register(SAKURA_HAMMER);
        MinecraftForge.addGrassSeed(new ItemStack(TOMATO_SEEDS), 2);
        MinecraftForge.addGrassSeed(new ItemStack(ONION_SEEDS), 2);
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
    	ItemRegister.registerRender(SAKURA_KNIFE_NOODLE);
        ItemRegister.registerRender(SAKURA_KNIFE_FISH);
    	ItemRegister.registerRender(KNIFE_FISH);
    	ItemRegister.registerRender(SEAWEED_RAW);
    	ItemRegister.registerRender(FUTON);
    	ItemRegister.registerRender(BENTO);
    	ItemRegister.registerRender(STONE_HAMMER);
    	ItemRegister.registerRender(IRON_HAMMER);
    	ItemRegister.registerRender(SAKURA_HAMMER);
    	ItemRegister.registerRender(SHEATH);
    	ItemRegister.registerRender(HAORI);
    	ItemRegister.registerRender(KIMONO);
    	ItemRegister.registerRender(BROOM);
    	ItemRegister.registerRender(SAMURAI_HELMET);
    	ItemRegister.registerRender(SAMURAI_CHEST);
    	ItemRegister.registerRender(SAMURAI_PANTS);
    	ItemRegister.registerRender(SAMURAI_SHOES);
    	ItemRegister.registerRender(TACHI);
    	ItemRegister.registerRender(ONION);
    	ItemRegister.registerRender(ONION_SEEDS);
    	ItemRegister.registerRender(SHINAI);
    	ItemRegister.registerRender(KODACHI);
    	ItemRegister.registerRender(SAKURAKODACHI);
    	ItemRegister.registerRender(KNIFE_NOODLE);
    	ItemRegister.registerRender(POT);
    	ItemRegister.registerRender(CABBAGE);
    	ItemRegister.registerRender(CABBAGE_SEEDS);
    	ItemRegister.registerRender(TOMATO);
    	ItemRegister.registerRender(TOMATO_SEEDS);
    	ItemRegister.registerRender(EGGPLANT);
    	ItemRegister.registerRender(EGGPLANT_SEEDS);
    	ItemRegister.registerRender(RADISH);
    	ItemRegister.registerRender(RADISH_SEEDS);
    	ItemRegister.registerRender(BUCKWHEAT);
    	ItemRegister.registerRender(MATERIAL);
    	ItemRegister.registerRender(RAPESEED);
    	ItemRegister.registerRender(RICE_SEEDS);
    	ItemRegister.registerRender(RED_BEAN);
    	ItemRegister.registerRender(BAMBOO_DOOR);
    	ItemRegister.registerRender(FOODSET);
    	ItemRegister.registerRender(HYDRA_RAMEN);
    	ItemRegister.registerRender(BUGGYS_MEAT);
    	ItemRegister.registerRender(STRAW_HAT);
    	ItemRegister.registerRender(SAKURA_DIAMOND);
    	ItemRegister.registerRender(KATANA);
    	ItemRegister.registerRender(SAKURAKATANA);
    	ItemRegister.registerRender(KATANA_SHEATH);
    	ItemRegister.registerRender(SAKURAKATANA_SHEATH);
    	ItemRegister.registerRender(cup);
    }

    private static void register(Item item) {
        item.setCreativeTab(CommonProxy.tab);
        ItemRegister.register(SakuraMain.MODID, item);
    }
}
