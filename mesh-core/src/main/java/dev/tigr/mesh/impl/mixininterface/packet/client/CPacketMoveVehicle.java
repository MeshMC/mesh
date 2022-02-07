package dev.tigr.mesh.impl.mixininterface.packet.client;

public interface CPacketMoveVehicle {
    double getX();
    double getY();
    double getZ();
    void setX(double value);
    void setY(double value);
    void setZ(double value);

    float getYaw();
    float getPitch();
    void setYaw(float value);
    void setPitch(float value);
}
