package cn.mcmod.sakura.item;

import java.util.Map;
import java.util.function.Supplier;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.item.enums.SakuraCuisineSet;
import cn.mcmod.sakura.item.enums.SakuraFoodSet;
import cn.mcmod_mmf.mmlib.item.ItemFoodBase;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import cn.mcmod_mmf.mmlib.registry.ItemRegistryUtil;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FoodRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SakuraMod.MODID);

    public static final Map<SakuraFoodSet, RegistryObject<ItemFoodBase>> FOODSET = ItemRegistryUtil.mapOfKeys(
            SakuraFoodSet.class, info -> register(info.getFoodInfo().getName(), () -> normalFood(info.getFoodInfo())));

    public static final Map<SakuraCuisineSet, RegistryObject<ItemFoodBase>> CUISINES = ItemRegistryUtil.mapOfKeys(
            SakuraCuisineSet.class,
            info -> register(info.getFoodInfo().getName(), () -> normalFood(info.getFoodInfo(), info.getContainer().get())));

    private static ItemFoodBase normalFood(FoodInfo info) {
        return new ItemFoodBase(SakuraMod.defaultItemProperties(), info);
    }

    private static ItemFoodBase normalFood(FoodInfo info, Item container) {
        if(container == null)
            return normalFood(info);
        return new ItemFoodBase(SakuraMod.defaultItemProperties().craftRemainder(container), info);
    }

    private static <V extends Item> RegistryObject<V> register(String name, Supplier<V> item) {
        return ITEMS.register(name, item);
    }
}
