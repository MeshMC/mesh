package net.meshmc.mesh.impl.wrapper.entity;

import net.meshmc.mesh.api.AbstractMesh;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.entity.EntityType;
import net.meshmc.mesh.api.entity.MoverType;
import net.meshmc.mesh.api.entity.living.player.EntityPlayer;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.math.Box;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.api.world.World;
import net.meshmc.mesh.impl.mixin.accessors.entity.EntityAccessor;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.Mappings;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.impl.wrapper.collections.EntityList;
import net.meshmc.mesh.impl.wrapper.entity.living.player.EntityPlayerMesh;
import net.meshmc.mesh.impl.wrapper.world.WorldMesh;
import net.meshmc.mesh.util.entity.Stance;
import net.meshmc.mesh.util.math.Facing;
import net.minecraft.client.MinecraftClient;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EntityMesh<T extends net.minecraft.entity.Entity> extends AbstractMesh<T> implements Entity {
    public EntityMesh(T value) {
        super(value);
    }

    @Override
    public EntityType getEntityType() {
        return Mappings.entityType(getMeshValue());
    }

    @Override
    public int getId() {
        return getMeshValue().getId();
    }

    @Override
    public void setId(int value) {
        getMeshValue().setId(value);
    }

    @Override
    public List<Entity> getRiders() {
        return new EntityList(getMeshValue().getPassengerList());
    }

    @Override
    public int getRidingCooldown() {
        return ((EntityAccessor) getMeshValue()).getRidingCooldown();
    }

    @Override
    public void setRidingCooldown(int value) {
        ((EntityAccessor) getMeshValue()).setRidingCooldown(value);
    }

    @Nullable
    @Override
    public Entity getVehicle() {
        return Mappings.entity(getMeshValue().getVehicle());
    }

    @Override
    public void setVehicle(Entity entity) {
        ((EntityAccessor) getMeshValue()).setVehicle(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public World getWorld() {
        return Mappings.world(getMeshValue().getWorld());
    }

    @Override
    public void setWorld(World world) {
        getMeshValue().world = ((WorldMesh<?>) world).getMeshValue();
    }

    @Override
    public double getPrevX() {
        return getMeshValue().prevX;
    }

    @Override
    public double getPrevY() {
        return getMeshValue().prevY;
    }

    @Override
    public double getPrevZ() {
        return getMeshValue().prevZ;
    }

    @Override
    public void setPrevX(double value) {
        getMeshValue().prevZ = value;
    }

    @Override
    public void setPrevY(double value) {
        getMeshValue().prevY = value;
    }

    @Override
    public void setPrevZ(double value) {
        getMeshValue().prevZ = value;
    }

    @Override
    public Vec3d getPos() {
        return (Vec3d) getMeshValue().getPos();
    }

    @Override
    public void setPosition(double x, double y, double z) {
        getMeshValue().setPosition(x, y, z);
    }

    @Override
    public double getX() {
        return getMeshValue().getX();
    }

    @Override
    public double getY() {
        return getMeshValue().getY();
    }

    @Override
    public double getZ() {
        return getMeshValue().getZ();
    }

    @Override
    public void setX(double value) {
        getPos().setX(value);
    }

    @Override
    public void setY(double value) {
        getPos().setY(value);
    }

    @Override
    public void setZ(double value) {
        getPos().setZ(value);
    }

    @Override
    public double getLastRenderX() {
        return getMeshValue().lastRenderX;
    }

    @Override
    public double getLastRenderY() {
        return getMeshValue().lastRenderY;
    }

    @Override
    public double getLastRenderZ() {
        return getMeshValue().lastRenderZ;
    }

    @Override
    public void setLastRenderX(double value) {
        getMeshValue().lastRenderX = value;
    }

    @Override
    public void setLastRenderY(double value) {
        getMeshValue().lastRenderY = value;
    }

    @Override
    public void setLastRenderZ(double value) {
        getMeshValue().lastRenderZ = value;
    }

    @Override
    public Vec3d getVelocity() {
        return (Vec3d) getMeshValue().getVelocity();
    }

    @Override
    public void setVelocity(double x, double y, double z) {
        getMeshValue().setVelocity(x, y, z);
    }

    @Override
    public void setVelocity(Vec3d velocity) {
        getMeshValue().setVelocity((net.minecraft.util.math.Vec3d) velocity);
    }

    @Override
    public double getVelocityX() {
        return getMeshValue().getVelocity().x;
    }

    @Override
    public double getVelocityY() {
        return getMeshValue().getVelocity().y;
    }

    @Override
    public double getVelocityZ() {
        return getMeshValue().getVelocity().z;
    }

    @Override
    public void setVelocityX(double value) {
        setVelocity(value, getVelocityY(), getVelocityZ());
    }

    @Override
    public void setVelocityY(double value) {
        setVelocity(getVelocityX(), value, getVelocityZ());
    }

    @Override
    public void setVelocityZ(double value) {
        setVelocity(getVelocityX(), getVelocityY(), value);
    }

    @Override
    public float getYaw() {
        return getMeshValue().getYaw();
    }

    @Override
    public float getPitch() {
        return getMeshValue().getPitch();
    }

    @Override
    public void setYaw(float value) {
        getMeshValue().setYaw(value);
    }

    @Override
    public void setPitch(float value) {
        getMeshValue().setPitch(value);
    }

    @Override
    public float getPrevYaw() {
        return getMeshValue().prevYaw;
    }

    @Override
    public float getPrevPitch() {
        return getMeshValue().prevPitch;
    }

    @Override
    public void setPrevYaw(float value) {
        getMeshValue().prevYaw = value;
    }

    @Override
    public void setPrevPitch(float value) {
        getMeshValue().prevPitch = value;
    }

    @Override
    public Box getBoundingBox() {
        return (Box) getMeshValue().getBoundingBox();
    }

    @Override
    public void setBoundingBox(Box box) {
        getMeshValue().setBoundingBox((net.minecraft.util.math.Box) box);
    }

    @Override
    public boolean isOnGround() {
        return getMeshValue().isOnGround();
    }

    @Override
    public void setOnGround(boolean value) {
        getMeshValue().setOnGround(value);
    }

    @Override
    public boolean isCollidedHorizontally() {
        return getMeshValue().horizontalCollision;
    }

    @Override
    public void setCollidedHorizontally(boolean value) {
        getMeshValue().horizontalCollision = value;
    }

    @Override
    public boolean isCollidedVertically() {
        return getMeshValue().verticalCollision;
    }

    @Override
    public void setCollidedVertically(boolean value) {
        getMeshValue().verticalCollision = value;
    }

    @Override
    public boolean isCollided() {
        return getMeshValue().collidedSoftly;
    }

    @Override
    public void setCollided(boolean value) {
        getMeshValue().collidedSoftly = value;
    }

    @Override
    public boolean isVelocityChanged() {
        return getMeshValue().velocityModified;
    }

    @Override
    public void setVelocityChanged(boolean value) {
        getMeshValue().velocityModified = value;
    }

    @Override
    public float getHorizontalSpeed() {
        return getMeshValue().horizontalSpeed;
    }

    @Override
    public void setHorizontalSpeed(float value) {
        getMeshValue().horizontalSpeed = value;
    }

    @Override
    public float getPrevHorizontalSpeed() {
        return getMeshValue().prevHorizontalSpeed;
    }

    @Override
    public void setPrevHorizontalSpeed(float value) {
        getMeshValue().prevHorizontalSpeed = value;
    }

    @Override
    public float getDistanceTraveled() {
        return getMeshValue().distanceTraveled;
    }

    @Override
    public void setDistanceTraveled(float value) {
        getMeshValue().distanceTraveled = value;
    }

    @Override
    public float getFallDistance() {
        return getMeshValue().fallDistance;
    }

    @Override
    public void setFallDistance(float value) {
        getMeshValue().fallDistance = value;
    }

    @Override
    public float getNextStepSoundDistance() {
        return ((EntityAccessor) getMeshValue()).getNextStepSoundDistance();
    }

    @Override
    public void setNextStepSoundDistance(float value) {
        ((EntityAccessor) getMeshValue()).setNextStepSoundDistance(value);
    }

    @Override
    public float getStepHeight() {
        return getMeshValue().getStepHeight();
    }

    @Override
    public void setStepHeight(float value) {
        getMeshValue().setStepHeight(value);
    }

    @Override
    public boolean isNoClip() {
        return getMeshValue().noClip;
    }

    @Override
    public void setNoClip(boolean value) {
        getMeshValue().noClip = value;
    }

    @Override
    public int getAge() {
        return getMeshValue().age;
    }

    @Override
    public void setAge(int value) {
        getMeshValue().age = value;
    }

    @Override
    public int getFireTicks() {
        return getMeshValue().getFireTicks();
    }

    @Override
    public void setFireTicks(int value) {
        getMeshValue().setFireTicks(value);
    }

    @Override
    public boolean isInWater() {
        return getMeshValue().isTouchingWater();
    }

    @Override
    public void setInWater(boolean value) {
        ((EntityAccessor) getMeshValue()).setTouchingWater(value);
    }

    @Override
    public boolean isFirstUpdate() {
        return ((EntityAccessor) getMeshValue()).getFirstUpdate();
    }

    @Override
    public void setFirstUpdate(boolean value) {
        ((EntityAccessor) getMeshValue()).setFirstUpdate(value);
    }

    @Override
    public boolean isIgnoringCameraFrustum() {
        return getMeshValue().ignoreCameraFrustum;
    }

    @Override
    public void setIgnoreCameraFrustum(boolean value) {
        getMeshValue().ignoreCameraFrustum = value;
    }

    @Override
    public boolean isInPortal() {
        return ((EntityAccessor) getMeshValue()).isInNetherPortal();
    }

    @Override
    public void setInPortal(boolean value) {
        ((EntityAccessor) getMeshValue()).setInNetherPortal(value);
    }

    @Override
    public int getPortalCooldown() {
        return ((EntityAccessor) getMeshValue()).getNetherPortalCooldown();
    }

    @Override
    public void setPortalCooldown(int value) {
        ((EntityAccessor) getMeshValue()).setNetherPortalCooldown(value);
    }

    @Override
    public int getPortalTime() {
        return ((EntityAccessor) getMeshValue()).getNetherPortalTime();
    }

    @Override
    public void setPortalTime(int value) {
        ((EntityAccessor) getMeshValue()).setNetherPortalTime(value);
    }

    @Override
    public BlockPos getLastPortalPosition() {
        return (BlockPos) ((EntityAccessor) getMeshValue()).getLastNetherPortalPosition();
    }

    @Override
    public void setLastPortalPosition(BlockPos pos) {
        ((EntityAccessor) getMeshValue()).setLastNetherPortalPosition((net.minecraft.util.math.BlockPos) pos);
    }

    @Override
    public boolean isInvulnerable() {
        return getMeshValue().isInvulnerable();
    }

    @Override
    public void setInvulnerable(boolean value) {
        getMeshValue().setInvulnerable(value);
    }

    @Override
    public boolean isGlowing() {
        return getMeshValue().isGlowing();
    }

    @Override
    public void setGlowing(boolean value) {
        getMeshValue().setGlowing(value);
    }

    @Override
    public double[] getPistonMovementDelta() {
        return ((EntityAccessor) getMeshValue()).getPistonMovementDelta();
    }

    @Override
    public void setPistonMovementDelta(double[] value) {
        ((EntityAccessor) getMeshValue()).setPistonMovementDelta(value);
    }

    @Override
    public long getPistonDelta() {
        return ((EntityAccessor) getMeshValue()).getPistonMovementTick();
    }

    @Override
    public void setPistonDelta(long value) {
        ((EntityAccessor) getMeshValue()).setPistonMovementTick(value);
    }

    @Override
    public float getEyeHeight() {
        return getMeshValue().getEyeHeight(getMeshValue().getPose());
    }

    @Override
    public boolean isSpectator() {
        return getMeshValue().isSpectator();
    }

    @Override
    public void kill() {
        getMeshValue().kill();
    }

    @Override
    public void discard() {
        getMeshValue().discard();
    }

    @Override
    public Box calculateBoundingBox() {
        return (Box) ((EntityAccessor) getMeshValue()).getDimensions().getBoxAt(getMeshValue().getPos());
    }

    @Override
    public void tick() {
        getMeshValue().tick();
    }

    @Override
    public void baseTick() {
        getMeshValue().baseTick();
    }

    @Override
    public int getMaxInPortalTime() {
        return getMeshValue().getMaxNetherPortalTime();
    }

    @Override
    public void setOnFireFromLava() {
        getMeshValue().setOnFireFromLava();
    }

    @Override
    public void setOnFireFor(int value) {
        getMeshValue().setOnFireFor(value);
    }

    @Override
    public void tickInVoid() {
        ((EntityAccessor) getMeshValue()).tickInVoid();
    }

    @Override
    public void move(MoverType moverType, Vec3d movement) {
        getMeshValue().move(MCEnum.moverType(moverType), (net.minecraft.util.math.Vec3d) movement);
    }

    @Override
    public void checkBlockCollision() {
        ((EntityAccessor) getMeshValue()).checkBlockCollision();
    }

    @Override
    public boolean isSilent() {
        return getMeshValue().isSilent();
    }

    @Override
    public void setSilent(boolean value) {
        getMeshValue().setSilent(value);
    }

    @Override
    public boolean hasNoGravity() {
        return getMeshValue().hasNoGravity();
    }

    @Override
    public void setNoGravity(boolean value) {
        getMeshValue().setNoGravity(value);
    }

    @Override
    public boolean isImmuneToFire() {
        return getMeshValue().isFireImmune();
    }

    @Override
    public boolean isBeingRainedOn() {
        return ((EntityAccessor) getMeshValue()).isBeingRainedOn();
    }

    @Override
    public boolean isInsideWaterOrBubbleColumn() {
        return getMeshValue().isInsideWaterOrBubbleColumn();
    }

    @Override
    public void updateSwimming() {
        getMeshValue().updateSwimming();
    }

    @Override
    public void spawnSprintingParticles() {
        ((EntityAccessor) getMeshValue()).spawnSprintingParticles();
    }

    @Override
    public boolean isInLava() {
        return getMeshValue().isInLava();
    }

    @Override
    public void moveRelative(float speed, Vec3d vec3d) {
        getMeshValue().updateVelocity(speed, (net.minecraft.util.math.Vec3d) vec3d);
    }

    @Override
    public float getBrightnessAtEyes() {
        return getMeshValue().getBrightnessAtEyes();
    }

    @Override
    public void updatePositionAndAngles(double x, double y, double z, float yaw, float pitch) {
        getMeshValue().updatePositionAndAngles(x, y, z, yaw, pitch);
    }

    @Override
    public void onPlayerCollision(EntityPlayer entityPlayer) {
        getMeshValue().onPlayerCollision(((EntityPlayerMesh<?>) entityPlayer).getMeshValue());
    }

    @Override
    public void pushAwayFrom(Entity entity) {
        getMeshValue().pushAwayFrom(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public Vec3d getRotationVec() {
        return (Vec3d) getMeshValue().getRotationVector();
    }

    @Override
    public Vec3d getOppositeRotationVec() {
        return (Vec3d) getMeshValue().getOppositeRotationVector(MinecraftClient.getInstance().getTickDelta());
    }

    @Override
    public float getPitch(float delta) {
        return getMeshValue().getPitch(delta);
    }

    @Override
    public float getYaw(float delta) {
        return getMeshValue().getYaw(delta);
    }

    @Override
    public Vec3d getCameraPosVec(float delta) {
        return (Vec3d) getMeshValue().getCameraPosVec(delta);
    }

    @Override
    public boolean canBeCollidedWith() {
        return getMeshValue().isCollidable();
    }

    @Override
    public boolean canBePushed() {
        return getMeshValue().isPushable();
    }

    @Override
    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return getMeshValue().shouldRender(cameraX, cameraY, cameraZ);
    }

    @Override
    public boolean shouldRender(double distance) {
        return getMeshValue().shouldRender(distance);
    }

    @Override
    public boolean shouldSetPositionOnLoad() {
        return ((EntityAccessor) getMeshValue()).shouldSetPositionOnLoad();
    }

    @Override
    public String getEntityString() {
        return ((EntityAccessor) getMeshValue()).getSavedEntityId();
    }

    @Override
    public boolean isAlive() {
        return getMeshValue().isAlive();
    }

    @Override
    public boolean isInsideWall() {
        return getMeshValue().isInsideWall();
    }

    @Override
    public void tickRiding() {
        getMeshValue().tickRiding();
    }

    @Override
    public void updateRiderPosition(Entity entity) {
        getMeshValue().updatePassengerPosition(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public void onRiderLookAround(Entity entity) {
        getMeshValue().onPassengerLookAround(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public double getYOffset() {
        return getMeshValue().getHeightOffset();
    }

    @Override
    public double getMountedYOffset() {
        return getMeshValue().getMountedHeightOffset();
    }

    @Override
    public boolean startRidingEntity(Entity entity, boolean force) {
        return getMeshValue().startRiding(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public boolean canStartRiding(Entity entity) {
        return ((EntityAccessor) getMeshValue()).canStartRiding(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public void removeRiders() {
        getMeshValue().removeAllPassengers();
    }

    @Override
    public void dismountVehicle() {
        getMeshValue().dismountVehicle();
    }

    @Override
    public void addRider(Entity entity) {
        ((EntityAccessor) getMeshValue()).addPassenger(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public void removeRider(Entity entity) {
        ((EntityAccessor) getMeshValue()).removePassenger(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public boolean canAddRider(Entity entity) {
        return ((EntityAccessor) getMeshValue()).canAddPassenger(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public void updateTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate) {
        getMeshValue().updateTrackedPositionAndAngles(x, y, z, yaw, pitch, interpolationSteps, interpolate);
    }

    @Override
    public float getTargetingMargin() {
        return getMeshValue().getTargetingMargin();
    }

    @Override
    public void setInNetherPortal(BlockPos blockPos) {
        getMeshValue().setInNetherPortal((net.minecraft.util.math.BlockPos) blockPos);
    }

    @Override
    public int getDefaultNetherPortalCooldown() {
        return getMeshValue().getDefaultPortalCooldown();
    }

    @Override
    public void handleStatus(byte status) {
        getMeshValue().handleStatus(status);
    }

    @Override
    public void performHurtAnimation(float damageTiltYaw) {
        getMeshValue().animateDamage(damageTiltYaw);
    }

    @Override
    public boolean isOnFire() {
        return getMeshValue().isOnFire();
    }

    @Override
    public boolean hasVehicle() {
        return getMeshValue().hasVehicle();
    }

    @Override
    public boolean hasRiders() {
        return getMeshValue().hasPassengers();
    }

    @Override
    public boolean isSneaking() {
        return getMeshValue().isSneaking();
    }

    @Override
    public void setSneaking(boolean value) {
        getMeshValue().setSneaking(value);
    }

    @Override
    public Stance getStance() {
        return MeshEnum.stance(getMeshValue().getPose());
    }

    @Override
    public void setStance(Stance stance) {
        getMeshValue().setPose(MCEnum.stance(stance));
    }

    @Override
    public boolean isSprinting() {
        return getMeshValue().isSprinting();
    }

    @Override
    public void setSprinting(boolean value) {
        getMeshValue().setSprinting(value);
    }

    @Override
    public boolean isInvisible() {
        return getMeshValue().isInvisible();
    }

    @Override
    public boolean isInvisibleTo(EntityPlayer player) {
        return getMeshValue().isInvisibleTo(((EntityPlayerMesh<?>) player).getMeshValue());
    }

    @Override
    public void setInvisible(boolean value) {
        getMeshValue().setInvisible(value);
    }

    @Override
    public boolean getFlag(int index) {
        return ((EntityAccessor) getMeshValue()).getFlag(index);
    }

    @Override
    public void setFlag(int index, boolean value) {
        ((EntityAccessor) getMeshValue()).setFlag(index, value);
    }

    @Override
    public int getAir() {
        return getMeshValue().getAir();
    }

    @Override
    public void setAir(int air) {
        getMeshValue().setAir(air);
    }

    @Override
    public void pushOutOfSolidBlock(double x, double y, double z) {
        ((EntityAccessor) getMeshValue()).pushOutOfBlocks(x, y, z);
    }

    @Override
    public float getRenderHeadYaw() {
        return getMeshValue().getHeadYaw();
    }

    @Override
    public void setRenderHeadYaw(float headYaw) {
        getMeshValue().setHeadYaw(headYaw);
    }

    @Override
    public void setRenderBodyYaw(float bodyYaw) {
        getMeshValue().setBodyYaw(bodyYaw);
    }

    @Override
    public boolean isAttackable() {
        return getMeshValue().isAttackable();
    }

    @Override
    public boolean handleAttack(Entity attacker) {
        return getMeshValue().handleAttack(((EntityMesh<?>) attacker).getMeshValue());
    }

    @Override
    public void copyPositionAndRotation(Entity entity) {
        getMeshValue().copyPositionAndRotation(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public void copyFrom(Entity original) {
        getMeshValue().copyFrom(((EntityMesh<?>) original).getMeshValue());
    }

    @Override
    public int getSafeFallDistance() {
        return getMeshValue().getSafeFallDistance();
    }

    @Override
    public boolean canAvoidTraps() {
        return getMeshValue().canAvoidTraps();
    }

    @Override
    public boolean doesRenderOnFire() {
        return getMeshValue().doesRenderOnFire();
    }

    @Override
    public boolean isPushedByFluids() {
        return getMeshValue().isPushedByFluids();
    }

    @Override
    public boolean hasCustomNameTag() {
        return getMeshValue().hasCustomName();
    }

    @Override
    public boolean isCustomNameTagVisible() {
        return getMeshValue().isCustomNameVisible();
    }

    @Override
    public void setCustomNameTagVisible(boolean visible) {
        getMeshValue().setCustomNameVisible(visible);
    }

    @Override
    public void teleport(double destX, double destY, double destZ) {
        getMeshValue().teleport(destX, destY, destZ);
    }

    @Override
    public boolean shouldRenderName() {
        return getMeshValue().shouldRenderName();
    }

    @Override
    public Facing getHorizontalFacing() {
        return MeshEnum.facing(getMeshValue().getHorizontalFacing());
    }

    @Override
    public Facing getMovementDirection() {
        return MeshEnum.facing(getMeshValue().getMovementDirection());
    }

    @Override
    public Box getRenderBoundingBox() {
        return (Box) getMeshValue().getVisibilityBoundingBox();
    }

    @Override
    public boolean isImmuneToExplosion() {
        return getMeshValue().isImmuneToExplosion();
    }

    @Override
    public boolean entityDataRequiresOperator() {
        return getMeshValue().entityDataRequiresOperator();
    }

    @Override
    public Entity getControllingRider() {
        return Mappings.entity(getMeshValue().getControllingPassenger());
    }

    @Override
    public boolean hasRider(Entity entity) {
        return getMeshValue().hasPassenger(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public Entity getLowestVehicle() {
        return Mappings.entity(getMeshValue().getRootVehicle());
    }

    @Override
    public int getBurningDuration() {
        return ((EntityAccessor) getMeshValue()).getBurningDuration();
    }

    @Override
    public float getWidth() {
        return getMeshValue().getWidth();
    }

    @Override
    public float getHeight() {
        return getMeshValue().getHeight();
    }

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) getMeshValue().getBlockPos();
    }
}
