package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.network.client.CPacketInput;
import net.meshmc.mesh.impl.mixin.accessors.packet.PlayerInputC2SPacketAccessor;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket;

public class CPacketInputMesh extends PacketMesh.Client<PlayerInputC2SPacket> implements CPacketInput {
    public CPacketInputMesh(PlayerInputC2SPacket value) {
        super(value);
    }

    @Override
    public C2S getType() {
        return C2S.Input;
    }

    @Override
    public float getSideways() {
        return getMeshValue().getSideways();
    }

    @Override
    public float getForwards() {
        return getMeshValue().getForward();
    }

    @Override
    public void setSideways(float value) {
        ((PlayerInputC2SPacketAccessor) getMeshValue()).setSideways(value);
    }

    @Override
    public void setForwards(float value) {
        ((PlayerInputC2SPacketAccessor) getMeshValue()).setForward(value);
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
        ((PlayerInputC2SPacketAccessor) getMeshValue()).setJumping(value);
    }

    @Override
    public void setSneaking(boolean value) {
        ((PlayerInputC2SPacketAccessor) getMeshValue()).setSneaking(value);
    }
}
