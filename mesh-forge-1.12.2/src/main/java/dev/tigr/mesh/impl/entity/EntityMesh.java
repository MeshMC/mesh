package dev.tigr.mesh.impl.entity;

import dev.tigr.mesh.api.AbstractMesh;
import dev.tigr.mesh.api.entity.Entity;
import dev.tigr.mesh.api.entity.EntityType;
import dev.tigr.mesh.api.entity.MoverType;
import dev.tigr.mesh.api.entity.living.player.EntityPlayer;
import dev.tigr.mesh.api.math.BlockPos;
import dev.tigr.mesh.api.math.Box;
import dev.tigr.mesh.api.math.Vec3d;
import dev.tigr.mesh.api.world.World;
import dev.tigr.mesh.impl.entity.living.EntityLivingMesh;
import dev.tigr.mesh.impl.entity.living.mob.EntityMobMesh;
import dev.tigr.mesh.impl.entity.living.mob.hostile.*;
import dev.tigr.mesh.impl.entity.living.mob.hostile.guardian.EntityGuardianElderMesh;
import dev.tigr.mesh.impl.entity.living.mob.hostile.guardian.EntityGuardianMesh;
import dev.tigr.mesh.impl.entity.living.mob.hostile.raider.*;
import dev.tigr.mesh.impl.entity.living.mob.hostile.skeleton.EntitySkeletonAbstractMesh;
import dev.tigr.mesh.impl.entity.living.mob.hostile.skeleton.EntitySkeletonMesh;
import dev.tigr.mesh.impl.entity.living.mob.hostile.skeleton.EntitySkeletonWitherMesh;
import dev.tigr.mesh.impl.entity.living.mob.hostile.skeleton.EntityStrayMesh;
import dev.tigr.mesh.impl.entity.living.mob.hostile.spider.EntitySpiderCaveMesh;
import dev.tigr.mesh.impl.entity.living.mob.hostile.spider.EntitySpiderMesh;
import dev.tigr.mesh.impl.entity.living.mob.hostile.zombie.EntityHuskMesh;
import dev.tigr.mesh.impl.entity.living.mob.hostile.zombie.EntityZombieMesh;
import dev.tigr.mesh.impl.entity.living.mob.hostile.zombie.EntityZombiePigmanMesh;
import dev.tigr.mesh.impl.entity.living.mob.hostile.zombie.EntityZombieVillagerMesh;
import dev.tigr.mesh.impl.entity.living.player.*;
import dev.tigr.mesh.impl.math.BlockPosMesh;
import dev.tigr.mesh.impl.math.BoxMesh;
import dev.tigr.mesh.impl.math.Vec3dMesh;
import dev.tigr.mesh.impl.mixin.accessors.entity.EntityAccessor;
import dev.tigr.mesh.impl.world.WorldMesh;
import dev.tigr.mesh.util.math.Facing;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Tigermouthbear 1/16/22
 * @author Makrennel - added hostile/player entities to static fromEntity list 2022/1/20
 * @param <T>
 */
public class EntityMesh<T extends net.minecraft.entity.Entity> extends AbstractMesh<T> implements Entity<T> {
    private final EntityType entityType;

    public EntityMesh(T value) {
        super(value);

        if(value instanceof net.minecraft.entity.player.EntityPlayer) entityType = EntityType.PLAYER;
        else if(value instanceof EntityDragon) entityType = EntityType.ENDER_DRAGON;
        else if(value instanceof EntityWither) entityType = EntityType.WITHER;
        else if(value instanceof EntityLightningBolt) entityType = EntityType.LIGHTNING_BOLT;
        else if(value instanceof EntityArmorStand) entityType = EntityType.ARMOR_STAND;
        else if(value instanceof EntityBoat) entityType = EntityType.BOAT;
        else if(value instanceof EntityEnderCrystal) entityType = EntityType.END_CRYSTAL;
        else if(value instanceof EntityEnderEye) entityType = EntityType.EYE_OF_ENDER;
        else if(value instanceof EntityEnderPearl) entityType = EntityType.ENDER_PEARL;
        else if(value instanceof EntityExpBottle) entityType = EntityType.EXPERIENCE_BOTTLE;
        else if(value instanceof EntityFallingBlock) entityType = EntityType.FALLING_BLOCK;
        else if(value instanceof EntityFireworkRocket) entityType = EntityType.FIREWORK_ROCKET;
        else if(value instanceof EntityItem) entityType = EntityType.ITEM;
        else if(value instanceof EntityItemFrame) entityType = EntityType.ITEM_FRAME;
        else if(value instanceof EntityMinecartEmpty) entityType = EntityType.MINECART;
        else if(value instanceof EntityMinecartChest) entityType = EntityType.CHEST_MINECART;
        else if(value instanceof EntityMinecartCommandBlock) entityType = EntityType.COMMAND_BLOCK_MINECART;
        else if(value instanceof EntityMinecartFurnace) entityType = EntityType.FURNACE_MINECART;
        else if(value instanceof EntityMinecartHopper) entityType = EntityType.HOPPER_MINECART;
        else if(value instanceof EntityMinecartMobSpawner) entityType = EntityType.SPAWNER_MINECART;
        else if(value instanceof EntityMinecartTNT) entityType = EntityType.TNT_MINECART;
        else if(value instanceof EntityPainting) entityType = EntityType.PAINTING;
        else if(value instanceof EntityTNTPrimed) entityType = EntityType.TNT;
        else if(value instanceof EntityXPOrb) entityType = EntityType.EXPERIENCE_ORB;
        else if(value instanceof EntityBlaze) entityType = EntityType.BLAZE;
        else if(value instanceof EntityCaveSpider) entityType = EntityType.CAVE_SPIDER;
        else if(value instanceof EntityCreeper) entityType = EntityType.CREEPER;
        else if(value instanceof EntityElderGuardian) entityType = EntityType.ELDER_GUARDIAN;
        else if(value instanceof EntityEnderman) entityType = EntityType.ENDERMAN;
        else if(value instanceof EntityEndermite) entityType = EntityType.ENDERMITE;
        else if(value instanceof EntityEvoker) entityType = EntityType.EVOKER;
        else if(value instanceof EntityGhast) entityType = EntityType.GHAST;
        else if(value instanceof EntityGiantZombie) entityType = EntityType.GIANT;
        else if(value instanceof EntityGuardian) entityType = EntityType.GUARDIAN;
        else if(value instanceof EntityHusk) entityType = EntityType.HUSK;
        else if(value instanceof EntityIllusionIllager) entityType = EntityType.ILLUSIONER;
        else if(value instanceof EntityIronGolem) entityType = EntityType.IRON_GOLEM;
        else if(value instanceof EntityMagmaCube) entityType = EntityType.MAGMA_CUBE;
        else if(value instanceof EntityPigZombie) entityType = EntityType.ZOMBIFIED_PIGLIN;
        else if(value instanceof EntityPolarBear) entityType = EntityType.POLAR_BEAR;
        else if(value instanceof EntityShulker) entityType = EntityType.SHULKER;
        else if(value instanceof EntitySilverfish) entityType = EntityType.SILVERFISH;
        else if(value instanceof EntitySkeleton) entityType = EntityType.SKELETON;
        else if(value instanceof EntitySlime) entityType = EntityType.SLIME;
        else if(value instanceof EntitySnowman) entityType = EntityType.SNOW_GOLEM;
        else if(value instanceof EntitySpider) entityType = EntityType.SPIDER;
        else if(value instanceof EntityStray) entityType = EntityType.STRAY;
        else if(value instanceof EntityVex) entityType = EntityType.VEX;
        else if(value instanceof EntityVindicator) entityType = EntityType.VINDICATOR;
        else if(value instanceof EntityWitch) entityType = EntityType.WITCH;
        else if(value instanceof EntityWitherSkeleton) entityType = EntityType.WITHER_SKELETON;
        else if(value instanceof EntityZombieVillager) entityType = EntityType.ZOMBIE_VILLAGER;
        else if(value instanceof EntityZombie) entityType = EntityType.ZOMBIE;
        else if(value instanceof EntityBat) entityType = EntityType.BAT;
        else if(value instanceof EntityChicken) entityType = EntityType.CHICKEN;
        else if(value instanceof EntityMooshroom) entityType = EntityType.MOOSHROOM;
        else if(value instanceof EntityCow) entityType = EntityType.COW;
        else if(value instanceof EntityDonkey) entityType = EntityType.DONKEY;
        else if(value instanceof EntityHorse) entityType = EntityType.HORSE;
        else if(value instanceof EntityLlama) entityType = EntityType.LLAMA;
        else if(value instanceof EntityMule) entityType = EntityType.MULE;
        else if(value instanceof EntityOcelot) entityType = EntityType.OCELOT;
        else if(value instanceof EntityParrot) entityType = EntityType.PARROT;
        else if(value instanceof EntityPig) entityType = EntityType.PIG;
        else if(value instanceof EntityRabbit) entityType = EntityType.RABBIT;
        else if(value instanceof EntitySheep) entityType = EntityType.SHEEP;
        else if(value instanceof EntitySkeletonHorse) entityType = EntityType.SKELETON_HORSE;
        else if(value instanceof EntitySquid) entityType = EntityType.SQUID;
        else if(value instanceof EntityWolf) entityType = EntityType.WOLF;
        else if(value instanceof EntityZombieHorse) entityType = EntityType.ZOMBIE_HORSE;
        else if(value instanceof EntityDragonFireball) entityType = EntityType.DRAGON_FIREBALL;
        else if(value instanceof EntityEgg) entityType = EntityType.EGG;
        else if(value instanceof EntityEvokerFangs) entityType = EntityType.EVOKER_FANGS;
        else if(value instanceof EntityWitherSkull) entityType = EntityType.WITHER_SKULL;
        else if(value instanceof EntityFireball) entityType = EntityType.FIREBALL;
        else if(value instanceof EntityFishHook) entityType = EntityType.FISHING_BOBBER;
        else if(value instanceof EntityLlamaSpit) entityType = EntityType.LLAMA_SPIT;
        else if(value instanceof EntityPotion) entityType = EntityType.POTION;
        else if(value instanceof EntityShulkerBullet) entityType = EntityType.SHULKER_BULLET;
        else if(value instanceof EntitySnowball) entityType = EntityType.SNOWBALL;
        else if(value instanceof EntitySpectralArrow) entityType = EntityType.SPECTRAL_ARROW;
        else if(value instanceof EntityArrow) entityType = EntityType.ARROW;
        else if(value instanceof EntityAreaEffectCloud) entityType = EntityType.AREA_EFFECT_CLOUD;
        else if(value instanceof EntityLeashKnot) entityType = EntityType.LEASH_KNOT;
        else entityType = null; // should not be null
    }

    // must add entity mesh constructor here when a new mesh is added
    public static Entity<?> fromEntity(net.minecraft.entity.Entity entity) {
        if(entity instanceof EntityLivingBase) {
            if(entity instanceof EntityCreature) {
                if(entity instanceof EntityMob) {
                    if(entity instanceof EntityGuardian) {
                        if(entity instanceof EntityElderGuardian) return new EntityGuardianElderMesh<>((EntityElderGuardian) entity);
                        return new EntityGuardianMesh<>((EntityGuardian) entity);
                    }
                    if(entity instanceof AbstractIllager) {
                        if(entity instanceof EntitySpellcasterIllager) {
                            if(entity instanceof EntityIllusionIllager) return new EntityIllusionerMesh<>((EntityIllusionIllager) entity);
                            if(entity instanceof EntityEvoker) return new EntityEvokerMesh<>((EntityEvoker) entity);
                            return new EntityIllagerSpellcasterMesh<>((EntitySpellcasterIllager) entity);
                        }
                        if(entity instanceof EntityVindicator) return new EntityVindicatorMesh<>((EntityVindicator) entity);
                        return new EntityRaiderAbstractMesh<>((AbstractIllager) entity);
                    }
                    if(entity instanceof AbstractSkeleton) {
                        if(entity instanceof EntitySkeleton) return new EntitySkeletonMesh<>((EntitySkeleton) entity);
                        if(entity instanceof EntityWitherSkeleton) return new EntitySkeletonWitherMesh<>((EntityWitherSkeleton) entity);
                        if(entity instanceof EntityStray) return new EntityStrayMesh<>((EntityStray) entity);
                        return new EntitySkeletonAbstractMesh<>((AbstractSkeleton) entity);
                    }
                    if(entity instanceof EntitySpider) {
                        if(entity instanceof EntityCaveSpider) return new EntitySpiderCaveMesh<>((EntityCaveSpider) entity);
                        return new EntitySpiderMesh<>((EntitySpider) entity);
                    }
                    if(entity instanceof EntityZombie) {
                        if(entity instanceof EntityHusk) return new EntityHuskMesh<>((EntityHusk) entity);
                        if(entity instanceof EntityPigZombie) return new EntityZombiePigmanMesh<>((EntityPigZombie) entity);
                        if(entity instanceof EntityZombieVillager) return new EntityZombieVillagerMesh<>((EntityZombieVillager) entity);
                        return new EntityZombieMesh<>((EntityZombie) entity);
                    }
                    if(entity instanceof EntityBlaze) return new EntityBlazeMesh<>((EntityBlaze) entity);
                    if(entity instanceof EntityCreeper) return new EntityCreeperMesh<>((EntityCreeper) entity);
                    if(entity instanceof EntityEnderman) return new EntityEndermanMesh<>((EntityEnderman) entity);
                    if(entity instanceof EntityEndermite) return new EntityEndermiteMesh<>((EntityEndermite) entity);
                    if(entity instanceof EntityGiantZombie) return new EntityGiantMesh<>((EntityGiantZombie) entity);
                    if(entity instanceof EntitySilverfish) return new EntitySilverfishMesh<>((EntitySilverfish) entity);
                    if(entity instanceof EntityVex) return new EntityVexMesh<>((EntityVex) entity);
                    if(entity instanceof EntityWitch) return new EntityWitchMesh<>((EntityWitch) entity);
                    if(entity instanceof EntityWither) return new EntityWitherMesh<>((EntityWither) entity);
                    return new EntityHostileMesh<>((EntityMob) entity);
                }
                if(entity instanceof EntityAgeable) {
                    // TODO: Passive Entities
                }
                return new EntityMobMesh<>((EntityCreature) entity);
            }
            if(entity instanceof net.minecraft.entity.player.EntityPlayer) {
                if(entity instanceof AbstractClientPlayer) {
                    if(entity instanceof EntityPlayerSP) return new EntityPlayerClientMesh<>((EntityPlayerSP) entity);
                    if(entity instanceof EntityOtherPlayerMP) return new EntityPlayerClientOtherMesh<>((EntityOtherPlayerMP) entity);
                    return new EntityPlayerClientAbstractMesh<>((AbstractClientPlayer) entity);
                }
                if(entity instanceof EntityPlayerMP) return new EntityPlayerServerMesh<>((EntityPlayerMP) entity);
                return new EntityPlayerMesh<>((net.minecraft.entity.player.EntityPlayer) entity);
            }

            return new EntityLivingMesh<>((EntityLivingBase) entity);
        }

        return new EntityMesh<>(entity);
    }

    @Override
    public EntityType getEntityType() {
        return entityType;
    }

    @Override
    public int getId() {
        return getMeshValue().getEntityId();
    }

    @Override
    public void setId(int value) {
        getMeshValue().setEntityId(value);
    }

    @Override
    public List<Entity<?>> getPassengers() {
        List<Entity<?>> list = new ArrayList<>();
        for(net.minecraft.entity.Entity entity: getMeshValue().getPassengers()) {
            list.add(fromEntity(entity));
        }
        return list;
    }

    @Override
    public int getRidingCooldown() {
        return ((EntityAccessor) getMeshValue()).getRidingCooldown();
    }

    @Override
    public void setRidingCooldown(int value) {
        ((EntityAccessor) getMeshValue()).setRidingCooldown(value);
    }

    @Override
    public Entity<?> getVehicle() {
        return fromEntity(getMeshValue().getRidingEntity());
    }

    @Override
    public void setVehicle(Entity<?> entity) {
        ((EntityAccessor) getMeshValue()).setVehicle((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public World<?> getWorld() {
        return WorldMesh.fromWorld(getMeshValue().world);
    }

    @Override
    public void setWorld(World<?> world) {
        getMeshValue().world = (net.minecraft.world.World) world.getMeshValue();
    }

    @Override
    public Vec3d<?> getPrevPosition() {
        return Vec3d.create(getPrevX(), getPrevY(), getPrevZ());
    }

    @Override
    public void setPrevPosition(Vec3d<?> position) {
        getMeshValue().prevPosX = position.getX();
        getMeshValue().prevPosY = position.getY();
        getMeshValue().prevPosZ = position.getZ();
    }

    @Override
    public double getPrevX() {
        return getMeshValue().prevPosX;
    }

    @Override
    public double getPrevY() {
        return getMeshValue().prevPosY;
    }

    @Override
    public double getPrevZ() {
        return getMeshValue().prevPosZ;
    }

    @Override
    public void setPrevX(double value) {
        getMeshValue().prevPosX = value;
    }

    @Override
    public void setPrevY(double value) {
        getMeshValue().prevPosY = value;
    }

    @Override
    public void setPrevZ(double value) {
        getMeshValue().prevPosZ = value;
    }

    @Override
    public Vec3d<?> getPosition() {
        return new Vec3dMesh(getMeshValue().getPositionVector());
    }

    @Override
    public void setPosition(double x, double y, double z) {
        getMeshValue().setPosition(x, y, z);
    }

    @Override
    public void setPosition(Vec3d<?> position) {
        getMeshValue().setPosition(position.getX(), position.getY(), position.getZ());
    }

    @Override
    public double getX() {
        return getMeshValue().posX;
    }

    @Override
    public double getY() {
        return getMeshValue().posY;
    }

    @Override
    public double getZ() {
        return getMeshValue().posZ;
    }

    @Override
    public void setX(double value) {
        getMeshValue().posX = value;
    }

    @Override
    public void setY(double value) {
        getMeshValue().posY = value;
    }

    @Override
    public void setZ(double value) {
        getMeshValue().posZ = value;
    }

    @Override
    public double getLastRenderX() {
        return getMeshValue().lastTickPosX;
    }

    @Override
    public double getLastRenderY() {
        return getMeshValue().lastTickPosY;
    }

    @Override
    public double getLastRenderZ() {
        return getMeshValue().lastTickPosZ;
    }

    @Override
    public void setLastRenderX(double value) {
        getMeshValue().lastTickPosX = value;
    }

    @Override
    public void setLastRenderY(double value) {
        getMeshValue().lastTickPosY = value;
    }

    @Override
    public void setLastRenderZ(double value) {
        getMeshValue().lastTickPosZ = value;
    }

    @Override
    public Vec3d<?> getVelocity() {
        return Vec3dMesh.create(getMeshValue().motionX, getMeshValue().motionY, getMeshValue().motionZ);
    }

    @Override
    public void setVelocity(double x, double y, double z) {
        getMeshValue().setVelocity(x, y, z);
    }

    @Override
    public void setVelocity(Vec3d<?> velocity) {
        getMeshValue().setVelocity(velocity.getX(), velocity.getY(), velocity.getZ());
    }

    @Override
    public double getXVelo() {
        return getMeshValue().motionX;
    }

    @Override
    public double getYVelo() {
        return getMeshValue().motionY;
    }

    @Override
    public double getZVelo() {
        return getMeshValue().motionZ;
    }

    @Override
    public void setXVelo(double value) {
        getMeshValue().motionX = value;
    }

    @Override
    public void setYVelo(double value) {
        getMeshValue().motionY = value;
    }

    @Override
    public void setZVelo(double value) {
        getMeshValue().motionZ = value;
    }

    @Override
    public float getYaw() {
        return getMeshValue().rotationYaw;
    }

    @Override
    public float getPitch() {
        return getMeshValue().rotationPitch;
    }

    @Override
    public void setYaw(float yaw) {
        getMeshValue().rotationYaw = yaw;
    }

    @Override
    public void setPitch(float pitch) {
        getMeshValue().rotationPitch = pitch;
    }

    @Override
    public float getPrevYaw() {
        return getMeshValue().prevRotationYaw;
    }

    @Override
    public float getPrevPitch() {
        return getMeshValue().prevRotationPitch;
    }

    @Override
    public void setPrevYaw(float yaw) {
        getMeshValue().prevRotationYaw = yaw;
    }

    @Override
    public void setPrevPitch(float pitch) {
        getMeshValue().prevRotationPitch = pitch;
    }

    @Override
    public Box<?> getBounds() {
        return new BoxMesh(getMeshValue().getEntityBoundingBox());
    }

    @Override
    public void setBounds(Box<?> box) {
        getMeshValue().setEntityBoundingBox((AxisAlignedBB) box.getMeshValue());
    }

    @Override
    public boolean isOnGround() {
        return getMeshValue().onGround;
    }

    @Override
    public void setOnGround(boolean value) {
        getMeshValue().onGround = value;
    }

    @Override
    public boolean isCollidedHorizontally() {
        return getMeshValue().collidedHorizontally;
    }

    @Override
    public void setCollidedHorizontally(boolean value) {
        getMeshValue().collidedHorizontally = value;
    }

    @Override
    public boolean isCollidedVertically() {
        return getMeshValue().collidedVertically;
    }

    @Override
    public void setCollidedVertically(boolean value) {
        getMeshValue().collidedVertically = value;
    }

    @Override
    public boolean isCollided() {
        return getMeshValue().collided;
    }

    @Override
    public void setCollided(boolean value) {
        getMeshValue().collided = value;
    }

    @Override
    public boolean isVelocityChanged() {
        return getMeshValue().velocityChanged;
    }

    @Override
    public void setVelocityChanged(boolean value) {
        getMeshValue().velocityChanged = value;
    }

    @Override
    public float getHorizontalSpeed() {
        return getMeshValue().distanceWalkedModified;
    }

    @Override
    public void setHorizontalSpeed(float value) {
        getMeshValue().distanceWalkedModified = value;
    }

    @Override
    public float getPrevHorizontalSpeed() {
        return getMeshValue().prevDistanceWalkedModified;
    }

    @Override
    public void setPrevHorizontalSpeed(float value) {
        getMeshValue().prevDistanceWalkedModified = value;
    }

    @Override
    public float getDistanceTraveled() {
        return getMeshValue().distanceWalkedOnStepModified;
    }

    @Override
    public void setDistanceTraveled(float value) {
        getMeshValue().distanceWalkedOnStepModified = value;
    }

    @Override
    public float getFallDistance() {
        return getMeshValue().fallDistance;
    }

    @Override
    public void setFallDistance(float value) {
        getMeshValue().fallDistance = value;
    }

    @Override
    public float getNextStepSoundDistance() {
        return ((EntityAccessor) getMeshValue()).getNextStepSoundDistance();
    }

    @Override
    public void setNextStepSoundDistance(float value) {
        ((EntityAccessor) getMeshValue()).setNextStepSoundDistance(value);
    }

    @Override
    public float getStepHeight() {
        return getMeshValue().stepHeight;
    }

    @Override
    public void setStepHeight(float value) {
        getMeshValue().stepHeight = value;
    }

    @Override
    public boolean isNoClip() {
        return getMeshValue().noClip;
    }

    @Override
    public void setNoClip(boolean value) {
        getMeshValue().noClip = value;
    }

    @Override
    public int getTicksExisted() {
        return getMeshValue().ticksExisted;
    }

    @Override
    public void setTicksExisted(int value) {
        getMeshValue().ticksExisted = value;
    }

    @Override
    public int getFireTicks() {
        return ((EntityAccessor) getMeshValue()).getFireTicks();
    }

    @Override
    public void setFireTicks(int value) {
        ((EntityAccessor) getMeshValue()).setFireTicks(value);
    }

    @Override
    public boolean isInWater() {
        return getMeshValue().isInWater();
    }

    @Override
    public void setInWater(boolean value) {
        ((EntityAccessor) getMeshValue()).setTouchingWater(value);
    }

    @Override
    public boolean isFirstUpdate() {
        return ((EntityAccessor) getMeshValue()).isFirstUpdate();
    }

    @Override
    public void setFirstUpdate(boolean value) {
        ((EntityAccessor) getMeshValue()).setFirstUpdate(value);
    }

    @Override
    public boolean isIgnoringCameraFrustum() {
        return getMeshValue().ignoreFrustumCheck;
    }

    @Override
    public void setIgnoreCameraFrustum(boolean value) {
        getMeshValue().ignoreFrustumCheck = value;
    }

    @Override
    public boolean isInPortal() {
        return ((EntityAccessor) getMeshValue()).isInNetherPortal();
    }

    @Override
    public void setInPortal(boolean value) {
        ((EntityAccessor) getMeshValue()).setInNetherPortal(value);
    }

    @Override
    public int getPortalCooldown() {
        return getMeshValue().timeUntilPortal;
    }

    @Override
    public void setPortalCooldown(int value) {
        getMeshValue().timeUntilPortal = value;
    }

    @Override
    public int getPortalTime() {
        return ((EntityAccessor) getMeshValue()).getNetherPortalTime();
    }

    @Override
    public void setPortalTime(int value) {
        ((EntityAccessor) getMeshValue()).setNetherPortalTime(value);
    }

    @Override
    public BlockPos<?> getLastPortalPosition() {
        return new BlockPosMesh(((EntityAccessor) getMeshValue()).getLastNetherPortalPosition());
    }

    @Override
    public void setLastPortalPosition(BlockPos<?> pos) {
        ((EntityAccessor) getMeshValue()).setLastNetherPortalVector(new net.minecraft.util.math.Vec3d(pos.getX(), pos.getY(), pos.getZ()));
        ((EntityAccessor) getMeshValue()).setLastNetherPortalPosition((net.minecraft.util.math.BlockPos) pos.getMeshValue());
    }

    @Override
    public boolean isInvulnerable() {
        return getMeshValue().getIsInvulnerable();
    }

    @Override
    public void setInvulnerable(boolean value) {
        getMeshValue().setEntityInvulnerable(value);
    }

    @Override
    public boolean isGlowing() {
        return getMeshValue().isGlowing();
    }

    @Override
    public void setGlowing(boolean value) {
        getMeshValue().setGlowing(value);
    }

    @Override
    public double[] getPistonMovementDelta() {
        return ((EntityAccessor) getMeshValue()).getPistonMovementDelta();
    }

    @Override
    public void setPistonMovementDelta(double[] value) {
        ((EntityAccessor) getMeshValue()).setPistonMovementDelta(value);
    }

    @Override
    public long getPistonDelta() {
        return ((EntityAccessor) getMeshValue()).getPistonMovementTick();
    }

    @Override
    public void setPistonDelta(long value) {
        ((EntityAccessor) getMeshValue()).setPistonMovementTick(value);
    }

    @Override
    public float getEyeHeight() {
        return getMeshValue().getEyeHeight();
    }

    @Override
    public boolean isSpectator() {
        return getMeshValue() instanceof net.minecraft.entity.player.EntityPlayer && ((net.minecraft.entity.player.EntityPlayer) getMeshValue()).isSpectator();
    }

    @Override
    public void kill() {
        getMeshValue().setDead();
    }

    @Override
    public Box<?> calculateBoundingBox() {
        double x = getMeshValue().posX;
        double y = getMeshValue().posY;
        double z = getMeshValue().posZ;
        float f = getMeshValue().width / 2.0F;
        float f1 = getMeshValue().height;
        return new BoxMesh(new AxisAlignedBB(x - (double)f, y, z - (double)f, x + (double)f, y + (double)f1, z + (double)f));
    }

    @Override
    public void tick() {
        getMeshValue().onUpdate();
    }

    @Override
    public void baseTick() {
        getMeshValue().onEntityUpdate();
    }

    @Override
    public int getMaxInPortalTime() {
        return getMeshValue().getMaxInPortalTime();
    }

    @Override
    public void setOnFireFromLava() {
        ((EntityAccessor) getMeshValue()).setOnFireFromLava();
    }

    @Override
    public void setOnFireFor(int value) {
        getMeshValue().setFire(value);
    }

    @Override
    public void tickInVoid() {
        ((EntityAccessor) getMeshValue()).outOfWorld();
    }

    @Override
    public void move(MoverType moverType, Vec3d<?> movement) {
        getMeshValue().move(net.minecraft.entity.MoverType.values()[moverType.ordinal()], movement.getX(), movement.getY(), movement.getZ());
    }

    @Override
    public void checkBlockCollision() {
        ((EntityAccessor) getMeshValue()).checkBlockCollision();
    }

    @Override
    public boolean isSilent() {
        return getMeshValue().isSilent();
    }

    @Override
    public void setSilent(boolean value) {
        getMeshValue().setSilent(value);
    }

    @Override
    public boolean hasNoGravity() {
        return getMeshValue().hasNoGravity();
    }

    @Override
    public void setNoGravity(boolean value) {
        getMeshValue().setNoGravity(value);
    }

    @Override
    public boolean isImmuneToFire() {
        return getMeshValue().isImmuneToFire();
    }

    @Override
    public boolean isBeingRainedOn() {
        net.minecraft.util.math.BlockPos.PooledMutableBlockPos block = net.minecraft.util.math.BlockPos.PooledMutableBlockPos.retain(getMeshValue().posX, getMeshValue().posY, getMeshValue().posZ);
        if(!getMeshValue().world.isRainingAt(block) && !getMeshValue().world.isRainingAt(block.setPos(getMeshValue().posX, getMeshValue().posY + (double)getMeshValue().height, getMeshValue().posZ))) {
            block.release();
            return false;
        }
        else {
            block.release();
            return true;
        }
    }

    @Override
    public boolean isInsideWaterOrBubbleColumn() {
        return false;
    }

    @Override
    public void updateSwimming() {
        // not in this version
    }

    @Override
    public void spawnSprintingParticles() {
        getMeshValue().spawnRunningParticles();
    }

    @Override
    public boolean isInLava() {
        return getMeshValue().isInLava();
    }

    @Override
    public void moveRelative(float speed, Vec3d<?> vec3d) {
        getMeshValue().moveRelative(speed, (float) vec3d.getX(), (float) vec3d.getY(), (float) vec3d.getZ());
    }

    @Override
    public float getBrightnessAtEyes() {
        return getMeshValue().getBrightnessForRender();
    }

    @Override
    public void updatePositionAndAngles(double x, double y, double z, float yaw, float pitch) {
        getMeshValue().setPositionAndRotation(x, y, z, yaw, pitch);
    }

    @Override
    public void onPlayerCollision(EntityPlayer<?> entityPlayer) {
        getMeshValue().onCollideWithPlayer((net.minecraft.entity.player.EntityPlayer) entityPlayer.getMeshValue());
    }

    @Override
    public void pushAwayFrom(Entity<?> entity) {
        getMeshValue().applyEntityCollision((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public Vec3d<?> getRotationVec() {
        return new Vec3dMesh(getMeshValue().getLookVec());
    }

    @Override
    public Vec3d<?> getOppositeRotationVec() {
        return new Vec3dMesh(((EntityAccessor) getMeshValue()).getVectorForRotation(getPitch() - 90F, getYaw()));
    }

    @Override
    public float getPitch(float delta) {
        return getMeshValue().rotationPitch;
    }

    @Override
    public float getYaw(float delta) {
        return getMeshValue().rotationYaw;
    }

    @Override
    public Vec3d<?> getCameraPosVec(float delta) {
        return new Vec3dMesh(getMeshValue().getPositionEyes(delta));
    }

    @Override
    public boolean canBeCollidedWith() {
        return getMeshValue().canBeCollidedWith();
    }

    @Override
    public boolean canBePushed() {
        return getMeshValue().canBePushed();
    }

    @Override
    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return getMeshValue().isInRangeToRender3d(cameraX, cameraY, cameraZ);
    }

    @Override
    public boolean shouldRender(double distance) {
        return getMeshValue().isInRangeToRenderDist(distance);
    }

    @Override
    public boolean shouldSetPositionOnLoad() {
        return ((EntityAccessor) getMeshValue()).shouldSetPositionOnLoad();
    }

    @Override
    public String getEntityString() {
        return ((EntityAccessor) getMeshValue()).getEntityString();
    }

    @Override
    public boolean isAlive() {
        return getMeshValue().isEntityAlive();
    }

    @Override
    public boolean isInsideWall() {
        return getMeshValue().isEntityInsideOpaqueBlock();
    }

    @Override
    public void tickRiding() {
        getMeshValue().updateRidden();
    }

    @Override
    public void updatePassengerPosition(Entity<?> entity) {
        getMeshValue().updatePassenger((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public void onPassengerLookAround(Entity<?> entity) {
        getMeshValue().applyOrientationToEntity((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public double getYOffset() {
        return getMeshValue().getYOffset();
    }

    @Override
    public double getMountedYOffset() {
        return getMeshValue().getMountedYOffset();
    }

    @Override
    public boolean startRiding(Entity<?> entity, boolean force) {
        return getMeshValue().startRiding((net.minecraft.entity.Entity) entity.getMeshValue(), force);
    }

    @Override
    public boolean canStartRiding(Entity<?> entity) {
        return ((EntityAccessor) getMeshValue()).canStartRiding((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public void removePassengers() {
        getMeshValue().removePassengers();
    }

    @Override
    public void dismountVehicle() {
        getMeshValue().dismountRidingEntity();
    }

    @Override
    public void addPassenger(Entity<?> entity) {
        ((EntityAccessor) getMeshValue()).addPassenger((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public void removePassenger(Entity<?> entity) {
        ((EntityAccessor) getMeshValue()).removePassenger((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public boolean canAddPassenger(Entity<?> entity) {
        return ((EntityAccessor) getMeshValue()).canAddPassenger((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public void updateTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate) {
        getMeshValue().setPositionAndRotationDirect(x, y, z, yaw, pitch, interpolationSteps, interpolate);
    }

    @Override
    public float getTargetingMargin() {
        return getMeshValue().getCollisionBorderSize();
    }

    @Override
    public void setInNetherPortal(BlockPos<?> blockPos) {
        getMeshValue().setPortal((net.minecraft.util.math.BlockPos) blockPos.getMeshValue());
    }

    @Override
    public int getDefaultNetherPortalCooldown() {
        return getMeshValue().getPortalCooldown();
    }

    @Override
    public void handleStatus(byte status) {
        getMeshValue().handleStatusUpdate(status);
    }

    @Override
    public void performHurtAnimation() {
        getMeshValue().performHurtAnimation();
    }

    @Override
    public boolean isOnFire() {
        return getMeshValue().isBurning();
    }

    @Override
    public boolean hasVehicle() {
        return getMeshValue().isRiding();
    }

    @Override
    public boolean hasPassengers() {
        return !getMeshValue().getPassengers().isEmpty();
    }

    @Override
    public boolean isSneaking() {
        return getMeshValue().isSneaking();
    }

    @Override
    public void setSneaking(boolean value) {
        getMeshValue().setSneaking(value);
    }

    @Override
    public boolean isInSneakingPose() {
        return getMeshValue().isSneaking();
    }

    @Override
    public boolean isSprinting() {
        return getMeshValue().isSprinting();
    }

    @Override
    public void setSprinting(boolean value) {
        getMeshValue().setSprinting(value);
    }

    @Override
    public boolean isInvisible() {
        return getMeshValue().isInvisible();
    }

    @Override
    public boolean isInvisibleTo(EntityPlayer<?> player) {
        return getMeshValue().isInvisibleToPlayer((net.minecraft.entity.player.EntityPlayer) player.getMeshValue());
    }

    @Override
    public void setInvisible(boolean value) {
        getMeshValue().setInvisible(value);
    }

    @Override
    public boolean getFlag(int index) {
        return ((EntityAccessor) getMeshValue()).getFlag(index);
    }

    @Override
    public void setFlag(int index, boolean value) {
        ((EntityAccessor) getMeshValue()).setFlag(index, value);
    }

    @Override
    public int getAir() {
        return getMeshValue().getAir();
    }

    @Override
    public void setAir(int air) {
        getMeshValue().setAir(air);
    }

    @Override
    public void pushOutOfBlocks(double x, double y, double z) {
        ((EntityAccessor) getMeshValue()).pushOutOfBlocks(x, y, z);
    }

    @Override
    public float getHeadYaw() {
        return getMeshValue().getRotationYawHead();
    }

    @Override
    public void setHeadYaw(float headYaw) {
        getMeshValue().setRotationYawHead(headYaw);
    }

    @Override
    public void setBodyYaw(float bodyYaw) {
        getMeshValue().setRenderYawOffset(bodyYaw);
    }

    @Override
    public boolean isAttackable() {
        return getMeshValue().canBeAttackedWithItem();
    }

    @Override
    public boolean handleAttack(Entity<?> attacker) {
        return getMeshValue().hitByEntity((net.minecraft.entity.Entity) attacker.getMeshValue());
    }

    @Override
    public void copyPositionAndRotation(Entity<?> entity) {
        getMeshValue().copyLocationAndAnglesFrom((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public void copyFrom(Entity<?> original) {
        ((EntityAccessor) getMeshValue()).copyDataFromOld((net.minecraft.entity.Entity) original.getMeshValue());
    }

    @Override
    public int getSafeFallDistance() {
        return getMeshValue().getMaxFallHeight();
    }

    @Override
    public boolean canAvoidTraps() {
        return getMeshValue().doesEntityNotTriggerPressurePlate();
    }

    @Override
    public boolean doesRenderOnFire() {
        return getMeshValue().canRenderOnFire();
    }

    @Override
    public boolean isPushedByFluids() {
        return getMeshValue().isPushedByWater();
    }

    @Override
    public boolean hasCustomNameTag() {
        return getMeshValue().hasCustomName();
    }

    @Override
    public boolean isCustomNameTagVisible() {
        return getMeshValue().getAlwaysRenderNameTag();
    }

    @Override
    public void setCustomNameTagVisible(boolean visible) {
        getMeshValue().setAlwaysRenderNameTag(visible);
    }

    @Override
    public void teleport(double destX, double destY, double destZ) {
        getMeshValue().setPositionAndUpdate(destX, destY, destZ);
    }

    @Override
    public boolean shouldRenderName() {
        return getMeshValue().getAlwaysRenderNameTagForRender();
    }

    @Override
    public Facing getHorizontalFacing() {
        return Facing.values()[getMeshValue().getHorizontalFacing().ordinal()];
    }

    @Override
    public Facing getMovementDirection() {
        return Facing.values()[getMeshValue().getAdjustedHorizontalFacing().ordinal()];
    }

    @Override
    public Box<?> getRenderBoundingBox() {
        return new BoxMesh(getMeshValue().getRenderBoundingBox());
    }

    @Override
    public boolean isImmuneToExplosion() {
        return getMeshValue().isImmuneToExplosions();
    }

    @Override
    public boolean entityDataRequiresOperator() {
        return getMeshValue().ignoreItemEntityData();
    }

    @Override
    public Entity<?> getControllingPassenger() {
        return fromEntity(getMeshValue().getControllingPassenger());
    }

    @Override
    public boolean isPassenger(Entity<?> entity) {
        return getMeshValue().isPassenger((net.minecraft.entity.Entity) entity.getMeshValue());
    }

    @Override
    public Entity<?> getRootVehicle() {
        return fromEntity(getMeshValue().getLowestRidingEntity());
    }

    @Override
    public int getBurningDuration() {
        return ((EntityAccessor) getMeshValue()).getBurningDuration();
    }

    @Override
    public float getWidth() {
        return getMeshValue().width;
    }

    @Override
    public float getHeight() {
        return getMeshValue().height;
    }

    @Override
    public BlockPos<?> getBlockPos() {
        return new BlockPosMesh(getMeshValue().getPosition());
    }

    public static class EntityIterator implements Iterator<Entity<?>> {
        private final Iterator<net.minecraft.entity.Entity> iterator;

        public EntityIterator(Iterator<net.minecraft.entity.Entity> iterator) {
            this.iterator = iterator;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Entity<?> next() {
            return fromEntity(iterator.next());
        }
    }

    public static class EntityIterable extends AbstractMesh<Iterable<net.minecraft.entity.Entity>> implements Iterable<Entity<?>> {
        public EntityIterable(Iterable<net.minecraft.entity.Entity> value) {
            super(value);
        }

        @Override
        public Iterator<Entity<?>> iterator() {
            return new EntityIterator(getMeshValue().iterator());
        }
    }
}
