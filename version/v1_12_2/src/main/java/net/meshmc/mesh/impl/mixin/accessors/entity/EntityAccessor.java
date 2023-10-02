package net.meshmc.mesh.impl.mixin.accessors.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Entity.class)
public interface EntityAccessor {
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

    @Accessor("fire")
    int getFireTicks();

    @Accessor("fire")
    void setFireTicks(int value);

    @Accessor("inWater")
    void setInWater(boolean value);

    @Accessor("firstUpdate")
    boolean isFirstUpdate();

    @Accessor("firstUpdate")
    void setFirstUpdate(boolean value);

    @Accessor("inPortal")
    boolean isInPortal();

    @Accessor("inPortal")
    void setInPortal(boolean value);

    @Accessor("timeUntilPortal")
    int getPortalCooldown();

    @Accessor("timeUntilPortal")
    void setPortalCooldown(int value);

    @Accessor("portalCounter")
    int getPortalTime();

    @Accessor("portalCounter")
    void setPortalTime(int value);

    @Accessor("lastPortalPos")
    BlockPos getLastPortalPosition();

    @Accessor("lastPortalPos")
    void setLastPortalPosition(BlockPos blockPos);

    @Accessor("pistonDeltas")
    double[] getPistonMovementDelta();

    @Accessor("pistonDeltas")
    void setPistonMovementDelta(double[] value);

    @Accessor("pistonDeltasGameTime")
    long getPistonDelta();

    @Accessor("pistonDeltasGameTime")
    void setPistonDelta(long value);

    @Invoker("setOnFireFromLava")
    void setOnFireFromLava_();

    @Invoker("outOfWorld")
    void tickInVoid();

    @Invoker("doBlockCollisions")
    void checkBlockCollisions();

    @Invoker("getVectorForRotation")
    Vec3d getVectorForRotation_(float pitch, float yaw);

    @Invoker("shouldSetPosAfterLoading")
    boolean shouldSetPositionOnLoad();

    @Invoker("getEntityString")
    String getEntityString_();

    @Invoker("canBeRidden")
    boolean canBeRidden_(Entity entity);

    @Invoker("addPassenger")
    void addRider(Entity entity);

    @Invoker("removePassenger")
    void removeRider(Entity entity);

    @Invoker("canFitPassenger")
    boolean canAddRider(Entity entity);

    @Invoker("getFlag")
    boolean getFlag_(int index);

    @Invoker("setFlag")
    void setFlag_(int index, boolean value);

    @Invoker("pushOutOfBlocks")
    boolean pushOutOfSolidBlock(double x, double y, double z);

    @Invoker("copyDataFromOld")
    void copyFrom(Entity entity);

    @Invoker("getFireImmuneTicks")
    int getBurningDuration();
}
