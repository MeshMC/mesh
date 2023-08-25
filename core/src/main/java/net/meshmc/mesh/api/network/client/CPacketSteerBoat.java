package net.meshmc.mesh.api.network.client;

import net.meshmc.mesh.api.network.Packet;
import net.meshmc.mesh.statics.StaticPackets;

/**
 * Provides an interface for boat steering input packets
 * @author Makrennel 2022/02/09
 */
public interface CPacketSteerBoat extends Packet.Client {
    static CPacketSteerBoat create(boolean left, boolean right) {
        return StaticPackets.createCPacketSteerBoat(left, right);
    }

    boolean getLeft();
    boolean getRight();
    void setLeft(boolean value);
    void setRight(boolean value);
}
