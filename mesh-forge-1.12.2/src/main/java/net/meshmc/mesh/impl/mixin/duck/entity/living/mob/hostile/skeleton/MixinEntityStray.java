package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.skeleton;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.skeleton.EntityStray;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityStray.class)
public abstract class MixinEntityStray extends MixinEntitySkeletonAbstract implements EntityStray {
}
