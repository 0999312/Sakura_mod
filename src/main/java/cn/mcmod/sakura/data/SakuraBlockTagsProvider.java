package cn.mcmod.sakura.data;

import cn.mcmod.sakura.block.BlockRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SakuraBlockTagsProvider extends BlockTagsProvider {

    public SakuraBlockTagsProvider(DataGenerator generator, String modId, ExistingFileHelper existingFileHelper) {
        super(generator, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.LOGS).add(BlockRegistry.STRIPPED_SAKURA_WOOD.get(), BlockRegistry.STRIPPED_MAPLE_WOOD.get(),
                BlockRegistry.SAKURA_WOOD.get(), BlockRegistry.MAPLE_WOOD.get(),
                BlockRegistry.STRIPPED_SAKURA_LOG.get(), BlockRegistry.STRIPPED_MAPLE_LOG.get(),
                BlockRegistry.SAKURA_LOG.get(), BlockRegistry.MAPLE_LOG.get(), BlockRegistry.MAPLE_SAP_LOG.get());
        this.tag(BlockTags.LOGS_THAT_BURN).add(BlockRegistry.STRIPPED_SAKURA_WOOD.get(),
                BlockRegistry.STRIPPED_MAPLE_WOOD.get(), BlockRegistry.SAKURA_WOOD.get(),
                BlockRegistry.MAPLE_WOOD.get(), BlockRegistry.STRIPPED_SAKURA_LOG.get(),
                BlockRegistry.STRIPPED_MAPLE_LOG.get(), BlockRegistry.SAKURA_LOG.get(), BlockRegistry.MAPLE_LOG.get(),
                BlockRegistry.MAPLE_SAP_LOG.get());
        
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BlockRegistry.STONE_MORTAR.get());

        this.tag(BlockTags.LEAVES).add(BlockRegistry.SAKURA_LEAVES.get(), BlockRegistry.MAPLE_LEAVES_RED.get(),
                BlockRegistry.MAPLE_LEAVES_GREEN.get(), BlockRegistry.MAPLE_LEAVES_ORANGE.get(),
                BlockRegistry.MAPLE_LEAVES_YELLOW.get());

        this.tag(BlockTags.SAPLINGS).add(BlockRegistry.SAKURA_SAPLING.get(), BlockRegistry.MAPLE_SAPLING_RED.get(),
                BlockRegistry.MAPLE_SAPLING_GREEN.get(), BlockRegistry.MAPLE_SAPLING_ORANGE.get(),
                BlockRegistry.MAPLE_SAPLING_YELLOW.get());

        this.tag(BlockTags.CROPS).add(BlockRegistry.RICE_CROP.get(), BlockRegistry.BUCKWHEAT_CROP.get(),
                BlockRegistry.CABBAGE_CROP.get(), BlockRegistry.EGGPLANT_CROP.get(), BlockRegistry.ONION_CROP.get(),
                BlockRegistry.RADISH_CROP.get(), BlockRegistry.RAPESEED_CROP.get(), BlockRegistry.REDBEAN_CROP.get(),
                BlockRegistry.RICE_CROP_ROOT.get(), BlockRegistry.TARO_CROP.get(), BlockRegistry.TOMATO_CROP.get());

        this.tag(BlockTags.PLANKS).add(BlockRegistry.SAKURA_PLANK.get(), BlockRegistry.BAMBOO_PLANK.get(),
                BlockRegistry.MAPLE_PLANK.get());
    }

    @Override
    public String getName() {
        return "Sakura Blocks' Tags";
    }
}
