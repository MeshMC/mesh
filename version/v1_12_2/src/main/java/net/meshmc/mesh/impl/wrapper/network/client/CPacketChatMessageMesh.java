package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.network.client.CPacketChatMessage;
import net.meshmc.mesh.impl.mixin.accessors.packet.CPacketChatMessageAccessor;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;

import javax.annotation.Nullable;
import java.time.Instant;

public class CPacketChatMessageMesh extends PacketMesh.Client<net.minecraft.network.play.client.CPacketChatMessage> implements CPacketChatMessage {
    public CPacketChatMessageMesh(net.minecraft.network.play.client.CPacketChatMessage value) {
        super(value);
    }

    @Override
    public C2S getType() {
        return C2S.ChatMessage;
    }

    @Override
    public String getMessage() {
        return getMeshValue().getMessage();
    }

    @Override
    public void setMessage(String message) {
        ((CPacketChatMessageAccessor) getMeshValue()).setMessage(message);
    }

    @Nullable
    @Override
    public Instant getTimestamp() {
        return null;
    }

    @Override
    public void setTimestamp(Instant value) {}

    @Nullable
    @Override
    public Long getSalt() {
        return null;
    }

    @Override
    public void setSalt(long value) {}

    @Nullable
    @Override
    public Boolean getSignedPreview() {
        return null;
    }

    @Override
    public void setSignedPreview() {}
}
