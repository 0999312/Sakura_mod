package cn.mcmod.sakura.packet;

import cn.mcmod.sakura.item.katana.ItemSheath;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketKeyMessageHandler implements IMessageHandler<PacketKeyMessage, IMessage> {

	@Override
	public IMessage onMessage(PacketKeyMessage message, MessageContext ctx) {
		EntityPlayer player = ctx.getServerHandler().player;
		if(isPlayerHoldingSheath(player)){
			ItemStack sheath = getHeldItemSheath(player);
			((ItemSheath)sheath.getItem()).sheath_In(player);
		}
		return null;
	}
	
	public ItemStack getHeldItemSheath(EntityPlayer player) {
		ItemStack stack = player.getHeldItemMainhand();
		if (stack.isEmpty() || !(stack.getItem() instanceof ItemSheath)) {
			stack = player.getHeldItemOffhand();
		}
		return stack;
	}
	public boolean isPlayerHoldingSheath(EntityPlayer player) {

		if (!(!player.getHeldItemMainhand().isEmpty() || !player.getHeldItemOffhand().isEmpty())) {
			return false;
		}
		ItemStack heldItem = player.getHeldItemMainhand();
		if (heldItem.getItem() instanceof ItemSheath) {
			return true;
		}
		heldItem = player.getHeldItemOffhand();
		return heldItem.getItem() instanceof ItemSheath;
	}
}