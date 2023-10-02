package net.meshmc.mesh.impl.mixin.advancement;

import net.meshmc.mesh.api.util.LocationIdentifier;
import net.minecraft.advancements.Advancement;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Advancement.Builder.class)
public class MixinAdvancementBuilder implements net.meshmc.mesh.api.advancement.Advancement.Builder {
    @Shadow @Final private ResourceLocation parentId;
    @Shadow private Advancement parent;
    @Shadow @Final private String[][] requirements;

    @Override
    public LocationIdentifier getParentId() {
        return (LocationIdentifier) parentId;
    }

    @Override
    public net.meshmc.mesh.api.advancement.Advancement getParent() {
        return (net.meshmc.mesh.api.advancement.Advancement) parent;
    }

    @Override
    public void setParent(net.meshmc.mesh.api.advancement.Advancement parent) {
        this.parent = (Advancement) parent;
    }

    @Override
    public String[][] getRequirements() {
        return requirements;
    }
}
