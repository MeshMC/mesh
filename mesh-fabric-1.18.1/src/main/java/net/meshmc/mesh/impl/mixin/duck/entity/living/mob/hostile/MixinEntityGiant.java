package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.EntityGiant;
import net.minecraft.entity.mob.GiantEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GiantEntity.class)
public abstract class MixinEntityGiant extends MixinEntityHostile implements EntityGiant {
}