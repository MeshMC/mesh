package net.meshmc.mesh.api.network.client;

import net.meshmc.mesh.api.network.Packet;
import net.meshmc.mesh.statics.StaticPackets;
import net.meshmc.mesh.util.math.Hand;

// same as CPacketAnimation
public interface CPacketHandSwing extends Packet.Client {
    static CPacketHandSwing create(Hand hand) {
        return StaticPackets.createCPacketHandSwing(hand);
    }

    Hand getHand();
    void setHand(Hand hand);
}
