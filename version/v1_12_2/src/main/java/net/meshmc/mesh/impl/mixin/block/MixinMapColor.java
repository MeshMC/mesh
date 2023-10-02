package net.meshmc.mesh.impl.mixin.block;

import net.meshmc.mesh.api.block.MapColor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = net.minecraft.block.material.MapColor.class, priority = Integer.MAX_VALUE)
public class MixinMapColor implements MapColor {
    @Shadow @Final public int colorValue;
    @Shadow @Final public int colorIndex;

    @Override
    public int getColor() {
        return colorValue;
    }

    @Override
    public int getId() {
        return colorIndex;
    }
}
