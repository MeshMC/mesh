package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.network.client.CPacketHandSwing;
import net.meshmc.mesh.impl.mixin.accessors.packet.HandSwingC2SPacketAccessor;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;

public class CPacketHandSwingMesh extends PacketMesh.Client<HandSwingC2SPacket> implements CPacketHandSwing {
    public CPacketHandSwingMesh(HandSwingC2SPacket value) {
        super(value);
    }

    @Override
    public C2S getType() {
        return C2S.HandSwing;
    }

    @Override
    public Hand getHand() {
        return MeshEnum.hand(getMeshValue().getHand());
    }

    @Override
    public void setHand(Hand hand) {
        ((HandSwingC2SPacketAccessor) getMeshValue()).setHand(MCEnum.hand(hand));
    }
}
