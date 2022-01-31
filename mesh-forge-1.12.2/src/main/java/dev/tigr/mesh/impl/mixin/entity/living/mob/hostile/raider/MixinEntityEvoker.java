package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.raider;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.raider.EntityEvoker;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityEvoker.class)
public abstract class MixinEntityEvoker extends MixinEntityIllagerSpellcaster implements EntityEvoker {
}
