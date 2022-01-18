package dev.tigr.mesh.impl.entity;

import dev.tigr.mesh.api.AbstractMesh;
import dev.tigr.mesh.api.entity.Entity;
import dev.tigr.mesh.api.entity.EntityType;
import dev.tigr.mesh.api.entity.MoverType;
import dev.tigr.mesh.api.entity.player.PlayerEntity;
import dev.tigr.mesh.api.math.BlockPos;
import dev.tigr.mesh.api.math.Box;
import dev.tigr.mesh.api.math.Vec3d;
import dev.tigr.mesh.api.world.World;
import dev.tigr.mesh.impl.entity.player.PlayerEntityMesh;
import dev.tigr.mesh.impl.math.BlockPosMesh;
import dev.tigr.mesh.impl.math.BoxMesh;
import dev.tigr.mesh.impl.math.Vec3dMesh;
import dev.tigr.mesh.impl.mixin.accessors.entity.EntityAccessor;
import dev.tigr.mesh.impl.world.WorldMesh;
import dev.tigr.mesh.util.math.Facing;
import net.minecraft.entity.MovementType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tigermouthbear 1/16/22
 * @param <T>
 */
public class EntityMesh<T extends net.minecraft.entity.Entity> extends AbstractMesh<T> implements Entity<T> {
    public EntityMesh(T value) {
        super(value);
    }

    // must add entity mesh constructor here when a new mesh is added
    public static Entity<?> fromEntity(net.minecraft.entity.Entity entity) {
        if(entity instanceof net.minecraft.entity.player.PlayerEntity)
            return new PlayerEntityMesh((net.minecraft.entity.player.PlayerEntity) entity);
        return new EntityMesh<>(entity);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.valueOf(net.minecraft.entity.EntityType.getId(getMeshValue().getType()).getPath().toUpperCase());
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
    public List<Entity<?>> getPassengers() {
        List<Entity<?>> list = new ArrayList<>();
        for(net.minecraft.entity.Entity entity: getMeshValue().getPassengerList()) {
            list.add(fromEntity(entity));
        }
        return list;
    }

    @Override
    public int getRidingCooldown() {
        return ((EntityAccessor) getMeshValue()).getRidingCooldown();
    }

    @Override
    public void setRidingCooldown(int value) {
        ((EntityAccessor) getMeshValue()).setRidingCooldown(value);
    }

    @Override
    public Entity<?> getVehicle() {
        return fromEntity(getMeshValue().getVehicle());
    }

    @Override
    public void setVehicle(Entity<?> entity) {
        ((EntityAccessor) getMeshValue()).setVehicle((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public World<?> getWorld() {
        return WorldMesh.fromWorld(getMeshValue().world);
    }

    @Override
    public void setWorld(World<?> world) {
        getMeshValue().world = (net.minecraft.world.World) world.getMeshValue();
    }

    @Override
    public Vec3d<?> getPrevPosition() {
        return Vec3d.create(getPrevX(), getPrevY(), getPrevZ());
    }

    @Override
    public void setPrevPosition(Vec3d<?> position) {
        getMeshValue().prevX = position.getX();
        getMeshValue().prevY = position.getY();
        getMeshValue().prevZ = position.getZ();
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
        getMeshValue().prevX = value;
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
    public Vec3d<?> getPosition() {
        return new Vec3dMesh(getMeshValue().getPos());
    }

    @Override
    public void setPosition(double x, double y, double z) {
        getMeshValue().setPosition(x, y, z);
    }

    @Override
    public void setPosition(Vec3d<?> position) {
        getMeshValue().setPosition((net.minecraft.util.math.Vec3d) position.getMeshValue());
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
        getMeshValue().setPos(value, getY(), getZ());
    }

    @Override
    public void setY(double value) {
        getMeshValue().setPos(getX(), value, getZ());
    }

    @Override
    public void setZ(double value) {
        getMeshValue().setPos(getX(), getY(), value);
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
    public Vec3d<?> getVelocity() {
        return new Vec3dMesh(getMeshValue().getVelocity());
    }

    @Override
    public void setVelocity(double x, double y, double z) {
        getMeshValue().setVelocity(x, y, z);
    }

    @Override
    public void setVelocity(Vec3d<?> velocity) {
        getMeshValue().setVelocity((net.minecraft.util.math.Vec3d) velocity.getMeshValue());
    }

    @Override
    public double getXVelo() {
        return getMeshValue().getVelocity().x;
    }

    @Override
    public double getYVelo() {
        return getMeshValue().getVelocity().y;
    }

    @Override
    public double getZVelo() {
        return getMeshValue().getVelocity().z;
    }

    @Override
    public void setXVelo(double value) {
        getMeshValue().setVelocity(value, getYVelo(), getZVelo());
    }

    @Override
    public void setYVelo(double value) {
        getMeshValue().setVelocity(getXVelo(), value, getZVelo());
    }

    @Override
    public void setZVelo(double value) {
        getMeshValue().setVelocity(getXVelo(), getYVelo(), value);
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
    public void setYaw(float yaw) {
        getMeshValue().setYaw(yaw);
    }

    @Override
    public void setPitch(float pitch) {
        getMeshValue().setPitch(pitch);
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
    public void setPrevYaw(float yaw) {
        getMeshValue().prevYaw = yaw;
    }

    @Override
    public void setPrevPitch(float pitch) {
        getMeshValue().prevPitch = pitch;
    }

    @Override
    public Box<?> getBounds() {
        return new BoxMesh(getMeshValue().getBoundingBox());
    }

    @Override
    public void setBounds(Box<?> box) {
        getMeshValue().setBoundingBox((net.minecraft.util.math.Box) box.getMeshValue());
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
        return getMeshValue().stepHeight;
    }

    @Override
    public void setStepHeight(float value) {
        getMeshValue().stepHeight = value;
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
    public int getTicksExisted() {
        return getMeshValue().age;
    }

    @Override
    public void setTicksExisted(int value) {
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
        return ((EntityAccessor) getMeshValue()).isFirstUpdate();
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
    public BlockPos<?> getLastPortalPosition() {
        return new BlockPosMesh(((EntityAccessor) getMeshValue()).getLastNetherPortalPosition());
    }

    @Override
    public void setLastPortalPosition(BlockPos<?> pos) {
        ((EntityAccessor) getMeshValue()).setLastNetherPortalPosition((net.minecraft.util.math.BlockPos) pos.getMeshValue());
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
        return getMeshValue().getStandingEyeHeight();
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
    public Box<?> calculateBoundingBox() {
        return new BoxMesh(((EntityAccessor) getMeshValue()).calculateBoundingBox());
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
        getMeshValue().attemptTickInVoid();
    }

    @Override
    public void move(MoverType moverType, Vec3d<?> movement) {
        getMeshValue().move(MovementType.values()[moverType.ordinal()], (net.minecraft.util.math.Vec3d) movement.getMeshValue());
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
    public void moveRelative(float speed, Vec3d<?> vec3d) {
        getMeshValue().updateVelocity(speed, (net.minecraft.util.math.Vec3d) vec3d.getMeshValue());
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
    public void onPlayerCollision(PlayerEntity<?> playerEntity) {
        getMeshValue().onPlayerCollision((net.minecraft.entity.player.PlayerEntity) playerEntity.getMeshValue());
    }

    @Override
    public void pushAwayFrom(Entity<?> entity) {
        getMeshValue().pushAwayFrom((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public Vec3d<?> getRotationVec() {
        return new Vec3dMesh(getMeshValue().getRotationVector());
    }

    @Override
    public Vec3d<?> getOppositeRotationVec() {
        return new Vec3dMesh(((EntityAccessor) getMeshValue()).getOppositeRotationVector(getPitch(), getYaw()));
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
    public Vec3d<?> getCameraPosVec(float delta) {
        return new Vec3dMesh(getMeshValue().getCameraPosVec(delta));
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
    public void updatePassengerPosition(Entity<?> entity) {
        getMeshValue().updatePassengerPosition((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public void onPassengerLookAround(Entity<?> entity) {
        getMeshValue().onPassengerLookAround((net.minecraft.entity.Entity) entity.getMeshValue());
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
    public boolean startRiding(Entity<?> entity, boolean force) {
        return getMeshValue().startRiding((net.minecraft.entity.Entity) entity.getMeshValue(), force);
    }

    @Override
    public boolean canStartRiding(Entity<?> entity) {
        return ((EntityAccessor) getMeshValue()).canStartRiding((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public void removePassengers() {
        getMeshValue().removeAllPassengers();
    }

    @Override
    public void dismountVehicle() {
        getMeshValue().dismountVehicle();
    }

    @Override
    public void addPassenger(Entity<?> entity) {
        ((EntityAccessor) getMeshValue()).addPassenger((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public void removePassenger(Entity<?> entity) {
        ((EntityAccessor) getMeshValue()).removePassenger((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public boolean canAddPassenger(Entity<?> entity) {
        return ((EntityAccessor) getMeshValue()).canAddPassenger((net.minecraft.entity.Entity) entity.getMeshValue());
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
    public void setInNetherPortal(BlockPos<?> blockPos) {
        getMeshValue().setInNetherPortal((net.minecraft.util.math.BlockPos) blockPos.getMeshValue());
    }

    @Override
    public int getDefaultNetherPortalCooldown() {
        return getMeshValue().getDefaultNetherPortalCooldown();
    }

    @Override
    public void handleStatus(byte status) {
        getMeshValue().handleStatus(status);
    }

    @Override
    public void performHurtAnimation() {
        ((EntityAccessor) getMeshValue()).animateDamage();
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
    public boolean hasPassengers() {
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
    public boolean isInSneakingPose() {
        return getMeshValue().isInSneakingPose();
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
    public boolean isInvisibleTo(PlayerEntity<?> player) {
        return getMeshValue().isInvisibleTo((net.minecraft.entity.player.PlayerEntity) player.getMeshValue());
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
    public void pushOutOfBlocks(double x, double y, double z) {
        ((EntityAccessor) getMeshValue()).pushOutOfBlocks(x, y, z);
    }

    @Override
    public float getHeadYaw() {
        return getMeshValue().getHeadYaw();
    }

    @Override
    public void setHeadYaw(float headYaw) {
        getMeshValue().setHeadYaw(headYaw);
    }

    @Override
    public void setBodyYaw(float bodyYaw) {
        getMeshValue().setBodyYaw(bodyYaw);
    }

    @Override
    public boolean isAttackable() {
        return getMeshValue().isAttackable();
    }

    @Override
    public boolean handleAttack(Entity<?> attacker) {
        return getMeshValue().handleAttack((net.minecraft.entity.Entity) attacker.getMeshValue());
    }

    @Override
    public void copyPositionAndRotation(Entity<?> entity) {
        getMeshValue().copyPositionAndRotation((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public void copyFrom(Entity<?> original) {
        getMeshValue().copyFrom((net.minecraft.entity.Entity) original.getMeshValue());
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
        return Facing.values()[getMeshValue().getHorizontalFacing().ordinal()];
    }

    @Override
    public Facing getMovementDirection() {
        return Facing.values()[getMeshValue().getMovementDirection().ordinal()];
    }

    @Override
    public Box<?> getRenderBoundingBox() {
        return new BoxMesh(((EntityAccessor) getMeshValue()).getVisibilityBoundingBox());
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
    public Entity<?> getControllingPassenger() {
        return fromEntity(getMeshValue().getPrimaryPassenger());
    }

    @Override
    public boolean isPassenger(Entity<?> entity) {
        return getMeshValue().hasPassenger((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public Entity<?> getRootVehicle() {
        return fromEntity(getMeshValue().getRootVehicle());
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
    public BlockPos<?> getBlockPos() {
        return new BlockPosMesh(getMeshValue().getBlockPos());
    }
}
