package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntityBlaze;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityBlaze.class)
public abstract class MixinEntityBlaze extends MixinEntityHostile implements EntityBlaze {
}
