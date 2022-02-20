package net.meshmc.mesh.api.packet.client;

import net.meshmc.mesh.util.math.Hand;

/**
 * Provides an interface for item use packets
 * @author Makrennel 2022/02/09
 */
public interface CPacketUseItem {
    Hand getHand();
    void setHand(Hand hand);
}
