package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.raider;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.raider.EntityPillager;
import net.minecraft.entity.mob.PillagerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PillagerEntity.class)
public abstract class MixinEntityPillager extends MixinEntityRaiderAbstract implements EntityPillager {
}
