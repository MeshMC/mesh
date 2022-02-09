package dev.tigr.mesh.impl.mixin.packet.client;

import dev.tigr.mesh.impl.mixininterface.packet.client.CPacketMoveVehicle;
import net.minecraft.network.packet.c2s.play.VehicleMoveC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(VehicleMoveC2SPacket.class)
public class MixinCPacketMoveVehicle implements CPacketMoveVehicle {
    @Mutable @Shadow @Final private double x;
    @Mutable @Shadow @Final private double y;
    @Mutable @Shadow @Final private double z;
    @Mutable @Shadow @Final private float yaw;
    @Mutable @Shadow @Final private float pitch;

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
}
