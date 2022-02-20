package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityCreeper;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityCreeper.class)
public abstract class MixinEntityCreeper extends MixinEntityHostile implements EntityCreeper {
}
