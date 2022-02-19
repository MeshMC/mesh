package net.meshmc.mesh.impl.mixin.duck.world;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(World.class)
public class MixinWorld implements net.meshmc.mesh.impl.mixininterface.world.World {
    @Shadow @Final public List<Entity> loadedEntityList;
}
