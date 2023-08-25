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
import net.minecraft.entity.LivingEntity;

import java.util.Random;

public class EntityLivingMesh<T extends LivingEntity> extends EntityMesh<T> implements EntityLiving {
    public EntityLivingMesh(T value) {
        super(value);
    }

    @Override
    public boolean isHandSwinging() {
        return getMeshValue().handSwinging;
    }

    @Override
    public void setHandSwinging(boolean value) {
        getMeshValue().handSwinging = value;
    }

    @Override
    public Hand getSwingingHand() {
        return MeshEnum.hand(getMeshValue().preferredHand);
    }

    @Override
    public void setSwingingHand(Hand hand) {
        getMeshValue().preferredHand = MCEnum.hand(hand);
    }

    @Override
    public int getSwingTicks() {
        return getMeshValue().handSwingTicks;
    }

    @Override
    public void setSwingTicks(int value) {
        getMeshValue().handSwingTicks = value;
    }

    @Override
    public int getArrowHitTimer() {
        return getMeshValue().stuckArrowTimer;
    }

    @Override
    public void setArrowHitTimer(int value) {
        getMeshValue().stuckArrowTimer = value;
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
    public Float getAttackedAtYaw() {
        return null;
//        return getMeshValue().knockbackVelocity;
    }

    @Override
    public void setAttackedAtYaw(float value) {
//        getMeshValue().knockbackVelocity = value;
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
        return getMeshValue().lastHandSwingProgress;
    }

    @Override
    public void setPrevSwingProgress(float value) {
        getMeshValue().lastHandSwingProgress = value;
    }

    @Override
    public float getSwingProgress() {
        return getMeshValue().handSwingProgress;
    }

    @Override
    public void setSwingProgress(float value) {
        getMeshValue().handSwingProgress = value;
    }

    @Override
    public int getLastAttackedTicks() {
        return ((EntityLivingAccessor) getMeshValue()).getLastAttackedTicks();
    }

    @Override
    public void setLastAttackedTicks(int value) {
        ((EntityLivingAccessor) getMeshValue()).setLastAttackedTicks(value);
    }

    @Override
    public Float getPrevSwingDistance() {
        return null;
//        return getMeshValue().lastLimbDistance;
    }

    @Override
    public void setPrevSwingDistance(float value) {
//        getMeshValue().lastLimbDistance = value;
    }

    @Override
    public Float getSwingDistance() {
        return null;
//        return getMeshValue().limbDistance;
    }

    @Override
    public void setSwingDistance(float value) {
//        getMeshValue().limbDistance = value;
    }

    @Override
    public Float getLimbAngle() {
        return null;
//        return getMeshValue().limbAngle;
    }

    @Override
    public void setLimbAngle(float value) {
//        getMeshValue().limbAngle = value;
    }

    @Override
    public float getRandomLargeSeed() {
        return getMeshValue().randomLargeSeed;
    }

    @Override
    public void setRandomLargeSeed(float value) {
        ((EntityLivingAccessor) getMeshValue()).setRandomLargeSeed(value);
    }

    @Override
    public float getRandomSmallSeed() {
        return getMeshValue().randomSmallSeed;
    }

    @Override
    public void setRandomSmallSeed(float value) {
        ((EntityLivingAccessor) getMeshValue()).setRandomSmallSeed(value);
    }

    @Override
    public float getBodyYaw() {
        return getMeshValue().bodyYaw;
    }

    @Override
    public void setBodyYaw(float value) {
        getMeshValue().bodyYaw = value;
    }

    @Override
    public float getPrevBodyYaw() {
        return getMeshValue().prevBodyYaw;
    }

    @Override
    public void setPrevBodyYaw(float value) {
        getMeshValue().prevBodyYaw = value;
    }

    @Override
    public float getHeadYaw() {
        return getMeshValue().headYaw;
    }

    @Override
    public void setHeadYaw(float value) {
        getMeshValue().headYaw = value;
    }

    @Override
    public float getPrevHeadYaw() {
        return getMeshValue().prevHeadYaw;
    }

    @Override
    public void setPrevHeadYaw(float value) {
        getMeshValue().prevHeadYaw = value;
    }

    @Override
    public Float getAirStrafingSpeed() {
        return null;
//        return getMeshValue().airStrafingSpeed;
    }

    @Override
    public void setAirStrafingSpeed(float value) {
//        getMeshValue().airStrafingSpeed = value;
    }

    @Override
    public EntityPlayer getAttackingPlayer() {
        return (EntityPlayer) Mappings.entity(((EntityLivingAccessor) getMeshValue()).getAttackingPlayer());
    }

    @Override
    public void setAttackingPlayer(EntityPlayer value) {
        getMeshValue().setAttacking(((EntityPlayerMesh<?>) value).getMeshValue());
    }

    @Override
    public int getRecentlyHit() {
        return ((EntityLivingAccessor) getMeshValue()).getPlayerHitTimer();
    }

    @Override
    public void setRecentlyHit(int value) {
        ((EntityLivingAccessor) getMeshValue()).setPlayerHitTimer(value);
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
        return ((EntityLivingAccessor) getMeshValue()).getDespawnCounter();
    }

    @Override
    public void setIdleTime(int value) {
        ((EntityLivingAccessor) getMeshValue()).setDespawnCounter(value);
    }

    @Override
    public float getPrevOnGroundSpeedFactor() {
        return ((EntityLivingAccessor) getMeshValue()).getPrevStepBobbingAmount();
    }

    @Override
    public void setPrevOnGroundSpeedFactor(float value) {
        ((EntityLivingAccessor) getMeshValue()).setPrevStepBobbingAmount(value);
    }

    @Override
    public float getOnGroundSpeedFactor() {
        return ((EntityLivingAccessor) getMeshValue()).getStepBobbingAmount();
    }

    @Override
    public void setOnGroundSpeedFactor(float value) {
        ((EntityLivingAccessor) getMeshValue()).setStepBobbingAmount(value);
    }

    @Override
    public float getMovedDistance() {
        return ((EntityLivingAccessor) getMeshValue()).getLookDirection();
    }

    @Override
    public void setMovedDistance(float value) {
        ((EntityLivingAccessor) getMeshValue()).setLookDirection(value);
    }

    @Override
    public float getPrevMovedDistance() {
        return ((EntityLivingAccessor) getMeshValue()).getPrevLookDirection();
    }

    @Override
    public void setPrevMovedDistance(float value) {
        ((EntityLivingAccessor) getMeshValue()).setPrevLookDirection(value);
    }

    @Override
    public float getUnused180() {
        return ((EntityLivingAccessor) getMeshValue()).getField_6215();
    }

    @Override
    public void setUnused180(float value) {
        ((EntityLivingAccessor) getMeshValue()).setField_6215(value);
    }

    @Override
    public int getScoreValue() {
        return ((EntityLivingAccessor) getMeshValue()).getScoreAmount();
    }

    @Override
    public void setScoreValue(int value) {
        ((EntityLivingAccessor) getMeshValue()).setScoreAmount(value);
    }

    @Override
    public float getLastDamage() {
        return ((EntityLivingAccessor) getMeshValue()).getLastDamageTaken();
    }

    @Override
    public void setLastDamage(float value) {
        ((EntityLivingAccessor) getMeshValue()).setLastDamageTaken(value);
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
        return getMeshValue().sidewaysSpeed;
    }

    @Override
    public void setMoveStrafing(float value) {
        getMeshValue().sidewaysSpeed = value;
    }

    @Override
    public float getMoveVertical() {
        return getMeshValue().upwardSpeed;
    }

    @Override
    public void setMoveVertical(float value) {
        getMeshValue().upwardSpeed = value;
    }

    @Override
    public float getMoveForward() {
        return getMeshValue().forwardSpeed;
    }

    @Override
    public void setMoveForward(float value) {
        getMeshValue().forwardSpeed = value;
    }

    @Override
    public double getServerX() {
        return ((EntityLivingAccessor) getMeshValue()).getServerX();
    }

    @Override
    public void setServerX(double value) {
        ((EntityLivingAccessor) getMeshValue()).setServerX(value);
    }

    @Override
    public double getServerY() {
        return ((EntityLivingAccessor) getMeshValue()).getServerY();
    }

    @Override
    public void setServerY(double value) {
        ((EntityLivingAccessor) getMeshValue()).setServerY(value);
    }

    @Override
    public double getServerZ() {
        return ((EntityLivingAccessor) getMeshValue()).getServerZ();
    }

    @Override
    public void setServerZ(double value) {
        ((EntityLivingAccessor) getMeshValue()).setServerZ(value);
    }

    @Override
    public double getServerYaw() {
        return ((EntityLivingAccessor) getMeshValue()).getServerYaw();
    }

    @Override
    public void setServerYaw(double value) {
        ((EntityLivingAccessor) getMeshValue()).setServerYaw(value);
    }

    @Override
    public double getServerPitch() {
        return ((EntityLivingAccessor) getMeshValue()).getServerPitch();
    }

    @Override
    public void setServerPitch(double value) {
        ((EntityLivingAccessor) getMeshValue()).setServerPitch(value);
    }

    @Override
    public int getHeadTrackingIncrements() {
        return ((EntityLivingAccessor) getMeshValue()).getHeadTrackingIncrements();
    }

    @Override
    public void setHeadTrackingIncrements(int value) {
        ((EntityLivingAccessor) getMeshValue()).setHeadTrackingIncrements(value);
    }

    @Override
    public boolean areEffectsChanged() {
        return ((EntityLivingAccessor) getMeshValue()).isEffectsChanged();
    }

    @Override
    public void setEffectsChanged(boolean value) {
        ((EntityLivingAccessor) getMeshValue()).setEffectsChanged(value);
    }

    @Override
    public EntityLiving getAttacker() {
        return (EntityLiving) Mappings.entity(((EntityLivingAccessor) getMeshValue()).getAttacker());
    }

    @Override
    public void setAttacker(EntityLiving value) {
        getMeshValue().setAttacker(((EntityLivingMesh<?>) value).getMeshValue());
    }

    @Override
    public int getLastAttackedTime() {
        return ((EntityLivingAccessor) getMeshValue()).getLastAttackedTime();
    }

    @Override
    public void setLastAttackedTime(int value) {
        ((EntityLivingAccessor) getMeshValue()).setLastAttackedTime(value);
    }

    @Override
    public EntityLiving getAttacking() {
        return (EntityLiving) Mappings.entity(((EntityLivingAccessor) getMeshValue()).getAttacking());
    }

    @Override
    public void setAttacking(EntityLiving value) {
        getMeshValue().onAttacking(((EntityLivingMesh<?>) value).getMeshValue());
    }

    @Override
    public int getLastAttackTime() {
        return ((EntityLivingAccessor) getMeshValue()).getLastAttackTime();
    }

    @Override
    public void setLastAttackTime(int value) {
        ((EntityLivingAccessor) getMeshValue()).setLastAttackTime(value);
    }

    @Override
    public float getMovementSpeed() {
        return ((EntityLivingAccessor) getMeshValue()).getMovementSpeed();
    }

    @Override
    public void setMovementSpeed(float value) {
        ((EntityLivingAccessor) getMeshValue()).setMovementSpeed(value);
    }

    @Override
    public int getJumpTicks() {
        return ((EntityLivingAccessor) getMeshValue()).getJumpingCooldown();
    }

    @Override
    public void setJumpTicks(int value) {
        ((EntityLivingAccessor) getMeshValue()).setJumpingCooldown(value);
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
        return ((EntityLivingAccessor) getMeshValue()).getItemUseTimeLeft();
    }

    @Override
    public void setItemUseTimeLeft(int value) {
        ((EntityLivingAccessor) getMeshValue()).setItemUseTimeLeft(value);
    }

    @Override
    public int getTicksElytraFlying() {
        return ((EntityLivingAccessor) getMeshValue()).getRoll();
    }

    @Override
    public void setTicksElytraFlying(int value) {
        ((EntityLivingAccessor) getMeshValue()).setRoll(value);
    }

    @Override
    public long getLastDamageTime() {
        return ((EntityLivingAccessor) getMeshValue()).getLastDamageTime();
    }

    @Override
    public void setLastDamageTime(long value) {
        ((EntityLivingAccessor) getMeshValue()).setLastDamageTime(value);
    }

    // TODO: INVALID BLOCKSTATE CAST??
    @Override
    public void tickFall(double heightDifference, boolean onGround, BlockState<?> landedState, BlockPos landedPosition) {
        ((EntityLivingAccessor) getMeshValue()).fall(heightDifference, onGround, (net.minecraft.block.BlockState) ((BlockStateMesh) landedState).getMeshValue(), (net.minecraft.util.math.BlockPos) landedPosition);
    }

    @Override
    public boolean canBreatheUnderwater() {
        return getMeshValue().canBreatheInWater();
    }

    @Override
    public boolean isChild() {
        return getMeshValue().isBaby();
    }

    @Override
    public void tickDeath() {
        ((EntityLivingAccessor) getMeshValue()).updatePostDeath();
    }

    @Override
    public boolean shouldDropLoot() {
        return ((EntityLivingAccessor) getMeshValue()).shouldDropLoot();
    }

    @Override
    public int nextAirSupplyUnderwater(int air) {
        return ((EntityLivingAccessor) getMeshValue()).getNextAirUnderwater(air);
    }

    @Override
    public int getXpToDrop(EntityPlayer player) {
        return ((EntityLivingAccessor) getMeshValue()).getXpToDrop();
    }

    @Override
    public boolean isPlayer() {
        return ((EntityLivingAccessor) getMeshValue()).isPlayer();
    }

    @Override
    public Random getRNG() {
        // TODO: FIX
        return null;
//        return getMeshValue().getRandom();
    }

    @Override
    public void tickStatusEffects() {
        ((EntityLivingAccessor) getMeshValue()).tickStatusEffects();
    }

    @Override
    public void tickPotionVisibility() {
        ((EntityLivingAccessor) getMeshValue()).updatePotionVisibility();
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
        return getMeshValue().isDead();
    }

    @Override
    public void blockUsingShield(EntityLiving entityLiving) {
        ((EntityLivingAccessor) getMeshValue()).takeShieldHit(((EntityLivingMesh<?>) entityLiving).getMeshValue());
    }

    @Override
    public void knockBack(float strength, double xRatio, double zRatio) {
        getMeshValue().takeKnockback(strength, xRatio, zRatio);
    }

    @Override
    public void fallDamage(float fallDistance, float damageMultiplier) {
        // TODO: DamageSource???
//        getMeshValue().handleFallDamage(fallDistance, damageMultiplier, DamageSource.FALL);
    }

    @Override
    public void hurtAnimation(float hurtTiltYaw) {
        getMeshValue().animateDamage(hurtTiltYaw);
    }

    @Override
    public int getArmorValue() {
        return getMeshValue().getArmor();
    }

    @Override
    public EntityLiving getPrimeAttacking() {
        return (EntityLiving) Mappings.entity(getMeshValue().getPrimeAdversary());
    }

    @Override
    public float getMaxHealth() {
        return getMeshValue().getMaxHealth();
    }

    @Override
    public int getStuckArrowCount() {
        return getMeshValue().getStuckArrowCount();
    }

    @Override
    public void setStuckArrowCount(int value) {
        getMeshValue().setStuckArrowCount(value);
    }

    @Override
    public int getHandSwingDuration() {
        return ((EntityLivingAccessor) getMeshValue()).getHandSwingDuration();
    }

    @Override
    public void swingHand(Hand hand) {
        getMeshValue().swingHand(MCEnum.hand(hand));
    }

    @Override
    public void tickHandSwing() {
        ((EntityLivingAccessor) getMeshValue()).tickHandSwing();
    }

    @Override
    public float getSoundVolume() {
        return ((EntityLivingAccessor) getMeshValue()).getSoundVolume();
    }

    @Override
    public float getSoundPitch() {
        return getMeshValue().getSoundPitch();
    }

    @Override
    public boolean isImmobile() {
        return ((EntityLivingAccessor) getMeshValue()).isImmobile();
    }

    @Override
    public float getJumpVelocity() {
        return ((EntityLivingAccessor) getMeshValue()).getJumpVelocity();
    }

    @Override
    public void jump() {
        ((EntityLivingAccessor) getMeshValue()).jump();
    }

    @Override
    public void travel(Vec3d input) {
        getMeshValue().travel((net.minecraft.util.math.Vec3d) input);
    }

    @Override
    public void travel(float strafe, float vertical, float forward) {
        getMeshValue().travel(new net.minecraft.util.math.Vec3d(strafe, vertical, forward));
    }

    @Override
    public boolean tryAttack(Entity entity) {
        return getMeshValue().tryAttack(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public float turnHead(float bodyRotation, float headRotation) {
        return ((EntityLivingAccessor) getMeshValue()).turnHead(bodyRotation, headRotation);
    }

    @Override
    public void tickMovement() {
        getMeshValue().tickMovement();
    }

    @Override
    public void tickFallFlying() {
        ((EntityLivingAccessor) getMeshValue()).tickFallFlying();
    }

    @Override
    public void tickAi() {
        ((EntityLivingAccessor) getMeshValue()).tickNewAi();
    }

    @Override
    public void tickCramming() {
        ((EntityLivingAccessor) getMeshValue()).tickCramming();
    }

    @Override
    public void collide(Entity entity) {
        ((EntityLivingAccessor) getMeshValue()).pushAway(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public void setTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean teleport) {
        getMeshValue().updateTrackedPositionAndAngles(x, y, z, yaw, pitch, interpolationSteps, teleport);
    }

    @Override
    public void onItemPickup(Entity entity, int count) {
        getMeshValue().sendPickup(((EntityMesh<?>) entity).getMeshValue(), count);
    }

    @Override
    public boolean canSee(Entity entity) {
        return getMeshValue().canSee(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public float getHandSwingProgress(float tickDelta) {
        return getMeshValue().getHandSwingProgress(tickDelta);
    }

    @Override
    public void sendEnterCombat() {
        getMeshValue().enterCombat();
    }

    @Override
    public void sendEndCombat() {
        getMeshValue().endCombat();
    }

    @Override
    public void markEffectsDirty() {
        ((EntityLivingAccessor) getMeshValue()).markEffectsDirty();
    }

    @Override
    public boolean isUsingItem() {
        return getMeshValue().isUsingItem();
    }

    @Override
    public Hand getActiveHand() {
        return MeshEnum.hand(getMeshValue().getActiveHand());
    }

    @Override
    public void tickActiveHand() {
        ((EntityLivingAccessor) getMeshValue()).tickActiveItemStack();
    }

    public void setActiveHand(Hand hand) {
        getMeshValue().setCurrentHand(MCEnum.hand(hand));
    }

    @Override
    public void onItemUseFinish() {
        ((EntityLivingAccessor) getMeshValue()).consumeItem();
    }

    @Override
    public int getItemUseTime() {
        return getMeshValue().getItemUseTime();
    }

    @Override
    public void stopUsingItem() {
        getMeshValue().stopUsingItem();
    }

    @Override
    public void clearActiveItem() {
        getMeshValue().clearActiveItem();
    }

    @Override
    public boolean isActiveItemBlocking() {
        return getMeshValue().isBlocking();
    }

    @Override
    public boolean isElytraFlying() {
        return getMeshValue().isFallFlying();
    }

    @Override
    public void attemptTeleport(double x, double y, double z) {
        getMeshValue().teleport(x, y, z);
    }

    @Override
    public boolean canBeHitWithPotion() {
        return getMeshValue().isAffectedBySplashPotions();
    }

    @Override
    public boolean isSleeping() {
        return getMeshValue().isSleeping();
    }
}
