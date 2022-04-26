package net.meshmc.mesh.impl.mixin.entity.living.player;

import net.meshmc.mesh.api.entity.living.player.EntityOtherClientPlayer;
import net.minecraft.client.network.OtherClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(OtherClientPlayerEntity.class)
public abstract class MixinEntityOtherClientPlayer extends MixinEntityAbstractClientPlayer implements EntityOtherClientPlayer {
}
