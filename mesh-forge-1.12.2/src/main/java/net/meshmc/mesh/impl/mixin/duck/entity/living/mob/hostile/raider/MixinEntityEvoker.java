package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.raider;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.raider.EntityEvoker;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityEvoker.class)
public abstract class MixinEntityEvoker extends MixinEntityIllagerSpellcaster implements EntityEvoker {
}