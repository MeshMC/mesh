package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntityWither;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.boss.EntityWither.class)
public abstract class MixinEntityWither extends MixinEntityHostile implements EntityWither {
}
