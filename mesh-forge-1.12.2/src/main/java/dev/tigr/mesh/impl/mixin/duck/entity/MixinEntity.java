package dev.tigr.mesh.impl.mixin.duck.entity;

import dev.tigr.mesh.api.entity.EntityType;
import dev.tigr.mesh.api.entity.MoverType;
import dev.tigr.mesh.impl.mixininterface.entity.Entity;
import dev.tigr.mesh.impl.mixininterface.entity.living.player.EntityPlayer;
import dev.tigr.mesh.impl.mixininterface.math.BlockPos;
import dev.tigr.mesh.impl.mixininterface.math.Box;
import dev.tigr.mesh.impl.mixininterface.math.Vec3d;
import dev.tigr.mesh.impl.mixininterface.world.World;
import dev.tigr.mesh.util.math.Facing;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@Mixin(net.minecraft.entity.Entity.class)
public abstract class MixinEntity implements Entity {
    @Shadow private int entityId;
    @Shadow public abstract List<net.minecraft.entity.Entity> getPassengers();
    @Shadow protected int rideCooldown;
    @Shadow private net.minecraft.entity.Entity ridingEntity;
    @Shadow public net.minecraft.world.World world;
    @Shadow public double prevPosX;
    @Shadow public double prevPosY;
    @Shadow public double prevPosZ;
    @Shadow public abstract net.minecraft.util.math.Vec3d getPositionVector();
    @Shadow public double posX;
    @Shadow public double posY;
    @Shadow public double posZ;
    @Shadow public double lastTickPosX;
    @Shadow public double lastTickPosY;
    @Shadow public double lastTickPosZ;
    @Shadow public double motionX;
    @Shadow public double motionY;
    @Shadow public double motionZ;
    @Shadow public float rotationYaw;
    @Shadow public float rotationPitch;
    @Shadow public float prevRotationYaw;
    @Shadow public float prevRotationPitch;
    @Shadow private AxisAlignedBB boundingBox;
    @Shadow public boolean onGround;
    @Shadow public boolean collidedHorizontally;
    @Shadow public boolean collidedVertically;
    @Shadow public boolean collided;
    @Shadow public boolean velocityChanged;
    @Shadow public float distanceWalkedModified;
    @Shadow public float prevDistanceWalkedModified;
    @Shadow public float distanceWalkedOnStepModified;
    @Shadow public float fallDistance;
    @Shadow private float nextFlap;
    @Shadow public float stepHeight;
    @Shadow public boolean noClip;
    @Shadow public int ticksExisted;
    @Shadow private int fire;
    @Shadow protected boolean inWater;
    @Shadow protected boolean firstUpdate;
    @Shadow public boolean ignoreFrustumCheck;
    @Shadow protected boolean inPortal;
    @Shadow public int timeUntilPortal;
    @Shadow protected int portalCounter;
    @Shadow protected net.minecraft.util.math.BlockPos lastPortalPos;
    @Shadow private boolean invulnerable;
    @Shadow protected boolean glowing;
    @Mutable @Shadow @Final private double[] pistonDeltas;
    @Shadow private long pistonDeltasGameTime;
    @Shadow public abstract void onKillCommand();
    @Shadow public abstract void setDead();
    @Shadow public float width;
    @Shadow public float height;
    @Shadow public abstract void onUpdate();
    @Shadow public abstract void onEntityUpdate();
    @Shadow public abstract void setFire(int seconds);
    @Shadow protected abstract void outOfWorld();
    @Shadow public abstract void move(net.minecraft.entity.MoverType type, double x, double y, double z);
    @Shadow protected abstract void doBlockCollisions();
    @Shadow public abstract void spawnRunningParticles();
    @Shadow public abstract int getBrightnessForRender();
    @Shadow public abstract void setPositionAndRotation(double x, double y, double z, float yaw, float pitch);
    @Shadow public abstract void onCollideWithPlayer(net.minecraft.entity.player.EntityPlayer entityIn);
    @Shadow public abstract void applyEntityCollision(net.minecraft.entity.Entity entityIn);
    @Shadow public abstract net.minecraft.util.math.Vec3d getLookVec();
    @Shadow protected abstract net.minecraft.util.math.Vec3d getVectorForRotation(float pitch, float yaw);
    @Shadow public abstract net.minecraft.util.math.Vec3d getPositionEyes(float partialTicks);
    @Shadow public abstract boolean isInRangeToRender3d(double x, double y, double z);
    @Shadow public abstract boolean isInRangeToRenderDist(double distance);
    @Shadow protected abstract boolean shouldSetPosAfterLoading();
    @Shadow public abstract boolean isEntityAlive();
    @Shadow public abstract boolean isEntityInsideOpaqueBlock();
    @Shadow public abstract void updateRidden();
    @Shadow public abstract void updatePassenger(net.minecraft.entity.Entity passenger);
    @Shadow public abstract void applyOrientationToEntity(net.minecraft.entity.Entity entityToUpdate);
    @Shadow protected abstract boolean canBeRidden(net.minecraft.entity.Entity entityIn);
    @Shadow public abstract void dismountRidingEntity();
    @Shadow protected abstract boolean canFitPassenger(net.minecraft.entity.Entity passenger);
    @Shadow public abstract void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport);
    @Shadow public abstract float getCollisionBorderSize();
    @Shadow public abstract void setPortal(net.minecraft.util.math.BlockPos pos);
    @Shadow public abstract void handleStatusUpdate(byte id);
    @Shadow public abstract boolean isBurning();
    @Shadow public abstract boolean isRiding();
    @Shadow public abstract boolean isInvisibleToPlayer(net.minecraft.entity.player.EntityPlayer player);
    @Shadow public abstract float getRotationYawHead();
    @Shadow public abstract void setRotationYawHead(float rotation);
    @Shadow public abstract void setRenderYawOffset(float offset);
    @Shadow public abstract boolean canBeAttackedWithItem();
    @Shadow public abstract boolean hitByEntity(net.minecraft.entity.Entity entityIn);
    @Shadow public abstract void copyLocationAndAnglesFrom(net.minecraft.entity.Entity entityIn);
    @Shadow protected abstract void copyDataFromOld(net.minecraft.entity.Entity entityIn);
    @Shadow public abstract int getMaxFallHeight();
    @Shadow public abstract boolean doesEntityNotTriggerPressurePlate();
    @Shadow public abstract boolean canRenderOnFire();
    @Shadow public abstract boolean isPushedByWater();
    @Shadow public abstract boolean hasCustomName();
    @Shadow public abstract boolean getAlwaysRenderNameTag();
    @Shadow public abstract void setAlwaysRenderNameTag(boolean alwaysRenderNameTag);
    @Shadow public abstract void setPositionAndUpdate(double x, double y, double z);
    @Shadow public abstract boolean getAlwaysRenderNameTagForRender();
    @Shadow public abstract EnumFacing getHorizontalFacing();
    @Shadow public abstract EnumFacing getAdjustedHorizontalFacing();
    @Shadow public abstract AxisAlignedBB getRenderBoundingBox();
    @Shadow public abstract boolean ignoreItemEntityData();
    @Shadow @Nullable public abstract net.minecraft.entity.Entity getControllingPassenger();
    @Shadow public abstract boolean isPassenger(net.minecraft.entity.Entity entityIn);
    @Shadow public abstract net.minecraft.entity.Entity getLowestRidingEntity();
    @Shadow protected abstract int getFireImmuneTicks();
    @Shadow public abstract net.minecraft.util.math.BlockPos getPosition();
    @Shadow public abstract boolean startRiding(net.minecraft.entity.Entity entityIn, boolean force);
    @Shadow protected abstract void addPassenger(net.minecraft.entity.Entity passenger);
    @Shadow protected abstract void removePassenger(net.minecraft.entity.Entity passenger);
    @Shadow protected abstract boolean pushOutOfBlocks(double x, double y, double z);
    @Shadow public abstract boolean isImmuneToExplosions();
    @Shadow public abstract void moveRelative(float strafe, float up, float forward, float friction);
    @Shadow public abstract void removePassengers();

    @Override
    public EntityType getEntityType() {
        net.minecraft.entity.Entity entity = Minecraft.getMinecraft().world.getEntityByID(entityId);
        if(entity instanceof net.minecraft.entity.player.EntityPlayer) return EntityType.PLAYER;
        else if(entity instanceof EntityDragon) return EntityType.ENDER_DRAGON;
        else if(entity instanceof EntityWither) return EntityType.WITHER;
        else if(entity instanceof EntityLightningBolt) return EntityType.LIGHTNING_BOLT;
        else if(entity instanceof EntityArmorStand) return EntityType.ARMOR_STAND;
        else if(entity instanceof EntityBoat) return EntityType.BOAT;
        else if(entity instanceof EntityEnderCrystal) return EntityType.END_CRYSTAL;
        else if(entity instanceof EntityEnderEye) return EntityType.EYE_OF_ENDER;
        else if(entity instanceof EntityEnderPearl) return EntityType.ENDER_PEARL;
        else if(entity instanceof EntityExpBottle) return EntityType.EXPERIENCE_BOTTLE;
        else if(entity instanceof EntityFallingBlock) return EntityType.FALLING_BLOCK;
        else if(entity instanceof EntityFireworkRocket) return EntityType.FIREWORK_ROCKET;
        else if(entity instanceof EntityItem) return EntityType.ITEM;
        else if(entity instanceof EntityItemFrame) return EntityType.ITEM_FRAME;
        else if(entity instanceof EntityMinecartEmpty) return EntityType.MINECART;
        else if(entity instanceof EntityMinecartChest) return EntityType.CHEST_MINECART;
        else if(entity instanceof EntityMinecartCommandBlock) return EntityType.COMMAND_BLOCK_MINECART;
        else if(entity instanceof EntityMinecartFurnace) return EntityType.FURNACE_MINECART;
        else if(entity instanceof EntityMinecartHopper) return EntityType.HOPPER_MINECART;
        else if(entity instanceof EntityMinecartMobSpawner) return EntityType.SPAWNER_MINECART;
        else if(entity instanceof EntityMinecartTNT) return EntityType.TNT_MINECART;
        else if(entity instanceof EntityPainting) return EntityType.PAINTING;
        else if(entity instanceof EntityTNTPrimed) return EntityType.TNT;
        else if(entity instanceof EntityXPOrb) return EntityType.EXPERIENCE_ORB;
        else if(entity instanceof EntityBlaze) return EntityType.BLAZE;
        else if(entity instanceof EntityCaveSpider) return EntityType.CAVE_SPIDER;
        else if(entity instanceof EntityCreeper) return EntityType.CREEPER;
        else if(entity instanceof EntityElderGuardian) return EntityType.ELDER_GUARDIAN;
        else if(entity instanceof EntityEnderman) return EntityType.ENDERMAN;
        else if(entity instanceof EntityEndermite) return EntityType.ENDERMITE;
        else if(entity instanceof EntityEvoker) return EntityType.EVOKER;
        else if(entity instanceof EntityGhast) return EntityType.GHAST;
        else if(entity instanceof EntityGiantZombie) return EntityType.GIANT;
        else if(entity instanceof EntityGuardian) return EntityType.GUARDIAN;
        else if(entity instanceof EntityHusk) return EntityType.HUSK;
        else if(entity instanceof EntityIllusionIllager) return EntityType.ILLUSIONER;
        else if(entity instanceof EntityIronGolem) return EntityType.IRON_GOLEM;
        else if(entity instanceof EntityMagmaCube) return EntityType.MAGMA_CUBE;
        else if(entity instanceof EntityPigZombie) return EntityType.ZOMBIFIED_PIGLIN;
        else if(entity instanceof EntityPolarBear) return EntityType.POLAR_BEAR;
        else if(entity instanceof EntityShulker) return EntityType.SHULKER;
        else if(entity instanceof EntitySilverfish) return EntityType.SILVERFISH;
        else if(entity instanceof EntitySkeleton) return EntityType.SKELETON;
        else if(entity instanceof EntitySlime) return EntityType.SLIME;
        else if(entity instanceof EntitySnowman) return EntityType.SNOW_GOLEM;
        else if(entity instanceof EntitySpider) return EntityType.SPIDER;
        else if(entity instanceof EntityStray) return EntityType.STRAY;
        else if(entity instanceof EntityVex) return EntityType.VEX;
        else if(entity instanceof EntityVindicator) return EntityType.VINDICATOR;
        else if(entity instanceof EntityWitch) return EntityType.WITCH;
        else if(entity instanceof EntityWitherSkeleton) return EntityType.WITHER_SKELETON;
        else if(entity instanceof EntityZombieVillager) return EntityType.ZOMBIE_VILLAGER;
        else if(entity instanceof EntityZombie) return EntityType.ZOMBIE;
        else if(entity instanceof EntityBat) return EntityType.BAT;
        else if(entity instanceof EntityChicken) return EntityType.CHICKEN;
        else if(entity instanceof EntityMooshroom) return EntityType.MOOSHROOM;
        else if(entity instanceof EntityCow) return EntityType.COW;
        else if(entity instanceof EntityDonkey) return EntityType.DONKEY;
        else if(entity instanceof EntityHorse) return EntityType.HORSE;
        else if(entity instanceof EntityLlama) return EntityType.LLAMA;
        else if(entity instanceof EntityMule) return EntityType.MULE;
        else if(entity instanceof EntityOcelot) return EntityType.OCELOT;
        else if(entity instanceof EntityParrot) return EntityType.PARROT;
        else if(entity instanceof EntityPig) return EntityType.PIG;
        else if(entity instanceof EntityRabbit) return EntityType.RABBIT;
        else if(entity instanceof EntitySheep) return EntityType.SHEEP;
        else if(entity instanceof EntitySkeletonHorse) return EntityType.SKELETON_HORSE;
        else if(entity instanceof EntitySquid) return EntityType.SQUID;
        else if(entity instanceof EntityWolf) return EntityType.WOLF;
        else if(entity instanceof EntityZombieHorse) return EntityType.ZOMBIE_HORSE;
        else if(entity instanceof EntityDragonFireball) return EntityType.DRAGON_FIREBALL;
        else if(entity instanceof EntityEgg) return EntityType.EGG;
        else if(entity instanceof EntityEvokerFangs) return EntityType.EVOKER_FANGS;
        else if(entity instanceof EntityWitherSkull) return EntityType.WITHER_SKULL;
        else if(entity instanceof EntityFireball) return EntityType.FIREBALL;
        else if(entity instanceof EntityFishHook) return EntityType.FISHING_BOBBER;
        else if(entity instanceof EntityLlamaSpit) return EntityType.LLAMA_SPIT;
        else if(entity instanceof EntityPotion) return EntityType.POTION;
        else if(entity instanceof EntityShulkerBullet) return EntityType.SHULKER_BULLET;
        else if(entity instanceof EntitySnowball) return EntityType.SNOWBALL;
        else if(entity instanceof EntitySpectralArrow) return EntityType.SPECTRAL_ARROW;
        else if(entity instanceof EntityArrow) return EntityType.ARROW;
        else if(entity instanceof EntityAreaEffectCloud) return EntityType.AREA_EFFECT_CLOUD;
        else if(entity instanceof EntityLeashKnot) return EntityType.LEASH_KNOT;
        else return null; // should not be null
    }

    @Override
    public int getId() {
        return entityId;
    }

    @Override
    public void setId(int value) {
        entityId = value;
    }

    @Override
    public List<Entity> getRiders() {
        List<Entity> list = new ArrayList<>();
        for(net.minecraft.entity.Entity entity: getPassengers()) list.add((Entity) entity);
        return list;
    }

    @Override
    public int getRidingCooldown() {
        return rideCooldown;
    }

    @Override
    public void setRidingCooldown(int value) {
        rideCooldown = value;
    }

    @Override
    public Entity getVehicle() {
        return (Entity) ridingEntity;
    }

    @Override
    public void setVehicle(Entity entity) {
        ridingEntity = (net.minecraft.entity.Entity) entity;
    }

    @Override
    public World getWorld() {
        return (World) world;
    }

    @Override
    public void setWorld(World world) {
        this.world = (net.minecraft.world.World) world;
    }

    @Override
    public Vec3d getPrevPosition() {
        return Vec3d.create(prevPosX, prevPosY, prevPosZ);
    }

    @Override
    public void setPrevPosition(Vec3d position) {
        prevPosX = position.getX();
        prevPosY = position.getY();
        prevPosZ = position.getZ();
    }

    @Override
    public double getPrevX() {
        return prevPosX;
    }

    @Override
    public double getPrevY() {
        return prevPosY;
    }

    @Override
    public double getPrevZ() {
        return prevPosZ;
    }

    @Override
    public void setPrevX(double value) {
        prevPosX = value;
    }

    @Override
    public void setPrevY(double value) {
        prevPosY = value;
    }

    @Override
    public void setPrevZ(double value) {
        prevPosZ = value;
    }

    @Override
    public Vec3d getPos() {
        return (Vec3d) getPositionVector();
    }

    @Override @Shadow public abstract void setPosition(double x, double y, double z);

    @Override
    public void setPosition(Vec3d position) {
        setPosition(position.getX(), position.getY(), position.getZ());
    }

    @Override
    public double getX() {
        return posX;
    }

    @Override
    public double getY() {
        return posY;
    }

    @Override
    public double getZ() {
        return posZ;
    }

    @Override
    public void setX(double value) {
        posX = value;
    }

    @Override
    public void setY(double value) {
        posY = value;
    }

    @Override
    public void setZ(double value) {
        posZ = value;
    }

    @Override
    public double getLastRenderX() {
        return lastTickPosX;
    }

    @Override
    public double getLastRenderY() {
        return lastTickPosY;
    }

    @Override
    public double getLastRenderZ() {
        return lastTickPosZ;
    }

    @Override
    public void setLastRenderX(double value) {
        lastTickPosX = value;
    }

    @Override
    public void setLastRenderY(double value) {
        lastTickPosY = value;
    }

    @Override
    public void setLastRenderZ(double value) {
        lastTickPosZ = value;
    }

    @Override
    public Vec3d getVelocity() {
        return Vec3d.create(motionX, motionY, motionZ);
    }

    @Override
    public void setVelocity(double x, double y, double z) {
        motionX = x;
        motionY = y;
        motionZ = z;
    }

    @Override
    public void setVelocity(Vec3d velocity) {
        motionX = velocity.getX();
        motionY = velocity.getY();
        motionZ = velocity.getZ();
    }

    @Override
    public double getXVelocity() {
        return motionX;
    }

    @Override
    public double getYVelocity() {
        return motionY;
    }

    @Override
    public double getZVelocity() {
        return motionZ;
    }

    @Override
    public void setXVelocity(double value) {
        motionX = value;
    }

    @Override
    public void setYVelocity(double value) {
        motionY = value;
    }

    @Override
    public void setZVelocity(double value) {
        motionZ = value;
    }

    @Override
    public float getYaw() {
        return rotationYaw;
    }

    @Override
    public float getPitch() {
        return rotationPitch;
    }

    @Override
    public void setYaw(float value) {
        rotationYaw = value;
    }

    @Override
    public void setPitch(float value) {
        rotationPitch = value;
    }

    @Override
    public float getPrevYaw() {
        return prevRotationYaw;
    }

    @Override
    public float getPrevPitch() {
        return prevRotationPitch;
    }

    @Override
    public void setPrevYaw(float value) {
        prevRotationYaw = value;
    }

    @Override
    public void setPrevPitch(float value) {
        prevRotationPitch = value;
    }

    @Override
    public Box getBounds() {
        return (Box) boundingBox;
    }

    @Override
    public void setBounds(Box box) {
        boundingBox = (AxisAlignedBB) box;
    }

    @Override
    public boolean isOnGround() {
        return onGround;
    }

    @Override
    public void setOnGround(boolean value) {
        onGround = value;
    }

    @Override
    public boolean isCollidedHorizontally() {
        return collidedHorizontally;
    }

    @Override
    public void setCollidedHorizontally(boolean value) {
        collidedHorizontally = value;
    }

    @Override
    public boolean isCollidedVertically() {
        return collidedVertically;
    }

    @Override
    public void setCollidedVertically(boolean value) {
        collidedVertically = value;
    }

    @Override
    public boolean isCollided() {
        return collided;
    }

    @Override
    public void setCollided(boolean value) {
        collided = value;
    }

    @Override
    public boolean isVelocityChanged() {
        return velocityChanged;
    }

    @Override
    public void setVelocityChanged(boolean value) {
        velocityChanged = value;
    }

    @Override
    public float getHorizontalSpeed() {
        return distanceWalkedModified;
    }

    @Override
    public void setHorizontalSpeed(float value) {
        distanceWalkedModified = value;
    }

    @Override
    public float getPrevHorizontalSpeed() {
        return prevDistanceWalkedModified;
    }

    @Override
    public void setPrevHorizontalSpeed(float value) {
        prevDistanceWalkedModified = value;
    }

    @Override
    public float getDistanceTraveled() {
        return distanceWalkedOnStepModified;
    }

    @Override
    public void setDistanceTraveled(float value) {
        distanceWalkedOnStepModified = value;
    }

    @Override
    public float getFallDistance() {
        return fallDistance;
    }

    @Override
    public void setFallDistance(float value) {
        fallDistance = value;
    }

    @Override
    public float getNextStepSoundDistance() {
        return nextFlap;
    }

    @Override
    public void setNextStepSoundDistance(float value) {
        nextFlap = value;
    }

    @Override
    public float getStepHeight() {
        return stepHeight;
    }

    @Override
    public void setStepHeight(float value) {
        stepHeight = value;
    }

    @Override
    public boolean isNoClip() {
        return noClip;
    }

    @Override
    public void setNoClip(boolean value) {
        noClip = value;
    }

    @Override
    public int getTicksExisted() {
        return ticksExisted;
    }

    @Override
    public void setTicksExisted(int value) {
        ticksExisted = value;
    }

    @Override
    public int getFireTicks() {
        return fire;
    }

    @Override
    public void setFireTicks(int value) {
        fire = value;
    }

    @Override
    public boolean isInWater() {
        return inWater;
    }

    @Override
    public void setInWater(boolean value) {
        inWater = value;
    }

    @Override
    public boolean isFirstUpdate() {
        return firstUpdate;
    }

    @Override
    public void setFirstUpdate(boolean value) {
        firstUpdate = value;
    }

    @Override
    public boolean isIgnoringCameraFrustum() {
        return ignoreFrustumCheck;
    }

    @Override
    public void setIgnoreCameraFrustum(boolean value) {
        ignoreFrustumCheck = value;
    }

    @Override
    public boolean isInPortal() {
        return inPortal;
    }

    @Override
    public void setInPortal(boolean value) {
        inPortal = value;
    }

    @Override
    public int getPortalCooldown() {
        return timeUntilPortal;
    }

    @Override
    public void setPortalCooldown(int value) {
        timeUntilPortal = value;
    }

    @Override
    public int getPortalTime() {
        return portalCounter;
    }

    @Override
    public void setPortalTime(int value) {
        portalCounter = value;
    }

    @Override
    public BlockPos getLastPortalPosition() {
        return (BlockPos) lastPortalPos;
    }

    @Override
    public void setLastPortalPosition(BlockPos pos) {
        lastPortalPos = (net.minecraft.util.math.BlockPos) pos;
    }

    @Override
    public boolean isInvulnerable() {
        return invulnerable;
    }

    @Override
    public void setInvulnerable(boolean value) {
        invulnerable = value;
    }

    @Override
    public boolean isGlowing() {
        return glowing;
    }

    @Override
    public void setGlowing(boolean value) {
        glowing = value;
    }

    @Override
    public double[] getPistonMovementDelta() {
        return pistonDeltas;
    }

    @Override
    public void setPistonMovementDelta(double[] value) {
        pistonDeltas = value;
    }

    @Override
    public long getPistonDelta() {
        return pistonDeltasGameTime;
    }

    @Override
    public void setPistonDelta(long value) {
        pistonDeltasGameTime = value;
    }

    @Override @Shadow public abstract float getEyeHeight();

    @Override
    public boolean isSpectator() {
        net.minecraft.entity.Entity entity = Minecraft.getMinecraft().world.getEntityByID(entityId);
        return entity instanceof net.minecraft.entity.player.EntityPlayer
                && ((net.minecraft.entity.player.EntityPlayer) entity).isSpectator();
    }

    @Override
    public void kill() {
        onKillCommand();
    }

    @Override
    public void discard() {
        setDead();
    }

    @Override
    public Box calculateBoundingBox() {
        double x = posX;
        double y = posY;
        double z = posZ;
        float f = width / 2.0F;
        float f1 = height;
        return (Box) new AxisAlignedBB(x - (double)f, y, z - (double)f, x + (double)f, y + (double)f1, z + (double)f);
    }

    @Override
    public void tick() {
        onUpdate();
    }

    @Override
    public void baseTick() {
        onEntityUpdate();
    }

    @Override @Shadow public abstract int getMaxInPortalTime();
    @Override @Shadow public abstract void setOnFireFromLava();

    @Override
    public void setOnFireFor(int value) {
        setFire(value);
    }

    @Override
    public void tickInVoid() {
        outOfWorld();
    }

    @Override
    public void move(MoverType moverType, Vec3d movement) {
        move(net.minecraft.entity.MoverType.values()[moverType.ordinal()], movement.getX(), movement.getY(), movement.getZ());
    }

    @Override
    public void checkBlockCollision() {
        doBlockCollisions();
    }

    @Override @Shadow public abstract boolean isSilent();
    @Override @Shadow public abstract void setSilent(boolean value);
    @Override @Shadow public abstract boolean hasNoGravity();
    @Override @Shadow public abstract void setNoGravity(boolean value);
    @Override @Shadow public abstract boolean isImmuneToFire();

    @Override
    public boolean isBeingRainedOn() {
        net.minecraft.util.math.BlockPos.PooledMutableBlockPos block = net.minecraft.util.math.BlockPos.PooledMutableBlockPos.retain(posX, posY, posZ);
        if(!world.isRainingAt(block) && !world.isRainingAt(block.setPos(posX, posY + (double)height, posZ))) {
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
        return inWater;
    }

    @Override
    public void updateSwimming() {
        // not in this version
    }

    @Override
    public void spawnSprintingParticles() {
        spawnRunningParticles();
    }

    @Override @Shadow public abstract boolean isInLava();

    @Override
    public void moveRelative(float speed, Vec3d vec3d) {
        moveRelative(speed, (float) vec3d.getX(), (float) vec3d.getY(), (float) vec3d.getZ());
    }

    @Override
    public float getBrightnessAtEyes() {
        return getBrightnessForRender();
    }

    @Override
    public void updatePositionAndAngles(double x, double y, double z, float yaw, float pitch) {
        setPositionAndRotation(x, y, z, yaw, pitch);
    }

    @Override
    public void onPlayerCollision(EntityPlayer entityPlayer) {
        onCollideWithPlayer((net.minecraft.entity.player.EntityPlayer) entityPlayer);
    }

    @Override
    public void pushAwayFrom(Entity entity) {
        applyEntityCollision((net.minecraft.entity.Entity) entity);
    }

    @Override
    public Vec3d getRotationVec() {
        return (Vec3d) getLookVec();
    }

    @Override
    public Vec3d getOppositeRotationVec() {
        return (Vec3d) getVectorForRotation(rotationPitch - 90F, rotationYaw);
    }

    @Override
    public float getPitch(float delta) {
        return rotationPitch;
    }

    @Override
    public float getYaw(float delta) {
        return rotationYaw;
    }

    @Override
    public Vec3d getCameraPosVec(float delta) {
        return (Vec3d) getPositionEyes(delta);
    }

    @Override @Shadow public abstract boolean canBeCollidedWith();
    @Override @Shadow public abstract boolean canBePushed();

    @Override
    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return isInRangeToRender3d(cameraX, cameraY, cameraZ);
    }

    @Override
    public boolean shouldRender(double distance) {
        return isInRangeToRenderDist(distance);
    }

    @Override
    public boolean shouldSetPositionOnLoad() {
        return shouldSetPosAfterLoading();
    }

    @Override @Shadow public abstract String getEntityString();

    @Override
    public boolean isAlive() {
        return isEntityAlive();
    }

    @Override
    public boolean isInsideWall() {
        return isEntityInsideOpaqueBlock();
    }

    @Override
    public void tickRiding() {
        updateRidden();
    }

    @Override
    public void updateRiderPosition(Entity entity) {
        updatePassenger((net.minecraft.entity.Entity) entity);
    }

    @Override
    public void onRiderLookAround(Entity entity) {
        applyOrientationToEntity((net.minecraft.entity.Entity) entity);
    }

    @Override @Shadow public abstract double getYOffset();
    @Override @Shadow public abstract double getMountedYOffset();

    @Override
    public boolean startRidingEntity(Entity entity, boolean force) {
        return startRiding((net.minecraft.entity.Entity) entity, force);
    }

    @Override
    public boolean canStartRiding(Entity entity) {
        return canBeRidden((net.minecraft.entity.Entity) entity);
    }

    @Override
    public void removeRiders() {
        removePassengers();
    }

    @Override
    public void dismountVehicle() {
        dismountRidingEntity();
    }

    @Override
    public void addRider(Entity entity) {
        addPassenger((net.minecraft.entity.Entity) entity);
    }

    @Override
    public void removeRider(Entity entity) {
        removePassenger((net.minecraft.entity.Entity) entity);
    }

    @Override
    public boolean canAddRider(Entity entity) {
        return canFitPassenger((net.minecraft.entity.Entity) entity);
    }

    @Override
    public void updateTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate) {
        setPositionAndRotationDirect(x, y, z, yaw, pitch, interpolationSteps, interpolate);
    }

    @Override
    public float getTargetingMargin() {
        return getCollisionBorderSize();
    }

    @Override
    public void setInNetherPortal(BlockPos blockPos) {
        setPortal((net.minecraft.util.math.BlockPos) blockPos);
    }

    @Override
    public int getDefaultNetherPortalCooldown() {
        return getPortalCooldown();
    }

    @Override
    public void handleStatus(byte status) {
        handleStatusUpdate(status);
    }

    @Override @Shadow public abstract void performHurtAnimation();

    @Override
    public boolean isOnFire() {
        return isBurning();
    }

    @Override
    public boolean hasVehicle() {
        return isRiding();
    }

    @Override
    public boolean hasRiders() {
        return !getPassengers().isEmpty();
    }

    @Override @Shadow public abstract boolean isSneaking();
    @Override @Shadow public abstract void setSneaking(boolean value);

    @Override
    public boolean isInSneakingPose() {
        return isSneaking();
    }

    @Override @Shadow public abstract boolean isSprinting();
    @Override @Shadow public abstract void setSprinting(boolean value);
    @Override @Shadow public abstract boolean isInvisible();

    @Override
    public boolean isInvisibleTo(EntityPlayer player) {
        return isInvisibleToPlayer((net.minecraft.entity.player.EntityPlayer) player);
    }

    @Override @Shadow public abstract void setInvisible(boolean value);
    @Override @Shadow public abstract boolean getFlag(int index);
    @Override @Shadow public abstract void setFlag(int index, boolean value);
    @Override @Shadow public abstract int getAir();
    @Override @Shadow public abstract void setAir(int air);

    @Override
    public void pushOutOfSolidBlock(double x, double y, double z) {
        pushOutOfBlocks(x, y, z);
    }

    @Override
    public float getHeadYaw() {
        return getRotationYawHead();
    }

    @Override
    public void setHeadYaw(float headYaw) {
        setRotationYawHead(headYaw);
    }

    @Override
    public void setBodyYaw(float bodyYaw) {
        setRenderYawOffset(bodyYaw);
    }

    @Override
    public boolean isAttackable() {
        return canBeAttackedWithItem();
    }

    @Override
    public boolean handleAttack(Entity attacker) {
        return hitByEntity((net.minecraft.entity.Entity) attacker);
    }

    @Override
    public void copyPositionAndRotation(Entity entity) {
        copyLocationAndAnglesFrom((net.minecraft.entity.Entity) entity);
    }

    @Override
    public void copyFrom(Entity original) {
        copyDataFromOld((net.minecraft.entity.Entity) original);
    }

    @Override
    public int getSafeFallDistance() {
        return getMaxFallHeight();
    }

    @Override
    public boolean canAvoidTraps() {
        return doesEntityNotTriggerPressurePlate();
    }

    @Override
    public boolean doesRenderOnFire() {
        return canRenderOnFire();
    }

    @Override
    public boolean isPushedByFluids() {
        return isPushedByWater();
    }

    @Override
    public boolean hasCustomNameTag() {
        return hasCustomName();
    }

    @Override
    public boolean isCustomNameTagVisible() {
        return getAlwaysRenderNameTag();
    }

    @Override
    public void setCustomNameTagVisible(boolean visible) {
        setAlwaysRenderNameTag(visible);
    }

    @Override
    public void teleport(double destX, double destY, double destZ) {
        setPositionAndUpdate(destX, destY, destZ);
    }

    @Override
    public boolean shouldRenderName() {
        return getAlwaysRenderNameTagForRender();
    }

    @Override
    public Facing getHorizontalFacing_() {
        return Facing.values()[getHorizontalFacing().ordinal()];
    }

    @Override
    public Facing getMovementDirection_() {
        return Facing.values()[getAdjustedHorizontalFacing().ordinal()];
    }

    @Override
    public Box getRenderBoundingBox_() {
        return (Box) getRenderBoundingBox();
    }

    @Override
    public boolean isImmuneToExplosion() {
        return isImmuneToExplosions();
    }

    @Override
    public boolean entityDataRequiresOperator() {
        return ignoreItemEntityData();
    }

    @Override
    public Entity getControllingRider() {
        return (Entity) getControllingPassenger();
    }

    @Override
    public boolean isRider(Entity entity) {
        return isPassenger((net.minecraft.entity.Entity) entity);
    }

    @Override
    public Entity getLowestVehicle() {
        return (Entity) getLowestRidingEntity();
    }

    @Override
    public int getBurningDuration() {
        return getFireImmuneTicks();
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) getPosition();
    }
}
