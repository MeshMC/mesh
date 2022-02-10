package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile.zombie;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.zombie.EntityHusk;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityHusk.class)
public abstract class MixinEntityHusk extends MixinEntityZombie implements EntityHusk {
}
