package dev.tigr.mesh.impl.mixin.duck.packet.client;

import dev.tigr.mesh.impl.mixininterface.packet.client.CPacketSteerBoat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(net.minecraft.network.play.client.CPacketSteerBoat.class)
public class MixinCPacketSteerBoat implements CPacketSteerBoat {
    @Shadow private boolean left;
    @Shadow private boolean right;

    @Override
    public boolean getLeft() {
        return left;
    }

    @Override
    public boolean getRight() {
        return right;
    }

    @Override
    public void setLeft(boolean value) {
        left = value;
    }

    @Override
    public void setRight(boolean value) {
        right = value;
    }
}
