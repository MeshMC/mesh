package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.skeleton;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.skeleton.EntitySkeleton;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntitySkeleton.class)
public abstract class MixinEntitySkeleton extends MixinEntitySkeletonAbstract implements EntitySkeleton {
}
