package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.api.entity.living.mob.hostile.zombie.EntityDrowned;
import net.minecraft.entity.mob.DrownedEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(DrownedEntity.class)
public abstract class MixinEntityDrowned extends MixinEntityZombie implements EntityDrowned {
}
