package cn.mcmod.sakura.block;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.tileentity.TileEntityCampfire;
import cn.mcmod_mmf.mmlib.util.WorldUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

import java.util.Random;

public class BlockCampfire extends BlockContainer implements ITileEntityProvider {
    protected static final AxisAlignedBB CAMPFIRE_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D);

    private final boolean isBurning;
    private static boolean keepInventory;

    public BlockCampfire(boolean isBurning) {
        super(Material.WOOD);
        this.setHardness(0.5F);
        this.setSoundType(SoundType.WOOD);
        this.isBurning = isBurning;

        if (isBurning) {
            this.setLightLevel(0.85F);
        }else {
            this.setCreativeTab(CommonProxy.tab);
        }
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return CAMPFIRE_AABB;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
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
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        IBlockState downState = worldIn.getBlockState(pos.down());
        return (downState.isTopSolid() || downState.getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) == BlockFaceShape.SOLID) && super.canPlaceBlockAt(worldIn, pos);
    }

    public boolean canBlockStay(World worldIn, BlockPos pos)
    {
        IBlockState downState = worldIn.getBlockState(pos.down());
        return downState.isTopSolid() || downState.getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) == BlockFaceShape.SOLID;
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        if (!this.canBlockStay(worldIn, pos)) {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote)
            return true;
        
		ItemStack stack = playerIn.getHeldItem(hand);
		TileEntity tile = worldIn.getTileEntity(pos);
		if (hand == EnumHand.MAIN_HAND) {
		    if (tile instanceof TileEntityCampfire) {
		        TileEntityCampfire tileEntityCampfire = (TileEntityCampfire) tile;

		        if(tileEntityCampfire.getInventory().isItemValid(0,stack)&& tileEntityCampfire.getInventory().getStackInSlot(0).getCount() < 16){
		            ItemStack campfireStack=new ItemStack(stack.getItem(),1,stack.getMetadata());
		            stack.shrink(1);
		            tileEntityCampfire.getInventory().insertItem(0,campfireStack,false);
		            return true;
		        }
		        if(stack.getItem()==ItemLoader.POT){
					worldIn.setBlockToAir(pos);
					worldIn.removeTileEntity(pos);
					worldIn.setBlockState(pos, BlockLoader.CAMPFIRE_POT_IDLE.getDefaultState());
					stack.shrink(1);
			        return true;
		        }
		        
		        if (WorldUtil.isItemFuel(stack)) {
		            tileEntityCampfire.setBurningTime(tileEntityCampfire.getBurningTime() + TileEntityFurnace.getItemBurnTime(stack));
		            setState(true, worldIn, pos);
					if(stack.getItem().hasContainerItem(stack)) stack = stack.getItem().getContainerItem(stack);
						else stack.shrink(1);
		            return true;
		        }

		        if (stack.getItem() == Items.FLINT_AND_STEEL) {
		            tileEntityCampfire.setBurningTime(tileEntityCampfire.getBurningTime() + 10000);
		            setState(true, worldIn, pos);
		            stack.damageItem(1, playerIn);
		            return true;
		        }

		        if(stack.isEmpty()){
		            Block.spawnAsEntity(worldIn, pos, ((TileEntityCampfire) tile).getInventory().getStackInSlot(0));
		            ((TileEntityCampfire) tile).getInventory().setStackInSlot(0, ItemStack.EMPTY);
		            return true;
		        }
		    }
		}

		return true;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.getBlockState(pos.up()).getBlock().onNeighborChange(worldIn, pos.up(), pos);
    }

    public static void setState(boolean active, World worldIn, BlockPos pos) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        keepInventory = true;

        if (active) {
            worldIn.setBlockState(pos, BlockLoader.CAMPFIRE_LIT.getDefaultState());
        } else {
            worldIn.setBlockState(pos, BlockLoader.CAMPFIRE_IDLE.getDefaultState());
        }

        keepInventory = false;

        if (tileentity != null) {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double d0 = pos.getX() + 0.5D;
        double d2 = pos.getZ() + 0.5D;
        double d4 = rand.nextDouble() * 0.4D - 0.2D;
        if (this.isBurning) {
            worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, pos.getY() + 0.2D, d2 + d4, 0.0D, 0.0D, 0.0D);
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, pos.getY() + 0.2D, d2 + d4, 0.0D, 0.0D, 0.0D);
        }
    }


    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        if (!keepInventory) {
            TileEntityCampfire te = (TileEntityCampfire) worldIn.getTileEntity(pos);
            IItemHandler inventory = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);

            if (inventory != null && inventory.getStackInSlot(0) != ItemStack.EMPTY) {
                Block.spawnAsEntity(worldIn, pos, inventory.getStackInSlot(0));
                ((IItemHandlerModifiable) inventory).setStackInSlot(0, ItemStack.EMPTY);
            }
        }

        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
    	return new ItemStack(BlockLoader.CAMPFIRE_IDLE);
    }
    
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCampfire();
    }

}