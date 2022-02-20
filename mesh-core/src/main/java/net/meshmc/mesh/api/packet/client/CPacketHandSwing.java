package net.meshmc.mesh.api.packet.client;

import net.meshmc.mesh.MeshStatics;
import net.meshmc.mesh.util.math.Hand;

// same as CPacketAnimation
public interface CPacketHandSwing {
    static CPacketHandSwing create(Hand hand) {
        return MeshStatics.createCPacketHandSwing(hand);
    }

    Hand getHand();
    void setHand(Hand hand);
}
