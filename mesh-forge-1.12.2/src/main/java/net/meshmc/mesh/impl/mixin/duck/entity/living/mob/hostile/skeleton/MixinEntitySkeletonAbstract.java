package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.skeleton;

import net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.MixinEntityHostile;
import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.skeleton.EntitySkeletonAbstract;
import net.minecraft.entity.monster.AbstractSkeleton;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractSkeleton.class)
public abstract class MixinEntitySkeletonAbstract extends MixinEntityHostile implements EntitySkeletonAbstract {
}
