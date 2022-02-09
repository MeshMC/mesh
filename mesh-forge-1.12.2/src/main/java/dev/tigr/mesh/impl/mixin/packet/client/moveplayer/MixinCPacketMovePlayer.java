package dev.tigr.mesh.impl.mixin.packet.client.moveplayer;

import dev.tigr.mesh.impl.mixininterface.packet.client.CPacketMovePlayer;
import net.minecraft.network.play.client.CPacketPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CPacketPlayer.class)
public class MixinCPacketMovePlayer implements CPacketMovePlayer {
    @Shadow protected double x;
    @Shadow protected double y;
    @Shadow protected double z;
    @Shadow protected float yaw;
    @Shadow protected float pitch;
    @Shadow protected boolean onGround;
    @Shadow protected boolean moving;
    @Shadow protected boolean rotating;

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
        return moving;
    }

    @Override
    public boolean isRotating() {
        return rotating;
    }

    @Override
    public void setOnGround(boolean value) {
        onGround = value;
    }

    @Override
    public void setMoving(boolean value) {
        moving = value;
    }

    @Override
    public void setRotating(boolean value) {
        rotating = value;
    }
}
