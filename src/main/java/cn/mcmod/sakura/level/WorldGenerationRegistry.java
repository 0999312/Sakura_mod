package cn.mcmod.sakura.level;

import cn.mcmod.sakura.SakuraConfig;
import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class WorldGenerationRegistry {
    public static ConfiguredFeature<RandomPatchConfiguration, ?> FEATURE_PATCH_BAMBOOSHOOT;

    public static PlacedFeature PATCH_BAMBOOSHOOT;

    public static final BlockPos BLOCK_BELOW = new BlockPos(0, -1, 0);

    public static void registerGeneration() {
        FEATURE_PATCH_BAMBOOSHOOT = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new ResourceLocation(SakuraMod.MODID, "patch_bamboo_shoot"),
                Feature.RANDOM_PATCH.configured(getSingleConfiguration(BlockRegistry.BAMBOOSHOOT.get(), 64,
                        BlockPredicate.matchesBlock(Blocks.GRASS_BLOCK, BLOCK_BELOW))));
        PATCH_BAMBOOSHOOT = Registry.register(BuiltinRegistries.PLACED_FEATURE,
                new ResourceLocation(SakuraMod.MODID, "patch_bamboo_shoot"),
                FEATURE_PATCH_BAMBOOSHOOT.placed(RarityFilter.onAverageOnceEvery(SakuraConfig.CHANCE_BAMBOOSHOOT.get()),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    }

    public static RandomPatchConfiguration getSingleConfiguration(Block block, int tries, BlockPredicate plantedOn) {
        return getSpreadConfiguration(block, tries, 0, plantedOn);
    }

    public static RandomPatchConfiguration getSpreadConfiguration(Block block, int tries, int xzSpread,
            BlockPredicate plantedOn) {
        return new RandomPatchConfiguration(tries, xzSpread, 3,
                () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(block)))
                        .filtered(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, plantedOn)));
    }
}
