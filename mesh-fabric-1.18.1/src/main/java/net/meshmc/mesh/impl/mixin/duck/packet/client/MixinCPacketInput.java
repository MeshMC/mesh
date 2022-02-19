package net.meshmc.mesh.impl.mixin.duck.packet.client;

import net.meshmc.mesh.impl.mixininterface.packet.client.CPacketInput;
import net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerInputC2SPacket.class)
public class MixinCPacketInput implements CPacketInput {
    @Mutable @Shadow @Final private float sideways;
    @Mutable @Shadow @Final private float forward;
    @Mutable @Shadow @Final private boolean jumping;
    @Mutable @Shadow @Final private boolean sneaking;

    @Override
    public float getSideways() {
        return sideways;
    }

    @Override
    public float getForwards() {
        return forward;
    }

    @Override
    public void setSideways(float value) {
        sideways = value;
    }

    @Override
    public void setForwards(float value) {
        forward = value;
    }

    @Override
    public boolean getJumping() {
        return jumping;
    }

    @Override
    public boolean getSneaking() {
        return sneaking;
    }

    @Override
    public void setJumping(boolean value) {
        jumping = value;
    }

    @Override
    public void setSneaking(boolean value) {
        sneaking = value;
    }
}
