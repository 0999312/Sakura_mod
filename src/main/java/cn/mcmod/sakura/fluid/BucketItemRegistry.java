package cn.mcmod.sakura.fluid;

import cn.mcmod.sakura.SakuraMod;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BucketItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SakuraMod.MODID);
    public static final RegistryObject<Item> FOOD_OIL_BUCKET = ITEMS.register("food_oil_bucket", () -> 
        new BucketItem(FluidRegistry.FOOD_OIL, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
