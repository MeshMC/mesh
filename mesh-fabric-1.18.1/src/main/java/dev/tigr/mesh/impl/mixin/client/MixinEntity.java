package dev.tigr.mesh.impl.mixin.client;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.events.MeshEvent;
import dev.tigr.mesh.events.client.TickEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class MixinEntity {
    @Shadow private int id;

    @Inject(method = "tick", at = @At("HEAD"))
    public void preTick(CallbackInfo ci) {
        if(MinecraftClient.getInstance().world == null) return;
        if(MinecraftClient.getInstance().world.getEntityById(id) instanceof PlayerEntity)
            Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.PLAYER, MeshEvent.Era.BEFORE));
    }

    @Inject(method = "tick", at = @At("RETURN"))
    public void postTick(CallbackInfo ci) {
        if(MinecraftClient.getInstance().world == null) return;
        if(MinecraftClient.getInstance().world.getEntityById(id) instanceof PlayerEntity)
            Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.PLAYER, MeshEvent.Era.AFTER));
    }
}
