package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile.zombie;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.zombie.EntityHusk;
import net.minecraft.entity.mob.HuskEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(HuskEntity.class)
public abstract class MixinEntityHusk extends MixinEntityZombie implements EntityHusk {
}
