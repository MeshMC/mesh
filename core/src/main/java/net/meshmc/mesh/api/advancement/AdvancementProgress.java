package net.meshmc.mesh.api.advancement;

import java.util.Date;

public interface AdvancementProgress {
    //TODO: CriterionProgress
    String[][] getRequirements();

    boolean isDone();

    boolean hasProgress();

    boolean grantCriterion(String name);

    boolean revokeCriterion(String name);

    String toString();

    float getPercent();

    String getProgressText();

    int countFinishedRequirements();

    Iterable<String> getUnfinishedCriteria();

    Iterable<String> getFinishedCriteria();

    Date getFirstProgressDate();

    int compare(AdvancementProgress advancementProgress);

    //TODO: Serializer?
}
