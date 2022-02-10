package dev.tigr.mesh.impl.mixin.duck.entity.living.player;

import dev.tigr.mesh.impl.mixininterface.entity.living.player.EntityClientPlayer;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientPlayerEntity.class)
public abstract class MixinEntityClientPlayer extends MixinEntityAbstractClientPlayer implements EntityClientPlayer {
}
