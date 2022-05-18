package net.meshmc.mesh.impl.wrapper.entity.living.player;

import com.mojang.authlib.GameProfile;
import net.meshmc.mesh.api.block.BlockState;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.entity.living.player.EntityPlayer;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.impl.mixin.accessors.entity.EntityPlayerAccessor;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.impl.wrapper.block.BlockStateMesh;
import net.meshmc.mesh.impl.wrapper.entity.EntityMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.EntityLivingMesh;
import net.meshmc.mesh.util.entity.ActionResult;
import net.meshmc.mesh.util.entity.Arm;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.entity.player.PlayerEntity;

public class EntityPlayerMesh<T extends PlayerEntity> extends EntityLivingMesh<T> implements EntityPlayer {
    public EntityPlayerMesh(T value) {
        super(value);
    }

    @Override
    public int getFlyToggleTimer() {
        return ((EntityPlayerAccessor) getMeshValue()).getFlyToggleTimer();
    }

    @Override
    public void setFlyToggleTimer(int value) {
        ((EntityPlayerAccessor) getMeshValue()).setFlyToggleTimer(value);
    }

    @Override
    public int getXpCooldown() {
        return getMeshValue().experiencePickUpDelay;
    }

    @Override
    public void setXpCooldown(int value) {
        getMeshValue().experiencePickUpDelay = value;
    }

    @Override
    public double getChasingX() {
        return getMeshValue().capeX;
    }

    @Override
    public double getChasingY() {
        return getMeshValue().capeY;
    }

    @Override
    public double getChasingZ() {
        return getMeshValue().capeZ;
    }

    @Override
    public void setChasingX(double value) {
        getMeshValue().capeX = value;
    }

    @Override
    public void setChasingY(double value) {
        getMeshValue().capeY = value;
    }

    @Override
    public void setChasingZ(double value) {
        getMeshValue().capeZ = value;
    }

    @Override
    public double getPrevChasingX() {
        return getMeshValue().prevCapeX;
    }

    @Override
    public double getPrevChasingY() {
        return getMeshValue().prevCapeY;
    }

    @Override
    public double getPrevChasingZ() {
        return getMeshValue().prevCapeZ;
    }

    @Override
    public void setPrevChasingX(double value) {
        getMeshValue().prevCapeX = value;
    }

    @Override
    public void setPrevChasingY(double value) {
        getMeshValue().prevCapeY = value;
    }

    @Override
    public void setPrevChasingZ(double value) {
        getMeshValue().prevCapeZ = value;
    }

    @Override
    public int getSleepTimer() {
        return getMeshValue().getSleepTimer();
    }

    @Override
    public void setSleepTimer(int value) {
        ((EntityPlayerAccessor) getMeshValue()).setSleepTimer(value);
    }

    @Override
    public int getExperienceLevel() {
        return getMeshValue().experienceLevel;
    }

    @Override
    public void setExperienceLevel(int value) {
        getMeshValue().experienceLevel = value;
    }

    @Override
    public int getTotalExperience() {
        return getMeshValue().totalExperience;
    }

    @Override
    public void setTotalExperience(int value) {
        getMeshValue().totalExperience = value;
    }

    @Override
    public float getExperienceProgress() {
        return getMeshValue().experienceProgress;
    }

    @Override
    public void setExperienceProgress(float value) {
        getMeshValue().experienceProgress = value;
    }

    @Override
    public int getEnchantmentTableSeed() {
        return getMeshValue().getEnchantmentTableSeed();
    }

    @Override
    public void setEnchantmentTableSeed(int value) {
        ((EntityPlayerAccessor) getMeshValue()).setEnchantmentTableSeed(value);
    }

    @Override
    public float getSpeedInAir() {
        return getMeshValue().airStrafingSpeed;
    }

    @Override
    public void setSpeedInAir(float value) {
        getMeshValue().airStrafingSpeed = value;
    }

    @Override
    public int getLastXPSound() {
        return ((EntityPlayerAccessor) getMeshValue()).getLastXPSound();
    }

    @Override
    public void setLastXPSound(int value) {
        ((EntityPlayerAccessor) getMeshValue()).setLastXPSound(value);
    }

    @Override
    public GameProfile getGameProfile() {
        return getMeshValue().getGameProfile();
    }

    @Override
    public void setGameProfile(GameProfile gameProfile) {
        ((EntityPlayerAccessor) getMeshValue()).setGameProfile(gameProfile);
    }

    @Override
    public boolean hasReducedDebug() {
        return getMeshValue().hasReducedDebugInfo();
    }

    @Override
    public void setReducedDebug(boolean value) {
        getMeshValue().setReducedDebugInfo(value);
    }

    @Override
    public void updateCape() {
        ((EntityPlayerAccessor) getMeshValue()).updateCapeAngles();
    }

    @Override
    public void updateSize() {
        ((EntityPlayerAccessor) getMeshValue()).updatePose();
    }

    @Override
    public void closeScreen() {
        ((EntityPlayerAccessor) getMeshValue()).closeHandledScreen();
    }

    @Override
    public int getScore() {
        return getMeshValue().getScore();
    }

    @Override
    public void addScore(int value) {
        getMeshValue().addScore(value);
    }

    @Override
    public float getDigSpeed(BlockState<?> state, BlockPos blockPos) {
        return getMeshValue().getBlockBreakingSpeed((net.minecraft.block.BlockState) ((BlockStateMesh) state).getMeshValue());
    }

    @Override
    public boolean canHarvest(BlockState<?> state) {
        return getMeshValue().canHarvest((net.minecraft.block.BlockState) ((BlockStateMesh) state).getMeshValue());
    }

    @Override
    public ActionResult interact(Entity entity, Hand hand) {
        return MeshEnum.actionResult(getMeshValue().interact(((EntityMesh<?>) entity).getMeshValue(), MCEnum.hand(hand)));
    }

    @Override
    public void attack(Entity target) {
        getMeshValue().attack(((EntityMesh<?>) target).getMeshValue());
    }

    @Override
    public void disableShield(boolean sprinting) {
        getMeshValue().disableShield(sprinting);
    }

    @Override
    public void addCritParticles(Entity target) {
        getMeshValue().addCritParticles(((EntityMesh<?>) target).getMeshValue());
    }

    @Override
    public void addEnchantedHitParticles(Entity target) {
        getMeshValue().addEnchantedHitParticles(((EntityMesh<?>) target).getMeshValue());
    }

    @Override
    public void spawnSweepParticles() {
        getMeshValue().spawnSweepAttackParticles();
    }

    @Override
    public void requestRespawn() {
        getMeshValue().requestRespawn();
    }

    @Override
    public boolean isMainPlayer() {
        return getMeshValue().isMainPlayer();
    }

    @Override
    public void increaseTravelMotionStats(double dx, double dy, double dz) {
        getMeshValue().increaseTravelMotionStats(dx, dy, dz);
    }

    @Override
    public void increaseRidingMotionStats(double dx, double dy, double dz) {
        ((EntityPlayerAccessor) getMeshValue()).increaseRidingMotionStats(dx, dy, dz);
    }

    @Override
    public void addExperience(int amount) {
        getMeshValue().addExperience(amount);
    }

    @Override
    public void addExperienceLevels(int levels) {
        getMeshValue().addExperienceLevels(levels);
    }

    @Override
    public int getNextLevelExperience() {
        return getMeshValue().getNextLevelExperience();
    }

    @Override
    public void addExhaustion(float exhaustion) {
        getMeshValue().addExhaustion(exhaustion);
    }

    @Override
    public boolean canEat(boolean ignoreHunger) {
        return getMeshValue().canConsume(ignoreHunger);
    }

    @Override
    public boolean canFoodHeal() {
        return getMeshValue().canFoodHeal();
    }

    @Override
    public boolean canModifyBlocks() {
        return getMeshValue().canModifyBlocks();
    }

    @Override
    public void sendAbilitiesUpdate() {
        getMeshValue().sendAbilitiesUpdate();
    }

    @Override
    public boolean isCreative() {
        return getMeshValue().isCreative();
    }

    @Override
    public boolean isSwimming() {
        return getMeshValue().isSwimming();
    }

    @Override
    public boolean isPushedByWater() {
        return getMeshValue().isPushedByFluids();
    }

    @Override
    public Arm getMainArm() {
        return MeshEnum.arm(getMeshValue().getMainArm());
    }

    @Override
    public void setMainArm(Arm arm) {
        getMeshValue().setMainArm(MCEnum.arm(arm));
    }

    @Override
    public float getAttackCooldownProgressPerTick() {
        return getMeshValue().getAttackCooldownProgressPerTick();
    }

    @Override
    public float getAttackCooldownProgress(float time) {
        return getMeshValue().getAttackCooldownProgress(time);
    }

    @Override
    public void resetAttackCooldown() {
        getMeshValue().resetLastAttackedTicks();
    }

    @Override
    public float getLuck() {
        return getMeshValue().getLuck();
    }

    @Override
    public boolean canUseCommandBlock() {
        return getMeshValue().isCreativeLevelTwoOp();
    }
}
