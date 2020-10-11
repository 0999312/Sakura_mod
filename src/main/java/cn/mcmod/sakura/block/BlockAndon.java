package cn.mcmod.sakura.block;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod_mmf.mmlib.block.BlockFacing;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;

public class BlockAndon extends BlockFacing {

    public BlockAndon() {
        super(Material.WOOD,false);
        this.setSoundType(SoundType.WOOD);
        this.setCreativeTab(CommonProxy.tab);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.setHardness(1.0F);
        this.setResistance(4.0F);
        this.setLightLevel(1F);
    }

}
