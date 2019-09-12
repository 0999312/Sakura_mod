package cn.mcmod.sakura.block;

import cn.mcmod.sakura.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockBambooShoot extends Block implements IPlantable, IGrowable {
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 8);
    protected static final AxisAlignedBB BAMBOO_AABB = new AxisAlignedBB(0.3D, 0.0D, 0.3D, 0.7D, 0.4D, 0.7D);

    public BlockBambooShoot() {
        super(Material.PLANTS);
        this.setTickRandomly(true);
        this.setCreativeTab(CommonProxy.tab);
        this.setResistance(2.0F);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isAreaLoaded(pos, 1))
            return; // Forge: prevent growing cactus from loading unloaded chunks with block update
        BlockPos blockpos = pos.up();

        if (worldIn.isAirBlock(blockpos)) {
        	if(worldIn.checkLightFor(EnumSkyBlock.BLOCK, pos)){
            int j = state.getValue(AGE).intValue();

            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, blockpos, state, true)) {
                if (j == 6) {
                    if(rand.nextInt() ==0){
                        worldIn.setBlockState(blockpos.up(2), BlockLoader.BAMBOO.getDefaultState());
                    }
                    worldIn.setBlockState(blockpos.up(), BlockLoader.BAMBOO.getDefaultState());
                    worldIn.setBlockState(blockpos, BlockLoader.BAMBOO.getDefaultState());
                    worldIn.setBlockState(pos, BlockLoader.BAMBOO.getDefaultState());
                } else {
                    worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(j + 1)), 4);
                }
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
            }
        	}
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BAMBOO_AABB;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState state = worldIn.getBlockState(pos.down());
        if (this.canBlockStay(worldIn, pos) && state.getBlock() != BlockLoader.BAMBOO ) {
            return super.canPlaceBlockAt(worldIn, pos);
        } else {
            return false;
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        if (!this.canBlockStay(worldIn, pos)) {
            worldIn.destroyBlock(pos, true);
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos) {
        IBlockState state = worldIn.getBlockState(pos.down());
        return state.getBlock().canSustainPlant(state, worldIn, pos.down(), EnumFacing.UP, this) && !worldIn.getBlockState(pos.up()).getMaterial().isLiquid();
    }

    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
        if (!worldIn.isRemote && stack.getItem() instanceof ItemHoe) {
            super.harvestBlock(worldIn,player,pos,state,te,stack);
        }
    }


    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }


    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Plains;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return getDefaultState();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, AGE);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(AGE).intValue();
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        if(rand.nextInt() ==0){
            worldIn.setBlockState(pos.up(3), BlockLoader.BAMBOO.getDefaultState());
        }
        worldIn.setBlockState(pos.up(), BlockLoader.BAMBOO.getDefaultState());
        worldIn.setBlockState(pos.up(2), BlockLoader.BAMBOO.getDefaultState());
        worldIn.setBlockState(pos, BlockLoader.BAMBOO.getDefaultState());
    }
}
