package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.raider;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.raider.EntityVindicator;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityVindicator.class)
public abstract class MixinEntityVindicator extends MixinEntityRaiderAbstract implements EntityVindicator {
}
