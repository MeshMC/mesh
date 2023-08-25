package net.meshmc.mesh.impl.mixin.events.network;

import io.netty.channel.ChannelHandlerContext;
import net.meshmc.mesh.MeshAPI;
import net.meshmc.mesh.event.MeshEvent;
import net.meshmc.mesh.event.events.network.NetworkConnectionEvent;
import net.meshmc.mesh.impl.util.Mappings;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.PacketCallbacks;
import net.minecraft.network.packet.Packet;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ClientConnection.class, priority = Integer.MAX_VALUE)
public class MixinNetworkConnection {
    @Inject(method = "send(Lnet/minecraft/network/packet/Packet;Lnet/minecraft/network/PacketCallbacks;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/ClientConnection;isOpen()Z", shift = At.Shift.BEFORE), cancellable = true)
    public void onSendPre(Packet<?> packet, @Nullable PacketCallbacks packetCallbacks, CallbackInfo ci) {
        if(MeshAPI.getEventManager()
                .post(new NetworkConnectionEvent.sendPacket(MeshEvent.Era.BEFORE, Mappings.packet(packet)))
                .isCancelled()) ci.cancel();
    }

    @Inject(method = "send(Lnet/minecraft/network/packet/Packet;Lnet/minecraft/network/PacketCallbacks;)V", at = @At(value = "TAIL"))
    public void onSendPost(Packet<?> packet, @Nullable PacketCallbacks packetCallbacks, CallbackInfo ci) {
        MeshAPI.getEventManager()
                .post(new NetworkConnectionEvent.sendPacket(MeshEvent.Era.AFTER, Mappings.packet(packet)));
    }

    @Inject(method = "channelRead0*", at = @At("HEAD"), cancellable = true)
    public void receivedPre(ChannelHandlerContext channelHandlerContext, Packet<?> packet, CallbackInfo ci) {
        if(MeshAPI.getEventManager()
                .post(new NetworkConnectionEvent.channelRead0(MeshEvent.Era.BEFORE, channelHandlerContext, Mappings.packet(packet)))
                .isCancelled()) ci.cancel();
    }

    @Inject(method = "channelRead0*", at = @At("TAIL"))
    public void receivedPost(ChannelHandlerContext channelHandlerContext, Packet<?> packet, CallbackInfo ci) {
        MeshAPI.getEventManager()
                .post(new NetworkConnectionEvent.channelRead0(MeshEvent.Era.AFTER, channelHandlerContext, Mappings.packet(packet)));
    }
}
