package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile.zombie;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.zombie.EntityZombiePigman;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ZombifiedPiglinEntity.class)
public abstract class MixinEntityZombiePigman extends MixinEntityZombie implements EntityZombiePigman {
}
