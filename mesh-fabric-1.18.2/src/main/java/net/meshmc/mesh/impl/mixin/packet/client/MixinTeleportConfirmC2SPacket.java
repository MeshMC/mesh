package net.meshmc.mesh.impl.mixin.packet.client;

import net.meshmc.mesh.api.packet.client.CPacketConfirmTeleport;
import net.minecraft.network.packet.c2s.play.TeleportConfirmC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(TeleportConfirmC2SPacket.class)
public class MixinTeleportConfirmC2SPacket implements CPacketConfirmTeleport {
    @Final @Mutable @Shadow private int teleportId;

    @Override
    public int getTeleportId() {
        return teleportId;
    }

    @Override
    public void setTeleportId(int id) {
        teleportId = id;
    }
}
