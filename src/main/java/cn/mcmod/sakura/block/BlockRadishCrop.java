package cn.mcmod.sakura.block;

import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockRadishCrop extends BlockCrops {
    private static final AxisAlignedBB[] CABBAGE_AABB = new AxisAlignedBB[] {
    		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D),
    		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D),
    		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.09375D, 1.0D),
    		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1875D, 1.0D),
    		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.28125D, 1.0D),
    		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D),
    		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.46875D, 1.0D),
    		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.46875D, 1.0D)};
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return CABBAGE_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    }
	@Override
	protected Item getCrop() {
		return ItemLoader.RADISH;
	}
	@Override
	protected Item getSeed() {
		return ItemLoader.RADISH_SEEDS;
	}
}
