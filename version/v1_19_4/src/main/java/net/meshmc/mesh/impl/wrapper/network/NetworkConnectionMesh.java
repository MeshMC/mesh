package net.meshmc.mesh.impl.wrapper.network;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.meshmc.mesh.api.network.NetworkConnection;
import net.meshmc.mesh.api.network.Packet;
import net.meshmc.mesh.api.network.PacketListener;
import net.meshmc.mesh.impl.mixin.accessors.network.ClientConnectionAccessor;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.util.network.NetworkDirection;
import net.meshmc.mesh.util.network.NetworkState;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.encryption.NetworkEncryptionException;
import net.minecraft.network.encryption.NetworkEncryptionUtils;

import javax.crypto.SecretKey;
import java.net.SocketAddress;

public class NetworkConnectionMesh extends NetworkConnection<ClientConnection> {
    public NetworkConnectionMesh(ClientConnection value) {
        super(value);
    }

    @Override
    public NetworkDirection getNetworkDirection() {
        return MeshEnum.networkDirection(getMeshValue().getSide());
    }

    @Override
    public void setNetworkDirection(NetworkDirection networkDirection) {
        ((ClientConnectionAccessor) getMeshValue()).setNetworkSide(MCEnum.networkDirection(networkDirection));
    }

    @Override
    public Channel getChannel() {
        return ((ClientConnectionAccessor) getMeshValue()).getChannel();
    }

    @Override
    public void setChannel(Channel channel) {
        ((ClientConnectionAccessor) getMeshValue()).setChannel(channel);
    }

    @Override
    public SocketAddress getAddress() {
        return getMeshValue().getAddress();
    }

    @Override
    public void setAddress(SocketAddress address) {
        ((ClientConnectionAccessor) getMeshValue()).setAddress(address);
    }

    @Override
    public PacketListener getPacketListener() {
        return new PacketListenerMesh(getMeshValue().getPacketListener());
    }

    @Override
    public boolean getEncrypted() {
        return getMeshValue().isEncrypted();
    }

    @Override
    public void setEncrypted(boolean value) {
        ((ClientConnectionAccessor) getMeshValue()).setEncrypted(value);
    }

    @Override
    public boolean getDisconnected() {
        return ((ClientConnectionAccessor) getMeshValue()).getDisconnected();
    }

    @Override
    public void setDisconnected(boolean value) {
        ((ClientConnectionAccessor) getMeshValue()).setDisconnected(value);
    }

    @Override
    public int getPacketsReceivedCounter() {
        return ((ClientConnectionAccessor) getMeshValue()).getPacketsReceivedCounter();
    }

    @Override
    public void setPacketsReceivedCounter(int value) {
        ((ClientConnectionAccessor) getMeshValue()).setPacketsReceivedCounter(value);
    }

    @Override
    public int getPacketsSentCounter() {
        return ((ClientConnectionAccessor) getMeshValue()).getPacketsSentCounter();
    }

    @Override
    public void setPacketsSentCounter(int value) {
        ((ClientConnectionAccessor) getMeshValue()).setPacketsSentCounter(value);
    }

    @Override
    public float getAveragePacketsReceived() {
        return ((ClientConnectionAccessor) getMeshValue()).getAveragePacketsReceived();
    }

    @Override
    public float getAveragePacketsSent() {
        return ((ClientConnectionAccessor) getMeshValue()).getAveragePacketsSent();
    }

    @Override
    public void channelActive(ChannelHandlerContext context) throws Exception {
        getMeshValue().channelActive(context);
    }

    @Override
    public void setState(NetworkState networkState) {
        getMeshValue().setState(MCEnum.networkState(networkState));
    }

    @Override
    public void channelInactive(ChannelHandlerContext context) {
        getMeshValue().channelInactive(context);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable ex) {
        getMeshValue().exceptionCaught(context, ex);
    }

    @Override
    public void channelRead(ChannelHandlerContext context, Packet packet) {
        ((ClientConnectionAccessor) getMeshValue()).channelRead(context, ((PacketMesh<?>) packet).getMeshValue());
    }

    @Override
    public void setPacketListener(PacketListener listener) {
        getMeshValue().setPacketListener(((PacketListenerMesh) listener).getMeshValue());
    }

    @Override
    public void sendPacket(Packet packet) {
        getMeshValue().send(((PacketMesh<?>) packet).getMeshValue());
    }

    @Override
    public void sendPacket(Packet packet, GenericFutureListener<? extends Future<? super Void>> callback) {
        // TODO:
//        getMeshValue().send(((PacketMesh<?>) packet).getMeshValue(), callback);
    }

    @Override
    public void sendPacketImmediately(Packet packet, GenericFutureListener<? extends Future<? super Void>>[] callbacks) {
        if(callbacks == null) throw new NullPointerException("callbacks is null");
        for(var call: callbacks) {
            if(call == null) continue;
            // TODO: Why'd they have to change to a MC specific callback -_-
//            ((ClientConnectionAccessor) getMeshValue()).sendImmediately(((PacketMesh<?>) packet).getMeshValue(), call);
            break;
        }
    }

    @Override
    public NetworkState getState() {
        return MeshEnum.networkState(((ClientConnectionAccessor) getMeshValue()).getNetworkState());
    }

    @Override
    public void sendQueuedPackets() {
        ((ClientConnectionAccessor) getMeshValue()).sendQueuedPackets();
    }

    @Override
    public void tick() {
        getMeshValue().tick();
    }

    @Override
    public boolean isLocalChannel() {
        return getMeshValue().isLocal();
    }

    @Override
    public void enableEncryption(SecretKey key) {
        try {
            getMeshValue().setupEncryption(
                    NetworkEncryptionUtils.cipherFromKey(2, key),
                    NetworkEncryptionUtils.cipherFromKey(1, key)
            );
        } catch(NetworkEncryptionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isEncrypted() {
        return getMeshValue().isEncrypted();
    }

    @Override
    public boolean isChannelOpen() {
        return getMeshValue().isOpen();
    }

    @Override
    public boolean hasNoChannel() {
        return getMeshValue().isChannelAbsent();
    }

    @Override
    public void disableAutoRead() {
        getMeshValue().disableAutoRead();
    }

    @Override
    public void setCompressionThreshold(int value, boolean rejectsBadPackets) {
        getMeshValue().setCompressionThreshold(value, rejectsBadPackets);
    }

    @Override
    public void handleDisconnection() {
        getMeshValue().handleDisconnection();
    }
}
