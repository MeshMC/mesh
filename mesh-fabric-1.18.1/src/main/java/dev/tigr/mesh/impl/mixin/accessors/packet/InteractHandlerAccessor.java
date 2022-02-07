package dev.tigr.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PlayerInteractEntityC2SPacket.InteractHandler.class)
public interface InteractHandlerAccessor {
    @Accessor("hand")
    Hand getHand();

    @Accessor("hand")
    void setHand(Hand hand);
}
