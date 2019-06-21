package cn.mcmod.sakura.world.biome;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.entity.EntityDeer;
import cn.mcmod.sakura.world.gen.WorldGenMapleTree;
import cn.mcmod.sakura.world.gen.WorldGenMapleTreeGreen;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeMapleForest extends Biome {
    protected static final WorldGenerator RED_MAPLETREE = new WorldGenMapleTree(false,5, BlockLoader.MAPLE_LOG.getDefaultState(),BlockLoader.MAPLE_LEAVE_RED.getDefaultState(),false);
    protected static final WorldGenerator RED_MAPLETREE_SAP = new WorldGenMapleTree(false,5, BlockLoader.MAPLE_LOG.getDefaultState(),BlockLoader.MAPLE_LEAVE_RED.getDefaultState(),true);
    protected static final WorldGenerator YELLOW_MAPLETREE = new WorldGenMapleTree(false,5, BlockLoader.MAPLE_LOG.getDefaultState(),BlockLoader.MAPLE_LEAVE_YELLOW.getDefaultState(),false);
    protected static final WorldGenerator YELLOW_MAPLETREE_SAP = new WorldGenMapleTree(false,5, BlockLoader.MAPLE_LOG.getDefaultState(),BlockLoader.MAPLE_LEAVE_YELLOW.getDefaultState(),true);
    protected static final WorldGenerator ORANGE_MAPLETREE = new WorldGenMapleTree(false,5, BlockLoader.MAPLE_LOG.getDefaultState(),BlockLoader.MAPLE_LEAVE_ORANGE.getDefaultState(),false);
    protected static final WorldGenerator ORANGE_MAPLETREE_SAP = new WorldGenMapleTree(false,5, BlockLoader.MAPLE_LOG.getDefaultState(),BlockLoader.MAPLE_LEAVE_ORANGE.getDefaultState(),true);
    protected static final WorldGenerator GREEN_MAPLETREE = new WorldGenMapleTreeGreen(false,5, BlockLoader.MAPLE_LOG.getDefaultState(),BlockLoader.MAPLE_LEAVE_GREEN.getDefaultState(),false);
    protected static final WorldGenerator GREEN_MAPLETREE_SAP = new WorldGenMapleTreeGreen(false,5, BlockLoader.MAPLE_LOG.getDefaultState(),BlockLoader.MAPLE_LEAVE_GREEN.getDefaultState(),true);
    
    public BiomeMapleForest(BiomeProperties mapleForest) {
        super(mapleForest);
        this.decorator.treesPerChunk = 10;
        this.decorator.grassPerChunk = 2;

        this.spawnableCreatureList.add(new SpawnListEntry(EntityDeer.class,10,3,4));
    }

    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
    	switch (rand.nextInt(8)) {
		case 0:
			return (WorldGenAbstractTree)RED_MAPLETREE_SAP;
		case 1:
			return (WorldGenAbstractTree)RED_MAPLETREE;	
		case 2:
			return (WorldGenAbstractTree)YELLOW_MAPLETREE_SAP;
		case 3:
			return (WorldGenAbstractTree)YELLOW_MAPLETREE;	
		case 4:
			return (WorldGenAbstractTree)ORANGE_MAPLETREE_SAP;
		case 5:
			return (WorldGenAbstractTree)ORANGE_MAPLETREE;	
		case 6:
			return (WorldGenAbstractTree)GREEN_MAPLETREE_SAP;
		case 7:
			return (WorldGenAbstractTree)GREEN_MAPLETREE;	

		default:
			return (WorldGenAbstractTree) RED_MAPLETREE;
		}
    }
}
