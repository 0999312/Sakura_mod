package cn.mcmod.sakura.compat.waila;

import java.util.List;

import cn.mcmod.sakura.block.BlockCampfirePot;
import cn.mcmod.sakura.tileentity.TileEntityCampfirePot;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public class CampfirePotPlugin implements IWailaDataProvider {
	public static void register(IWailaRegistrar registrar) {
		registrar.registerBodyProvider(new CampfirePotPlugin(), BlockCampfirePot.class);
	}

	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		if (accessor.getTileEntity() instanceof TileEntityCampfirePot) {
			TileEntityCampfirePot te_campfire = (TileEntityCampfirePot) accessor.getTileEntity();
			currenttip.add(I18n.format("sakura.tooltip.campfire.fire_remain", te_campfire.getField(0)));
		}
		return currenttip;
	}

}
