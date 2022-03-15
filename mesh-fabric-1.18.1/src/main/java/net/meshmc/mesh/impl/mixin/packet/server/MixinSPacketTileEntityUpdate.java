package net.meshmc.mesh.impl.mixin.packet.server;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.packet.server.SPacketTileEntityUpdate;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockEntityUpdateS2CPacket.class)
public class MixinSPacketTileEntityUpdate implements SPacketTileEntityUpdate {
    @Shadow @Final private net.minecraft.util.math.BlockPos pos;

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) pos;
    }
}
