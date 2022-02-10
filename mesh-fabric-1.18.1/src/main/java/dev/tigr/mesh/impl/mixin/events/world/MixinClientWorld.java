package dev.tigr.mesh.impl.mixin.events.world;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.event.MeshEvent;
import dev.tigr.mesh.event.events.client.TickEvent;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public abstract class MixinClientWorld {
    @Inject(method = "tick", at = @At("HEAD"))
    public void preTick(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.WORLD, MeshEvent.Era.BEFORE));
    }

    @Inject(method = "tick", at = @At("RETURN"))
    public void postTick(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.WORLD, MeshEvent.Era.AFTER));
    }
}
