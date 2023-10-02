package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.packet.c2s.play.BoatPaddleStateC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BoatPaddleStateC2SPacket.class)
public interface BoatPaddleStateC2SPacketAccessor {
    @Mutable
    @Accessor("leftPaddling")
    void setLeft(boolean value);

    @Mutable
    @Accessor("rightPaddling")
    void setRight(boolean value);
}
