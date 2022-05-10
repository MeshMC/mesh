package net.meshmc.mesh.impl.util.duck;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public interface EntityAccessor {
    int getRidingCooldown();
    void setRidingCooldown(int value);

    void setVehicle(Entity entity);

    float getNextStepSoundDistance();
    void setNextStepSoundDistance(float value);

    int getFireTicks();
    void setFireTicks(int value);

    void setInWater(boolean value);

    boolean isFirstUpdate();
    void setFirstUpdate(boolean value);

    boolean isInPortal();
    void setInPortal(boolean value);

    int getPortalCooldown();
    void setPortalCooldown(int value);

    int getPortalTime();
    void setPortalTime(int value);

    BlockPos getLastPortalPosition();
    void setLastPortalPosition(BlockPos blockPos);

    double[] getPistonMovementDelta();
    void setPistonMovementDelta(double[] value);

    long getPistonDelta();
    void setPistonDelta(long value);

    void setOnFireFromLava_();

    void tickInVoid();

    void checkBlockCollisions();

    Vec3d getVectorForRotation_(float pitch, float yaw);

    boolean shouldSetPositionOnLoad();

    String getEntityString_();

    boolean canBeRidden_(Entity entity);

    void addRider(Entity entity);

    void removeRider(Entity entity);

    boolean canAddRider(Entity entity);

    boolean getFlag_(int index);
    void setFlag_(int index, boolean value);

    void pushOutOfSolidBlock(double x, double y, double z);

    void copyFrom(Entity entity);

    int getBurningDuration();
}
