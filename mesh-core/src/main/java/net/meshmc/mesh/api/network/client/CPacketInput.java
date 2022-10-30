package net.meshmc.mesh.api.network.client;

import net.meshmc.mesh.api.network.Packet;
import net.meshmc.mesh.statics.StaticPackets;

/**
 * Provides an interface for input packets
 * @author Makrennel 2022/02/09
 */
public interface CPacketInput extends Packet.Client {
    static CPacketInput create(float sideways, float forward, boolean jumping, boolean sneaking) {
        return StaticPackets.createCPacketInput(sideways, forward, jumping, sneaking);
    }

    float getSideways();
    float getForwards();
    void setSideways(float value);
    void setForwards(float value);

    boolean isJumping();
    boolean isSneaking();
    void setJumping(boolean value);
    void setSneaking(boolean value);
}
