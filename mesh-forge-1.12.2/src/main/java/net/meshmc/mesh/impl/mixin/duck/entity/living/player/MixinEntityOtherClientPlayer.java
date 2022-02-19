package net.meshmc.mesh.impl.mixin.duck.entity.living.player;

import net.meshmc.mesh.impl.mixininterface.entity.living.player.EntityOtherClientPlayer;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityOtherPlayerMP.class)
public abstract class MixinEntityOtherClientPlayer extends MixinEntityAbstractClientPlayer implements EntityOtherClientPlayer {
}
