package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PlayerMoveC2SPacket.class)
public interface PlayerMoveC2SPacketAccessor {
    @Accessor("onGround")
    boolean isOnGround();

    @Mutable
    @Accessor("onGround")
    void setOnGround(boolean value);

    @Accessor("x")
    double getX();

    @Mutable
    @Accessor("x")
    void setX(double value);

    @Accessor("y")
    double getY();

    @Mutable
    @Accessor("y")
    void setY(double value);

    @Accessor("z")
    double getZ();

    @Mutable
    @Accessor("z")
    void setZ(double value);

    @Accessor("yaw")
    float getYaw();

    @Mutable
    @Accessor("yaw")
    void setYaw(float value);

    @Accessor("pitch")
    float getPitch();

    @Mutable
    @Accessor("pitch")
    void setPitch(float value);
}
