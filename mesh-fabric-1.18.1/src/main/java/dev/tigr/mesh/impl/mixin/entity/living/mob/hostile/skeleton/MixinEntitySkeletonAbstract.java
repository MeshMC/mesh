package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.skeleton;

import dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.MixinEntityHostile;
import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.skeleton.EntitySkeletonAbstract;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractSkeletonEntity.class)
public abstract class MixinEntitySkeletonAbstract extends MixinEntityHostile implements EntitySkeletonAbstract {
}
