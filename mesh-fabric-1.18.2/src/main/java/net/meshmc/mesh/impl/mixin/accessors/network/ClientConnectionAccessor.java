package net.meshmc.mesh.impl.mixin.accessors.network;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.NetworkSide;
import net.minecraft.network.NetworkState;
import net.minecraft.network.Packet;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.net.SocketAddress;

@Mixin(ClientConnection.class)
public interface ClientConnectionAccessor {
    @Accessor("side")
    void setNetworkSide(NetworkSide networkSide);
    
    @Accessor("channel")
    Channel getChannel();
    
    @Accessor("channel")
    void setChannel(Channel channel);
    
    @Accessor("address")
    void setAddress(SocketAddress socketAddress);
    
    @Accessor("encrypted")
    void setEncrypted(boolean value);

    @Accessor("disconnected")
    boolean getDisconnected();

    @Accessor("packetsReceivedCounter")
    int getPacketsReceivedCounter();

    @Accessor("packetsReceivedCounter")
    void setPacketsReceivedCounter(int value);

    @Accessor("packetsSentCounter")
    int getPacketsSentCounter();

    @Accessor("packetsSentCounter")
    void setPacketsSentCounter(int value);

    @Accessor("averagePacketsReceived")
    float getAveragePacketsReceived();

    @Accessor("averagePacketsSent")
    float getAveragePacketsSent();
    
    @Accessor("disconnected")
    void setDisconnected(boolean value);
    
    @Invoker("channelRead0")
    void channelRead(ChannelHandlerContext context, Packet<?> packet);
    
    @Invoker("sendImmediately")
    void sendImmediately(Packet<?> packet, @Nullable GenericFutureListener<? extends Future<? super Void>> callback);

    @Invoker("getState")
    NetworkState getNetworkState();

    @Invoker("sendQueuedPackets")
    void sendQueuedPackets();
}
