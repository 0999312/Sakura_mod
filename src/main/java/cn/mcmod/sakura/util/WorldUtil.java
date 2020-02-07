package cn.mcmod.sakura.util;

import javax.annotation.Nullable;

import cn.mcmod.sakura.block.BlockCampfire;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockMagma;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.IFluidBlock;

public class WorldUtil {
//    public static boolean buildPit(World par1World, BlockPos pos, Block block) {
//    	
//		return false;
//	}
    public static int getHeatStrength(World par1World, BlockPos pos) {
        for (int i = 1; i < 5; i++) {
            Block block = par1World.getBlockState(pos.down(i)).getBlock();
            if (block instanceof BlockCampfire||block instanceof BlockMagma||block instanceof BlockFire || block == Blocks.LAVA || block == Blocks.FLOWING_LAVA) {
                return i <= 3 ? 2 : 1;
            }
        }
        return 0;
    }
    public static boolean isItemFuel(ItemStack stack){
        return TileEntityFurnace.getItemBurnTime(stack) > 0;
    }
    
    @Nullable
    public static BlockPos.MutableBlockPos findGround(World world, BlockPos pos, boolean ignoreLeaves, boolean stopOnFluid, boolean useWorldHeight){
        return findGround(world, pos, ignoreLeaves, stopOnFluid, useWorldHeight, 8);
    }

    @Nullable
    public static BlockPos.MutableBlockPos findGround(World world, BlockPos pos, boolean ignoreLeaves, boolean stopOnFluid, boolean useWorldHeight, int offset) {
        if (pos.getY() <= 4) {
            return null;
        }
        if (useWorldHeight)
            pos = world.getHeight(pos);

        BlockPos.MutableBlockPos position = new BlockPos.MutableBlockPos(pos);
        if (position.getY() > 0){
            int yOrigin = position.getY();
            do {
                IBlockState state = world.getBlockState(position);
                if (stopOnFluid && (state.getBlock() instanceof BlockLiquid || state.getBlock() instanceof IFluidBlock))
                   return position.move(EnumFacing.UP);

                if (!state.getBlock().isReplaceable(world, position) && (!ignoreLeaves || !state.getBlock().isLeaves(state, world, position)))
                    return position.move(EnumFacing.UP);
            }
            while (yOrigin - position.getY() < 40 && position.move(EnumFacing.DOWN).getY() > 0);
        }
        return null;
    }

}
