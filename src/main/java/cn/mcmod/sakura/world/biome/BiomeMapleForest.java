package cn.mcmod.sakura.world.biome;

import cn.mcmod.sakura.block.BlockLoader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeMapleForest extends Biome {

    protected static final WorldGenerator RED_MAPLETREE = new WorldGenTrees(true,5, BlockLoader.MAPLE_LOG.getDefaultState(),BlockLoader.MAPLE_LEAVE_RED.getDefaultState(),false);

    public BiomeMapleForest(BiomeProperties mapleForest) {
        super(mapleForest);
        this.decorator.treesPerChunk = 10;
        this.decorator.grassPerChunk = 2;
    }

    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
        return (WorldGenAbstractTree) RED_MAPLETREE;

    }
}
