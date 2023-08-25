package net.meshmc.mesh.impl.wrapper.entity.living.player;

import net.meshmc.mesh.api.client.input.MovementInput;
import net.meshmc.mesh.api.entity.living.player.EntityClientPlayer;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.network.ClientPlayNetworkConnection;
import net.meshmc.mesh.impl.mixin.accessors.entity.player.EntityClientPlayerAccessor;
import net.meshmc.mesh.impl.wrapper.network.ClientPlayNetworkConnectionMesh;
import net.minecraft.block.BlockState;
import net.minecraft.client.input.Input;
import net.minecraft.client.network.ClientPlayerEntity;
import org.jetbrains.annotations.Nullable;

public class EntityClientPlayerMesh<T extends ClientPlayerEntity> extends EntityAbstractClientPlayerMesh<T> implements EntityClientPlayer {
    public EntityClientPlayerMesh(T value) {
        super(value);
    }

    @Override
    public ClientPlayNetworkConnection<?> getNetworkConnection() {
        return new ClientPlayNetworkConnectionMesh(getMeshValue().networkHandler);
    }

    @Override
    public double getLastX() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getLastX();
    }

    @Override
    public double getLastY() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getLastY();
    }

    @Override
    public double getLastZ() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getLastZ();
    }

    @Override
    public void setLastX(double value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setLastX(value);
    }

    @Override
    public void setLastY(double value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setLastY(value);
    }

    @Override
    public void setLastZ(double value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setLastZ(value);
    }

    @Override
    public float getLastYaw() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getLastYaw();
    }

    @Override
    public float getLastPitch() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getLastPitch();
    }

    @Override
    public void setLastYaw(float value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setLastYaw(value);
    }

    @Override
    public void setLastPitch(float value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setLastPitch(value);
    }

    @Override
    public boolean getLastOnGround() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getLastOnGround();
    }

    @Override
    public void setLastOnGround(boolean value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setLastOnGround(value);
    }

    @Nullable
    @Override
    public Boolean isInSneakingPose() {
        return ((EntityClientPlayerAccessor) getMeshValue()).isInSneakingPose();
    }

    @Override
    public void setInSneakingPose(boolean value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setInSneakingPose(value);
    }

    @Override
    public boolean getLastSneaking() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getLastSneaking();
    }

    @Override
    public void setLastSneaking(boolean value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setLastSneaking(value);
    }

    @Override
    public boolean getLastSprinting() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getLastSprinting();
    }

    @Override
    public void setLastSprinting(boolean value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setLastSprinting(value);
    }

    @Override
    public int getTicksSinceLastPositionPacket() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getTicksSinceLastPositionPacketSent();
    }

    @Override
    public void setTicksSinceLastPositionPacket(int value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setTicksSinceLastPositionPacketSent(value);
    }

    @Override
    public boolean getHealthInitialized() {
        return ((EntityClientPlayerAccessor) getMeshValue()).isHealthInitialized();
    }

    @Override
    public void setHealthInitialized(boolean value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setHealthInitialized(value);
    }

    @Override
    public MovementInput getMovementInput() {
        return (MovementInput) getMeshValue().input;
    }

    @Override
    public void setMovementInput(MovementInput movementInput) {
        getMeshValue().input = (Input) movementInput;
    }

    @Override
    public int getTicksLeftToToggleSprint() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getTicksLeftToDoubleTapSprint();
    }

    @Override
    public void setTicksLeftToToggleSprint(int value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setTicksLeftToDoubleTapSprint(value);
    }

    @Override
    public float getRenderYaw() {
        return getMeshValue().renderYaw;
    }

    @Override
    public void setRenderYaw(float value) {
        getMeshValue().renderYaw = value;
    }

    @Override
    public float getRenderPitch() {
        return getMeshValue().renderPitch;
    }

    @Override
    public void setRenderPitch(float value) {
        getMeshValue().renderPitch = value;
    }

    @Override
    public float getLastRenderYaw() {
        return getMeshValue().lastRenderYaw;
    }

    @Override
    public void setLastRenderYaw(float value) {
        getMeshValue().lastRenderYaw = value;
    }

    @Override
    public float getLastRenderPitch() {
        return getMeshValue().lastRenderPitch;
    }

    @Override
    public void setLastRenderPitch(float value) {
        getMeshValue().lastRenderPitch = value;
    }

    @Override
    public int getMountJumpStrengthCounter() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getMountJumpStrengthCounter();
    }

    @Override
    public void setMountJumpStrengthCounter(int value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setMountJumpStrengthCounter(value);
    }

    @Override
    public void setMountJumpStrength(float value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setMountJumpStrength(value);
    }

    @Override
    public float getTimeInPortal() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getNextNauseaStrength();
    }

    @Override
    public void setTimeInPortal(float value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setNextNauseaStrength(value);
    }

    @Override
    public float getLastTimeInPortal() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getLastNauseaStrength();
    }

    @Override
    public void setLastTimeInPortal(float value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setLastNauseaStrength(value);
    }

    @Override
    public void setUsingItem(boolean value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setUsingItem(value);
    }

    @Override
    public void setRiding(boolean value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setRiding(value);
    }

    @Override
    public void setAutoJumpEnabled(boolean value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setAutoJumpEnabled(value);
    }

    @Override
    public int getTicksToNextAutoJump() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getTicksToNextAutoJump();
    }

    @Override
    public void setTicksToNextAutoJump(int value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setTicksToNextAutoJump(value);
    }

    @Override
    public boolean isFalling() {
        return ((EntityClientPlayerAccessor) getMeshValue()).isFalling();
    }

    @Override
    public void setFalling(boolean value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setFalling(value);
    }

    @Nullable
    @Override
    public Integer getUnderwaterVisibilityTicks() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getUnderwaterVisibilityTicks();
    }

    @Override
    public void setUnderwaterVisibilityTicks(int value) {
        ((EntityClientPlayerAccessor) getMeshValue()).setUnderwaterVisbilityTicks(value);
    }

    @Nullable
    @Override
    public Float getMoodPercentage() {
        return getMeshValue().getMoodPercentage();
    }

    @Override
    public void sendMovementPackets() {
        ((EntityClientPlayerAccessor) getMeshValue()).sendMovementPackets();
    }

    @Override
    public void dropSelectedItem(boolean entireStack) {
        getMeshValue().dropSelectedItem(entireStack);
    }

    @Override
    public void sendChatMessage(String message) {
        getMeshValue().sendChatMessage(message);
    }

    @Override
    public void closeScreen() {
        getMeshValue().closeScreen();
    }

    @Override
    public void updateHealth(float health) {
        getMeshValue().updateHealth(health);
    }

    @Override
    public void startRidingJump() {
        ((EntityClientPlayerAccessor) getMeshValue()).startRidingJump();
    }

    @Override
    public void openRidingInventory() {
        getMeshValue().openRidingInventory();
    }

    @Nullable
    @Override
    public String getServerBrand() {
        return getMeshValue().getServerBrand();
    }

    @Override
    public void setServerBrand(String brand) {
        getMeshValue().setServerBrand(brand);
    }

    @Override
    public int getPermissionLevel() {
        return ((EntityClientPlayerAccessor) getMeshValue()).getPermissionLevel();
    }

    @Override
    public void setPermissionLevel(int value) {
        getMeshValue().setClientPermissionLevel(value);
    }

    @Override
    public boolean isHeadspaceFree(BlockPos pos, int height) {
        for(int y = 0; y < height; y++) if(!isOpenBlockSpace(pos.add(0, y, 0))) return false;
        return true;
    }

    private boolean isOpenBlockSpace(BlockPos pos) {
        BlockState blockState = getMeshValue().world.getBlockState((net.minecraft.util.math.BlockPos) pos);
        return !(blockState.isOpaque() && blockState.isFullCube(getMeshValue().world,
                (net.minecraft.util.math.BlockPos) pos) && !blockState.emitsRedstonePower());
    }

    @Nullable
    @Override
    public Boolean cannotFitAt(BlockPos pos) {
        return null;
    }

    @Nullable
    @Override
    public Boolean wouldCollideAt(BlockPos pos) {
        return ((EntityClientPlayerAccessor) getMeshValue()).wouldCollideAt((net.minecraft.util.math.BlockPos) pos);
    }

    @Override
    public void pushOutOfBlock(double x, double y, double z) {
        ((EntityClientPlayerAccessor) getMeshValue()).pushOutOfBlocks(x, z);
    }

    @Override
    public void setExperience(float progress, int total, int level) {
        getMeshValue().setExperience(progress, total, level);
    }

    @Nullable
    @Override
    public Boolean showsDeathScreen() {
        return getMeshValue().showsDeathScreen();
    }

    @Override
    public void setShowsDeathScreen(boolean value) {
        getMeshValue().setShowsDeathScreen(value);
    }

    @Override
    public boolean hasJumpingMount() {
        return getMeshValue().hasJumpingMount();
    }

    @Override
    public float getMountJumpStrength() {
        return getMeshValue().getMountJumpStrength();
    }

    @Override
    public boolean isCamera() {
        return ((EntityClientPlayerAccessor) getMeshValue()).isCamera();
    }

    @Override
    public boolean isRiding() {
        return getMeshValue().isRiding();
    }

    @Override
    public boolean isAutoJumpEnabled() {
        return getMeshValue().isAutoJumpEnabled();
    }

    @Override
    public void autoJump(float dx, float dz) {
        ((EntityClientPlayerAccessor) getMeshValue()).autoJump(dx, dz);
    }

    @Override
    public boolean shouldAutoJump() {
        return ((EntityClientPlayerAccessor) getMeshValue()).shouldAutoJump();
    }

    @Override
    public boolean hasMovementInput() {
        return ((EntityClientPlayerAccessor) getMeshValue()).hasMovementInput();
    }

    @Nullable
    @Override
    public Boolean isWalking() {
        return ((EntityClientPlayerAccessor) getMeshValue()).isWalking();
    }

    @Nullable
    @Override
    public Float getUnderwaterVisibility() {
        return getMeshValue().getUnderwaterVisibility();
    }
}
