package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.network.client.CPacketUseItem;
import net.meshmc.mesh.impl.mixin.accessors.packet.CPacketPlayerTryUseItemAccessor;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;

public class CPacketUseItemMesh extends PacketMesh.Client<CPacketPlayerTryUseItem> implements CPacketUseItem {
    public CPacketUseItemMesh(CPacketPlayerTryUseItem value) {
        super(value);
    }

    @Override
    public C2S getType() {
        return C2S.UseItem;
    }

    @Override
    public Hand getHand() {
        return MeshEnum.hand(getMeshValue().getHand());
    }

    @Override
    public void setHand(Hand hand) {
        ((CPacketPlayerTryUseItemAccessor) getMeshValue()).setHand(MCEnum.hand(hand));
    }
}
