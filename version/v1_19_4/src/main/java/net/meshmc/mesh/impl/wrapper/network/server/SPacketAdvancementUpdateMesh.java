package net.meshmc.mesh.impl.wrapper.network.server;

import net.meshmc.mesh.api.advancement.Advancement;
import net.meshmc.mesh.api.advancement.AdvancementProgress;
import net.meshmc.mesh.api.network.server.SPacketAdvancementUpdate;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.meshmc.mesh.util.collections.MapWrapper;
import net.meshmc.mesh.util.collections.SetWrapper;
import net.minecraft.network.packet.s2c.play.AdvancementUpdateS2CPacket;

import java.util.Map;
import java.util.Set;

public class SPacketAdvancementUpdateMesh extends PacketMesh.Server<AdvancementUpdateS2CPacket> implements SPacketAdvancementUpdate {
    public SPacketAdvancementUpdateMesh(AdvancementUpdateS2CPacket value) {
        super(value);
    }

    @Override
    public S2C getType() {
        return S2C.AdvancementUpdate;
    }

    @Override
    public boolean isFirstSync() {
        return getMeshValue().shouldClearCurrent();
    }

    @Override
    public Map<LocationIdentifier, Advancement.Builder> getAdvancementsToAdd() {
        return new MapWrapper<>(getMeshValue().getAdvancementsToEarn());
    }

    @Override
    public Set<LocationIdentifier> getAdvancementsToRemove() {
        return new SetWrapper<>(getMeshValue().getAdvancementIdsToRemove());
    }

    @Override
    public Map<LocationIdentifier, AdvancementProgress> getProgressUpdates() {
        return new MapWrapper<>(getMeshValue().getAdvancementsToProgress());
    }
}
