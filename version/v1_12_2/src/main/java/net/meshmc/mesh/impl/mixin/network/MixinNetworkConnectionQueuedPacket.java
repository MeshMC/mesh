package net.meshmc.mesh.impl.mixin.network;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.meshmc.mesh.api.network.NetworkConnection;
import net.meshmc.mesh.impl.util.Mappings;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
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
    public net.meshmc.mesh.api.network.Packet getPacket() {
        return Mappings.packet(packet);
    }

    @Override
    public void setPacket(net.meshmc.mesh.api.network.Packet packet) {
        this.packet = ((PacketMesh<?>) packet).getMeshValue();
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
