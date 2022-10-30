package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.network.client.CPacketMoveVehicle;
import net.meshmc.mesh.impl.mixin.accessors.packet.CPacketVehicleMoveAccessor;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.network.play.client.CPacketVehicleMove;

public class CPacketMoveVehicleMesh extends PacketMesh.Client<CPacketVehicleMove> implements CPacketMoveVehicle {
    public CPacketMoveVehicleMesh(CPacketVehicleMove value) {
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
        ((CPacketVehicleMoveAccessor) getMeshValue()).setX(value);
    }

    @Override
    public void setY(double value) {
        ((CPacketVehicleMoveAccessor) getMeshValue()).setY(value);
    }

    @Override
    public void setZ(double value) {
        ((CPacketVehicleMoveAccessor) getMeshValue()).setZ(value);
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
        ((CPacketVehicleMoveAccessor) getMeshValue()).setYaw(value);
    }

    @Override
    public void setPitch(float value) {
        ((CPacketVehicleMoveAccessor) getMeshValue()).setPitch(value);
    }


}
