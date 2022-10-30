package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.network.client.CPacketSteerBoat;
import net.meshmc.mesh.impl.mixin.accessors.packet.BoatPaddleStateC2SPacketAccessor;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.network.packet.c2s.play.BoatPaddleStateC2SPacket;

public class CPacketSteerBoatMesh extends PacketMesh.Client<BoatPaddleStateC2SPacket> implements CPacketSteerBoat {
    public CPacketSteerBoatMesh(BoatPaddleStateC2SPacket value) {
        super(value);
    }

    @Override
    public C2S getType() {
        return C2S.SteerBoat;
    }

    @Override
    public boolean getLeft() {
        return getMeshValue().isLeftPaddling();
    }

    @Override
    public boolean getRight() {
        return getMeshValue().isRightPaddling();
    }

    @Override
    public void setLeft(boolean value) {
        ((BoatPaddleStateC2SPacketAccessor) getMeshValue()).setLeft(value);
    }

    @Override
    public void setRight(boolean value) {
        ((BoatPaddleStateC2SPacketAccessor) getMeshValue()).setRight(value);
    }


}
