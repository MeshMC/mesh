package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.zombie;

import dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.MixinEntityHostile;
import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.zombie.EntityZombie;
import net.minecraft.entity.mob.ZombieEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ZombieEntity.class)
public abstract class MixinEntityZombie extends MixinEntityHostile implements EntityZombie {
}
