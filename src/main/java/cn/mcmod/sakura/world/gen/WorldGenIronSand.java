package cn.mcmod.sakura.world.gen;

import cn.mcmod.sakura.block.BlockLoader;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeBeach;
import net.minecraft.world.biome.BiomeRiver;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenIronSand implements IWorldGenerator {
	private final int block_count;
    public WorldGenIronSand(int blockCount) {
    	block_count=blockCount;
    }

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World worldIn, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		  for (int i = 0; i < block_count; i++) {
	            int rX = (chunkX  * 16) + rand.nextInt(16) + 8;
	            int rY = 48 + rand.nextInt(19);
	            int rZ = (chunkZ  * 16) + rand.nextInt(16) + 8;
	            BlockPos pos = new BlockPos(rX, rY, rZ);
	            IBlockState stateAt = worldIn.getBlockState(pos);
	            if(!stateAt.getBlock().equals(Blocks.SAND)) {
	                continue;
	            }

	            boolean canSpawn = false;
	            for (int yy = 0; yy < 2; yy++) {
	                BlockPos check = pos.offset(EnumFacing.UP, yy);
	                IBlockState bs = worldIn.getBlockState(check);
	                Block block = bs.getBlock();
	                if(worldIn.getBiome(pos) instanceof BiomeBeach|| worldIn.getBiome(pos) instanceof BiomeRiver)
	                if((worldIn.isAirBlock(pos.up())||block instanceof BlockLiquid && bs.getMaterial() == Material.WATER)) {
	                    canSpawn = true;
	                    break;
	                }
	            }
	            if(!canSpawn)
	                continue;
	            worldIn.setBlockState(pos, BlockLoader.IRON_SAND.getDefaultState());
//	            SakuraMain.logger.info(String.format("Iron Sand in: %d %d %d", pos.getX(),pos.getY(),pos.getZ()));
	        }
	}

}