package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.play.client.CPacketChatMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CPacketChatMessage.class)
public interface CPacketChatMessageAccessor {
    @Accessor("message")
    void setMessage(String message);
}
