package cn.mcmod.sakura.block.tree;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod.sakura.block.BlockLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import java.util.Random;

public class BlockMapleSapLog extends Block {
    public static final PropertyInteger SAP_AGE = PropertyInteger.create("sap_age", 0, 5);

    public BlockMapleSapLog() {
        super(Material.WOOD);
        this.setCreativeTab(CommonProxy.tab);
        this.setHardness(2.0F);
        this.setSoundType(SoundType.WOOD);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(SAP_AGE, 0));
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlockLoader.MAPLE_LOG);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(SAP_AGE, Integer.valueOf(meta));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, SAP_AGE);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(SAP_AGE).intValue();
    }

    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return true;
    }

    @Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 5;
    }

    @Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 5;
    }
}
