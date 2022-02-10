package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile.raider;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.raider.EntityEvoker;
import net.minecraft.entity.mob.EvokerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EvokerEntity.class)
public abstract class MixinEntityEvoker extends MixinEntityIllagerSpellcaster implements EntityEvoker {
}
