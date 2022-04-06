package cn.mcmod.sakura.item.enums;

import java.util.function.Supplier;

import cn.mcmod.sakura.item.ItemRegistry;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import net.minecraft.world.item.Item;

public enum SakuraCuisineSet {
    BEEF_STICK(FoodInfo.builder().name("beef_stick").amountAndCalories(8, 0.8F).water(2F).nutrients(0F, 0F, 0F, 4F, 0F)
            .decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build(),ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO)),
    CHICKEN_STICK(FoodInfo.builder().name("chicken_stick").amountAndCalories(6, 0.4F).water(2F).nutrients(0F, 0F, 0F, 4F, 0F)
            .decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build(),ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO)),
    PORK_STICK(FoodInfo.builder().name("pork_stick").amountAndCalories(6, 0.6F).water(2F).nutrients(0F, 0F, 0F, 4F, 0F)
            .decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build(),ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO))
    ;
    private final FoodInfo info;
    private final Supplier<Item> container;
    
    private SakuraCuisineSet(FoodInfo info, Supplier<Item> container) {
        this.info = info;
        this.container = container;
    }

    public FoodInfo getFoodInfo() {
        return info;
    }

    public Supplier<Item> getContainer() {
        return container;
    }
}
