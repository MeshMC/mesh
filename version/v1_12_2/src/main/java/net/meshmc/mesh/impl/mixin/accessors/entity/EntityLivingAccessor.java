package net.meshmc.mesh.impl.mixin.accessors.entity;

import net.meshmc.mesh.api.block.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(EntityLivingBase.class)
public interface EntityLivingAccessor {
    @Accessor("ticksSinceLastSwing")
    int getTicksSinceLastSwing();

    @Accessor("ticksSinceLastSwing")
    void setTicksSinceLastSwing(int value);

    @Accessor("attackingPlayer")
    EntityPlayer getAttackingPlayer();

    @Accessor("attackingPlayer")
    void setAttackingPlayer(EntityPlayer value);

    @Accessor("recentlyHit")
    int getRecentlyHit();

    @Accessor("recentlyHit")
    void setRecentlyHit(int value);

    @Accessor("dead")
    boolean isTrulyDead();

    @Accessor("dead")
    void setTrulyDead(boolean value);

    @Accessor("idleTime")
    int getIdleTime();

    @Accessor("idleTime")
    void setIdleTime(int value);

    @Accessor("prevOnGroundSpeedFactor")
    float getPrevOnGroundSpeedFactor();

    @Accessor("prevOnGroundSpeedFactor")
    void setPrevOnGroundSpeedFactor(float value);

    @Accessor("onGroundSpeedFactor")
    float getOnGroundSpeedFactor();

    @Accessor("onGroundSpeedFactor")
    void setOnGroundSpeedFactor(float value);

    @Accessor("movedDistance")
    float getMovedDistance();

    @Accessor("movedDistance")
    void setMovedDistance(float value);

    @Accessor("prevMovedDistance")
    float getPrevMovedDistance();

    @Accessor("prevMovedDistance")
    void setPrevMovedDistance(float value);

    @Accessor("unused180")
    float getUnused180();

    @Accessor("unused180")
    void setUnused180(float value);

    @Accessor("scoreValue")
    int getScoreValue();

    @Accessor("scoreValue")
    void setScoreValue(int value);

    @Accessor("lastDamage")
    float getLastDamage();

    @Accessor("lastDamage")
    void setLastDamage(float value);

    @Accessor("isJumping")
    boolean isJumping();

    @Accessor("isJumping")
    void setJumping(boolean value);

    @Accessor("newPosRotationIncrements")
    int getNewPosRotationIncrements();

    @Accessor("newPosRotationIncrements")
    void setNewPosRotationIncrements(int value);

    @Accessor("interpTargetX")
    double getInterpTargetX();

    @Accessor("interpTargetX")
    void setInterpTargetX(double value);

    @Accessor("interpTargetY")
    double getInterpTargetY();

    @Accessor("interpTargetY")
    void setInterpTargetY(double value);

    @Accessor("interpTargetZ")
    double getInterpTargetZ();

    @Accessor("interpTargetZ")
    void setInterpTargetZ(double value);

    @Accessor("interpTargetYaw")
    double getInterpTargetYaw();

    @Accessor("interpTargetYaw")
    void setInterpTargetYaw(double value);

    @Accessor("interpTargetPitch")
    double getInterpTargetPitch();

    @Accessor("interpTargetPitch")
    void setInterpTargetPitch(double value);

    @Accessor("potionsNeedUpdate")
    boolean getPotionsNeedUpdate();

    @Accessor("potionsNeedUpdate")
    void setPotionsNeedUpdate(boolean value);

    @Accessor("revengeTarget")
    EntityLivingBase getRevengeTarget();

    @Accessor("revengeTarget")
    void setRevengeTarget(EntityLivingBase value);

    @Accessor("revengeTimer")
    int getRevengeTimer();

    @Accessor("revengeTimer")
    void setRevengeTimer(int value);

    @Accessor("lastAttackedEntity")
    EntityLivingBase getLastAttackedEntity();

    @Accessor("lastAttackedEntity")
    void setLastAttackedEntity(EntityLivingBase value);

    @Accessor("lastAttackedEntityTime")
    int getLastAttackedEntityTime();

    @Accessor("lastAttackedEntityTime")
    void setLastAttackedEntityTime(int value);

    @Accessor("landMovementFactor")
    float getLandMovementFactor();

    @Accessor("landMovementFactor")
    void setLandMovementFactor(float value);

    @Accessor("jumpTicks")
    int getJumpTicks();

    @Accessor("jumpTicks")
    void setJumpTicks(int value);

    @Accessor("absorptionAmount")
    float getAbsorptionAmount();

    @Accessor("absorptionAmount")
    void setAbsorptionAmount(float value);

    @Accessor("activeItemStackUseCount")
    int getActiveItemStackUseCount();

    @Accessor("activeItemStackUseCount")
    void setActiveItemStackUseCount(int value);

    @Accessor("ticksElytraFlying")
    int getTicksElytraFlying();

    @Accessor("ticksElytraFlying")
    void setTicksElytraFlying(int value);

    @Accessor("lastDamageStamp")
    long getLastDamageStamp();

    @Accessor("lastDamageStamp")
    void setLastDamageStamp(long value);

    @Invoker("updateFallState")
    void updateFallState(double y, boolean onGround, IBlockState state, BlockPos blockPos);

    @Invoker("onDeathUpdate")
    void onDeathUpdate();

    @Invoker("canDropLoot")
    boolean canDropLoot();

    @Invoker("decreaseAirSupply")
    int decreaseAirSupply(int air);

    @Invoker("getExperiencePoints")
    int getExperiencePoints(EntityPlayer player);

    @Invoker("isPlayer")
    boolean isPlayer();

    @Invoker("updatePotionEffects")
    void updatePotionEffects();

    @Invoker("updatePotionMetadata")
    void updatePotionMetadata();

    @Invoker("blockUsingShield")
    void blockUsingShield(EntityLivingBase entityLivingBase);

    @Invoker("getArmSwingAnimationEnd")
    int getArmSwingAnimationEnd();

    @Invoker("getSoundVolume")
    float getSoundVolume();

    @Invoker("updateArmSwingProgress")
    void updateArmSwingProgress();

    @Invoker("getSoundPitch")
    float getSoundPitch();

    @Invoker("isMovementBlocked")
    boolean isMovementBlocked();

    @Invoker("jump")
    void jump();

    @Invoker("updateElytra")
    void updateElytra();

    @Invoker("updateEntityActionState")
    void updateEntityActionState();

    @Invoker("collideWithNearbyEntities")
    void collideWithNearbyEntities();

    @Invoker("collideWithEntity")
    void collideWithEntity(Entity entity);

    @Invoker("getJumpUpwardsMotion")
    float getJumpUpwardsMotion();

    @Invoker("onLivingUpdate")
    void onLivingUpdate();

    @Invoker("updateDistance")
    float updateDistance(float body, float head);

    @Invoker("markPotionsDirty")
    void markPotionsDirty();

    @Invoker("updateActiveHand")
    void updateActiveHand();

    @Invoker("onItemUseFinish")
    void onItemUseFinish();
}
