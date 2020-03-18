package cn.mcmod.sakura.block.door;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.tileentity.TileEntityShoji;
import cn.mcmod_mmf.mmlib.util.RecipesUtil;

public class BlockShoji extends Block implements ITileEntityProvider {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final PropertyBool OPEN = PropertyBool.create("open");
    public static final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(0.4375D, 0.0D, 0D, 0.5625D, 2D, 1D);
    public static final AxisAlignedBB BLOCK_AABB_ROTATE = new AxisAlignedBB(0D, 0.0D, 0.4375D, 1D, 2D, 0.5625D);
    public static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0D, 0.0D, 0.4375D, 0.2D, 2D, 0.5625D);
    public static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.8D, 0.0D, 0.4375D, 1D, 2D, 0.5625D);
    public static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.4375D, 0.0D, 0.8D, 0.5625D, 2D, 1D);
    public static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.4375D, 0.0D, 0D, 0.5625D, 2D, 0.2D);

    public BlockShoji() {
        super(Material.WOOD);
        setHardness(0.5f);
        setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(OPEN, false));
        setSoundType(SoundType.WOOD);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        state = state.cycleProperty(OPEN);
        worldIn.setBlockState(pos, state, 10);
        worldIn.markBlockRangeForRenderUpdate(pos, pos);
        worldIn.playEvent(playerIn, state.getValue(OPEN) ? 1006 : 1012, pos, 0);
        TileEntityShoji te = (TileEntityShoji) worldIn.getTileEntity(pos);
        if (te != null) {
            te.setOpen(!te.isOpen());
            te.setAnimation(10);
        }
        return true;
    }

    private static ItemStack getDefaultItemStack() {
        ItemStack stack = new ItemStack(BlockLoader.SHOJI);
        RecipesUtil.getItemTagCompound(stack).setInteger("type", 0);
        return stack;
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        ItemStack stack = new ItemStack(this);
        TileEntityShoji te = (TileEntityShoji) world.getTileEntity(pos);
        if (te != null) {
        	RecipesUtil.getItemTagCompound(stack).setInteger("type", te.getType());
        } else {
        	RecipesUtil.getItemTagCompound(stack).setInteger("type", 0);
        }
        return stack;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta % 6))
                .withProperty(OPEN, meta >= 6);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int meta = state.getValue(FACING).getIndex();
        if (state.getValue(OPEN)) {
            meta += 6;
        }
        return meta;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, OPEN);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        boolean isOpen = state.getValue(OPEN);

        switch (state.getValue(FACING)) {
            case NORTH:
                return isOpen ? EAST_AABB : BLOCK_AABB_ROTATE;
            case SOUTH:
                return isOpen ? WEST_AABB : BLOCK_AABB_ROTATE;
            case WEST:
                return isOpen ? SOUTH_AABB : BLOCK_AABB;
            case EAST:
                return isOpen ? NORTH_AABB : BLOCK_AABB;
            default:
                return isOpen ? EAST_AABB : BLOCK_AABB_ROTATE;
        }
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        items.add(getItemStackWithType(0));
        items.add(getItemStackWithType(1));
        items.add(getItemStackWithType(2));
        items.add(getItemStackWithType(3));
        items.add(getItemStackWithType(4));
        items.add(getItemStackWithType(5));
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
	    ItemStack stack = getDefaultItemStack();
	    TileEntityShoji te = (TileEntityShoji) worldIn.getTileEntity(pos);
	    if (te != null) {
	    	RecipesUtil.getItemTagCompound(stack).setInteger("type", te.getType());
	    } else {
	    	RecipesUtil.getItemTagCompound(stack).setInteger("type", 0);
	    }
        worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack));
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityShoji();
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, state.withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer))
                .withProperty(OPEN, false), 2);
        if (!worldIn.isRemote) {
            TileEntityShoji te = (TileEntityShoji) worldIn.getTileEntity(pos);
            if (te != null) {
                te.setType(RecipesUtil.getItemTagCompound(stack).getInteger("type"));
                te.setFacing(EnumFacing.getDirectionFromEntityLiving(pos, placer));
                te.setOpen(false);
            }
        }
    }

    public static ItemStack getItemStackWithType(int type) {
        ItemStack stack = getDefaultItemStack();
        RecipesUtil.getItemTagCompound(stack).setInteger("type", type);
        return stack;
    }


    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean isBlockNormalCube(IBlockState blockState) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    
}
