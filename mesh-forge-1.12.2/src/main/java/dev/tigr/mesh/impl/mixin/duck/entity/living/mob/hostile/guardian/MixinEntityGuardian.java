package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile.guardian;

import dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile.MixinEntityHostile;
import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.guardian.EntityGuardian;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityGuardian.class)
public abstract class MixinEntityGuardian extends MixinEntityHostile implements EntityGuardian {
}
