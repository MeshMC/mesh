package net.meshmc.mesh.impl.mixin.accessors.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LivingEntity.class)
public interface EntityLivingAccessor {
    @Accessor("lastAttackedTicks")
    int getLastAttackedTicks();

    @Accessor("lastAttackedTicks")
    void setLastAttackedTicks(int value);

    @Accessor("randomLargeSeed")
    void setRandomLargeSeed(float value);

    @Accessor("randomSmallSeed")
    void setRandomSmallSeed(float value);

    @Accessor("attackingPlayer")
    PlayerEntity getAttackingPlayer();

    @Accessor("attackingPlayer")
    void setAttackingPlayer(PlayerEntity value);

    @Accessor("playerHitTimer")
    int getPlayerHitTimer();

    @Accessor("playerHitTimer")
    void setPlayerHitTimer(int value);

    @Accessor("dead")
    boolean isTrulyDead();

    @Accessor("dead")
    void setTrulyDead(boolean value);

    @Accessor("despawnCounter")
    int getDespawnCounter();

    @Accessor("despawnCounter")
    void setDespawnCounter(int value);

    @Accessor("prevStepBobbingAmount")
    float getPrevStepBobbingAmount();

    @Accessor("prevStepBobbingAmount")
    void setPrevStepBobbingAmount(float value);

    @Accessor("stepBobbingAmount")
    float getStepBobbingAmount();

    @Accessor("stepBobbingAmount")
    void setStepBobbingAmount(float value);

    @Accessor("lookDirection")
    float getLookDirection();

    @Accessor("lookDirection")
    void setLookDirection(float value);

    @Accessor("prevLookDirection")
    float getPrevLookDirection();

    @Accessor("prevLookDirection")
    void setPrevLookDirection(float value);

    @Accessor("field_6215")
    float getField_6215();

    @Accessor("field_6215")
    void setField_6215(float value);

    @Accessor("scoreAmount")
    int getScoreAmount();

    @Accessor("scoreAmount")
    void setScoreAmount(int value);

    @Accessor("lastDamageTaken")
    float getLastDamageTaken();

    @Accessor("lastDamageTaken")
    void setLastDamageTaken(float value);

    @Accessor("jumping")
    boolean isJumping();

    @Accessor("jumping")
    void setJumping(boolean value);

    @Accessor("bodyTrackingIncrements")
    int getBodyTrackingIncrements();

    @Accessor("bodyTrackingIncrements")
    void setBodyTrackingIncrements(int value);

    @Accessor("serverX")
    double getServerX();

    @Accessor("serverX")
    void setServerX(double value);

    @Accessor("serverY")
    double getServerY();

    @Accessor("serverY")
    void setServerY(double value);

    @Accessor("serverZ")
    double getServerZ();

    @Accessor("serverZ")
    void setServerZ(double value);

    @Accessor("serverYaw")
    double getServerYaw();

    @Accessor("serverYaw")
    void setServerYaw(double value);

    @Accessor("serverPitch")
    double getServerPitch();

    @Accessor("serverPitch")
    void setServerPitch(double value);

    @Accessor("serverHeadYaw")
    double getServerHeadYaw();

    @Accessor("serverHeadYaw")
    void setServerHeadYaw(double value);

    @Accessor("headTrackingIncrements")
    int getHeadTrackingIncrements();

    @Accessor("headTrackingIncrements")
    void setHeadTrackingIncrements(int value);

    @Accessor("effectsChanged")
    boolean isEffectsChanged();

    @Accessor("effectsChanged")
    void setEffectsChanged(boolean value);

    @Accessor("attacker")
    LivingEntity getAttacker();

    @Accessor("attacker")
    void setAttacker(LivingEntity value);

    @Accessor("lastAttackedTime")
    int getLastAttackedTime();

    @Accessor("lastAttackedTime")
    void setLastAttackedTime(int value);

    @Accessor("attacking")
    LivingEntity getAttacking();

    @Accessor("attacking")
    void setAttacking(LivingEntity value);

    @Accessor("lastAttackTime")
    int getLastAttackTime();

    @Accessor("lastAttackTime")
    void setLastAttackTime(int value);

    @Accessor("movementSpeed")
    float getMovementSpeed();

    @Accessor("movementSpeed")
    void setMovementSpeed(float value);

    @Accessor("jumpingCooldown")
    int getJumpingCooldown();

    @Accessor("jumpingCooldown")
    void setJumpingCooldown(int value);

    @Accessor("absorptionAmount")
    float getAbsorptionAmount();

    @Accessor("absorptionAmount")
    void setAbsorptionAmount(float value);

    @Accessor("itemUseTimeLeft")
    int getItemUseTimeLeft();

    @Accessor("itemUseTimeLeft")
    void setItemUseTimeLeft(int value);

    @Accessor("roll")
    int getRoll();

    @Accessor("roll")
    void setRoll(int value);

    @Accessor("lastDamageTime")
    long getLastDamageTime();

    @Accessor("lastDamageTime")
    void setLastDamageTime(long value);

    @Invoker("fall")
    void fall(double y, boolean onGround, BlockState blockState, BlockPos blockPos);

    @Invoker("updatePostDeath")
    void updatePostDeath();

    @Invoker("shouldDropLoot")
    boolean shouldDropLoot();

    @Invoker("getNextAirUnderwater")
    int getNextAirUnderwater(int air);

    @Invoker("getXpToDrop")
    int getXpToDrop();

    @Invoker("shouldAlwaysDropXp")
    boolean isPlayer();

    @Invoker("tickStatusEffects")
    void tickStatusEffects();

    @Invoker("updatePotionVisibility")
    void updatePotionVisibility();

    @Invoker("takeShieldHit")
    void takeShieldHit(LivingEntity livingEntity);

    @Invoker("getHandSwingDuration")
    int getHandSwingDuration();

    @Invoker("tickHandSwing")
    void tickHandSwing();

    @Invoker("getSoundVolume")
    float getSoundVolume();

    @Invoker("isImmobile")
    boolean isImmobile();

    @Invoker("getJumpVelocity")
    float getJumpVelocity();

    @Invoker("jump")
    void jump();

    @Invoker("turnHead")
    float turnHead(float body, float head);

    @Invoker("tickFallFlying")
    void tickFallFlying();

    @Invoker("tickNewAi")
    void tickNewAi();

    @Invoker("tickCramming")
    void tickCramming();

    @Invoker("pushAway")
    void pushAway(Entity entity);

    @Invoker("markEffectsDirty")
    void markEffectsDirty();

    @Invoker("tickActiveItemStack")
    void tickActiveItemStack();

    @Invoker("consumeItem")
    void consumeItem();


}
