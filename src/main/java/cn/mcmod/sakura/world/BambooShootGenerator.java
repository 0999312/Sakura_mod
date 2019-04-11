package cn.mcmod.sakura.world;

import cn.mcmod.sakura.block.BlockLoader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class BambooShootGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider instanceof WorldProviderSurface) {
            int x = chunkX * 16 + random.nextInt(16);
            int z = chunkZ * 16 + random.nextInt(16);

            int y = world.getHeight(x, z);

            BlockPos pos = new BlockPos(x, y, z);

            if (BiomeDictionary.hasType(world.getBiome(pos), BiomeDictionary.Type.PLAINS )&& random.nextFloat() < 0.002) {
                this.generateBamboo(world, random, pos);
            }
        }
    }


    private void generateBamboo(World world, Random random, BlockPos pos) {
        if (world.provider instanceof WorldProviderSurface) {

            for (int i = 0; i < 4; ++i)
            {
                if (world.isAirBlock(pos.up()) && BlockLoader.BAMBOOSHOOT.canBlockStay(world, pos))
                {
                    world.setBlockState(pos, BlockLoader.BAMBOOSHOOT.getDefaultState(), 2);
                }
            }
        }
    }
}