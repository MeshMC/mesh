package net.meshmc.mesh.impl.mixin.advancement;

import net.meshmc.mesh.api.advancement.AdvancementProgress;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Date;

@Mixin(net.minecraft.advancements.AdvancementProgress.class)
public abstract class MixinAdvancementProgress implements AdvancementProgress {
    @Shadow private String[][] requirements;
    @Shadow protected abstract int countCompletedRequirements();
    @Shadow public abstract Iterable<String> getRemaningCriteria();
    @Shadow public abstract Iterable<String> getCompletedCriteria();
    @Shadow public abstract int compareTo(Object par1);

    @Override
    public String[][] getRequirements() {
        return requirements;
    }

    @Override @Shadow public abstract boolean isDone();
    @Override @Shadow public abstract boolean hasProgress();
    @Override @Shadow public abstract boolean grantCriterion(String name);
    @Override @Shadow public abstract boolean revokeCriterion(String name);
    @Override @Shadow public abstract float getPercent();
    @Override @Shadow public abstract String getProgressText();

    @Override
    public int countFinishedRequirements() {
        return countCompletedRequirements();
    }

    @Override
    public Iterable<String> getUnfinishedCriteria() {
        return getRemaningCriteria();
    }

    @Override
    public Iterable<String> getFinishedCriteria() {
        return getCompletedCriteria();
    }

    @Override @Shadow public abstract Date getFirstProgressDate();

    @Override
    public int compare(AdvancementProgress advancementProgress) {
        return compareTo(advancementProgress);
    }
}
