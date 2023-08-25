package net.meshmc.mesh.api.network.client;

import net.meshmc.mesh.api.network.Packet;
import net.meshmc.mesh.statics.StaticPackets;

public interface CPacketConfirmTeleport extends Packet.Client {
    static CPacketConfirmTeleport create(int id) {
        return StaticPackets.createCPacketConfirmTeleport(id);
    }

    int getTeleportId();
    void setTeleportId(int id);
}
