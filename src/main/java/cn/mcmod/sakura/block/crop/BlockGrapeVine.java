package cn.mcmod.sakura.block.crop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.IShearable;

public class BlockGrapeVine extends BlockCrops{
	public BlockGrapeVine() {
        this.setHardness(2.0F);
        this.setSoundType(SoundType.WOOD);
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
	}
	@Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return new AxisAlignedBB(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
    }
	@Override
	protected Item getCrop() {
		return Item.getItemFromBlock(BlockLoader.GRAPE_SPLINT_STAND);
	}
	@Override
	protected Item getSeed() {
		return Item.getItemFromBlock(BlockLoader.GRAPE_SPLINT_STAND);
	}

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return this.isMaxAge(state) ? this.getCrop() : this.getSeed();
    }

    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);

        if (!worldIn.isRemote) // Forge: NOP all this.
        {
            int i = this.getAge(state);

            if (i >= this.getMaxAge())
            {
                int j = 3 + fortune;

                for (int k = 0; k < j; ++k)
                {
                    if (worldIn.rand.nextInt(2 * this.getMaxAge()) <= i)
                    {
                        spawnAsEntity(worldIn, pos, new ItemStack(this.getSeed(),1,0));
                    }
                }
            }
        }
    }
    
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(BlockLoader.GRAPE_SPLINT_STAND);
    }

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
			IPlantable plantable) {
        return true;
	}
	
    public void grow(World worldIn, BlockPos pos, IBlockState state)
    {

        int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge();
    	if(i>= 2 && worldIn.getBlockState(pos.up()).getBlock() == BlockLoader.GRAPE_SPLINT_STAND)
    		worldIn.setBlockState(pos.up(), this.withAge(0), 2);
        if(i>= 5 && worldIn.getBlockState(pos.east()).getBlock() == BlockLoader.GRAPE_SPLINT)
    		worldIn.setBlockState(pos.east(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
        if(i>= 5 && worldIn.getBlockState(pos.north()).getBlock() == BlockLoader.GRAPE_SPLINT)
    		worldIn.setBlockState(pos.north(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
        if(i>= 5 && worldIn.getBlockState(pos.west()).getBlock() == BlockLoader.GRAPE_SPLINT)
    		worldIn.setBlockState(pos.west(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
        if(i>= 5 && worldIn.getBlockState(pos.south()).getBlock() == BlockLoader.GRAPE_SPLINT)
    		worldIn.setBlockState(pos.south(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
        if (i > j)
        {
            i = j;
        }

        worldIn.setBlockState(pos, this.withAge(i), 2);
    }
	@Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(worldIn, pos, state, rand);

        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
        {
            int i = this.getAge(state);
        	if(i>= 2 && worldIn.getBlockState(pos.up()).getBlock() == BlockLoader.GRAPE_SPLINT_STAND)
        		worldIn.setBlockState(pos.up(), this.withAge(0), 2);
            if(i>= 5 && worldIn.getBlockState(pos.east()).getBlock() == BlockLoader.GRAPE_SPLINT)
        		worldIn.setBlockState(pos.east(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
            if(i>= 5 && worldIn.getBlockState(pos.north()).getBlock() == BlockLoader.GRAPE_SPLINT)
        		worldIn.setBlockState(pos.north(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
            if(i>= 5 && worldIn.getBlockState(pos.west()).getBlock() == BlockLoader.GRAPE_SPLINT)
        		worldIn.setBlockState(pos.west(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
            if(i>= 5 && worldIn.getBlockState(pos.south()).getBlock() == BlockLoader.GRAPE_SPLINT)
        		worldIn.setBlockState(pos.south(), BlockLoader.GRAPE_LEAVES.withAge(0), 2);
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
