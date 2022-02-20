package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.piglin;

import net.meshmc.mesh.api.entity.living.mob.hostile.piglin.EntityPiglin;
import net.minecraft.entity.mob.PiglinEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PiglinEntity.class)
public abstract class MixinEntityPiglin extends MixinEntityPiglinAbstract implements EntityPiglin {
}
