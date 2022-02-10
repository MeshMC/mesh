package dev.tigr.mesh.impl.mixin.duck.world;

import dev.tigr.mesh.impl.mixininterface.entity.Entity;
import dev.tigr.mesh.impl.mixininterface.world.ClientWorld;
import dev.tigr.mesh.impl.wrapper.util.EntityIterable;
import net.minecraft.client.multiplayer.WorldClient;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WorldClient.class)
public class MixinClientWorld extends MixinWorld implements ClientWorld {
    @Override
    public Iterable<Entity> getLoadedEntities() {
        return new EntityIterable(loadedEntityList);
    }
}
