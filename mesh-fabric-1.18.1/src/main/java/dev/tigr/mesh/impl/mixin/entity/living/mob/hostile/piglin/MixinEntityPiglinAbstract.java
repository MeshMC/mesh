package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.piglin;

import dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.MixinEntityHostile;
import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.piglin.EntityPiglinAbstract;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractPiglinEntity.class)
public abstract class MixinEntityPiglinAbstract extends MixinEntityHostile implements EntityPiglinAbstract {
}
