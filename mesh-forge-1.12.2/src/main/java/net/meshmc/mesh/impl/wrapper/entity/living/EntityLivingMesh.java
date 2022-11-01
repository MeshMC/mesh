package net.meshmc.mesh.impl.wrapper.entity.living;

import net.meshmc.mesh.api.block.BlockState;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.entity.living.EntityLiving;
import net.meshmc.mesh.api.entity.living.player.EntityPlayer;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.impl.mixin.accessors.entity.EntityLivingAccessor;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.Mappings;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.impl.wrapper.block.BlockStateMesh;
import net.meshmc.mesh.impl.wrapper.entity.EntityMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.player.EntityPlayerMesh;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.entity.EntityLivingBase;

import java.util.Random;

public class EntityLivingMesh<T extends EntityLivingBase> extends EntityMesh<T> implements EntityLiving {
    public EntityLivingMesh(T value) {
        super(value);
    }

    @Override
    public boolean isHandSwinging() {
        return getMeshValue().isSwingInProgress;
    }

    @Override
    public void setHandSwinging(boolean value) {
        getMeshValue().isSwingInProgress = value;
    }

    @Override
    public Hand getSwingingHand() {
        return MeshEnum.hand(getMeshValue().swingingHand);
    }

    @Override
    public void setSwingingHand(Hand hand) {
        getMeshValue().swingingHand = MCEnum.hand(hand);
    }

    @Override
    public int getSwingTicks() {
        return getMeshValue().swingProgressInt;
    }

    @Override
    public void setSwingTicks(int value) {
        getMeshValue().swingProgressInt = value;
    }

    @Override
    public int getArrowHitTimer() {
        return getMeshValue().arrowHitTimer;
    }

    @Override
    public void setArrowHitTimer(int value) {
        getMeshValue().arrowHitTimer = value;
    }

    @Override
    public int getHurtTime() {
        return getMeshValue().hurtTime;
    }

    @Override
    public void setHurtTime(int value) {
        getMeshValue().hurtTime = value;
    }

    @Override
    public int getMaxHurtTime() {
        return getMeshValue().maxHurtTime;
    }

    @Override
    public void setMaxHurtTime(int value) {
        getMeshValue().maxHurtTime = value;
    }

    @Override
    public float getAttackedAtYaw() {
        return getMeshValue().attackedAtYaw;
    }

    @Override
    public void setAttackedAtYaw(float value) {
        getMeshValue().attackedAtYaw = value;
    }

    @Override
    public int getDeathTime() {
        return getMeshValue().deathTime;
    }

    @Override
    public void setDeathTime(int value) {
        getMeshValue().deathTime = value;
    }

    @Override
    public float getPrevSwingProgress() {
        return getMeshValue().prevSwingProgress;
    }

    @Override
    public void setPrevSwingProgress(float value) {
        getMeshValue().prevSwingProgress = value;
    }

    @Override
    public float getSwingProgress() {
        return getMeshValue().swingProgress;
    }

    @Override
    public void setSwingProgress(float value) {
        getMeshValue().swingProgress = value;
    }

    @Override
    public int getLastAttackedTicks() {
        return ((EntityLivingAccessor) getMeshValue()).getTicksSinceLastSwing();
    }

    @Override
    public void setLastAttackedTicks(int value) {
        ((EntityLivingAccessor) getMeshValue()).setTicksSinceLastSwing(value);
    }

    @Override
    public float getPrevSwingDistance() {
        return getMeshValue().prevLimbSwingAmount;
    }

    @Override
    public void setPrevSwingDistance(float value) {
        getMeshValue().prevLimbSwingAmount = value;
    }

    @Override
    public float getSwingDistance() {
        return getMeshValue().limbSwingAmount;
    }

    @Override
    public void setSwingDistance(float value) {
        getMeshValue().limbSwingAmount = value;
    }

    @Override
    public float getLimbAngle() {
        return getMeshValue().limbSwing;
    }

    @Override
    public void setLimbAngle(float value) {
        getMeshValue().limbSwing = value;
    }

    @Override
    public float getRandomLargeSeed() {
        return getMeshValue().randomUnused2;
    }

    @Override
    public void setRandomLargeSeed(float value) {
        getMeshValue().randomUnused2 = value;
    }

    @Override
    public float getRandomSmallSeed() {
        return getMeshValue().randomUnused1;
    }

    @Override
    public void setRandomSmallSeed(float value) {
        getMeshValue().randomUnused1 = value;
    }

    @Override
    public float getBodyYaw() {
        return getMeshValue().renderYawOffset;
    }

    @Override
    public void setBodyYaw(float value) {
        getMeshValue().renderYawOffset = value;
    }

    @Override
    public float getPrevBodyYaw() {
        return getMeshValue().prevRenderYawOffset;
    }

    @Override
    public void setPrevBodyYaw(float value) {
        getMeshValue().prevRenderYawOffset = value;
    }

    @Override
    public float getHeadYaw() {
        return getMeshValue().rotationYawHead;
    }

    @Override
    public void setHeadYaw(float value) {
        getMeshValue().rotationYawHead = value;
    }

    @Override
    public float getPrevHeadYaw() {
        return getMeshValue().prevRotationYawHead;
    }

    @Override
    public void setPrevHeadYaw(float value) {
        getMeshValue().prevRotationYawHead = value;
    }

    @Override
    public float getAirStrafingSpeed() {
        return getMeshValue().jumpMovementFactor;
    }

    @Override
    public void setAirStrafingSpeed(float value) {
        getMeshValue().jumpMovementFactor = value;
    }

    @Override
    public EntityPlayer getAttackingPlayer() {
        return (EntityPlayer) Mappings.entity(((EntityLivingAccessor) getMeshValue()).getAttackingPlayer());
    }

    @Override
    public void setAttackingPlayer(EntityPlayer value) {
        ((EntityLivingAccessor) getMeshValue()).setAttackingPlayer(((EntityPlayerMesh<?>) value).getMeshValue());
        setRecentlyHit(getAge()); // 1.18 does this on set
    }

    @Override
    public int getRecentlyHit() {
        return ((EntityLivingAccessor) getMeshValue()).getRecentlyHit();
    }

    @Override
    public void setRecentlyHit(int value) {
        ((EntityLivingAccessor) getMeshValue()).setRecentlyHit(value);
    }

    @Override
    public boolean isTrulyDead() {
        return ((EntityLivingAccessor) getMeshValue()).isTrulyDead();
    }

    @Override
    public void setTrulyDead(boolean value) {
        ((EntityLivingAccessor) getMeshValue()).setTrulyDead(value);
    }

    @Override
    public int getIdleTime() {
        return ((EntityLivingAccessor) getMeshValue()).getIdleTime();
    }

    @Override
    public void setIdleTime(int value) {
        ((EntityLivingAccessor) getMeshValue()).setIdleTime(value);
    }

    @Override
    public float getPrevOnGroundSpeedFactor() {
        return ((EntityLivingAccessor) getMeshValue()).getPrevOnGroundSpeedFactor();
    }

    @Override
    public void setPrevOnGroundSpeedFactor(float value) {
        ((EntityLivingAccessor) getMeshValue()).setPrevOnGroundSpeedFactor(value);
    }

    @Override
    public float getOnGroundSpeedFactor() {
        return ((EntityLivingAccessor) getMeshValue()).getOnGroundSpeedFactor();
    }

    @Override
    public void setOnGroundSpeedFactor(float value) {
        ((EntityLivingAccessor) getMeshValue()).setOnGroundSpeedFactor(value);
    }

    @Override
    public float getMovedDistance() {
        return ((EntityLivingAccessor) getMeshValue()).getMovedDistance();
    }

    @Override
    public void setMovedDistance(float value) {
        ((EntityLivingAccessor) getMeshValue()).setMovedDistance(value);
    }

    @Override
    public float getPrevMovedDistance() {
        return ((EntityLivingAccessor) getMeshValue()).getPrevMovedDistance();
    }

    @Override
    public void setPrevMovedDistance(float value) {
        ((EntityLivingAccessor) getMeshValue()).setPrevMovedDistance(value);
    }

    @Override
    public float getUnused180() {
        return ((EntityLivingAccessor) getMeshValue()).getUnused180();
    }

    @Override
    public void setUnused180(float value) {
        ((EntityLivingAccessor) getMeshValue()).setUnused180(value);
    }

    @Override
    public int getScoreValue() {
        return ((EntityLivingAccessor) getMeshValue()).getScoreValue();
    }

    @Override
    public void setScoreValue(int value) {
        ((EntityLivingAccessor) getMeshValue()).setScoreValue(value);
    }

    @Override
    public float getLastDamage() {
        return ((EntityLivingAccessor) getMeshValue()).getLastDamage();
    }

    @Override
    public void setLastDamage(float value) {
        ((EntityLivingAccessor) getMeshValue()).setLastDamage(value);
    }

    @Override
    public boolean isJumping() {
        return ((EntityLivingAccessor) getMeshValue()).isJumping();
    }

    @Override
    public void setJumping(boolean value) {
        ((EntityLivingAccessor) getMeshValue()).setJumping(value);
    }

    @Override
    public float getMoveStrafing() {
        return getMeshValue().moveStrafing;
    }

    @Override
    public void setMoveStrafing(float value) {
        getMeshValue().moveStrafing = value;
    }

    @Override
    public float getMoveVertical() {
        return getMeshValue().moveVertical;
    }

    @Override
    public void setMoveVertical(float value) {
        getMeshValue().moveVertical = value;
    }

    @Override
    public float getMoveForward() {
        return getMeshValue().moveForward;
    }

    @Override
    public void setMoveForward(float value) {
        getMeshValue().moveForward = value;
    }

    @Override
    public double getServerX() {
        return ((EntityLivingAccessor) getMeshValue()).getInterpTargetX();
    }

    @Override
    public void setServerX(double value) {
        ((EntityLivingAccessor) getMeshValue()).setInterpTargetX(value);
    }

    @Override
    public double getServerY() {
        return ((EntityLivingAccessor) getMeshValue()).getInterpTargetY();
    }

    @Override
    public void setServerY(double value) {
        ((EntityLivingAccessor) getMeshValue()).setInterpTargetY(value);
    }

    @Override
    public double getServerZ() {
        return ((EntityLivingAccessor) getMeshValue()).getInterpTargetZ();
    }

    @Override
    public void setServerZ(double value) {
        ((EntityLivingAccessor) getMeshValue()).setInterpTargetZ(value);
    }

    @Override
    public double getServerYaw() {
        return ((EntityLivingAccessor) getMeshValue()).getInterpTargetYaw();
    }

    @Override
    public void setServerYaw(double value) {
        ((EntityLivingAccessor) getMeshValue()).setInterpTargetYaw(value);
    }

    @Override
    public double getServerPitch() {
        return ((EntityLivingAccessor) getMeshValue()).getInterpTargetPitch();
    }

    @Override
    public void setServerPitch(double value) {
        ((EntityLivingAccessor) getMeshValue()).setInterpTargetPitch(value);
    }

    @Override
    public int getHeadTrackingIncrements() {
        return ((EntityLivingAccessor) getMeshValue()).getNewPosRotationIncrements();
    }

    @Override
    public void setHeadTrackingIncrements(int value) {
        ((EntityLivingAccessor) getMeshValue()).setNewPosRotationIncrements(value);
    }

    @Override
    public boolean areEffectsChanged() {
        return ((EntityLivingAccessor) getMeshValue()).getPotionsNeedUpdate();
    }

    @Override
    public void setEffectsChanged(boolean value) {
        ((EntityLivingAccessor) getMeshValue()).setPotionsNeedUpdate(value);
    }

    @Override
    public EntityLiving getAttacker() {
        return (EntityLiving) Mappings.entity(((EntityLivingAccessor) getMeshValue()).getRevengeTarget());
    }

    @Override
    public void setAttacker(EntityLiving value) {
        ((EntityLivingAccessor) getMeshValue()).setRevengeTarget(((EntityLivingMesh<?>) value).getMeshValue());
        setLastAttackedTime(getAge());
    }

    @Override
    public int getLastAttackedTime() {
        return ((EntityLivingAccessor) getMeshValue()).getRevengeTimer();
    }

    @Override
    public void setLastAttackedTime(int value) {
        ((EntityLivingAccessor) getMeshValue()).setRevengeTimer(value);
    }

    @Override
    public EntityLiving getAttacking() {
        return (EntityLiving) Mappings.entity(((EntityLivingAccessor) getMeshValue()).getLastAttackedEntity());
    }

    @Override
    public void setAttacking(EntityLiving value) {
        ((EntityLivingAccessor) getMeshValue()).setLastAttackedEntity(((EntityLivingMesh<?>) value).getMeshValue());
        setLastAttackTime(getAge());
    }

    @Override
    public int getLastAttackTime() {
        return ((EntityLivingAccessor) getMeshValue()).getLastAttackedEntityTime();
    }

    @Override
    public void setLastAttackTime(int value) {
        ((EntityLivingAccessor) getMeshValue()).setLastAttackedEntityTime(value);
    }

    @Override
    public float getMovementSpeed() {
        return ((EntityLivingAccessor) getMeshValue()).getLandMovementFactor();
    }

    @Override
    public void setMovementSpeed(float value) {
        ((EntityLivingAccessor) getMeshValue()).setLandMovementFactor(value);
    }

    @Override
    public int getJumpTicks() {
        return ((EntityLivingAccessor) getMeshValue()).getJumpTicks();
    }

    @Override
    public void setJumpTicks(int value) {
        ((EntityLivingAccessor) getMeshValue()).setJumpTicks(value);
    }

    @Override
    public float getAbsorptionAmount() {
        return ((EntityLivingAccessor) getMeshValue()).getAbsorptionAmount();
    }

    @Override
    public void setAbsorptionAmount(float value) {
        ((EntityLivingAccessor) getMeshValue()).setAbsorptionAmount(value);
    }

    @Override
    public int getItemUseTimeLeft() {
        return ((EntityLivingAccessor) getMeshValue()).getActiveItemStackUseCount();
    }

    @Override
    public void setItemUseTimeLeft(int value) {
        ((EntityLivingAccessor) getMeshValue()).setActiveItemStackUseCount(value);
    }

    @Override
    public int getTicksElytraFlying() {
        return ((EntityLivingAccessor) getMeshValue()).getTicksElytraFlying();
    }

    @Override
    public void setTicksElytraFlying(int value) {
        ((EntityLivingAccessor) getMeshValue()).setTicksElytraFlying(value);
    }

    @Override
    public long getLastDamageTime() {
        return ((EntityLivingAccessor) getMeshValue()).getLastDamageStamp();
    }

    @Override
    public void setLastDamageTime(long value) {
        ((EntityLivingAccessor) getMeshValue()).setLastDamageStamp(value);
    }

    @Override
    public void tickFall(double heightDifference, boolean onGround, BlockState<?> landedState, BlockPos landedPosition) {
        ((EntityLivingAccessor) getMeshValue()).updateFallState(heightDifference, onGround, ((BlockStateMesh) landedState).getMeshValue(), (net.minecraft.util.math.BlockPos) landedPosition);
    }

    @Override
    public boolean canBreatheUnderwater() {
        return getMeshValue().canBreatheUnderwater();
    }

    @Override
    public boolean isChild() {
        return getMeshValue().isChild();
    }

    @Override
    public void tickDeath() {
        ((EntityLivingAccessor) getMeshValue()).onDeathUpdate();
    }

    @Override
    public boolean shouldDropLoot() {
        return ((EntityLivingAccessor) getMeshValue()).canDropLoot();
    }

    @Override
    public int nextAirSupplyUnderwater(int air) {
        return ((EntityLivingAccessor) getMeshValue()).decreaseAirSupply(air);
    }

    @Override
    public int getXpToDrop(EntityPlayer player) {
        return ((EntityLivingAccessor) getMeshValue()).getExperiencePoints(((EntityPlayerMesh<?>) player).getMeshValue());
    }

    @Override
    public boolean isPlayer() {
        return ((EntityLivingAccessor) getMeshValue()).isPlayer();
    }

    @Override
    public Random getRNG() {
        return getMeshValue().getRNG();
    }

    @Override
    public void tickStatusEffects() {
        ((EntityLivingAccessor) getMeshValue()).updatePotionEffects();
    }

    @Override
    public void tickPotionVisibility() {
        ((EntityLivingAccessor) getMeshValue()).updatePotionMetadata();
    }

    @Override
    public void heal(float amount) {
        getMeshValue().heal(amount);
    }

    @Override
    public float getHealth() {
        return getMeshValue().getHealth();
    }

    @Override
    public void setHealth(float value) {
        getMeshValue().setHealth(value);
    }

    @Override
    public boolean isDead() {
        return getHealth() <= 0.0F;
    }

    @Override
    public void blockUsingShield(EntityLiving entityLiving) {
        ((EntityLivingAccessor) getMeshValue()).blockUsingShield(((EntityLivingMesh<?>) entityLiving).getMeshValue());
    }

    @Override
    public void knockBack(float strength, double xRatio, double zRatio) {
        // WHY FORGE???, why u adding params to mc methods
        getMeshValue().knockBack(null, strength, xRatio, zRatio);
    }

    @Override
    public void fallDamage(float fallDistance, float damageMultiplier) {
        getMeshValue().fall(fallDistance, damageMultiplier);
    }

    @Override
    public void hurtAnimation() {
        getMeshValue().performHurtAnimation();
    }

    @Override
    public int getArmorValue() {
        return getMeshValue().getTotalArmorValue();
    }

    @Override
    public EntityLiving getPrimeAttacking() {
        return (EntityLiving) Mappings.entity(getMeshValue().getAttackingEntity());
    }

    @Override
    public float getMaxHealth() {
        return getMeshValue().getMaxHealth();
    }

    @Override
    public int getStuckArrowCount() {
        return getMeshValue().getArrowCountInEntity();
    }

    @Override
    public void setStuckArrowCount(int value) {
        getMeshValue().setArrowCountInEntity(value);
    }

    @Override
    public int getHandSwingDuration() {
        return ((EntityLivingAccessor) getMeshValue()).getArmSwingAnimationEnd();
    }

    @Override
    public void swingHand(Hand hand) {
        getMeshValue().swingArm(MCEnum.hand(hand));
    }

    @Override
    public void tickHandSwing() {
        ((EntityLivingAccessor) getMeshValue()).updateArmSwingProgress();
    }

    @Override
    public float getSoundVolume() {
        return ((EntityLivingAccessor) getMeshValue()).getSoundVolume();
    }

    @Override
    public float getSoundPitch() {
        return ((EntityLivingAccessor) getMeshValue()).getSoundPitch();
    }

    @Override
    public boolean isImmobile() {
        return ((EntityLivingAccessor) getMeshValue()).isMovementBlocked();
    }

    @Override
    public float getJumpVelocity() {
        return ((EntityLivingAccessor) getMeshValue()).getJumpUpwardsMotion();
    }

    @Override
    public void jump() {
        ((EntityLivingAccessor) getMeshValue()).jump();
    }

    @Override
    public void travel(Vec3d input) {
        getMeshValue().travel((float) input.getX(), (float) input.getY(), (float) input.getZ());
    }

    @Override
    public void travel(float strafe, float vertical, float forward) {
        getMeshValue().travel(strafe, vertical, forward);
    }

    @Override
    public boolean tryAttack(Entity entity) {
        return getMeshValue().attackEntityAsMob(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public float turnHead(float bodyRotation, float headRotation) {
        return ((EntityLivingAccessor) getMeshValue()).updateDistance(bodyRotation, headRotation);
    }

    @Override
    public void tickMovement() {
        ((EntityLivingAccessor) getMeshValue()).onLivingUpdate();
    }

    @Override
    public void tickFallFlying() {
        ((EntityLivingAccessor) getMeshValue()).updateElytra();
    }

    @Override
    public void tickAi() {
        ((EntityLivingAccessor) getMeshValue()).updateEntityActionState();
    }

    @Override
    public void tickCramming() {
        ((EntityLivingAccessor) getMeshValue()).collideWithNearbyEntities();
    }

    @Override
    public void collide(Entity entity) {
        ((EntityLivingAccessor) getMeshValue()).collideWithEntity(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public void setTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean teleport) {
        getMeshValue().setPositionAndRotationDirect(x, y, z, yaw, pitch, interpolationSteps, teleport);
    }

    @Override
    public void onItemPickup(Entity entity, int count) {
        getMeshValue().onItemPickup(((EntityMesh<?>) entity).getMeshValue(), count);
    }

    @Override
    public boolean canSee(Entity entity) {
        return getMeshValue().canEntityBeSeen(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public float getHandSwingProgress(float tickDelta) {
        return getMeshValue().getSwingProgress(tickDelta);
    }

    @Override
    public void sendEnterCombat() {
        getMeshValue().sendEnterCombat();
    }

    @Override
    public void sendEndCombat() {
        getMeshValue().sendEndCombat();
    }

    @Override
    public void markEffectsDirty() {
        ((EntityLivingAccessor) getMeshValue()).markPotionsDirty();
    }

    @Override
    public boolean isUsingItem() {
        return getMeshValue().isHandActive();
    }

    @Override
    public Hand getActiveHand() {
        return MeshEnum.hand(getMeshValue().getActiveHand());
    }

    @Override
    public void tickActiveHand() {
        ((EntityLivingAccessor) getMeshValue()).updateActiveHand();
    }

    @Override
    public void setActiveHand(Hand hand) {
        getMeshValue().setActiveHand(MCEnum.hand(hand));
    }

    @Override
    public void onItemUseFinish() {
        ((EntityLivingAccessor) getMeshValue()).onItemUseFinish();
    }

    @Override
    public int getItemUseTime() {
        return getMeshValue().getItemInUseMaxCount();
    }

    @Override
    public void stopUsingItem() {
        getMeshValue().stopActiveHand();
    }

    @Override
    public void clearActiveItem() {
        getMeshValue().resetActiveHand();
    }

    @Override
    public boolean isActiveItemBlocking() {
        return getMeshValue().isActiveItemStackBlocking();
    }

    @Override
    public boolean isElytraFlying() {
        return getMeshValue().isElytraFlying();
    }

    @Override
    public void attemptTeleport(double x, double y, double z) {
        getMeshValue().attemptTeleport(x, y, z);
    }

    @Override
    public boolean canBeHitWithPotion() {
        return getMeshValue().canBeHitWithPotion();
    }

    @Override
    public boolean isSleeping() {
        return getMeshValue().isPlayerSleeping();
    }
}
