package net.meshmc.mesh.impl.mixin.packet.client;

import net.meshmc.mesh.api.packet.client.CPacketUseItem;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerInteractItemC2SPacket.class)
public class MixinCPacketUseItem implements CPacketUseItem {
    @Mutable @Shadow @Final private net.minecraft.util.Hand hand;

    @Override
    public Hand getHand() {
        return MeshEnum.hand(hand);
    }

    @Override
    public void setHand(Hand hand) {
        this.hand = MCEnum.hand(hand);
    }
}
