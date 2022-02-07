package dev.tigr.mesh.impl.mixininterface.packet.client;

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
