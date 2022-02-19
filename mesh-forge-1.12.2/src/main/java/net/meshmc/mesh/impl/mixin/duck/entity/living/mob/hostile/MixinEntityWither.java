package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.EntityWither;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.boss.EntityWither.class)
public abstract class MixinEntityWither extends MixinEntityHostile implements EntityWither {
}
