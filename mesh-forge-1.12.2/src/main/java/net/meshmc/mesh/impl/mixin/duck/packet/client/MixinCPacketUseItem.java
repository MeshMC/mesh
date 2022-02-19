package net.meshmc.mesh.impl.mixin.duck.packet.client;

import net.meshmc.mesh.impl.conversion.MCEnum;
import net.meshmc.mesh.impl.conversion.MeshEnum;
import net.meshmc.mesh.impl.mixininterface.packet.client.CPacketUseItem;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CPacketPlayerTryUseItem.class)
public class MixinCPacketUseItem implements CPacketUseItem {
    @Shadow private EnumHand hand;

    @Override
    public Hand getHand() {
        return MeshEnum.hand(hand);
    }

    @Override
    public void setHand(Hand hand) {
        this.hand = MCEnum.hand(hand);
    }
}
