package net.meshmc.mesh.impl.mixin.duck.packet.client;

import net.meshmc.mesh.impl.mixininterface.packet.client.CPacketSteerBoat;
import net.minecraft.network.packet.c2s.play.BoatPaddleStateC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BoatPaddleStateC2SPacket.class)
public class MixinCPacketSteerBoat implements CPacketSteerBoat {
    @Mutable @Shadow @Final private boolean leftPaddling;
    @Mutable @Shadow @Final private boolean rightPaddling;

    @Override
    public boolean getLeft() {
        return leftPaddling;
    }

    @Override
    public boolean getRight() {
        return rightPaddling;
    }

    @Override
    public void setLeft(boolean value) {
        leftPaddling = value;
    }

    @Override
    public void setRight(boolean value) {
        rightPaddling = value;
    }
}
