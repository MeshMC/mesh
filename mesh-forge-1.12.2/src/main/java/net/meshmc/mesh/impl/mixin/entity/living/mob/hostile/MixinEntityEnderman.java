package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityEnderman;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityEnderman.class)
public abstract class MixinEntityEnderman extends MixinEntityHostile implements EntityEnderman {
}