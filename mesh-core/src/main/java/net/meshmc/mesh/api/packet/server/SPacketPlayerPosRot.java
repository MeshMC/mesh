package net.meshmc.mesh.api.packet.server;

import java.util.Set;

/**
 * Provides a mesh implementation for:
 * 1.18.1 - PlayerPositionLookS2CPacket
 * 1.12.2 - SPacketPlayerPosLook
 *
 * @author Makrennel 03/15/22
 */
public interface SPacketPlayerPosRot {
    enum Flag {
        X, Y, Z,
        Y_ROT, X_ROT;
        public static final Flag[] VALUES = Flag.values();
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

    int getTeleportId();
    void setTeleportId(int value);

    Set<Flag> getFlags();
    void setFlags(Set<Flag> flags);

    void addFlag(Flag flag);
    void removeFlag(Flag flag);

    boolean getShouldDismount();
    void setShouldDismount(boolean value);
}
