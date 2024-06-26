package de.spacepotato.sagittarius.viaversion.platform;

import com.viaversion.viaversion.ViaAPIBase;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.protocol.version.VersionType;
import de.spacepotato.sagittarius.entity.Player;
import de.spacepotato.sagittarius.network.protocol.PacketReceiver;
import io.netty.buffer.ByteBuf;

public class SagittariusViaApi extends ViaAPIBase<Player> {

	@Override
	public ProtocolVersion getPlayerProtocolVersion(Player player) {
		return ProtocolVersion.getProtocol(VersionType.RELEASE, getPlayerVersion(player));
	}

	@Override
	public void sendRawPacket(Player player, ByteBuf packet) {
		((PacketReceiver) player).sendPacket(packet);
	}

}
