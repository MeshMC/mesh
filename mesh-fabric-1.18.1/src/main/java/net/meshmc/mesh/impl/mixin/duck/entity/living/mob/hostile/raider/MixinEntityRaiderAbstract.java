package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.raider;

import net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.MixinEntityHostile;
import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.raider.EntityRaiderAbstract;
import net.minecraft.entity.raid.RaiderEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RaiderEntity.class)
public abstract class MixinEntityRaiderAbstract extends MixinEntityHostile implements EntityRaiderAbstract {
}
