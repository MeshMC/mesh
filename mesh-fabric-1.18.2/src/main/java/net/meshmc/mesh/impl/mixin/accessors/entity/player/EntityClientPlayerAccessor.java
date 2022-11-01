package net.meshmc.mesh.impl.mixin.accessors.entity.player;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ClientPlayerEntity.class)
public interface EntityClientPlayerAccessor {
    @Accessor("lastX")
    double getLastX();

    @Accessor("lastX")
    void setLastX(double value);

    @Accessor("lastBaseY")
    double getLastY();

    @Accessor("lastBaseY")
    void setLastY(double value);

    @Accessor("lastZ")
    double getLastZ();

    @Accessor("lastZ")
    void setLastZ(double value);

    @Accessor("lastYaw")
    float getLastYaw();

    @Accessor("lastYaw")
    void setLastYaw(float value);

    @Accessor("lastPitch")
    float getLastPitch();

    @Accessor("lastPitch")
    void setLastPitch(float value);

    @Accessor("lastOnGround")
    boolean getLastOnGround();

    @Accessor("lastOnGround")
    void setLastOnGround(boolean value);

    @Accessor("inSneakingPose")
    boolean isInSneakingPose();

    @Accessor("inSneakingPose")
    void setInSneakingPose(boolean value);

    @Accessor("lastSneaking")
    boolean getLastSneaking();

    @Accessor("lastSneaking")
    void setLastSneaking(boolean value);

    @Accessor("lastSprinting")
    boolean getLastSprinting();

    @Accessor("lastSprinting")
    void setLastSprinting(boolean value);

    @Accessor("ticksSinceLastPositionPacketSent")
    int getTicksSinceLastPositionPacketSent();

    @Accessor("ticksSinceLastPositionPacketSent")
    void setTicksSinceLastPositionPacketSent(int value);

    @Accessor("healthInitialized")
    boolean isHealthInitialized();

    @Accessor("healthInitialized")
    void setHealthInitialized(boolean value);

    @Accessor("ticksLeftToDoubleTapSprint")
    int getTicksLeftToDoubleTapSprint();

    @Accessor("ticksLeftToDoubleTapSprint")
    void setTicksLeftToDoubleTapSprint(int value);

    @Accessor("field_3938")
    int getMountJumpStrengthCounter();

    @Accessor("field_3938")
    void setMountJumpStrengthCounter(int value);

    @Accessor("mountJumpStrength")
    void setMountJumpStrength(float value);

    @Accessor("nextNauseaStrength")
    float getNextNauseaStrength();

    @Accessor("nextNauseaStrength")
    void setNextNauseaStrength(float value);

    @Accessor("lastNauseaStrength")
    float getLastNauseaStrength();

    @Accessor("lastNauseaStrength")
    void setLastNauseaStrength(float value);

    @Accessor("usingItem")
    void setUsingItem(boolean value);

    @Accessor("riding")
    void setRiding(boolean value);

    @Accessor("autoJumpEnabled")
    void setAutoJumpEnabled(boolean value);

    @Accessor("ticksToNextAutojump")
    int getTicksToNextAutoJump();

    @Accessor("ticksToNextAutojump")
    void setTicksToNextAutoJump(int value);

    @Accessor("falling")
    boolean isFalling();

    @Accessor("falling")
    void setFalling(boolean value);

    @Accessor("underwaterVisibilityTicks")
    int getUnderwaterVisibilityTicks();

    @Accessor("underwaterVisibilityTicks")
    void setUnderwaterVisbilityTicks(int value);


    @Invoker("sendMovementPackets")
    void sendMovementPackets();

    @Invoker("startRidingJump")
    void startRidingJump();

    @Invoker("getPermissionLevel")
    int getPermissionLevel();

    @Invoker("wouldCollideAt")
    boolean wouldCollideAt(BlockPos pos);

    @Invoker("pushOutOfBlocks")
    void pushOutOfBlocks(double x, double z);

    @Invoker("isCamera")
    boolean isCamera();

    @Invoker("autoJump")
    void autoJump(float dx, float dz);

    @Invoker("shouldAutoJump")
    boolean shouldAutoJump();

    @Invoker("hasMovementInput")
    boolean hasMovementInput();

    @Invoker("isWalking")
    boolean isWalking();
}
