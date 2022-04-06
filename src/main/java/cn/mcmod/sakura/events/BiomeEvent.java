package cn.mcmod.sakura.events;

import cn.mcmod.sakura.SakuraConfig;
import cn.mcmod.sakura.level.WorldGenerationRegistry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class BiomeEvent {

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        setVegetalFeature(event, WorldGenerationRegistry.PATCH_BAMBOOSHOOT, SakuraConfig.GENERATE_BAMBOOSHOOT.get(),
                0.4F, 1.0F);
    }

    public static void setVegetalFeature(BiomeLoadingEvent event, PlacedFeature feature, boolean canGen, float low,
            float high) {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();
        Biome.ClimateSettings climate = event.getClimate();
        if (climate.temperature > low && climate.temperature <= high) {
            if (canGen) {
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, feature);
            }
        }
    }
}
