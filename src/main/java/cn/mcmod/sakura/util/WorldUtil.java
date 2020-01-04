package cn.mcmod.sakura.util;

import cn.mcmod.sakura.block.BlockCampfire;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockMagma;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldUtil {
    
    public static int getHeatStrength(World par1World, BlockPos pos)
    {
        for (int i = 1; i < 5; i++)
        {
            Block block = par1World.getBlockState(pos.down(i)).getBlock();
            if (block instanceof BlockCampfire||block instanceof BlockMagma||block instanceof BlockFire || block == Blocks.LAVA || block == Blocks.FLOWING_LAVA)
            {
                return i <= 3 ? 2 : 1;
            }
        }
        return 0;
    }
    
}
