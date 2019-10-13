package cn.mcmod.sakura.world.biome;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.world.gen.WorldGenBamboo;
import cn.mcmod.sakura.world.gen.WorldGenBigSakura;
import cn.mcmod.sakura.world.gen.WorldGenMapleTree;
import cn.mcmod.sakura.world.gen.WorldGenSakuraTree;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeBambooForest extends Biome {
	 protected static final WorldGenAbstractTree SAKURA = new WorldGenSakuraTree(false, 5);
	 protected static final WorldGenAbstractTree SAKURA_BIG = new WorldGenBigSakura(false);
    public BiomeBambooForest(BiomeProperties bambooForest) {
        super(bambooForest);
        this.decorator.treesPerChunk = 30;
        this.decorator.grassPerChunk = 25;
        this.decorator.flowersPerChunk = 4;
    }

    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
    	if (rand.nextInt(160) == 0) {
            return SAKURA_BIG;
        }else if (rand.nextInt(40) == 0) {
            return SAKURA;
        } else if (rand.nextInt(20) == 0) {
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
