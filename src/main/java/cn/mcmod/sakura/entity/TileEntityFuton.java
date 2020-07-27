package cn.mcmod.sakura.entity;

import cn.mcmod.sakura.block.BlockFuton;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityFuton extends TileEntity {
    @SideOnly(Side.CLIENT)
    public boolean isHeadPiece() { return BlockFuton.isHeadPiece(this.getBlockMetadata()); }
}
