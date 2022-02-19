package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.EntityVex;
import net.minecraft.entity.mob.VexEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(VexEntity.class)
public abstract class MixinEntityVex extends MixinEntityHostile implements EntityVex {
}
