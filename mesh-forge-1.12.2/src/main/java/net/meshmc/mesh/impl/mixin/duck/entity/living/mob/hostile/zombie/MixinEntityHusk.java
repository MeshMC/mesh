package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.zombie.EntityHusk;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityHusk.class)
public abstract class MixinEntityHusk extends MixinEntityZombie implements EntityHusk {
}
