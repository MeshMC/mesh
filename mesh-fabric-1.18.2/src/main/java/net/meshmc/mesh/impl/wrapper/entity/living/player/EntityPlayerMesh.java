package net.meshmc.mesh.impl.wrapper.entity.living.player;

import net.meshmc.mesh.api.entity.living.player.EntityPlayer;
import net.meshmc.mesh.impl.mixin.accessors.entity.PlayerEntityAccessor;
import net.meshmc.mesh.impl.wrapper.entity.living.EntityLivingMesh;
import net.minecraft.entity.player.PlayerEntity;

public class EntityPlayerMesh<T extends PlayerEntity> extends EntityLivingMesh<T> implements EntityPlayer {
    public EntityPlayerMesh(T value) {
        super(value);
    }

    @Override
    public int getFlyToggleTimer() {
        return ((PlayerEntityAccessor) getMeshValue()).getFlyToggleTimer();
    }

    @Override
    public void setFlyToggleTimer(int value) {
        ((PlayerEntityAccessor) getMeshValue()).setFlyToggleTimer(value);
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
        return ((PlayerEntityAccessor) getMeshValue()).getLastXPSound();
    }

    @Override
    public void setLastXPSound(int value) {
        ((PlayerEntityAccessor) getMeshValue()).setLastXPSound(value);
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
