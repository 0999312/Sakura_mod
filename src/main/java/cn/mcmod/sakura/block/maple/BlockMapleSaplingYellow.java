package cn.mcmod.sakura.block.maple;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.world.gen.WorldGenMapleTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.EnumPlantType;

import java.util.Random;

public class BlockMapleSaplingYellow extends BlockBush implements IGrowable {

    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

    public BlockMapleSaplingYellow() {
        super();
        setCreativeTab(CommonProxy.tab);
        this.setSoundType(SoundType.PLANT);
    }

    @Override
    public void grow(World world, Random rand, BlockPos pos, IBlockState state) {
        WorldGenerator treeGenerator = (WorldGenerator)(rand.nextInt(8) == 0 ? new WorldGenMapleTree(true,5, BlockLoader.MAPLE_LOG.getDefaultState(),BlockLoader.MAPLE_LEAVE_YELLOW.getDefaultState(),true) : new WorldGenMapleTree(true,5, BlockLoader.MAPLE_LOG.getDefaultState(),BlockLoader.MAPLE_LEAVE_YELLOW.getDefaultState(),false));

        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);

        if (!treeGenerator.generate(world, rand, pos)) {

            world.setBlockState(pos, state, 4);

        }
    }
    @Override
    protected boolean canSustainBush(IBlockState state) {

        Block block = state.getBlock();
        return block == Blocks.GRASS || block == Blocks.DIRT || block.getMaterial(state) == Material.GROUND;
    }

    @Override
    public boolean canBlockStay(World world, BlockPos pos, IBlockState state) {
        BlockPos down = pos.down();

        IBlockState soil = world.getBlockState(down);

        return soil.getBlock().canSustainPlant(soil, world, down, EnumFacing.UP, this);
    }


    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Plains;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return SAPLING_AABB;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 0 && rand.nextInt(7) == 0) {
                this.grow(worldIn, rand, pos, state);
            }
        }
    }



    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return rand.nextFloat() < 0.5;
    }
}