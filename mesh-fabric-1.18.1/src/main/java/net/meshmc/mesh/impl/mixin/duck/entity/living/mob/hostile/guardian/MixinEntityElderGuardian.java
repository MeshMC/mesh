package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.guardian;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.guardian.EntityElderGuardian;
import net.minecraft.entity.mob.ElderGuardianEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ElderGuardianEntity.class)
public abstract class MixinEntityElderGuardian extends MixinEntityGuardian implements EntityElderGuardian {
}
