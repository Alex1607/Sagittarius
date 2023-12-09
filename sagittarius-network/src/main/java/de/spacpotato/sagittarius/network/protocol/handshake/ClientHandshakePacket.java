package de.spacpotato.sagittarius.network.protocol.handshake;

import de.spacpotato.sagittarius.network.handler.ChildNetworkHandler;
import de.spacpotato.sagittarius.network.protocol.Packet;
import io.netty.buffer.ByteBuf;
import lombok.Getter;

@Getter
public class ClientHandshakePacket extends Packet {

	private int protocolVersion;
	private String serverAddress;
	private int port;
	private int nextState;
	
	@Override
	public void read(ByteBuf buf) throws Exception {
		protocolVersion = readVarInt(buf);
		serverAddress = readString(buf);
		port = buf.readUnsignedShort();
		nextState= readVarInt(buf);
	}
	
	@Override
	public void handle(ChildNetworkHandler childHandler) {
		childHandler.handleHandshake(this);
	}
	
	@Override
	public Packet createNewPacket() {
		return new ClientHandshakePacket();
	}

	@Override
	public int getId() {
		return 0x00;
	}

}