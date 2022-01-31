package dev.tigr.mesh.impl.mixininterface.entity;

import dev.tigr.mesh.api.entity.EntityType;
import dev.tigr.mesh.api.entity.MoverType;
import dev.tigr.mesh.impl.mixininterface.entity.living.player.EntityPlayer;
import dev.tigr.mesh.impl.mixininterface.math.BlockPos;
import dev.tigr.mesh.impl.mixininterface.math.Box;
import dev.tigr.mesh.impl.mixininterface.math.Vec3d;
import dev.tigr.mesh.impl.mixininterface.world.World;
import dev.tigr.mesh.util.math.Facing;

import java.util.List;

/**
 * Provides a mesh interface for controlling a minecraft entity
 * @author Tigermouthbear 1/16/22
 * @author Makrennel    - moved from wrapper to mixin+interface 2022/01/30
 */
public interface Entity {
    EntityType getEntityType();

    // TODO: canRiderInteract?

    int getId();
    void setId(int value);

    List<Entity> getRiders();

    int getRidingCooldown();
    void setRidingCooldown(int value);

    Entity getVehicle();
    void setVehicle(Entity entity);

    World getWorld();
    void setWorld(World world);

    Vec3d getPrevPosition();
    void setPrevPosition(Vec3d position);

    double getPrevX();
    double getPrevY();
    double getPrevZ();
    void setPrevX(double value);
    void setPrevY(double value);
    void setPrevZ(double value);

    Vec3d getPos();
    void setPosition(double x, double y, double z);
    void setPosition(Vec3d position);

    double getX();
    double getY();
    double getZ();
    void setX(double value);
    void setY(double value);
    void setZ(double value);

    double getLastRenderX();
    double getLastRenderY();
    double getLastRenderZ();
    void setLastRenderX(double value);
    void setLastRenderY(double value);
    void setLastRenderZ(double value);

    // TODO: chunkpos and serverpos

    Vec3d getVelocity();
    void setVelocity(double x, double y, double z);
    void setVelocity(Vec3d velocity);

    double getXVelocity();
    double getYVelocity();
    double getZVelocity();
    void setXVelocity(double value);
    void setYVelocity(double value);
    void setZVelocity(double value);

    float getYaw();
    float getPitch();
    void setYaw(float value);
    void setPitch(float value);

    float getPrevYaw();
    float getPrevPitch();
    void setPrevYaw(float value);
    void setPrevPitch(float value);

    Box getBounds();
    void setBounds(Box box);

    boolean isOnGround();
    void setOnGround(boolean value);

    boolean isCollidedHorizontally();
    void setCollidedHorizontally(boolean value);

    boolean isCollidedVertically();
    void setCollidedVertically(boolean value);

    boolean isCollided();
    void setCollided(boolean value);

    boolean isVelocityChanged();
    void setVelocityChanged(boolean value);

    // TODO: movementMultiplier

    // distanceWalkedModified
    float getHorizontalSpeed();
    void setHorizontalSpeed(float value);

    // prevDistanceWalkedModified
    float getPrevHorizontalSpeed();
    void setPrevHorizontalSpeed(float value);

    // distanceWalkedOnStepModified
    float getDistanceTraveled();
    void setDistanceTraveled(float value);

    float getFallDistance();
    void setFallDistance(float value);

    // TODO: speed

    // nextFlap?
    float getNextStepSoundDistance();
    void setNextStepSoundDistance(float value);

    float getStepHeight();
    void setStepHeight(float value);

    boolean isNoClip();
    void setNoClip(boolean value);

    // age
    int getTicksExisted();
    void setTicksExisted(int value);

    int getFireTicks();
    void setFireTicks(int value);

    boolean isInWater();
    void setInWater(boolean value);

    // TODO: submergedInWater and fluidHeight (maybe)

    // TODO: timeUntilRegen

    boolean isFirstUpdate();
    void setFirstUpdate(boolean value);

    boolean isIgnoringCameraFrustum();
    void setIgnoreCameraFrustum(boolean value);

    boolean isInPortal();
    void setInPortal(boolean value);

    int getPortalCooldown();
    void setPortalCooldown(int value);

    int getPortalTime();
    void setPortalTime(int value);

    BlockPos getLastPortalPosition();
    void setLastPortalPosition(BlockPos pos);

    boolean isInvulnerable();
    void setInvulnerable(boolean value);

    // TODO: UUID

    boolean isGlowing();
    void setGlowing(boolean value);

    double[] getPistonMovementDelta();
    void setPistonMovementDelta(double[] value);

    long getPistonDelta();
    void setPistonDelta(long value);

    // TODO: DIMENSIONS

    // TODO: OTHER STANDING POSITION EYE HEIGHTS
    float getEyeHeight();

    // TODO:
    /*public boolean inPowderSnow;
    public boolean wasInPowderSnow;
    public boolean wasOnFire;
    private float lastChimeIntensity;
    private int lastChimeAge;
    private boolean hasVisualFire;*/

    boolean isSpectator();

    // TODO: SCOREBOARD

    // setDead
    void kill();
    void discard();

    // TODO: REMOVAL AND POSE

    default void setRotation(float yaw, float pitch) {
        setYaw(yaw % 360.0F);
        setPitch(pitch % 360.0F);
    }

    default void moveTo(double x, double y, double z) {
        setPosition(x, y, z);
        setBounds(calculateBoundingBox());
    }

    default void moveTo(Vec3d vec3d) {
        moveTo(vec3d.getX(), vec3d.getY(), vec3d.getZ());
    }

    Box calculateBoundingBox();

    void tick();

    void baseTick();

    // TODO: SET ON FIRE

    int getMaxInPortalTime();

    void setOnFireFromLava();

    void setOnFireFor(int value);

    default void extinguish() {
        setFireTicks(0);
    }

    // outOfWorld
    void tickInVoid();

    // TODO: COLLIDE and adjustMovementForCollisions

    void move(MoverType moverType, Vec3d movement);

    // doBlockCollisions
    void checkBlockCollision();

    // TODO: getLandingPos and velocity multiplier

    // TODO: onBlockCollision (BlockState)

    boolean isSilent();
    void setSilent(boolean value);

    boolean hasNoGravity();
    void setNoGravity(boolean value);

    // TODO: fall and handleFallDamage (BlockState)

    boolean isImmuneToFire();
    // setter maybe?

    boolean isBeingRainedOn();

    boolean isInsideWaterOrBubbleColumn();

    void updateSwimming();

    // TODO: SWIMMING/WATER STATE

    void spawnSprintingParticles();

    boolean isInLava();

    // updateVelocity
    void moveRelative(float speed, Vec3d vec3d);

    // getBrightnessForRender
    float getBrightnessAtEyes();

    void updatePositionAndAngles(double x, double y, double z, float yaw, float pitch);

    default double distanceTo(Entity entity) {
        return getPos().distanceTo(entity.getPos());
    }

    default double distanceTo(Vec3d pos) {
        return getPos().distanceTo(pos);
    }

    default double distanceTo(double x, double y, double z) {
        return getPos().distanceTo(x, y, z);
    }

    default double squaredDistanceTo(Entity entity) {
        return getPos().squareDistanceTo(entity.getPos());
    }

    default double squaredDistanceTo(Vec3d vector) {
        return getPos().squareDistanceTo(vector);
    }

    default double squaredDistanceTo(double x, double y, double z) {
        return getPos().squareDistanceTo(x, y, z);
    }

    void onPlayerCollision(EntityPlayer entityPlayer);

    void pushAwayFrom(Entity entity);

    default void addVelocity(double x, double y, double z) {
        setVelocity(getVelocity().add(x, y, z));
    }

    default void addVelocity(Vec3d vec3d) {
        setVelocity(getVelocity().add(vec3d));
    }

    // TODO: DAMAGE (DamageSource)

    // getLook
    Vec3d getRotationVec();
    Vec3d getOppositeRotationVec();

    float getPitch(float delta);
    float getYaw(float delta);

    // getPositionEyes
    Vec3d getCameraPosVec(float delta);

    // TODO: RAYCAST (HitResult)

    boolean canBeCollidedWith();
    boolean canBePushed();

    // TODO: awardKillScore / updateKilledAdvancementCriterion (DamageSource)

    boolean shouldRender(double cameraX, double cameraY, double cameraZ);
    boolean shouldRender(double distance);

    // TODO: NBT SHIT :(

    boolean shouldSetPositionOnLoad();

    // getSavedEntityId
    String getEntityString();

    // TODO: MORE NBT SHIT HERE :(

    // TODO: DROP ITEM (ItemEntity)

    boolean isAlive();

    // isEntityInsideOpaqueBlock
    boolean isInsideWall();

    // TODO: interact / processInteract (ActionResult)

    // TODO: collidesWith / collides

    void tickRiding();

    // updatePassenger
    void updateRiderPosition(Entity entity);

    // applyOrientationToEntity
    void onRiderLookAround(Entity entity);

    // getHeightOffset
    double getYOffset();

    double getMountedYOffset();

    boolean startRidingEntity(Entity entity, boolean force);
    default boolean startRidingEntity(Entity entity) {
        return startRidingEntity(entity, false);
    }

    // canBeRidden
    boolean canStartRiding(Entity entity);

    // TODO: wouldPoseNotCollide

    void removeRiders();

    // TODO: stopRiding vs dismountVehicle?
    void dismountVehicle();

    void addRider(Entity entity);

    void removeRider(Entity entity);

    boolean canAddRider(Entity entity);

    // setPositionAndRotationDirect
    void updateTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate);

    // getCollisionBorderSize
    float getTargetingMargin();

    // setPortal
    void setInNetherPortal(BlockPos blockPos);

    // getPortalCooldown
    int getDefaultNetherPortalCooldown();

    void handleStatus(byte status);

    // animateDamage
    void performHurtAnimation();

    // TODO: HELD ITEMS AND ARMOR (ItemStack)

    // isBurning
    boolean isOnFire();

    // isRiding
    boolean hasVehicle();

    // isBeingRidden
    boolean hasRiders();

    boolean isSneaking();
    void setSneaking(boolean value);

    // isSneaking for 1.12.2 and lower
    boolean isInSneakingPose();

    // TODO: bypassesSteppingEffects, isDescending

    boolean isSprinting();
    void setSprinting(boolean value);

    // TODO: SWIMMING

    boolean isInvisible();

    boolean isInvisibleTo(EntityPlayer player);

    void setInvisible(boolean value);

    // TODO: getScoreboardTeam

    boolean getFlag(int index);
    void setFlag(int index, boolean value);

    int getAir();
    void setAir(int air);

    // TODO: FROZENTICKS

    // TODO: onStruckByLightning

    // TODO: onBubbleColumnCollision

    // TODO: onKilledOtherEntity

    void pushOutOfSolidBlock(double x, double y, double z);

    // TODO: INWEB / SLOWMOVEMENT

    // TODO: getName (Text)

    float getHeadYaw();
    void setHeadYaw(float headYaw);

    // setRenderYawOffset?
    void setBodyYaw(float bodyYaw);

    boolean isAttackable();

    boolean handleAttack(Entity attacker);

    // TODO: invulnerableTo (DamageSource)

    void copyPositionAndRotation(Entity entity);

    // copyDataFromOld
    void copyFrom(Entity original);

    // TODO: moveToWorld, target teleport, dimension

    // TODO: getEffectiveExplosionResistance, canExplosionDestroyBlock

    // getMaxFallHeight
    int getSafeFallDistance();

    // doesEntityNotTriggerPressurePlate
    boolean canAvoidTraps();

    // canRenderOnFire
    boolean doesRenderOnFire();

    // TODO: get/set UUID

    boolean isPushedByFluids();

    // TODO: getRenderDistanceWeight (static)

    // TODO: getDisplayName (Text)

    boolean hasCustomNameTag();
    // TODO: Text getCustomNameTag();
    //TODO: void setCustomNameTag(Text name);
    boolean isCustomNameTagVisible();
    void setCustomNameTagVisible(boolean visible);

    // setPositionAndUpdate
    void teleport(double destX, double destY, double destZ);

    // TODO: requestTeleport

    // getAlwaysRenderNameTagForRender
    boolean shouldRenderName();

    Facing getHorizontalFacing_();

    // getAdjustedHorizontalFacing
    Facing getMovementDirection_();

    // TODO: canBeSpectated (ServerPlayerEntity)

    Box getRenderBoundingBox_();

    // TODO: getStackReference (StackReference)

    // TODO: sendSystemMessage (Text, UUID)

    // TODO: getServer (MinecraftServer)

    // TODO: interactAt (Hand)

    boolean isImmuneToExplosion();

    // TODO: isImmuneToExplosion (LivingEntity)

    // ignoreItemEntityData
    boolean entityDataRequiresOperator();

    Entity getControllingRider();

    boolean isRider(Entity entity);

    // getLowestRidingEntity / getRootVehicle
    Entity getLowestVehicle();

    // TODO: updatePassengerForDismount

    // getFireImmuneTicks
    int getBurningDuration();

    // TODO: permissionLevel

    // TODO: updateMovementInFluid

    // TODO: getSwimHeight

    float getWidth();
    float getHeight();
    // TODO: SET WIDTH / HEIGHT ? POSE PROBLEM

    // TODO: getDimensions

    BlockPos getBlockPos();
}
