package net.meshmc.mesh.api.packet.client;

import net.meshmc.mesh.MeshStatics;

public interface CPacketConfirmTeleport {
    static CPacketConfirmTeleport create(int id) {
        return MeshStatics.createCPacketConfirmTeleport(id);
    }

    int getTeleportId();
    void setTeleportId(int id);
}
