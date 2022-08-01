package net.meshmc.mesh.api.network;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.meshmc.mesh.api.AbstractMesh;
import net.meshmc.mesh.util.network.NetworkDirection;
import net.meshmc.mesh.util.network.NetworkState;

import javax.annotation.Nullable;
import javax.crypto.SecretKey;
import java.net.SocketAddress;

public abstract class NetworkConnection<T> extends AbstractMesh<T> {
    public NetworkConnection(T value) {
        super(value);
    }

    public abstract NetworkDirection getNetworkDirection();
    public abstract void setNetworkDirection(NetworkDirection networkDirection);

    public abstract Channel getChannel();
    public abstract void setChannel(Channel channel);

    public abstract SocketAddress getAddress();
    public abstract void setAddress(SocketAddress address);

    public abstract PacketListener getPacketListener();

    //TODO: Text disconnectReason

    public abstract boolean getEncrypted();
    public abstract void setEncrypted(boolean value);

    public abstract boolean getDisconnected();
    public abstract void setDisconnected(boolean value);

    public abstract int getPacketsReceivedCounter();
    public abstract void setPacketsReceivedCounter(int value);

    public abstract int getPacketsSentCounter();
    public abstract void setPacketsSentCounter(int value);

    public abstract float getAveragePacketsReceived();
    public abstract float getAveragePacketsSent();

    public abstract void channelActive(ChannelHandlerContext context) throws Exception;

    public abstract void setState(NetworkState networkState);

    public abstract void channelInactive(ChannelHandlerContext context);

    public abstract void exceptionCaught(ChannelHandlerContext context, Throwable ex);

    public abstract void channelRead(ChannelHandlerContext context, Object packet);

    public abstract void setPacketListener(PacketListener listener);

    public abstract void sendPacket(Object packet);

    public abstract void sendPacket(Object packet, @Nullable GenericFutureListener<? extends Future<? super Void>> callback);

    public abstract void sendPacketImmediately(Object packet, @Nullable GenericFutureListener<? extends Future<? super Void>>[] callbacks);

    public abstract NetworkState getState();

    public abstract void sendQueuedPackets();

    public abstract void tick();

    //TODO: public abstract void disconnectChannel(Text disconnectReason);

    public abstract boolean isLocalChannel();

    public abstract void enableEncryption(SecretKey key);

    public abstract boolean isEncrypted();

    public abstract boolean isChannelOpen();

    public abstract boolean hasNoChannel();

    //TODO: public abstract Text getDisconnectReason();

    public abstract void disableAutoRead();

    /** @param rejectsBadPackets on 1.18 */
    public abstract void setCompressionThreshold(int value, boolean rejectsBadPackets);

    public abstract void handleDisconnection();

    public interface QueuedPacket {
        static void create(Object packet) {
        }

        static void create(Object packet, GenericFutureListener<? extends Future<? super Void>> callbacks) {
        }

        Object getPacket();
        void setPacket(Object packet);

        @Nullable
        GenericFutureListener<? extends Future<? super Void>>[] getCallbacks();
        void setCallbacks(@Nullable GenericFutureListener<? extends Future<? super Void>>[] callbacks);
    }
}
