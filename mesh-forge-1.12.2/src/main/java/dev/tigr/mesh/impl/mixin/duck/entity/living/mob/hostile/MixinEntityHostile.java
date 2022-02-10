package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixin.duck.entity.living.mob.MixinEntityMob;
import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntityHostile;
import net.minecraft.entity.monster.EntityMob;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityMob.class)
public abstract class MixinEntityHostile extends MixinEntityMob implements EntityHostile {
}
