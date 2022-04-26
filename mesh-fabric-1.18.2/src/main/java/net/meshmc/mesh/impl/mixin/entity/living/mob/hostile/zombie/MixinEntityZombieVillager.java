package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.api.entity.living.mob.hostile.zombie.EntityZombieVillager;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ZombieVillagerEntity.class)
public abstract class MixinEntityZombieVillager extends MixinEntityZombie implements EntityZombieVillager {
}
