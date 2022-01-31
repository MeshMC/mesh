package dev.tigr.mesh.impl.mixin.client;

import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(World.class)
public class MixinWorld implements dev.tigr.mesh.impl.mixininterface.world.World {
}
