package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.play.client.CPacketSteerBoat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CPacketSteerBoat.class)
public interface CPacketSteerBoatAccessor {
    @Accessor("left")
    void setLeft(boolean value);

    @Accessor("right")
    void setRight(boolean value);
}
