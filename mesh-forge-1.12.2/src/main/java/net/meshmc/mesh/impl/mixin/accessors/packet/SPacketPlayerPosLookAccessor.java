package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.play.server.SPacketPlayerPosLook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(SPacketPlayerPosLook.class)
public interface SPacketPlayerPosLookAccessor {
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

    @Accessor("flags")
    void setFlags(Set<SPacketPlayerPosLook.EnumFlags> value);

    @Accessor("teleportId")
    void setTeleportId(int value);
}
