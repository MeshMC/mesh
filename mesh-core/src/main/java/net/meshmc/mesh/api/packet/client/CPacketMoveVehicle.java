package net.meshmc.mesh.api.packet.client;

import net.meshmc.mesh.MeshStatics;
import net.meshmc.mesh.api.entity.Entity;

/**
 * Provides an interface for vehicle position packets
 * @author Makrennel 2022/02/09
 */
public interface CPacketMoveVehicle {
    static CPacketMoveVehicle create(Entity entity) {
        return MeshStatics.createCPacketMoveVehicle(entity);
    }

    static CPacketMoveVehicle create(double x, double y, double z, float yaw, float pitch) {
        return MeshStatics.createCPacketMoveVehicle(x, y, z, yaw, pitch);
    }

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
