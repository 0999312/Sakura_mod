package cn.mcmod.sakura.world.gen;

import cn.mcmod.sakura.SakuraConfig;
import cn.mcmod.sakura.block.BlockLoader;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.IWorldGenerator;

import javax.annotation.Nullable;
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
	      BlockPos newPos = findGround(world, new BlockPos(posX, 0, posZ), true, true, true);
	      if ((newPos != null) && (BlockLoader.BAMBOOSHOOT.canBlockStay(world, newPos))) {
	        world.setBlockState(newPos, BlockLoader.BAMBOOSHOOT.getDefaultState(), 2);
	      }
	    }
	}
	

    @Nullable
    public static BlockPos.MutableBlockPos findGround(World world, BlockPos pos, boolean ignoreLeaves, boolean stopOnFluid, boolean useWorldHeight)
    {
        return findGround(world, pos, ignoreLeaves, stopOnFluid, useWorldHeight, 8);
    }

    @Nullable
    public static BlockPos.MutableBlockPos findGround(World world, BlockPos pos, boolean ignoreLeaves, boolean stopOnFluid, boolean useWorldHeight, int offset)
    {
        if (useWorldHeight)
        {
            pos = world.getHeight(pos);
        }

        BlockPos.MutableBlockPos position = new BlockPos.MutableBlockPos(pos);
        if (position.getY() > 0){
            int yOrigin = position.getY();
            do {
                IBlockState state = world.getBlockState(position);
                if (stopOnFluid && (state.getBlock() instanceof BlockLiquid || state.getBlock() instanceof IFluidBlock))
                {
                   return position.move(EnumFacing.UP);
                }

                if (!state.getBlock().isReplaceable(world, position) && (!ignoreLeaves || !state.getBlock().isLeaves(state, world, position)))
                {
                    return position.move(EnumFacing.UP);
                }
            }
            while (yOrigin - position.getY() < 40 && position.move(EnumFacing.DOWN).getY() > 0);
        }
        return null;
    }

}
