package dev.tigr.mesh.impl.mixininterface.packet.client;

/**
 * Provides an interface for boat steering input packets
 * @author Makrennel 2022/02/09
 */
public interface CPacketSteerBoat {
    boolean getLeft();
    boolean getRight();
    void setLeft(boolean value);
    void setRight(boolean value);
}
