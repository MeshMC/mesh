package net.meshmc.mesh.impl.mixin.duck.math;

import net.meshmc.mesh.impl.mixininterface.math.Vec2f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(net.minecraft.util.math.Vec2f.class)
public class MixinVec2f implements Vec2f {
    @Mutable @Shadow @Final public float x;
    @Mutable @Shadow @Final public float y;

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setX(float value) {
        x = value;
    }

    @Override
    public void setY(float value) {
        y = value;
    }
}
