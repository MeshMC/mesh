package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.skeleton;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.skeleton.EntitySkeleton;
import net.minecraft.entity.mob.SkeletonEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SkeletonEntity.class)
public abstract class MixinEntitySkeleton extends MixinEntitySkeletonAbstract implements EntitySkeleton {
}
