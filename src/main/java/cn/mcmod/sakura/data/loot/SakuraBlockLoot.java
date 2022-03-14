package cn.mcmod.sakura.data.loot;

import cn.mcmod.sakura.block.BambooPlant;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.block.crops.RiceCropRoot;
import cn.mcmod.sakura.item.FoodRegistry;
import cn.mcmod.sakura.item.ItemRegistry;
import cn.mcmod.sakura.item.enums.SakuraFoodSet;
import cn.mcmod.sakura.item.enums.SakuraNormalItemSet;
import cn.mcmod_mmf.mmlib.data.loot.AbstartctBlockLoot;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public class SakuraBlockLoot extends AbstartctBlockLoot {

    @Override
    public void addTables() {
        dropSelf(BlockRegistry.BAMBOO_BLOCK.get());
        BlockRegistry.BLOCKS.getEntries().forEach(block -> {
            if (block.get() instanceof LeavesBlock)
                ;
            else if (block.get() instanceof CropBlock)
                ;
            else if (block.get() instanceof RiceCropRoot)
                ;
            else if (block.get() instanceof BambooPlant)
                dropOther(block.get(), ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO).get());
            else
                dropSelf(block.get());
        });
        this.add(BlockRegistry.MAPLE_LEAVES_RED.get(), createLeavesDrops(BlockRegistry.MAPLE_LEAVES_RED.get(), BlockRegistry.MAPLE_SAPLING_RED.get(),
                NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(BlockRegistry.MAPLE_LEAVES_ORANGE.get(), createLeavesDrops(BlockRegistry.MAPLE_LEAVES_ORANGE.get(), BlockRegistry.MAPLE_SAPLING_ORANGE.get(),
                NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(BlockRegistry.MAPLE_LEAVES_YELLOW.get(), createLeavesDrops(BlockRegistry.MAPLE_LEAVES_YELLOW.get(), BlockRegistry.MAPLE_SAPLING_YELLOW.get(),
                NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(BlockRegistry.MAPLE_LEAVES_GREEN.get(), createLeavesDrops(BlockRegistry.MAPLE_LEAVES_GREEN.get(), BlockRegistry.MAPLE_SAPLING_GREEN.get(),
                NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(BlockRegistry.SAKURA_LEAVES.get(),createLeavesDrops(BlockRegistry.SAKURA_LEAVES.get(), BlockRegistry.SAKURA_SAPLING.get(),
                NORMAL_LEAVES_SAPLING_CHANCES));

        createCrop(BlockRegistry.CABBAGE_CROP.get(), FoodRegistry.FOODSET.get(SakuraFoodSet.CABBAGE).get(),
                ItemRegistry.CABBAGE_SEEDS.get(), 7);
        
        createCrop(BlockRegistry.RADISH_CROP.get(), FoodRegistry.FOODSET.get(SakuraFoodSet.RADISH).get(),
                ItemRegistry.RADISH_SEEDS.get(), 3);
        
        createCrop(BlockRegistry.ONION_CROP.get(), FoodRegistry.FOODSET.get(SakuraFoodSet.ONION).get(),
                ItemRegistry.ONION_SEEDS.get(), 3);
        
        createCrop(BlockRegistry.REDBEAN_CROP.get(), ItemRegistry.RED_BEAN.get(),
                ItemRegistry.RED_BEAN.get(), 3);
        
        createCrop(BlockRegistry.EGGPLANT_CROP.get(), FoodRegistry.FOODSET.get(SakuraFoodSet.EGGPLANT).get(),
                ItemRegistry.EGGPLANT_SEEDS.get(), 3);
        
        createCrop(BlockRegistry.TOMATO_CROP.get(), FoodRegistry.FOODSET.get(SakuraFoodSet.TOMATO).get(),
                ItemRegistry.TOMATO_SEEDS.get(), 3);
        
        createCrop(BlockRegistry.RICE_CROP.get(), ItemRegistry.MATERIALS.get(SakuraNormalItemSet.STRAW).get(),
                ItemRegistry.RICE_SEEDS.get(), 7);
        
        createCrop(BlockRegistry.RICE_CROP_ROOT.get(), ItemRegistry.MATERIALS.get(SakuraNormalItemSet.STRAW).get(),
                ItemRegistry.RICE_SEEDS.get(), 7);
        
        createCrop(BlockRegistry.RAPESEED_CROP.get(), ItemRegistry.RAPESEEDS.get(),
                ItemRegistry.RAPESEEDS.get(), 7);
        
        createCrop(BlockRegistry.TARO_CROP.get(), ItemRegistry.MATERIALS.get(SakuraNormalItemSet.IMOGARA).get(),
                ItemRegistry.TARO.get(), 3);
        
        createCrop(BlockRegistry.BUCKWHEAT_CROP.get(), ItemRegistry.BUCKWHEAT.get(),
                ItemRegistry.BUCKWHEAT.get(), 7);
    }

    private void createCrop(Block block, Item crop, Item seeds, int age) {
        LootItemCondition.Builder builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, age));
        this.add(block, createCropDrops(block, crop, seeds, builder));
    }
}
