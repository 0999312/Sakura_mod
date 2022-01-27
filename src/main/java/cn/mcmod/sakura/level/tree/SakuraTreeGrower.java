package cn.mcmod.sakura.level.tree;

import java.util.Random;

import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class SakuraTreeGrower extends AbstractTreeGrower{

    @Override
    protected ConfiguredFeature<?, ?> getConfiguredFeature(Random random, boolean hasBees) {
        if (random.nextInt(10) == 0) {
            return SakuraTreeFeatures.FANCY_SAKURA;
         } else {
            return SakuraTreeFeatures.SAKURA;
         }
    }

}
