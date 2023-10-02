package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.packet.c2s.play.VehicleMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(VehicleMoveC2SPacket.class)
public interface VehicleMoveC2SPacketAccessor {
    @Mutable
    @Accessor("x")
    void setX(double value);

    @Mutable
    @Accessor("y")
    void setY(double value);

    @Mutable
    @Accessor("z")
    void setZ(double value);

    @Mutable
    @Accessor("yaw")
    void setYaw(float value);

    @Mutable
    @Accessor("pitch")
    void setPitch(float value);
}
