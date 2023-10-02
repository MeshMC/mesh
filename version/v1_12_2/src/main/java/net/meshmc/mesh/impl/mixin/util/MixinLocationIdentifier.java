package net.meshmc.mesh.impl.mixin.util;

import net.meshmc.mesh.api.util.LocationIdentifier;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ResourceLocation.class)
public abstract class MixinLocationIdentifier implements LocationIdentifier {
    @Override @Shadow public abstract String getNamespace();
    @Override @Shadow public abstract String getPath();
    @Override @Shadow public abstract String toString();
}
