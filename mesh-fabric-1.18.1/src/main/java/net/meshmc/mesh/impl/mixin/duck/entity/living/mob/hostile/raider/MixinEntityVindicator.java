package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.raider;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.raider.EntityVindicator;
import net.minecraft.entity.mob.VindicatorEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(VindicatorEntity.class)
public abstract class MixinEntityVindicator extends MixinEntityRaiderAbstract implements EntityVindicator {
}
