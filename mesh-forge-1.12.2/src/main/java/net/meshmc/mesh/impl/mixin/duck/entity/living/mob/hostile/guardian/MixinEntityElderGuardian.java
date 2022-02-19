package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.guardian;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.guardian.EntityElderGuardian;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityElderGuardian.class)
public abstract class MixinEntityElderGuardian extends MixinEntityGuardian implements EntityElderGuardian {
}
