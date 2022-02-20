package net.meshmc.mesh.api.packet.client;

import net.meshmc.mesh.MeshStatics;

/**
 * Provides an interface for boat steering input packets
 * @author Makrennel 2022/02/09
 */
public interface CPacketSteerBoat {
    static CPacketSteerBoat create(boolean left, boolean right) {
        return MeshStatics.createCPacketSteerBoat(left, right);
    }

    boolean getLeft();
    boolean getRight();
    void setLeft(boolean value);
    void setRight(boolean value);
}
