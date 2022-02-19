package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.EntityEndermite;
import net.minecraft.entity.mob.EndermiteEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EndermiteEntity.class)
public abstract class MixinEntityEndermite extends MixinEntityHostile implements EntityEndermite {
}
