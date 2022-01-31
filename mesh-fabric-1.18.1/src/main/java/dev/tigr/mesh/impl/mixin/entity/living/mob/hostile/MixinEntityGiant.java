package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntityGiant;
import net.minecraft.entity.mob.GiantEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GiantEntity.class)
public abstract class MixinEntityGiant extends MixinEntityHostile implements EntityGiant {
}
