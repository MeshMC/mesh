package net.meshmc.mesh.impl.mixin.packet.server;

import net.meshmc.mesh.api.advancement.Advancement;
import net.meshmc.mesh.api.advancement.AdvancementProgress;
import net.meshmc.mesh.api.packet.server.SPacketAdvancementUpdate;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.meshmc.mesh.util.collections.MapWrapper;
import net.meshmc.mesh.util.collections.SetWrapper;
import net.minecraft.network.packet.s2c.play.AdvancementUpdateS2CPacket;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;
import java.util.Set;

@Mixin(AdvancementUpdateS2CPacket.class)
public abstract class MixinSPacketAdvancementUpdate implements SPacketAdvancementUpdate {
    @Shadow public abstract boolean shouldClearCurrent();
    @Shadow @Final private Set<Identifier> toRemove;
    @Shadow @Final private Map<Identifier, net.minecraft.advancement.Advancement.Task> toEarn;
    @Shadow @Final private Map<Identifier, net.minecraft.advancement.AdvancementProgress> toSetProgress;

    @Override
    public boolean isFirstSync() {
        return shouldClearCurrent();
    }

    @Override
    public Map<LocationIdentifier, Advancement.Builder> getAdvancementsToAdd() {
        return new MapWrapper<>(toEarn);
    }

    @Override
    public Set<LocationIdentifier> getAdvancementsToRemove() {
        return new SetWrapper<>(toRemove);
    }

    @Override
    public Map<LocationIdentifier, AdvancementProgress> getProgressUpdates() {
    return new MapWrapper<>(toSetProgress);
    }
}
