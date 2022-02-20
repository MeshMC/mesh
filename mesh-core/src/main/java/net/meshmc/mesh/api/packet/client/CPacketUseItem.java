package net.meshmc.mesh.api.packet.client;

import net.meshmc.mesh.MeshStatics;
import net.meshmc.mesh.util.math.Hand;

/**
 * Provides an interface for item use packets
 * @author Makrennel 2022/02/09
 */
public interface CPacketUseItem {
    static CPacketUseItem create(Hand hand) {
        return MeshStatics.createCPacketUseItem(hand);
    }

    Hand getHand();
    void setHand(Hand hand);
}
