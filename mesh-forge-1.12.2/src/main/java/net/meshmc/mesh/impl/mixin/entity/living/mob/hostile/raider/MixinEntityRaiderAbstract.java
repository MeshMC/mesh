package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityRaiderAbstract;
import net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.MixinEntityHostile;
import net.minecraft.entity.monster.AbstractIllager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractIllager.class)
public abstract class MixinEntityRaiderAbstract extends MixinEntityHostile implements EntityRaiderAbstract {
}
