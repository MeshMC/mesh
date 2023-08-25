package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.impl.mixin.accessors.packet.CPacketUseEntityAccessor;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.network.play.client.CPacketUseEntity;

public class CPacketUseEntityMesh extends PacketMesh.Client<CPacketUseEntity> implements net.meshmc.mesh.api.network.client.CPacketUseEntity {
    public CPacketUseEntityMesh(CPacketUseEntity value) {
        super(value);
    }

    @Override
    public C2S getType() {
       return C2S.UseEntity;
    }

    @Override
    public int getEntityID() {
        return ((CPacketUseEntityAccessor) getMeshValue()).getEntityId();
    }

    @Override
    public void setEntityID(int value) {
        ((CPacketUseEntityAccessor) getMeshValue()).setEntityId(value);
    }

    @Override
    public Action getAction() {
        return Action.VALUES[getMeshValue().getAction().ordinal()];
    }

    @Override
    public void setAttack() {
        ((CPacketUseEntityAccessor) getMeshValue()).setType(CPacketUseEntity.Action.ATTACK);
    }

    @Override
    public void setInteract(Hand hand) {
        ((CPacketUseEntityAccessor) getMeshValue()).setType(CPacketUseEntity.Action.INTERACT);
        ((CPacketUseEntityAccessor) getMeshValue()).setHand(MCEnum.hand(hand));
    }

    @Override
    public void setInteractAt(Hand hand, Vec3d pos) {
        ((CPacketUseEntityAccessor) getMeshValue()).setType(CPacketUseEntity.Action.INTERACT_AT);
        ((CPacketUseEntityAccessor) getMeshValue()).setHand(MCEnum.hand(hand));
        ((CPacketUseEntityAccessor) getMeshValue()).setHitVec((net.minecraft.util.math.Vec3d) pos);
    }

    @Override
    public Hand getHand() {
        if(getMeshValue().getAction() == CPacketUseEntity.Action.ATTACK) return Hand.MAIN_HAND;
        return MeshEnum.hand(getMeshValue().getHand());
    }

    @Override
    public Vec3d getHitVec() {
       return (Vec3d) getMeshValue().getHitVec();
    }

    @Override
    public Boolean isSneaking() {
        return null;
    }

    @Override
    public void setSneaking(boolean value) {}
}
