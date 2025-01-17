package meteor.plugins.api.packets;

import meteor.plugins.api.game.Game;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.packets.PacketBufferNode;
import net.runelite.api.packets.PacketWriter;

public class MovementPackets {
	public static void sendMovement(int worldX, int worldY, boolean run) {
		PacketWriter writer = Game.getClient().getPacketWriter();
		PacketBufferNode packet = Game.getClient().preparePacket(Game.getClient().getWalkPacket(), writer.getIsaacCipher());
		packet.getPacketBuffer().writeByte$api(5);
		packet.getPacketBuffer().writeShort01A$api(worldX);
		packet.getPacketBuffer().writeShortA$api(worldY);
		packet.getPacketBuffer().writeByteA$api(run ? 2 : 0);
		writer.queuePacket(packet);
	}

	public static void sendMovement(int worldX, int worldY) {
		sendMovement(worldX, worldY, false);
	}

	public static void sendMovement(WorldPoint worldPoint, boolean run) {
		sendMovement(worldPoint.getX(), worldPoint.getY(), run);
	}

	public static void sendMovement(WorldPoint worldPoint) {
		sendMovement(worldPoint, false);
	}
}
