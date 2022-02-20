package net.meshmc.mesh.impl.mixin.entity.living.player;

import net.meshmc.mesh.api.entity.living.player.EntityAbstractClientPlayer;
import net.minecraft.client.entity.AbstractClientPlayer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractClientPlayer.class)
public abstract class MixinEntityAbstractClientPlayer extends MixinEntityPlayer implements EntityAbstractClientPlayer {
}
