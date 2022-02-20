package net.meshmc.mesh.impl.mixin.entity.living;

import net.meshmc.mesh.impl.mixin.entity.MixinEntity;
import net.meshmc.mesh.api.entity.living.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityLivingBase.class)
public abstract class MixinEntityLiving extends MixinEntity implements EntityLiving {
}
