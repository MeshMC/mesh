package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityGiant;
import net.minecraft.entity.monster.EntityGiantZombie;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityGiantZombie.class)
public abstract class MixinEntityGiant extends MixinEntityHostile implements EntityGiant {
}
