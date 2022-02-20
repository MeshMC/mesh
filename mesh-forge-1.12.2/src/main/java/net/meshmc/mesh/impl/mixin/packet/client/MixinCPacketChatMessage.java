package net.meshmc.mesh.impl.mixin.packet.client;

import net.meshmc.mesh.api.packet.client.CPacketChatMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(net.minecraft.network.play.client.CPacketChatMessage.class)
public class MixinCPacketChatMessage implements CPacketChatMessage {
    @Shadow private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
