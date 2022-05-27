package net.meshmc.mesh.impl.mixin.block;

import net.meshmc.mesh.impl.util.duck.BlockGlazedTerracottaDuck;
import net.minecraft.block.BlockGlazedTerracotta;
import net.minecraft.item.EnumDyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * This allows us to feed the dyeColor passed to the constructor directly to mappings
 */
@Mixin(BlockGlazedTerracotta.class)
public class MixinBlockGlazedTerracotta implements BlockGlazedTerracottaDuck {
    private EnumDyeColor color;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void onInit(EnumDyeColor color, CallbackInfo ci) {
        this.color = color;
    }

    @Override
    public EnumDyeColor getColor() {
        return color;
    }
}
