package cn.mcmod.sakura.level.biome;

import cn.mcmod.sakura.SakuraMod;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BiomeRegistryExample {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
            SakuraMod.MODID);

    public static final RegistryObject<Biome> EXAMPLE_BIOME = BIOMES.register("example_biome",
            BiomeRegistryExample::makeExampleBiome);
    public static final ResourceKey<Biome> EXAMPLE_KEY = ResourceKey.create(Registry.BIOME_REGISTRY, 
            BiomeRegistryExample.EXAMPLE_BIOME.getId());
    private static Biome makeExampleBiome() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder()
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        builder.addFeature(0, null)
        globalOverworldGeneration(builder);

        // add features
        BiomeDefaultFeatures.addDefaultOres(builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder);
        BiomeDefaultFeatures.addAncientDebris(builder);
        BiomeDefaultFeatures.addBambooVegetation(builder);
        BiomeDefaultFeatures.addBlueIce(builder);
        BiomeDefaultFeatures.addJungleMelons(builder);
        Biome result = new Biome.BiomeBuilder().precipitation(Biome.Precipitation.SNOW)
                .biomeCategory(Biome.BiomeCategory.FOREST)
                // worldGen settings
                .generationSettings(builder.build()).temperature(0.7F).downfall(0.8F)
                // biome visual & sensual effects
                .specialEffects(
                        new BiomeSpecialEffects.Builder().waterColor(0xD23D1D).fogColor(0x373D4D).skyColor(0x37E6C9)
                                .waterFogColor(0x93E642).grassColorOverride(0xD7E90F).foliageColorOverride(0xD7E90F)
                                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                // biome mob spawn
                .mobSpawnSettings(getStandardMobSpawnBuilder()
                        .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 5, 10))
                        .build())
                .build();
        
        // build biome
        return result;
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    private static MobSpawnSettings.Builder getStandardMobSpawnBuilder() {
        MobSpawnSettings.Builder builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(builder);
        BiomeDefaultFeatures.endSpawns(builder);
        return builder;
    }
}
