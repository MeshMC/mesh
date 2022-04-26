package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.api.entity.living.mob.hostile.zombie.EntityZombie;
import net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.MixinEntityHostile;
import net.minecraft.entity.mob.ZombieEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ZombieEntity.class)
public abstract class MixinEntityZombie extends MixinEntityHostile implements EntityZombie {
}
