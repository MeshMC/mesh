package net.meshmc.mesh.impl.mixin.entity.living.mob.passive;

import net.meshmc.mesh.api.entity.living.mob.passive.EntityPassive;
import net.meshmc.mesh.impl.mixin.entity.living.mob.MixinEntityMob;
import net.minecraft.entity.passive.PassiveEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PassiveEntity.class)
public abstract class MixinEntityPassive extends MixinEntityMob implements EntityPassive {
}
