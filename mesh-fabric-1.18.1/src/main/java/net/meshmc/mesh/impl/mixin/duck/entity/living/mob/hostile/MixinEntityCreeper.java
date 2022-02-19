package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.EntityCreeper;
import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CreeperEntity.class)
public abstract class MixinEntityCreeper extends MixinEntityHostile implements EntityCreeper {
}
