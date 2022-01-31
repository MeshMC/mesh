package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntityVex;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityVex.class)
public abstract class MixinEntityVex extends MixinEntityHostile implements EntityVex {
}
