package net.meshmc.mesh.impl.mixin.entity.living.player;

import net.meshmc.mesh.api.entity.living.player.EntityServerPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityPlayerMP.class)
public abstract class MixinEntityServerPlayer extends MixinEntityPlayer implements EntityServerPlayer {
}
