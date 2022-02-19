package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.piglin;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.piglin.EntityPiglin;
import net.minecraft.entity.mob.PiglinEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PiglinEntity.class)
public abstract class MixinEntityPiglin extends MixinEntityPiglinAbstract implements EntityPiglin {
}
