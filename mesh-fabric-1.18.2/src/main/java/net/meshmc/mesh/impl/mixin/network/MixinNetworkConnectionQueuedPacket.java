package net.meshmc.mesh.impl.mixin.network;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.meshmc.mesh.api.network.NetworkConnection;
import net.minecraft.network.Packet;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(targets = "net.minecraft.network.ClientConnection$QueuedPacket")
public class MixinNetworkConnectionQueuedPacket implements NetworkConnection.QueuedPacket {
    @Mutable @Shadow @Final Packet<?> packet;
    @Mutable @Shadow @Final @Nullable GenericFutureListener<? extends Future<? super Void>> callback;

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
