package net.meshmc.mesh.impl.mixin.accessors;

import net.meshmc.mesh.impl.util.duck.EntityPlayerAccessor;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EntityPlayer.class)
public class MixinEntityPlayer implements EntityPlayerAccessor {
    @Shadow protected int flyToggleTimer;
    @Shadow private int sleepTimer;
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
    public int getSleepTimer() {
        return sleepTimer;
    }

    @Override
    public void setSleepTimer(int value) {
        sleepTimer = value;
    }

    @Override
    public int getXPSeed() {
        return xpSeed;
    }

    @Override
    public void setXPSeed(int value) {
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
}
