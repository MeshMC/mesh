package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntityVex;
import net.minecraft.entity.mob.VexEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(VexEntity.class)
public abstract class MixinEntityVex extends MixinEntityHostile implements EntityVex {
}
