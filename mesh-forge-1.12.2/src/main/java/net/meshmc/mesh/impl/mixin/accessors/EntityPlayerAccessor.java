package net.meshmc.mesh.impl.mixin.accessors;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(EntityPlayer.class)
public interface EntityPlayerAccessor {
    @Accessor("flyToggleTimer")
    int getFlyToggleTimer();

    @Accessor("flyToggleTimer")
    void setFlyToggleTimer(int value);

    @Accessor("sleepTimer")
    int getSleepTimer();

    @Accessor("sleepTimer")
    void setSleepTimer(int value);

    @Accessor("xpSeed")
    int getXPSeed();

    @Accessor("xpSeed")
    void setXPSeed(int value);

    @Accessor("speedInAir")
    float getSpeedInAir();

    @Accessor("speedInAir")
    void setSpeedInAir(float value);

    @Accessor("lastXPSound")
    int getLastXPSound();

    @Accessor("lastXPSound")
    void setLastXPSound(int value);

    @Accessor("gameProfile")
    void setGameProfile(GameProfile gameProfile);

    @Invoker("updateCape")
    void updateCape();

    @Invoker("updateSize")
    void updateSize();

    @Invoker("addMountedMovementStat")
    void addMountedMovementStat(double x, double y, double z);
}
