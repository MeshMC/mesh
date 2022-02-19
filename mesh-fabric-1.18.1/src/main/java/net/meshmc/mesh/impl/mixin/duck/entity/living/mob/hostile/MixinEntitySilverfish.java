package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.EntitySilverfish;
import net.minecraft.entity.mob.SilverfishEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SilverfishEntity.class)
public abstract class MixinEntitySilverfish extends MixinEntityHostile implements EntitySilverfish {
}
