package dev.tigr.mesh.impl.mixin.accessors.entity;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PlayerEntity.class)
public interface PlayerEntityAccessor {
    @Accessor("abilityResyncCountdown")
    int getAbilityResyncCountdown();

    @Accessor("abilityResyncCountdown")
    void setAbilityResyncCountdown(int value);

    @Accessor("sleepTimer")
    void setSleepTimer(int value);

    @Accessor("enchantmentTableSeed")
    void setEnchantmentTableSeed(int value);

    @Accessor("lastPlayedLevelUpSoundTime")
    int getLastPlayedLevelUpSoundTime();

    @Accessor("lastPlayedLevelUpSoundTime")
    void setLastPlayedLevelUpSoundTime(int value);
}
