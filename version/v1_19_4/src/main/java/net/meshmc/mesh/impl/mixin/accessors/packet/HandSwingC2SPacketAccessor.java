package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(HandSwingC2SPacket.class)
public interface HandSwingC2SPacketAccessor {
    @Mutable
    @Accessor("hand")
    void setHand(Hand hand);
}
