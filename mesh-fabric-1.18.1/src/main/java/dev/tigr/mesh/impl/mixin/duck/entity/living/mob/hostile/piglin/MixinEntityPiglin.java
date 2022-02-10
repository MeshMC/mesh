package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile.piglin;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.piglin.EntityPiglin;
import net.minecraft.entity.mob.PiglinEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PiglinEntity.class)
public abstract class MixinEntityPiglin extends MixinEntityPiglinAbstract implements EntityPiglin {
}
