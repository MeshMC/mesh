package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityRavager;
import net.minecraft.entity.mob.RavagerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RavagerEntity.class)
public abstract class MixinEntityRavager extends MixinEntityRaiderAbstract implements EntityRavager {
}