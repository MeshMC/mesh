package net.meshmc.mesh.impl.mixin.duck.entity.living;

import net.meshmc.mesh.impl.mixin.duck.entity.MixinEntity;
import net.meshmc.mesh.impl.mixininterface.entity.living.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityLivingBase.class)
public abstract class MixinEntityLiving extends MixinEntity implements EntityLiving {
}
