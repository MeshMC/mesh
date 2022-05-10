package net.meshmc.mesh.impl.util;

import net.meshmc.mesh.api.entity.EntityType;
import net.meshmc.mesh.impl.wrapper.entity.EntityMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.EntityLivingMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.EntityMobMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.*;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.guardian.EntityElderGuardianMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.guardian.EntityGuardianMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.piglin.EntityPiglinAbstractMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.piglin.EntityPiglinBruteMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.piglin.EntityPiglinMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.raider.*;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton.EntitySkeletonAbstractMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton.EntitySkeletonMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton.EntityStrayMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton.EntityWitherSkeletonMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.spider.EntityCaveSpiderMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.spider.EntitySpiderMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.zombie.*;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.EntityPassiveMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.player.*;
import net.meshmc.mesh.impl.wrapper.world.ClientWorldMesh;
import net.meshmc.mesh.impl.wrapper.world.WorldMesh;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

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
        worldClassMap.put(ClientWorld.class, value -> new ClientWorldMesh<>((ClientWorld) value));
        worldClassMap.put(ServerWorld.class, value -> new WorldMesh<>((ServerWorld) value));
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
        entityClassMap.put(LivingEntity.class, value -> new EntityLivingMesh<>((LivingEntity) value));

        // Player Entities
        entityClassMap.put(PlayerEntity.class, value -> new EntityPlayerMesh<>((PlayerEntity) value));
        entityClassMap.put(AbstractClientPlayerEntity.class, value -> new EntityAbstractClientPlayerMesh<>((AbstractClientPlayerEntity) value));
        entityClassMap.put(ClientPlayerEntity.class, value -> new EntityClientPlayerMesh<>((ClientPlayerEntity) value));
        entityClassMap.put(OtherClientPlayerEntity.class, value -> new EntityOtherClientPlayerMesh<>((OtherClientPlayerEntity) value));
        entityClassMap.put(ServerPlayerEntity.class, value -> new EntityServerPlayerMesh<>((ServerPlayerEntity) value));

        entityClassMap.put(PathAwareEntity.class, value -> new EntityMobMesh<>((PathAwareEntity) value));

        // Hostile Mob Entities
        entityClassMap.put(HostileEntity.class, value -> new EntityHostileMesh<>((HostileEntity) value));
        entityClassMap.put(BlazeEntity.class, value -> new EntityBlazeMesh<>((BlazeEntity) value));
        entityClassMap.put(CreeperEntity.class, value -> new EntityCreeperMesh<>((CreeperEntity) value));
        entityClassMap.put(EndermanEntity.class, value -> new EntityEndermanMesh<>((EndermanEntity) value));
        entityClassMap.put(EndermiteEntity.class, value -> new EntityEndermiteMesh<>((EndermiteEntity) value));
        entityClassMap.put(GiantEntity.class, value -> new EntityGiantMesh<>((GiantEntity) value));
        entityClassMap.put(SilverfishEntity.class, value -> new EntitySilverfishMesh<>((SilverfishEntity) value));
        entityClassMap.put(VexEntity.class, value -> new EntityVexMesh<>((VexEntity) value));
        entityClassMap.put(WitherEntity.class, value -> new EntityWitherMesh<>((WitherEntity) value));
        entityClassMap.put(ZoglinEntity.class, value -> new EntityZoglinMesh<>((ZoglinEntity) value));

        entityClassMap.put(ZombieEntity.class, value -> new EntityZombieMesh<>((ZombieEntity) value));
        entityClassMap.put(DrownedEntity.class, value -> new EntityDrownedMesh<>((DrownedEntity) value));
        entityClassMap.put(HuskEntity.class, value -> new EntityHuskMesh<>((HuskEntity) value));
        entityClassMap.put(ZombifiedPiglinEntity.class, value -> new EntityZombiePigmanMesh<>((ZombifiedPiglinEntity) value));
        entityClassMap.put(ZombieVillagerEntity.class, value -> new EntityZombieVillagerMesh<>((ZombieVillagerEntity) value));

        entityClassMap.put(SpiderEntity.class, value -> new EntitySpiderMesh<>((SpiderEntity) value));
        entityClassMap.put(CaveSpiderEntity.class, value -> new EntityCaveSpiderMesh<>((CaveSpiderEntity) value));

        entityClassMap.put(AbstractSkeletonEntity.class, value -> new EntitySkeletonAbstractMesh<>((AbstractSkeletonEntity) value));
        entityClassMap.put(SkeletonEntity.class, value -> new EntitySkeletonMesh<>((SkeletonEntity) value));
        entityClassMap.put(StrayEntity.class, value -> new EntityStrayMesh<>((StrayEntity) value));
        entityClassMap.put(WitherSkeletonEntity.class, value -> new EntityWitherSkeletonMesh<>((WitherSkeletonEntity) value));

        entityClassMap.put(EvokerEntity.class, value -> new EntityEvokerMesh<>((EvokerEntity) value));
        entityClassMap.put(SpellcastingIllagerEntity.class, value -> new EntityIllagerSpellcasterMesh<>((SpellcastingIllagerEntity) value));
        entityClassMap.put(IllusionerEntity.class, value -> new EntityIllusionerMesh<>((IllusionerEntity) value));
        entityClassMap.put(PillagerEntity.class, value -> new EntityPillagerMesh<>((PillagerEntity) value));
        entityClassMap.put(RaiderEntity.class, value -> new EntityRaiderAbstractMesh<>((RaiderEntity) value));
        entityClassMap.put(RavagerEntity.class, value -> new EntityRavagerMesh<>((RavagerEntity) value));
        entityClassMap.put(VindicatorEntity.class, value -> new EntityVindicatorMesh<>((VindicatorEntity) value));
        entityClassMap.put(WitchEntity.class, value -> new EntityWitchMesh<>((WitchEntity) value));

        entityClassMap.put(AbstractPiglinEntity.class, value -> new EntityPiglinAbstractMesh<>((AbstractPiglinEntity) value));
        entityClassMap.put(PiglinBruteEntity.class, value -> new EntityPiglinBruteMesh<>((PiglinBruteEntity) value));
        entityClassMap.put(PiglinEntity.class, value -> new EntityPiglinMesh<>((PiglinEntity) value));

        entityClassMap.put(GuardianEntity.class, value -> new EntityGuardianMesh<>((GuardianEntity) value));
        entityClassMap.put(ElderGuardianEntity.class, value -> new EntityElderGuardianMesh<>((ElderGuardianEntity) value));

        // Passive Entities
        entityClassMap.put(PassiveEntity.class, value -> new EntityPassiveMesh<>((PassiveEntity) value));
    }

    // ENTITY Type Map
    public static EntityType entityType(Entity entity) {
        return entityTypeMap.get(entity.getType());
    }

    public static final Map<net.minecraft.entity.EntityType<?>, EntityType> entityTypeMap = new LinkedHashMap<>();
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
}
