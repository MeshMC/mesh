package net.meshmc.mesh.impl.mixin.entity.living.player;

import net.meshmc.mesh.api.entity.living.player.EntityClientPlayer;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientPlayerEntity.class)
public abstract class MixinEntityClientPlayer extends MixinEntityAbstractClientPlayer implements EntityClientPlayer {
}
