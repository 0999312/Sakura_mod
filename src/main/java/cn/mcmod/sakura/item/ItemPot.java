package cn.mcmod.sakura.item;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.block.BlockCampfire;
import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.tileentity.TileEntityCampfire;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemPot extends Item {
	public ItemPot() {
		setUnlocalizedName(SakuraMain.MODID + "." + "cooking_pot");
		setMaxStackSize(1);
	}

}
