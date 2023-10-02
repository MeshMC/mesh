package net.meshmc.mesh.api.network.client;

import net.meshmc.mesh.api.network.Packet;
import net.meshmc.mesh.statics.StaticPackets;
import net.meshmc.mesh.util.math.Hand;

/**
 * Provides an interface for item use packets
 * @author Makrennel 2022/02/09
 */
public interface CPacketUseItem extends Packet.Client {
    static CPacketUseItem create(Hand hand, int sequence) {
        return StaticPackets.createCPacketUseItem(hand, sequence);
    }

    Hand getHand();
    void setHand(Hand hand);
}
