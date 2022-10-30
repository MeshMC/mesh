package net.meshmc.mesh.event.events.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.meshmc.mesh.api.network.Packet;
import net.meshmc.mesh.event.MeshEvent;
import org.jetbrains.annotations.Nullable;

public class NetworkConnectionEvent extends MeshEvent {
    public NetworkConnectionEvent(String name, Era era) {
        super(name, era);
    }

    public static class channelRead0 extends NetworkConnectionEvent {
        public final ChannelHandlerContext channelHandlerContext;
        public final Packet packet;

        public channelRead0(Era era, ChannelHandlerContext channelHandlerContext, Packet packet) {
            super("channelRead0", era);
            this.channelHandlerContext = channelHandlerContext;
            this.packet = packet;
        }
    }

    public static class sendPacket extends NetworkConnectionEvent {
        public final Packet packet;
        @Nullable
        public final GenericFutureListener<? extends Future<? super Void>> callback;

        public sendPacket(Era era, Packet packet, @Nullable GenericFutureListener<? extends Future<? super Void>> callback) {
            super("sendPacket", era);
            this.packet = packet;
            this.callback = callback;
        }
    }
}
