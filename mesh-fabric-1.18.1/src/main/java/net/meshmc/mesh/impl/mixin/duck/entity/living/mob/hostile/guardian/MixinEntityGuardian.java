package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.guardian;

import net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.MixinEntityHostile;
import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.guardian.EntityGuardian;
import net.minecraft.entity.mob.GuardianEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GuardianEntity.class)
public abstract class MixinEntityGuardian extends MixinEntityHostile implements EntityGuardian {
}
