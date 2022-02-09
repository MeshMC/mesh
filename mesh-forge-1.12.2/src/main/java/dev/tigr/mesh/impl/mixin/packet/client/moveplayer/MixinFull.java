package dev.tigr.mesh.impl.mixin.packet.client.moveplayer;

import net.minecraft.network.play.client.CPacketPlayer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CPacketPlayer.PositionRotation.class)
public class MixinFull extends MixinCPacketMovePlayer {
}
