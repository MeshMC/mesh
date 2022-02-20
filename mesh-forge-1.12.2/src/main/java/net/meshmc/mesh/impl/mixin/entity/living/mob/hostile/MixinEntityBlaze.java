package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityBlaze;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityBlaze.class)
public abstract class MixinEntityBlaze extends MixinEntityHostile implements EntityBlaze {
}
