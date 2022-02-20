package net.meshmc.mesh.api.packet.client;

/**
 * Provides an interface for input packets
 * @author Makrennel 2022/02/09
 */
public interface CPacketInput {
    float getSideways();
    float getForwards();
    void setSideways(float value);
    void setForwards(float value);

    boolean getJumping();
    boolean getSneaking();
    void setJumping(boolean value);
    void setSneaking(boolean value);
}
