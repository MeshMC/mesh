package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.guardian;

import net.meshmc.mesh.api.entity.living.mob.hostile.guardian.EntityElderGuardian;
import net.minecraft.entity.mob.ElderGuardianEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ElderGuardianEntity.class)
public abstract class MixinEntityElderGuardian extends MixinEntityGuardian implements EntityElderGuardian {
}
