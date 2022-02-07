package dev.tigr.mesh.impl.mixininterface.packet.client;

import dev.tigr.mesh.MeshStatics;
import dev.tigr.mesh.impl.mixininterface.entity.Entity;
import dev.tigr.mesh.impl.mixininterface.math.Vec3d;
import dev.tigr.mesh.util.math.Hand;

public interface CPacketUseEntity {
    enum Action {
        INTERACT, ATTACK, INTERACT_AT;
        public static final Action[] VALUES = Action.values();
    }

    static CPacketUseEntity createAttack(Entity entity, boolean sneaking) {
        return MeshStatics.createCPacketUseEntityAttack(entity, sneaking);
    }

    static CPacketUseEntity createInteract(Entity entity, Hand hand, boolean sneaking) {
        return MeshStatics.createCPacketUseEntityInteract(entity, hand, sneaking);
    }

    static CPacketUseEntity createInteractAt(Entity entity, Hand hand, Vec3d pos, boolean sneaking) {
        return MeshStatics.createCPacketUseEntityInteractAt(entity, hand, pos, sneaking);
    }

    int getEntityID();
    void setEntityID(int value);

    Action getAction();

    Vec3d getHitVec();
    boolean setHitVec(Vec3d hitVec);

    Hand getHand();
    boolean setHand(Hand setHand);

    /** 1.18 only */
    boolean isSneaking();
    /** 1.18 only */
    void setSneaking(boolean sneaking);
}
