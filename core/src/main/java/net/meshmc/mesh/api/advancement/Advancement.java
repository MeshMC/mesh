package net.meshmc.mesh.api.advancement;

import net.meshmc.mesh.api.util.LocationIdentifier;

import java.util.Set;

public interface Advancement {
    //TODO: create
    Advancement getParent();
    LocationIdentifier getId();
    String[][] getRequirements();
    Set<Advancement> getChildren();
    //TODO: DisplayInfo, AdvancementRewards, Criterion, ITextComponent

    Builder copyTask();

    String toString();

    void addChild(Advancement advancement);

    boolean equals(Object object);

    int hashCode();

    interface Builder {
        LocationIdentifier getParentId();
        Advancement getParent();
        void setParent(Advancement parent);
        //TODO: DisplayInfo, AdvancementRewards, Criterion
        String[][] getRequirements();
    }
}
