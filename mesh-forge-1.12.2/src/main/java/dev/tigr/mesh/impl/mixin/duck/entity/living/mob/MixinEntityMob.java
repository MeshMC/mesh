package dev.tigr.mesh.impl.mixin.duck.entity.living.mob;

import dev.tigr.mesh.impl.mixin.duck.entity.living.MixinEntityLiving;
import dev.tigr.mesh.impl.mixininterface.entity.living.mob.EntityMob;
import net.minecraft.entity.EntityCreature;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityCreature.class)
public abstract class MixinEntityMob extends MixinEntityLiving implements EntityMob {
}