package net.meshmc.mesh.impl.mixin.world;

import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(World.class)
public class MixinWorld implements net.meshmc.mesh.api.world.World {
}
