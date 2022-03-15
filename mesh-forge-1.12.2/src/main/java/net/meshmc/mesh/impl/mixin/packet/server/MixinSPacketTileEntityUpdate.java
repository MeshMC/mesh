package net.meshmc.mesh.impl.mixin.packet.server;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.packet.server.SPacketTileEntityUpdate;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SPacketUpdateTileEntity.class)
public class MixinSPacketTileEntityUpdate implements SPacketTileEntityUpdate {
    @Shadow private net.minecraft.util.math.BlockPos blockPos;

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) blockPos;
    }
}
