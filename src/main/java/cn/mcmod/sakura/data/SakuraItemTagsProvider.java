package cn.mcmod.sakura.data;

import cn.mcmod.sakura.block.BlockItemRegistry;
import cn.mcmod.sakura.item.FoodRegistry;
import cn.mcmod.sakura.item.ItemRegistry;
import cn.mcmod.sakura.item.enums.SakuraFoodSet;
import cn.mcmod.sakura.item.enums.SakuraNormalItemSet;
import cn.mcmod.sakura.tags.SakuraItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SakuraItemTagsProvider extends ItemTagsProvider {

    public SakuraItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTags, String modId,
            ExistingFileHelper existingFileHelper) {
        super(generator, blockTags, modId, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags() {
        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        tag(ItemTags.LOGS).add(BlockItemRegistry.MAPLE_LOG.get(), BlockItemRegistry.SAKURA_LOG.get(),
                BlockItemRegistry.MAPLE_WOOD.get(), BlockItemRegistry.SAKURA_WOOD.get(),
                BlockItemRegistry.STRIPPED_MAPLE_LOG.get(), BlockItemRegistry.STRIPPED_SAKURA_LOG.get());

        tag(ItemTags.COALS).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO_CHARCOAL).get());
        
        tag(SakuraItemTags.SEEDS_RICE).add(ItemRegistry.RICE_SEEDS.get());
        tag(SakuraItemTags.SEEDS_CABBAGE).add(ItemRegistry.CABBAGE_SEEDS.get());
        tag(SakuraItemTags.SEEDS_EGGPLANT).add(ItemRegistry.EGGPLANT_SEEDS.get());
        tag(SakuraItemTags.SEEDS_BUCKWHEAT).add(ItemRegistry.BUCKWHEAT.get());
        tag(SakuraItemTags.SEEDS_ONION).add(ItemRegistry.ONION_SEEDS.get());
        tag(SakuraItemTags.SEEDS_RADISH).add(ItemRegistry.RADISH_SEEDS.get());
        tag(SakuraItemTags.SEEDS_RAPESEED).add(ItemRegistry.RAPESEEDS.get());
        tag(SakuraItemTags.SEEDS_REDBEAN).add(ItemRegistry.RED_BEAN.get());
        tag(SakuraItemTags.SEEDS_TOMATO).add(ItemRegistry.TOMATO_SEEDS.get());

        tag(SakuraItemTags.BAMBOO).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO).get());
        tag(SakuraItemTags.BAMBOO).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO_SUNBURNT).get());
        tag(SakuraItemTags.BAMBOO).add(Items.BAMBOO);

        tag(SakuraItemTags.CROPS_REDBEAN).add(ItemRegistry.RED_BEAN.get());
        tag(SakuraItemTags.CROPS_BUCKWHEAT).add(ItemRegistry.BUCKWHEAT.get());

        tag(SakuraItemTags.CROPS_RICE).add(ItemRegistry.RICE_SEEDS.get());
        tag(SakuraItemTags.CROPS_TARO).add(ItemRegistry.TARO.get());
        tag(SakuraItemTags.CROPS_CABBAGE).add(FoodRegistry.FOODSET.get(SakuraFoodSet.CABBAGE).get());
        tag(SakuraItemTags.CROPS_EGGPLANT).add(FoodRegistry.FOODSET.get(SakuraFoodSet.EGGPLANT).get());
        tag(SakuraItemTags.CROPS_ONION).add(FoodRegistry.FOODSET.get(SakuraFoodSet.ONION).get());
        tag(SakuraItemTags.CROPS_RADISH).add(FoodRegistry.FOODSET.get(SakuraFoodSet.RADISH).get());
        tag(SakuraItemTags.CROPS_TOMATO).add(FoodRegistry.FOODSET.get(SakuraFoodSet.TOMATO).get());

        tag(SakuraItemTags.CROPS_RICE).add(ItemRegistry.RICE_SEEDS.get());
        tag(SakuraItemTags.CROPS_TARO).add(ItemRegistry.TARO.get());

        tag(SakuraItemTags.VEGETABLES_CABBAGE).add(FoodRegistry.FOODSET.get(SakuraFoodSet.CABBAGE).get());
        tag(SakuraItemTags.VEGETABLES_EGGPLANT).add(FoodRegistry.FOODSET.get(SakuraFoodSet.EGGPLANT).get());
        tag(SakuraItemTags.VEGETABLES_ONION).add(FoodRegistry.FOODSET.get(SakuraFoodSet.ONION).get());
        tag(SakuraItemTags.VEGETABLES_RADISH).add(FoodRegistry.FOODSET.get(SakuraFoodSet.RADISH).get());
        tag(SakuraItemTags.VEGETABLES_TOMATO).add(FoodRegistry.FOODSET.get(SakuraFoodSet.TOMATO).get());

        tag(SakuraItemTags.RICE_BROWN).addTag(SakuraItemTags.GRAIN_RICE);
        tag(SakuraItemTags.RICE_RICE).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.RICE).get());
        tag(SakuraItemTags.STRAW).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.STRAW).get());
        tag(SakuraItemTags.RICE).addTag(SakuraItemTags.RICE_BROWN).addTag(SakuraItemTags.RICE_RICE);

        tag(SakuraItemTags.LUMBER).addTag(SakuraItemTags.LUMBER_BAMBOO).addTag(SakuraItemTags.LUMBER_MAPLE)
                .addTag(SakuraItemTags.LUMBER_SAKURA);

        tag(SakuraItemTags.LUMBER_TFC).addTag(SakuraItemTags.LUMBER);

        tag(SakuraItemTags.LUMBER_BAMBOO).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.LUMBER_BAMBOO).get());

        tag(SakuraItemTags.LUMBER_MAPLE).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.LUMBER_MAPLE).get());
        tag(SakuraItemTags.LUMBER_SAKURA).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.LUMBER_SAKURA).get());
        tag(SakuraItemTags.GRAIN_RICE).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BROWN_RICE).get());
        tag(SakuraItemTags.GRAIN_BUCKWHEAT).add(ItemRegistry.BUCKWHEAT.get());

        tag(SakuraItemTags.SALT).addTag(SakuraItemTags.DUST_SALT).addTag(SakuraItemTags.SALT_SALT);
        tag(SakuraItemTags.DUST_SALT).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.SALT).get());
        tag(SakuraItemTags.SALT_SALT).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.SALT).get());

        tag(SakuraItemTags.SUGAR).addTag(SakuraItemTags.SUGAR_SUGAR);
        tag(SakuraItemTags.SUGAR_SUGAR).add(Items.SUGAR);
        
        tag(SakuraItemTags.CHEESE).addTag(SakuraItemTags.CHEESE_CHEESE);
        tag(SakuraItemTags.CHEESE_CHEESE).add(FoodRegistry.FOODSET.get(SakuraFoodSet.CHEESE).get());

        tag(SakuraItemTags.WATER).addTag(SakuraItemTags.WATER_WATER);
        tag(SakuraItemTags.WATER_WATER).add(Items.WATER_BUCKET);

        tag(SakuraItemTags.FLOUR).addTags(SakuraItemTags.FLOUR_WHEAT, SakuraItemTags.FLOUR_BUCKWHEAT,
                SakuraItemTags.FLOUR_RICE);
        tag(SakuraItemTags.FLOUR_WHEAT).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.FLOUR).get());
        tag(SakuraItemTags.FLOUR_BUCKWHEAT).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.FLOUR_BUCKWHEAT).get());
        tag(SakuraItemTags.FLOUR_RICE).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.FLOUR_RICE).get());

        tag(SakuraItemTags.DOUGH).addTags(SakuraItemTags.DOUGH_WHEAT, SakuraItemTags.DOUGH_BUCKWHEAT,
                SakuraItemTags.DOUGH_RICE);
        tag(SakuraItemTags.DOUGH_WHEAT).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.DOUGH).get());
        tag(SakuraItemTags.DOUGH_BUCKWHEAT).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.DOUGH_BUCKWHEAT).get());
        tag(SakuraItemTags.DOUGH_RICE).add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.DOUGH_RICE).get());

        registerForgeTags();
    }

    @SuppressWarnings("unchecked")
    private void registerForgeTags() {
        tag(SakuraItemTags.SEEDS).addTag(SakuraItemTags.SEEDS_CABBAGE).addTag(SakuraItemTags.SEEDS_ONION)
                .addTag(SakuraItemTags.SEEDS_EGGPLANT).addTag(SakuraItemTags.SEEDS_RADISH)
                .addTag(SakuraItemTags.SEEDS_RICE).addTag(SakuraItemTags.SEEDS_TOMATO)
                .addTag(SakuraItemTags.SEEDS_BUCKWHEAT).addTag(SakuraItemTags.SEEDS_RAPESEED)
                .addTag(SakuraItemTags.SEEDS_REDBEAN);
        tag(SakuraItemTags.CROPS).addTag(SakuraItemTags.CROPS_CABBAGE).addTag(SakuraItemTags.CROPS_ONION)
                .addTag(SakuraItemTags.CROPS_BUCKWHEAT).addTag(SakuraItemTags.CROPS_EGGPLANT)
                .addTag(SakuraItemTags.CROPS_RADISH).addTag(SakuraItemTags.CROPS_RICE)
                .addTag(SakuraItemTags.CROPS_TOMATO).addTag(SakuraItemTags.CROPS_TARO)
                .addTag(SakuraItemTags.SEEDS_RAPESEED).addTag(SakuraItemTags.CROPS_REDBEAN)

        ;
        tag(SakuraItemTags.VEGETABLES).addTag(SakuraItemTags.VEGETABLES_CABBAGE)
                .addTag(SakuraItemTags.VEGETABLES_BEETROOT).addTag(SakuraItemTags.VEGETABLES_CARROT)
                .addTag(SakuraItemTags.VEGETABLES_EGGPLANT).addTag(SakuraItemTags.VEGETABLES_ONION)
                .addTag(SakuraItemTags.VEGETABLES_POTATO).addTag(SakuraItemTags.VEGETABLES_RADISH)
                .addTag(SakuraItemTags.VEGETABLES_TOMATO)
                .add(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.IMOGARA).get());
        ;
        tag(SakuraItemTags.LEAFYVEGETABLES).addTag(SakuraItemTags.LEAFYVEGETABLES_CABBAGE);
        tag(SakuraItemTags.LEAFYVEGETABLES_CABBAGE).addTag(SakuraItemTags.VEGETABLES_CABBAGE);

        tag(SakuraItemTags.MUSHROOMS).addTags(SakuraItemTags.BROWN_MUSHROOMS, SakuraItemTags.RED_MUSHROOMS);
        tag(SakuraItemTags.BROWN_MUSHROOMS).add(Items.BROWN_MUSHROOM);
        tag(SakuraItemTags.RED_MUSHROOMS).add(Items.RED_MUSHROOM);
        tag(SakuraItemTags.VEGETABLES_BEETROOT).add(Items.BEETROOT);
        tag(SakuraItemTags.VEGETABLES_CARROT).add(Items.CARROT);
        tag(SakuraItemTags.VEGETABLES_POTATO).add(Items.POTATO);
        tag(SakuraItemTags.COOKIES).add(Items.COOKIE);
        tag(SakuraItemTags.BREAD).addTags(SakuraItemTags.BREAD_WHEAT, SakuraItemTags.BREAD_BUCKWHEAT,
                SakuraItemTags.BREAD_RICE);
        tag(SakuraItemTags.BREAD_WHEAT).add(Items.BREAD, FoodRegistry.FOODSET.get(SakuraFoodSet.BUN).get());
        tag(SakuraItemTags.BREAD_BUCKWHEAT).add(FoodRegistry.FOODSET.get(SakuraFoodSet.BUCKWHEAT_BREAD).get());
        tag(SakuraItemTags.BREAD_RICE).add(FoodRegistry.FOODSET.get(SakuraFoodSet.RICE_BREAD).get());
        tag(SakuraItemTags.COOKED_BEEF).add(Items.COOKED_BEEF);
        tag(SakuraItemTags.COOKED_CHICKEN).add(Items.COOKED_CHICKEN);
        tag(SakuraItemTags.COOKED_PORK).add(Items.COOKED_PORKCHOP);
        tag(SakuraItemTags.COOKED_MUTTON).add(Items.COOKED_MUTTON);
        tag(SakuraItemTags.COOKED_FISHES).addTags(SakuraItemTags.COOKED_FISHES_COD,
                SakuraItemTags.COOKED_FISHES_SALMON);
        tag(SakuraItemTags.COOKED_FISHES_COD).add(Items.COOKED_COD);
        tag(SakuraItemTags.COOKED_FISHES_SALMON).add(Items.COOKED_SALMON);
        tag(SakuraItemTags.EGGS).add(Items.EGG);
        tag(SakuraItemTags.GRAIN).addTags(SakuraItemTags.GRAIN_WHEAT, SakuraItemTags.GRAIN_RICE,
                SakuraItemTags.GRAIN_BUCKWHEAT);
        tag(SakuraItemTags.GRAIN_WHEAT).add(Items.WHEAT);
        tag(SakuraItemTags.MILK).addTags(SakuraItemTags.MILK_BUCKET);
        tag(SakuraItemTags.MILK_BUCKET).add(Items.MILK_BUCKET);
        tag(SakuraItemTags.RAW_BEEF).add(Items.BEEF);
        tag(SakuraItemTags.RAW_CHICKEN).add(Items.CHICKEN);
        tag(SakuraItemTags.RAW_PORK).add(Items.PORKCHOP);
        tag(SakuraItemTags.RAW_MUTTON).add(Items.MUTTON);
        tag(SakuraItemTags.FISHES).addTag(SakuraItemTags.RAW_FISHES);
        tag(SakuraItemTags.RAW_FISHES).addTags(SakuraItemTags.RAW_FISHES_COD, SakuraItemTags.RAW_FISHES_SALMON,
                SakuraItemTags.RAW_FISHES_TROPICAL);
        tag(SakuraItemTags.RAW_FISHES_COD).add(Items.COD);
        tag(SakuraItemTags.RAW_FISHES_SALMON).add(Items.SALMON);
        tag(SakuraItemTags.RAW_FISHES_TROPICAL).add(Items.TROPICAL_FISH);
        tag(SakuraItemTags.SALAD_INGREDIENTS).addTags(SakuraItemTags.SALAD_INGREDIENTS_CABBAGE,
                SakuraItemTags.SALAD_INGREDIENTS_TOMATO);
        tag(SakuraItemTags.SALAD_INGREDIENTS_CABBAGE)
                .add(FoodRegistry.FOODSET.get(SakuraFoodSet.CABBAGE).get())
                .add(FoodRegistry.FOODSET.get(SakuraFoodSet.SLICED_CABBAGE).get());
        tag(SakuraItemTags.SALAD_INGREDIENTS_TOMATO).add(FoodRegistry.FOODSET.get(SakuraFoodSet.TOMATO).get());
        tag(SakuraItemTags.TOOLS).addTags(SakuraItemTags.TOOLS_AXES, SakuraItemTags.TOOLS_PICKAXES,
                SakuraItemTags.TOOLS_SHOVELS);
        tag(SakuraItemTags.TOOLS_AXES).add(Items.WOODEN_AXE, Items.STONE_AXE, Items.IRON_AXE, Items.DIAMOND_AXE,
                Items.GOLDEN_AXE, Items.NETHERITE_AXE);
        tag(SakuraItemTags.TOOLS_PICKAXES).add(Items.WOODEN_PICKAXE, Items.STONE_PICKAXE, Items.IRON_PICKAXE,
                Items.DIAMOND_PICKAXE, Items.GOLDEN_PICKAXE, Items.NETHERITE_PICKAXE);
        tag(SakuraItemTags.TOOLS_SHOVELS).add(Items.WOODEN_SHOVEL, Items.STONE_SHOVEL, Items.IRON_SHOVEL,
                Items.DIAMOND_SHOVEL, Items.GOLDEN_SHOVEL, Items.NETHERITE_SHOVEL);
    }

    @Override
    public String getName() {
        return "Sakura Items' Tags";
    }
}
