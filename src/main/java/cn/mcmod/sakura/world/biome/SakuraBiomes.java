package cn.mcmod.sakura.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.IForgeRegistry;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

public class SakuraBiomes {
    public static Biome BAMBOOFOREST = new BiomeBambooForest(new Biome.BiomeProperties("BambooForest").setTemperature(0.95F).setRainfall(0.9F));

    public static void register(IForgeRegistry<Biome> registry) {
        registry.register(BAMBOOFOREST.setRegistryName("bamboo_forest"));

        BiomeManager.addBiome(BiomeManager.BiomeType.WARM,new BiomeManager.BiomeEntry(BAMBOOFOREST, 10));

        BiomeDictionary.addTypes(BAMBOOFOREST, HOT, WET, DENSE, JUNGLE);
    }
}
