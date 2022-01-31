package dev.tigr.mesh.impl.mixin.entity.living.mob.passive;

import dev.tigr.mesh.impl.mixin.entity.living.mob.MixinEntityMob;
import dev.tigr.mesh.impl.mixininterface.entity.living.mob.passive.EntityPassive;
import net.minecraft.entity.passive.PassiveEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PassiveEntity.class)
public abstract class MixinEntityPassive extends MixinEntityMob implements EntityPassive {
}
