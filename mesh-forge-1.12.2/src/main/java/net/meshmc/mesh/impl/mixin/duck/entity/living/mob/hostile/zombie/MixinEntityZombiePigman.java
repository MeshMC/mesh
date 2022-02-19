package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.zombie.EntityZombiePigman;
import net.minecraft.entity.monster.EntityPigZombie;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityPigZombie.class)
public abstract class MixinEntityZombiePigman extends MixinEntityZombie implements EntityZombiePigman {
}
