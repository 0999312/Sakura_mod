package cn.mcmod.sakura.level.tree;

import java.util.Random;

import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class MapleTreeGrower extends AbstractTreeGrower {
    private final ConfiguredFeature<TreeConfiguration, ?> tree;
    private final ConfiguredFeature<TreeConfiguration, ?> fancy_tree;

    public MapleTreeGrower(ConfiguredFeature<TreeConfiguration, ?> tree,
            ConfiguredFeature<TreeConfiguration, ?> fancy_tree) {
        this.tree = tree;
        this.fancy_tree = fancy_tree;
    }

    @Override
    protected ConfiguredFeature<?, ?> getConfiguredFeature(Random random, boolean hasBees) {
        if (random.nextInt(10) == 0) {
            return this.fancy_tree;
        } else {
            return this.tree;
        }
    }

}
