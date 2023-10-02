package net.meshmc.mesh.api.network.server;

import net.meshmc.mesh.api.advancement.Advancement;
import net.meshmc.mesh.api.advancement.AdvancementProgress;
import net.meshmc.mesh.api.network.Packet;
import net.meshmc.mesh.api.util.LocationIdentifier;

import java.util.Map;
import java.util.Set;

/**
 * Provides a mesh implementation for:
 * 1.18.1 - AdvancementUpdateS2CPacket
 * 1.12.2 - SPacketAdvancementInfo
 *
 * @author Makrennel 03/15/22
 */
public interface SPacketAdvancementUpdate extends Packet.Server {
    boolean isFirstSync();
    Map<LocationIdentifier, Advancement.Builder> getAdvancementsToAdd();
    Set<LocationIdentifier> getAdvancementsToRemove();
    Map<LocationIdentifier, AdvancementProgress> getProgressUpdates();
}
