package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntitySilverfish;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntitySilverfish.class)
public abstract class MixinEntitySilverfish extends MixinEntityHostile implements EntitySilverfish {
}
