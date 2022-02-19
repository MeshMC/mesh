package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile;

import net.meshmc.mesh.impl.mixin.duck.entity.living.mob.MixinEntityMob;
import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.EntityHostile;
import net.minecraft.entity.mob.HostileEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(HostileEntity.class)
public abstract class MixinEntityHostile extends MixinEntityMob implements EntityHostile {
}
