package cn.mcmod.sakura.block.crop;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockGrapeLeaves extends BlockCrops implements IShearable {
	public BlockGrapeLeaves() {
        this.setHardness(2.0F);
        this.setSoundType(SoundType.WOOD);
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);
	}
	@Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);
    }
	@Override
	protected Item getCrop() {
		return Item.getItemFromBlock(BlockLoader.GRAPE_SPLINT);
	}
	@Override
	protected Item getSeed() {
		return Item.getItemFromBlock(BlockLoader.GRAPE_SPLINT);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		int i = this.getAge(state);
		if(i>=7){
			if(playerIn.getHeldItem(hand).getItem() instanceof ItemShears){
			List<ItemStack> list = onSheared(playerIn.getHeldItem(hand), worldIn, pos, 0);
			for(ItemStack stackresult:list)
                spawnAsEntity(worldIn, pos.down(), stackresult);
			worldIn.setBlockState(pos, this.getDefaultState().withProperty(AGE, 2));
			}
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return this.getSeed();
    }

    @Override
    public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        super.getDrops(drops, world, pos, state, 0);
        drops.clear();
    	drops.add(new ItemStack(BlockLoader.GRAPE_SPLINT));
        int age = getAge(state);
        Random rand = world instanceof World ? ((World)world).rand : new Random();

        if (age >= getMaxAge())
        {
            int k = 3 + fortune;

            for (int i = 0; i < 3 + fortune; ++i)
            {
                if (rand.nextInt(2 * getMaxAge()) <= age)
                {
                    drops.add(new ItemStack(ItemLoader.MATERIAL,1+fortune,23));
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
            int i = this.getAge(state);

            if (i >= this.getMaxAge())
            {
                int j = 3 + fortune;

                for (int k = 0; k < j; ++k)
                {
                    if (worldIn.rand.nextInt(2 * this.getMaxAge()) <= i)
                    {
                        spawnAsEntity(worldIn, pos, new ItemStack(this.getSeed(),1,21));
                    }
                }
            }
        }
    }
    
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(BlockLoader.GRAPE_SPLINT);
    }
	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		int i = this.getAge(world.getBlockState(pos));
		List<ItemStack> list = new ArrayList<ItemStack>();
		list.add(new ItemStack(ItemLoader.FOODSET,1+fortune,0));
		return list;
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
        if(i>= 2 && worldIn.getBlockState(pos.east()).getBlock() == BlockLoader.GRAPE_SPLINT)
    		worldIn.setBlockState(pos.east(), this.withAge(0), 2);
        if(i>= 2 && worldIn.getBlockState(pos.north()).getBlock() == BlockLoader.GRAPE_SPLINT)
    		worldIn.setBlockState(pos.north(), this.withAge(0), 2);
        if(i>= 2 && worldIn.getBlockState(pos.west()).getBlock() == BlockLoader.GRAPE_SPLINT)
    		worldIn.setBlockState(pos.west(), this.withAge(0), 2);
        if(i>= 2 && worldIn.getBlockState(pos.south()).getBlock() == BlockLoader.GRAPE_SPLINT)
    		worldIn.setBlockState(pos.south(), this.withAge(0), 2);
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
            if(i>= 2 && worldIn.getBlockState(pos.east()).getBlock() == BlockLoader.GRAPE_SPLINT)
        		worldIn.setBlockState(pos.east(), this.withAge(0), 2);
            if(i>= 2 && worldIn.getBlockState(pos.north()).getBlock() == BlockLoader.GRAPE_SPLINT)
        		worldIn.setBlockState(pos.north(), this.withAge(0), 2);
            if(i>= 2 && worldIn.getBlockState(pos.west()).getBlock() == BlockLoader.GRAPE_SPLINT)
        		worldIn.setBlockState(pos.west(), this.withAge(0), 2);
            if(i>= 2 && worldIn.getBlockState(pos.south()).getBlock() == BlockLoader.GRAPE_SPLINT)
        		worldIn.setBlockState(pos.south(), this.withAge(0), 2);
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
	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
        {
            IBlockState n = worldIn.getBlockState(pos.north());
            IBlockState s = worldIn.getBlockState(pos.south());
            IBlockState w = worldIn.getBlockState(pos.west());
            IBlockState e = worldIn.getBlockState(pos.east());
            return 
            n.getBlock().canSustainPlant(n, worldIn, pos.north(), net.minecraft.util.EnumFacing.SOUTH, this)||
            s.getBlock().canSustainPlant(s, worldIn, pos.south(), net.minecraft.util.EnumFacing.NORTH, this)||
            w.getBlock().canSustainPlant(w, worldIn, pos.west(), net.minecraft.util.EnumFacing.EAST, this)||
            e.getBlock().canSustainPlant(e, worldIn, pos.east(), net.minecraft.util.EnumFacing.WEST, this);
        }
        return false;
	}

}
