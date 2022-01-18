package dev.tigr.mesh.impl.entity.player;

import dev.tigr.mesh.impl.entity.EntityMesh;
import dev.tigr.mesh.impl.mixin.accessors.entity.PlayerEntityAccessor;
import dev.tigr.mesh.api.entity.player.PlayerEntity;

/**
 * @author Tigermouthbear 1/16/22
 */
public class PlayerEntityMesh extends EntityMesh<net.minecraft.entity.player.PlayerEntity> implements PlayerEntity<net.minecraft.entity.player.PlayerEntity> {
    public PlayerEntityMesh(net.minecraft.entity.player.PlayerEntity value) {
        super(value);
    }

    @Override
    public int getFlyToggleTimer() {
        return ((PlayerEntityAccessor) getMeshValue()).getAbilityResyncCountdown();
    }

    @Override
    public void setFlyToggleTimer(int value) {
        ((PlayerEntityAccessor) getMeshValue()).setAbilityResyncCountdown(value);
    }

    @Override
    public int getXpCooldown() {
        return getMeshValue().experiencePickUpDelay;
    }

    @Override
    public void setXpCooldown(int value) {
        getMeshValue().experiencePickUpDelay = value;
    }

    @Override
    public double getChasingX() {
        return getMeshValue().capeX;
    }

    @Override
    public double getChasingY() {
        return getMeshValue().capeY;
    }

    @Override
    public double getChasingZ() {
        return getMeshValue().capeZ;
    }

    @Override
    public void setChasingX(double value) {
        getMeshValue().capeX = value;
    }

    @Override
    public void setChasingY(double value) {
        getMeshValue().capeY = value;
    }

    @Override
    public void setChasingZ(double value) {
        getMeshValue().capeZ = value;
    }

    @Override
    public double getPrevChasingX() {
        return getMeshValue().prevCapeX;
    }

    @Override
    public double getPrevChasingY() {
        return getMeshValue().prevCapeY;
    }

    @Override
    public double getPrevChasingZ() {
        return getMeshValue().prevCapeZ;
    }

    @Override
    public void setPrevChasingX(double value) {
        getMeshValue().prevCapeX = value;
    }

    @Override
    public void setPrevChasingY(double value) {
        getMeshValue().prevCapeY = value;
    }

    @Override
    public void setPrevChasingZ(double value) {
        getMeshValue().prevCapeZ = value;
    }

    @Override
    public int getSleepTimer() {
        return getMeshValue().getSleepTimer();
    }

    @Override
    public void setSleepTimer(int value) {
        ((PlayerEntityAccessor) getMeshValue()).setSleepTimer(value);
    }

    @Override
    public int getExperienceLevel() {
        return getMeshValue().experienceLevel;
    }

    @Override
    public void setExperienceLevel(int value) {
        getMeshValue().experienceLevel = value;
    }

    @Override
    public int getTotalExperience() {
        return getMeshValue().totalExperience;
    }

    @Override
    public void setTotalExperience(int value) {
        getMeshValue().totalExperience = value;
    }

    @Override
    public float getExperienceProgress() {
        return getMeshValue().experienceProgress;
    }

    @Override
    public void setExperienceProgress(float value) {
        getMeshValue().experienceProgress = value;
    }

    @Override
    public int getEnchantmentTableSeed() {
        return getMeshValue().getEnchantmentTableSeed();
    }

    @Override
    public void setEnchantmentTableSeed(int value) {
        ((PlayerEntityAccessor) getMeshValue()).setEnchantmentTableSeed(value);
    }

    @Override
    public float getSpeedInAir() {
        return getMeshValue().airStrafingSpeed;
    }

    @Override
    public void setSpeedInAir(float value) {
        getMeshValue().airStrafingSpeed = value;
    }

    @Override
    public int getLastXPSound() {
        return ((PlayerEntityAccessor) getMeshValue()).getLastPlayedLevelUpSoundTime();
    }

    @Override
    public void setLastXPSound(int value) {
        ((PlayerEntityAccessor) getMeshValue()).setLastPlayedLevelUpSoundTime(value);
    }

    @Override
    public boolean hasReducedDebug() {
        return getMeshValue().hasReducedDebugInfo();
    }

    @Override
    public void setReducedDebug(boolean value) {
        getMeshValue().setReducedDebugInfo(value);
    }
}
