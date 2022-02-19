package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.zombie.EntityZombiePigman;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ZombifiedPiglinEntity.class)
public abstract class MixinEntityZombiePigman extends MixinEntityZombie implements EntityZombiePigman {
}
