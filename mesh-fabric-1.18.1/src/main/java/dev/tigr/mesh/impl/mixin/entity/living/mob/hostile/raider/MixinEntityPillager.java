package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.raider;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.raider.EntityPillager;
import net.minecraft.entity.mob.PillagerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PillagerEntity.class)
public abstract class MixinEntityPillager extends MixinEntityRaiderAbstract implements EntityPillager {
}
