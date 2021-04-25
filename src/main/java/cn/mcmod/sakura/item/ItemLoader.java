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
import cn.mcmod_mmf.mmlib.item.ItemAxeBlank;
import cn.mcmod_mmf.mmlib.item.ItemBase;
import cn.mcmod_mmf.mmlib.item.ItemHoeBlank;
import cn.mcmod_mmf.mmlib.item.ItemMetaDurability;
import cn.mcmod_mmf.mmlib.item.ItemPickaxeBlank;
import cn.mcmod_mmf.mmlib.item.ItemShovelBlank;
import cn.mcmod_mmf.mmlib.item.food.ItemFoodBase;
import cn.mcmod_mmf.mmlib.item.food.ItemFoodContain;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import cn.mcmod_mmf.mmlib.register.ItemRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoader {
    public static Item SAKURA_DIAMOND = new ItemSakuraDiamond();
	
    public static final ItemArmor.ArmorMaterial STRAW_MATERIAL = EnumHelper.addArmorMaterial("STRAW_MATERIAL", SakuraMain.MODID + ":textures/models/armor/strawhat.png", 6, new int[]{0, 0, 0, 1}, 30, net.minecraft.init.SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
    public static final ItemTool.ToolMaterial SAKURA_TOOLMATERIAL = EnumHelper.addToolMaterial("SAKURA_TOOLMATERIAL", 4, 1561, 8.5F, 4.0F, 12);
    public static final ItemTool.ToolMaterial TACHI_TOOLMATERIAL = EnumHelper.addToolMaterial("TACHI_TOOLMATERIAL", 3, 457, 7F, 3.0F, 18);
    public static final ItemTool.ToolMaterial STRAW_TOOLMATERIAL = EnumHelper.addToolMaterial("STRAW_TOOLMATERIAL", 0, 256, 2F, 1.0F, 8);
    public static final ItemArmor.ArmorMaterial SAMURAI_MATERIAL = EnumHelper.addArmorMaterial("SAMURAI_MATERIAL", SakuraMain.MODID + ":textures/models/armor/samurai_armor.png", 33, new int[]{5, 8, 9, 5}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.5F).setRepairItem(new ItemStack(SAKURA_DIAMOND));
    public static final ItemArmor.ArmorMaterial SOLDIER_MATERIAL = EnumHelper.addArmorMaterial("SOLDIER_MATERIAL", SakuraMain.MODID + ":textures/models/armor/soldier_armor.png", 16, new int[]{2, 5, 6, 2}, 14, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5F).setRepairItem(new ItemStack(Items.IRON_INGOT));

    public static final ItemArmor.ArmorMaterial KIMONO_MATERIAL = EnumHelper.addArmorMaterial("KIMONO_MATERIAL", SakuraMain.MODID + ":textures/models/armor/kimono_base.png", -1, new int[]{0, 0, 0, 0}, 0, net.minecraft.init.SoundEvents.BLOCK_CLOTH_PLACE, 0);
    public static ItemBase cup = new ItemBase(SakuraMain.MODID,"cup", 32, new String[]{
    		"cup"
    });
    
    public static Item SAKURA_AXE = new ItemAxeBlank(SAKURA_TOOLMATERIAL,9.0F,-3.3F).setUnlocalizedName("sakura.sakura_axe");
    public static Item SAKURA_PICKAXE = new ItemPickaxeBlank(SAKURA_TOOLMATERIAL).setUnlocalizedName("sakura.sakura_pickaxe");
    public static Item SAKURA_HOE = new ItemHoeBlank(SAKURA_TOOLMATERIAL).setUnlocalizedName("sakura.sakura_hoe");
    public static Item SAKURA_SHOVEL = new ItemShovelBlank(SAKURA_TOOLMATERIAL).setUnlocalizedName("sakura.sakura_shovel");
    
    public static Item BROOM = new ItemBroom(STRAW_TOOLMATERIAL).setUnlocalizedName("sakura.broom");
    
    public static Item SAMURAI_HELMET=new ItemSamuraiArmors("samurai_helmet", false, SAMURAI_MATERIAL, 0, EntityEquipmentSlot.HEAD);
    public static Item SAMURAI_CHEST=new ItemSamuraiArmors("samurai_chest", false, SAMURAI_MATERIAL, 0, EntityEquipmentSlot.CHEST);
    public static Item SAMURAI_PANTS=new ItemSamuraiArmors("samurai_pants", false, SAMURAI_MATERIAL, 0, EntityEquipmentSlot.LEGS);
    public static Item SAMURAI_SHOES=new ItemSamuraiArmors("samurai_shoes", false, SAMURAI_MATERIAL, 0, EntityEquipmentSlot.FEET);
    
    public static Item SOLDIER_HELMET=new ItemSamuraiArmors("soldier_helmet", true, SOLDIER_MATERIAL, 0, EntityEquipmentSlot.HEAD);
    public static Item SOLDIER_CHEST=new ItemSamuraiArmors("soldier_chest", true, SOLDIER_MATERIAL, 0, EntityEquipmentSlot.CHEST);
    public static Item SOLDIER_PANTS=new ItemSamuraiArmors("soldier_pants", true, SOLDIER_MATERIAL, 0, EntityEquipmentSlot.LEGS);
    public static Item SOLDIER_SHOES=new ItemSamuraiArmors("soldier_shoes", true, SOLDIER_MATERIAL, 0, EntityEquipmentSlot.FEET);
    
    public static Item RICE_SEEDS = new ItemRiceSeeds();
    
    public static Item SEAWEED_RAW = new ItemSeaweed();
    
    public static Item TOMATO = new ItemFood(2, false).setUnlocalizedName("sakura.tomato");
    public static Item TOMATO_SEEDS = new ItemSeeds(BlockLoader.TOMATOCROP, Blocks.FARMLAND).setUnlocalizedName("sakura.tomato_seeds");
    public static Item EGGPLANT = new ItemFood(2, false).setUnlocalizedName("sakura.eggplant");
    public static Item EGGPLANT_SEEDS = new ItemSeeds(BlockLoader.EGGPLANTCROP, Blocks.FARMLAND).setUnlocalizedName("sakura.eggplant_seeds");
    public static Item CABBAGE = new ItemFood(2, false).setUnlocalizedName("sakura.cabbage");
    public static Item CABBAGE_SEEDS = new ItemSeeds(BlockLoader.CABBAGECROP, Blocks.FARMLAND).setUnlocalizedName("sakura.cabbage_seeds");
    public static Item RADISH = new ItemFood(2, false).setUnlocalizedName("sakura.radish");
    public static Item TARO = new ItemSeedFood(2, 0.2F, BlockLoader.TARO_CROP, Blocks.FARMLAND).setUnlocalizedName("sakura.taro");
    public static Item RADISH_SEEDS = new ItemSeeds(BlockLoader.RADISHCROP, Blocks.FARMLAND).setUnlocalizedName("sakura.radish_seeds");
    public static Item RED_BEAN = new ItemSeeds(BlockLoader.REDBEANCROP, Blocks.FARMLAND).setUnlocalizedName("sakura.red_bean");
    public static Item BUCKWHEAT = new ItemSeeds(BlockLoader.BUCKWHEATCROP, Blocks.FARMLAND).setUnlocalizedName("sakura.buckwheat");
    public static Item RAPESEED = new ItemSeeds(BlockLoader.RAPESEEDCROP, Blocks.FARMLAND).setUnlocalizedName("sakura.rapeseeds");
    public static Item ONION = new ItemFood(2, false).setUnlocalizedName("sakura.onion");
    public static Item ONION_SEEDS = new ItemSeeds(BlockLoader.ONIONCROP, Blocks.FARMLAND).setUnlocalizedName("sakura.onion_seeds");
    
    public static ItemFoodBase FOODSET = new ItemFoodBase(SakuraMain.MODID,"foodset", 64,
           new FoodInfo[]{
        		new FoodInfo("grape", 1, 0.25f, false, 4F, 0.25F, 0F, 1F, 0F, 0F, 5F, 0, -1),  
        		new FoodInfo("maple_cookie", 3, 0.25f, false, 0.75F, 2F, 0F, 0F, 0F, 0.2F, 0.8F, 1f, 480f),         
        		new FoodInfo("rice_bread", 5, 0.6f, false, 0f, 2f, 0f, 0f, 0f, 0f, 0f, 1f, 480f),
        		new FoodInfo("red_bean_paste", 4, 0.25f, false, 4F, 0.25F, 0F, 1F, 0F, 0F, 4F, 0, -1),  
        		new FoodInfo("bun", 5, 0.6f, false, 0F, 2F, 0F, 0F, 0F, 0F, 0.8F, 1f, 480f),         
        		new FoodInfo("cheese", 2, 0.2f, false, 1f, 0f, 0f, 0f, 0f, 2f, 2f, 0, -1),	
        		new FoodInfo("katsu", 9, 0.6f, false, 4F, 0.25F, 0F, 0F, 3F, 0F, 1.25F, 0, -1),  
        		new FoodInfo("rice_cooked", 4, 0.5f, false, 0.5F, 1.5F, 0F, 0F, 0F, 0F, 2F, 1f, 480f),         
        		new FoodInfo("rice_bamboo", 5, 0.6f, false, 0.5F, 1.5F, 1f, 0f, 0f, 0f, 2.25f, 1f, 480f),
        		new FoodInfo("rice_fish", 7, 0.7f, false, 0.5F, 1.5F, 0f, 0f, 2f, 0f, 2.25f, 1f, 480f),  
        		new FoodInfo("rice_beef", 9, 0.8f, false, 0.5F, 1.5F, 0F, 0F, 3F, 0F, 2.25f, 1f, 480f),         
        		new FoodInfo("rice_pork", 7, 0.7f, false, 0.5F, 1.5F, 0F, 0F, 3F, 0F, 2.25f, 1f, 480f),  
        		new FoodInfo("rice_mushroom", 6, 0.6f, false, 0.5F, 1.5F, 0F, 2F, 0F, 0F, 2F, 1f, 480f),         
        		new FoodInfo("rice_egg", 5, 0.6f, false, 0.5F, 1.5F, 0f, 0f, 0f, 2f, 2.25f, 1f, 480f),
        		new FoodInfo("rice_beef_egg", 10, 1f, false, 0.5F, 1.5F, 0f, 0f, 3.5f, 2f, 2.25f, 1f, 480f),  
        		new FoodInfo("rice_pork_egg", 9, 0.8f, false, 0.5F, 1.5F, 0f, 0F, 3.5f, 2f, 2.25f, 1f, 480f),         
        		new FoodInfo("rice_pork_fried", 10, 1f, false, 0.5F, 2F, 0F, 0F, 4F, 4F, 2.25f, 1f, 480f),	
        		new FoodInfo("rice_oyako", 9, 0.8f, false, 0.5F, 1.5F, 0f, 0f, 3.5f, 2f, 2.25f, 1f, 480f),  
        		new FoodInfo("rice_oyako_fish", 9, 0.8f, false, 0.5F, 1.5F, 0f, 0f, 3.5f, 2f, 2.25f, 1f, 480f),  
        		new FoodInfo("ramen", 4, 0.5f, false, 35F, 1.5F, 0F, 0F, 0F, 0F, 0F, 1f, 480f),         
        		new FoodInfo("ramen_beef", 9, 0.8f, false, 35F, 1.5F, 0F, 0F, 3F, 0F, 5f, 1f, 480f),
        		new FoodInfo("ramen_egg", 5, 0.6f, false, 35F, 1.5F, 0f, 0f, 0f, 2f, 5f, 1f, 480f),  
        		new FoodInfo("ramen_tempura", 9, 0.8f, false, 35F, 2F, 0F, 0F, 3F, 0F, 5f, 1f, 480f),         
        		new FoodInfo("ramen_friedtofu", 9, 0.7f, false, 35F, 2F, 0F, 2F, 0F, 0F, 5f, 1f, 480f),
        		new FoodInfo("ramen_katsu", 10, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),         
        		new FoodInfo("ramen_large", 12, 1f, false, 35F, 2F, 0F, 5F, 5F, 2F, 5f, 1f, 480f),
        		new FoodInfo("udon", 4, 0.5f, false, 35F, 1.5F, 0F, 0F, 0F, 0F, 4F, 1f, 480f),         
        		new FoodInfo("udon_beef", 9, 0.8f, false, 35F, 1.5F, 0F, 0F, 3F, 0F, 5f, 1f, 480f),
        		new FoodInfo("udon_egg", 5, 0.6f, false, 35F, 1.5F, 0f, 0f, 0f, 2f, 5f, 1f, 480f),  
        		new FoodInfo("udon_tempura", 9, 0.8f, false, 35F, 2F, 0F, 0F, 3F, 0F, 5f, 1f, 480f),           
        		new FoodInfo("udon_friedtofu", 9, 0.7f, false, 35F, 2F, 0F, 2F, 0F, 0F, 5f, 1f, 480f),
        		new FoodInfo("udon_katsu", 10, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),         
        		new FoodInfo("udon_large", 12, 1f, false, 35F, 2F, 0F, 5F, 5F, 2F, 5f, 1f, 480f),
        		new FoodInfo("yaki_udon", 9, 0.7f, false, 2.5F, 1.5F, 0F, 4F, 2F, 2F, 3.5f, 1f, 480f),
        		new FoodInfo("soba", 4, 0.5f, false, 35F, 1.5F, 0F, 0F, 0F, 0F, 4F, 1f, 480f),         
        		new FoodInfo("soba_beef", 9, 0.8f, false, 35F, 1.5F, 0F, 0F, 3F, 0F, 5f, 1f, 480f),
        		new FoodInfo("soba_egg", 5, 0.6f, false, 35F, 1.5F, 0f, 0f, 0f, 2f, 5f, 1f, 480f),  
        		new FoodInfo("soba_tempura", 9, 0.8f, false, 35F, 2F, 0F, 0F, 3F, 0F, 5f, 1f, 480f),         
        		new FoodInfo("soba_friedtofu", 9, 0.7f, false, 35F, 2F, 0F, 2F, 0F, 0F, 5f, 1f, 480f),
        		new FoodInfo("soba_katsu", 10, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),          
        		new FoodInfo("soba_large", 12, 1f, false, 35F, 2F, 0F, 5F, 5F, 2F, 5f, 1f, 480f),
        		new FoodInfo("soba_zaru", 6, 0.7f, false, 5F, 2F, 0F, 0.5F, 0F, 0F, 3.5f, 1f, 480f),
        		new FoodInfo("onigiri", 6, 0.6f, false, 0.5F, 2F, 0F, 1F, 0F, 0F, 2F, 1f, 480f),         
        		new FoodInfo("onigiri_bamboo", 7, 0.7f, false, 0.5F, 2F, 0f, 2f, 0f, 0f, 2.25f, 1f, 480f),
        		new FoodInfo("onigiri_fish", 8, 0.7f, false, 0.5F, 2F, 0f, 1f, 2f, 0f, 2.25f, 1f, 480f), 
        		new FoodInfo("onigiri_mushroom", 7, 0.7f, false, 0.5F, 2F, 0F, 2F, 0F, 0.5F, 2F, 1f, 480f),         
        		new FoodInfo("onigiri_seaweed", 7, 0.7f, false, 0.5F, 2F, 0F, 2F, 0F, 0.5F, 2.25F, 1f, 480f), 
        		new FoodInfo("onigiri_tempura", 10, 0.8f, false, 0.5F, 2F, 0F, 2F, 4F, 1F, 2.25f, 1f, 480f), 
        		new FoodInfo("burger_raw", 2, 0.2f, false, 1f, 0.5f, 0f, 0f, 3f, 0f, 2f, 1f, 200f),         
        		new FoodInfo("burger", 6, 0.6f, false, 2f, 0.5f, 0f, 0f, 4f, 0f, 2f, 1f, 200f), 
        		new FoodInfo("burger_dish", 10, 0.8f, false, 2.5F, 0.5F, 0F, 2F, 4F, 0F, 2.5f, 1f, 480f), 
        		new FoodInfo("rice_curry", 6, 0.6f, false, 0.5F, 2.5F, 0f, 1f, 1f, 1f, 2.25f, 1f, 480f),  
        		new FoodInfo("rice_curry_katsu", 10, 0.8f, false, 0.5F, 3F, 0f, 1f, 4f, 1f, 2.25f, 1f, 480f),         
        		new FoodInfo("rice_curry_burger", 10, 0.8f, false, 0.5F, 3F, 0f, 1f, 4f, 1f, 2.25f, 1f, 480f),      
        		new FoodInfo("rice_curry_cheese", 8, 0.8f, false, 0.5F, 2.5F, 0f, 1f, 1f, 4f, 2.25f, 1f, 480f),   
        		new FoodInfo("rice_curry_cheese_katsu", 12, 0.8f, false, 0.5F, 3F, 0f, 1f, 4f, 3f, 2.25f, 1f, 480f),               
        		new FoodInfo("rice_curry_cheese_burger", 12, 0.8f, false, 0.5F, 3F, 0f, 1f, 4f, 3f, 2.25f, 1f, 480f),      
        		new FoodInfo("mashed_potato", 5, 0.6f, false, 0.5F, 2F, 0f, 2f, 0f, 0.5f, 4f, 1f, 480f),  
        		new FoodInfo("mochi", 2, 0.5f, false, 0.5F, 2F, 0f, 0f, 0f, 0f, 2f, 1f, 480f),         
        		new FoodInfo("mochi_toasted", 4, 0.6f, false, 0.5F, 3F, 0f, 0f, 0f, 0f, 1.5f, 1f, 480f),
        		new FoodInfo("mochi_sakura", 4, 0.6f, false, 0.5F, 3F, 0f, 1f, 0f, 0.5f, 2f, 1f, 480f),  
        		new FoodInfo("ohagi", 6, 0.6f, false, 0.5F, 3F, 0f, 0.5f, 0f, 0.5f, 2.25f, 1f, 480f),         
        		new FoodInfo("croquette", 6, 0.6f, false, 2f, 2f, 0f, 2.5f, 2f, 0f, 1.5f, 1f, 480f),
        		new FoodInfo("natto", 2, 0.5f, false, 0.5F, 1F, 0f, 2f, 0f, 0f, 2f, 1f, 480f),
        		new FoodInfo("rice_natto", 5, 0.6f, false, 0.5F, 2.5F, 0f, 2f, 0f, 0f, 2.25f, 1f, 480f),     
        		new FoodInfo("rice_natto_egg", 6, 0.6f, false, 0.5F, 2.5F, 0f, 3f, 0f, 3f, 2.25f, 1f, 480f),
        		new FoodInfo("nikujaga", 8, 0.6f, false, 0.5F, 2F, 0f, 3f, 4f, 2f, 3f, 1f, 480f),  
        		new FoodInfo("omurice", 8, 0.6f, false, 0.5F, 2F, 0f, 3f, 3f, 2f, 2.5f, 1f, 480f),         
        		new FoodInfo("rice_fried", 8, 0.6f, false, 0.5F, 1.5F, 0f, 2f, 2f, 0f, 2.5f, 1f, 480f), 
        		new FoodInfo("hamburger", 8, 0.6f, false, 0.5F, 2F, 0f, 2f, 4f, 1f, 3f, 1f, 480f),
        		new FoodInfo("cheese_burger", 10, 0.8f, false, 0.5F, 2F, 0f, 2f, 4f, 3f, 3f, 1f, 480f),   
        		new FoodInfo("mabodofu", 8, 0.6f, false, 1F, 1F, 0f, 3f, 1f, 0f, 4f, 1f, 480f),
        		new FoodInfo("maboqiezi", 8, 0.6f, false, 1F, 1F, 0f, 4f, 0f, 0f, 4f, 1f, 480f),  
        		new FoodInfo("chestnut_toasted", 4, 0.4f, false, 0.5F, 2F, 0f, 2f, 0f, 0f, 2.5f, 1f, 480f),         
        		new FoodInfo("soup_red_bean", 6, 0.6f, false, 5F, 2F, 0f, 2f, 0f, 2f, 5f, 0f, 0f), 
        		new FoodInfo("pound_cake", 5, 0.6f, false, 0.5F, 4F, 2f, 0f, 0f, 4f, 3f, 1f, 480f),  
        		new FoodInfo("osuimono", 4, 0.5f, false, 50F, 0F, 0f, 0f, 0f, 0f, 5f, 1f, 480f),         
        		new FoodInfo("ochazuke", 6, 0.6f, false, 50F, 0F, 0f, 2f, 2f, 2f, 5f, 1f, 480f),
        		new FoodInfo("shrimp", 2, 0.6f, false, 0.5F, 0F, 0f, 0f, 2f, 0f, 2f, 1f, 480f),  
        		new FoodInfo("tempura", 5, 0.6f, false, 0F, 1F, 0f, 0f, 2f, 0f, 1.5f, 1f, 480f),         
        		new FoodInfo("fishcake", 4, 0.6f, false, 1f, 1f, 0f, 1f, 2f, 0f, 1.5f, 1f, 480f),
        		new FoodInfo("tofu", 2, 0.4f, false, 0.5F, 0F, 0f, 2f, 0f, 0.5f, 3f, 1f, 480f),
        		new FoodInfo("tofu_fried", 4, 0.5f, false, 0.5F, 0.5F, 0f, 3f, 0f, 0.5f, 2f, 1f, 480f),     
        		new FoodInfo("oden", 8, 0.6f, false, 1F, 1F, 0f, 3f, 3f, 0f, 4f, 1f, 480f),
        		new FoodInfo("dananko", 6, 0.6f, false, 1F, 3F, 0f, 0f, 0f, 1f, 2f, 1f, 480f),  
        		new FoodInfo("danmitarashi", 6, 0.4f, false, 1F, 3F, 0f, 0f, 0f, 1f, 2f, 1f, 480f),        
        		new FoodInfo("dansansyoku", 6, 0.6f, false, 1F, 3F, 0f, 0f, 0f, 1f, 2f, 1f, 480f),   
        		new FoodInfo("eggplant_baked", 4, 0.5f, false, 1F, 0F, 0f, 3f, 0f, 0f, 3f, 1f, 480f),
        		new FoodInfo("fried_chicken", 6, 0.6f, false, 2f, 1f, 0f, 0f, 4f, 0f, 1.5f, 1f, 480f),
        		new FoodInfo("sashimi", 6, 0.6f, false, 1F, 0F, 0f, 1f, 3f, 0f, 4f, 1f, 480f),
        		new FoodInfo("beef_stick", 8, 0.8f, false, 2f, 0f, 0f, 0f, 4f, 0f, 1.5f, 1f, 480f),  
        		new FoodInfo("chicken_stick", 6, 0.4f, false, 2f, 0f, 0f, 0f, 4f, 0f, 1.5f, 1f, 480f),          
        		new FoodInfo("pork_stick", 6, 0.6f, false, 2f, 0f, 0f, 0f, 4f, 0f, 1.5f, 1f, 480f),  
        		new FoodInfo("ramen_croquette", 9, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),         
        		new FoodInfo("udon_croquette", 9, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),                
        		new FoodInfo("soba_croquette", 9, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),               
        		new FoodInfo("ramen_chicken", 9, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),             
        		new FoodInfo("udon_chicken", 9, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),                    
        		new FoodInfo("soba_chicken", 9, 0.8f, false, 35F, 2F, 0F, 0F, 4F, 0F, 5F, 1f, 480f),            
        		new FoodInfo("tamagoyaki", 6, 0.6f, false, 0.5F, 2F, 0f, 0f, 0f, 3f, 3f, 1f, 480f),
        		new FoodInfo("sushi", 5, 0.6f, false, 1F, 2F, 0f, 0f, 2f, 0f, 4f, 1f, 480f),     
        		new FoodInfo("sushi_tamago", 4, 0.6f, false, 1F, 2F, 0f, 0f, 0f, 2f, 4f, 1f, 480f),
        		new FoodInfo("ehoumaki", 8, 0.6f, false, 1F, 2F, 0f, 3f, 3f, 2f, 4f, 1f, 480f),  
        		new FoodInfo("pudding", 4, 0.4f, false, 2F, 2F, 0f, 0f, 0f, 2f, 2.5f, 1f, 480f),         
        		new FoodInfo("pudding_maple", 6, 0.6f, false, 2F, 3F, 0f, 0f, 0f, 2f, 2.5f, 1f, 480f),         
        		new FoodInfo("rice_redbean", 6, 0.6f, false, 0.5F, 4F, 0f, 2f, 0f, 0f, 3f, 1f, 480f),
        		new FoodInfo("fish_bake", 8, 0.8f, false, 0.5F, 0F, 0f, 0f, 4f, 0f, 3f, 1f, 480f),     
        		new FoodInfo("fries", 5, 0.6f, false, 1F, 2F, 0f, 2f, 0f, 0f, 1f, 1f, 480f),
        		new FoodInfo("furofuki_daikon", 5, 0.6f, false, 25F, 0F, 0f, 4f, 0f, 0f, 5f, 1f, 480f),  
        		new FoodInfo("cabbage_roll", 4, 0.4f, false, 25F, 0F, 0f, 4f, 0f, 0f, 5f, 1f, 480f),           
        		new FoodInfo("white_stew", 6, 0.6f, false, 35F, 2F, 2f, 2f, 2f, 2f, 5f, 0f, 0f), 
        		new FoodInfo("fruitsalad", 6, 0.6f, false, 15F, 2F, 4f, 0f, 0f, 2f, 5.5f, 1f, 480f),
        		new FoodInfo("raw_taiyaki", 2, 0.2f, false, 0.5F, 0.5F, 0f, 0f, 0f, 0f, 2f, 1f, 480f),     
        		new FoodInfo("taiyaki", 6, 0.6f, false, 0.5F, 4F, 0f, 0f, 0f, 4f, 1f, 1f, 480f),
        		new FoodInfo("lemon",  1, 0.1f, false, 5f, 0f, 2f, 0f, 0f, 0f, 3.5f, 1f, 480f),     
        		new FoodInfo("lemon_juice",  1, 0.1f, false, 40F, 0F, 2f, 0f, 0f, 0f, 5f, 0f, 0f),            
        		new FoodInfo("soda_water", 1, 0.1f, false, 50F, 0F, 0f, 0f, 0f, 0f, 5f, 0f, 0f), 
        		new FoodInfo("almond", 1, 0.1f, false, 0F, 0F, 0f, 0f, 0f, 0f, 2f, 1f, 480f),
        		new FoodInfo("blackcurrant_juice", 1, 0.1f, false, 40F, 0F, 2f, 0f, 0f, 0f, 5f, 0f, 0f),     
        		new FoodInfo("orange_juice", 1, 0.1f, false, 40F, 0F, 2f, 0f, 0f, 0f, 5f, 0f, 0f),      
        		new FoodInfo("grape_green", 2, 0.2f, false, 4F, 0F, 2F, 0F, 0.5F, 0F, 5F, 0f, 0f),  
        		new FoodInfo("sliced_cabbage", 2, 0.2f, false, 5f, 0f, 0f, 2f, 0f, 0f, 2.5f, 1f, 480f),         
        		new FoodInfo("sushi_shrimp", 5, 0.6f, false, 1F, 2F, 0f, 0f, 2f, 0f, 4f, 1f, 480f),     
        		new FoodInfo("curry_omurice", 8, 0.6f, false, 0.5F, 3F, 0f, 1f, 4f, 3f, 2.25f, 1f, 480f), 
        		new FoodInfo("katsu_dish", 10, 0.8f, false, 0.5F, 0.5F, 0f, 2f, 5f, 1f, 3f, 1f, 480f),     
        		new FoodInfo("croquette_dish", 8, 0.6f, false, 0.5F, 0.5F, 0f, 2f, 5f, 1f, 3f, 1f, 480f), 
        		new FoodInfo("pasta_tomato", 9, 0.8f, false, 1.5F, 2F, 0F, 4F, 4F, 2F, 5f, 1f, 480f),
        		new FoodInfo("pasta_mushroom", 9, 0.8f, false, 1.5F, 2F, 0F, 4F, 4F, 2F, 5f, 1f, 480f),        
        		new FoodInfo("pasta_whitesauce", 9, 0.8f, false, 1.5F, 2F, 0F, 4F, 4F, 2F, 5f, 1f, 480f),
        		new FoodInfo("egg_soft", 2, 0.6F, false, 1F, 0F, 0F, 0F, 0.0F, 3.0F, 2F, 1f, 480f), 
        		new FoodInfo("egg_soysauce", 4, 0.6F, false, 1F, 0F, 0F, 0F, 0.0F, 3.5F, 1.0F, 1f, 480f), 
        		new FoodInfo("buckwheat_bread", 5, 0.6f, false, 0f, 2f, 0f, 0f, 0f, 0f, 0.5f, 1f, 480f),
        		
        		new FoodInfo("chawanmushi", 6, 0.5f, false, 5f, 0f, 0f, 3f, 3f, 3f, 5f, 2f, 480f),
        		new FoodInfo("dorayaki", 6, 0.6f, false, 1f, 5f, 2f, 2f, 0f, 0f, 2f, 2f, 480f),
        		new FoodInfo("machined_fish", 1, 0.2f, false, 1f, 0f, 0f, 0f, 2f, 2f, 5f, 1f, 480f),
        		new FoodInfo("matsutake", 1, 0.2f, false, 1f, 0f, 0f, 2f, 0f, 0f, 2f, 2f, 480f),
        		new FoodInfo("edodes", 1, 0.2f, false, 1f, 0f, 0f, 2f, 0f, 0f, 2f, 2f, 480f),
        		new FoodInfo("shimeji", 1, 0.2f, false, 1f, 0f, 0f, 2f, 0f, 0f, 2f, 2f, 480f),
        		new FoodInfo("roast_matsutake", 5, 0.6f, false, 0f, 0f, 0f, 3f, 0f, 0f, 1f, 1f, 480f),
        		new FoodInfo("rice_matsutake", 8, 0.6f, false, 0.5F, 2F, 0F, 3F, 0F, 1F, 2F, 1f, 480f),         
        		new FoodInfo("onigiri_matsutake",9, 0.7f, false, 0.5F, 2F, 0F, 4F, 0F, 1F, 2F, 1f, 480f),   
        		
        		new FoodInfo("bonito", 2, 0.2f, false, 1f, 0f, 0f, 0f, 2f, 2f, 5f, 1f, 480f),
        		new FoodInfo("machined_bonito", 1, 0.2f, false, 1f, 0f, 0f, 0f, 2f, 2f, 5f, 1f, 480f),
        		new FoodInfo("boiled_bonito", 2, 0.2f, false, 3f, 0f, 0f, 0f, 2f, 2f, 5f, 1f, 480f),
        		new FoodInfo("smoked_bonito", 3, 0.3f, false, 0f, 0f, 0f, 0f, 2f, 2f, 3f, 1f, 480f),
        		new FoodInfo("dried_bonito", 3, 0.3f, false, 0f, 0f, 0f, 0f, 2f, 2f, 0f, 1f, 480f),
        		new FoodInfo("bonito_shaving", 1, 0.1f, false, 0f, 0f, 0f, 0f, 2f, 2f, 0f, 1f, 480f),
        		new FoodInfo("dough_okinoyaki", 2, 0.2f, false, 0F, 2F, 0F, 2F, 2F, 2F, 0F, 1f, 480f),         
        		new FoodInfo("okinoyaki",8, 0.8f, false, 0.5F, 2F, 0F, 3F, 3F, 3F, 1F, 1f, 480f),  
        		new FoodInfo("okinoyaki_plus", 10, 1f, false, 1F, 3F, 3F, 3F, 3F, 3F, 1F, 1f, 480f),    
        		new FoodInfo("okinoyaki_final", 12, 1f, false, 1F, 5F, 5F, 5F, 5F, 5F, 1F, 1f, 480f),    
        		
        		new FoodInfo("nimono_pumpkin", 6, 0.5f, false, 5F, 2F, 0F, 2F, 0F, 0F, 5F, 1f, 480f),         
        		new FoodInfo("nimono_radish", 6, 0.5f, false, 5F, 2F, 0F, 2F, 0F, 0F, 5F, 1f, 480f),  
        		new FoodInfo("nimono_fish", 8, 1f, false, 6F, 0F, 0F, 0F, 3F, 3F, 5F, 1f, 480f),    
        		new FoodInfo("chikuzenni", 12, 1f, false, 5F, 0F, 5F, 5F, 5F, 5F, 5F, 1f, 480f),
        		
        		new FoodInfo("yaki_soba", 9, 0.7f, false, 2.5F, 1.5F, 0F, 4F, 2F, 2F, 3.5f, 1f, 480f),
        		new FoodInfo("yaki_pasta", 9, 0.7f, false, 2.5F, 1.5F, 0F, 4F, 2F, 2F, 3.5f, 1f, 480f),
        		
        		new FoodInfo("taiyaki_mocha", 8, 0.6f, false, 0.5F, 4F, 0f, 0f, 0f, 4f, 1f, 1f, 480f),
        		new FoodInfo("mocha_cookie",  5, 0.25f, false, 0.75F, 2F, 0F, 0F, 0F, 0.2F, 0.8F, 1f, 480f),         
        		new FoodInfo("pudding_mocha", 6, 0.6f, false, 2F, 3F, 0f, 0f, 0f, 2f, 2.5f, 1f, 480f),    
        		new FoodInfo("pound_cake_mocha", 7, 0.6f, false, 0.5F, 4F, 2f, 0f, 0f, 4f, 3f, 1f, 480f),  
        		
        		new FoodInfo("soup_miso", 5, 0.5f, false, 50F, 0F, 0f, 0f, 0f, 0f, 5f, 1f, 480f),      
        		
        		new FoodInfo("brown_rice_cooked", 4, 0.5f, false, 0.5F, 1.5F, 0F, 0F, 0F, 0F, 2F, 1f, 480f),        
        		new FoodInfo("dried_brown_rice", 4, 0.5f, false, 0F, 1.5F, 0F, 0F, 0F, 0F, 0F, 1f, 480f),
        		new FoodInfo("dried_rice", 4, 0.5f, false, 0F, 1.5F, 0F, 0F, 0F, 0F, 0F, 1f, 480f),  
        		new FoodInfo("fried_brown_rice", 4, 0.5f, false, 0F, 1.5F, 0F, 0F, 0F, 0F, 0F, 1f, 480f),
        		
        		new FoodInfo("ume", 2, 0.2f, false, 5F, 0F, 1F, 0F, 0F, 0F, 3F, 1f, 480f),
        		new FoodInfo("umeboshi", 2, 0.5f, false, 5F, 0F, 2F, 0F, 0F, 0F, 0F, 1f, 480f),  
        		
        		new FoodInfo("zosui_zuiki", 6, 1f, false, 5F, 2F, 0F, 2F, 0F, 0F, 5F, 1f, 480f),  
        		new FoodInfo("zosui", 8, 1f, false, 5F, 0F, 0F, 0F, 3F, 3F, 5F, 1f, 480f),  
        		
        		new FoodInfo("taro_baked", 5, 0.6f, false, 0f, 2f, 2f, 0f, 0f, 0f, 2f, 1f, 480f),
        		new FoodInfo("imotaki", 12, 1f, false, 5F, 0F, 5F, 5F, 5F, 5F, 5F, 1f, 480f),
        		new FoodInfo("noppei_jiru", 12, 1f, false, 5F, 0F, 5F, 5F, 5F, 5F, 5F, 1f, 480f),
        		
        		new FoodInfo("hyorogan", 4, 0.5f, false, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 1f, 480f),
        		new FoodInfo("suikatsugan", 4, 0.5f, false, 20F, 1.5F, 2F, 0F, 0F, 0F, 0F, 1f, 480f),  
        		
        		new FoodInfo("fish_bake_salt", 8, 0.8f, false, 0.5F, 0F, 0f, 0f, 4f, 0f, 3f, 1f, 480f),
        		
    	}
    );
    public static ItemDoor BAMBOO_DOOR = new ItemDoor(BlockLoader.BAMBOODOOR);
    public static ItemBase MATERIAL = new ItemBase(SakuraMain.MODID,"materials", 64, new String[]{
            "straw",//0
            "rice",//1
            "salt",//2
            "curry_powder",//3
            "flour",//4
            "flour_buckwheat",//5
            "dough",//6
            "dough_buckwheat",
            "ramen_raw",
            "udon_raw",
            "soba_raw",//10
            "curry_sauce",
            "tomato_sauce",
            "white_sauce",
            "tempura_batter",
            "chestnut_burrs",//15
            "flour_rice",
            "dough_rice",//17
            "peppercorn_green",
            "peppercorn_red",//19
            "vanilla_seeds",
            "vanilla",//21
            "vanilla_roast",
            "grape_seeds",//23
            "lumber_bamboo",//24
            "lumber_sakura",
            "lumber_maple",//26
            "black_pepper",
            "white_pepper",//28
            "miso",
            "breadcrumbs",//30
            "chestnut",//31
            "noodle_soup",//32
            "soysause",//33
            "seaweed",//34
            "alkaline",//35
            "yeast",//36
            "hop",//37
            "brown_rice",//38
            "green_tea_leaves",//39
            "black_tea_leaves",//40
            "earl_grey_leaves",//41
            "fruit_tea_leaves",//42
            "mocha",//43
            "rice_tea_leaves",//44
            "mint",//45
            "mint_tea_leaves",//46
            "empty_bottle",//47
            "bamboo_sunburnt",//48
            "maple_syrup",//49
            "coin",//50
            "bamboo_charcoal",//51
            
            "zuku",//52
            "zuku_ingot",//53
            "sagegane",//54
            "tamahagane",//55
            "steel_ingot",//56
            "pasta_raw",//57
            
            "bento_box",//58
            "silk",//59
            
            "worcester_sauce",//60
            "mayo",//61
            "vinegar",//62
            
            "imogara",//63
            "dried_imogara",//64
            "imogaranawa_piece",//65
            "miso_ball",//66
            });
    public static Item POT = new ItemPot();
    public static Item KNIFE_NOODLE = new ItemKnifeNoodle(ToolMaterial.IRON);
    public static Item KNIFE_FISH = new ItemKnifeNoodle(ToolMaterial.IRON).setUnlocalizedName(SakuraMain.MODID+"."+"knife_fish");

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
    public static Item STONE_HAMMER = new ItemHammer(ToolMaterial.STONE).setUnlocalizedName("sakura.stone_hammer");
    public static Item IRON_HAMMER = new ItemHammer(ToolMaterial.IRON).setUnlocalizedName("sakura.iron_hammer");
    public static Item SAKURA_HAMMER = new ItemHammer(SAKURA_TOOLMATERIAL).setUnlocalizedName("sakura.sakura_hammer");
   
    public static Item SAKURA_KNIFE_NOODLE = new ItemKnifeNoodle(SAKURA_TOOLMATERIAL).setMaxDamage(SAKURA_TOOLMATERIAL.getMaxUses()).setUnlocalizedName(SakuraMain.MODID+"."+"sakura_knife_noodle");
    public static Item SAKURA_KNIFE_FISH = new ItemKnifeNoodle(SAKURA_TOOLMATERIAL).setMaxDamage(SAKURA_TOOLMATERIAL.getMaxUses()).setUnlocalizedName(SakuraMain.MODID+"."+"sakura_knife_fish");
    
    public static Item IMOGARANAWA = new ItemMetaDurability(SakuraMain.MODID, "imogaranawa", 15, ItemStack.EMPTY, new String[] {
    		"imogaranawa"
    });
    
    public static ItemFoodBase BENTO = new ItemFoodContain(SakuraMain.MODID, "bento", 1,
    new FoodInfo[]{
    	new FoodInfo("bento_0", 14, 0.8F, false, 10F, 10F, 10F, 10F, 10F, 10F, 2, 0F, 480),
    	new FoodInfo("bento_1", 16, 0.8F, false, 10F, 10F, 10F, 10F, 10F, 10F, 2, 0F, 480),
    	new FoodInfo("bento_2", 14, 0.8F, false, 10F, 10F, 10F, 10F, 10F, 10F, 2, 0F, 480),
    	new FoodInfo("bento_3", 14, 0.8F, false, 10F, 10F, 10F, 10F, 10F, 10F, 2, 0F, 480),
    },new ItemStack[]{
    	new ItemStack(MATERIAL,1,58),
    	new ItemStack(MATERIAL,1,58),
    	new ItemStack(MATERIAL,1,58),
    	new ItemStack(MATERIAL,1,58),
    });
    private static final ItemLoader INSTANCE = new ItemLoader();
    
    private ItemLoader() {
    }
    
    public void registerItem() {
    	register(cup);
        register(POT);
        register(KIMONO);
        register(HAORI);
        register(BAMBOO_DOOR.setUnlocalizedName("sakura.bamboo_door"));
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
        register(TARO);
        register(KNIFE_NOODLE);
        register(KNIFE_FISH);
        register(SAKURA_DIAMOND);
        
        register(SAKURA_PICKAXE);
        register(SAKURA_AXE);
        register(SAKURA_SHOVEL);
        register(SAKURA_HOE);
        
        register(SAKURA_KNIFE_NOODLE);
        register(SAKURA_KNIFE_FISH);
        register(MATERIAL);
        register(IMOGARANAWA);
        register(FOODSET);
        register(HYDRA_RAMEN.setUnlocalizedName("sakura.hydra_ramen"));
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
        
        register(SOLDIER_HELMET);
        register(SOLDIER_CHEST);
        register(SOLDIER_PANTS);
        register(SOLDIER_SHOES);
        
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
        MinecraftForge.addGrassSeed(new ItemStack(RED_BEAN), 2);
        MinecraftForge.addGrassSeed(new ItemStack(MATERIAL, 1, 23), 2);
        MinecraftForge.addGrassSeed(new ItemStack(MATERIAL, 1, 37), 1);
        MinecraftForge.addGrassSeed(new ItemStack(TARO), 1);
        
//        OreDictionary.getOres().forEach((stack)->SOLDIER_MATERIAL.setRepairItem(stack));
	}

    @SideOnly(Side.CLIENT)
    public void registerRenders() {
    	ItemRegister.getInstance().registerRender(IMOGARANAWA);
    	ItemRegister.getInstance().registerRender(TARO);
    	ItemRegister.getInstance().registerRender(SAKURA_PICKAXE);
        ItemRegister.getInstance().registerRender(SAKURA_AXE);
        ItemRegister.getInstance().registerRender(SAKURA_SHOVEL);
        ItemRegister.getInstance().registerRender(SAKURA_HOE);
    	
    	ItemRegister.getInstance().registerRender(SOLDIER_HELMET);
        ItemRegister.getInstance().registerRender(SOLDIER_CHEST);
        ItemRegister.getInstance().registerRender(SOLDIER_PANTS);
        ItemRegister.getInstance().registerRender(SOLDIER_SHOES);
    	
    	ItemRegister.getInstance().registerRender(SAKURA_KNIFE_NOODLE);
        ItemRegister.getInstance().registerRender(SAKURA_KNIFE_FISH);
    	ItemRegister.getInstance().registerRender(KNIFE_FISH);
    	ItemRegister.getInstance().registerRender(SEAWEED_RAW);
    	ItemRegister.getInstance().registerRender(FUTON);
    	ItemRegister.getInstance().registerRender(BENTO);
    	ItemRegister.getInstance().registerRender(STONE_HAMMER);
    	ItemRegister.getInstance().registerRender(IRON_HAMMER);
    	ItemRegister.getInstance().registerRender(SAKURA_HAMMER);
    	ItemRegister.getInstance().registerRender(SHEATH);
    	ItemRegister.getInstance().registerRender(HAORI);
    	ItemRegister.getInstance().registerRender(KIMONO);
    	ItemRegister.getInstance().registerRender(BROOM);
    	ItemRegister.getInstance().registerRender(SAMURAI_HELMET);
    	ItemRegister.getInstance().registerRender(SAMURAI_CHEST);
    	ItemRegister.getInstance().registerRender(SAMURAI_PANTS);
    	ItemRegister.getInstance().registerRender(SAMURAI_SHOES);
    	ItemRegister.getInstance().registerRender(TACHI);
    	ItemRegister.getInstance().registerRender(ONION);
    	ItemRegister.getInstance().registerRender(ONION_SEEDS);
    	ItemRegister.getInstance().registerRender(SHINAI);
    	ItemRegister.getInstance().registerRender(KODACHI);
    	ItemRegister.getInstance().registerRender(SAKURAKODACHI);
    	ItemRegister.getInstance().registerRender(KNIFE_NOODLE);
    	ItemRegister.getInstance().registerRender(POT);
    	ItemRegister.getInstance().registerRender(CABBAGE);
    	ItemRegister.getInstance().registerRender(CABBAGE_SEEDS);
    	ItemRegister.getInstance().registerRender(TOMATO);
    	ItemRegister.getInstance().registerRender(TOMATO_SEEDS);
    	ItemRegister.getInstance().registerRender(EGGPLANT);
    	ItemRegister.getInstance().registerRender(EGGPLANT_SEEDS);
    	ItemRegister.getInstance().registerRender(RADISH);
    	ItemRegister.getInstance().registerRender(RADISH_SEEDS);
    	ItemRegister.getInstance().registerRender(BUCKWHEAT);
    	ItemRegister.getInstance().registerRender(MATERIAL);
    	ItemRegister.getInstance().registerRender(RAPESEED);
    	ItemRegister.getInstance().registerRender(RICE_SEEDS);
    	ItemRegister.getInstance().registerRender(RED_BEAN);
    	ItemRegister.getInstance().registerRender(BAMBOO_DOOR);
    	ItemRegister.getInstance().registerRender(FOODSET);
    	ItemRegister.getInstance().registerRender(HYDRA_RAMEN);
    	ItemRegister.getInstance().registerRender(BUGGYS_MEAT);
    	ItemRegister.getInstance().registerRender(STRAW_HAT);
    	ItemRegister.getInstance().registerRender(SAKURA_DIAMOND);
    	ItemRegister.getInstance().registerRender(KATANA);
    	ItemRegister.getInstance().registerRender(SAKURAKATANA);
    	ItemRegister.getInstance().registerRender(KATANA_SHEATH);
    	ItemRegister.getInstance().registerRender(SAKURAKATANA_SHEATH);
    	ItemRegister.getInstance().registerRender(cup);
    }

    private void register(Item item) {
        item.setCreativeTab(CommonProxy.tab);
        ItemRegister.getInstance().register(SakuraMain.MODID, item);
    }

	public static ItemLoader getInstance() {
		return INSTANCE;
	}
}
