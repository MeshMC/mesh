package dev.tigr.mesh.impl.entity.player;

import dev.tigr.mesh.api.entity.player.PlayerEntity;
import dev.tigr.mesh.impl.entity.EntityMesh;
import dev.tigr.mesh.impl.mixin.accessors.entity.EntityPlayerAccessor;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @author Tigermouthbear 1/16/22
 */
public class PlayerEntityMesh extends EntityMesh<EntityPlayer> implements PlayerEntity<EntityPlayer> {
    public PlayerEntityMesh(EntityPlayer value) {
        super(value);
    }

    @Override
    public int getFlyToggleTimer() {
        return ((EntityPlayerAccessor) getMeshValue()).getFlyToggleTimer();
    }

    @Override
    public void setFlyToggleTimer(int value) {
        ((EntityPlayerAccessor) getMeshValue()).setFlyToggleTimer(value);
    }

    @Override
    public int getXpCooldown() {
        return getMeshValue().xpCooldown;
    }

    @Override
    public void setXpCooldown(int value) {
        getMeshValue().xpCooldown = value;
    }

    @Override
    public double getChasingX() {
        return getMeshValue().chasingPosX;
    }

    @Override
    public double getChasingY() {
        return getMeshValue().chasingPosY;
    }

    @Override
    public double getChasingZ() {
        return getMeshValue().chasingPosZ;
    }

    @Override
    public void setChasingX(double value) {
        getMeshValue().chasingPosX = value;
    }

    @Override
    public void setChasingY(double value) {
        getMeshValue().chasingPosY = value;
    }

    @Override
    public void setChasingZ(double value) {
        getMeshValue().chasingPosZ = value;
    }

    @Override
    public double getPrevChasingX() {
        return getMeshValue().prevChasingPosX;
    }

    @Override
    public double getPrevChasingY() {
        return getMeshValue().prevChasingPosY;
    }

    @Override
    public double getPrevChasingZ() {
        return getMeshValue().prevChasingPosZ;
    }

    @Override
    public void setPrevChasingX(double value) {
        getMeshValue().prevChasingPosX = value;
    }

    @Override
    public void setPrevChasingY(double value) {
        getMeshValue().prevChasingPosY = value;
    }

    @Override
    public void setPrevChasingZ(double value) {
        getMeshValue().prevChasingPosZ = value;
    }

    @Override
    public int getSleepTimer() {
        return getMeshValue().getSleepTimer();
    }

    @Override
    public void setSleepTimer(int value) {
        ((EntityPlayerAccessor) getMeshValue()).setSleepTimer(value);
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
        return getMeshValue().experienceTotal;
    }

    @Override
    public void setTotalExperience(int value) {
        getMeshValue().experienceTotal = value;
    }

    @Override
    public float getExperienceProgress() {
        return getMeshValue().experience;
    }

    @Override
    public void setExperienceProgress(float value) {
        getMeshValue().experience = value;
    }

    @Override
    public int getEnchantmentTableSeed() {
        return getMeshValue().getXPSeed();
    }

    @Override
    public void setEnchantmentTableSeed(int value) {
        ((EntityPlayerAccessor) getMeshValue()).setXpSeed(value);
    }

    @Override
    public float getSpeedInAir() {
        return ((EntityPlayerAccessor) getMeshValue()).getSpeedInAir();
    }

    @Override
    public void setSpeedInAir(float value) {
        ((EntityPlayerAccessor) getMeshValue()).setSpeedInAir(value);
    }

    @Override
    public int getLastXPSound() {
        return ((EntityPlayerAccessor) getMeshValue()).getLastXPSound();
    }

    @Override
    public void setLastXPSound(int value) {
        ((EntityPlayerAccessor) getMeshValue()).setLastXPSound(value);
    }

    @Override
    public boolean hasReducedDebug() {
        return getMeshValue().hasReducedDebug();
    }

    @Override
    public void setReducedDebug(boolean value) {
        getMeshValue().setReducedDebug(value);
    }
}
