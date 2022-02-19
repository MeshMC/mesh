package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.EntityEnderman;
import net.minecraft.entity.mob.EndermanEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EndermanEntity.class)
public abstract class MixinEntityEnderman extends MixinEntityHostile implements EntityEnderman {
}
