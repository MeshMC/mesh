package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.zombie;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.zombie.EntityZombieVillager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityZombieVillager.class)
public abstract class MixinEntityZombieVillager extends MixinEntityZombie implements EntityZombieVillager {
}
