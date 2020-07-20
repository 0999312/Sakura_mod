package cn.mcmod.sakura.api.kimono;

import java.util.Map;

import com.google.common.collect.Maps;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.item.armors.ItemHaori;
import cn.mcmod.sakura.item.armors.ItemKimono;
import cn.mcmod_mmf.mmlib.util.RecipesUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class KimonoLoader {
	
	public static void Init(){
		registerKimono("kimono_1");
		registerKimono("kimono_2");
		registerKimono("kimono_3");
		registerKimono("kimono_4");
		registerKimono("kimono_5");
		registerKimono("kimono_6");
		
		registerKimono("kimono_miko");
		registerKimono("yukata_0");
		registerKimono("yukata_1");
		registerKimono("yukata_2");
		registerKimono("yukata_3");
		registerKimono("yukata_4");
		
		registerHaori("haori_1");
		registerHaori("haori_2");
		registerHaori("haori_3");
		registerHaori("haori_4");
	}
	
	private static void registerKimono(String texture_name) {
		ItemStack kimono = new ItemStack(ItemLoader.KIMONO);
		ItemKimono.KimonoIDs.add(texture_name);
		NBTTagCompound tag = RecipesUtil.getItemTagCompound(kimono);
		ItemKimono.texture_name.set(tag, texture_name);
		registerCustomItemStack(texture_name, kimono);
	}
	
	private static void registerHaori(String texture_name) {
		ItemStack kimono = new ItemStack(ItemLoader.HAORI);
		ItemHaori.KimonoIDs.add(texture_name);
		NBTTagCompound tag = RecipesUtil.getItemTagCompound(kimono);
		ItemKimono.texture_name.set(tag, texture_name);
		registerCustomItemStack(texture_name, kimono);
	}
	
	public static Map<ResourceLocation, ItemStack> KimonoRegistry = Maps.newHashMap();

	public static void registerCustomItemStack(String name, ItemStack stack){
		KimonoRegistry.put(new ResourceLocation(SakuraMain.MODID, name),stack);
	}

	public static ItemStack findItemStack(String modid, String name, int count){
		ResourceLocation key = new ResourceLocation(modid, name);
        ItemStack stack = ItemStack.EMPTY;

        if(KimonoRegistry.containsKey(key)) {
            stack = KimonoRegistry.get(new ResourceLocation(modid, name)).copy();
        }else {
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(modid, name));
            if (item != null)
                stack = new ItemStack(item);
        }
        if(!stack.isEmpty()) {
            stack.setCount(count);
        }
        return stack;
    }

    public static ItemStack getCustomKimono(String modid,String name){
        return findItemStack(modid, name, 1);
    }
    public static ItemStack getCustomKimono(String key){
        String modid;
        String name;
        {
            String str[] = key.split(":",2);
            if(str.length == 2){
                modid = str[0];
                name = str[1];
            }else{
                modid = SakuraMain.MODID;
                name = key;
            }
        }

        return getCustomKimono(modid,name);
    }
}
