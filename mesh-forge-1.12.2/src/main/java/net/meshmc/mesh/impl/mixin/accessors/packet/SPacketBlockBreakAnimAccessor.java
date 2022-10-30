package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.play.server.SPacketBlockBreakAnim;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SPacketBlockBreakAnim.class)
public interface SPacketBlockBreakAnimAccessor {
    @Accessor("breakerId")
    void setEntityId(int value);

    @Accessor("progress")
    void setProgress(int value);
}
