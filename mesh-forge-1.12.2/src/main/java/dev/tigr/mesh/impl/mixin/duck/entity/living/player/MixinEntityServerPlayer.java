package dev.tigr.mesh.impl.mixin.duck.entity.living.player;

import dev.tigr.mesh.impl.mixininterface.entity.living.player.EntityServerPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityPlayerMP.class)
public abstract class MixinEntityServerPlayer extends MixinEntityPlayer implements EntityServerPlayer {
}
