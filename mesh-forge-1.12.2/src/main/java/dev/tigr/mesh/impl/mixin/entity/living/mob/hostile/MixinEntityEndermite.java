package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntityEndermite;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityEndermite.class)
public abstract class MixinEntityEndermite extends MixinEntityHostile implements EntityEndermite {
}
