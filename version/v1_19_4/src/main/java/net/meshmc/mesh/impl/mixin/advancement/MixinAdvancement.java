package net.meshmc.mesh.impl.mixin.advancement;

import net.meshmc.mesh.api.advancement.Advancement;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.meshmc.mesh.util.collections.SetWrapper;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Set;

@Mixin(net.minecraft.advancement.Advancement.class)
public abstract class MixinAdvancement implements Advancement {
    @Shadow @Final @Nullable private net.minecraft.advancement.Advancement parent;
    @Shadow @Final private Identifier id;
    @Shadow @Final private String[][] requirements;
    @Shadow @Final private Set<net.minecraft.advancement.Advancement> children;
    @Shadow public abstract net.minecraft.advancement.Advancement.Builder createTask();

    @Override
    public Advancement getParent() {
        return (Advancement) parent;
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
        return (Builder) createTask();
    }

    @Override
    public void addChild(Advancement advancement) {
        children.add((net.minecraft.advancement.Advancement) advancement);
    }
}
