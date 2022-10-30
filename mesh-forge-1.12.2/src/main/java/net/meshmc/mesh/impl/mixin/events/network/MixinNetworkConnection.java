package net.meshmc.mesh.impl.mixin.events.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.event.MeshEvent;
import net.meshmc.mesh.event.events.network.NetworkConnectionEvent;
import net.meshmc.mesh.impl.util.Mappings;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = NetworkManager.class, priority = Integer.MAX_VALUE)
public class MixinNetworkConnection {
    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/NetworkManager;isChannelOpen()Z", shift = At.Shift.BEFORE), cancellable = true)
    public void sendPacketPre(Packet<?> packet, CallbackInfo ci) {
        if(Mesh.getMesh().getEventManager()
                .post(new NetworkConnectionEvent.sendPacket(MeshEvent.Era.BEFORE, Mappings.packet(packet), null))
                .isCancelled()) ci.cancel();
    }

    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At(value = "TAIL"))
    public void sendPacketPost(Packet<?> packet, CallbackInfo ci) {
        Mesh.getMesh().getEventManager()
                .post(new NetworkConnectionEvent.sendPacket(MeshEvent.Era.AFTER, Mappings.packet(packet), null));
    }

    // As far as I can tell the array listeners are never actually used.
    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;Lio/netty/util/concurrent/GenericFutureListener;[Lio/netty/util/concurrent/GenericFutureListener;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/NetworkManager;isChannelOpen()Z", shift = At.Shift.BEFORE), cancellable = true)
    public void sendPacketIIPre(Packet<?> packetIn, GenericFutureListener<? extends Future<? super Void>> listener, GenericFutureListener<? extends Future<? super Void>>[] listeners, CallbackInfo ci) {
        if(Mesh.getMesh().getEventManager()
                .post(new NetworkConnectionEvent.sendPacket(MeshEvent.Era.BEFORE, Mappings.packet(packetIn), listener))
                .isCancelled()) ci.cancel();
    }

    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;Lio/netty/util/concurrent/GenericFutureListener;[Lio/netty/util/concurrent/GenericFutureListener;)V", at = @At(value = "TAIL"))
    public void sendPacketIIPost(Packet<?> packetIn, GenericFutureListener<? extends Future<? super Void>> listener, GenericFutureListener<? extends Future<? super Void>>[] listeners, CallbackInfo ci) {
        Mesh.getMesh().getEventManager()
                .post(new NetworkConnectionEvent.sendPacket(MeshEvent.Era.AFTER, Mappings.packet(packetIn), listener));
    }

    @Inject(method = "channelRead0*", at = @At("HEAD"), cancellable = true)
    public void receivedPre(ChannelHandlerContext channelHandlerContext, Packet<?> packet, CallbackInfo ci) {
        if(Mesh.getMesh().getEventManager()
                .post(new NetworkConnectionEvent.channelRead0(MeshEvent.Era.BEFORE, channelHandlerContext, Mappings.packet(packet)))
                .isCancelled()) ci.cancel();
    }

    @Inject(method = "channelRead0*", at = @At("TAIL"))
    public void receivedPost(ChannelHandlerContext channelHandlerContext, Packet<?> packet, CallbackInfo ci) {
        Mesh.getMesh().getEventManager()
                .post(new NetworkConnectionEvent.channelRead0(MeshEvent.Era.AFTER, channelHandlerContext, Mappings.packet(packet)));
    }
}
