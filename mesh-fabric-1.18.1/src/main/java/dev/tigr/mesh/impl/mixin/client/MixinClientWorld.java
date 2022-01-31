package dev.tigr.mesh.impl.mixin.client;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.event.MeshEvent;
import dev.tigr.mesh.event.events.TickEvent;
import dev.tigr.mesh.impl.mixininterface.entity.Entity;
import dev.tigr.mesh.impl.util.EntityIterable;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public abstract class MixinClientWorld extends MixinWorld implements dev.tigr.mesh.impl.mixininterface.world.ClientWorld {
    @Shadow public abstract Iterable<net.minecraft.entity.Entity> getEntities();

    @Inject(method = "tick", at = @At("HEAD"))
    public void preTick(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.WORLD, MeshEvent.Era.BEFORE));
    }

    @Inject(method = "tick", at = @At("RETURN"))
    public void postTick(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.WORLD, MeshEvent.Era.AFTER));
    }

    @Override
    public Iterable<Entity> getLoadedEntities() {
        return new EntityIterable(getEntities());
    }
}
