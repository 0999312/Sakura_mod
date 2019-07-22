package cn.mcmod.sakura.world.gen;

import cn.mcmod.sakura.world.biome.SakuraBiomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class SakuraDiamondOreGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider instanceof WorldProviderSurface) {

            this.generateOre(world, random, chunkX << 4, chunkZ << 4);
        }
    }

    private void generateOre(World world, Random random, int x, int z) {
        if (world.getBiome(new BlockPos(x, 0, z)) == SakuraBiomes.BAMBOOFOREST || world.getBiome(new BlockPos(x, 0, z)) == SakuraBiomes.MAPLEFOREST) {
            //1チャンクで生成したい回数だけ繰り返す。
            if (world.provider instanceof WorldProviderSurface) {
                for (int i = 0; i < 2; i++) {
                    int genX = x + random.nextInt(16);
                    int genY = 10 + random.nextInt(24);
                    int genZ = z + random.nextInt(16);
                    new WorldGenMinable(
                            Blocks.DIAMOND_ORE.getDefaultState(), 3 + random.nextInt(5)).generate(world, random, new BlockPos(genX, genY, genZ));
                }
            }
        }
    }
}