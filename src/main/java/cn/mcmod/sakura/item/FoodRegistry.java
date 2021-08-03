package cn.mcmod.sakura.item;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod_mmf.mmlib.item.ItemFoodBase;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FoodRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SakuraMod.MODID);

    public static final RegistryObject<Item> GRAPE = ITEMS.register("grape",
            () -> new ItemFoodBase(new Item.Properties().tab(SakuraMod.GROUP),
                    new FoodInfo("grape", 1, 0.25f, false, 4F, 0.25F, 0F, 1F, 0F, 0F, 5F, 0, -1)));
}
