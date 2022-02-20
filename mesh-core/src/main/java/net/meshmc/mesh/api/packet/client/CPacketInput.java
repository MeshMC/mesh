package net.meshmc.mesh.api.packet.client;

import net.meshmc.mesh.MeshStatics;

/**
 * Provides an interface for input packets
 * @author Makrennel 2022/02/09
 */
public interface CPacketInput {
    static CPacketInput create(float sideways, float forward, boolean jumping, boolean sneaking) {
        return MeshStatics.createCPacketInput(sideways, forward, jumping, sneaking);
    }

    float getSideways();
    float getForwards();
    void setSideways(float value);
    void setForwards(float value);

    boolean getJumping();
    boolean getSneaking();
    void setJumping(boolean value);
    void setSneaking(boolean value);
}
