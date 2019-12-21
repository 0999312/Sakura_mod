package cn.mcmod.sakura.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketKeyMessage implements IMessage {
	private String sender;
	public PacketKeyMessage() {
		
	}
	
	public PacketKeyMessage(String sender1) {
		sender=sender1;
	}
    @Override
    public void fromBytes(ByteBuf buf) {
        sender = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf,sender);
    }
}