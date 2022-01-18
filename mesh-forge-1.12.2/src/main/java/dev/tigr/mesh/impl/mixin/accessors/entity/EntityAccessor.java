package dev.tigr.mesh.impl.mixin.accessors.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Entity.class)
public interface EntityAccessor {
    @Accessor("fire")
    int getFireTicks();

    @Accessor("fire")
    void setFireTicks(int value);

    @Accessor("rideCooldown")
    int getRidingCooldown();

    @Accessor("rideCooldown")
    void setRidingCooldown(int value);

    @Accessor("ridingEntity")
    void setVehicle(Entity entity);

    @Accessor("nextFlap")
    float getNextStepSoundDistance();

    @Accessor("nextFlap")
    void setNextStepSoundDistance(float value);

    @Accessor("inWater")
    void setTouchingWater(boolean value);

    @Accessor("firstUpdate")
    boolean isFirstUpdate();

    @Accessor("firstUpdate")
    void setFirstUpdate(boolean value);

    @Accessor("inPortal")
    boolean isInNetherPortal();

    @Accessor("inPortal")
    void setInNetherPortal(boolean value);

    @Accessor("portalCounter")
    int getNetherPortalTime();

    @Accessor("portalCounter")
    void setNetherPortalTime(int value);

    @Accessor("lastPortalPos")
    BlockPos getLastNetherPortalPosition();

    @Accessor("lastPortalPos")
    void setLastNetherPortalPosition(BlockPos value);

    @Accessor("lastPortalVec")
    void setLastNetherPortalVector(Vec3d value);

    @Accessor("pistonDeltas")
    double[] getPistonMovementDelta();

    @Accessor("pistonDeltas")
    void setPistonMovementDelta(double[] value);

    @Accessor("pistonDeltasGameTime")
    long getPistonMovementTick();

    @Accessor("pistonDeltasGameTime")
    void setPistonMovementTick(long value);

    @Invoker("doBlockCollisions")
    void checkBlockCollision();

    @Invoker("setOnFireFromLava")
    void setOnFireFromLava();

    @Invoker("shouldSetPosAfterLoading")
    boolean shouldSetPositionOnLoad();

    @Invoker("canBeRidden")
    boolean canStartRiding(Entity entity);

    @Invoker("addPassenger")
    void addPassenger(Entity entity);

    @Invoker("removePassenger")
    void removePassenger(Entity entity);

    @Invoker("canFitPassenger")
    boolean canAddPassenger(Entity entity);

    @Invoker("getFlag")
    boolean getFlag(int index);

    @Invoker("setFlag")
    void setFlag(int index, boolean value);

    @Invoker("pushOutOfBlocks")
    boolean pushOutOfBlocks(double x, double y, double z);

    @Invoker("copyDataFromOld")
    void copyDataFromOld(Entity entity);

    @Invoker("getFireImmuneTicks")
    int getBurningDuration();

    @Invoker("getVectorForRotation")
    Vec3d getVectorForRotation(float pitch, float yaw);

    @Invoker("getEntityString")
    String getEntityString();

    @Invoker("outOfWorld")
    void outOfWorld();
}
