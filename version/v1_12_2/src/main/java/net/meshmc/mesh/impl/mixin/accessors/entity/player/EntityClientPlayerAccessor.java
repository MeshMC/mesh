package net.meshmc.mesh.impl.mixin.accessors.entity.player;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(EntityPlayerSP.class)
public interface EntityClientPlayerAccessor {
    @Accessor("lastReportedPosX")
    double getLastX();

    @Accessor("lastReportedPosX")
    void setLastX(double value);

    @Accessor("lastReportedPosY")
    double getLastY();

    @Accessor("lastReportedPosY")
    void setLastY(double value);

    @Accessor("lastReportedPosZ")
    double getLastZ();

    @Accessor("lastReportedPosZ")
    void setLastZ(double value);

    @Accessor("lastReportedYaw")
    float getLastYaw();

    @Accessor("lastReportedYaw")
    void setLastYaw(float value);

    @Accessor("lastReportedPitch")
    float getLastPitch();

    @Accessor("lastReportedPitch")
    void setLastPitch(float value);

    @Accessor("prevOnGround")
    boolean getLastOnGround();

    @Accessor("prevOnGround")
    void setLastOnGround(boolean value);

    @Accessor("serverSneakState")
    boolean getLastSneaking();

    @Accessor("serverSneakState")
    void setLastSneaking(boolean value);

    @Accessor("serverSprintState")
    boolean getLastSprinting();

    @Accessor("serverSprintState")
    void setLastSprinting(boolean value);

    @Accessor("positionUpdateTicks")
    int getTicksSinceLastPositionPacketSent();

    @Accessor("positionUpdateTicks")
    void setTicksSinceLastPositionPacketSent(int value);

    @Accessor("hasValidHealth")
    boolean isHealthInitialized();

    @Accessor("hasValidHealth")
    void setHealthInitialized(boolean value);

    @Accessor("sprintToggleTimer")
    int getTicksLeftToDoubleTapSprint();

    @Accessor("sprintToggleTimer")
    void setTicksLeftToDoubleTapSprint(int value);

    @Accessor("horseJumpPowerCounter")
    int getMountJumpStrengthCounter();

    @Accessor("horseJumpPowerCounter")
    void setMountJumpStrengthCounter(int value);

    @Accessor("horseJumpPower")
    void setMountJumpStrength(float value);

    @Accessor("timeInPortal")
    float getNextNauseaStrength();

    @Accessor("timeInPortal")
    void setNextNauseaStrength(float value);

    @Accessor("prevTimeInPortal")
    float getLastNauseaStrength();

    @Accessor("prevTimeInPortal")
    void setLastNauseaStrength(float value);

    @Accessor("handActive")
    void setUsingItem(boolean value);

    @Accessor("rowingBoat")
    void setRiding(boolean value);

    @Accessor("autoJumpEnabled")
    void setAutoJumpEnabled(boolean value);

    @Accessor("autoJumpTime")
    int getTicksToNextAutoJump();

    @Accessor("autoJumpTime")
    void setTicksToNextAutoJump(int value);

    @Accessor("wasFallFlying")
    boolean isFalling();

    @Accessor("wasFallFlying")
    void setFalling(boolean value);


    @Invoker("onUpdateWalkingPlayer")
    void sendMovementPackets();

    @Invoker("sendHorseJump")
    void startRidingJump();

    @Invoker("getPermissionLevel")
    int getPermissionLevel();

    @Invoker("isHeadspaceFree")
    boolean isHeadspaceFree(BlockPos pos, int height);

    @Invoker("pushOutOfBlocks")
    boolean pushOutOfBlocks(double x, double y, double z);

    @Invoker("isCurrentViewEntity")
    boolean isCamera();

    @Invoker("updateAutoJump")
    void autoJump(float dx, float dz);
}
