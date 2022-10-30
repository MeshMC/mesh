package net.meshmc.mesh.impl.wrapper.network.server;

import net.meshmc.mesh.api.network.server.SPacketPlayerPositionRotation;
import net.meshmc.mesh.impl.mixin.accessors.packet.SPacketPlayerPosLookAccessor;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.network.play.server.SPacketPlayerPosLook;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

public class SPacketPlayerPositionRotationMesh extends PacketMesh.Server<SPacketPlayerPosLook> implements SPacketPlayerPositionRotation {
    public SPacketPlayerPositionRotationMesh(SPacketPlayerPosLook value) {
        super(value);
    }

    @Override
    public S2C getType() {
        return S2C.PlayerPositionRotation;
    }

    @Override
    public double getX() {
        return getMeshValue().getX();
    }

    @Override
    public double getY() {
        return getMeshValue().getY();
    }

    @Override
    public double getZ() {
        return getMeshValue().getZ();
    }

    @Override
    public void setX(double value) {
        ((SPacketPlayerPosLookAccessor) getMeshValue()).setX(value);
    }

    @Override
    public void setY(double value) {
        ((SPacketPlayerPosLookAccessor) getMeshValue()).setY(value);
    }

    @Override
    public void setZ(double value) {
        ((SPacketPlayerPosLookAccessor) getMeshValue()).setZ(value);
    }

    @Override
    public float getYaw() {
        return getMeshValue().getYaw();
    }

    @Override
    public float getPitch() {
        return getMeshValue().getPitch();
    }

    @Override
    public void setYaw(float value) {
        ((SPacketPlayerPosLookAccessor) getMeshValue()).setYaw(value);
    }

    @Override
    public void setPitch(float value) {
        ((SPacketPlayerPosLookAccessor) getMeshValue()).setPitch(value);
    }

    @Override
    public int getTeleportId() {
        return getMeshValue().getTeleportId();
    }

    @Override
    public void setTeleportId(int value) {
        ((SPacketPlayerPosLookAccessor) getMeshValue()).setTeleportId(value);
    }

    @Override
    public Set<Flag> getFlags() {
        Set<Flag> flagSet = new HashSet<>();
        for(SPacketPlayerPosLook.EnumFlags flag: getMeshValue().getFlags()) {
            flagSet.add(Flag.VALUES[flag.ordinal()]);
        }
        return flagSet;
    }

    public static final SPacketPlayerPosLook.EnumFlags[] FLAGS = SPacketPlayerPosLook.EnumFlags.values();
    @Override
    public void setFlags(Set<Flag> flags) {
        Set<SPacketPlayerPosLook.EnumFlags> flagSet = new HashSet<>();
        for(Flag flag: flags) {
            flagSet.add(FLAGS[flag.ordinal()]);
        }
        ((SPacketPlayerPosLookAccessor) getMeshValue()).setFlags(flagSet);
    }

    @Override
    public void addFlag(Flag flag) {
        getMeshValue().getFlags().add(FLAGS[flag.ordinal()]);
    }

    @Override
    public void removeFlag(Flag flag) {
        getMeshValue().getFlags().remove(FLAGS[flag.ordinal()]);
    }

    @Nullable
    @Override
    public Boolean getShouldDismount() {
        return null;
    }

    @Override
    public void setShouldDismount(boolean value) {}
}
