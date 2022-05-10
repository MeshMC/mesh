package net.meshmc.mesh.impl.mixin.accessors.entity;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PlayerEntity.class)
public interface PlayerEntityAccessor {
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
}
