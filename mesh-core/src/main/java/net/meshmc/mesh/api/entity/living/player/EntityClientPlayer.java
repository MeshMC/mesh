package net.meshmc.mesh.api.entity.living.player;

import net.meshmc.mesh.api.client.input.MovementInput;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.math.Vec2f;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.api.network.ClientPlayNetworkConnection;
import net.meshmc.mesh.util.GameVersion;
import org.jetbrains.annotations.Nullable;

public interface EntityClientPlayer extends EntityAbstractClientPlayer {
    ClientPlayNetworkConnection<?> getNetworkConnection();

    // TODO: setStatHandler
    // TODO: setRecipeBook

    // TODO: Tickables

    double getLastX();
    double getLastY();
    double getLastZ();
    void setLastX(double value);
    void setLastY(double value);
    void setLastZ(double value);

    default Vec3d getLastPos() {
        return Vec3d.create(getLastX(), getLastY(), getLastZ());
    }
    default void setLastPos(Vec3d pos) {
        setLastX(pos.getX());
        setLastY(pos.getY());
        setLastZ(pos.getZ());
    }
    default void setLastPos(double x, double y, double z) {
        setLastX(x);
        setLastY(y);
        setLastZ(z);
    }

    float getLastYaw();
    float getLastPitch();
    void setLastYaw(float value);
    void setLastPitch(float value);

    default Vec2f getLastRotation() {
        return Vec2f.create(getLastYaw(), getLastPitch());
    }
    default void setLastRotation(Vec2f rotation) {
        setLastYaw(rotation.getX());
        setLastPitch(rotation.getY());
    }
    default void setLastRotation(float yaw, float pitch) {
        setLastYaw(yaw);
        setLastPitch(pitch);
    }

    boolean getLastOnGround();
    void setLastOnGround(boolean value);

    @Nullable
    @GameVersion.OnlyOn(value = GameVersion.v1_13, minimumVersion = true)
    Boolean isInSneakingPose();
    void setInSneakingPose(boolean value);

    boolean getLastSneaking();
    void setLastSneaking(boolean value);

    boolean getLastSprinting();
    void setLastSprinting(boolean value);

    int getTicksSinceLastPositionPacket();
    void setTicksSinceLastPositionPacket(int value);

    boolean getHealthInitialized();
    void setHealthInitialized(boolean value);

    MovementInput getMovementInput();
    void setMovementInput(MovementInput movementInput);

    int getTicksLeftToToggleSprint();
    void setTicksLeftToToggleSprint(int value);

    float getRenderYaw();
    void setRenderYaw(float value);

    float getRenderPitch();
    void setRenderPitch(float value);

    float getLastRenderYaw();
    void setLastRenderYaw(float value);

    float getLastRenderPitch();
    void setLastRenderPitch(float value);

    int getMountJumpStrengthCounter();
    void setMountJumpStrengthCounter(int value);

    void setMountJumpStrength(float value);

    float getTimeInPortal();
    void setTimeInPortal(float value);

    float getLastTimeInPortal();
    void setLastTimeInPortal(float value);

    void setUsingItem(boolean value);

    void setRiding(boolean value);

    void setAutoJumpEnabled(boolean value);

    int getTicksToNextAutoJump();
    void setTicksToNextAutoJump(int value);

    boolean isFalling();
    void setFalling(boolean value);

    @Nullable
    @GameVersion.OnlyOn(value = GameVersion.v1_13, minimumVersion = true)
    Integer getUnderwaterVisibilityTicks();
    void setUnderwaterVisibilityTicks(int value);

    // End of Fields

    @Nullable
    @GameVersion.OnlyOn(value = GameVersion.v1_16, minimumVersion = true)
    Float getMoodPercentage();

    void sendMovementPackets();

    void dropSelectedItem(boolean entireStack);

    void sendChatMessage(String message);

    void closeScreen();

    void updateHealth(float health);

    void startRidingJump();

    void openRidingInventory();

    @Nullable
    String getServerBrand();
    void setServerBrand(String brand);

    // TODO: getStatHandler & getRecipeBook

    // TODO: onRecipeDisplayed

    int getPermissionLevel();
    void setPermissionLevel(int value);

    // This doesn't actually exist as a method in 1.13+, but it's implemented in Mesh
    boolean isHeadspaceFree(BlockPos pos, int height);

    @Nullable
    @GameVersion.OnlyOn(value = {GameVersion.v1_13, GameVersion.v1_16_5}, minimumVersion = true, maximumVersion = true)
    Boolean cannotFitAt(BlockPos pos);
    // TODO: are cannotFitAt and wouldCollideAt the same?
    @Nullable
    @GameVersion.OnlyOn(value = GameVersion.v1_17, minimumVersion = true)
    Boolean wouldCollideAt(BlockPos pos);

    /** @param y Unused on 1.13+ */
    void pushOutOfBlock(double x, double y, double z);

    void setExperience(float progress, int total, int level);

    @Nullable
    @GameVersion.OnlyOn(value = GameVersion.v1_15, minimumVersion = true)
    Boolean showsDeathScreen();
    void setShowsDeathScreen(boolean value);

    boolean hasJumpingMount();

    float getMountJumpStrength();

    // TODO: Sneak & Slow Down related methods

    boolean isCamera();

    boolean isRiding();

    boolean isAutoJumpEnabled();

    void autoJump(float dx, float dz);

    boolean shouldAutoJump();

    boolean hasMovementInput();

    @Nullable
    @GameVersion.OnlyOn(value = GameVersion.v1_14, minimumVersion = true)
    Boolean isWalking();

    @Nullable
    @GameVersion.OnlyOn(value = GameVersion.v1_13, minimumVersion = true)
    Float getUnderwaterVisibility();
}
