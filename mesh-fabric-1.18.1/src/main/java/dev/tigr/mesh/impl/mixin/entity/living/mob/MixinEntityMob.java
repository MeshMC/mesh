package dev.tigr.mesh.impl.mixin.entity.living.mob;

import dev.tigr.mesh.impl.mixin.entity.living.MixinEntityLiving;
import dev.tigr.mesh.impl.mixininterface.entity.living.mob.EntityMob;
import net.minecraft.entity.mob.PathAwareEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PathAwareEntity.class)
public abstract class MixinEntityMob extends MixinEntityLiving implements EntityMob {
}
