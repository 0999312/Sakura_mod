package cn.mcmod.sakura.block.maple;

import cn.mcmod.sakura.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public class BlockMapleSapLog extends Block {
    public static final PropertyInteger SAP_AGE = PropertyInteger.create("sap_age", 0, 5);
    public BlockMapleSapLog() {
        super(Material.WOOD);
        this.setCreativeTab(CommonProxy.tab);
        this.setHardness(2.0F);
        this.setSoundType(SoundType.WOOD);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(SAP_AGE,0));
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
}
