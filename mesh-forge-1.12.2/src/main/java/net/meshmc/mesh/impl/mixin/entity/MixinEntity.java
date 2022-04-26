package net.meshmc.mesh.impl.mixin.entity;

import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.entity.EntityType;
import net.meshmc.mesh.api.entity.MoverType;
import net.meshmc.mesh.api.entity.living.player.EntityPlayer;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.math.Box;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.api.world.World;
import net.meshmc.mesh.util.math.Facing;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    private static final Map<Class<? extends net.minecraft.entity.Entity>, EntityType> entityTypeMap;

    static {
        entityTypeMap = new LinkedHashMap<>();

        entityTypeMap.put(net.minecraft.entity.player.EntityPlayer.class, EntityType.PLAYER);
        entityTypeMap.put(net.minecraft.entity.player.EntityPlayerMP.class, EntityType.PLAYER);
        entityTypeMap.put(EntityPlayerSP.class, EntityType.PLAYER);
        entityTypeMap.put(EntityOtherPlayerMP.class, EntityType.PLAYER);
        entityTypeMap.put(EntityDragon.class, EntityType.ENDER_DRAGON);
        entityTypeMap.put(EntityWither.class, EntityType.WITHER);
        entityTypeMap.put(EntityLightningBolt.class, EntityType.LIGHTNING_BOLT);
        entityTypeMap.put(EntityArmorStand.class, EntityType.ARMOR_STAND);
        entityTypeMap.put(EntityBoat.class, EntityType.BOAT);
        entityTypeMap.put(EntityEnderCrystal.class, EntityType.END_CRYSTAL);
        entityTypeMap.put(EntityEnderEye.class, EntityType.EYE_OF_ENDER);
        entityTypeMap.put(EntityEnderPearl.class, EntityType.ENDER_PEARL);
        entityTypeMap.put(EntityExpBottle.class, EntityType.EXPERIENCE_BOTTLE);
        entityTypeMap.put(EntityFallingBlock.class, EntityType.FALLING_BLOCK);
        entityTypeMap.put(EntityFireworkRocket.class, EntityType.FIREWORK_ROCKET);
        entityTypeMap.put(EntityItem.class, EntityType.ITEM);
        entityTypeMap.put(EntityItemFrame.class, EntityType.ITEM_FRAME);
        entityTypeMap.put(EntityMinecartEmpty.class, EntityType.MINECART);
        entityTypeMap.put(EntityMinecartChest.class, EntityType.CHEST_MINECART);
        entityTypeMap.put(EntityMinecartCommandBlock.class, EntityType.COMMAND_BLOCK_MINECART);
        entityTypeMap.put(EntityMinecartFurnace.class, EntityType.FURNACE_MINECART);
        entityTypeMap.put(EntityMinecartHopper.class, EntityType.HOPPER_MINECART);
        entityTypeMap.put(EntityMinecartMobSpawner.class, EntityType.SPAWNER_MINECART);
        entityTypeMap.put(EntityMinecartTNT.class, EntityType.TNT_MINECART);
        entityTypeMap.put(EntityPainting.class, EntityType.PAINTING);
        entityTypeMap.put(EntityTNTPrimed.class, EntityType.TNT);
        entityTypeMap.put(EntityXPOrb.class, EntityType.EXPERIENCE_ORB);
        entityTypeMap.put(EntityBlaze.class, EntityType.BLAZE);
        entityTypeMap.put(EntityCaveSpider.class, EntityType.CAVE_SPIDER);
        entityTypeMap.put(EntityCreeper.class, EntityType.CREEPER);
        entityTypeMap.put(EntityElderGuardian.class, EntityType.ELDER_GUARDIAN);
        entityTypeMap.put(EntityEnderman.class, EntityType.ENDERMAN);
        entityTypeMap.put(EntityEndermite.class, EntityType.ENDERMITE);
        entityTypeMap.put(EntityEvoker.class, EntityType.EVOKER);
        entityTypeMap.put(EntityGhast.class, EntityType.GHAST);
        entityTypeMap.put(EntityGiantZombie.class, EntityType.GIANT);
        entityTypeMap.put(EntityGuardian.class, EntityType.GUARDIAN);
        entityTypeMap.put(EntityHusk.class, EntityType.HUSK);
        entityTypeMap.put(EntityIllusionIllager.class, EntityType.ILLUSIONER);
        entityTypeMap.put(EntityIronGolem.class, EntityType.IRON_GOLEM);
        entityTypeMap.put(EntityMagmaCube.class, EntityType.MAGMA_CUBE);
        entityTypeMap.put(EntityPigZombie.class, EntityType.ZOMBIFIED_PIGLIN);
        entityTypeMap.put(EntityPolarBear.class, EntityType.POLAR_BEAR);
        entityTypeMap.put(EntityShulker.class, EntityType.SHULKER);
        entityTypeMap.put(EntitySilverfish.class, EntityType.SILVERFISH);
        entityTypeMap.put(EntitySkeleton.class, EntityType.SKELETON);
        entityTypeMap.put(EntitySlime.class, EntityType.SLIME);
        entityTypeMap.put(EntitySnowman.class, EntityType.SNOW_GOLEM);
        entityTypeMap.put(EntitySpider.class, EntityType.SPIDER);
        entityTypeMap.put(EntityStray.class, EntityType.STRAY);
        entityTypeMap.put(EntityVex.class, EntityType.VEX);
        entityTypeMap.put(EntityVindicator.class, EntityType.VINDICATOR);
        entityTypeMap.put(EntityWitch.class, EntityType.WITCH);
        entityTypeMap.put(EntityWitherSkeleton.class, EntityType.WITHER_SKELETON);
        entityTypeMap.put(EntityZombieVillager.class, EntityType.ZOMBIE_VILLAGER);
        entityTypeMap.put(EntityZombie.class, EntityType.ZOMBIE);
        entityTypeMap.put(EntityBat.class, EntityType.BAT);
        entityTypeMap.put(EntityChicken.class, EntityType.CHICKEN);
        entityTypeMap.put(EntityMooshroom.class, EntityType.MOOSHROOM);
        entityTypeMap.put(EntityCow.class, EntityType.COW);
        entityTypeMap.put(EntityDonkey.class, EntityType.DONKEY);
        entityTypeMap.put(EntityHorse.class, EntityType.HORSE);
        entityTypeMap.put(EntityLlama.class, EntityType.LLAMA);
        entityTypeMap.put(EntityMule.class, EntityType.MULE);
        entityTypeMap.put(EntityOcelot.class, EntityType.OCELOT);
        entityTypeMap.put(EntityParrot.class, EntityType.PARROT);
        entityTypeMap.put(EntityPig.class, EntityType.PIG);
        entityTypeMap.put(EntityRabbit.class, EntityType.RABBIT);
        entityTypeMap.put(EntitySheep.class, EntityType.SHEEP);
        entityTypeMap.put(EntitySkeletonHorse.class, EntityType.SKELETON_HORSE);
        entityTypeMap.put(EntitySquid.class, EntityType.SQUID);
        entityTypeMap.put(EntityWolf.class, EntityType.WOLF);
        entityTypeMap.put(EntityZombieHorse.class, EntityType.ZOMBIE_HORSE);
        entityTypeMap.put(EntityDragonFireball.class, EntityType.DRAGON_FIREBALL);
        entityTypeMap.put(EntityEgg.class, EntityType.EGG);
        entityTypeMap.put(EntityEvokerFangs.class, EntityType.EVOKER_FANGS);
        entityTypeMap.put(EntityWitherSkull.class, EntityType.WITHER_SKULL);
        entityTypeMap.put(EntityFireball.class, EntityType.FIREBALL);
        entityTypeMap.put(EntityFishHook.class, EntityType.FISHING_BOBBER);
        entityTypeMap.put(EntityLlamaSpit.class, EntityType.LLAMA_SPIT);
        entityTypeMap.put(EntityPotion.class, EntityType.POTION);
        entityTypeMap.put(EntityShulkerBullet.class, EntityType.SHULKER_BULLET);
        entityTypeMap.put(EntitySnowball.class, EntityType.SNOWBALL);
        entityTypeMap.put(EntitySpectralArrow.class, EntityType.SPECTRAL_ARROW);
        entityTypeMap.put(EntityArrow.class, EntityType.ARROW);
        entityTypeMap.put(EntityAreaEffectCloud.class, EntityType.AREA_EFFECT_CLOUD);
        entityTypeMap.put(EntityLeashKnot.class, EntityType.LEASH_KNOT);
    }

    @Override
    public EntityType getEntityType() {
        net.minecraft.entity.Entity entity = Minecraft.getMinecraft().world.getEntityByID(entityId);
        if(entity != null) return entityTypeMap.get(entity.getClass());
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
