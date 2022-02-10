package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntityEnderman;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityEnderman.class)
public abstract class MixinEntityEnderman extends MixinEntityHostile implements EntityEnderman {
}
