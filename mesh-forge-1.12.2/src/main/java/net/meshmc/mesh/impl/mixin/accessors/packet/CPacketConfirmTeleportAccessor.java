package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.play.client.CPacketConfirmTeleport;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CPacketConfirmTeleport.class)
public interface CPacketConfirmTeleportAccessor {
    @Accessor("telportId")
    void setTeleportId(int value);
}
