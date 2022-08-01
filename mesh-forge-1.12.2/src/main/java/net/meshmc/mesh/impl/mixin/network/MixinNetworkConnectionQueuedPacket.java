package net.meshmc.mesh.impl.mixin.network;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.meshmc.mesh.api.network.NetworkConnection;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(targets = "net.minecraft.network.NetworkManager$InboundHandlerTuplePacketListener")
public class MixinNetworkConnectionQueuedPacket implements NetworkConnection.QueuedPacket {
    @Mutable @Shadow @Final private Packet<?> packet;
    @Mutable @Shadow @Final private GenericFutureListener<? extends Future<? super Void>>[] futureListeners;

    @Override
    public Object getPacket() {
        return packet;
    }

    @Override
    public void setPacket(Object packet) {
        this.packet = (Packet<?>) packet;
    }

    @Override
    public GenericFutureListener<? extends Future<? super Void>>[] getCallbacks() {
        return futureListeners;
    }

    @Override
    public void setCallbacks(GenericFutureListener<? extends Future<? super Void>>[] callbacks) {
        this.futureListeners = callbacks;
    }
}
