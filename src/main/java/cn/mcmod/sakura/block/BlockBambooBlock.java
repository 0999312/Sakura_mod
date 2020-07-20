package cn.mcmod.sakura.block;

import java.util.Random;

import cn.mcmod.sakura.CommonProxy;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBambooBlock extends BlockRotatedPillar {
    public static final PropertyEnum<EnumAxis> LOG_AXIS = PropertyEnum.<EnumAxis>create("axis", EnumAxis.class);
    private final boolean isSunburnt;
    public BlockBambooBlock(Material material,boolean sunburnt) {
        super(material);
        isSunburnt=sunburnt;
        this.setTickRandomly(true);
        this.setCreativeTab(CommonProxy.tab);
    }

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if(!isSunburnt&&(worldIn.canSeeSky(pos)||worldIn.getBlockState(pos.up()).getBlock() instanceof BlockBambooBlock)&&worldIn.isDaytime()){
				worldIn.setBlockState(pos, (BlockLoader.BAMBOO_BLOCK_SUNBURNT).getDefaultState().withProperty(LOG_AXIS, state.getValue(LOG_AXIS)));
		}
		super.updateTick(worldIn, pos, state, rand);
	}
    
    @Override
    public int getMetaFromState(IBlockState state) {
        switch (state.getValue(LOG_AXIS)) {
            case X:
                return 4;
            case Y:
                return 0;
            case Z:
                return 8;
            case NONE:
            default:
                return 12;
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        switch (meta) {
            case 0:
                return getDefaultState().withProperty(LOG_AXIS, EnumAxis.Y);
            case 4:
                return getDefaultState().withProperty(LOG_AXIS, EnumAxis.X);
            case 8:
                return getDefaultState().withProperty(LOG_AXIS, EnumAxis.Z);
            case 12:
            default:
                return getDefaultState().withProperty(LOG_AXIS, EnumAxis.NONE);
        }
    }

    
    /**
     * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
     * IBlockstate
     */
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getStateFromMeta(meta).withProperty(LOG_AXIS, EnumAxis.fromFacingAxis(facing.getAxis()));
    }

    public BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
    }
    
    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        switch (rot){
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:

                switch (state.getValue(LOG_AXIS)){
                    case X:
                        return state.withProperty(LOG_AXIS, EnumAxis.Z);
                    case Z:
                        return state.withProperty(LOG_AXIS, EnumAxis.X);
                    default:
                        return state;
                }

            default:
                return state;
        }
    }

    public static enum EnumAxis implements IStringSerializable
    {
        X("x"),
        Y("y"),
        Z("z"),
        NONE("none");

        private final String name;

        private EnumAxis(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return this.name;
        }

        public static EnumAxis fromFacingAxis(EnumFacing.Axis axis)
        {
            switch (axis)
            {
                case X:
                    return X;
                case Y:
                    return Y;
                case Z:
                    return Z;
                default:
                    return NONE;
            }
        }

        public String getName()
        {
            return this.name;
        }
    }
}
