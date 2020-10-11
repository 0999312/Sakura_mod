package cn.mcmod.sakura.compat.waila;

import java.util.List;

import cn.mcmod.sakura.block.BlockCampfire;
import cn.mcmod.sakura.tileentity.TileEntityCampfire;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public class CampfirePlugin implements IWailaDataProvider {
	public static void register(IWailaRegistrar registrar) {
		registrar.registerBodyProvider(new CampfirePlugin(), BlockCampfire.class);
	}

	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		if (accessor.getTileEntity() instanceof TileEntityCampfire) {
			TileEntityCampfire te_campfire = (TileEntityCampfire) accessor.getTileEntity();
			currenttip.add(I18n.format("sakura.tooltip.campfire.fire_remain", te_campfire.getBurningTime()));
		}
		return currenttip;
	}

}
