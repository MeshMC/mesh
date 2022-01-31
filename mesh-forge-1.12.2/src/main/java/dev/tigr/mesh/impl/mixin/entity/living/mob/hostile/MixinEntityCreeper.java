package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntityCreeper;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityCreeper.class)
public abstract class MixinEntityCreeper extends MixinEntityHostile implements EntityCreeper {
}
