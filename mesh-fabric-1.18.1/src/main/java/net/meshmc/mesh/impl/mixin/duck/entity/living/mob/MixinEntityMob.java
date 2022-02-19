package net.meshmc.mesh.impl.mixin.duck.entity.living.mob;

import net.meshmc.mesh.impl.mixin.duck.entity.living.MixinEntityLiving;
import net.meshmc.mesh.impl.mixininterface.entity.living.mob.EntityMob;
import net.minecraft.entity.mob.PathAwareEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PathAwareEntity.class)
public abstract class MixinEntityMob extends MixinEntityLiving implements EntityMob {
}
