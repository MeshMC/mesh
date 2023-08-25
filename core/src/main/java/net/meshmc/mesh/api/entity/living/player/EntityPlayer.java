package net.meshmc.mesh.api.entity.living.player;

import com.mojang.authlib.GameProfile;
import net.meshmc.mesh.api.block.BlockState;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.entity.living.EntityLiving;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.util.entity.ActionResult;
import net.meshmc.mesh.util.entity.Arm;
import net.meshmc.mesh.util.math.Hand;

/**
 * @author Tigermouthbear 1/16/22
 * @author Makrennel    - moved from wrapper to mixin+interface 2022/01/30
 */
public interface EntityPlayer extends EntityLiving {
    // TODO: INVENTORY AND HUNGER, CONSTRUCTOR

    int getFlyToggleTimer();
    void setFlyToggleTimer(int value);

    /*TODO: NOT IN FABRIC
    float getPrevCameraYaw();
    float getCameraYaw();
    void setPrevCameraYaw(float value);
    void setCameraYaw(float value);
     */

    int getXpCooldown();
    void setXpCooldown(int value);

    // cape(X,Y,Z)
    double getChasingX();
    double getChasingY();
    double getChasingZ();
    void setChasingX(double value);
    void setChasingY(double value);
    void setChasingZ(double value);

    double getPrevChasingX();
    double getPrevChasingY();
    double getPrevChasingZ();
    void setPrevChasingX(double value);
    void setPrevChasingY(double value);
    void setPrevChasingZ(double value);

    // TODO: is sleeping?

    int getSleepTimer();
    void setSleepTimer(int value);

    // TODO: submerged in water

    // TODO: ABILITIES

    int getExperienceLevel();
    void setExperienceLevel(int value);

    int getTotalExperience();
    void setTotalExperience(int value);

    float getExperienceProgress();
    void setExperienceProgress(float value);

    int getEnchantmentTableSeed();
    void setEnchantmentTableSeed(int value);

    // field_7509
    float getSpeedInAir();
    void setSpeedInAir(float value);

    int getLastXPSound();
    void setLastXPSound(int value);

    GameProfile getGameProfile();
    void setGameProfile(GameProfile gameProfile);

    boolean hasReducedDebug();
    void setReducedDebug(boolean value);

    // TODO: ITEMSTACK, ITEM COOLDOWN, AND FISH HOOK

    void updateCape();

    void updateSize(); // updatePose

    // TODO: playSound, getSoundCategory

    void closeHandledScreen();

    int getScore();

    void addScore(int value);

    // TODO: riptide

    // TODO: dropItem

    float getDigSpeed(BlockState<?> state, BlockPos blockPos);

    boolean canHarvest(BlockState<?> state);

    // TODO: open Sign, CommandBlock, ...

    ActionResult interact(Entity entity, Hand hand);

    void attack(Entity target);

    void disableShield(boolean sprinting);

    void addCritParticles(Entity target);

    void addEnchantedHitParticles(Entity target);

    void spawnSweepParticles();

    void requestRespawn(); // respawnPlayer

    boolean isMainPlayer();

    // TODO: SLEEP

    // TODO: Text, sendStatusMessage

    // TODO: STATS, RECIPES

    void increaseTravelMotionStats(double dx, double dy, double dz); // addMovementStat

    void increaseRidingMotionStats(double dx, double dy, double dz); // addMountedMovementStat

    void addExperience(int amount);

    // onEnchant

    void addExperienceLevels(int levels);

    int getNextLevelExperience(); // xpBarCap

    void addExhaustion(float exhaustion);

    // TODO: foodStats

    boolean canEat(boolean ignoreHunger);

    boolean canFoodHeal();

    boolean canModifyBlocks(); // isAllowEdit

    // TODO: boolean canPlaceOn(BlockPos pos, Facing facing, )

    void sendAbilitiesUpdate();

    // TODO: equipStack

    // shoulderEntities

    boolean isCreative();

    boolean isSwimming(); // 1.12 and lower defaults to false

    boolean isPushedByWater();

    // TODO: isWearing (ModelParts)

    Arm getMainArm();
    void setMainArm(Arm arm);

    // shoulderEntity...

    float getAttackCooldownProgressPerTick();

    float getAttackCooldownProgress(float time);

    void resetAttackCooldown();

    // cooldown tracker?

    float getLuck();

    boolean canUseCommandBlock();
}
