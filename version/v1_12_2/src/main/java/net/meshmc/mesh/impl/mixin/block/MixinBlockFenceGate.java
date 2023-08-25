package net.meshmc.mesh.impl.mixin.block;

import net.meshmc.mesh.impl.util.duck.BlockFenceGateDuck;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Allows us to feed the wood type in the constructor directly to mappings
 */
@Mixin(BlockFenceGate.class)
public class MixinBlockFenceGate implements BlockFenceGateDuck {
    private BlockPlanks.EnumType woodType;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void onInit(BlockPlanks.EnumType p_i46394_1_, CallbackInfo ci) {
        woodType = p_i46394_1_;
    }

    @Override
    public BlockPlanks.EnumType getWoodType() {
        return woodType;
    }
}
