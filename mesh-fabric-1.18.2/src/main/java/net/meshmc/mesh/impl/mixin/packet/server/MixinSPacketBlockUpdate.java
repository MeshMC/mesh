package net.meshmc.mesh.impl.mixin.packet.server;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.packet.server.SPacketBlockUpdate;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockUpdateS2CPacket.class)
public class MixinSPacketBlockUpdate implements SPacketBlockUpdate {
    @Shadow @Final private net.minecraft.util.math.BlockPos pos;

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) pos;
    }
}
