package net.meshmc.mesh.api.packet.client;

import net.meshmc.mesh.MeshStatics;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.util.math.Hand;

/**
 * Provides an interface for entity interaction packets
 * @author Makrennel 2022/02/09
 */
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
