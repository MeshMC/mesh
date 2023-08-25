package net.meshmc.mesh.api.network.client;

import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.math.Vec2f;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.api.network.Packet;
import net.meshmc.mesh.statics.StaticPackets;

/**
 * Provides an interface for vehicle position packets
 * @author Makrennel 2022/02/09
 */
public interface CPacketMoveVehicle extends Packet.Client {
    static CPacketMoveVehicle create(Entity entity) {
        return StaticPackets.createCPacketMoveVehicle(entity);
    }

    static CPacketMoveVehicle create(double x, double y, double z, float yaw, float pitch) {
        return StaticPackets.createCPacketMoveVehicle(x, y, z, yaw, pitch);
    }

    double getX();
    double getY();
    double getZ();
    void setX(double value);
    void setY(double value);
    void setZ(double value);

    default Vec3d getPos() {
        return Vec3d.create(getX(), getY(), getZ());
    }

    default void setPos(Vec3d pos) {
        setX(pos.getX());
        setY(pos.getY());
        setZ(pos.getZ());
    }

    default void setPos(double x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    float getYaw();
    float getPitch();
    void setYaw(float value);
    void setPitch(float value);

    default Vec2f getRotation() {
        return Vec2f.create(getYaw(), getPitch());
    }

    default void setRotation(Vec2f rotation) {
        setYaw(rotation.getX());
        setPitch(rotation.getY());
    }

    default void setRotation(float yaw, float pitch) {
        setYaw(yaw);
        setPitch(pitch);
    }
}
