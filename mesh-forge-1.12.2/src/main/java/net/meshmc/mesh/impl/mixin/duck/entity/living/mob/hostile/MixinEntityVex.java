package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.EntityVex;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityVex.class)
public abstract class MixinEntityVex extends MixinEntityHostile implements EntityVex {
}
