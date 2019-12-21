package cn.mcmod.sakura.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockKawara extends BlockFacing
{
  public static final PropertyEnum<EnumShape> SHAPE = PropertyEnum.create("shape", EnumShape.class);
  
  public BlockKawara()
  {
    super(Material.ROCK,false);
    setDefaultState(this.blockState.getBaseState().withProperty(SHAPE, EnumShape.STRAIGHT));
  }
  
  /**
   * Called by ItemBlocks after a block is set in the world, to allow post-place logic
   */
  public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
  {
      worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(SHAPE, EnumShape.STRAIGHT), 2);
  }
  
  public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
  {
    IBlockState iblockstate = getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(SHAPE, EnumShape.STRAIGHT);
    return iblockstate;
  }
  
  protected BlockStateContainer createBlockState()
  {
    return new BlockStateContainer(this, new IProperty[] { FACING, SHAPE });
  }
  
  public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
  {
    return state.withProperty(SHAPE, getStairsShape(state, worldIn, pos));
  }
  
  private static EnumShape getStairsShape(IBlockState p_185706_0_, IBlockAccess p_185706_1_, BlockPos p_185706_2_)
  {
    EnumFacing enumfacing = p_185706_0_.getValue(FACING);
    IBlockState iblockstate = p_185706_1_.getBlockState(p_185706_2_.offset(enumfacing.getOpposite()));
    if (isBlockStairs(iblockstate))
    {
      EnumFacing enumfacing1 = iblockstate.getValue(FACING);
      if (enumfacing1.getAxis() != p_185706_0_.getValue(FACING).getAxis())
      {
        if (enumfacing1 == enumfacing.rotateYCCW()) {
          return EnumShape.OUTER_LEFT;
        }
        return EnumShape.OUTER_RIGHT;
      }
    }
    IBlockState iblockstate1 = p_185706_1_.getBlockState(p_185706_2_.offset(enumfacing));
    if (isBlockStairs(iblockstate1))
    {
      EnumFacing enumfacing2 = iblockstate1.getValue(FACING);
      if (enumfacing2.getAxis() != p_185706_0_.getValue(FACING).getAxis())
      {
        if (enumfacing2 == enumfacing.rotateYCCW()) {
          return EnumShape.INNER_LEFT;
        }
        return EnumShape.INNER_RIGHT;
      }
    }
    return EnumShape.STRAIGHT;
  }
  
  public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
  {
    return face == EnumFacing.DOWN ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
  }
  
  public static boolean isBlockStairs(IBlockState state)
  {
    return state.getBlock() instanceof BlockKawara;
  }
  
  public static enum EnumShape
    implements IStringSerializable
  {
    STRAIGHT("straight"),  INNER_LEFT("inner_left"),  INNER_RIGHT("inner_right"),  OUTER_LEFT("outer_left"),  OUTER_RIGHT("outer_right");
    
    private final String name;
    
    private EnumShape(String name)
    {
      this.name = name;
    }
    
    public String toString()
    {
      return this.name;
    }
    
    public String getName()
    {
      return this.name;
    }
  }
 
}
