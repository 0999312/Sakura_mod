package cn.mcmod.sakura.gui;

import cn.mcmod.sakura.inventory.ContainerStoneMortar;
import cn.mcmod.sakura.tileentity.TileEntityStoneMortar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class SakuraGuiHandler implements IGuiHandler {
    public static final int ID_STONEMORTAR = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));

        if (ID == ID_STONEMORTAR) {
            if (tile instanceof TileEntityStoneMortar) {
                return new ContainerStoneMortar(player.inventory, (TileEntityStoneMortar) tile);
            }
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));

        if (ID == ID_STONEMORTAR) {
            if (tile instanceof TileEntityStoneMortar) {

                return new GuiStoneMortar(player.inventory, (TileEntityStoneMortar) tile);
            }
        }


        return null;
    }
}