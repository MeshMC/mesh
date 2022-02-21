package net.meshmc.mesh.impl.mixin.events.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.event.MeshEvent;
import net.meshmc.mesh.event.events.client.PacketEvent;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class MixinClientConnection {
    @Inject(method = "send(Lnet/minecraft/network/Packet;Lio/netty/util/concurrent/GenericFutureListener;)V", at = @At("HEAD"), cancellable = true)
    public void sendPre(Packet<?> packet, GenericFutureListener<? extends Future<? super Void>> callback, CallbackInfo ci) {
        if(Mesh.getMesh().getEventManager().post(new PacketEvent.Sent(packet, MeshEvent.Era.BEFORE)).isCancelled()) ci.cancel();
    }

    @Inject(method = "send(Lnet/minecraft/network/Packet;Lio/netty/util/concurrent/GenericFutureListener;)V", at = @At("RETURN"))
    public void sendPost(Packet<?> packet, GenericFutureListener<? extends Future<? super Void>> callback, CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new PacketEvent.Sent(packet, MeshEvent.Era.AFTER));
    }

    @Inject(method = "channelRead0*", at = @At("HEAD"), cancellable = true)
    public void receivedPre(ChannelHandlerContext channelHandlerContext, Packet<?> packet, CallbackInfo ci) {
        if(Mesh.getMesh().getEventManager().post(new PacketEvent.Received(packet, MeshEvent.Era.BEFORE)).isCancelled()) ci.cancel();
    }

    @Inject(method = "channelRead0*", at = @At("RETURN"))
    public void receivedPost(ChannelHandlerContext channelHandlerContext, Packet<?> packet, CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new PacketEvent.Received(packet, MeshEvent.Era.AFTER));
    }
}
