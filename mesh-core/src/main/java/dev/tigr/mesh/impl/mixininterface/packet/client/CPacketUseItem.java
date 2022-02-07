package dev.tigr.mesh.impl.mixininterface.packet.client;

import dev.tigr.mesh.util.math.Hand;

public interface CPacketUseItem {
    Hand getHand();
    void setHand(Hand hand);
}
