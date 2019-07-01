package cn.mcmod.sakura.block.crop;

import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class BlockHighCrop extends BlockCrops {
	public BlockHighCrop() {
	}

	@Override
    protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == Blocks.FARMLAND||state.getBlock() instanceof BlockHighCrop;
    }
	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
			IPlantable plantable) {
        return state.getBlock() == Blocks.FARMLAND||
        	(this.getAge(state)>=4&&state.getBlock() instanceof BlockHighCrop 
        		&&world.getBlockState(pos.down()).getBlock() == Blocks.FARMLAND);
	}
	
    public void grow(World worldIn, BlockPos pos, IBlockState state)
    {

        int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge();
    	if(i>= 4 && worldIn.getBlockState(pos.down()).getBlock() == Blocks.FARMLAND 
    			&& worldIn.isAirBlock(pos.up()))
    		worldIn.setBlockState(pos.up(), this.withAge(0), 2);
        if (i > j)
        {
            i = j;
        }

        worldIn.setBlockState(pos, this.withAge(i), 2);
    }
	
    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
    	IBlockState soil = worldIn.getBlockState(pos.down());
    	return super.canPlaceBlockAt(worldIn, pos)&&soil.getBlock() == Blocks.FARMLAND;
    }
    
	@Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(worldIn, pos, state, rand);

        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
        {
            int i = this.getAge(state);
            if (i >= 4 && worldIn.getBlockState(pos.down()).getBlock() == Blocks.FARMLAND &&worldIn.isAirBlock(pos.up()))
    	    	  worldIn.setBlockState(pos.up(), this.withAge(0), 2);
            if (i < this.getMaxAge())
            {
            	
                float f = getGrowthChance(this, worldIn, pos);

                if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0))
                {
                    worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                }
            }
        }
    }
	
	
}
