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

public class BlockVanillaCrop extends BlockCrops implements IShearable {
	public BlockVanillaCrop() {
        this.setHardness(2.0F);
        this.setSoundType(SoundType.WOOD);
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return FULL_BLOCK_AABB;
	}
	@Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
	@Override
	protected Item getCrop() {
		return Item.getItemFromBlock(BlockLoader.VANILLA_SPLINT);
	}
	@Override
	protected Item getSeed() {
		return Item.getItemFromBlock(BlockLoader.VANILLA_SPLINT);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(this.isMaxAge(state)){
			if(playerIn.getHeldItem(hand).getItem() instanceof ItemShears){
			List<ItemStack> list = onSheared(playerIn.getHeldItem(hand), worldIn, pos, 0);
			for(ItemStack stackresult:list)
				 spawnAsEntity(worldIn, pos, stackresult);
			worldIn.setBlockState(pos, this.getDefaultState().withProperty(AGE, 3));
			}
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return this.isMaxAge(state) ? this.getCrop() : this.getSeed();
    }

    @Override
    public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        super.getDrops(drops, world, pos, state, 0);
        drops.clear();
    	drops.add(new ItemStack(BlockLoader.VANILLA_SPLINT));
        int age = getAge(state);
        Random rand = world instanceof World ? ((World)world).rand : new Random();

        if (this.isMaxAge(state)) {
            for (int i = 0; i < 3 + fortune; ++i)
            {
                if (rand.nextInt(2 * getMaxAge()) <= age)
                {
                    drops.add(new ItemStack(ItemLoader.MATERIAL,1+fortune,21));
                }
            }
        }
    }
    
    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);

        if (!worldIn.isRemote) // Forge: NOP all this.
        {
        	 int i = getAge(state);
            if (this.isMaxAge(state))
            {
                int j = 3 + fortune;

                for (int k = 0; k < j; ++k)
                {
                    if (worldIn.rand.nextInt(2 * this.getMaxAge()) <= i)
                    {
                        spawnAsEntity(worldIn, pos, new ItemStack(ItemLoader.MATERIAL,1+fortune,21));
                    }
                }
            }
        }
    }
    
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(BlockLoader.VANILLA_SPLINT);
    }
	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		List<ItemStack> list = new ArrayList<ItemStack>();
		if(this.isMaxAge(world.getBlockState(pos)))list.add(new ItemStack(ItemLoader.MATERIAL,1+fortune,21));
		return list;
	}
	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
			IPlantable plantable) {
        return state.getMaterial()==Material.GROUND||state.getMaterial()==Material.GRASS||
        	(state.getBlock() instanceof BlockVanillaCrop&&this.getAge(state)>=2)||(state.getBlock() instanceof BlockVanillaSplint);
	}
	
    public void grow(World worldIn, BlockPos pos, IBlockState state)
    {

        int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge();
    	if(i>= 2 && worldIn.getBlockState(pos.up()).getBlock() == BlockLoader.VANILLA_SPLINT)
    		worldIn.setBlockState(pos.up(), this.withAge(0), 2);
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
            if(i>= 2 && worldIn.getBlockState(pos.up()).getBlock() == BlockLoader.VANILLA_SPLINT)
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
