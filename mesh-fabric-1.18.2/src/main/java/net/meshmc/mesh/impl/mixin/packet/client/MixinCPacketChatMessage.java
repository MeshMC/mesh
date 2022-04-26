package net.meshmc.mesh.impl.mixin.packet.client;

import net.meshmc.mesh.api.packet.client.CPacketChatMessage;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ChatMessageC2SPacket.class)
public class MixinCPacketChatMessage implements CPacketChatMessage {
    @Mutable @Shadow @Final private String chatMessage;

    @Override
    public String getMessage() {
        return chatMessage;
    }

    @Override
    public void setMessage(String message) {
        chatMessage = message;
    }
}
