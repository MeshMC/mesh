package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.passive;

import net.meshmc.mesh.impl.mixin.duck.entity.living.mob.MixinEntityMob;
import net.meshmc.mesh.impl.mixininterface.entity.living.mob.passive.EntityPassive;
import net.minecraft.entity.EntityAgeable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityAgeable.class)
public abstract class MixinEntityPassive extends MixinEntityMob implements EntityPassive {
}
