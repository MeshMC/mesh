package net.meshmc.mesh.impl.mixin.packet.client;

import net.meshmc.mesh.api.packet.client.CPacketHandSwing;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(HandSwingC2SPacket.class)
public class MixinCPacketHandSwing implements CPacketHandSwing {
    @Mutable @Shadow @Final private Hand hand;

    @Override
    public net.meshmc.mesh.util.math.Hand getHand() {
        return MeshEnum.hand(hand);
    }

    @Override
    public void setHand(net.meshmc.mesh.util.math.Hand hand) {
        this.hand = MCEnum.hand(hand);
    }
}
