package cn.mcmod.sakura.world.gen;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.block.BlockPlantBamboo;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class WorldGenBamboo extends WorldGenAbstractTree {
    public WorldGenBamboo(boolean notify) {
        super(notify);
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        int i = 9 + rand.nextInt(9);

        for (int i2 = 0; i2 < i; ++i2) {
            BlockPos blockpos = position.up(i2);
            if ((BlockLoader.BAMBOOSHOOT.canBlockStay(worldIn, blockpos)||
            		worldIn.getBlockState(blockpos.down()).getBlock() instanceof BlockPlantBamboo) && 
            (worldIn.isAirBlock(blockpos) || 
            		worldIn.getBlockState(blockpos).getMaterial() == Material.PLANTS
            		&& !(worldIn.getBlockState(blockpos).getBlock() instanceof BlockLeaves))) {
                worldIn.setBlockState(blockpos, BlockLoader.BAMBOO.getDefaultState(), 2);
            }
        }
        return true;
    }
}
