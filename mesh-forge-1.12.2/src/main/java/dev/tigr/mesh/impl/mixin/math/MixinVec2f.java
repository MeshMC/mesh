package dev.tigr.mesh.impl.mixin.math;

import dev.tigr.mesh.impl.mixininterface.IVec2f;
import net.minecraft.util.math.Vec2f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Vec2f.class)
public class MixinVec2f implements IVec2f {
    @Mutable
    @Shadow @Final public float x;

    @Mutable
    @Shadow @Final public float y;

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }
}
