package cn.mcmod.sakura.data;

import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod_mmf.mmlib.data.AbstractBlockStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SakuraBlockStateProvider extends AbstractBlockStateProvider {

    public SakuraBlockStateProvider(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockRegistry.SAKURA_LEAVES.get());
        simpleBlock(BlockRegistry.SAKURA_PLANK.get());
        simpleBlock(BlockRegistry.MAPLE_PLANK.get());
        simpleBlock(BlockRegistry.BAMBOO_PLANK.get());
        
        simpleBlock(BlockRegistry.MAPLE_LEAVES_RED.get());
        simpleBlock(BlockRegistry.MAPLE_LEAVES_YELLOW.get());
        simpleBlock(BlockRegistry.MAPLE_LEAVES_GREEN.get());
        simpleBlock(BlockRegistry.MAPLE_LEAVES_ORANGE.get());

        log(BlockRegistry.SAKURA_LOG::get);
        log(BlockRegistry.STRIPPED_SAKURA_LOG::get);
        log(BlockRegistry.BAMBOO_BLOCK::get);
        log(BlockRegistry.BAMBOO_BLOCK_SUNBURNT::get);
        log(BlockRegistry.BAMBOO_CHARCOAL_BLOCK::get);
        
        log(BlockRegistry.MAPLE_LOG::get);
        log(BlockRegistry.STRIPPED_MAPLE_LOG::get);
        
        crossBlock(BlockRegistry.SAKURA_SAPLING::get);
        crossBlock(BlockRegistry.MAPLE_SAPLING_RED::get);
        crossBlock(BlockRegistry.MAPLE_SAPLING_YELLOW::get);
        crossBlock(BlockRegistry.MAPLE_SAPLING_GREEN::get);
        crossBlock(BlockRegistry.MAPLE_SAPLING_ORANGE::get);
        
        stageBlock(BlockRegistry.BUCKWHEAT_CROP::get, BlockStateProperties.AGE_7);
        stageBlock(BlockRegistry.RAPESEED_CROP::get, BlockStateProperties.AGE_7);
        stageBlock(BlockRegistry.REDBEAN_CROP::get, BlockStateProperties.AGE_3);
    }

}
