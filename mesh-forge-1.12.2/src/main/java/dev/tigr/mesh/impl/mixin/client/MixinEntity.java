package dev.tigr.mesh.impl.mixin.client;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.events.MeshEvent;
import dev.tigr.mesh.events.client.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class MixinEntity {
    @Shadow private int entityId;

    @Inject(method = "onUpdate", at = @At("HEAD"))
    public void preTick(CallbackInfo ci) {
        if(Minecraft.getMinecraft().world == null) return;
        if(Minecraft.getMinecraft().world.getEntityByID(entityId) instanceof EntityPlayer)
            Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.PLAYER, MeshEvent.Era.BEFORE));
    }

    @Inject(method = "onUpdate", at = @At("RETURN"))
    public void postTick(CallbackInfo ci) {
        if(Minecraft.getMinecraft().world == null) return;
        if(Minecraft.getMinecraft().world.getEntityByID(entityId) instanceof EntityPlayer)
            Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.PLAYER, MeshEvent.Era.AFTER));
    }
}
