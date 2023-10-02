package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.network.client.CPacketChatMessage;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;

public class CPacketChatMessageMesh extends PacketMesh.Client<ChatMessageC2SPacket> implements CPacketChatMessage {
    public CPacketChatMessageMesh(ChatMessageC2SPacket value) {
        super(value);
    }

    @Override
    public C2S getType() {
        return C2S.ChatMessage;
    }

    @Override
    public String getMessage() {
        return getMeshValue().chatMessage();
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
