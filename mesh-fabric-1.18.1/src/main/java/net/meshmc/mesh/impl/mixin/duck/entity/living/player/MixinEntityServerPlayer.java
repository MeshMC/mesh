package net.meshmc.mesh.impl.mixin.duck.entity.living.player;

import net.meshmc.mesh.impl.mixininterface.entity.living.player.EntityServerPlayer;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerPlayerEntity.class)
public abstract class MixinEntityServerPlayer extends MixinEntityPlayer implements EntityServerPlayer {
}
