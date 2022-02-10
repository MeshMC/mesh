package dev.tigr.mesh.impl.mixin.duck.entity.living.player;

import dev.tigr.mesh.impl.mixin.duck.entity.living.MixinEntityLiving;
import dev.tigr.mesh.impl.mixininterface.entity.living.player.EntityPlayer;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * @author Tigermouthbear 1/16/22
 * @author Makrennel    - moved from wrapper to mixin+interface 2022/01/30
 */
@Mixin(PlayerEntity.class)
public abstract class MixinEntityPlayer extends MixinEntityLiving implements EntityPlayer {
    @Shadow protected int abilityResyncCountdown;
    @Shadow public int experiencePickUpDelay;
    @Shadow public double capeX;
    @Shadow public double capeY;
    @Shadow public double capeZ;
    @Shadow public double prevCapeX;
    @Shadow public double prevCapeZ;
    @Shadow public double prevCapeY;
    @Shadow private int sleepTimer;
    @Shadow public int experienceLevel;
    @Shadow public int totalExperience;
    @Shadow public float experienceProgress;
    @Shadow protected int enchantmentTableSeed;
    @Shadow private int lastPlayedLevelUpSoundTime;
    @Shadow public abstract boolean hasReducedDebugInfo();
    @Shadow public abstract void setReducedDebugInfo(boolean reducedDebugInfo);

    @Override
    public int getFlyToggleTimer() {
        return abilityResyncCountdown;
    }

    @Override
    public void setFlyToggleTimer(int value) {
        abilityResyncCountdown = value;
    }

    @Override
    public int getXpCooldown() {
        return experiencePickUpDelay;
    }

    @Override
    public void setXpCooldown(int value) {
        experiencePickUpDelay = value;
    }

    @Override
    public double getChasingX() {
        return capeX;
    }

    @Override
    public double getChasingY() {
        return capeY;
    }

    @Override
    public double getChasingZ() {
        return capeZ;
    }

    @Override
    public void setChasingX(double value) {
        capeX = value;
    }

    @Override
    public void setChasingY(double value) {
        capeY = value;
    }

    @Override
    public void setChasingZ(double value) {
        capeZ = value;
    }

    @Override
    public double getPrevChasingX() {
        return prevCapeX;
    }

    @Override
    public double getPrevChasingY() {
        return prevCapeY;
    }

    @Override
    public double getPrevChasingZ() {
        return prevCapeZ;
    }

    @Override
    public void setPrevChasingX(double value) {
        prevCapeX = value;
    }

    @Override
    public void setPrevChasingY(double value) {
        prevCapeY = value;
    }

    @Override
    public void setPrevChasingZ(double value) {
        prevCapeZ = value;
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
        return totalExperience;
    }

    @Override
    public void setTotalExperience(int value) {
        totalExperience = value;
    }

    @Override
    public float getExperienceProgress() {
        return experienceProgress;
    }

    @Override
    public void setExperienceProgress(float value) {
        experienceProgress = value;
    }

    @Override
    public int getEnchantmentTableSeed() {
        return enchantmentTableSeed;
    }

    @Override
    public void setEnchantmentTableSeed(int value) {
        enchantmentTableSeed = value;
    }

    @Override
    public float getSpeedInAir() {
        return airStrafingSpeed;
    }

    @Override
    public void setSpeedInAir(float value) {
        airStrafingSpeed = value;
    }

    @Override
    public int getLastXPSound() {
        return lastPlayedLevelUpSoundTime;
    }

    @Override
    public void setLastXPSound(int value) {
        lastPlayedLevelUpSoundTime = value;
    }

    @Override
    public boolean hasReducedDebug() {
        return hasReducedDebugInfo();
    }

    @Override
    public void setReducedDebug(boolean value) {
        setReducedDebugInfo(value);
    }
}
