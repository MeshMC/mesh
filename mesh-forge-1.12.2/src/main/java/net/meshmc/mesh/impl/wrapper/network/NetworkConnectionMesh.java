package net.meshmc.mesh.impl.wrapper.network;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.meshmc.mesh.api.network.NetworkConnection;
import net.meshmc.mesh.api.network.PacketListener;
import net.meshmc.mesh.impl.mixin.accessors.network.NetworkManagerAccessor;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.impl.util.duck.NetworkConnectionDuck;
import net.meshmc.mesh.util.network.NetworkDirection;
import net.meshmc.mesh.util.network.NetworkState;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;

import javax.annotation.Nullable;
import javax.crypto.SecretKey;
import java.net.SocketAddress;

public class NetworkConnectionMesh extends NetworkConnection<NetworkManager> {
    public NetworkConnectionMesh(NetworkManager value) {
        super(value);
    }

    @Override
    public NetworkDirection getNetworkDirection() {
        return MeshEnum.networkDirection(getMeshValue().getDirection());
    }

    @Override
    public void setNetworkDirection(NetworkDirection networkDirection) {
        ((NetworkManagerAccessor) getMeshValue()).setDirection(MCEnum.networkDirection(networkDirection));
    }

    @Override
    public Channel getChannel() {
        return getMeshValue().channel();
    }

    @Override
    public void setChannel(Channel channel) {
        ((NetworkManagerAccessor) getMeshValue()).setChannel(channel);
    }

    @Override
    public SocketAddress getAddress() {
        return getMeshValue().getRemoteAddress();
    }

    @Override
    public void setAddress(SocketAddress address) {
        ((NetworkManagerAccessor) getMeshValue()).setSocketAddress(address);
    }

    @Override
    public PacketListener getPacketListener() {
        return new PacketListenerMesh(getMeshValue().getNetHandler());
    }

    @Override
    public boolean getEncrypted() {
        return getMeshValue().isEncrypted();
    }

    @Override
    public void setEncrypted(boolean value) {
        ((NetworkManagerAccessor) getMeshValue()).setEncrypted(value);
    }

    @Override
    public boolean getDisconnected() {
        return ((NetworkManagerAccessor) getMeshValue()).getDisconnected();
    }

    @Override
    public void setDisconnected(boolean value) {
        ((NetworkManagerAccessor) getMeshValue()).setDisconnected(value);
    }

    @Override
    public int getPacketsReceivedCounter() {
        return ((NetworkConnectionDuck) getMeshValue()).getPacketsReceivedCounter();
    }

    @Override
    public void setPacketsReceivedCounter(int value) {
        ((NetworkConnectionDuck) getMeshValue()).setPacketsReceivedCounter(value);
    }

    @Override
    public int getPacketsSentCounter() {
        return ((NetworkConnectionDuck) getMeshValue()).getPacketsSentCounter();
    }

    @Override
    public void setPacketsSentCounter(int value) {
        ((NetworkConnectionDuck) getMeshValue()).setPacketsSentCounter(value);
    }

    @Override
    public float getAveragePacketsReceived() {
        return ((NetworkConnectionDuck) getMeshValue()).getAveragePacketsReceived();
    }

    @Override
    public float getAveragePacketsSent() {
        return ((NetworkConnectionDuck) getMeshValue()).getAveragePacketsSent();
    }

    @Override
    public void channelActive(ChannelHandlerContext context) throws Exception {
        getMeshValue().channelActive(context);
    }

    @Override
    public void setState(NetworkState networkState) {
        getMeshValue().setConnectionState(MCEnum.networkState(networkState));
    }

    @Override
    public void channelInactive(ChannelHandlerContext context) {
        try {
            getMeshValue().channelInactive(context);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable ex) {
        try {
            getMeshValue().exceptionCaught(context, ex);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext context, Object packet) {
        try {
            ((NetworkManagerAccessor) getMeshValue()).channelRead(context, (Packet<?>) packet);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setPacketListener(PacketListener listener) {
        getMeshValue().setNetHandler(((PacketListenerMesh) listener).getMeshValue());
    }

    @Override
    public void sendPacket(Object packet) {
        getMeshValue().sendPacket((Packet<?>) packet);
    }

    @Override
    public void sendPacket(Object packet, GenericFutureListener<? extends Future<? super Void>> callback) {
        getMeshValue().sendPacket((Packet<?>) packet, callback);
    }

    @Override
    public void sendPacketImmediately(Object packet, @Nullable GenericFutureListener<? extends Future<? super Void>>[] callbacks) {
        ((NetworkManagerAccessor) getMeshValue()).dispatchPacket((Packet<?>) packet, callbacks);
    }

    @Override
    public NetworkState getState() {
        return MeshEnum.networkState(getMeshValue().channel().attr(NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get());
    }

    @Override
    public void sendQueuedPackets() {
        ((NetworkManagerAccessor) getMeshValue()).flushOutboundQueue();
    }

    @Override
    public void tick() {
        getMeshValue().processReceivedPackets();
    }

    @Override
    public boolean isLocalChannel() {
        return getMeshValue().isLocalChannel();
    }

    @Override
    public void enableEncryption(SecretKey key) {
        getMeshValue().enableEncryption(key);
    }

    @Override
    public boolean isEncrypted() {
        return getMeshValue().isEncrypted();
    }

    @Override
    public boolean isChannelOpen() {
        return getMeshValue().isChannelOpen();
    }

    @Override
    public boolean hasNoChannel() {
        return getMeshValue().hasNoChannel();
    }

    @Override
    public void disableAutoRead() {
        getMeshValue().disableAutoRead();
    }

    @Override
    public void setCompressionThreshold(int value, boolean rejectsBadPackets) {
        getMeshValue().setCompressionThreshold(value);
    }

    @Override
    public void handleDisconnection() {
        getMeshValue().handleDisconnection();
    }
}
