package net.meshmc.mesh.impl.mixin.duck.packet.client;

import net.meshmc.mesh.impl.mixininterface.packet.client.CPacketMovePlayer;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerMoveC2SPacket.class)
public class MixinCPacketMovePlayer implements CPacketMovePlayer {
    @Mutable @Shadow @Final protected double x;
    @Mutable @Shadow @Final protected double y;
    @Mutable @Shadow @Final protected double z;
    @Mutable @Shadow @Final protected float yaw;
    @Mutable @Shadow @Final protected float pitch;
    @Mutable @Shadow @Final protected boolean onGround;
    @Mutable @Shadow @Final protected boolean changePosition;
    @Mutable @Shadow @Final protected boolean changeLook;

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public void setX(double value) {
        x = value;
    }

    @Override
    public void setY(double value) {
        y = value;
    }

    @Override
    public void setZ(double value) {
        z = value;
    }

    @Override
    public float getYaw() {
        return yaw;
    }

    @Override
    public float getPitch() {
        return pitch;
    }

    @Override
    public void setYaw(float value) {
        yaw = value;
    }

    @Override
    public void setPitch(float value) {
        pitch = value;
    }

    @Override
    public boolean isOnGround() {
        return onGround;
    }

    @Override
    public boolean isMoving() {
        return changePosition;
    }

    @Override
    public boolean isRotating() {
        return changeLook;
    }

    @Override
    public void setOnGround(boolean value) {
        onGround = value;
    }

    @Override
    public void setMoving(boolean value) {
        changePosition = value;
    }

    @Override
    public void setRotating(boolean value) {
        changeLook = value;
    }

    @Mixin(PlayerMoveC2SPacket.OnGroundOnly.class)
    public static class MixinOnGround extends MixinCPacketMovePlayer implements CPacketMovePlayer {
    }

    @Mixin(PlayerMoveC2SPacket.PositionAndOnGround.class)
    public static class MixinMoving extends MixinCPacketMovePlayer implements CPacketMovePlayer {
    }

    @Mixin(PlayerMoveC2SPacket.LookAndOnGround.class)
    public static class MixinRotating extends MixinCPacketMovePlayer implements CPacketMovePlayer {
    }

    @Mixin(PlayerMoveC2SPacket.Full.class)
    public static class MixinFull extends MixinCPacketMovePlayer implements CPacketMovePlayer {
    }
}
