package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile.skeleton;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.skeleton.EntityWitherSkeleton;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WitherSkeletonEntity.class)
public abstract class MixinEntityWitherSkeleton extends MixinEntitySkeletonAbstract implements EntityWitherSkeleton {
}
