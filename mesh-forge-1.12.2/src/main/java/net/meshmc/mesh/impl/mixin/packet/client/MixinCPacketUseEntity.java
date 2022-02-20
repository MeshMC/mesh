package net.meshmc.mesh.impl.mixin.packet.client;

import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.api.packet.client.CPacketUseEntity;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.util.EnumHand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(net.minecraft.network.play.client.CPacketUseEntity.class)
public class MixinCPacketUseEntity implements CPacketUseEntity {
    @Shadow private int entityId;
    @Shadow private net.minecraft.network.play.client.CPacketUseEntity.Action action;
    @Shadow private EnumHand hand;
    @Shadow private net.minecraft.util.math.Vec3d hitVec;

    @Override
    public int getEntityID() {
        return entityId;
    }

    @Override
    public void setEntityID(int value) {
        entityId = value;
    }

    @Override
    public Action getAction() {
        return Action.VALUES[action.ordinal()];
    }

    @Override
    public Vec3d getHitVec() {
        return (Vec3d) hitVec;
    }

    @Override
    public boolean setHitVec(Vec3d hitVec) {
        if(action != net.minecraft.network.play.client.CPacketUseEntity.Action.INTERACT_AT)
            return false;
        this.hitVec = (net.minecraft.util.math.Vec3d) hitVec;
        return true;
    }

    @Override
    public Hand getHand() {
        return MeshEnum.hand(hand);
    }

    @Override
    public boolean setHand(Hand hand) {
        if(action == net.minecraft.network.play.client.CPacketUseEntity.Action.ATTACK)
            return false;
        this.hand = MCEnum.hand(hand);
        return true;
    }

    @Override
    public boolean isSneaking() {
        // not in 1.12.2
        return false;
    }

    @Override
    public void setSneaking(boolean sneaking) {
        // Do nothing - not in 1.12.2
    }
}
