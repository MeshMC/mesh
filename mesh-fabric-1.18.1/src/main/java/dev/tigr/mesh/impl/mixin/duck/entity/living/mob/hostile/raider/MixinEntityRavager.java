package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile.raider;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.raider.EntityRavager;
import net.minecraft.entity.mob.RavagerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RavagerEntity.class)
public abstract class MixinEntityRavager extends MixinEntityRaiderAbstract implements EntityRavager {
}
