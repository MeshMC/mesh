package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.api.entity.living.mob.hostile.zombie.EntityHusk;
import net.minecraft.entity.mob.HuskEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(HuskEntity.class)
public abstract class MixinEntityHusk extends MixinEntityZombie implements EntityHusk {
}
