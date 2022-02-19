package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.MixinEntityHostile;
import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.zombie.EntityZombie;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityZombie.class)
public abstract class MixinEntityZombie extends MixinEntityHostile implements EntityZombie {
}
