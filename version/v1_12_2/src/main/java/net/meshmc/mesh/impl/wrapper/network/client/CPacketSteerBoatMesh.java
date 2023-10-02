package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.network.client.CPacketSteerBoat;
import net.meshmc.mesh.impl.mixin.accessors.packet.CPacketSteerBoatAccessor;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;

public class CPacketSteerBoatMesh extends PacketMesh.Client<net.minecraft.network.play.client.CPacketSteerBoat> implements CPacketSteerBoat {
    public CPacketSteerBoatMesh(net.minecraft.network.play.client.CPacketSteerBoat value) {
        super(value);
    }

    @Override
    public C2S getType() {
        return C2S.SteerBoat;
    }

    @Override
    public boolean getLeft() {
        return getMeshValue().getLeft();
    }

    @Override
    public boolean getRight() {
        return getMeshValue().getRight();
    }

    @Override
    public void setLeft(boolean value) {
        ((CPacketSteerBoatAccessor) getMeshValue()).setLeft(value);
    }

    @Override
    public void setRight(boolean value) {
        ((CPacketSteerBoatAccessor) getMeshValue()).setRight(value);
    }


}
