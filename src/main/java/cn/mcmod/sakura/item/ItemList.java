package cn.mcmod.sakura.item;

import java.util.List;

import com.google.common.collect.Lists;

import cn.mcmod_mmf.mmlib.item.info.FoodInfo;

public final class ItemList {
    public static List<String> MATERIAL_SET = Lists.newArrayList("silk", "hop", "straw", "brown_rice", "rice", "salt",
            "curry_powder", "alkaline", "yeast", "flour", "flour_rice", "flour_buckwheat", "dough", "dough_rice",
            "dough_buckwheat", "ramen_raw", "udon_raw", "soba_raw", "pasta_raw", "maple_syrup", "noodle_soup",
            "soysause", "seaweed", "worcester_sauce", "mayo", "vinegar", "curry_sauce", "tomato_sauce", "white_sauce",
            "tempura_batter", "chestnut_burrs", "chestnut", "peppercorn_green", "peppercorn_red", "black_pepper",
            "white_pepper", "grape_seeds", "vanilla_seeds", "vanilla", "vanilla_roast", "lumber_bamboo",
            "lumber_sakura", "lumber_maple", "miso", "miso_ball", "breadcrumbs", "green_tea_leaves", "black_tea_leaves",
            "earl_grey_leaves", "fruit_tea_leaves", "mocha", "rice_tea_leaves", "mint", "mint_tea_leaves", "coin",
            "zuku", "zuku_ingot", "sagegane", "tamahagane", "steel_ingot", "imogara", "dried_imogara",
            "imogaranawa_piece", "empty_bottle", "bento_box", "bamboo_sunburnt", "bamboo_charcoal");
    
    public static List<FoodInfo> FOODSET = Lists.newArrayList(
            FoodInfo.builder().name("rice_bread").amountAndCalories(5, 0.6F).water(0F).nutrients(2F, 0F, 0F, 0F, 0F)
                    .decayModifier(0F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("buckwheat_bread").amountAndCalories(5, 0.6F).water(0F)
                    .nutrients(2F, 0F, 0F, 0F, 0F).decayModifier(0.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("bun").amountAndCalories(5, 0.6F).water(0F).nutrients(2F, 0F, 0F, 0F, 0F)
                    .decayModifier(0.8F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("tomato").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
                    .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("radish").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
                    .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("onion").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
                    .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("eggplant").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
                    .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("cabbage").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
                    .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("sliced_cabbage").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 0F, 2F, 0F, 0F)
                    .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("matsutake").amountAndCalories(1, 0.2F).water(1F).nutrients(0F, 0F, 2F, 0F, 0F)
                    .decayModifier(2F).heatCapacity(2F).cookingTemp(480F).build(),
            FoodInfo.builder().name("edodes").amountAndCalories(1, 0.2F).water(1F).nutrients(0F, 0F, 2F, 0F, 0F)
                    .decayModifier(2F).heatCapacity(2F).cookingTemp(480F).build(),
            FoodInfo.builder().name("shimeji").amountAndCalories(1, 0.2F).water(1F).nutrients(0F, 0F, 2F, 0F, 0F)
                    .decayModifier(2F).heatCapacity(2F).cookingTemp(480F).build(),
            FoodInfo.builder().name("lemon").amountAndCalories(1, 0.1F).water(5F).nutrients(0F, 2F, 0F, 0F, 0F)
                    .decayModifier(3.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("grape_green").amountAndCalories(2, 0.2F).water(4F).nutrients(0F, 2F, 0F, 0.5F, 0F)
                    .decayModifier(5F).heatCapacity(0F).cookingTemp(0F).build(),
            FoodInfo.builder().name("grape").amountAndCalories(1, 0.25F).water(4F).nutrients(0.25F, 0F, 1F, 0F, 0F)
                    .decayModifier(5F).heatCapacity(0F).cookingTemp(-1F).build(),
            FoodInfo.builder().name("ume").amountAndCalories(2, 0.2F).water(5F).nutrients(0F, 1F, 0F, 0F, 0F)
                    .decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("umeboshi").amountAndCalories(2, 0.5F).water(5F).nutrients(0F, 2F, 0F, 0F, 0F)
                    .decayModifier(0F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("red_bean_paste").amountAndCalories(4, 0.25F).water(4F)
                    .nutrients(0.25F, 0F, 1F, 0F, 0F).decayModifier(4F).heatCapacity(0F).cookingTemp(-1F).build(),
            FoodInfo.builder().name("cheese").amountAndCalories(2, 0.2F).water(1F).nutrients(0F, 0F, 0F, 0F, 2F)
                    .decayModifier(2F).heatCapacity(0F).cookingTemp(-1F).build(),
            FoodInfo.builder().name("shrimp").amountAndCalories(2, 0.6F).water(0.5F).nutrients(0F, 0F, 0F, 2F, 0F)
                    .decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("machined_fish").amountAndCalories(1, 0.2F).water(1F).nutrients(0F, 0F, 0F, 2F, 2F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("bonito").amountAndCalories(2, 0.2F).water(1F).nutrients(0F, 0F, 0F, 2F, 2F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("machined_bonito").amountAndCalories(1, 0.2F).water(1F)
                    .nutrients(0F, 0F, 0F, 2F, 2F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("boiled_bonito").amountAndCalories(2, 0.2F).water(3F).nutrients(0F, 0F, 0F, 2F, 2F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("smoked_bonito").amountAndCalories(3, 0.3F).water(0F).nutrients(0F, 0F, 0F, 2F, 2F)
                    .decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("dried_bonito").amountAndCalories(3, 0.3F).water(0F).nutrients(0F, 0F, 0F, 2F, 2F)
                    .decayModifier(0F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("bonito_shaving").amountAndCalories(1, 0.1F).water(0F).nutrients(0F, 0F, 0F, 2F, 2F)
                    .decayModifier(0F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("chestnut_toasted").amountAndCalories(4, 0.4F).water(0.5F)
                    .nutrients(2F, 0F, 2F, 0F, 0F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("taro_baked").amountAndCalories(5, 0.6F).water(0F).nutrients(2F, 2F, 0F, 0F, 0F)
                    .decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("roast_matsutake").amountAndCalories(5, 0.6F).water(0F)
                    .nutrients(0F, 0F, 3F, 0F, 0F).decayModifier(1F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("eggplant_baked").amountAndCalories(4, 0.5F).water(1F).nutrients(0F, 0F, 3F, 0F, 0F)
                    .decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("tamagoyaki").amountAndCalories(6, 0.6F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 3F)
                    .decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("fishcake").amountAndCalories(4, 0.6F).water(1F).nutrients(1F, 0F, 1F, 2F, 0F)
                    .decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("tofu").amountAndCalories(2, 0.4F).water(0.5F).nutrients(0F, 0F, 2F, 0F, 0.5F)
                    .decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("tofu_fried").amountAndCalories(4, 0.5F).water(0.5F)
                    .nutrients(0.5F, 0F, 3F, 0F, 0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("natto").amountAndCalories(2, 0.5F).water(0.5F).nutrients(1F, 0F, 2F, 0F, 0F)
                    .decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("mashed_potato").amountAndCalories(5, 0.6F).water(0.5F)
                    .nutrients(2F, 0F, 2F, 0F, 0.5F).decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("fries").amountAndCalories(5, 0.6F).water(1F).nutrients(2F, 0F, 2F, 0F, 0F)
                    .decayModifier(1F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("fried_chicken").amountAndCalories(6, 0.6F).water(2F).nutrients(1F, 0F, 0F, 4F, 0F)
                    .decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("croquette").amountAndCalories(6, 0.6F).water(2F).nutrients(2F, 0F, 2.5F, 2F, 0F)
                    .decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("katsu").amountAndCalories(9, 0.6F).water(4F).nutrients(0.25F, 0F, 0F, 3F, 0F)
                    .decayModifier(1.25F).heatCapacity(0F).cookingTemp(-1F).build(),
            FoodInfo.builder().name("tempura").amountAndCalories(5, 0.6F).water(0F).nutrients(1F, 0F, 0F, 2F, 0F)
                    .decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("burger_raw").amountAndCalories(2, 0.2F).water(1F).nutrients(0.5F, 0F, 0F, 3F, 0F)
                    .decayModifier(2F).heatCapacity(1F).cookingTemp(200F).build(),
            FoodInfo.builder().name("burger").amountAndCalories(6, 0.6F).water(2F).nutrients(0.5F, 0F, 0F, 4F, 0F)
                    .decayModifier(2F).heatCapacity(1F).cookingTemp(200F).build(),
            FoodInfo.builder().name("burger_dish").amountAndCalories(10, 0.8F).water(2.5F)
                    .nutrients(0.5F, 0F, 2F, 4F, 0F).decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("katsu_dish").amountAndCalories(10, 0.8F).water(0.5F)
                    .nutrients(0.5F, 0F, 2F, 5F, 1F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("croquette_dish").amountAndCalories(8, 0.6F).water(0.5F)
                    .nutrients(0.5F, 0F, 2F, 5F, 1F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("egg_soft").amountAndCalories(2, 0.6F).water(1F).nutrients(0F, 0F, 0F, 0.0F, 3.0F)
                    .decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("egg_soysauce").amountAndCalories(4, 0.6F).water(1F)
                    .nutrients(0F, 0F, 0F, 0.0F, 3.5F).decayModifier(1.0F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("lemon_juice").amountAndCalories(1, 0.1F).water(40F).nutrients(0F, 2F, 0F, 0F, 0F)
                    .decayModifier(5F).heatCapacity(0F).cookingTemp(0F).build(),
            FoodInfo.builder().name("soda_water").amountAndCalories(1, 0.1F).water(50F).nutrients(0F, 0F, 0F, 0F, 0F)
                    .decayModifier(5F).heatCapacity(0F).cookingTemp(0F).build(),
            FoodInfo.builder().name("blackcurrant_juice").amountAndCalories(1, 0.1F).water(40F)
                    .nutrients(0F, 2F, 0F, 0F, 0F).decayModifier(5F).heatCapacity(0F).cookingTemp(0F).build(),
            FoodInfo.builder().name("orange_juice").amountAndCalories(1, 0.1F).water(40F).nutrients(0F, 2F, 0F, 0F, 0F)
                    .decayModifier(5F).heatCapacity(0F).cookingTemp(0F).build(),
            FoodInfo.builder().name("brown_rice_cooked").amountAndCalories(4, 0.5F).water(0.5F)
                    .nutrients(1.5F, 0F, 0F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_cooked").amountAndCalories(4, 0.5F).water(0.5F)
                    .nutrients(1.5F, 0F, 0F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_redbean").amountAndCalories(6, 0.6F).water(0.5F).nutrients(4F, 0F, 2F, 0F, 0F)
                    .decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("fried_brown_rice").amountAndCalories(4, 0.5F).water(0F)
                    .nutrients(1.5F, 0F, 0F, 0F, 0F).decayModifier(0F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("dried_brown_rice").amountAndCalories(4, 0.5F).water(0F)
                    .nutrients(1.5F, 0F, 0F, 0F, 0F).decayModifier(0F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("dried_rice").amountAndCalories(4, 0.5F).water(0F).nutrients(1.5F, 0F, 0F, 0F, 0F)
                    .decayModifier(0F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_natto").amountAndCalories(5, 0.6F).water(0.5F).nutrients(2.5F, 0F, 2F, 0F, 0F)
                    .decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_bamboo").amountAndCalories(5, 0.6F).water(0.5F)
                    .nutrients(1.5F, 1F, 0F, 0F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_fish").amountAndCalories(7, 0.7F).water(0.5F).nutrients(1.5F, 0F, 0F, 2F, 0F)
                    .decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_beef").amountAndCalories(9, 0.8F).water(0.5F).nutrients(1.5F, 0F, 0F, 3F, 0F)
                    .decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_pork").amountAndCalories(7, 0.7F).water(0.5F).nutrients(1.5F, 0F, 0F, 3F, 0F)
                    .decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_mushroom").amountAndCalories(6, 0.6F).water(0.5F)
                    .nutrients(1.5F, 0F, 2F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_matsutake").amountAndCalories(8, 0.6F).water(0.5F)
                    .nutrients(2F, 0F, 3F, 0F, 1F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_egg").amountAndCalories(5, 0.6F).water(0.5F).nutrients(1.5F, 0F, 0F, 0F, 2F)
                    .decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_beef_egg").amountAndCalories(10, 1F).water(0.5F)
                    .nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_natto_egg").amountAndCalories(6, 0.6F).water(0.5F)
                    .nutrients(2.5F, 0F, 3F, 0F, 3F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_pork_egg").amountAndCalories(9, 0.8F).water(0.5F)
                    .nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_pork_fried").amountAndCalories(10, 1F).water(0.5F)
                    .nutrients(2F, 0F, 0F, 4F, 4F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_oyako").amountAndCalories(9, 0.8F).water(0.5F)
                    .nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_oyako_fish").amountAndCalories(9, 0.8F).water(0.5F)
                    .nutrients(1.5F, 0F, 0F, 3.5F, 2F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_curry").amountAndCalories(6, 0.6F).water(0.5F).nutrients(2.5F, 0F, 1F, 1F, 1F)
                    .decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_curry_katsu").amountAndCalories(10, 0.8F).water(0.5F)
                    .nutrients(3F, 0F, 1F, 4F, 1F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_curry_burger").amountAndCalories(10, 0.8F).water(0.5F)
                    .nutrients(3F, 0F, 1F, 4F, 1F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_curry_cheese").amountAndCalories(8, 0.8F).water(0.5F)
                    .nutrients(2.5F, 0F, 1F, 1F, 4F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_curry_cheese_katsu").amountAndCalories(12, 0.8F).water(0.5F)
                    .nutrients(3F, 0F, 1F, 4F, 3F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_curry_cheese_burger").amountAndCalories(12, 0.8F).water(0.5F)
                    .nutrients(3F, 0F, 1F, 4F, 3F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("omurice").amountAndCalories(8, 0.6F).water(0.5F).nutrients(2F, 0F, 3F, 3F, 2F)
                    .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("curry_omurice").amountAndCalories(8, 0.6F).water(0.5F)
                    .nutrients(3F, 0F, 1F, 4F, 3F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("rice_fried").amountAndCalories(8, 0.6F).water(0.5F).nutrients(1.5F, 0F, 2F, 2F, 0F)
                    .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("zosui_zuiki").amountAndCalories(6, 1F).water(5F).nutrients(2F, 0F, 2F, 0F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("zosui").amountAndCalories(8, 1F).water(5F).nutrients(0F, 0F, 0F, 3F, 3F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("onigiri").amountAndCalories(6, 0.6F).water(0.5F).nutrients(2F, 0F, 1F, 0F, 0F)
                    .decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("onigiri_bamboo").amountAndCalories(7, 0.7F).water(0.5F)
                    .nutrients(2F, 0F, 2F, 0F, 0F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("onigiri_fish").amountAndCalories(8, 0.7F).water(0.5F).nutrients(2F, 0F, 1F, 2F, 0F)
                    .decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("onigiri_mushroom").amountAndCalories(7, 0.7F).water(0.5F)
                    .nutrients(2F, 0F, 2F, 0F, 0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("onigiri_seaweed").amountAndCalories(7, 0.7F).water(0.5F)
                    .nutrients(2F, 0F, 2F, 0F, 0.5F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("onigiri_tempura").amountAndCalories(10, 0.8F).water(0.5F)
                    .nutrients(2F, 0F, 2F, 4F, 1F).decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("onigiri_matsutake").amountAndCalories(9, 0.7F).water(0.5F)
                    .nutrients(2F, 0F, 4F, 0F, 1F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("sushi").amountAndCalories(5, 0.6F).water(1F).nutrients(2F, 0F, 0F, 2F, 0F)
                    .decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("sushi_shrimp").amountAndCalories(5, 0.6F).water(1F).nutrients(2F, 0F, 0F, 2F, 0F)
                    .decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("sushi_tamago").amountAndCalories(4, 0.6F).water(1F).nutrients(2F, 0F, 0F, 0F, 2F)
                    .decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("ehoumaki").amountAndCalories(8, 0.6F).water(1F).nutrients(2F, 0F, 3F, 3F, 2F)
                    .decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("mochi").amountAndCalories(2, 0.5F).water(0.5F).nutrients(2F, 0F, 0F, 0F, 0F)
                    .decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("mochi_toasted").amountAndCalories(4, 0.6F).water(0.5F)
                    .nutrients(3F, 0F, 0F, 0F, 0F).decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("mochi_sakura").amountAndCalories(4, 0.6F).water(0.5F)
                    .nutrients(3F, 0F, 1F, 0F, 0.5F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("ohagi").amountAndCalories(6, 0.6F).water(0.5F).nutrients(3F, 0F, 0.5F, 0F, 0.5F)
                    .decayModifier(2.25F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("ramen").amountAndCalories(4, 0.5F).water(35F).nutrients(1.5F, 0F, 0F, 0F, 0F)
                    .decayModifier(0F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("ramen_beef").amountAndCalories(9, 0.8F).water(35F).nutrients(1.5F, 0F, 0F, 3F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("ramen_egg").amountAndCalories(5, 0.6F).water(35F).nutrients(1.5F, 0F, 0F, 0F, 2F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("ramen_tempura").amountAndCalories(9, 0.8F).water(35F).nutrients(2F, 0F, 0F, 3F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("ramen_friedtofu").amountAndCalories(9, 0.7F).water(35F)
                    .nutrients(2F, 0F, 2F, 0F, 0F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("ramen_katsu").amountAndCalories(10, 0.8F).water(35F).nutrients(2F, 0F, 0F, 4F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("ramen_chicken").amountAndCalories(9, 0.8F).water(35F).nutrients(2F, 0F, 0F, 4F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("ramen_croquette").amountAndCalories(9, 0.8F).water(35F)
                    .nutrients(2F, 0F, 0F, 4F, 0F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("ramen_large").amountAndCalories(12, 1F).water(35F).nutrients(2F, 0F, 5F, 5F, 2F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("udon").amountAndCalories(4, 0.5F).water(35F).nutrients(1.5F, 0F, 0F, 0F, 0F)
                    .decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("udon_beef").amountAndCalories(9, 0.8F).water(35F).nutrients(1.5F, 0F, 0F, 3F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("udon_egg").amountAndCalories(5, 0.6F).water(35F).nutrients(1.5F, 0F, 0F, 0F, 2F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("udon_tempura").amountAndCalories(9, 0.8F).water(35F).nutrients(2F, 0F, 0F, 3F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("udon_friedtofu").amountAndCalories(9, 0.7F).water(35F)
                    .nutrients(2F, 0F, 2F, 0F, 0F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("udon_katsu").amountAndCalories(10, 0.8F).water(35F).nutrients(2F, 0F, 0F, 4F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("udon_croquette").amountAndCalories(9, 0.8F).water(35F)
                    .nutrients(2F, 0F, 0F, 4F, 0F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("udon_chicken").amountAndCalories(9, 0.8F).water(35F).nutrients(2F, 0F, 0F, 4F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("udon_large").amountAndCalories(12, 1F).water(35F).nutrients(2F, 0F, 5F, 5F, 2F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("yaki_udon").amountAndCalories(9, 0.7F).water(2.5F).nutrients(1.5F, 0F, 4F, 2F, 2F)
                    .decayModifier(3.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("soba").amountAndCalories(4, 0.5F).water(35F).nutrients(1.5F, 0F, 0F, 0F, 0F)
                    .decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("soba_beef").amountAndCalories(9, 0.8F).water(35F).nutrients(1.5F, 0F, 0F, 3F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("soba_egg").amountAndCalories(5, 0.6F).water(35F).nutrients(1.5F, 0F, 0F, 0F, 2F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("soba_tempura").amountAndCalories(9, 0.8F).water(35F).nutrients(2F, 0F, 0F, 3F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("soba_friedtofu").amountAndCalories(9, 0.7F).water(35F)
                    .nutrients(2F, 0F, 2F, 0F, 0F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("soba_katsu").amountAndCalories(10, 0.8F).water(35F).nutrients(2F, 0F, 0F, 4F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("soba_croquette").amountAndCalories(9, 0.8F).water(35F)
                    .nutrients(2F, 0F, 0F, 4F, 0F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("soba_chicken").amountAndCalories(9, 0.8F).water(35F).nutrients(2F, 0F, 0F, 4F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("soba_large").amountAndCalories(12, 1F).water(35F).nutrients(2F, 0F, 5F, 5F, 2F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("soba_zaru").amountAndCalories(6, 0.7F).water(5F).nutrients(2F, 0F, 0.5F, 0F, 0F)
                    .decayModifier(3.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("yaki_soba").amountAndCalories(9, 0.7F).water(2.5F).nutrients(1.5F, 0F, 4F, 2F, 2F)
                    .decayModifier(3.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("pasta_tomato").amountAndCalories(9, 0.8F).water(1.5F).nutrients(2F, 0F, 4F, 4F, 2F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("pasta_mushroom").amountAndCalories(9, 0.8F).water(1.5F)
                    .nutrients(2F, 0F, 4F, 4F, 2F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("pasta_whitesauce").amountAndCalories(9, 0.8F).water(1.5F)
                    .nutrients(2F, 0F, 4F, 4F, 2F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("yaki_pasta").amountAndCalories(9, 0.7F).water(2.5F).nutrients(1.5F, 0F, 4F, 2F, 2F)
                    .decayModifier(3.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("oden").amountAndCalories(8, 0.6F).water(1F).nutrients(1F, 0F, 3F, 3F, 0F)
                    .decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("dananko").amountAndCalories(6, 0.6F).water(1F).nutrients(3F, 0F, 0F, 0F, 1F)
                    .decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("danmitarashi").amountAndCalories(6, 0.4F).water(1F).nutrients(3F, 0F, 0F, 0F, 1F)
                    .decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("dansansyoku").amountAndCalories(6, 0.6F).water(1F).nutrients(3F, 0F, 0F, 0F, 1F)
                    .decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("beef_stick").amountAndCalories(8, 0.8F).water(2F).nutrients(0F, 0F, 0F, 4F, 0F)
                    .decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("chicken_stick").amountAndCalories(6, 0.4F).water(2F).nutrients(0F, 0F, 0F, 4F, 0F)
                    .decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("pork_stick").amountAndCalories(6, 0.6F).water(2F).nutrients(0F, 0F, 0F, 4F, 0F)
                    .decayModifier(1.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("soup_red_bean").amountAndCalories(6, 0.6F).water(5F).nutrients(2F, 0F, 2F, 0F, 2F)
                    .decayModifier(5F).heatCapacity(0F).cookingTemp(0F).build(),
            FoodInfo.builder().name("soup_miso").amountAndCalories(5, 0.5F).water(50F).nutrients(0F, 0F, 0F, 0F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("chawanmushi").amountAndCalories(6, 0.5F).water(5F).nutrients(0F, 0F, 3F, 3F, 3F)
                    .decayModifier(5F).heatCapacity(2F).cookingTemp(480F).build(),
            FoodInfo.builder().name("osuimono").amountAndCalories(4, 0.5F).water(50F).nutrients(0F, 0F, 0F, 0F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("ochazuke").amountAndCalories(6, 0.6F).water(50F).nutrients(0F, 0F, 2F, 2F, 2F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("fruitsalad").amountAndCalories(6, 0.6F).water(15F).nutrients(2F, 4F, 0F, 0F, 2F)
                    .decayModifier(5.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("maple_cookie").amountAndCalories(3, 0.25F).water(0.75F)
                    .nutrients(2F, 0F, 0F, 0F, 0.2F).decayModifier(0.8F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("pudding").amountAndCalories(4, 0.4F).water(2F).nutrients(2F, 0F, 0F, 0F, 2F)
                    .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("pudding_maple").amountAndCalories(6, 0.6F).water(2F).nutrients(3F, 0F, 0F, 0F, 2F)
                    .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("pound_cake").amountAndCalories(5, 0.6F).water(0.5F).nutrients(4F, 2F, 0F, 0F, 4F)
                    .decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("dorayaki").amountAndCalories(6, 0.6F).water(1F).nutrients(5F, 2F, 2F, 0F, 0F)
                    .decayModifier(2F).heatCapacity(2F).cookingTemp(480F).build(),
            FoodInfo.builder().name("raw_taiyaki").amountAndCalories(2, 0.2F).water(0.5F)
                    .nutrients(0.5F, 0F, 0F, 0F, 0F).decayModifier(2F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("taiyaki").amountAndCalories(6, 0.6F).water(0.5F).nutrients(4F, 0F, 0F, 0F, 4F)
                    .decayModifier(1F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("taiyaki_mocha").amountAndCalories(8, 0.6F).water(0.5F)
                    .nutrients(4F, 0F, 0F, 0F, 4F).decayModifier(1F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("mocha_cookie").amountAndCalories(5, 0.25F).water(0.75F)
                    .nutrients(2F, 0F, 0F, 0F, 0.2F).decayModifier(0.8F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("pudding_mocha").amountAndCalories(6, 0.6F).water(2F).nutrients(3F, 0F, 0F, 0F, 2F)
                    .decayModifier(2.5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("pound_cake_mocha").amountAndCalories(7, 0.6F).water(0.5F)
                    .nutrients(4F, 2F, 0F, 0F, 4F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("sashimi").amountAndCalories(6, 0.6F).water(1F).nutrients(0F, 0F, 1F, 3F, 0F)
                    .decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("fish_bake").amountAndCalories(8, 0.8F).water(0.5F).nutrients(0F, 0F, 0F, 4F, 0F)
                    .decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("fish_bake_salt").amountAndCalories(8, 0.8F).water(0.5F)
                    .nutrients(0F, 0F, 0F, 4F, 0F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("mabodofu").amountAndCalories(8, 0.6F).water(1F).nutrients(1F, 0F, 3F, 1F, 0F)
                    .decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("maboqiezi").amountAndCalories(8, 0.6F).water(1F).nutrients(1F, 0F, 4F, 0F, 0F)
                    .decayModifier(4F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("nikujaga").amountAndCalories(8, 0.6F).water(0.5F).nutrients(2F, 0F, 3F, 4F, 2F)
                    .decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("furofuki_daikon").amountAndCalories(5, 0.6F).water(25F)
                    .nutrients(0F, 0F, 4F, 0F, 0F).decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("cabbage_roll").amountAndCalories(4, 0.4F).water(25F).nutrients(0F, 0F, 4F, 0F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("white_stew").amountAndCalories(6, 0.6F).water(35F).nutrients(2F, 2F, 2F, 2F, 2F)
                    .decayModifier(5F).heatCapacity(0F).cookingTemp(0F).build(),
            FoodInfo.builder().name("hamburger").amountAndCalories(8, 0.6F).water(0.5F).nutrients(2F, 0F, 2F, 4F, 1F)
                    .decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("cheese_burger").amountAndCalories(10, 0.8F).water(0.5F)
                    .nutrients(2F, 0F, 2F, 4F, 3F).decayModifier(3F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("dough_okinoyaki").amountAndCalories(2, 0.2F).water(0F)
                    .nutrients(2F, 0F, 2F, 2F, 2F).decayModifier(0F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("okinoyaki").amountAndCalories(8, 0.8F).water(0.5F).nutrients(2F, 0F, 3F, 3F, 3F)
                    .decayModifier(1F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("okinoyaki_plus").amountAndCalories(10, 1F).water(1F).nutrients(3F, 3F, 3F, 3F, 3F)
                    .decayModifier(1F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("okinoyaki_final").amountAndCalories(12, 1F).water(1F).nutrients(5F, 5F, 5F, 5F, 5F)
                    .decayModifier(1F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("hyorogan").amountAndCalories(4, 0.5F).water(0F).nutrients(2F, 0F, 0F, 0F, 0F)
                    .decayModifier(0F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("suikatsugan").amountAndCalories(4, 0.5F).water(20F).nutrients(1.5F, 2F, 0F, 0F, 0F)
                    .decayModifier(0F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("nimono_pumpkin").amountAndCalories(6, 0.5F).water(5F).nutrients(2F, 0F, 2F, 0F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("nimono_radish").amountAndCalories(6, 0.5F).water(5F).nutrients(2F, 0F, 2F, 0F, 0F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("nimono_fish").amountAndCalories(8, 1F).water(6F).nutrients(0F, 0F, 0F, 3F, 3F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("chikuzenni").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("imotaki").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build(),
            FoodInfo.builder().name("noppei_jiru").amountAndCalories(12, 1F).water(5F).nutrients(0F, 5F, 5F, 5F, 5F)
                    .decayModifier(5F).heatCapacity(1F).cookingTemp(480F).build());
}
