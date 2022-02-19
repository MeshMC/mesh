package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.raider;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.raider.EntityIllusioner;
import net.minecraft.entity.mob.IllusionerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(IllusionerEntity.class)
public abstract class MixinEntityIllusioner extends MixinEntityIllagerSpellcaster implements EntityIllusioner {
}
