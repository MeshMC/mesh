package net.meshmc.mesh.impl.mixin.packet.client.moveplayer;

import net.minecraft.network.play.client.CPacketPlayer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CPacketPlayer.Position.class)
public class MixinMoving extends MixinCPacketMovePlayer {
}
