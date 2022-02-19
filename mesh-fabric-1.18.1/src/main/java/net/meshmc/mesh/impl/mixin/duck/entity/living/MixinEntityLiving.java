package net.meshmc.mesh.impl.mixin.duck.entity.living;

import net.meshmc.mesh.impl.mixin.duck.entity.MixinEntity;
import net.meshmc.mesh.impl.mixininterface.entity.living.EntityLiving;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class MixinEntityLiving extends MixinEntity implements EntityLiving {
    @Shadow public float airStrafingSpeed;
}
