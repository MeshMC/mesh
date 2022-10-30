package net.meshmc.mesh.api.network.client;

import net.meshmc.mesh.api.network.Packet;
import net.meshmc.mesh.statics.StaticPackets;
import net.meshmc.mesh.util.MCVersion;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;

public interface CPacketChatMessage extends Packet.Client {
    static CPacketChatMessage create(String message) {
        return StaticPackets.createCPacketChatMessage(message);
    }

    String getMessage();
    void setMessage(String message);

    @Nullable
    @MCVersion.OnlyOn(value = MCVersion.v1_19, minimumVersion = true)
    Instant getTimestamp();
    @MCVersion.OnlyOn(value = MCVersion.v1_19, minimumVersion = true)
    void setTimestamp(Instant value);

    @Nullable
    @MCVersion.OnlyOn(value = MCVersion.v1_19, minimumVersion = true)
    Long getSalt();
    @MCVersion.OnlyOn(value = MCVersion.v1_19, minimumVersion = true)
    void setSalt(long value);

    @Nullable
    @MCVersion.OnlyOn(value = MCVersion.v1_19, minimumVersion = true)
    Boolean getSignedPreview();
    @MCVersion.OnlyOn(value = MCVersion.v1_19, minimumVersion = true)
    void setSignedPreview();

    // TODO: 1.19 Signature
    // TODO: 1.19.1+ (Different)Signature + Acknowledgement
}
