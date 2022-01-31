package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.skeleton;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.skeleton.EntityWitherSkeleton;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityWitherSkeleton.class)
public abstract class MixinEntityWitherSkeleton extends MixinEntitySkeletonAbstract implements EntityWitherSkeleton {
}
