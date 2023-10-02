package net.meshmc.mesh.api.network.server;

import net.meshmc.mesh.api.network.Packet;
import net.meshmc.mesh.util.GameVersion;

import javax.annotation.Nullable;
import java.util.Set;

/**
 * Provides a mesh implementation for:
 * 1.18.1 - PlayerPositionLookS2CPacket
 * 1.12.2 - SPacketPlayerPosLook
 *
 * @author Makrennel 03/15/22
 */
public interface SPacketPlayerPositionRotation extends Packet.Server {
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

    @Nullable
    @GameVersion.OnlyOn(value = {GameVersion.v1_17, GameVersion.v1_17_1, GameVersion.v1_18, GameVersion.v1_18_1, GameVersion.v1_18_2})
    Boolean getShouldDismount();
    @GameVersion.OnlyOn(value = {GameVersion.v1_17, GameVersion.v1_17_1, GameVersion.v1_18, GameVersion.v1_18_1, GameVersion.v1_18_2})
    void setShouldDismount(boolean value);
}
