package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntityEndermite;
import net.minecraft.entity.mob.EndermiteEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EndermiteEntity.class)
public abstract class MixinEntityEndermite extends MixinEntityHostile implements EntityEndermite {
}
