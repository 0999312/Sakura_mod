package cn.mcmod.sakura.item.enums;

import cn.mcmod_mmf.mmlib.item.info.FoodInfo;

public enum SakuraFoodSet {
    TOMATO(
            FoodInfo.builder()
            .name("tomato")
            .amountAndCalories(2, 0.2F).water(5F)
            .nutrients(0F, 0F, 2F, 0F, 0F)
            .decayModifier(2.5F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    RADISH(
            FoodInfo.builder()
            .name("radish")
            .amountAndCalories(2, 0.2F).water(5F)
            .nutrients(0F, 0F, 2F, 0F, 0F)
            .decayModifier(2.5F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    EGGPLANT(
            FoodInfo.builder()
            .name("eggplant")
            .amountAndCalories(2, 0.2F).water(5F)
            .nutrients(0F, 0F, 2F, 0F, 0F)
            .decayModifier(2.5F)
            .heatCapacity(1F).cookingTemp(480F).build()
            ),
    CABBAGE(
            FoodInfo.builder()
            .name("cabbage")
            .amountAndCalories(2, 0.2F).water(5F)
            .nutrients(0F, 0F, 2F, 0F, 0F)
            .decayModifier(2.5F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    ONION(
            FoodInfo.builder()
            .name("onion")
            .amountAndCalories(2, 0.2F).water(5F)
            .nutrients(0F, 0F, 2F, 0F, 0F)
            .decayModifier(2.5F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    FISHCAKE(
            FoodInfo.builder()
            .name("fishcake")
            .amountAndCalories(4, 0.6F).water(1F)
            .nutrients(1F, 0F, 1F, 2F, 0F)
            .decayModifier(1.5F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    EGGPLANT_BAKED(
            FoodInfo.builder()
            .name("eggplant_baked")
            .amountAndCalories(4, 0.5F).water(0F)
            .nutrients(0F, 0F, 3F, 0F, 0F)
            .decayModifier(3F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    TARO_BAKED(
            FoodInfo.builder()
            .name("taro_baked")
            .amountAndCalories(5, 0.6F).water(0F)
            .nutrients(2F, 2F, 0F, 0F, 0F)
            .decayModifier(2F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    BROWN_RICE_COOKED(
            FoodInfo.builder()
            .name("brown_rice_cooked")
            .amountAndCalories(4, 0.5F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 0F, 0F)
            .decayModifier(2F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    RICE_COOKED(
            FoodInfo.builder()
            .name("rice_cooked")
            .amountAndCalories(4, 0.5F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 0F, 0F)
            .decayModifier(2F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    RICE_REDBEAN(
            FoodInfo.builder()
            .name("rice_redbean")
            .amountAndCalories(6, 0.6F).water(0.5F)
            .nutrients(4F, 0F, 2F, 0F, 0F)
            .decayModifier(3F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    RICE_BAMBOO(
            FoodInfo.builder()
            .name("rice_bamboo")
            .amountAndCalories(5, 0.6F).water(0.5F)
            .nutrients(1.5F, 1F, 0F, 0F, 0F)
            .decayModifier(2.25F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    RICE_BEEF(
            FoodInfo.builder()
            .name("rice_beef")
            .amountAndCalories(9, 0.8F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 3F, 0F)
            .decayModifier(2.25F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    RICE_FISH(
            FoodInfo.builder()
            .name("rice_fish")
            .amountAndCalories(7, 0.7F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 2F, 0F)
            .decayModifier(2.25F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    RICE_PORK(
            FoodInfo.builder()
            .name("rice_pork")
            .amountAndCalories(7, 0.7F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 3F, 0F)
            .decayModifier(2.25F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    RICE_MUSHROOM(
            FoodInfo.builder()
            .name("rice_mushroom")
            .amountAndCalories(6, 0.6F).water(0.5F)
            .nutrients(1.5F, 0F, 2F, 0F, 0F)
            .decayModifier(2F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    RICE_EGG(
            FoodInfo.builder()
            .name("rice_egg")
            .amountAndCalories(5, 0.6F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 0F, 2F)
            .decayModifier(2.25F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    RICE_BEEF_EGG(
            FoodInfo.builder()
            .name("rice_beef_egg")
            .amountAndCalories(10, 1F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 3.5F, 2F)
            .decayModifier(2.25F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    RICE_PORK_EGG(
            FoodInfo.builder()
            .name("rice_pork_egg")
            .amountAndCalories(9, 0.8F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 3.5F, 2F)
            .decayModifier(2.25F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    RICE_OYAKO(
            FoodInfo.builder()
            .name("rice_oyako")
            .amountAndCalories(9, 0.8F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 3.5F, 2F)
            .decayModifier(2.25F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    RICE_OYAKO_FISH(
            FoodInfo.builder()
            .name("rice_oyako_fish")
            .amountAndCalories(9, 0.8F).water(0.5F)
            .nutrients(1.5F, 0F, 0F, 3.5F, 2F)
            .decayModifier(2.25F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    
    ONIGIRI(
            FoodInfo.builder()
            .name("onigiri")
            .amountAndCalories(6, 0.6F).water(0.5F)
            .nutrients(2F, 0F, 1F, 0F, 0F)
            .decayModifier(2F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    ONIGIRI_BAMBOO(
            FoodInfo.builder()
            .name("onigiri_bamboo")
            .amountAndCalories(7, 0.7F).water(0.5F)
            .nutrients(2F, 0F, 2F, 0F, 0F)
            .decayModifier(2.25F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    ONIGIRI_FISH(
            FoodInfo.builder()
            .name("onigiri_fish")
            .amountAndCalories(8, 0.7F).water(0.5F)
            .nutrients(2F, 0F, 1F, 2F, 0F)
            .decayModifier(2.25F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    ONIGIRI_MUSHROOM(
            FoodInfo.builder()
            .name("onigiri_mushroom")
            .amountAndCalories(7, 0.7F).water(0.5F)
            .nutrients(2F, 0F, 2F, 0F, 0.5F)
            .decayModifier(2F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            ),
    ONIGIRI_SEAWEED(
            FoodInfo.builder()
            .name("onigiri_seaweed")
            .amountAndCalories(7, 0.7F).water(0.5F)
            .nutrients(2F, 0F, 2F, 0F, 0.5F)
            .decayModifier(2.25F)
            .heatCapacity(1F).cookingTemp(480F)
            .build()
            )
    ;
    private final FoodInfo info;
    private SakuraFoodSet(FoodInfo info) {
        this.info = info;
    }
    public FoodInfo getFoodInfo() {
        return info;
    }
}
