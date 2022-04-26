package net.meshmc.mesh.impl.mixin.advancement;

import net.meshmc.mesh.api.advancement.AdvancementProgress;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Date;

@Mixin(net.minecraft.advancement.AdvancementProgress.class)
public abstract class MixinAdvancementProgress implements AdvancementProgress {
    @Shadow private String[][] requirements;
    @Shadow public abstract boolean obtain(String name);
    @Shadow public abstract boolean reset(String name);
    @Shadow public abstract float getProgressBarPercentage();
    @Shadow protected abstract int countObtainedRequirements();
    @Shadow public abstract Iterable<String> getUnobtainedCriteria();
    @Shadow public abstract Iterable<String> getObtainedCriteria();
    @Shadow @Nullable public abstract Date getEarliestProgressObtainDate();
    @Shadow public abstract int compareTo(Object par1);
    @Shadow @Nullable public abstract String getProgressBarFraction();
    @Shadow public abstract boolean isAnyObtained();

    @Override
    public String[][] getRequirements() {
        return requirements;
    }

    @Override @Shadow public abstract boolean isDone();

    @Override
    public boolean hasProgress() {
        return isAnyObtained();
    }

    @Override
    public boolean grantCriterion(String name) {
        return obtain(name);
    }

    @Override
    public boolean revokeCriterion(String name) {
        return reset(name);
    }

    @Override
    public float getPercent() {
        return getProgressBarPercentage();
    }

    @Override
    public String getProgressText() {
        return getProgressBarFraction();
    }

    @Override
    public int countFinishedRequirements() {
        return countObtainedRequirements();
    }

    @Override
    public Iterable<String> getUnfinishedCriteria() {
        return getUnobtainedCriteria();
    }

    @Override
    public Iterable<String> getFinishedCriteria() {
        return getObtainedCriteria();
    }

    @Override
    public Date getFirstProgressDate() {
        return getEarliestProgressObtainDate();
    }

    @Override
    public int compare(AdvancementProgress advancementProgress) {
        return compareTo(advancementProgress);
    }
}
