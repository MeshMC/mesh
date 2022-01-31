package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntityZoglin;
import net.minecraft.entity.mob.ZoglinEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ZoglinEntity.class)
public abstract class MixinEntityZoglin extends MixinEntityHostile implements EntityZoglin {
}
