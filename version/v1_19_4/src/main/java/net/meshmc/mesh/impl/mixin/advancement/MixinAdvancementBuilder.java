package net.meshmc.mesh.impl.mixin.advancement;

import net.meshmc.mesh.api.advancement.Advancement;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(net.minecraft.advancement.Advancement.Builder.class)
public class MixinAdvancementBuilder implements Advancement.Builder {
    @Shadow @Nullable private Identifier parentId;
    @Shadow @Nullable private net.minecraft.advancement.Advancement parentObj;
    @Shadow @Nullable private String[][] requirements;

    @Override
    public LocationIdentifier getParentId() {
        return (LocationIdentifier) parentId;
    }

    @Override
    public Advancement getParent() {
        return (Advancement) parentObj;
    }

    @Override
    public void setParent(Advancement parent) {
        parentObj = (net.minecraft.advancement.Advancement) parent;
    }

    @Override
    public String[][] getRequirements() {
        return requirements;
    }
}
