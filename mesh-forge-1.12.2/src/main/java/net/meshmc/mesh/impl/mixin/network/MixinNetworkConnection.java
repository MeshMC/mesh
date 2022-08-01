package net.meshmc.mesh.impl.mixin.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.meshmc.mesh.impl.util.duck.NetworkConnectionDuck;
import net.meshmc.mesh.util.math.MathHelper;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public class MixinNetworkConnection implements NetworkConnectionDuck {
    private int
            packetsReceivedCounter = 0,
            packetsSentCounter = 0,
            ticks = 0;

    private float
            averagePacketsReceived = 0f,
            averagePacketsSent = 0f;

    private void updateStats() {
        this.averagePacketsSent = MathHelper.lerp(0.75F, (float)this.packetsSentCounter, this.averagePacketsSent);
        this.averagePacketsReceived = MathHelper.lerp(0.75F, (float)this.packetsReceivedCounter, this.averagePacketsReceived);
        this.packetsSentCounter = 0;
        this.packetsReceivedCounter = 0;
    }

    @Inject(method = "channelRead0(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/Packet;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/Packet;processPacket(Lnet/minecraft/network/INetHandler;)V", shift = At.Shift.AFTER))
    public void incrementPacketsReceivedCounter(ChannelHandlerContext p_channelRead0_1_, Packet<?> p_channelRead0_2_, CallbackInfo ci) {
        ++packetsReceivedCounter;
    }

    @Inject(method = "dispatchPacket", at = @At(value = "INVOKE", target = "Lio/netty/util/Attribute;get()Ljava/lang/Object;", shift = At.Shift.AFTER))
    public void incrementPacketsSentCounter(Packet<?> inPacket, GenericFutureListener<? extends Future<? super Void>>[] futureListeners, CallbackInfo ci) {
        ++packetsSentCounter;
    }

    @Inject(method = "processReceivedPackets", at = @At("TAIL"))
    public void updateStats(CallbackInfo ci) {
        if(ticks++ % 20 == 0) updateStats();
    }

    @Override
    public int getPacketsReceivedCounter() {
        return packetsReceivedCounter;
    }

    @Override
    public void setPacketsReceivedCounter(int value) {
        packetsReceivedCounter = value;
    }

    @Override
    public int getPacketsSentCounter() {
        return packetsSentCounter;
    }

    @Override
    public void setPacketsSentCounter(int value) {
        packetsSentCounter = value;
    }

    @Override
    public float getAveragePacketsReceived() {
        return averagePacketsReceived;
    }

    @Override
    public float getAveragePacketsSent() {
        return averagePacketsSent;
    }
}
