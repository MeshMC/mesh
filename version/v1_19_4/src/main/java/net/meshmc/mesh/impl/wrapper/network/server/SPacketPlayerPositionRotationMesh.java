package net.meshmc.mesh.impl.wrapper.network.server;

import net.meshmc.mesh.api.network.server.SPacketPlayerPositionRotation;
import net.meshmc.mesh.impl.mixin.accessors.packet.PlayerPositionLookS2CPacketAccessor;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.network.packet.s2c.play.PositionFlag;

import java.util.HashSet;
import java.util.Set;

public class SPacketPlayerPositionRotationMesh extends PacketMesh.Server<PlayerPositionLookS2CPacket> implements SPacketPlayerPositionRotation {
    public SPacketPlayerPositionRotationMesh(PlayerPositionLookS2CPacket value) {
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
        ((PlayerPositionLookS2CPacketAccessor) getMeshValue()).setX(value);
    }

    @Override
    public void setY(double value) {
        ((PlayerPositionLookS2CPacketAccessor) getMeshValue()).setY(value);
    }

    @Override
    public void setZ(double value) {
        ((PlayerPositionLookS2CPacketAccessor) getMeshValue()).setZ(value);
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
        ((PlayerPositionLookS2CPacketAccessor) getMeshValue()).setYaw(value);
    }

    @Override
    public void setPitch(float value) {
        ((PlayerPositionLookS2CPacketAccessor) getMeshValue()).setPitch(value);
    }

    @Override
    public int getTeleportId() {
        return getMeshValue().getTeleportId();
    }

    @Override
    public void setTeleportId(int value) {
        ((PlayerPositionLookS2CPacketAccessor) getMeshValue()).setTeleportId(value);
    }

    @Override
    public Set<Flag> getFlags() {
        Set<Flag> flagSet = new HashSet<>();
        for(PositionFlag flag: getMeshValue().getFlags()) {
            flagSet.add(Flag.VALUES[flag.ordinal()]);
        }
        return flagSet;
    }

    public static final PositionFlag[] FLAGS = PositionFlag.values();
    @Override
    public void setFlags(Set<Flag> flags) {
        Set<PositionFlag> flagSet = new HashSet<>();
        for(Flag flag: flags) {
            flagSet.add(FLAGS[flag.ordinal()]);
        }
        ((PlayerPositionLookS2CPacketAccessor) getMeshValue()).setFlags(flagSet);
    }

    @Override
    public void addFlag(Flag flag) {
        getMeshValue().getFlags().add(FLAGS[flag.ordinal()]);
    }

    @Override
    public void removeFlag(Flag flag) {
        getMeshValue().getFlags().remove(FLAGS[flag.ordinal()]);
    }

    @Override
    public Boolean getShouldDismount() {
        return null;
    }

    @Override
    public void setShouldDismount(boolean value) {}
}
