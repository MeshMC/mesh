package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.block.state.IBlockState;
import net.minecraft.network.play.server.SPacketBlockChange;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SPacketBlockChange.class)
public interface SPacketBlockChangeAccessor {
    @Accessor("blockState")
    void setState(IBlockState blockState);
}
