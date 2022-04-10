package cn.mcmod.sakura.level.tree;

import java.util.OptionalInt;

import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.level.WorldGenerationRegistry;
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
import net.minecraftforge.registries.RegistryObject;

public class SakuraTreeFeatures {

    public static final RegistryObject<ConfiguredFeature<?, ?>> SAKURA = WorldGenerationRegistry.FEATURES.register("sakura",
            ()->registryTree(createSimpleBlobTree(BlockRegistry.SAKURA_LOG.get(), BlockRegistry.SAKURA_LEAVES.get()).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_SAKURA = WorldGenerationRegistry.FEATURES.register("fancy_sakura",
            ()->registryTree(createFancyTree(BlockRegistry.SAKURA_LOG.get(), BlockRegistry.SAKURA_LEAVES.get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> MAPLE_RED = WorldGenerationRegistry.FEATURES.register("maple_red",
            ()->registryTree(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(),BlockRegistry.MAPLE_LEAVES_RED.get(), 5, 2, 0, 2).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_MAPLE_RED = WorldGenerationRegistry.FEATURES.register("fancy_maple_red",
            ()->registryTree(createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.MAPLE_LEAVES_RED.get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> MAPLE_YELLOW = WorldGenerationRegistry.FEATURES.register("maple_yellow",
            ()->registryTree(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(),BlockRegistry.MAPLE_LEAVES_YELLOW.get(), 5, 2, 0, 2).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_MAPLE_YELLOW = WorldGenerationRegistry.FEATURES.register("fancy_maple_yellow",
            ()->registryTree(createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.MAPLE_LEAVES_YELLOW.get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> MAPLE_ORANGE = WorldGenerationRegistry.FEATURES.register("maple_orange",
            ()->registryTree(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(),BlockRegistry.MAPLE_LEAVES_ORANGE.get(), 5, 2, 0, 2).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_MAPLE_ORANGE = WorldGenerationRegistry.FEATURES.register("fancy_maple_orange", 
            ()->registryTree(createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.MAPLE_LEAVES_ORANGE.get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> MAPLE_GREEN = WorldGenerationRegistry.FEATURES.register("maple_green",
            ()->registryTree(createStraightBlobTree(BlockRegistry.MAPLE_LOG.get(),BlockRegistry.MAPLE_LEAVES_GREEN.get(), 5, 2, 0, 2).ignoreVines()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_MAPLE_GREEN = WorldGenerationRegistry.FEATURES.register("fancy_maple_green", 
            ()->registryTree(createFancyTree(BlockRegistry.MAPLE_LOG.get(), BlockRegistry.MAPLE_LEAVES_GREEN.get())));

    private static ConfiguredFeature<?, ?> registryTree(TreeConfiguration.TreeConfigurationBuilder tree){
        return new ConfiguredFeature<>(Feature.TREE, tree.build());
    }
    
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
