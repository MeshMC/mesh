package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PlayerInputC2SPacket.class)
public interface PlayerInputC2SPacketAccessor {
    @Mutable
    @Accessor("sideways")
    void setSideways(float value);

    @Mutable
    @Accessor("forward")
    void setForward(float value);

    @Mutable
    @Accessor("jumping")
    void setJumping(boolean value);

    @Mutable
    @Accessor("sneaking")
    void setSneaking(boolean value);
}
