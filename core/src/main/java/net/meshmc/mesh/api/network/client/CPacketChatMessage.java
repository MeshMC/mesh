package net.meshmc.mesh.api.network.client;

import net.meshmc.mesh.api.network.Packet;
import net.meshmc.mesh.statics.StaticPackets;
import net.meshmc.mesh.util.GameVersion;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;

public interface CPacketChatMessage extends Packet.Client {
    static CPacketChatMessage create(String message) {
        return StaticPackets.createCPacketChatMessage(message);
    }

    String getMessage();
//    void setMessage(String message);

    @Nullable
    @GameVersion.OnlyOn(value = GameVersion.v1_19, minimumVersion = true)
    Instant getTimestamp();
    @GameVersion.OnlyOn(value = GameVersion.v1_19, minimumVersion = true)
    void setTimestamp(Instant value);

    @Nullable
    @GameVersion.OnlyOn(value = GameVersion.v1_19, minimumVersion = true)
    Long getSalt();
    @GameVersion.OnlyOn(value = GameVersion.v1_19, minimumVersion = true)
    void setSalt(long value);

    @Nullable
    @GameVersion.OnlyOn(value = GameVersion.v1_19, minimumVersion = true)
    Boolean getSignedPreview();
    @GameVersion.OnlyOn(value = GameVersion.v1_19, minimumVersion = true)
    void setSignedPreview();

    // TODO: 1.19 Signature
    // TODO: 1.19.1+ (Different)Signature + Acknowledgement
}
