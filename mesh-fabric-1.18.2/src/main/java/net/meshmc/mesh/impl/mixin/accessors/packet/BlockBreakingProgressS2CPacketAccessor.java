package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.packet.s2c.play.BlockBreakingProgressS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockBreakingProgressS2CPacket.class)
public interface BlockBreakingProgressS2CPacketAccessor {
    @Mutable
    @Accessor("entityId")
    void setEntityId(int value);

    @Mutable
    @Accessor("progress")
    void setProgress(int value);
}
