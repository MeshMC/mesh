package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.skeleton;

import net.meshmc.mesh.api.entity.living.mob.hostile.skeleton.EntityStray;
import net.minecraft.entity.mob.StrayEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(StrayEntity.class)
public abstract class MixinEntityStray extends MixinEntitySkeletonAbstract implements EntityStray {
}
