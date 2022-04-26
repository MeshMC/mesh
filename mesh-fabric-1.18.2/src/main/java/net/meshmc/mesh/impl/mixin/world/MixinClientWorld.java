package net.meshmc.mesh.impl.mixin.world;

import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.world.ClientWorld;
import net.meshmc.mesh.util.collections.IterableWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(net.minecraft.client.world.ClientWorld.class)
public abstract class MixinClientWorld extends MixinWorld implements ClientWorld {
    @Shadow public abstract Iterable<net.minecraft.entity.Entity> getEntities();

    @Override
    public Iterable<Entity> getLoadedEntities() {
        return new IterableWrapper<>(getEntities());
    }
}
