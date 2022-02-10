package dev.tigr.mesh.impl.mixin.duck.entity.living.player;

import dev.tigr.mesh.impl.mixininterface.entity.living.player.EntityAbstractClientPlayer;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class MixinEntityAbstractClientPlayer extends MixinEntityPlayer implements EntityAbstractClientPlayer {
}
