package cn.mcmod.sakura.world.gen;

import cn.mcmod.sakura.SakuraConfig;
import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod_mmf.mmlib.util.WorldUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenBambooShot implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,IChunkProvider chunkProvider) {
	    int x = chunkX * 16;
	    int z = chunkZ * 16;
	    
	    Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
	    if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.DEAD)
	    		||BiomeDictionary.hasType(biome, BiomeDictionary.Type.SANDY)) {
	      return;
	    }
	    
        if (random.nextFloat() < SakuraConfig.bambooshot_weight / 4000.0F)
	    {
	      int posX = x+ world.rand.nextInt(16) + 8;
	      int posZ = z+ world.rand.nextInt(16) + 8;
	      BlockPos newPos = WorldUtil.getInstance().findGround(world, new BlockPos(posX, 0, posZ), true, true, true);
	      if ((newPos != null) && (BlockLoader.BAMBOOSHOOT.canBlockStay(world, newPos))) {
	        world.setBlockState(newPos, BlockLoader.BAMBOOSHOOT.getDefaultState(), 2);
	      }
	    }
	}
	

}
