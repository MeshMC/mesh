package dev.tigr.mesh.impl.mixin.duck.entity.living.player;

import dev.tigr.mesh.impl.mixininterface.entity.living.player.EntityAbstractClientPlayer;
import net.minecraft.client.entity.AbstractClientPlayer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractClientPlayer.class)
public abstract class MixinEntityAbstractClientPlayer extends MixinEntityPlayer implements EntityAbstractClientPlayer {
}
