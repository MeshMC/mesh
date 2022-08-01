package net.meshmc.mesh.impl.mixin.accessors.network;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import javax.annotation.Nullable;
import java.net.SocketAddress;

@Mixin(NetworkManager.class)
public interface NetworkManagerAccessor {
    @Accessor("direction")
    void setDirection(EnumPacketDirection direction);

    @Accessor("channel")
    void setChannel(Channel channel);

    @Accessor("socketAddress")
    void setSocketAddress(SocketAddress socketAddress);

    @Accessor("isEncrypted")
    void setEncrypted(boolean value);

    @Accessor("disconnected")
    boolean getDisconnected();

    @Accessor("disconnected")
    void setDisconnected(boolean value);

    @Invoker("channelRead0")
    void channelRead(ChannelHandlerContext context, Packet<?> packet) throws Exception;

    @Invoker("dispatchPacket")
    void dispatchPacket(final Packet<?> packet, @Nullable final GenericFutureListener<? extends Future<? super Void >>[] futureListeners);

    @Invoker("flushOutboundQueue")
    void flushOutboundQueue();
}
