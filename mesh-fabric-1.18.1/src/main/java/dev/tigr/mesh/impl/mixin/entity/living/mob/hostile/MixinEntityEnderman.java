package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntityEnderman;
import net.minecraft.entity.mob.EndermanEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EndermanEntity.class)
public abstract class MixinEntityEnderman extends MixinEntityHostile implements EntityEnderman {
}
