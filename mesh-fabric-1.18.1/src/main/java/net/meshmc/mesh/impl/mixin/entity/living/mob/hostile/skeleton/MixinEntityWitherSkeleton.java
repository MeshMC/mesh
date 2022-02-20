package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.skeleton;

import net.meshmc.mesh.api.entity.living.mob.hostile.skeleton.EntityWitherSkeleton;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WitherSkeletonEntity.class)
public abstract class MixinEntityWitherSkeleton extends MixinEntitySkeletonAbstract implements EntityWitherSkeleton {
}
