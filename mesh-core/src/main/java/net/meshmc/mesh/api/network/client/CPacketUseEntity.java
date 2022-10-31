package net.meshmc.mesh.api.network.client;

import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.api.network.Packet;
import net.meshmc.mesh.statics.StaticPackets;
import net.meshmc.mesh.util.GameVersion;
import net.meshmc.mesh.util.math.Hand;
import org.jetbrains.annotations.Nullable;

/**
 * Provides an interface for entity interaction packets
 * @author Makrennel 2022/02/09
 */
public interface CPacketUseEntity extends Packet.Client {
    enum Action {
        INTERACT, ATTACK, INTERACT_AT;
        public static final Action[] VALUES = Action.values();
    }

    static CPacketUseEntity createAttack(Entity entity, @GameVersion.OnlyOn(value = GameVersion.v1_16_3, minimumVersion = true) boolean sneaking) {
        return StaticPackets.createCPacketUseEntityAttack(entity, sneaking);
    }

    static CPacketUseEntity createInteract(Entity entity, Hand hand, @GameVersion.OnlyOn(value = GameVersion.v1_16_3, minimumVersion = true) boolean sneaking) {
        return StaticPackets.createCPacketUseEntityInteract(entity, hand, sneaking);
    }

    static CPacketUseEntity createInteractAt(Entity entity, Hand hand, Vec3d pos, @GameVersion.OnlyOn(value = GameVersion.v1_16_3, minimumVersion = true) boolean sneaking) {
        return StaticPackets.createCPacketUseEntityInteractAt(entity, hand, pos, sneaking);
    }

    int getEntityID();
    void setEntityID(int value);

    Action getAction();

    void setAttack();
    void setInteract(Hand hand);
    void setInteractAt(Hand hand, Vec3d pos);

    /**
     * @return Hand which is being used (Always Hand.MAIN_HAND on Action.ATTACK)
     */
    Hand getHand();

    /**
     * @return Hand which is being used (Only on Action.INTERACT_AT)
     */
    @Nullable
    Vec3d getHitVec();

    @Nullable
    @GameVersion.OnlyOn(value = GameVersion.v1_16_3, minimumVersion = true)
    Boolean isSneaking();
    @GameVersion.OnlyOn(value = GameVersion.v1_16_3, minimumVersion = true)
    void setSneaking(boolean sneaking);
}
