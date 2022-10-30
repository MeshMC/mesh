package net.meshmc.mesh.impl.mixin.network;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.meshmc.mesh.api.network.NetworkConnection;
import net.meshmc.mesh.api.network.Packet;
import net.meshmc.mesh.impl.util.Mappings;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(targets = "net.minecraft.network.ClientConnection$QueuedPacket")
public class MixinNetworkConnectionQueuedPacket implements NetworkConnection.QueuedPacket {
    @Mutable @Shadow @Final
    net.minecraft.network.Packet<?> packet;
    @Mutable @Shadow @Final @Nullable GenericFutureListener<? extends Future<? super Void>> callback;

    @Override
    public Packet getPacket() {
        return Mappings.packet(packet);
    }

    @Override
    public void setPacket(Packet packet) {
        this.packet = ((PacketMesh<?>) packet).getMeshValue();
    }

    @Override
    public GenericFutureListener<? extends Future<? super Void>>[] getCallbacks() {
        GenericFutureListener<? extends Future<? super Void>>[] l = new GenericFutureListener[1];
        l[0] = callback;
        return l;
    }

    @Override
    public void setCallbacks(GenericFutureListener<? extends Future<? super Void>>[] callbacks) {
        if(callbacks == null) return;
        for(GenericFutureListener<? extends Future<? super Void>> cb: callbacks)
            if(cb != null) {
                this.callback = cb;
                break;
            }
    }
}
