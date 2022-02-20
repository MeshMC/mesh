package net.meshmc.mesh.impl.mixin.packet.client.moveplayer;

import net.minecraft.network.play.client.CPacketPlayer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CPacketPlayer.Rotation.class)
public class MixinRotating extends MixinCPacketMovePlayer {
}
