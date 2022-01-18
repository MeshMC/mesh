package dev.tigr.mesh.impl.mixin.accessors.entity;

import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(EntityPlayer.class)
public interface EntityPlayerAccessor {
    @Accessor("flyToggleTimer")
    int getFlyToggleTimer();

    @Accessor("flyToggleTimer")
    void setFlyToggleTimer(int value);

    @Accessor("sleepTimer")
    void setSleepTimer(int value);

    @Accessor("xpSeed")
    void setXpSeed(int value);

    @Accessor("speedInAir")
    float getSpeedInAir();

    @Accessor("speedInAir")
    void setSpeedInAir(float value);

    @Accessor("lastXPSound")
    int getLastXPSound();

    @Accessor("lastXPSound")
    void setLastXPSound(int value);
}
