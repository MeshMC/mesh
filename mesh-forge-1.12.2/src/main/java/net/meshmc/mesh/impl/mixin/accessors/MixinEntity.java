package net.meshmc.mesh.impl.mixin.accessors;

import net.meshmc.mesh.impl.util.duck.EntityAccessor;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;

@Mixin(Entity.class)
public abstract class MixinEntity implements EntityAccessor {
    @Shadow protected int rideCooldown;
    @Shadow private Entity ridingEntity;
    @Shadow private float nextFlap;
    @Shadow private int fire;
    @Shadow protected boolean inWater;
    @Shadow protected boolean firstUpdate;
    @Shadow protected boolean inPortal;
    @Shadow public int timeUntilPortal;
    @Shadow protected int portalCounter;
    @Shadow protected BlockPos lastPortalPos;
    @Mutable @Shadow @Final private double[] pistonDeltas;
    @Shadow private long pistonDeltasGameTime;
    @Shadow protected abstract void setOnFireFromLava();
    @Shadow protected abstract void outOfWorld();
    @Shadow protected abstract void doBlockCollisions();
    @Shadow protected abstract Vec3d getVectorForRotation(float pitch, float yaw);
    @Shadow protected abstract boolean shouldSetPosAfterLoading();
    @Shadow @Nullable protected abstract String getEntityString();
    @Shadow protected abstract boolean canBeRidden(Entity entityIn);
    @Shadow protected abstract void addPassenger(Entity passenger);
    @Shadow protected abstract void removePassenger(Entity passenger);
    @Shadow protected abstract boolean canFitPassenger(Entity passenger);
    @Shadow protected abstract boolean getFlag(int flag);
    @Shadow protected abstract void setFlag(int flag, boolean set);
    @Shadow protected abstract boolean pushOutOfBlocks(double x, double y, double z);
    @Shadow protected abstract void copyDataFromOld(Entity entityIn);
    @Shadow protected abstract int getFireImmuneTicks();

    @Override
    public int getRidingCooldown() {
        return rideCooldown;
    }

    @Override
    public void setRidingCooldown(int value) {
        rideCooldown = value;
    }

    @Override
    public void setVehicle(Entity entity) {
        ridingEntity = entity;
    }

    @Override
    public float getNextStepSoundDistance() {
        return nextFlap;
    }

    @Override
    public void setNextStepSoundDistance(float value) {
        nextFlap = value;
    }

    @Override
    public int getFireTicks() {
        return fire;
    }

    @Override
    public void setFireTicks(int value) {
        fire = value;
    }

    @Override
    public void setInWater(boolean value) {
        inWater = value;
    }

    @Override
    public boolean isFirstUpdate() {
        return firstUpdate;
    }

    @Override
    public void setFirstUpdate(boolean value) {
        firstUpdate = value;
    }

    @Override
    public boolean isInPortal() {
        return inPortal;
    }

    @Override
    public void setInPortal(boolean value) {
        inPortal = value;
    }

    @Override
    public int getPortalCooldown() {
        return timeUntilPortal;
    }

    @Override
    public void setPortalCooldown(int value) {
        timeUntilPortal = value;
    }

    @Override
    public int getPortalTime() {
        return portalCounter;
    }

    @Override
    public void setPortalTime(int value) {
        portalCounter = value;
    }

    @Override
    public BlockPos getLastPortalPosition() {
        return lastPortalPos;
    }

    @Override
    public void setLastPortalPosition(BlockPos blockPos) {
        lastPortalPos = blockPos;
    }

    @Override
    public double[] getPistonMovementDelta() {
        return pistonDeltas;
    }

    @Override
    public void setPistonMovementDelta(double[] value) {
        pistonDeltas = value;
    }

    @Override
    public long getPistonDelta() {
        return pistonDeltasGameTime;
    }

    @Override
    public void setPistonDelta(long value) {
        pistonDeltasGameTime = value;
    }

    @Override
    public void setOnFireFromLava_() {
        setOnFireFromLava();
    }

    @Override
    public void tickInVoid() {
        outOfWorld();
    }

    @Override
    public void checkBlockCollisions() {
        doBlockCollisions();
    }

    @Override
    public Vec3d getVectorForRotation_(float pitch, float yaw) {
        return getVectorForRotation(pitch, yaw);
    }

    @Override
    public boolean shouldSetPositionOnLoad() {
        return shouldSetPosAfterLoading();
    }

    @Override
    public String getEntityString_() {
        return getEntityString();
    }

    @Override
    public boolean canBeRidden_(Entity entity) {
        return canBeRidden(entity);
    }

    @Override
    public void addRider(Entity entity) {
        addPassenger(entity);
    }

    @Override
    public void removeRider(Entity entity) {
        removePassenger(entity);
    }

    @Override
    public boolean canAddRider(Entity entity) {
        return canFitPassenger(entity);
    }

    @Override
    public boolean getFlag_(int index) {
        return getFlag(index);
    }

    @Override
    public void setFlag_(int index, boolean value) {
        setFlag(index, value);
    }

    @Override
    public void pushOutOfSolidBlock(double x, double y, double z) {
        pushOutOfBlocks(x, y, z);
    }

    @Override
    public void copyFrom(Entity entity) {
        copyDataFromOld(entity);
    }

    @Override
    public int getBurningDuration() {
        return getFireImmuneTicks();
    }
}
