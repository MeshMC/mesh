package net.meshmc.mesh.impl.mixin.accessors.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Entity.class)
public interface EntityAccessor {
    @Accessor("ridingCooldown")
    int getRidingCooldown();

    @Accessor("ridingCooldown")
    void setRidingCooldown(int value);

    @Accessor("vehicle")
    void setVehicle(Entity entity);

    @Accessor("nextStepSoundDistance")
    float getNextStepSoundDistance();

    @Accessor("nextStepSoundDistance")
    void setNextStepSoundDistance(float value);

    @Accessor("touchingWater")
    void setTouchingWater(boolean value);

    @Accessor("firstUpdate")
    boolean getFirstUpdate();

    @Accessor("firstUpdate")
    void setFirstUpdate(boolean value);

    @Accessor("inNetherPortal")
    boolean isInNetherPortal();

    @Accessor("inNetherPortal")
    void setInNetherPortal(boolean value);

    @Accessor("netherPortalCooldown")
    int getNetherPortalCooldown();

    @Accessor("netherPortalCooldown")
    void setNetherPortalCooldown(int value);

    @Accessor("netherPortalTime")
    int getNetherPortalTime();

    @Accessor("netherPortalTime")
    void setNetherPortalTime(int value);

    @Accessor("lastNetherPortalPosition")
    BlockPos getLastNetherPortalPosition();

    @Accessor("lastNetherPortalPosition")
    void setLastNetherPortalPosition(BlockPos blockPos);

    @Accessor("pistonMovementDelta")
    double[] getPistonMovementDelta();

    @Accessor("pistonMovementDelta")
    void setPistonMovementDelta(double[] value);

    @Accessor("pistonMovementTick")
    long getPistonMovementTick();

    @Accessor("pistonMovementTick")
    void setPistonMovementTick(long value);

    @Accessor("dimensions")
    EntityDimensions getDimensions();

    @Invoker("tickInVoid")
    void tickInVoid();

    @Invoker("checkBlockCollision")
    void checkBlockCollision();

    @Invoker("isBeingRainedOn")
    boolean isBeingRainedOn();

    @Invoker("spawnSprintingParticles")
    void spawnSprintingParticles();

    @Invoker("shouldSetPositionOnLoad")
    boolean shouldSetPositionOnLoad();

    @Invoker("getSavedEntityId")
    String getSavedEntityId();

    @Invoker("canStartRiding")
    boolean canStartRiding(Entity entity);

    @Invoker("addPassenger")
    void addPassenger(Entity entity);

    @Invoker("removePassenger")
    void removePassenger(Entity entity);

    @Invoker("canAddPassenger")
    boolean canAddPassenger(Entity entity);

    @Invoker("getFlag")
    boolean getFlag(int index);

    @Invoker("setFlag")
    void setFlag(int index, boolean value);

    @Invoker("pushOutOfBlocks")
    void pushOutOfBlocks(double x, double y, double z);

    @Invoker("getBurningDuration")
    int getBurningDuration();
}
