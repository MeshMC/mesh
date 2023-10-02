package net.meshmc.mesh.impl.mixin.accessors.entity;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PlayerEntity.class)
public interface EntityPlayerAccessor {
    @Accessor("abilityResyncCountdown")
    int getFlyToggleTimer();

    @Accessor("abilityResyncCountdown")
    void setFlyToggleTimer(int value);

    @Accessor("sleepTimer")
    void setSleepTimer(int value);

    @Accessor("enchantmentTableSeed")
    void setEnchantmentTableSeed(int value);

    @Accessor("lastPlayedLevelUpSoundTime")
    int getLastXPSound();

    @Accessor("lastPlayedLevelUpSoundTime")
    void setLastXPSound(int value);

    @Accessor("gameProfile")
    void setGameProfile(GameProfile gameProfile);

    @Invoker("updateCapeAngles")
    void updateCapeAngles();

    @Invoker("updatePose")
    void updatePose();

    @Invoker("closeHandledScreen")
    void closeHandledScreen();

    @Invoker("increaseRidingMotionStats")
    void increaseRidingMotionStats(double x, double y, double z);

    @Invoker("getOffGroundSpeed")
    float getOffGroundSpeed();
}
