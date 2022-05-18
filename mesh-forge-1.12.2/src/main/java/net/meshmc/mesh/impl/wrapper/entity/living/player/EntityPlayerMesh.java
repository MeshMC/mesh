package net.meshmc.mesh.impl.wrapper.entity.living.player;

import com.mojang.authlib.GameProfile;
import net.meshmc.mesh.api.block.BlockState;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.entity.living.player.EntityPlayer;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.impl.mixin.accessors.EntityPlayerAccessor;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.impl.wrapper.block.BlockStateMesh;
import net.meshmc.mesh.impl.wrapper.entity.EntityMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.EntityLivingMesh;
import net.meshmc.mesh.util.entity.ActionResult;
import net.meshmc.mesh.util.entity.Arm;
import net.meshmc.mesh.util.math.Hand;

/**
 * @author Tigermouthbear 1/16/22
 * @author Makrennel    - moved from wrapper to mixin+interface 2022/01/30
 */
public class EntityPlayerMesh<T extends net.minecraft.entity.player.EntityPlayer> extends EntityLivingMesh<T> implements EntityPlayer {
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
        return getMeshValue().xpCooldown;
    }

    @Override
    public void setXpCooldown(int value) {
        getMeshValue().xpCooldown = value;
    }

    @Override
    public double getChasingX() {
        return getMeshValue().chasingPosX;
    }

    @Override
    public double getChasingY() {
        return getMeshValue().chasingPosY;
    }

    @Override
    public double getChasingZ() {
        return getMeshValue().chasingPosZ;
    }

    @Override
    public void setChasingX(double value) {
        getMeshValue().chasingPosX = value;
    }

    @Override
    public void setChasingY(double value) {
        getMeshValue().chasingPosY = value;
    }

    @Override
    public void setChasingZ(double value) {
        getMeshValue().chasingPosZ = value;
    }

    @Override
    public double getPrevChasingX() {
        return getMeshValue().prevChasingPosX;
    }

    @Override
    public double getPrevChasingY() {
        return getMeshValue().prevChasingPosY;
    }

    @Override
    public double getPrevChasingZ() {
        return getMeshValue().prevChasingPosZ;
    }

    @Override
    public void setPrevChasingX(double value) {
        getMeshValue().prevChasingPosX = value;
    }

    @Override
    public void setPrevChasingY(double value) {
        getMeshValue().prevChasingPosY = value;
    }

    @Override
    public void setPrevChasingZ(double value) {
        getMeshValue().prevChasingPosZ = value;
    }

    @Override
    public int getSleepTimer() {
        return ((EntityPlayerAccessor) getMeshValue()).getSleepTimer();
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
        return getMeshValue().experienceTotal;
    }

    @Override
    public void setTotalExperience(int value) {
        getMeshValue().experienceTotal = value;
    }

    @Override
    public float getExperienceProgress() {
        return getMeshValue().experience;
    }

    @Override
    public void setExperienceProgress(float value) {
        getMeshValue().experience = value;
    }

    @Override
    public int getEnchantmentTableSeed() {
        return ((EntityPlayerAccessor) getMeshValue()).getXPSeed();
    }

    @Override
    public void setEnchantmentTableSeed(int value) {
        ((EntityPlayerAccessor) getMeshValue()).setXPSeed(value);
    }

    @Override
    public float getSpeedInAir() {
        return ((EntityPlayerAccessor) getMeshValue()).getSpeedInAir();
    }

    @Override
    public void setSpeedInAir(float value) {
        ((EntityPlayerAccessor) getMeshValue()).setSpeedInAir(value);
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
        return getMeshValue().hasReducedDebug();
    }

    @Override
    public void setReducedDebug(boolean value) {
        getMeshValue().setReducedDebug(value);
    }

    @Override
    public void updateCape() {
        ((EntityPlayerAccessor) getMeshValue()).updateCape();
    }

    @Override
    public void updateSize() {
        ((EntityPlayerAccessor) getMeshValue()).updateSize();
    }

    @Override
    public void closeScreen() {
        getMeshValue().closeScreen();
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
        return getMeshValue().getDigSpeed(((BlockStateMesh) state).getMeshValue(), (net.minecraft.util.math.BlockPos) blockPos);
    }

    @Override
    public boolean canHarvest(BlockState<?> state) {
        return getMeshValue().canHarvestBlock(((BlockStateMesh) state).getMeshValue());
    }

    @Override
    public ActionResult interact(Entity entity, Hand hand) {
        return MeshEnum.actionResult(getMeshValue().interactOn(((EntityMesh<?>) entity).getMeshValue(), MCEnum.hand(hand)));
    }

    @Override
    public void attack(Entity target) {
        getMeshValue().attackTargetEntityWithCurrentItem(((EntityMesh<?>) target).getMeshValue());
    }

    @Override
    public void disableShield(boolean sprinting) {
        getMeshValue().disableShield(sprinting);
    }

    @Override
    public void addCritParticles(Entity target) {
        getMeshValue().onCriticalHit(((EntityMesh<?>) target).getMeshValue());
    }

    @Override
    public void addEnchantedHitParticles(Entity target) {
        getMeshValue().onEnchantmentCritical(((EntityMesh<?>) target).getMeshValue());
    }

    @Override
    public void spawnSweepParticles() {
        getMeshValue().spawnSweepParticles();
    }

    @Override
    public void requestRespawn() {
        getMeshValue().respawnPlayer();
    }

    @Override
    public boolean isMainPlayer() {
        return getMeshValue().isUser();
    }

    @Override
    public void increaseTravelMotionStats(double dx, double dy, double dz) {
        getMeshValue().addMovementStat(dx, dy, dz);
    }

    @Override
    public void increaseRidingMotionStats(double dx, double dy, double dz) {
        ((EntityPlayerAccessor) getMeshValue()).addMountedMovementStat(dx, dy, dz);
    }

    @Override
    public void addExperience(int amount) {
        getMeshValue().addExperience(amount);
    }

    @Override
    public void addExperienceLevels(int levels) {
        getMeshValue().addExperienceLevel(levels);
    }

    @Override
    public int getNextLevelExperience() {
        return getMeshValue().xpBarCap();
    }

    @Override
    public void addExhaustion(float exhaustion) {
        getMeshValue().addExhaustion(exhaustion);
    }

    @Override
    public boolean canEat(boolean ignoreHunger) {
        return getMeshValue().canEat(ignoreHunger);
    }

    @Override
    public boolean canFoodHeal() {
        return getMeshValue().shouldHeal();
    }

    @Override
    public boolean canModifyBlocks() {
        return getMeshValue().isAllowEdit();
    }

    @Override
    public void sendAbilitiesUpdate() {
        getMeshValue().sendPlayerAbilities();
    }

    @Override
    public boolean isCreative() {
        return getMeshValue().isCreative();
    }

    @Override
    public boolean isSwimming() {
        return false;
    }

    @Override
    public boolean isPushedByWater() {
        return getMeshValue().isPushedByWater();
    }

    @Override
    public Arm getMainArm() {
        return MeshEnum.arm(getMeshValue().getPrimaryHand());
    }

    @Override
    public void setMainArm(Arm arm) {
        getMeshValue().setPrimaryHand(MCEnum.arm(arm));
    }

    @Override
    public float getAttackCooldownProgressPerTick() {
        return getMeshValue().getCooldownPeriod();
    }

    @Override
    public float getAttackCooldownProgress(float time) {
        return getMeshValue().getCooledAttackStrength(time);
    }

    @Override
    public void resetAttackCooldown() {
        getMeshValue().resetCooldown();
    }

    @Override
    public float getLuck() {
        return getMeshValue().getLuck();
    }

    @Override
    public boolean canUseCommandBlock() {
        return getMeshValue().canUseCommandBlock();
    }
}
