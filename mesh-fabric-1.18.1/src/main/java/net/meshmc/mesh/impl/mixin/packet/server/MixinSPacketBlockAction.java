package net.meshmc.mesh.impl.mixin.packet.server;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.packet.server.SPacketBlockAction;
import net.minecraft.network.packet.s2c.play.BlockEventS2CPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockEventS2CPacket.class)
public class MixinSPacketBlockAction implements SPacketBlockAction {
    @Shadow @Final private net.minecraft.util.math.BlockPos pos;
    @Shadow @Final private int type;
    @Shadow @Final private int data;

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) pos;
    }

    @Override
    public int getInstrument() {
        return type;
    }

    @Override
    public int getPitch() {
        return data;
    }
}
