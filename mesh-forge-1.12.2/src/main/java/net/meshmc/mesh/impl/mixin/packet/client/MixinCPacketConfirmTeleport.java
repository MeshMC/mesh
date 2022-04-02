package net.meshmc.mesh.impl.mixin.packet.client;

import net.minecraft.network.play.client.CPacketConfirmTeleport;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CPacketConfirmTeleport.class)
public class MixinCPacketConfirmTeleport implements net.meshmc.mesh.api.packet.client.CPacketConfirmTeleport {
    @Shadow private int telportId;

    @Override
    public int getTeleportId() {
        return telportId;
    }

    @Override
    public void setTeleportId(int id) {
        telportId = id;
    }
}
