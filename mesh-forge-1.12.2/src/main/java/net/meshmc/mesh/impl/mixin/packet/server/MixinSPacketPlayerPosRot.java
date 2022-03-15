package net.meshmc.mesh.impl.mixin.packet.server;

import net.meshmc.mesh.api.packet.server.SPacketPlayerPosRot;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Mixin(SPacketPlayerPosLook.class)
public class MixinSPacketPlayerPosRot implements SPacketPlayerPosRot {
    @Shadow private Set<SPacketPlayerPosLook.EnumFlags> flags;
    @Shadow private double x;
    @Shadow private double y;
    @Shadow private double z;
    @Shadow private float yaw;
    @Shadow private float pitch;
    @Shadow private int teleportId;

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
        for(SPacketPlayerPosLook.EnumFlags flag: flags) {
            flagSet.add(Flag.VALUES[flag.ordinal()]);
        }
        return Collections.unmodifiableSet(flagSet);
    }

    private static final SPacketPlayerPosLook.EnumFlags[] FLAGS = SPacketPlayerPosLook.EnumFlags.values();
    @Override
    public void setFlags(Set<Flag> flags) {
        Set<SPacketPlayerPosLook.EnumFlags> flagSet = new HashSet<>();
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
        return false;
    }

    @Override
    public void setShouldDismount(boolean value) {
        // Not In 1.12
    }
}
