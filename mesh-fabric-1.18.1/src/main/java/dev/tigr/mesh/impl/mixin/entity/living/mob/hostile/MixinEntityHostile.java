package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile;

import dev.tigr.mesh.impl.mixin.entity.living.mob.MixinEntityMob;
import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.EntityHostile;
import net.minecraft.entity.mob.HostileEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(HostileEntity.class)
public abstract class MixinEntityHostile extends MixinEntityMob implements EntityHostile {
}
