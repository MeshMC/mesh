package net.meshmc.mesh.impl.mixin.advancement;

import net.meshmc.mesh.api.advancement.Advancement;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.meshmc.mesh.util.collections.SetWrapper;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Set;

@Mixin(net.minecraft.advancements.Advancement.class)
public abstract class MixinAdvancement implements Advancement {
    @Shadow @Final private ResourceLocation id;
    @Shadow @Final private String[][] requirements;
    @Shadow @Final private Set<net.minecraft.advancements.Advancement> children;
    @Shadow public abstract net.minecraft.advancements.Advancement.Builder copy();

    @Override
    public Advancement getParent() {
        return (Advancement) id;
    }

    @Override
    public LocationIdentifier getId() {
        return (LocationIdentifier) id;
    }

    @Override
    public String[][] getRequirements() {
        return requirements;
    }

    @Override
    public Set<Advancement> getChildren() {
        return new SetWrapper<>(children);
    }

    @Override
    public Builder copyTask() {
        return (Builder) copy();
    }

    @Override
    public void addChild(Advancement advancement) {
        children.add((net.minecraft.advancements.Advancement) advancement);
    }
}
