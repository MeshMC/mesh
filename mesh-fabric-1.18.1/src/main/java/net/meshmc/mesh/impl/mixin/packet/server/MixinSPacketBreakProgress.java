package net.meshmc.mesh.impl.mixin.packet.server;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.packet.server.SPacketBreakProgress;
import net.minecraft.network.packet.s2c.play.BlockBreakingProgressS2CPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockBreakingProgressS2CPacket.class)
public class MixinSPacketBreakProgress implements SPacketBreakProgress {
    @Shadow @Final private int entityId;
    @Shadow @Final private net.minecraft.util.math.BlockPos pos;
    @Shadow @Final private int progress;

    @Override
    public int getEntityId() {
        return entityId;
    }

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) pos;
    }

    @Override
    public int getProgress() {
        return progress;
    }
}
