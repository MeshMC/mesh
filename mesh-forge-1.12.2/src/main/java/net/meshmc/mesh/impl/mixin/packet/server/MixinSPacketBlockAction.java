package net.meshmc.mesh.impl.mixin.packet.server;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.packet.server.SPacketBlockAction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(net.minecraft.network.play.server.SPacketBlockAction.class)
public class MixinSPacketBlockAction implements SPacketBlockAction {
    @Shadow private net.minecraft.util.math.BlockPos blockPosition;
    @Shadow private int instrument;
    @Shadow private int pitch;

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) blockPosition;
    }

    @Override
    public int getInstrument() {
        return instrument;
    }

    @Override
    public int getPitch() {
        return pitch;
    }
}
