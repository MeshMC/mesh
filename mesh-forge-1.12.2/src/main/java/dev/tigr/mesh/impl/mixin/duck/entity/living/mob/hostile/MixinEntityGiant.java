package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntityGiant;
import net.minecraft.entity.monster.EntityGiantZombie;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityGiantZombie.class)
public abstract class MixinEntityGiant extends MixinEntityHostile implements EntityGiant {
}
