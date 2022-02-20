package net.meshmc.mesh.api.packet.client;

import net.meshmc.mesh.MeshStatics;

public interface CPacketChatMessage {
    static CPacketChatMessage create(String message) {
        return MeshStatics.createCPacketChatMessage(message);
    }

    String getMessage();
    void setMessage(String message);
}
