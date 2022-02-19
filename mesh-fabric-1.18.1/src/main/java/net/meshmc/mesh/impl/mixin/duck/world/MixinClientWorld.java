package net.meshmc.mesh.impl.mixin.duck.world;

import net.meshmc.mesh.impl.mixininterface.entity.Entity;
import net.meshmc.mesh.impl.mixininterface.world.ClientWorld;
import net.meshmc.mesh.impl.conversion.EntityIterable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(net.minecraft.client.world.ClientWorld.class)
public abstract class MixinClientWorld extends MixinWorld implements ClientWorld {
    @Shadow public abstract Iterable<net.minecraft.entity.Entity> getEntities();

    @Override
    public Iterable<Entity> getLoadedEntities() {
        return new EntityIterable(getEntities());
    }
}
