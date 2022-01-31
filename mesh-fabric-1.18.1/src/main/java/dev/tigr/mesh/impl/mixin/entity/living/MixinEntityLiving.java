package dev.tigr.mesh.impl.mixin.entity.living;

import dev.tigr.mesh.impl.mixin.entity.MixinEntity;
import dev.tigr.mesh.impl.mixininterface.entity.living.EntityLiving;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class MixinEntityLiving extends MixinEntity implements EntityLiving {
    @Shadow public float airStrafingSpeed;
}
