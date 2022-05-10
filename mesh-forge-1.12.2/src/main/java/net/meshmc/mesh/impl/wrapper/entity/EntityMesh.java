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
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.Mappings;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.impl.util.duck.EntityAccessor;
import net.meshmc.mesh.impl.wrapper.collections.EntityList;
import net.meshmc.mesh.impl.wrapper.entity.living.player.EntityPlayerMesh;
import net.meshmc.mesh.impl.wrapper.world.WorldMesh;
import net.meshmc.mesh.util.entity.Stance;
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.MathHelper;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nullable;
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
        return getMeshValue().getEntityId();
    }

    @Override
    public void setId(int value) {
        getMeshValue().setEntityId(value);
    }

    @Override
    public List<Entity> getRiders() {
        return new EntityList(getMeshValue().getPassengers());
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
        if(getMeshValue().getRidingEntity() == null) return null;
        return Mappings.entity(getMeshValue().getRidingEntity());
    }

    @Override
    public void setVehicle(Entity entity) {
        ((EntityAccessor) getMeshValue()).setVehicle(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public World getWorld() {
        return Mappings.world(getMeshValue().world);
    }

    @Override
    public void setWorld(World world) {
        getMeshValue().world = ((WorldMesh<?>) world).getMeshValue();
    }

    @Override
    public double getPrevX() {
        return getMeshValue().prevPosX;
    }

    @Override
    public double getPrevY() {
        return getMeshValue().prevPosY;
    }

    @Override
    public double getPrevZ() {
        return getMeshValue().prevPosZ;
    }

    @Override
    public void setPrevX(double value) {
        getMeshValue().prevPosX = value;
    }

    @Override
    public void setPrevY(double value) {
        getMeshValue().prevPosY = value;
    }

    @Override
    public void setPrevZ(double value) {
        getMeshValue().prevPosZ = value;
    }

    @Override
    public Vec3d getPos() {
        return (Vec3d) getMeshValue().getPositionVector();
    }

    @Override
    public void setPosition(double x, double y, double z) {
        getMeshValue().setPosition(x, y, z);
    }

    @Override
    public double getX() {
        return getMeshValue().posX;
    }

    @Override
    public double getY() {
        return getMeshValue().posY;
    }

    @Override
    public double getZ() {
        return getMeshValue().posZ;
    }

    @Override
    public void setX(double value) {
        getMeshValue().posX = value;
    }

    @Override
    public void setY(double value) {
        getMeshValue().posY = value;
    }

    @Override
    public void setZ(double value) {
        getMeshValue().posZ = value;
    }

    @Override
    public double getLastRenderX() {
        return getMeshValue().lastTickPosX;
    }

    @Override
    public double getLastRenderY() {
        return getMeshValue().lastTickPosY;
    }

    @Override
    public double getLastRenderZ() {
        return getMeshValue().lastTickPosZ;
    }

    @Override
    public void setLastRenderX(double value) {
        getMeshValue().lastTickPosX = value;
    }

    @Override
    public void setLastRenderY(double value) {
        getMeshValue().lastTickPosY = value;
    }

    @Override
    public void setLastRenderZ(double value) {
        getMeshValue().lastTickPosZ = value;
    }

    @Override
    public Vec3d getVelocity() {
        return Vec3d.create(getMeshValue().motionX, getMeshValue().motionY, getMeshValue().motionZ);
    }

    @Override
    public void setVelocity(double x, double y, double z) {
        getMeshValue().setVelocity(x, y, z);
    }

    @Override
    public void setVelocity(Vec3d velocity) {
        getMeshValue().setVelocity(velocity.getX(), velocity.getY(), velocity.getZ());
    }

    @Override
    public double getVelocityX() {
        return getMeshValue().motionX;
    }

    @Override
    public double getVelocityY() {
        return getMeshValue().motionY;
    }

    @Override
    public double getVelocityZ() {
        return getMeshValue().motionZ;
    }

    @Override
    public void setVelocityX(double value) {
        getMeshValue().motionX = value;
    }

    @Override
    public void setVelocityY(double value) {
        getMeshValue().motionY = value;
    }

    @Override
    public void setVelocityZ(double value) {
        getMeshValue().motionZ = value;
    }

    @Override
    public float getYaw() {
        return getMeshValue().rotationYaw;
    }

    @Override
    public float getPitch() {
        return getMeshValue().rotationPitch;
    }

    @Override
    public void setYaw(float value) {
        getMeshValue().rotationYaw = value;
    }

    @Override
    public void setPitch(float value) {
        getMeshValue().rotationPitch = value;
    }

    @Override
    public float getPrevYaw() {
        return getMeshValue().prevRotationYaw;
    }

    @Override
    public float getPrevPitch() {
        return getMeshValue().prevRotationPitch;
    }

    @Override
    public void setPrevYaw(float value) {
        getMeshValue().prevRotationYaw = value;
    }

    @Override
    public void setPrevPitch(float value) {
        getMeshValue().prevRotationPitch = value;
    }

    @Override
    public Box getBoundingBox() {
        return (Box) getMeshValue().getEntityBoundingBox();
    }

    @Override
    public void setBoundingBox(Box box) {
        getMeshValue().setEntityBoundingBox((AxisAlignedBB) box);
    }

    @Override
    public boolean isOnGround() {
        return getMeshValue().onGround;
    }

    @Override
    public void setOnGround(boolean value) {
        getMeshValue().onGround = value;
    }

    @Override
    public boolean isCollidedHorizontally() {
        return getMeshValue().collidedHorizontally;
    }

    @Override
    public void setCollidedHorizontally(boolean value) {
        getMeshValue().collidedHorizontally = value;
    }

    @Override
    public boolean isCollidedVertically() {
        return getMeshValue().collidedVertically;
    }

    @Override
    public void setCollidedVertically(boolean value) {
        getMeshValue().collidedVertically = value;
    }

    @Override
    public boolean isCollided() {
        return getMeshValue().collided;
    }

    @Override
    public void setCollided(boolean value) {
        getMeshValue().collided = value;
    }

    @Override
    public boolean isVelocityChanged() {
        return getMeshValue().velocityChanged;
    }

    @Override
    public void setVelocityChanged(boolean value) {
        getMeshValue().velocityChanged = value;
    }

    @Override
    public float getHorizontalSpeed() {
        return getMeshValue().distanceWalkedModified;
    }

    @Override
    public void setHorizontalSpeed(float value) {
        getMeshValue().distanceWalkedModified = value;
    }

    @Override
    public float getPrevHorizontalSpeed() {
        return getMeshValue().prevDistanceWalkedModified;
    }

    @Override
    public void setPrevHorizontalSpeed(float value) {
        getMeshValue().prevDistanceWalkedModified = value;
    }

    @Override
    public float getDistanceTraveled() {
        return getMeshValue().distanceWalkedOnStepModified;
    }

    @Override
    public void setDistanceTraveled(float value) {
        getMeshValue().distanceWalkedOnStepModified = value;
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
    public int getAge() {
        return getMeshValue().ticksExisted;
    }

    @Override
    public void setAge(int value) {
        getMeshValue().ticksExisted = value;
    }

    @Override
    public int getFireTicks() {
        return ((EntityAccessor) getMeshValue()).getFireTicks();
    }

    @Override
    public void setFireTicks(int value) {
        ((EntityAccessor) getMeshValue()).setFireTicks(value);
    }

    @Override
    public boolean isInWater() {
        return getMeshValue().isInWater();
    }

    @Override
    public void setInWater(boolean value) {
        ((EntityAccessor) getMeshValue()).setInWater(value);
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
        return getMeshValue().ignoreFrustumCheck;
    }

    @Override
    public void setIgnoreCameraFrustum(boolean value) {
        getMeshValue().ignoreFrustumCheck = value;
    }

    @Override
    public boolean isInPortal() {
        return ((EntityAccessor) getMeshValue()).isInPortal();
    }

    @Override
    public void setInPortal(boolean value) {
        ((EntityAccessor) getMeshValue()).setInPortal(value);
    }

    @Override
    public int getPortalCooldown() {
        return ((EntityAccessor) getMeshValue()).getPortalCooldown();
    }

    @Override
    public void setPortalCooldown(int value) {
        ((EntityAccessor) getMeshValue()).setPortalCooldown(value);
    }

    @Override
    public int getPortalTime() {
        return ((EntityAccessor) getMeshValue()).getPortalTime();
    }

    @Override
    public void setPortalTime(int value) {
        ((EntityAccessor) getMeshValue()).setPortalTime(value);
    }

    @Override
    public BlockPos getLastPortalPosition() {
        return (BlockPos) ((EntityAccessor) getMeshValue()).getLastPortalPosition();
    }

    @Override
    public void setLastPortalPosition(BlockPos pos) {
        ((EntityAccessor) getMeshValue()).setLastPortalPosition((net.minecraft.util.math.BlockPos) pos);
    }

    @Override
    public boolean isInvulnerable() {
        return getMeshValue().getIsInvulnerable();
    }

    @Override
    public void setInvulnerable(boolean value) {
        getMeshValue().setEntityInvulnerable(value);
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
        return ((EntityAccessor) getMeshValue()).getPistonDelta();
    }

    @Override
    public void setPistonDelta(long value) {
        ((EntityAccessor) getMeshValue()).setPistonDelta(value);
    }

    @Override
    public float getEyeHeight() {
        return getMeshValue().getEyeHeight();
    }

    @Override
    public boolean isSpectator() {
        return getMeshValue() instanceof net.minecraft.entity.player.EntityPlayer && ((net.minecraft.entity.player.EntityPlayer) getMeshValue()).isSpectator();
    }

    @Override
    public void kill() {
        getMeshValue().onKillCommand();
    }

    @Override
    public void discard() {
        getMeshValue().setDead();
    }

    @Override
    public Box calculateBoundingBox() {
        double x = getMeshValue().posX;
        double y = getMeshValue().posY;
        double z = getMeshValue().posZ;
        float f = getMeshValue().width / 2.0F;
        float f1 = getMeshValue().height;
        return (Box) new AxisAlignedBB(x - (double)f, y, z - (double)f, x + (double)f, y + (double)f1, z + (double)f);
    }

    @Override
    public void tick() {
        getMeshValue().onUpdate();
    }

    @Override
    public void baseTick() {
        getMeshValue().onEntityUpdate();
    }

    @Override
    public int getMaxInPortalTime() {
        return getMeshValue().getMaxInPortalTime();
    }

    @Override
    public void setOnFireFromLava() {
        ((EntityAccessor) getMeshValue()).setOnFireFromLava_();
    }

    @Override
    public void setOnFireFor(int value) {
        getMeshValue().setFire(value);
    }

    @Override
    public void tickInVoid() {
        ((EntityAccessor) getMeshValue()).tickInVoid();
    }

    @Override
    public void move(MoverType moverType, Vec3d movement) {
        getMeshValue().move(MCEnum.moverType(moverType), movement.getX(), movement.getY(), movement.getZ());
    }

    @Override
    public void checkBlockCollision() {
        ((EntityAccessor) getMeshValue()).checkBlockCollisions();
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
        return getMeshValue().isImmuneToFire();
    }

    @Override
    public boolean isBeingRainedOn() {
        net.minecraft.util.math.BlockPos.PooledMutableBlockPos block = net.minecraft.util.math.BlockPos.PooledMutableBlockPos.retain(getMeshValue().posX, getMeshValue().posY, getMeshValue().posZ);
        if(!getMeshValue().world.isRainingAt(block) && !getMeshValue().world.isRainingAt(block.setPos(getMeshValue().posX, getMeshValue().posY + (double)getMeshValue().height, getMeshValue().posZ))) {
            block.release();
            return false;
        }
        else {
            block.release();
            return true;
        }
    }

    @Override
    public boolean isInsideWaterOrBubbleColumn() {
        return getMeshValue().isInWater();
    }

    @Override
    public void updateSwimming() {
        // not in this version
    }

    @Override
    public void spawnSprintingParticles() {
        getMeshValue().spawnRunningParticles();
    }

    @Override
    public boolean isInLava() {
        return getMeshValue().isInLava();
    }

    @Override
    public void moveRelative(float speed, Vec3d vec3d) {
        getMeshValue().moveRelative(speed, (float) vec3d.getX(), (float) vec3d.getY(), (float) vec3d.getZ());
    }

    @Override
    public float getBrightnessAtEyes() {
        return getMeshValue().getBrightnessForRender();
    }

    @Override
    public void updatePositionAndAngles(double x, double y, double z, float yaw, float pitch) {
        getMeshValue().setPositionAndRotation(x, y, z, yaw, pitch);
    }

    @Override
    public void onPlayerCollision(EntityPlayer entityPlayer) {
        getMeshValue().onCollideWithPlayer(((EntityPlayerMesh<?>) entityPlayer).getMeshValue());
    }

    @Override
    public void pushAwayFrom(Entity entity) {
        getMeshValue().applyEntityCollision(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public Vec3d getRotationVec() {
        return (Vec3d) getMeshValue().getLookVec();
    }

    @Override
    public Vec3d getOppositeRotationVec() {
        return (Vec3d) ((EntityAccessor) getMeshValue()).getVectorForRotation_(getMeshValue().rotationPitch - 90F, getMeshValue().rotationYaw);
    }

    @Override
    public float getPitch(float delta) {
        return delta == 1.0F ? getMeshValue().rotationPitch : MathHelper.lerp(delta, getMeshValue().prevRotationPitch, getMeshValue().rotationPitch);
    }

    @Override
    public float getYaw(float delta) {
        return delta == 1.0F ? getMeshValue().rotationYaw : MathHelper.lerp(delta, getMeshValue().prevRotationYaw, getMeshValue().rotationYaw);
    }

    @Override
    public Vec3d getCameraPosVec(float delta) {
        return (Vec3d) getMeshValue().getPositionEyes(delta);
    }

    @Override
    public boolean canBeCollidedWith() {
        return getMeshValue().canBeCollidedWith();
    }

    @Override
    public boolean canBePushed() {
        return getMeshValue().canBePushed();
    }

    @Override
    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return getMeshValue().isInRangeToRender3d(cameraX, cameraY, cameraZ);
    }

    @Override
    public boolean shouldRender(double distance) {
        return getMeshValue().isInRangeToRenderDist(distance);
    }

    @Override
    public boolean shouldSetPositionOnLoad() {
        return ((EntityAccessor) getMeshValue()).shouldSetPositionOnLoad();
    }

    @Override
    public String getEntityString() {
        return ((EntityAccessor) getMeshValue()).getEntityString_();
    }

    @Override
    public boolean isAlive() {
        return getMeshValue().isEntityAlive();
    }

    @Override
    public boolean isInsideWall() {
        return getMeshValue().isEntityInsideOpaqueBlock();
    }

    @Override
    public void tickRiding() {
        getMeshValue().updateRidden();
    }

    @Override
    public void updateRiderPosition(Entity entity) {
        getMeshValue().updatePassenger(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public void onRiderLookAround(Entity entity) {
        getMeshValue().applyOrientationToEntity(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public double getYOffset() {
        return getMeshValue().getYOffset();
    }
    @Override
    public double getMountedYOffset() {
        return getMeshValue().getMountedYOffset();
    }

    @Override
    public boolean startRidingEntity(Entity entity, boolean force) {
        return getMeshValue().startRiding(((EntityMesh<?>) entity).getMeshValue(), force);
    }

    @Override
    public boolean canStartRiding(Entity entity) {
        return ((EntityAccessor) getMeshValue()).canBeRidden_(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public void removeRiders() {
        getMeshValue().removePassengers();
    }

    @Override
    public void dismountVehicle() {
        getMeshValue().dismountRidingEntity();
    }

    @Override
    public void addRider(Entity entity) {
        ((EntityAccessor) getMeshValue()).addRider(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public void removeRider(Entity entity) {
        ((EntityAccessor) getMeshValue()).removeRider(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public boolean canAddRider(Entity entity) {
        return ((EntityAccessor) getMeshValue()).canAddRider(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public void updateTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate) {
        getMeshValue().setPositionAndRotationDirect(x, y, z, yaw, pitch, interpolationSteps, interpolate);
    }

    @Override
    public float getTargetingMargin() {
        return getMeshValue().getCollisionBorderSize();
    }

    @Override
    public void setInNetherPortal(BlockPos blockPos) {
        getMeshValue().setPortal((net.minecraft.util.math.BlockPos) blockPos);
    }

    @Override
    public int getDefaultNetherPortalCooldown() {
        return getPortalCooldown();
    }

    @Override
    public void handleStatus(byte status) {
        getMeshValue().handleStatusUpdate(status);
    }

    @Override
    public void performHurtAnimation() {
        getMeshValue().performHurtAnimation();
    }

    @Override
    public boolean isOnFire() {
        return getMeshValue().isBurning();
    }

    @Override
    public boolean hasVehicle() {
        return getMeshValue().isRiding();
    }

    @Override
    public boolean hasRiders() {
        return getMeshValue().isBeingRidden();
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
        if(isSneaking()) return Stance.CROUCHING;
        else return Stance.STANDING;
    }

    @Override
    public void setStance(Stance stance) {
        //TODO: make this change clientside stance/animation like in 1.18?
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
        return getMeshValue().isInvisibleToPlayer(((EntityPlayerMesh<?>) player).getMeshValue());
    }

    @Override
    public void setInvisible(boolean value) {
        getMeshValue().setInvisible(value);
    }

    @Override
    public boolean getFlag(int index) {
        return ((EntityAccessor) getMeshValue()).getFlag_(index);
    }

    @Override
    public void setFlag(int index, boolean value) {
        ((EntityAccessor) getMeshValue()).setFlag_(index, value);
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
        ((EntityAccessor) getMeshValue()).pushOutOfSolidBlock(x, y, z);
    }

    @Override
    public float getRenderHeadYaw() {
        return getMeshValue().getRotationYawHead();
    }

    @Override
    public void setRenderHeadYaw(float headYaw) {
        getMeshValue().setRotationYawHead(headYaw);
    }

    @Override
    public void setRenderBodyYaw(float bodyYaw) {
        getMeshValue().setRenderYawOffset(bodyYaw);
    }

    @Override
    public boolean isAttackable() {
        return getMeshValue().canBeAttackedWithItem();
    }

    @Override
    public boolean handleAttack(Entity attacker) {
        return getMeshValue().hitByEntity(((EntityMesh<?>) attacker).getMeshValue());
    }

    @Override
    public void copyPositionAndRotation(Entity entity) {
        getMeshValue().copyLocationAndAnglesFrom(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public void copyFrom(Entity original) {
        ((EntityAccessor) getMeshValue()).copyFrom(((EntityMesh<?>) original).getMeshValue());
    }

    @Override
    public int getSafeFallDistance() {
        return getMeshValue().getMaxFallHeight();
    }

    @Override
    public boolean canAvoidTraps() {
        return getMeshValue().doesEntityNotTriggerPressurePlate();
    }

    @Override
    public boolean doesRenderOnFire() {
        return getMeshValue().canRenderOnFire();
    }

    @Override
    public boolean isPushedByFluids() {
        return getMeshValue().isPushedByWater();
    }

    @Override
    public boolean hasCustomNameTag() {
        return getMeshValue().hasCustomName();
    }

    @Override
    public boolean isCustomNameTagVisible() {
        return getMeshValue().getAlwaysRenderNameTag();
    }

    @Override
    public void setCustomNameTagVisible(boolean visible) {
        getMeshValue().setAlwaysRenderNameTag(visible);
    }

    @Override
    public void teleport(double destX, double destY, double destZ) {
        getMeshValue().setPositionAndUpdate(destX, destY, destZ);
    }

    @Override
    public boolean shouldRenderName() {
        return getMeshValue().getAlwaysRenderNameTagForRender();
    }

    @Override
    public Facing getHorizontalFacing() {
        return MeshEnum.facing(getMeshValue().getHorizontalFacing());
    }

    @Override
    public Facing getMovementDirection() {
        return MeshEnum.facing(getMeshValue().getAdjustedHorizontalFacing());
    }

    @Override
    public Box getRenderBoundingBox() {
        return (Box) getMeshValue().getRenderBoundingBox();
    }

    @Override
    public boolean isImmuneToExplosion() {
        return getMeshValue().isImmuneToExplosions();
    }

    @Override
    public boolean entityDataRequiresOperator() {
        return getMeshValue().ignoreItemEntityData();
    }

    @Override
    public Entity getControllingRider() {
        return Mappings.entity(getMeshValue().getControllingPassenger());
    }

    @Override
    public boolean hasRider(Entity entity) {
        return getMeshValue().isPassenger(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public Entity getLowestVehicle() {
        return Mappings.entity(getMeshValue().getLowestRidingEntity());
    }

    @Override
    public int getBurningDuration() {
        return ((EntityAccessor) getMeshValue()).getBurningDuration();
    }

    @Override
    public float getWidth() {
        return getMeshValue().width;
    }

    @Override
    public float getHeight() {
        return getMeshValue().height;
    }

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) getMeshValue().getPosition();
    }
}
