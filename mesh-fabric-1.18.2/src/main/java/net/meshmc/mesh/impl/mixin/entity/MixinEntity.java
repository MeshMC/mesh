package net.meshmc.mesh.impl.mixin.entity;

import com.google.common.collect.ImmutableList;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.entity.EntityType;
import net.meshmc.mesh.api.entity.MoverType;
import net.meshmc.mesh.api.entity.living.player.EntityPlayer;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.math.Box;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.api.world.World;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.util.entity.Stance;
import net.meshmc.mesh.util.math.Facing;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tigermouthbear 1/16/22
 * @author Makrennel - moved to mixin with interface from wrapper
 */
@Mixin(net.minecraft.entity.Entity.class)
public abstract class MixinEntity implements Entity {
    @Shadow @Final private net.minecraft.entity.EntityType<?> type;
    @Shadow private ImmutableList<net.minecraft.entity.Entity> passengerList;
    @Shadow protected int ridingCooldown;
    @Shadow private net.minecraft.entity.Entity vehicle;
    @Shadow public net.minecraft.world.World world;
    @Shadow public double prevX;
    @Shadow public double prevY;
    @Shadow public double prevZ;
    @Shadow private net.minecraft.util.math.Vec3d pos;
    @Shadow private net.minecraft.util.math.BlockPos blockPos;
    @Shadow public double lastRenderX;
    @Shadow public double lastRenderY;
    @Shadow public double lastRenderZ;
    @Shadow private net.minecraft.util.math.Vec3d velocity;
    @Shadow private float yaw;
    @Shadow private float pitch;
    @Shadow public float prevYaw;
    @Shadow public float prevPitch;
    @Shadow private net.minecraft.util.math.Box boundingBox;
    @Shadow public boolean horizontalCollision;
    @Shadow public boolean verticalCollision;
    @Shadow public boolean collidedSoftly;
    @Shadow public boolean velocityModified;
    @Shadow public float horizontalSpeed;
    @Shadow public float prevHorizontalSpeed;
    @Shadow public float distanceTraveled;
    @Shadow public float fallDistance;
    @Shadow private float nextStepSoundDistance;
    @Shadow public float stepHeight;
    @Shadow public boolean noClip;
    @Shadow public int age;
    @Shadow protected boolean touchingWater;
    @Shadow protected boolean firstUpdate;
    @Shadow public boolean ignoreCameraFrustum;
    @Shadow protected boolean inNetherPortal;
    @Shadow private int netherPortalCooldown;
    @Shadow protected int netherPortalTime;
    @Shadow protected net.minecraft.util.math.BlockPos lastNetherPortalPosition;
    @Mutable @Shadow @Final private double[] pistonMovementDelta;
    @Shadow private long pistonMovementTick;
    @Shadow private float standingEyeHeight;
    @Shadow private EntityDimensions dimensions;
    @Shadow public abstract int getMaxNetherPortalTime();
    @Shadow public abstract void move(MovementType par1, net.minecraft.util.math.Vec3d par2);
    @Shadow public abstract boolean isFireImmune();
    @Shadow public abstract void onPlayerCollision(PlayerEntity par1);
    @Shadow public abstract void pushAwayFrom(net.minecraft.entity.Entity par1);
    @Shadow public abstract net.minecraft.util.math.Vec3d getRotationVector();
    @Shadow protected abstract net.minecraft.util.math.Vec3d getOppositeRotationVector(float par1, float par2);
    @Shadow public abstract void updateVelocity(float par1, net.minecraft.util.math.Vec3d par2);
    @Shadow public abstract boolean isCollidable();
    @Shadow public abstract boolean isPushable();
    @Shadow protected abstract String getSavedEntityId();
    @Shadow public abstract void updatePassengerPosition(net.minecraft.entity.Entity par1);
    @Shadow public abstract void onPassengerLookAround(net.minecraft.entity.Entity par1);
    @Shadow public abstract double getHeightOffset();
    @Shadow public abstract double getMountedHeightOffset();
    @Shadow public abstract boolean startRiding(net.minecraft.entity.Entity entityIn, boolean force);
    @Shadow protected abstract boolean canStartRiding(net.minecraft.entity.Entity par1);
    @Shadow public abstract void removeAllPassengers();
    @Shadow protected abstract void addPassenger(net.minecraft.entity.Entity passenger);
    @Shadow protected abstract void removePassenger(net.minecraft.entity.Entity passenger);
    @Shadow protected abstract boolean canAddPassenger(net.minecraft.entity.Entity par1);
    @Shadow public abstract void setInNetherPortal(net.minecraft.util.math.BlockPos par1);
    @Shadow public abstract void animateDamage();
    @Shadow public abstract boolean isInvisibleTo(PlayerEntity par1);
    @Shadow public abstract boolean handleAttack(net.minecraft.entity.Entity par1);
    @Shadow public abstract void copyPositionAndRotation(net.minecraft.entity.Entity par1);
    @Shadow public abstract void copyFrom(net.minecraft.entity.Entity par1);
    @Shadow public abstract boolean hasCustomName();
    @Shadow public abstract boolean isCustomNameVisible();
    @Shadow public abstract void setCustomNameVisible(boolean par1);
    @Shadow public abstract Direction getHorizontalFacing();
    @Shadow public abstract Direction getMovementDirection();
    @Shadow public abstract net.minecraft.util.math.Box getVisibilityBoundingBox();
    @Shadow public abstract net.minecraft.entity.Entity getPrimaryPassenger();
    @Shadow public abstract boolean hasPassenger(net.minecraft.entity.Entity par1);
    @Shadow public abstract net.minecraft.entity.Entity getRootVehicle();
    @Shadow public abstract void remove(net.minecraft.entity.Entity.RemovalReason par1);
    @Shadow public abstract boolean hasPassengers();
    @Shadow protected abstract void pushOutOfBlocks(double x, double y, double z);
    @Shadow public abstract net.minecraft.entity.EntityPose getPose();
    @Shadow public abstract float getHeadYaw();
    @Shadow public abstract void setHeadYaw(float value);
    @Shadow public abstract void setBodyYaw(float value);

    private static final Map<net.minecraft.entity.EntityType<?>, EntityType> entityTypeMap = new LinkedHashMap<>();

    static {
        entityTypeMap.put(net.minecraft.entity.EntityType.AREA_EFFECT_CLOUD, EntityType.AREA_EFFECT_CLOUD);
        entityTypeMap.put(net.minecraft.entity.EntityType.ARMOR_STAND, EntityType.ARMOR_STAND);
        entityTypeMap.put(net.minecraft.entity.EntityType.ARROW, EntityType.ARROW);
        entityTypeMap.put(net.minecraft.entity.EntityType.AXOLOTL, EntityType.AXOLOTL);
        entityTypeMap.put(net.minecraft.entity.EntityType.BAT, EntityType.BAT);
        entityTypeMap.put(net.minecraft.entity.EntityType.BEE, EntityType.BEE);
        entityTypeMap.put(net.minecraft.entity.EntityType.BLAZE, EntityType.BLAZE);
        entityTypeMap.put(net.minecraft.entity.EntityType.BOAT, EntityType.BOAT);
        entityTypeMap.put(net.minecraft.entity.EntityType.CAT, EntityType.CAT);
        entityTypeMap.put(net.minecraft.entity.EntityType.CAVE_SPIDER, EntityType.CAVE_SPIDER);
        entityTypeMap.put(net.minecraft.entity.EntityType.CHICKEN, EntityType.CHICKEN);
        entityTypeMap.put(net.minecraft.entity.EntityType.COD, EntityType.COD);
        entityTypeMap.put(net.minecraft.entity.EntityType.COW, EntityType.COW);
        entityTypeMap.put(net.minecraft.entity.EntityType.CREEPER, EntityType.CREEPER);
        entityTypeMap.put(net.minecraft.entity.EntityType.DOLPHIN, EntityType.DOLPHIN);
        entityTypeMap.put(net.minecraft.entity.EntityType.DONKEY, EntityType.DONKEY);
        entityTypeMap.put(net.minecraft.entity.EntityType.DRAGON_FIREBALL, EntityType.DRAGON_FIREBALL);
        entityTypeMap.put(net.minecraft.entity.EntityType.DROWNED, EntityType.DROWNED);
        entityTypeMap.put(net.minecraft.entity.EntityType.ELDER_GUARDIAN, EntityType.ELDER_GUARDIAN);
        entityTypeMap.put(net.minecraft.entity.EntityType.END_CRYSTAL, EntityType.END_CRYSTAL);
        entityTypeMap.put(net.minecraft.entity.EntityType.ENDER_DRAGON, EntityType.ENDER_DRAGON);
        entityTypeMap.put(net.minecraft.entity.EntityType.ENDERMAN, EntityType.ENDERMAN);
        entityTypeMap.put(net.minecraft.entity.EntityType.ENDERMITE, EntityType.ENDERMITE);
        entityTypeMap.put(net.minecraft.entity.EntityType.EVOKER, EntityType.EVOKER);
        entityTypeMap.put(net.minecraft.entity.EntityType.EVOKER_FANGS, EntityType.EVOKER_FANGS);
        entityTypeMap.put(net.minecraft.entity.EntityType.EXPERIENCE_ORB, EntityType.EXPERIENCE_ORB);
        entityTypeMap.put(net.minecraft.entity.EntityType.EYE_OF_ENDER, EntityType.EYE_OF_ENDER);
        entityTypeMap.put(net.minecraft.entity.EntityType.FALLING_BLOCK, EntityType.FALLING_BLOCK);
        entityTypeMap.put(net.minecraft.entity.EntityType.FIREWORK_ROCKET, EntityType.FIREWORK_ROCKET);
        entityTypeMap.put(net.minecraft.entity.EntityType.FOX, EntityType.FOX);
        entityTypeMap.put(net.minecraft.entity.EntityType.GHAST, EntityType.GHAST);
        entityTypeMap.put(net.minecraft.entity.EntityType.GIANT, EntityType.GIANT);
        entityTypeMap.put(net.minecraft.entity.EntityType.GLOW_ITEM_FRAME, EntityType.GLOW_ITEM_FRAME);
        entityTypeMap.put(net.minecraft.entity.EntityType.GLOW_SQUID, EntityType.GLOW_SQUID);
        entityTypeMap.put(net.minecraft.entity.EntityType.GOAT, EntityType.GOAT);
        entityTypeMap.put(net.minecraft.entity.EntityType.GUARDIAN, EntityType.GUARDIAN);
        entityTypeMap.put(net.minecraft.entity.EntityType.HOGLIN, EntityType.HOGLIN);
        entityTypeMap.put(net.minecraft.entity.EntityType.HORSE, EntityType.HORSE);
        entityTypeMap.put(net.minecraft.entity.EntityType.HUSK, EntityType.HUSK);
        entityTypeMap.put(net.minecraft.entity.EntityType.ILLUSIONER, EntityType.ILLUSIONER);
        entityTypeMap.put(net.minecraft.entity.EntityType.IRON_GOLEM, EntityType.IRON_GOLEM);
        entityTypeMap.put(net.minecraft.entity.EntityType.ITEM, EntityType.ITEM);
        entityTypeMap.put(net.minecraft.entity.EntityType.ITEM_FRAME, EntityType.ITEM_FRAME);
        entityTypeMap.put(net.minecraft.entity.EntityType.FIREBALL, EntityType.FIREBALL);
        entityTypeMap.put(net.minecraft.entity.EntityType.LEASH_KNOT, EntityType.LEASH_KNOT);
        entityTypeMap.put(net.minecraft.entity.EntityType.LIGHTNING_BOLT, EntityType.LIGHTNING_BOLT);
        entityTypeMap.put(net.minecraft.entity.EntityType.LLAMA, EntityType.LLAMA);
        entityTypeMap.put(net.minecraft.entity.EntityType.LLAMA_SPIT, EntityType.LLAMA_SPIT);
        entityTypeMap.put(net.minecraft.entity.EntityType.MAGMA_CUBE, EntityType.MAGMA_CUBE);
        entityTypeMap.put(net.minecraft.entity.EntityType.MARKER, EntityType.MARKER);
        entityTypeMap.put(net.minecraft.entity.EntityType.MINECART, EntityType.MINECART);
        entityTypeMap.put(net.minecraft.entity.EntityType.CHEST_MINECART, EntityType.CHEST_MINECART);
        entityTypeMap.put(net.minecraft.entity.EntityType.COMMAND_BLOCK_MINECART, EntityType.COMMAND_BLOCK_MINECART);
        entityTypeMap.put(net.minecraft.entity.EntityType.FURNACE_MINECART, EntityType.FURNACE_MINECART);
        entityTypeMap.put(net.minecraft.entity.EntityType.HOPPER_MINECART, EntityType.HOPPER_MINECART);
        entityTypeMap.put(net.minecraft.entity.EntityType.SPAWNER_MINECART, EntityType.SPAWNER_MINECART);
        entityTypeMap.put(net.minecraft.entity.EntityType.TNT_MINECART, EntityType.TNT_MINECART);
        entityTypeMap.put(net.minecraft.entity.EntityType.MULE, EntityType.MULE);
        entityTypeMap.put(net.minecraft.entity.EntityType.MOOSHROOM, EntityType.MOOSHROOM);
        entityTypeMap.put(net.minecraft.entity.EntityType.OCELOT, EntityType.OCELOT);
        entityTypeMap.put(net.minecraft.entity.EntityType.PAINTING, EntityType.PAINTING);
        entityTypeMap.put(net.minecraft.entity.EntityType.PANDA, EntityType.PANDA);
        entityTypeMap.put(net.minecraft.entity.EntityType.PARROT, EntityType.PARROT);
        entityTypeMap.put(net.minecraft.entity.EntityType.PHANTOM, EntityType.PHANTOM);
        entityTypeMap.put(net.minecraft.entity.EntityType.PIG, EntityType.PIG);
        entityTypeMap.put(net.minecraft.entity.EntityType.PIGLIN, EntityType.PIGLIN);
        entityTypeMap.put(net.minecraft.entity.EntityType.PIGLIN_BRUTE, EntityType.PIGLIN_BRUTE);
        entityTypeMap.put(net.minecraft.entity.EntityType.PILLAGER, EntityType.PILLAGER);
        entityTypeMap.put(net.minecraft.entity.EntityType.POLAR_BEAR, EntityType.POLAR_BEAR);
        entityTypeMap.put(net.minecraft.entity.EntityType.TNT, EntityType.TNT);
        entityTypeMap.put(net.minecraft.entity.EntityType.PUFFERFISH, EntityType.PUFFERFISH);
        entityTypeMap.put(net.minecraft.entity.EntityType.RABBIT, EntityType.RABBIT);
        entityTypeMap.put(net.minecraft.entity.EntityType.RAVAGER, EntityType.RAVAGER);
        entityTypeMap.put(net.minecraft.entity.EntityType.SALMON, EntityType.SALMON);
        entityTypeMap.put(net.minecraft.entity.EntityType.SHEEP, EntityType.SHEEP);
        entityTypeMap.put(net.minecraft.entity.EntityType.SHULKER, EntityType.SHULKER);
        entityTypeMap.put(net.minecraft.entity.EntityType.SHULKER_BULLET, EntityType.SHULKER_BULLET);
        entityTypeMap.put(net.minecraft.entity.EntityType.SILVERFISH, EntityType.SILVERFISH);
        entityTypeMap.put(net.minecraft.entity.EntityType.SKELETON, EntityType.SKELETON);
        entityTypeMap.put(net.minecraft.entity.EntityType.SKELETON_HORSE, EntityType.SKELETON_HORSE);
        entityTypeMap.put(net.minecraft.entity.EntityType.SLIME, EntityType.SLIME);
        entityTypeMap.put(net.minecraft.entity.EntityType.SMALL_FIREBALL, EntityType.SMALL_FIREBALL);
        entityTypeMap.put(net.minecraft.entity.EntityType.SNOW_GOLEM, EntityType.SNOW_GOLEM);
        entityTypeMap.put(net.minecraft.entity.EntityType.SNOWBALL, EntityType.SNOWBALL);
        entityTypeMap.put(net.minecraft.entity.EntityType.SPECTRAL_ARROW, EntityType.SPECTRAL_ARROW);
        entityTypeMap.put(net.minecraft.entity.EntityType.SPIDER, EntityType.SPIDER);
        entityTypeMap.put(net.minecraft.entity.EntityType.SQUID, EntityType.SQUID);
        entityTypeMap.put(net.minecraft.entity.EntityType.STRAY, EntityType.STRAY);
        entityTypeMap.put(net.minecraft.entity.EntityType.STRIDER, EntityType.STRIDER);
        entityTypeMap.put(net.minecraft.entity.EntityType.EGG, EntityType.EGG);
        entityTypeMap.put(net.minecraft.entity.EntityType.ENDER_PEARL, EntityType.ENDER_PEARL);
        entityTypeMap.put(net.minecraft.entity.EntityType.EXPERIENCE_BOTTLE, EntityType.EXPERIENCE_BOTTLE);
        entityTypeMap.put(net.minecraft.entity.EntityType.POTION, EntityType.POTION);
        entityTypeMap.put(net.minecraft.entity.EntityType.TRIDENT, EntityType.TRIDENT);
        entityTypeMap.put(net.minecraft.entity.EntityType.TRADER_LLAMA, EntityType.TRADER_LLAMA);
        entityTypeMap.put(net.minecraft.entity.EntityType.TROPICAL_FISH, EntityType.TROPICAL_FISH);
        entityTypeMap.put(net.minecraft.entity.EntityType.TURTLE, EntityType.TURTLE);
        entityTypeMap.put(net.minecraft.entity.EntityType.VEX, EntityType.VEX);
        entityTypeMap.put(net.minecraft.entity.EntityType.VILLAGER, EntityType.VILLAGER);
        entityTypeMap.put(net.minecraft.entity.EntityType.VINDICATOR, EntityType.VINDICATOR);
        entityTypeMap.put(net.minecraft.entity.EntityType.WANDERING_TRADER, EntityType.WANDERING_TRADER);
        entityTypeMap.put(net.minecraft.entity.EntityType.WITCH, EntityType.WITCH);
        entityTypeMap.put(net.minecraft.entity.EntityType.WITHER, EntityType.WITHER);
        entityTypeMap.put(net.minecraft.entity.EntityType.WITHER_SKELETON, EntityType.WITHER_SKELETON);
        entityTypeMap.put(net.minecraft.entity.EntityType.WITHER_SKULL, EntityType.WITHER_SKULL);
        entityTypeMap.put(net.minecraft.entity.EntityType.WOLF, EntityType.WOLF);
        entityTypeMap.put(net.minecraft.entity.EntityType.ZOGLIN, EntityType.ZOGLIN);
        entityTypeMap.put(net.minecraft.entity.EntityType.ZOMBIE, EntityType.ZOMBIE);
        entityTypeMap.put(net.minecraft.entity.EntityType.ZOMBIE_HORSE, EntityType.ZOMBIE_HORSE);
        entityTypeMap.put(net.minecraft.entity.EntityType.ZOMBIE_VILLAGER, EntityType.ZOMBIE_VILLAGER);
        entityTypeMap.put(net.minecraft.entity.EntityType.ZOMBIFIED_PIGLIN, EntityType.ZOMBIFIED_PIGLIN);
        entityTypeMap.put(net.minecraft.entity.EntityType.PLAYER, EntityType.PLAYER);
        entityTypeMap.put(net.minecraft.entity.EntityType.FISHING_BOBBER, EntityType.FISHING_BOBBER);
    }

    @Override
    public EntityType getEntityType() {
        return entityTypeMap.get(type);
    }

    @Override @Shadow public abstract int getId();
    @Override @Shadow public abstract void setId(int value);

    @Override
    public List<Entity> getRiders() {
        List<Entity> list = new ArrayList<>();
        for(net.minecraft.entity.Entity entity: passengerList) list.add((Entity) entity);
        return list;
    }

    @Override
    public int getRidingCooldown() {
        return ridingCooldown;
    }

    @Override
    public void setRidingCooldown(int value) {
        ridingCooldown = value;
    }

    @Override
    public Entity getVehicle() {
        return (Entity) vehicle;
    }

    @Override
    public void setVehicle(Entity entity) {
        vehicle = (net.minecraft.entity.Entity) entity;
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
        return Vec3d.create(getPrevX(), getPrevY(), getPrevZ());
    }

    @Override
    public void setPrevPosition(Vec3d position) {
        prevX = position.getX();
        prevY = position.getY();
        prevZ = position.getZ();
    }

    @Override
    public double getPrevX() {
        return prevX;
    }

    @Override
    public double getPrevY() {
        return prevY;
    }

    @Override
    public double getPrevZ() {
        return prevZ;
    }

    @Override
    public void setPrevX(double value) {
        prevX = value;
    }

    @Override
    public void setPrevY(double value) {
        prevY = value;
    }

    @Override
    public void setPrevZ(double value) {
        prevZ = value;
    }

    @Override
    public Vec3d getPos() {
        return (Vec3d) pos;
    }

    @Override @Shadow public abstract void setPosition(double x, double y, double z);

    @Override
    public void setPosition(Vec3d position) {
        setPosition(position.getX(), position.getY(), position.getZ());
    }

    @Override @Shadow public abstract double getX();
    @Override @Shadow public abstract double getY();
    @Override @Shadow public abstract double getZ();

    @Override
    public void setX(double value) {
        getPos().setX(value);
    }

    @Override
    public void setY(double value) {
        getPos().setY(value);
    }

    @Override
    public void setZ(double value) {
        getPos().setZ(value);
    }

    @Override
    public double getLastRenderX() {
        return lastRenderX;
    }

    @Override
    public double getLastRenderY() {
        return lastRenderY;
    }

    @Override
    public double getLastRenderZ() {
        return lastRenderZ;
    }

    @Override
    public void setLastRenderX(double value) {
        lastRenderX = value;
    }

    @Override
    public void setLastRenderY(double value) {
        lastRenderY = value;
    }

    @Override
    public void setLastRenderZ(double value) {
        lastRenderZ = value;
    }

    @Override
    public Vec3d getVelocity() {
        return (Vec3d) velocity;
    }

    @Override @Shadow public abstract void setVelocity(double x, double y, double z);

    @Override
    public void setVelocity(Vec3d velocity) {
        this.velocity = (net.minecraft.util.math.Vec3d) velocity;
    }

    @Override
    public double getXVelocity() {
        return velocity.x;
    }

    @Override
    public double getYVelocity() {
        return velocity.y;
    }

    @Override
    public double getZVelocity() {
        return velocity.z;
    }

    @Override
    public void setXVelocity(double value) {
        setVelocity(value, getYVelocity(), getZVelocity());
    }

    @Override
    public void setYVelocity(double value) {
        setVelocity(getXVelocity(), value, getZVelocity());
    }

    @Override
    public void setZVelocity(double value) {
        setVelocity(getXVelocity(), getYVelocity(), value);
    }

    @Override @Shadow public abstract float getYaw();
    @Override @Shadow public abstract float getPitch();
    @Override @Shadow public abstract void setYaw(float value);
    @Override @Shadow public abstract void setPitch(float value);

    @Override
    public float getPrevYaw() {
        return prevYaw;
    }

    @Override
    public float getPrevPitch() {
        return prevPitch;
    }

    @Override
    public void setPrevYaw(float value) {
        prevYaw = value;
    }

    @Override
    public void setPrevPitch(float value) {
        prevPitch = value;
    }

    @Override
    public Box getBounds() {
        return (Box) boundingBox;
    }

    @Override
    public void setBounds(Box box) {
        boundingBox = (net.minecraft.util.math.Box) box;
    }

    @Override @Shadow public abstract boolean isOnGround();
    @Override @Shadow public abstract void setOnGround(boolean value);

    @Override
    public boolean isCollidedHorizontally() {
        return horizontalCollision;
    }

    @Override
    public void setCollidedHorizontally(boolean value) {
        horizontalCollision = value;
    }

    @Override
    public boolean isCollidedVertically() {
        return verticalCollision;
    }

    @Override
    public void setCollidedVertically(boolean value) {
        verticalCollision = value;
    }

    @Override
    public boolean isCollided() {
        return collidedSoftly;
    }

    @Override
    public void setCollided(boolean value) {
        collidedSoftly = value;
    }

    @Override
    public boolean isVelocityChanged() {
        return velocityModified;
    }

    @Override
    public void setVelocityChanged(boolean value) {
        velocityModified = value;
    }

    @Override
    public float getHorizontalSpeed() {
        return horizontalSpeed;
    }

    @Override
    public void setHorizontalSpeed(float value) {
        horizontalSpeed = value;
    }

    @Override
    public float getPrevHorizontalSpeed() {
        return prevHorizontalSpeed;
    }

    @Override
    public void setPrevHorizontalSpeed(float value) {
        prevHorizontalSpeed = value;
    }

    @Override
    public float getDistanceTraveled() {
        return distanceTraveled;
    }

    @Override
    public void setDistanceTraveled(float value) {
        distanceTraveled = value;
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
        return nextStepSoundDistance;
    }

    @Override
    public void setNextStepSoundDistance(float value) {
        nextStepSoundDistance = value;
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
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int value) {
        age = value;
    }

    @Override @Shadow public abstract int getFireTicks();
    @Override @Shadow public abstract void setFireTicks(int value);

    @Override
    public boolean isInWater() {
        return touchingWater;
    }

    @Override
    public void setInWater(boolean value) {
        touchingWater = value;
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
        return ignoreCameraFrustum;
    }

    @Override
    public void setIgnoreCameraFrustum(boolean value) {
        ignoreCameraFrustum = value;
    }

    @Override
    public boolean isInPortal() {
        return inNetherPortal;
    }

    @Override
    public void setInPortal(boolean value) {
        inNetherPortal = value;
    }

    @Override
    public int getPortalCooldown() {
        return netherPortalCooldown;
    }

    @Override
    public void setPortalCooldown(int value) {
        netherPortalCooldown = value;
    }

    @Override
    public int getPortalTime() {
        return netherPortalTime;
    }

    @Override
    public void setPortalTime(int value) {
        netherPortalTime = value;
    }

    @Override
    public BlockPos getLastPortalPosition() {
        return (BlockPos) lastNetherPortalPosition;
    }

    @Override
    public void setLastPortalPosition(BlockPos pos) {
        lastNetherPortalPosition = (net.minecraft.util.math.BlockPos) pos;
    }

    @Override @Shadow public abstract boolean isInvulnerable();
    @Override @Shadow public abstract void setInvulnerable(boolean value);
    @Override @Shadow public abstract boolean isGlowing();
    @Override @Shadow public abstract void setGlowing(boolean value);

    @Override
    public double[] getPistonMovementDelta() {
        return pistonMovementDelta;
    }

    @Override
    public void setPistonMovementDelta(double[] value) {
        pistonMovementDelta = value;
    }

    @Override
    public long getPistonDelta() {
        return pistonMovementTick;
    }

    @Override
    public void setPistonDelta(long value) {
        pistonMovementTick = value;
    }

    @Override
    public float getEyeHeight() {
        return standingEyeHeight;
    }

    @Override @Shadow public abstract boolean isSpectator();
    @Override @Shadow public abstract void kill();
    @Override @Shadow public abstract void discard();

    @Override
    public Box calculateBoundingBox() {
        return (Box) dimensions.getBoxAt(pos);
    }

    @Override @Shadow public abstract void tick();
    @Override @Shadow public abstract void baseTick();

    @Override
    public int getMaxInPortalTime() {
        return getMaxNetherPortalTime();
    }

    @Override @Shadow public abstract void setOnFireFromLava();
    @Override @Shadow public abstract void setOnFireFor(int value);
    @Override @Shadow public abstract void tickInVoid();

    @Override
    public void move(MoverType moverType, Vec3d movement) {
        move(MovementType.values()[moverType.ordinal()], (net.minecraft.util.math.Vec3d) movement);
    }

    @Override @Shadow public abstract void checkBlockCollision();
    @Override @Shadow public abstract boolean isSilent();
    @Override @Shadow public abstract void setSilent(boolean value);
    @Override @Shadow public abstract boolean hasNoGravity();
    @Override @Shadow public abstract void setNoGravity(boolean value);

    @Override
    public boolean isImmuneToFire() {
        return isFireImmune();
    }

    @Override @Shadow public abstract boolean isBeingRainedOn();
    @Override @Shadow public abstract boolean isInsideWaterOrBubbleColumn();
    @Override @Shadow public abstract void updateSwimming();
    @Override @Shadow public abstract void spawnSprintingParticles();
    @Override @Shadow public abstract boolean isInLava();

    @Override
    public void moveRelative(float speed, Vec3d vec3d) {
        updateVelocity(speed, (net.minecraft.util.math.Vec3d) vec3d);
    }

    @Override @Shadow public abstract float getBrightnessAtEyes();
    @Override @Shadow public abstract void updatePositionAndAngles(double x, double y, double z, float yaw, float pitch);

    @Override
    public void onPlayerCollision(EntityPlayer entityPlayer) {
        onPlayerCollision((net.minecraft.entity.player.PlayerEntity) entityPlayer);
    }

    @Override
    public void pushAwayFrom(Entity entity) {
        pushAwayFrom((net.minecraft.entity.Entity) entity);
    }

    @Override
    public Vec3d getRotationVec() {
        return (Vec3d) getRotationVector();
    }

    @Override
    public Vec3d getOppositeRotationVec() {
        return (Vec3d) getOppositeRotationVector(pitch, yaw);
    }

    @Override @Shadow public abstract float getPitch(float delta);
    @Override @Shadow public abstract float getYaw(float delta);

    @Override
    public Vec3d getCameraPosVec(float delta) {
        double $$1 = MathHelper.lerp(delta, this.prevX, this.getX());
        double $$2 = MathHelper.lerp(delta, this.prevY, this.getY()) + (double)this.standingEyeHeight;
        double $$3 = MathHelper.lerp(delta, this.prevZ, this.getZ());
        return Vec3d.create($$1, $$2, $$3);
    }

    @Override
    public boolean canBeCollidedWith() {
        return isCollidable();
    }

    @Override
    public boolean canBePushed() {
        return isPushable();
    }

    @Override @Shadow public abstract boolean shouldRender(double cameraX, double cameraY, double cameraZ);
    @Override @Shadow public abstract boolean shouldRender(double distance);
    @Override @Shadow public abstract boolean shouldSetPositionOnLoad();

    @Override
    public String getEntityString() {
        return getSavedEntityId();
    }

    @Override @Shadow public abstract boolean isAlive();
    @Override @Shadow public abstract boolean isInsideWall();
    @Override @Shadow public abstract void tickRiding();

    @Override
    public void updateRiderPosition(Entity entity) {
        updatePassengerPosition((net.minecraft.entity.Entity) entity);
    }

    @Override
    public void onRiderLookAround(Entity entity) {
        onPassengerLookAround((net.minecraft.entity.Entity) entity);
    }

    @Override
    public double getYOffset() {
        return getHeightOffset();
    }

    @Override
    public double getMountedYOffset() {
        return getMountedHeightOffset();
    }

    @Override
    public boolean startRidingEntity(Entity entity, boolean force) {
        return startRiding((net.minecraft.entity.Entity) entity, force);
    }

    @Override
    public boolean canStartRiding(Entity entity) {
        return canStartRiding((net.minecraft.entity.Entity) entity);
    }

    @Override
    public void removeRiders() {
        removeAllPassengers();
    }

    @Override @Shadow public abstract void dismountVehicle();

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
        return canAddPassenger((net.minecraft.entity.Entity) entity);
    }

    @Override @Shadow public abstract void updateTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate);
    @Override @Shadow public abstract float getTargetingMargin();

    @Override
    public void setInNetherPortal(BlockPos blockPos) {
        setInNetherPortal((net.minecraft.util.math.BlockPos) blockPos);
    }

    @Override @Shadow public abstract int getDefaultNetherPortalCooldown();
    @Override @Shadow public abstract void handleStatus(byte status);

    @Override
    public void performHurtAnimation() {
        animateDamage();
    }

    @Override @Shadow public abstract boolean isOnFire();
    @Override @Shadow public abstract boolean hasVehicle();

    @Override
    public boolean hasRiders() {
        return hasPassengers();
    }

    @Override @Shadow public abstract boolean isSneaking();
    @Override @Shadow public abstract void setSneaking(boolean value);

    @Override
    public Stance getStance() {
        return MeshEnum.stance(getPose());
    }

    @Override
    public void setStance(Stance stance) {
        setPose(MCEnum.stance(stance));
    }

    @Override @Shadow public abstract boolean isSprinting();
    @Override @Shadow public abstract void setSprinting(boolean value);
    @Override @Shadow public abstract boolean isInvisible();

    @Override
    public boolean isInvisibleTo(EntityPlayer player) {
        return isInvisibleTo((net.minecraft.entity.player.PlayerEntity) player);
    }

    @Override @Shadow public abstract void setInvisible(boolean value);
    @Override @Shadow public abstract boolean getFlag(int index);
    @Override @Shadow public abstract void setFlag(int index, boolean value);
    @Override @Shadow public abstract int getAir();
    @Override @Shadow public abstract void setAir(int air);

    @Override public void pushOutOfSolidBlock(double x, double y, double z) {
        pushOutOfBlocks(x, y, z);
    }

    @Override
    public float getRenderHeadYaw() {
        return getHeadYaw();
    }

    @Override
    public void setRenderHeadYaw(float headYaw) {
        setHeadYaw(headYaw);
    }

    @Override
    public void setRenderBodyYaw(float bodyYaw) {
        setBodyYaw(bodyYaw);
    }

    @Override @Shadow public abstract boolean isAttackable();

    @Override
    public boolean handleAttack(Entity attacker) {
        return handleAttack((net.minecraft.entity.Entity) attacker);
    }

    @Override
    public void copyPositionAndRotation(Entity entity) {
        copyPositionAndRotation((net.minecraft.entity.Entity) entity);
    }

    @Override
    public void copyFrom(Entity original) {
        copyFrom((net.minecraft.entity.Entity) original);
    }

    @Override @Shadow public abstract int getSafeFallDistance();
    @Override @Shadow public abstract boolean canAvoidTraps();
    @Override @Shadow public abstract boolean doesRenderOnFire();
    @Override @Shadow public abstract boolean isPushedByFluids();

    @Override
    public boolean hasCustomNameTag() {
        return hasCustomName();
    }

    @Override
    public boolean isCustomNameTagVisible() {
        return isCustomNameVisible();
    }

    @Override
    public void setCustomNameTagVisible(boolean visible) {
        setCustomNameVisible(visible);
    }

    @Override @Shadow public abstract void teleport(double destX, double destY, double destZ);
    @Override @Shadow public abstract boolean shouldRenderName();

    @Override
    public Facing getHorizontalFacing_() {
        return Facing.values()[getHorizontalFacing().ordinal()];
    }

    @Override
    public Facing getMovementDirection_() {
        return Facing.values()[getMovementDirection().ordinal()];
    }

    @Override
    public Box getRenderBoundingBox_() {
        return (Box) getVisibilityBoundingBox();
    }

    @Override @Shadow public abstract boolean isImmuneToExplosion();
    @Override @Shadow public abstract boolean entityDataRequiresOperator();

    @Override
    public Entity getControllingRider() {
        return (Entity) getPrimaryPassenger();
    }

    @Override
    public boolean hasRider(Entity entity) {
        return hasPassenger((net.minecraft.entity.Entity) entity);
    }

    @Override
    public Entity getLowestVehicle() {
        return (Entity) getRootVehicle();
    }

    @Override @Shadow public abstract int getBurningDuration();
    @Override @Shadow public abstract float getWidth();
    @Override @Shadow public abstract float getHeight();

    @Shadow public abstract void setPose(EntityPose par1);

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) blockPos;
    }
}