package cn.mcmod.sakura.gui;

import cn.mcmod.sakura.inventory.ContainerBarrel;
import cn.mcmod.sakura.inventory.ContainerCampfirePot;
import cn.mcmod.sakura.inventory.ContainerDistillation;
import cn.mcmod.sakura.inventory.ContainerStoneMortar;
import cn.mcmod.sakura.tileentity.TileEntityBarrel;
import cn.mcmod.sakura.tileentity.TileEntityCampfirePot;
import cn.mcmod.sakura.tileentity.TileEntityDistillation;
import cn.mcmod.sakura.tileentity.TileEntityStoneMortar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class SakuraGuiHandler implements IGuiHandler {
    public static final int ID_STONEMORTAR = 0;
    public static final int ID_CAMPFIREPOT = 1;
    public static final int ID_BARREL = 2;
    public static final int ID_DISTILLATION = 3;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));

        if (ID == ID_STONEMORTAR) {
            if (tile instanceof TileEntityStoneMortar) {
                return new ContainerStoneMortar(player.inventory, (TileEntityStoneMortar) tile);
            }
        }
        if (ID == ID_CAMPFIREPOT) {
            if (tile instanceof TileEntityCampfirePot) {
                return new ContainerCampfirePot(player.inventory, (TileEntityCampfirePot) tile);
            }
        }
        if (ID == ID_BARREL) {
            if (tile instanceof TileEntityBarrel) {
                return new ContainerBarrel(player.inventory, (TileEntityBarrel) tile);
            }
        }
        if (ID == ID_DISTILLATION) {
            if (tile instanceof TileEntityDistillation) {
                return new ContainerDistillation(player.inventory, (TileEntityDistillation) tile);
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
        if (ID == ID_CAMPFIREPOT) {
            if (tile instanceof TileEntityCampfirePot) {

                return new GuiCampfirePot(player.inventory, (TileEntityCampfirePot) tile);
            }
        }
        if (ID == ID_BARREL) {
            if (tile instanceof TileEntityBarrel) {
                return new GuiBarrel(player.inventory, (TileEntityBarrel) tile);
            }
        }
        if (ID == ID_DISTILLATION) {
            if (tile instanceof TileEntityDistillation) {
                return new GuiDistillation(player.inventory, (TileEntityDistillation) tile);
            }
        }

        return null;
    }
}