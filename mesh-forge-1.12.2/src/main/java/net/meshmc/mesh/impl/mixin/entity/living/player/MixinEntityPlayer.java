package net.meshmc.mesh.impl.mixin.entity.living.player;

import net.meshmc.mesh.impl.mixin.entity.living.MixinEntityLiving;
import net.meshmc.mesh.api.entity.living.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * @author Tigermouthbear 1/16/22
 * @author Makrennel    - moved from wrapper to mixin+interface 2022/01/30
 */
@Mixin(net.minecraft.entity.player.EntityPlayer.class)
public abstract class MixinEntityPlayer extends MixinEntityLiving implements EntityPlayer {
    @Shadow protected int flyToggleTimer;
    @Shadow public int xpCooldown;
    @Shadow public double chasingPosX;
    @Shadow public double chasingPosY;
    @Shadow public double chasingPosZ;
    @Shadow public double prevChasingPosX;
    @Shadow public double prevChasingPosY;
    @Shadow public double prevChasingPosZ;
    @Shadow private int sleepTimer;
    @Shadow public int experienceLevel;
    @Shadow public int experienceTotal;
    @Shadow public float experience;
    @Shadow protected int xpSeed;
    @Shadow protected float speedInAir;
    @Shadow private int lastXPSound;

    @Override
    public int getFlyToggleTimer() {
        return flyToggleTimer;
    }

    @Override
    public void setFlyToggleTimer(int value) {
        flyToggleTimer = value;
    }

    @Override
    public int getXpCooldown() {
        return xpCooldown;
    }

    @Override
    public void setXpCooldown(int value) {
        xpCooldown = value;
    }

    @Override
    public double getChasingX() {
        return chasingPosX;
    }

    @Override
    public double getChasingY() {
        return chasingPosY;
    }

    @Override
    public double getChasingZ() {
        return chasingPosZ;
    }

    @Override
    public void setChasingX(double value) {
        chasingPosX = value;
    }

    @Override
    public void setChasingY(double value) {
        chasingPosY = value;
    }

    @Override
    public void setChasingZ(double value) {
        chasingPosZ = value;
    }

    @Override
    public double getPrevChasingX() {
        return prevChasingPosX;
    }

    @Override
    public double getPrevChasingY() {
        return prevChasingPosY;
    }

    @Override
    public double getPrevChasingZ() {
        return prevChasingPosZ;
    }

    @Override
    public void setPrevChasingX(double value) {
        prevChasingPosX = value;
    }

    @Override
    public void setPrevChasingY(double value) {
        prevChasingPosY = value;
    }

    @Override
    public void setPrevChasingZ(double value) {
        prevChasingPosZ = value;
    }

    @Override
    public int getSleepTimer() {
        return sleepTimer;
    }

    @Override
    public void setSleepTimer(int value) {
        sleepTimer = value;
    }

    @Override
    public int getExperienceLevel() {
        return experienceLevel;
    }

    @Override
    public void setExperienceLevel(int value) {
        experienceLevel = value;
    }

    @Override
    public int getTotalExperience() {
        return experienceTotal;
    }

    @Override
    public void setTotalExperience(int value) {
        experienceTotal = value;
    }

    @Override
    public float getExperienceProgress() {
        return experience;
    }

    @Override
    public void setExperienceProgress(float value) {
        experience = value;
    }

    @Override
    public int getEnchantmentTableSeed() {
        return xpSeed;
    }

    @Override
    public void setEnchantmentTableSeed(int value) {
        xpSeed = value;
    }

    @Override
    public float getSpeedInAir() {
        return speedInAir;
    }

    @Override
    public void setSpeedInAir(float value) {
        speedInAir = value;
    }

    @Override
    public int getLastXPSound() {
        return lastXPSound;
    }

    @Override
    public void setLastXPSound(int value) {
        lastXPSound = value;
    }

    @Override @Shadow public abstract boolean hasReducedDebug();
    @Override @Shadow public abstract void setReducedDebug(boolean value);
}
