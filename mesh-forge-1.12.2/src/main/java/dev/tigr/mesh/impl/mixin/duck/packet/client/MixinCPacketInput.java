package dev.tigr.mesh.impl.mixin.duck.packet.client;

import dev.tigr.mesh.impl.mixininterface.packet.client.CPacketInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(net.minecraft.network.play.client.CPacketInput.class)
public class MixinCPacketInput implements CPacketInput {
    @Shadow private float strafeSpeed;
    @Shadow private float forwardSpeed;
    @Shadow private boolean jumping;
    @Shadow private boolean sneaking;

    @Override
    public float getSideways() {
        return strafeSpeed;
    }

    @Override
    public float getForwards() {
        return forwardSpeed;
    }

    @Override
    public void setSideways(float value) {
        strafeSpeed = value;
    }

    @Override
    public void setForwards(float value) {
        forwardSpeed = value;
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
