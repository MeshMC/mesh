package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.impl.mixin.accessors.packet.InteractAtHandlerAccessor;
import net.meshmc.mesh.impl.mixin.accessors.packet.InteractHandlerAccessor;
import net.meshmc.mesh.impl.mixin.accessors.packet.PlayerInteractEntityC2SPacketAccessor;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;

public class CPacketUseEntityMesh extends PacketMesh.Client<PlayerInteractEntityC2SPacket> implements net.meshmc.mesh.api.network.client.CPacketUseEntity {
    public CPacketUseEntityMesh(PlayerInteractEntityC2SPacket value) {
        super(value);
    }

    @Override
    public C2S getType() {
       return C2S.UseEntity;
    }

    @Override
    public int getEntityID() {
        return ((PlayerInteractEntityC2SPacketAccessor) getMeshValue()).getEntityId();
    }

    @Override
    public void setEntityID(int value) {
        ((PlayerInteractEntityC2SPacketAccessor) getMeshValue()).setEntityId(value);
    }

    @Override
    public Action getAction() {
        return Action.VALUES[((PlayerInteractEntityC2SPacketAccessor) getMeshValue()).getType().getType().ordinal()];
    }

    @Override
    public void setAttack() {
        ((PlayerInteractEntityC2SPacketAccessor) getMeshValue()).setType(PlayerInteractEntityC2SPacketAccessor.getAttack());
    }

    @Override
    public void setInteract(Hand hand) {
        ((PlayerInteractEntityC2SPacketAccessor) getMeshValue()).setType(new PlayerInteractEntityC2SPacket.InteractHandler(MCEnum.hand(hand)));
    }

    @Override
    public void setInteractAt(Hand hand, Vec3d pos) {
        ((PlayerInteractEntityC2SPacketAccessor) getMeshValue()).setType(new PlayerInteractEntityC2SPacket.InteractAtHandler(MCEnum.hand(hand), (net.minecraft.util.math.Vec3d) pos));
    }

    @Override
    public Hand getHand() {
        return switch(((PlayerInteractEntityC2SPacketAccessor) getMeshValue()).getType().getType()) {
            case INTERACT -> MeshEnum.hand(((InteractHandlerAccessor) ((PlayerInteractEntityC2SPacketAccessor) getMeshValue()).getType()).getHand());
            case INTERACT_AT -> MeshEnum.hand(((InteractAtHandlerAccessor) ((PlayerInteractEntityC2SPacketAccessor) getMeshValue()).getType()).getHand());
            default -> Hand.MAIN_HAND;
        };
    }

    @Override
    public Vec3d getHitVec() {
        if(((PlayerInteractEntityC2SPacketAccessor) getMeshValue()).getType() instanceof PlayerInteractEntityC2SPacket.InteractAtHandler handler)
            return (Vec3d) ((InteractAtHandlerAccessor) handler).getPos();
        return null;
    }

    @Override
    public Boolean isSneaking() {
        return ((PlayerInteractEntityC2SPacketAccessor) getMeshValue()).isPlayerSneaking();
    }

    @Override
    public void setSneaking(boolean value) {
        ((PlayerInteractEntityC2SPacketAccessor) getMeshValue()).setPlayerSneaking(value);
    }
}
