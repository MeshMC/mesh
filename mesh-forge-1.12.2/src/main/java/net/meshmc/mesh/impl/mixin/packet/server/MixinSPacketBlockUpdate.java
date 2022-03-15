package net.meshmc.mesh.impl.mixin.packet.server;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.packet.server.SPacketBlockUpdate;
import net.minecraft.network.play.server.SPacketBlockChange;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SPacketBlockChange.class)
public class MixinSPacketBlockUpdate implements SPacketBlockUpdate {
    @Shadow private net.minecraft.util.math.BlockPos blockPosition;

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) blockPosition;
    }
}
