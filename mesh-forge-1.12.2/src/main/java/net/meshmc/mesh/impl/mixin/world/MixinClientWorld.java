package net.meshmc.mesh.impl.mixin.world;

import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.world.ClientWorld;
import net.meshmc.mesh.util.collections.IterableWrapper;
import net.minecraft.client.multiplayer.WorldClient;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WorldClient.class)
public class MixinClientWorld extends MixinWorld implements ClientWorld {
    @Override
    public Iterable<Entity> getLoadedEntities() {
        return new IterableWrapper<>(loadedEntityList);
    }
}
