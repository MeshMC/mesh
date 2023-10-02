package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(PlayerPositionLookS2CPacket.class)
public interface PlayerPositionLookS2CPacketAccessor {
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

    @Mutable
    @Accessor("flags")
    void setFlags(Set<PositionFlag> flags);

    @Mutable
    @Accessor("teleportId")
    void setTeleportId(int value);
}
