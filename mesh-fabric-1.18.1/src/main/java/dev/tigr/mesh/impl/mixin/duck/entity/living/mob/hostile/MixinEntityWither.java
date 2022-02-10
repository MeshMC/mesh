package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntityWither;
import net.minecraft.entity.boss.WitherEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WitherEntity.class)
public abstract class MixinEntityWither extends MixinEntityHostile implements EntityWither {
}
