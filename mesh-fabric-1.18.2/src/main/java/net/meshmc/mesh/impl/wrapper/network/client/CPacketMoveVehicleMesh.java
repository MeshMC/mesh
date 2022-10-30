package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.network.client.CPacketMoveVehicle;
import net.meshmc.mesh.impl.mixin.accessors.packet.VehicleMoveC2SPacketAccessor;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.network.packet.c2s.play.VehicleMoveC2SPacket;

public class CPacketMoveVehicleMesh extends PacketMesh.Client<VehicleMoveC2SPacket> implements CPacketMoveVehicle {
    public CPacketMoveVehicleMesh(VehicleMoveC2SPacket value) {
        super(value);
    }

    @Override
    public C2S getType() {
        return C2S.MoveVehicle;
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
        ((VehicleMoveC2SPacketAccessor) getMeshValue()).setX(value);
    }

    @Override
    public void setY(double value) {
        ((VehicleMoveC2SPacketAccessor) getMeshValue()).setY(value);
    }

    @Override
    public void setZ(double value) {
        ((VehicleMoveC2SPacketAccessor) getMeshValue()).setZ(value);
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
        ((VehicleMoveC2SPacketAccessor) getMeshValue()).setYaw(value);
    }

    @Override
    public void setPitch(float value) {
        ((VehicleMoveC2SPacketAccessor) getMeshValue()).setPitch(value);
    }


}
