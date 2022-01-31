package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.piglin;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.piglin.EntityPiglinBrute;
import net.minecraft.entity.mob.PiglinBruteEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PiglinBruteEntity.class)
public abstract class MixinEntityPiglinBrute extends MixinEntityPiglinAbstract implements EntityPiglinBrute {
}
