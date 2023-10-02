package net.meshmc.mesh.api.entity.living;

import net.meshmc.mesh.api.block.BlockState;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.entity.living.player.EntityPlayer;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.util.math.Hand;

import java.util.Random;

public interface EntityLiving extends Entity {
    // TODO: ATTRIBUTES, COMBAT TRACKER, POTIONS, ARMOR
    boolean isHandSwinging();
    void setHandSwinging(boolean value);

    // TODO: 1.18.2 - noDrag field?

    Hand getSwingingHand();
    void setSwingingHand(Hand hand);

    int getSwingTicks(); // handSwingTicks, swingProgressInt
    void setSwingTicks(int value);

    int getArrowHitTimer(); // stuckArrowTimer
    void setArrowHitTimer(int value);

    // TODO: STUCK STINGER TIME, NOT IN 1.12.2

    int getHurtTime();
    void setHurtTime(int value);

    int getMaxHurtTime();
    void setMaxHurtTime(int value);

    Float getAttackedAtYaw(); // knockbackVelocity?
    void setAttackedAtYaw(float value);

    int getDeathTime();
    void setDeathTime(int value);

    float getPrevSwingProgress();
    void setPrevSwingProgress(float value);

    float getSwingProgress();
    void setSwingProgress(float value);

    int getLastAttackedTicks();
    void setLastAttackedTicks(int value);

    Float getPrevSwingDistance();
    void setPrevSwingDistance(float value);

    Float getSwingDistance();
    void setSwingDistance(float value);

    Float getLimbAngle();
    void setLimbAngle(float value);

    // TODO: maxHurtResistantTime? defaultMaxHealt?

    // TODO: (prev)cameraPitch

    float getRandomLargeSeed();
    void setRandomLargeSeed(float value);

    float getRandomSmallSeed();
    void setRandomSmallSeed(float value);

    float getBodyYaw();
    void setBodyYaw(float value);

    float getPrevBodyYaw();
    void setPrevBodyYaw(float value);

    float getHeadYaw();
    void setHeadYaw(float value);

    float getPrevHeadYaw();
    void setPrevHeadYaw(float value);

    Float getAirStrafingSpeed();
    void setAirStrafingSpeed(float value);

    EntityPlayer getAttackingPlayer();
    void setAttackingPlayer(EntityPlayer value);

    int getRecentlyHit();
    void setRecentlyHit(int value);

    boolean isTrulyDead();
    void setTrulyDead(boolean value);

    int getIdleTime();
    void setIdleTime(int value); // despawnCounter

    float getPrevOnGroundSpeedFactor();
    void setPrevOnGroundSpeedFactor(float value);

    float getOnGroundSpeedFactor(); // stepBobbingAmount
    void setOnGroundSpeedFactor(float value);

    float getMovedDistance(); // lookDirection
    void setMovedDistance(float value);

    float getPrevMovedDistance();
    void setPrevMovedDistance(float value);

    float getUnused180();
    void setUnused180(float value);

    int getScoreValue();
    void setScoreValue(int value);

    float getLastDamage();
    void setLastDamage(float value);

    boolean isJumping();
    void setJumping(boolean value);

    float getMoveStrafing();
    void setMoveStrafing(float value);

    float getMoveVertical();
    void setMoveVertical(float value);

    float getMoveForward();
    void setMoveForward(float value);

    // TODO: randomYawVelocity 1.12.2 only?

    double getServerX();
    void setServerX(double value);

    double getServerY();
    void setServerY(double value);

    double getServerZ();
    void setServerZ(double value);

    double getServerYaw();
    void setServerYaw(double value);

    double getServerPitch();
    void setServerPitch(double value);

    // TODO: serverHeadYaw 1.18 only?

    int getHeadTrackingIncrements(); // newPosRotationIncrements
    void setHeadTrackingIncrements(int value);

    boolean areEffectsChanged(); // potionsNeedUpdate
    void setEffectsChanged(boolean value);

    EntityLiving getAttacker(); // revengeTarget
    void setAttacker(EntityLiving value);

    int getLastAttackedTime(); // revengeTimer
    void setLastAttackedTime(int value);

    EntityLiving getAttacking();
    void setAttacking(EntityLiving value);

    int getLastAttackTime();
    void setLastAttackTime(int value);

    float getMovementSpeed(); // landMovementFactor
    void setMovementSpeed(float value);

    int getJumpTicks(); // jumpingCooldown
    void setJumpTicks(int value);

    float getAbsorptionAmount();
    void setAbsorptionAmount(float value);

    // TODO: activeItemStack

    int getItemUseTimeLeft();
    void setItemUseTimeLeft(int value);

    int getTicksElytraFlying();
    void setTicksElytraFlying(int value);

    // TODO: IDEK WHY MIXINS HATES THIS, maybe its just me \(*.*)/
    //BlockPos getLastBlockPos();
    //void setLastBlockPos(BlockPos value);

    long getLastDamageTime();
    void setLastDamageTime(long value);

    // TODO: lastDamageSource, climbingPos (1.18)
    // TODO: riptideTicks, leaningTicks, leaningPitch, brain?

    void tickFall(double heightDifference, boolean onGround, BlockState<?> landedState, BlockPos landedPosition);

    boolean canBreatheUnderwater();

    // TODO: soulSand and soulSpeed movement effects 1.18

    boolean isChild();

    // TODO: SWIMMING

    void tickDeath(); // updatePostDeath, onDeathUpdate

    boolean shouldDropLoot(); // canDropLoot TODO: shouldDropXp

    int nextAirSupplyUnderwater(int air); // decreaaseAirSupply, getNextAirUnderwater

    // nextAirOnLand?

    int getXpToDrop(EntityPlayer player);

    boolean isPlayer(); // shouldAlwaysDropXp

    Random getRNG();

    // TODO: equipStack and nbt

    void tickStatusEffects();

    void tickPotionVisibility();

    // TODO: potions

    // TODO: target?

    void heal(float amount);

    float getHealth();
    void setHealth(float value);

    boolean isDead();

    // TODO: attackEntityFrom (damage) DamageSource needed

    void blockUsingShield(EntityLiving entityLiving);

    // TODO: tryUseTotem, lastDamageSource, hurtSound, blockDamageSource, equipmentBreakEffects (renderBrokenItemStack)

    // TODO: onDeath, drop loot

    void knockBack(float strength, double xRatio, double zRatio);

    // hurtSound, deathSound

    void fallDamage(float fallDistance, float damageMultiplier);

    void hurtAnimation(float hurtTiltYaw);

    int getArmorValue();

    // TODO: DAMAGE ARMOR

    EntityLiving getPrimeAttacking();

    float getMaxHealth();

    int getStuckArrowCount();
    void setStuckArrowCount(int value);

    int getHandSwingDuration();

    void swingHand(Hand hand);

    void tickHandSwing(); // updateArmSwingProgress

    // TODO: EntityAttributes, items

    float getSoundVolume();

    float getSoundPitch();

    boolean isImmobile(); // isMovementBlocked

    boolean shouldRenderName();

    float getJumpVelocity();

    void jump();

    void travel(Vec3d input);
    void travel(float strafe, float vertical, float forward);

    // updateLimbs?

    boolean tryAttack(Entity entity);

    float turnHead(float bodyRotation, float headRotation); // updateDistance

    void tickMovement(); // onLivingUpdate

    void tickFallFlying(); // updateElytra

    void tickAi(); // updateEntityActionState

    void tickCramming(); // collideWithNearbyEntities

    // riptide

    void collide(Entity entity); // pushAway, collideWithEntity

    // setPositionAndRotationDirect
    void setTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean teleport);

    void onItemPickup(Entity entity, int count);

    boolean canSee(Entity entity);

    float getHandSwingProgress(float tickDelta);

    // collides?

    void sendEnterCombat();
    void sendEndCombat();

    void markEffectsDirty();

    // arm

    boolean isUsingItem();

    Hand getActiveHand();

    void tickActiveHand();

    void setActiveHand(Hand hand);

    // updateItemUse

    // getActiveItem TODO:

    void onItemUseFinish();

    int getItemUseTime();

    void stopUsingItem();

    void clearActiveItem();

    boolean isActiveItemBlocking(); // isBlocking

    boolean isElytraFlying();

    void attemptTeleport(double x, double y, double z);

    boolean canBeHitWithPotion();

    boolean isSleeping();

    // eat?
}
