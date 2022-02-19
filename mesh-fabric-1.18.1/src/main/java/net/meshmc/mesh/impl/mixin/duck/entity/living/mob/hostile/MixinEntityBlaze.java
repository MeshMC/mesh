package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.EntityBlaze;
import net.minecraft.entity.mob.BlazeEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlazeEntity.class)
public abstract class MixinEntityBlaze extends MixinEntityHostile implements EntityBlaze {
}
