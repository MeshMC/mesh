package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.play.client.CPacketPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CPacketPlayer.class)
public interface CPacketPlayerAccessor {
    @Accessor("x")
    double getX();

    @Accessor("x")
    void setX(double value);

    @Accessor("y")
    double getY();

    @Accessor("y")
    void setY(double value);

    @Accessor("z")
    double getZ();

    @Accessor("z")
    void setZ(double value);

    @Accessor("yaw")
    float getYaw();

    @Accessor("yaw")
    void setYaw(float value);

    @Accessor("pitch")
    float getPitch();

    @Accessor("pitch")
    void setPitch(float value);

    @Accessor("onGround")
    boolean isOnGround();

    @Accessor("onGround")
    void setOnGround(boolean value);
}
