package net.meshmc.mesh.impl.util;

import net.meshmc.mesh.api.entity.EntityType;
import net.meshmc.mesh.impl.wrapper.entity.EntityMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.EntityLivingMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.EntityPassiveMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.player.*;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.EntityMobMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.*;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.guardian.*;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.raider.*;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton.*;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.spider.*;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.zombie.*;
import net.meshmc.mesh.impl.wrapper.world.ClientWorldMesh;
import net.meshmc.mesh.impl.wrapper.world.WorldMesh;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.*;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Mappings {
    @FunctionalInterface
    public interface CreationWrapper<T, Y> {
        Y wrap(T value);
    }

    // WORLD Class Wrapping
    public static <T extends World> net.meshmc.mesh.api.world.World world(T world) {
        if(world == null) return null;
        return (net.meshmc.mesh.api.world.World) worldClassMap.get(world.getClass()).wrap(world);
    }

    public static final Map<Class<? extends World>, CreationWrapper> worldClassMap = new LinkedHashMap<>();
    static {
        worldClassMap.put(World.class, value -> new WorldMesh<>((World) value));
        worldClassMap.put(WorldClient.class, value -> new ClientWorldMesh<>((WorldClient) value));
        worldClassMap.put(WorldServer.class, value -> new WorldMesh<>((World) value));
    }

    // ENTITY Class Wrapping
    public static <T extends Entity> net.meshmc.mesh.api.entity.Entity entity(T entity) {
        if(entity == null) return null;
        if(!entityClassMap.containsKey(entity.getClass())) return new EntityMesh<>(entity);
        return (net.meshmc.mesh.api.entity.Entity) entityClassMap.get(entity.getClass()).wrap(entity);
    }

    public static final Map<Class<? extends Entity>, CreationWrapper> entityClassMap = new LinkedHashMap<>();
    static {
        entityClassMap.put(Entity.class, value -> new EntityMesh<>((Entity) value));

        // Living Entities
        entityClassMap.put(EntityLiving.class, value -> new EntityLivingMesh<>((EntityLiving) value));

        // Player Entities
        entityClassMap.put(EntityPlayer.class, value -> new EntityPlayerMesh<>((EntityPlayer) value));
        entityClassMap.put(AbstractClientPlayer.class, value -> new EntityAbstractClientPlayerMesh<>((AbstractClientPlayer) value));
        entityClassMap.put(EntityPlayerSP.class, value -> new EntityClientPlayerMesh<>((EntityPlayerSP) value));
        entityClassMap.put(EntityOtherPlayerMP.class, value -> new EntityOtherClientPlayerMesh<>((EntityOtherPlayerMP) value));
        entityClassMap.put(EntityPlayerMP.class, value -> new EntityServerPlayerMesh<>((EntityPlayerMP) value));

        entityClassMap.put(EntityCreature.class, value -> new EntityMobMesh<>((EntityCreature) value));

        // Hostile Mob Entities
        entityClassMap.put(EntityMob.class, value -> new EntityHostileMesh<>((EntityMob) value));
        entityClassMap.put(EntityBlaze.class, value -> new EntityBlazeMesh<>((EntityBlaze) value));
        entityClassMap.put(EntityCreeper.class, value -> new EntityCreeperMesh<>((EntityCreeper) value));
        entityClassMap.put(EntityEnderman.class, value -> new EntityEndermanMesh<>((EntityEnderman) value));
        entityClassMap.put(EntityEndermite.class, value -> new EntityEndermiteMesh<>((EntityEndermite) value));
        entityClassMap.put(EntityGiantZombie.class, value -> new EntityGiantMesh<>((EntityGiantZombie) value));
        entityClassMap.put(EntitySilverfish.class, value -> new EntitySilverfishMesh<>((EntitySilverfish) value));
        entityClassMap.put(EntityVex.class, value -> new EntityVexMesh<>((EntityVex) value));
        entityClassMap.put(EntityWither.class, value -> new EntityWitherMesh<>((EntityWither) value));

        entityClassMap.put(EntityZombie.class, value -> new EntityZombieMesh<>((EntityZombie) value));
        entityClassMap.put(EntityHusk.class, value -> new EntityHuskMesh<>((EntityHusk) value));
        entityClassMap.put(EntityPigZombie.class, value -> new EntityZombiePigmanMesh<>((EntityPigZombie) value));
        entityClassMap.put(EntityZombieVillager.class, value -> new EntityZombieVillagerMesh<>((EntityZombieVillager) value));

        entityClassMap.put(EntitySpider.class, value -> new EntitySpiderMesh<>((EntitySpider) value));
        entityClassMap.put(EntityCaveSpider.class, value -> new EntityCaveSpiderMesh<>((EntityCaveSpider) value));

        entityClassMap.put(AbstractSkeleton.class, value -> new EntitySkeletonAbstractMesh<>((AbstractSkeleton) value));
        entityClassMap.put(EntitySkeleton.class, value -> new EntitySkeletonMesh<>((EntitySkeleton) value));
        entityClassMap.put(EntityStray.class, value -> new EntityStrayMesh<>((EntityStray) value));
        entityClassMap.put(EntityWitherSkeleton.class, value -> new EntityWitherSkeletonMesh<>((EntityWitherSkeleton) value));

        entityClassMap.put(EntityEvoker.class, value -> new EntityEvokerMesh<>((EntityEvoker) value));
        entityClassMap.put(EntitySpellcasterIllager.class, value -> new EntityIllagerSpellcasterMesh<>((EntitySpellcasterIllager) value));
        entityClassMap.put(EntityIllusionIllager.class, value -> new EntityIllusionerMesh<>((EntityIllusionIllager) value));
        entityClassMap.put(AbstractIllager.class, value -> new EntityRaiderAbstractMesh<>((AbstractIllager) value));
        entityClassMap.put(EntityVindicator.class, value -> new EntityVindicatorMesh<>((EntityVindicator) value));
        entityClassMap.put(EntityWitch.class, value -> new EntityWitchMesh<>((EntityWitch) value));

        entityClassMap.put(EntityGuardian.class, value -> new EntityGuardianMesh<>((EntityGuardian) value));
        entityClassMap.put(EntityElderGuardian.class, value -> new EntityElderGuardianMesh<>((EntityElderGuardian) value));

        // Passive Entities
        entityClassMap.put(EntityAgeable.class, value -> new EntityPassiveMesh<>((EntityAgeable) value));
    }

    // ENTITY Type Map
    public static EntityType entityType(Entity entity) {
        return entityTypeMap.get(entity.getClass());
    }

    public static final Map<Class<? extends net.minecraft.entity.Entity>, EntityType> entityTypeMap;
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
}
