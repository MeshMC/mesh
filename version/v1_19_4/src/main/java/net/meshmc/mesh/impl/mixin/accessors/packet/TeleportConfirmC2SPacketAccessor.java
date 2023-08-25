package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.packet.c2s.play.TeleportConfirmC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(TeleportConfirmC2SPacket.class)
public interface TeleportConfirmC2SPacketAccessor {
    @Mutable
    @Accessor("teleportId")
    void setTeleportId(int id);
}
