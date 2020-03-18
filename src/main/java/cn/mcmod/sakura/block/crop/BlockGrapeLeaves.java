package cn.mcmod.sakura.block.crop;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod_mmf.mmlib.block.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockGrapeLeaves extends BlockBase implements IPlantable, IGrowable, IShearable {
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);

	public BlockGrapeLeaves() {
		super(Material.WOOD);
		this.setDefaultState(this.blockState.getBaseState().withProperty(this.getAgeProperty(), Integer.valueOf(0)));
		this.setTickRandomly(true);
		this.setCreativeTab((CreativeTabs) null);
		this.setHardness(2.0F);
		this.setSoundType(SoundType.WOOD);
	}

	protected PropertyInteger getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return 7;
	}

	protected int getAge(IBlockState state) {
		return state.getValue(this.getAgeProperty()).intValue();
	}

	public IBlockState withAge(int age) {
		return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age));
	}

	public boolean isMaxAge(IBlockState state) {
		return state.getValue(this.getAgeProperty()).intValue() >= this.getMaxAge();
	}

	/**
	 * Whether this IGrowable can grow
	 */
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return !this.isMaxAge(state);
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}

	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		this.grow(worldIn, pos, state);
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state) {
		return this.getAge(state);
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { AGE });
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
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
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(worldIn.isRemote){
			return true;
		}
		int i = this.getAge(state);
		if(i>=6){
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
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(BlockLoader.GRAPE_SPLINT);
    }

    @Override
    public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune){
        drops.clear();
        int age = getAge(state);
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        drops.add(new ItemStack(BlockLoader.GRAPE_SPLINT));
        if (age >= getMaxAge()) {
            for (int i = 0; i < 3 + fortune; ++i) {
                if (rand.nextInt(2 * getMaxAge()) <= age)
                    drops.add(new ItemStack(ItemLoader.MATERIAL,1,23));
            }
        }
    }
    
    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune){
        if (!worldIn.isRemote) {
        	spawnAsEntity(worldIn, pos, new ItemStack(BlockLoader.GRAPE_SPLINT));
            int i = this.getAge(state);
            if (i >= this.getMaxAge()) {
                int j = 3 + fortune;
                for (int k = 0; k < j; ++k){
                    if (worldIn.rand.nextInt(2 * this.getMaxAge()) <= i)
                        spawnAsEntity(worldIn, pos, new ItemStack(ItemLoader.MATERIAL,1,23));
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
		if(i==6){
			list.clear();
			list.add(new ItemStack(ItemLoader.FOODSET,1+fortune,120));
		}else 
		if(i==7){
			list.clear();
			list.add(new ItemStack(ItemLoader.FOODSET,1+fortune,0));
		}
		return list;
	}

	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
			IPlantable plantable) {
        return true;
	}
	
    public void grow(World worldIn, BlockPos pos, IBlockState state) {
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
            i = j;
        worldIn.setBlockState(pos, this.withAge(i), 2);
    }
	@Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
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
            if (i < this.getMaxAge()){
                float f = getGrowthChance(this, worldIn, pos);
                if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0)){
                    worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                }
            }
        }
    }

	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        if (state.getBlock() == this) {
            IBlockState n = worldIn.getBlockState(pos.north());
            IBlockState s = worldIn.getBlockState(pos.south());
            IBlockState w = worldIn.getBlockState(pos.west());
            IBlockState e = worldIn.getBlockState(pos.east());
            return 
            (n.getBlock() instanceof BlockGrapeLeaves||n.getBlock() instanceof BlockGrapeSplint||n.getBlock() instanceof BlockGrapeVine)||
            (s.getBlock() instanceof BlockGrapeLeaves||s.getBlock() instanceof BlockGrapeSplint||s.getBlock() instanceof BlockGrapeVine)||
            (w.getBlock() instanceof BlockGrapeLeaves||w.getBlock() instanceof BlockGrapeSplint||w.getBlock() instanceof BlockGrapeVine)||
            (e.getBlock() instanceof BlockGrapeLeaves||e.getBlock() instanceof BlockGrapeSplint||e.getBlock() instanceof BlockGrapeVine);
        }
        return false;
	}
	protected int getBonemealAgeIncrease(World worldIn) {
		return MathHelper.getInt(worldIn.rand, 2, 5);
	}

	protected static float getGrowthChance(Block blockIn, World worldIn, BlockPos pos) {
		float f = 1.0F;
		BlockPos blockpos = pos.down();

		for (int i = -1; i <= 1; ++i) {
			for (int j = -1; j <= 1; ++j) {
				float f1 = 0.0F;
				IBlockState iblockstate = worldIn.getBlockState(blockpos.add(i, 0, j));

				if (iblockstate.getBlock().canSustainPlant(iblockstate, worldIn, blockpos.add(i, 0, j),
						net.minecraft.util.EnumFacing.UP, (net.minecraftforge.common.IPlantable) blockIn)) {
					f1 = 1.0F;

					if (iblockstate.getBlock().isFertile(worldIn, blockpos.add(i, 0, j))) {
						f1 = 3.0F;
					}
				}

				if (i != 0 || j != 0) {
					f1 /= 4.0F;
				}

				f += f1;
			}
		}

		BlockPos blockpos1 = pos.north();
		BlockPos blockpos2 = pos.south();
		BlockPos blockpos3 = pos.west();
		BlockPos blockpos4 = pos.east();
		boolean flag = blockIn == worldIn.getBlockState(blockpos3).getBlock()
				|| blockIn == worldIn.getBlockState(blockpos4).getBlock();
		boolean flag1 = blockIn == worldIn.getBlockState(blockpos1).getBlock()
				|| blockIn == worldIn.getBlockState(blockpos2).getBlock();

		if (flag && flag1) {
			f /= 2.0F;
		} else {
			boolean flag2 = blockIn == worldIn.getBlockState(blockpos3.north()).getBlock()
					|| blockIn == worldIn.getBlockState(blockpos4.north()).getBlock()
					|| blockIn == worldIn.getBlockState(blockpos4.south()).getBlock()
					|| blockIn == worldIn.getBlockState(blockpos3.south()).getBlock();

			if (flag2) {
				f /= 2.0F;
			}
		}

		return f;
	}
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Plains;
	}

    @Override
    public IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return getDefaultState();
        return state;
    }
}
