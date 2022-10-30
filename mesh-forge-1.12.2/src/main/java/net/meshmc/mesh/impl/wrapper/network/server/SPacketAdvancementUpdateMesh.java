package net.meshmc.mesh.impl.wrapper.network.server;

import net.meshmc.mesh.api.advancement.Advancement;
import net.meshmc.mesh.api.advancement.AdvancementProgress;
import net.meshmc.mesh.api.network.server.SPacketAdvancementUpdate;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.meshmc.mesh.util.collections.MapWrapper;
import net.meshmc.mesh.util.collections.SetWrapper;
import net.minecraft.network.play.server.SPacketAdvancementInfo;

import java.util.Map;
import java.util.Set;

public class SPacketAdvancementUpdateMesh extends PacketMesh.Server<SPacketAdvancementInfo> implements SPacketAdvancementUpdate {
    public SPacketAdvancementUpdateMesh(SPacketAdvancementInfo value) {
        super(value);
    }

    @Override
    public S2C getType() {
        return S2C.AdvancementUpdate;
    }

    @Override
    public boolean isFirstSync() {
        return getMeshValue().isFirstSync();
    }

    @Override
    public Map<LocationIdentifier, Advancement.Builder> getAdvancementsToAdd() {
        return new MapWrapper<>(getMeshValue().getAdvancementsToAdd());
    }

    @Override
    public Set<LocationIdentifier> getAdvancementsToRemove() {
        return new SetWrapper<>(getMeshValue().getAdvancementsToRemove());
    }

    @Override
    public Map<LocationIdentifier, AdvancementProgress> getProgressUpdates() {
        return new MapWrapper<>(getMeshValue().getProgressUpdates());
    }
}
