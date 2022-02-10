package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile.zombie;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.zombie.EntityZombieVillager;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ZombieVillagerEntity.class)
public abstract class MixinEntityZombieVillager extends MixinEntityZombie implements EntityZombieVillager {
}
