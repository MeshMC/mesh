package dev.tigr.mesh.api.entity.player;


import dev.tigr.mesh.api.entity.Entity;

/**
 * @author Tigermouthbear 1/16/22
 */
public interface PlayerEntity<T> extends Entity<T> {
    // TODO: INVENTORY AND HUNGER

    int getFlyToggleTimer();
    void setFlyToggleTimer(int value);

    /*TODO: NOT IN FABRIC
    float getPrevCameraYaw();
    float getCameraYaw();
    void setPrevCameraYaw(float value);
    void setCameraYaw(float value);
     */

    int getXpCooldown();
    void setXpCooldown(int value);

    // cape(X,Y,Z)
    double getChasingX();
    double getChasingY();
    double getChasingZ();
    void setChasingX(double value);
    void setChasingY(double value);
    void setChasingZ(double value);

    double getPrevChasingX();
    double getPrevChasingY();
    double getPrevChasingZ();
    void setPrevChasingX(double value);
    void setPrevChasingY(double value);
    void setPrevChasingZ(double value);

    // TODO: is sleeping?

    int getSleepTimer();
    void setSleepTimer(int value);

    // TODO: submerged in water

    // TODO: ABILITIES

    int getExperienceLevel();
    void setExperienceLevel(int value);

    int getTotalExperience();
    void setTotalExperience(int value);

    float getExperienceProgress();
    void setExperienceProgress(float value);

    int getEnchantmentTableSeed();
    void setEnchantmentTableSeed(int value);

    // field_7509
    float getSpeedInAir();
    void setSpeedInAir(float value);

    int getLastXPSound();
    void setLastXPSound(int value);

    // TODO: GAME PROFILE

    boolean hasReducedDebug();
    void setReducedDebug(boolean value);

    // TODO: ITEMSTACK, ITEM COOLDOWN, AND FISH HOOK

    // TODO: METHODS
}
