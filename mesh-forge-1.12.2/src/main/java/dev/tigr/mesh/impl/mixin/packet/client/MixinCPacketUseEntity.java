package dev.tigr.mesh.impl.mixin.packet.client;

import dev.tigr.mesh.impl.conversion.MCEnum;
import dev.tigr.mesh.impl.conversion.MeshEnum;
import dev.tigr.mesh.impl.mixininterface.math.Vec3d;
import dev.tigr.mesh.impl.mixininterface.packet.Packet;
import dev.tigr.mesh.impl.mixininterface.packet.client.CPacketUseEntity;
import dev.tigr.mesh.util.math.Hand;
import net.minecraft.util.EnumHand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(net.minecraft.network.play.client.CPacketUseEntity.class)
public class MixinCPacketUseEntity implements Packet, CPacketUseEntity {
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
