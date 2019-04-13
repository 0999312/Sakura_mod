package cn.mcmod.sakura.world.biome;

import cn.mcmod.sakura.world.gen.WorldGenBamboo;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeBambooForest extends Biome {
    public BiomeBambooForest(BiomeProperties bambooForest) {
        super(bambooForest);

        this.decorator.treesPerChunk = 30;
        this.decorator.grassPerChunk = 25;
        this.decorator.flowersPerChunk = 4;
    }

    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        if (rand.nextInt(20) == 0) {
            return BIG_TREE_FEATURE;
        } else {
            return new WorldGenBamboo(false);
        }
    }

    public WorldGenerator getRandomWorldGenForGrass(Random rand)
    {
        return rand.nextInt(4) == 0 ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
}
