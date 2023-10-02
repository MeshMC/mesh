package net.meshmc.mesh.impl.mixin.accessors;

import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(HitResult.class)
public interface HitResultAccessor {
    @Accessor("pos")
    void setPos(Vec3d pos);
}
