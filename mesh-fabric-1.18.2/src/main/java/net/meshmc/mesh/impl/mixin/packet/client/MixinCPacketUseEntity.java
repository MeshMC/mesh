package net.meshmc.mesh.impl.mixin.packet.client;

import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.api.packet.client.CPacketUseEntity;
import net.meshmc.mesh.impl.mixin.accessors.packet.InteractAtHandlerAccessor;
import net.meshmc.mesh.impl.mixin.accessors.packet.InteractHandlerAccessor;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerInteractEntityC2SPacket.class)
public class MixinCPacketUseEntity implements CPacketUseEntity {
    @Mutable @Shadow @Final private int entityId;
    @Mutable @Shadow @Final private PlayerInteractEntityC2SPacket.InteractTypeHandler type;
    @Mutable @Shadow @Final private boolean playerSneaking;

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
        return Action.VALUES[type.getType().ordinal()];
    }

    @Override
    public Vec3d getHitVec() {
        if(type instanceof PlayerInteractEntityC2SPacket.InteractAtHandler handler)
            return (Vec3d) ((InteractAtHandlerAccessor) handler).getPos();
        return null;
    }

    @Override
    public boolean setHitVec(Vec3d hitVec) {
        if(type instanceof PlayerInteractEntityC2SPacket.InteractAtHandler handler) {
            ((InteractAtHandlerAccessor) handler).setPos((net.minecraft.util.math.Vec3d) hitVec);
            return true;
        }
        return false;
    }

    @Override
    public Hand getHand() {
        if(type instanceof PlayerInteractEntityC2SPacket.InteractHandler handler)
            return MeshEnum.hand(((InteractHandlerAccessor) handler).getHand());
        if(type instanceof PlayerInteractEntityC2SPacket.InteractAtHandler handler)
            return MeshEnum.hand(((InteractAtHandlerAccessor) handler).getHand());
        return Hand.MAIN_HAND;
    }

    @Override
    public boolean setHand(Hand hand) {
        if(type instanceof PlayerInteractEntityC2SPacket.InteractHandler handler) {
            ((InteractHandlerAccessor) handler).setHand(MCEnum.hand(hand));
            return true;
        }
        if(type instanceof PlayerInteractEntityC2SPacket.InteractAtHandler handler) {
            ((InteractAtHandlerAccessor) handler).setHand(MCEnum.hand(hand));
            return true;
        }
        return false;
    }

    @Override
    public boolean isSneaking() {
        return playerSneaking;
    }

    @Override
    public void setSneaking(boolean value) {
        playerSneaking = value;
    }
}
