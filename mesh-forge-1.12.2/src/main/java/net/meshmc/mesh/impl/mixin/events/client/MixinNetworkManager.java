package net.meshmc.mesh.impl.mixin.events.client;

import io.netty.channel.ChannelHandlerContext;
import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.event.MeshEvent;
import net.meshmc.mesh.event.events.client.PacketEvent;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public class MixinNetworkManager {
    @Inject(method = "sendPacket*", at = @At("HEAD"), cancellable = true)
    public void sendPre(Packet<?> packet, CallbackInfo ci) {
        if(Mesh.getMesh().getEventManager().post(new PacketEvent.Sent(packet, MeshEvent.Era.BEFORE)).isCancelled()) ci.cancel();
    }

    @Inject(method = "sendPacket*", at = @At("RETURN"))
    public void sendPost(Packet<?> packet, CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new PacketEvent.Sent(packet, MeshEvent.Era.AFTER));
    }

    @Inject(method = "channelRead0*", at = @At("HEAD"), cancellable = true)
    private void receivePre(ChannelHandlerContext context, Packet<?> packet, CallbackInfo ci) {
        if(Mesh.getMesh().getEventManager().post(new PacketEvent.Received(packet, MeshEvent.Era.BEFORE)).isCancelled()) ci.cancel();
    }

    @Inject(method = "channelRead0*", at = @At("RETURN"))
    private void receivePost(ChannelHandlerContext context, Packet<?> packet, CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new PacketEvent.Received(packet, MeshEvent.Era.AFTER));
    }
}
