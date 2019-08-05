package cn.mcmod.sakura.block;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.gui.SakuraGuiHandler;
import cn.mcmod.sakura.tileentity.TileEntityStoneMortar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockStoneMortar extends BlockContainer implements ITileEntityProvider {
    protected BlockStoneMortar() {
        super(Material.ROCK);
        this.setHardness(2.0F);
        this.setResistance(11.0F);
        this.setSoundType(SoundType.STONE);
        this.setCreativeTab(CommonProxy.tab);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        } else {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity instanceof TileEntityStoneMortar) {
                player.openGui(SakuraMain.instance, SakuraGuiHandler.ID_STONEMORTAR, world, pos.getX(), pos.getY(), pos.getZ());
            }
            return true;
        }
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityStoneMortar();
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
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

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof TileEntityStoneMortar) {
            InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityStoneMortar) tileentity);
            worldIn.updateComparatorOutputLevel(pos, this);
        }


        super.breakBlock(worldIn, pos, state);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }
}
