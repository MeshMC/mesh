package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.zombie.EntityZombieVillager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityZombieVillager.class)
public abstract class MixinEntityZombieVillager extends MixinEntityZombie implements EntityZombieVillager {
}
