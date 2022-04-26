package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityWither;
import net.minecraft.entity.boss.WitherEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WitherEntity.class)
public abstract class MixinEntityWither extends MixinEntityHostile implements EntityWither {
}
