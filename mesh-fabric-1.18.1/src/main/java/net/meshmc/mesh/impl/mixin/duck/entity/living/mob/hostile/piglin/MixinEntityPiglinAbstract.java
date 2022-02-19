package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.piglin;

import net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.MixinEntityHostile;
import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.piglin.EntityPiglinAbstract;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractPiglinEntity.class)
public abstract class MixinEntityPiglinAbstract extends MixinEntityHostile implements EntityPiglinAbstract {
}
