package cn.mcmod.sakura.block;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.gui.SakuraGuiHandler;
import cn.mcmod.sakura.tileentity.TileEntityBarrel;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nullable;

public class BlockBarrel extends BlockContainer implements ITileEntityProvider {

    protected BlockBarrel() {
        super(Material.WOOD);
        this.setHardness(2.5F);
        this.setResistance(8.0F);
        this.setSoundType(SoundType.WOOD);
        this.setCreativeTab(CommonProxy.tab);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }
		ItemStack stack = player.getHeldItem(hand);
		TileEntity tile = world.getTileEntity(pos);
		if (tile instanceof TileEntityBarrel) {
		    IFluidHandlerItem handler = FluidUtil.getFluidHandler(ItemHandlerHelper.copyStackWithSize(stack, 1));
		    if (handler != null) {
		        FluidUtil.interactWithFluidHandler(player, hand, tile.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, side));
		        return true;
		    }
		    player.openGui(SakuraMain.instance, SakuraGuiHandler.ID_BARREL, world, pos.getX(), pos.getY(), pos.getZ());
		    return true;
		}
		return true;
    }


    @Nullable
    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBarrel();
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }


    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        return super.canPlaceBlockAt(worldIn, pos) && this.canPlaceFullBlock(worldIn, pos);
    }

    //Only on top of FullBlock can place
    private boolean canPlaceFullBlock(World worldIn, BlockPos pos) {
        IBlockState downState = worldIn.getBlockState(pos.down());

        return downState.isTopSolid() && downState.getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) == BlockFaceShape.SOLID;
    }
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	   /**
	  * Called after the block is set in the Chunk data, but before the Tile Entity is set
	  */
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
	    this.setDefaultFacing(worldIn, pos, state);
	}
	
	public void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
	{
	    if (!worldIn.isRemote)
	    {
	         IBlockState iblockstate = worldIn.getBlockState(pos.north());
	         IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
	         IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
	         IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
	         EnumFacing enumfacing = state.getValue(FACING);
	
	         if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock())
	         {
	             enumfacing = EnumFacing.SOUTH;
	         }
	         else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock())
	         {
	             enumfacing = EnumFacing.NORTH;
	         }
	         else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock())
	         {
	             enumfacing = EnumFacing.EAST;
	         }
	         else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock())
	         {
	             enumfacing = EnumFacing.WEST;
	         }
	
	         worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
	     }
	 }
	 
	 /**
	  * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
	  * IBlockstate
	  */
	 public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	 {
	     return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	 }
	
	 /**
	  * Called by ItemBlocks after a block is set in the world, to allow post-place logic
	  */
	 public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	 {
	     worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	 }
	 
	 /**
	  * Convert the given metadata into a BlockState for this Block
	  */
	 public IBlockState getStateFromMeta(int meta)
	 {
	     EnumFacing enumfacing = EnumFacing.getFront(meta);
	
	     if (enumfacing.getAxis() == EnumFacing.Axis.Y)
	     {
	         enumfacing = EnumFacing.NORTH;
	     }
	
	     return this.getDefaultState().withProperty(FACING, enumfacing);
	 }
	
	 /**
	  * Convert the BlockState into the correct metadata value
	  */
	 public int getMetaFromState(IBlockState state)
	 {
	     return state.getValue(FACING).getIndex();
	 }
	
	 /**
	  * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
	  * blockstate.
	  */
	 public IBlockState withRotation(IBlockState state, Rotation rot)
	 {
	     return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
	 }
	
	 /**
	  * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
	  * blockstate.
	  */
	 public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	 {
	     return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
	 }
	
	 protected BlockStateContainer createBlockState()
	 {
	     return new BlockStateContainer(this, new IProperty[] {FACING});
	 }

}
