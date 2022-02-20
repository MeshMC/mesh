package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.raider;

import net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.MixinEntityHostile;
import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityWitch;
import net.minecraft.entity.mob.WitchEntity;
import org.spongepowered.asm.mixin.Mixin;

/**
 * EntityWitch is a raider in later versions, but in 1.12 Witch does not extend the same class as other Illagers
 */
@Mixin(WitchEntity.class)
public abstract class MixinEntityWitch extends MixinEntityHostile implements EntityWitch {
}
