package cn.mcmod.sakura.level.tree;

import java.util.OptionalInt;

import cn.mcmod.sakura.block.BlockRegistry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class SakuraTreeFeatures {

    public static final ConfiguredFeature<TreeConfiguration, ?> SAKURA = FeatureUtils.register("sakura",
            Feature.TREE
                    .configured(createSimpleBlobTree(BlockRegistry.SAKURA_LOG.get(), BlockRegistry.SAKURA_LEAVES.get())
                            .ignoreVines().build()));

    public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_SAKURA = FeatureUtils.register("fancy_sakura",
            Feature.TREE.configured(
                    createFancyTree(BlockRegistry.SAKURA_LOG.get(), BlockRegistry.SAKURA_LEAVES.get()).build()));

    public static final ConfiguredFeature<TreeConfiguration, ?> MAPLE_RED = FeatureUtils.register("maple_red",
            Feature.TREE.configured(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(),
                    BlockRegistry.MAPLE_LEAVES_RED.get(), 5, 2, 0, 2).ignoreVines().build()));

    public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_MAPLE_RED = FeatureUtils
            .register("fancy_maple_red", Feature.TREE.configured(
                    createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.MAPLE_LEAVES_RED.get()).build()));

    public static final ConfiguredFeature<TreeConfiguration, ?> MAPLE_YELLOW = FeatureUtils.register("maple_yellow",
            Feature.TREE.configured(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(),
                    BlockRegistry.MAPLE_LEAVES_YELLOW.get(), 5, 2, 0, 2).ignoreVines().build()));

    public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_MAPLE_YELLOW = FeatureUtils
            .register("fancy_maple_yellow", Feature.TREE.configured(
                    createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.MAPLE_LEAVES_YELLOW.get()).build()));

    public static final ConfiguredFeature<TreeConfiguration, ?> MAPLE_ORANGE = FeatureUtils.register("maple_orange",
            Feature.TREE.configured(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(),
                    BlockRegistry.MAPLE_LEAVES_ORANGE.get(), 5, 2, 0, 2).ignoreVines().build()));

    public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_MAPLE_ORANGE = FeatureUtils
            .register("fancy_maple_orange", Feature.TREE.configured(
                    createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.MAPLE_LEAVES_ORANGE.get()).build()));

    public static final ConfiguredFeature<TreeConfiguration, ?> MAPLE_GREEN = FeatureUtils.register("maple_green",
            Feature.TREE.configured(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(),
                    BlockRegistry.MAPLE_LEAVES_GREEN.get(), 5, 2, 0, 2).ignoreVines().build()));

    public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_MAPLE_GREEN = FeatureUtils
            .register("fancy_maple_green", Feature.TREE.configured(
                    createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.MAPLE_LEAVES_GREEN.get()).build()));

    private static TreeConfiguration.TreeConfigurationBuilder createSimpleBlobTree(Block log, Block leaves) {
        return createStraightBlobTree(log, leaves, 4, 2, 0, 2);
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block log, Block leaves,
            int baseHeight, int heightRandA, int heightRandB, int leaves_radius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log),
                new StraightTrunkPlacer(baseHeight, heightRandA, heightRandB), BlockStateProvider.simple(leaves),
                new BlobFoliagePlacer(ConstantInt.of(leaves_radius), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createFancyTree(Block log, Block leaves) {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log),
                new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(leaves),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
    }
}
