package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.play.client.CPacketVehicleMove;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CPacketVehicleMove.class)
public interface CPacketVehicleMoveAccessor {
    @Accessor("x")
    void setX(double value);

    @Accessor("y")
    void setY(double value);

    @Accessor("z")
    void setZ(double value);

    @Accessor("yaw")
    void setYaw(float value);

    @Accessor("pitch")
    void setPitch(float value);
}
