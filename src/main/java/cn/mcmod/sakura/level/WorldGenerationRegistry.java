package cn.mcmod.sakura.level;

import java.util.function.Supplier;

import com.google.common.collect.Lists;

import cn.mcmod.sakura.SakuraConfig;
import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class WorldGenerationRegistry {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> FEATURES = DeferredRegister
            .create(BuiltinRegistries.CONFIGURED_FEATURE.key(), SakuraMod.MODID);
    public static final DeferredRegister<PlacedFeature> PATCHES = DeferredRegister
            .create(BuiltinRegistries.PLACED_FEATURE.key(), SakuraMod.MODID);
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> FEATURE_PATCH_BAMBOOSHOOT = FEATURES.register("patch_bambooshoot", 
            ()->wildPlantFeature(BlockRegistry.BAMBOOSHOOT, BlockTags.DIRT));

    public static final RegistryObject<PlacedFeature> PATCH_BAMBOOSHOOT = PATCHES.register("patch_bambooshoot", 
            ()->wildPlantPatch(FEATURE_PATCH_BAMBOOSHOOT, RarityFilter.onAverageOnceEvery(SakuraConfig.CHANCE_BAMBOOSHOOT.get()),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    public static final BlockPos BLOCK_BELOW = new BlockPos(0, -1, 0);

    private static ConfiguredFeature<?, ?> wildPlantFeature(Supplier<Block> wildCrop, TagKey<Block> blockTag) {
        return new ConfiguredFeature<>(Feature.RANDOM_PATCH, getWildCropConfiguration(wildCrop.get(),
                64, 1, BlockPredicate.matchesTag(blockTag, BLOCK_BELOW)));
    }
    private static PlacedFeature wildPlantPatch(Supplier<ConfiguredFeature<?, ?>> feature,
            PlacementModifier... modifiers) {
        return new PlacedFeature(Holder.direct(feature.get()), Lists.newArrayList(modifiers));
    }
    
    private static RandomPatchConfiguration getWildCropConfiguration(Block block, int tries, int xzSpread, BlockPredicate plantedOn) {
        return new RandomPatchConfiguration(tries, xzSpread, 3, PlacementUtils.filtered(
                Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(block)),
                        BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, plantedOn)));
    }
}
