package dev.tigr.mesh.impl.mixin.entity.living.mob.passive;

import dev.tigr.mesh.impl.mixin.entity.living.mob.MixinEntityMob;
import dev.tigr.mesh.impl.mixininterface.entity.living.mob.passive.EntityPassive;
import net.minecraft.entity.EntityAgeable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityAgeable.class)
public abstract class MixinEntityPassive extends MixinEntityMob implements EntityPassive {
}
