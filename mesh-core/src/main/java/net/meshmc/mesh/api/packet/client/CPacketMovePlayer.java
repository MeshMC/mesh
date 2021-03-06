package net.meshmc.mesh.api.packet.client;

import net.meshmc.mesh.MeshStatics;
import net.meshmc.mesh.api.math.Vec2f;
import net.meshmc.mesh.api.math.Vec3d;

/**
 * Provides an interface for player position and rotation packets
 * @author Makrennel 2022/02/09
 */
public interface CPacketMovePlayer {
    static CPacketMovePlayer create(boolean onGround) {
        return MeshStatics.createCPacketMovePlayerOnGround(onGround);
    }

    static CPacketMovePlayer create(double x, double y, double z, boolean onGround) {
        return MeshStatics.createCPacketMovePlayerMoving(x, y, z, onGround);
    }

    static CPacketMovePlayer create(float yaw, float pitch, boolean onGround) {
        return MeshStatics.createCPacketMovePlayerRotating(yaw, pitch, onGround);
    }

    static CPacketMovePlayer create(double x, double y, double z, float yaw, float pitch, boolean onGround) {
        return MeshStatics.createCPacketMovePlayerFull(x, y, z, yaw, pitch, onGround);
    }

    static CPacketMovePlayer create(Vec3d position, boolean onGround) {
        return MeshStatics.createCPacketMovePlayerMoving(position.getX(), position.getY(), position.getZ(), onGround);
    }

    static CPacketMovePlayer create(Vec2f rotation, boolean onGround) {
        return MeshStatics.createCPacketMovePlayerRotating(rotation.getX(), rotation.getY(), onGround);
    }

    static CPacketMovePlayer create(Vec3d position, Vec2f rotation, boolean onGround) {
        return MeshStatics.createCPacketMovePlayerFull(position.getX(), position.getY(), position.getZ(), rotation.getX(), rotation.getY(), onGround);
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

    boolean isOnGround();
    boolean isMoving();
    boolean isRotating();
    void setOnGround(boolean value);
    void setMoving(boolean value);
    void setRotating(boolean value);
}
