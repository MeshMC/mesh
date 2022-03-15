package net.meshmc.mesh.impl.mixin.packet.server;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.packet.server.SPacketBreakProgress;
import net.minecraft.network.play.server.SPacketBlockBreakAnim;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SPacketBlockBreakAnim.class)
public class MixinSPacketBreakProgress implements SPacketBreakProgress {
    @Shadow private int breakerId;
    @Shadow private net.minecraft.util.math.BlockPos position;
    @Shadow private int progress;

    @Override
    public int getEntityId() {
        return breakerId;
    }

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) position;
    }

    @Override
    public int getProgress() {
        return progress;
    }
}
