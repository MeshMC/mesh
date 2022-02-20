package net.meshmc.mesh.impl.mixin.math;

import net.meshmc.mesh.api.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.util.math.BlockPos.class)
public class MixinBlockPos extends MixinVec3i implements BlockPos {
}
