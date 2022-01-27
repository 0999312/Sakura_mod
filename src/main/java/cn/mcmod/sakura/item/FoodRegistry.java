package cn.mcmod.sakura.item;

import java.util.Map;
import java.util.function.Supplier;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod_mmf.mmlib.item.ItemFoodBase;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import cn.mcmod_mmf.mmlib.registry.ItemRegistryUtil;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FoodRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SakuraMod.MODID);

    public static final Map<FoodInfo, RegistryObject<ItemFoodBase>> FOODSET = ItemRegistryUtil
            .registerAllFoodInList(ItemList.FOODSET, info -> register(info.getName(), () -> normalFood(info)));

    public static RegistryObject<ItemFoodBase> getFood(Map<FoodInfo, RegistryObject<ItemFoodBase>> foodset,
            String name) {
        return foodset.values().stream().filter(item -> item.get().getFoodInfo().getName().equals(name)).findAny()
                .get();
    }

    private static ItemFoodBase normalFood(FoodInfo info) {
        return new ItemFoodBase(SakuraMod.defaultItemProperties(), info);
    }

    private static <V extends Item> RegistryObject<V> register(String name, Supplier<V> item) {
        return ITEMS.register(name, item);
    }
}
