package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.guardian;

import net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.MixinEntityHostile;
import net.meshmc.mesh.api.entity.living.mob.hostile.guardian.EntityGuardian;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityGuardian.class)
public abstract class MixinEntityGuardian extends MixinEntityHostile implements EntityGuardian {
}
