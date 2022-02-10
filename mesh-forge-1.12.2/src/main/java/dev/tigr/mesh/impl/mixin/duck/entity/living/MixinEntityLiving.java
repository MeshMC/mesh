package dev.tigr.mesh.impl.mixin.duck.entity.living;

import dev.tigr.mesh.impl.mixin.duck.entity.MixinEntity;
import dev.tigr.mesh.impl.mixininterface.entity.living.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityLivingBase.class)
public abstract class MixinEntityLiving extends MixinEntity implements EntityLiving {
}
