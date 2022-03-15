package net.meshmc.mesh.impl.mixin.packet.server;

import net.meshmc.mesh.api.advancement.Advancement;
import net.meshmc.mesh.api.advancement.AdvancementProgress;
import net.meshmc.mesh.api.packet.server.SPacketAdvancementUpdate;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.meshmc.mesh.util.collections.MapWrapper;
import net.meshmc.mesh.util.collections.SetWrapper;
import net.minecraft.network.play.server.SPacketAdvancementInfo;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;
import java.util.Set;

@Mixin(SPacketAdvancementInfo.class)
public abstract class MixinSPacketAdvancementUpdate implements SPacketAdvancementUpdate {
    @Shadow private Map<ResourceLocation, net.minecraft.advancements.Advancement.Builder> advancementsToAdd;
    @Shadow private Set<ResourceLocation> advancementsToRemove;
    @Shadow private Map<ResourceLocation, net.minecraft.advancements.AdvancementProgress> progressUpdates;

    @Override @Shadow public abstract boolean isFirstSync();

    @Override
    public Map<LocationIdentifier, Advancement.Builder> getAdvancementsToAdd() {
        return new MapWrapper<>(advancementsToAdd);
    }

    @Override
    public Set<LocationIdentifier> getAdvancementsToRemove() {
        return new SetWrapper<>(advancementsToRemove);
    }

    @Override
    public Map<LocationIdentifier, AdvancementProgress> getProgressUpdates() {
        return new MapWrapper<>(progressUpdates);
    }
}
