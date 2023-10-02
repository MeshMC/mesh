package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.network.client.CPacketInput;
import net.meshmc.mesh.impl.mixin.accessors.packet.CPacketInputAccessor;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;

public class CPacketInputMesh extends PacketMesh.Client<net.minecraft.network.play.client.CPacketInput> implements CPacketInput {
    public CPacketInputMesh(net.minecraft.network.play.client.CPacketInput value) {
        super(value);
    }

    @Override
    public C2S getType() {
        return C2S.Input;
    }

    @Override
    public float getSideways() {
        return getMeshValue().getStrafeSpeed();
    }

    @Override
    public float getForwards() {
        return getMeshValue().getForwardSpeed();
    }

    @Override
    public void setSideways(float value) {
        ((CPacketInputAccessor) getMeshValue()).setSideways(value);
    }

    @Override
    public void setForwards(float value) {
        ((CPacketInputAccessor) getMeshValue()).setForward(value);
    }

    @Override
    public boolean isJumping() {
        return getMeshValue().isJumping();
    }

    @Override
    public boolean isSneaking() {
        return getMeshValue().isSneaking();
    }

    @Override
    public void setJumping(boolean value) {
        ((CPacketInputAccessor) getMeshValue()).setJumping(value);
    }

    @Override
    public void setSneaking(boolean value) {
        ((CPacketInputAccessor) getMeshValue()).setSneaking(value);
    }
}
