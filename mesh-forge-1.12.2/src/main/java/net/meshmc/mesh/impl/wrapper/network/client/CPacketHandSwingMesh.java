package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.network.client.CPacketHandSwing;
import net.meshmc.mesh.impl.mixin.accessors.packet.CPacketAnimationAccessor;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.network.play.client.CPacketAnimation;

public class CPacketHandSwingMesh extends PacketMesh.Client<CPacketAnimation> implements CPacketHandSwing {
    public CPacketHandSwingMesh(CPacketAnimation value) {
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
        ((CPacketAnimationAccessor) getMeshValue()).setHand(MCEnum.hand(hand));
    }
}
