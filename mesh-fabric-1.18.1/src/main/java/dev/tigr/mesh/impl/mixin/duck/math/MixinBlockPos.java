package dev.tigr.mesh.impl.mixin.duck.math;

import dev.tigr.mesh.impl.mixininterface.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.util.math.BlockPos.class)
public class MixinBlockPos extends MixinVec3i implements BlockPos {
}
