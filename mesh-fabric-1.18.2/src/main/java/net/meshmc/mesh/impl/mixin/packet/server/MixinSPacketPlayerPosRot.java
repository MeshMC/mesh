package net.meshmc.mesh.impl.mixin.packet.server;

import net.meshmc.mesh.api.packet.server.SPacketPlayerPosRot;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.HashSet;
import java.util.Set;

@Mixin(PlayerPositionLookS2CPacket.class)
public class MixinSPacketPlayerPosRot implements SPacketPlayerPosRot {
    @Mutable @Shadow @Final private Set<PlayerPositionLookS2CPacket.Flag> flags;
    @Mutable @Shadow @Final private double x;
    @Mutable @Shadow @Final private double y;
    @Mutable @Shadow @Final private double z;
    @Mutable @Shadow @Final private float yaw;
    @Mutable @Shadow @Final private float pitch;
    @Mutable @Shadow @Final private int teleportId;
    @Mutable @Shadow @Final private boolean shouldDismount;

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public void setX(double value) {
        x = value;
    }

    @Override
    public void setY(double value) {
        y = value;
    }

    @Override
    public void setZ(double value) {
        z = value;
    }

    @Override
    public float getYaw() {
        return yaw;
    }

    @Override
    public float getPitch() {
        return pitch;
    }

    @Override
    public void setYaw(float value) {
        yaw = value;
    }

    @Override
    public void setPitch(float value) {
        pitch = value;
    }

    @Override
    public int getTeleportId() {
        return teleportId;
    }

    @Override
    public void setTeleportId(int value) {
        teleportId = value;
    }

    @Override
    public Set<Flag> getFlags() {
        Set<Flag> flagSet = new HashSet<>();
        for(PlayerPositionLookS2CPacket.Flag flag: flags) {
            flagSet.add(Flag.VALUES[flag.ordinal()]);
        }
        return flagSet;
    }

    private static final PlayerPositionLookS2CPacket.Flag[] FLAGS = PlayerPositionLookS2CPacket.Flag.values();
    @Override
    public void setFlags(Set<Flag> flags) {
        Set<PlayerPositionLookS2CPacket.Flag> flagSet = new HashSet<>();
        for(Flag flag: flags) {
            flagSet.add(FLAGS[flag.ordinal()]);
        }
        this.flags = flagSet;
    }

    @Override
    public void addFlag(Flag flag) {
        flags.add(FLAGS[flag.ordinal()]);
    }

    @Override
    public void removeFlag(Flag flag) {
        flags.remove(FLAGS[flag.ordinal()]);
    }

    @Override
    public boolean getShouldDismount() {
        return shouldDismount;
    }

    @Override
    public void setShouldDismount(boolean value) {
        shouldDismount = value;
    }
}
