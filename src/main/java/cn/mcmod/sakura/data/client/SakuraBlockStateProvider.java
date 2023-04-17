package cn.mcmod.sakura.data.client;

import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod_mmf.mmlib.data.AbstractBlockStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
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
        
        simpleBlock(BlockRegistry.STRAW_BLOCK.get());

        simpleBlock(BlockRegistry.MAPLE_LEAVES_RED.get());
        simpleBlock(BlockRegistry.MAPLE_LEAVES_YELLOW.get());
        simpleBlock(BlockRegistry.MAPLE_LEAVES_GREEN.get());
        simpleBlock(BlockRegistry.MAPLE_LEAVES_ORANGE.get());

        log(BlockRegistry.SAKURA_LOG);
        log(BlockRegistry.STRIPPED_SAKURA_LOG);
        log(BlockRegistry.MAPLE_LOG);
        log(BlockRegistry.STRIPPED_MAPLE_LOG);
        log(BlockRegistry.BAMBOO_BLOCK);
        log(BlockRegistry.BAMBOO_BLOCK_SUNBURNT);
        log(BlockRegistry.BAMBOO_CHARCOAL_BLOCK);

        horizontalBlock(BlockRegistry.FERMENTER.get(), models().getExistingFile(new ResourceLocation("sakura:block/fermenter")));
        crossBlock(BlockRegistry.SAKURA_SAPLING);
        crossBlock(BlockRegistry.MAPLE_SAPLING_RED);
        crossBlock(BlockRegistry.MAPLE_SAPLING_YELLOW);
        crossBlock(BlockRegistry.MAPLE_SAPLING_GREEN);
        crossBlock(BlockRegistry.MAPLE_SAPLING_ORANGE);

        stageBlock(BlockRegistry.BUCKWHEAT_CROP, BlockStateProperties.AGE_7);
        stageBlock(BlockRegistry.RAPESEED_CROP, BlockStateProperties.AGE_7);
        stageBlock(BlockRegistry.REDBEAN_CROP, BlockStateProperties.AGE_3);
        stageBlock(BlockRegistry.TARO_CROP, BlockStateProperties.AGE_3);
        
        horizontalBlock(BlockRegistry.TATAMI.get(), 
                texture("tatami"), 
                texture("tatami"), 
                texture("tatami"));
        horizontalBlock(BlockRegistry.TATAMI_SUNBURNT.get(), 
                texture("tatami_tan"), 
                texture("tatami_tan"), 
                texture("tatami_tan"));
        
        facingSlabBlock(BlockRegistry.TATAMI_SLAB, 
                texture("tatami"), 
                texture("tatami"), 
                texture("tatami")
        );
        facingSlabBlock(BlockRegistry.TATAMI_SLAB_SUNBURNT, 
                texture("tatami_tan"), 
                texture("tatami_tan"), 
                texture("tatami_tan")
        );
    }

}
