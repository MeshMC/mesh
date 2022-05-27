package net.meshmc.mesh.impl.util;

import net.meshmc.mesh.api.block.Block;
import net.meshmc.mesh.api.entity.EntityType;
import net.meshmc.mesh.impl.util.duck.BlockFenceGateDuck;
import net.meshmc.mesh.impl.util.duck.BlockGlazedTerracottaDuck;
import net.meshmc.mesh.impl.wrapper.entity.EntityMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.EntityLivingMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.EntityMobMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.*;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.guardian.EntityElderGuardianMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.guardian.EntityGuardianMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.raider.*;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton.EntitySkeletonAbstractMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton.EntitySkeletonMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton.EntityStrayMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton.EntityWitherSkeletonMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.spider.EntityCaveSpiderMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.spider.EntitySpiderMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.zombie.EntityHuskMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.zombie.EntityZombieMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.zombie.EntityZombiePigmanMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.zombie.EntityZombieVillagerMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.EntityPassiveMesh;
import net.meshmc.mesh.impl.wrapper.entity.living.player.*;
import net.meshmc.mesh.impl.wrapper.world.ClientWorldMesh;
import net.meshmc.mesh.impl.wrapper.world.WorldMesh;
import net.meshmc.mesh.util.block.BlockVariant;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import javax.annotation.Nullable;
import java.util.HashMap;
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

    public static final Map<Class<? extends World>, CreationWrapper> worldClassMap;
    static {
        worldClassMap = new HashMap<>();

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

    public static final Map<Class<? extends Entity>, CreationWrapper> entityClassMap;
    static {
        entityClassMap = new HashMap<>();

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
        entityTypeMap = new HashMap<>();

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

    // Block Map
    public static Block block(net.minecraft.block.Block block) {
        return blockMap.get(block);
    }

    private static final Map<net.minecraft.block.Block, Block> blockMap;
    static {
        blockMap = new HashMap<>();

        blockMap.put(Blocks.AIR, Block.AIR);
        blockMap.put(Blocks.STONE, Block.STONE);
        blockMap.put(Blocks.GRASS, Block.DIRT);
        blockMap.put(Blocks.DIRT, Block.DIRT);
        blockMap.put(Blocks.COBBLESTONE, Block.COBBLESTONE);
        blockMap.put(Blocks.PLANKS, Block.WOOD_PLANKS);
        blockMap.put(Blocks.SAPLING, Block.WOOD_SAPLING);
        blockMap.put(Blocks.BEDROCK, Block.BEDROCK);
        blockMap.put(Blocks.WATER, Block.WATER);
        blockMap.put(Blocks.LAVA, Block.LAVA);
        blockMap.put(Blocks.SAND, Block.SAND);
        blockMap.put(Blocks.GRAVEL, Block.GRAVEL);
        blockMap.put(Blocks.GOLD_ORE, Block.GOLD_ORE);
        blockMap.put(Blocks.IRON_ORE, Block.IRON_ORE);
        blockMap.put(Blocks.COAL_ORE, Block.COAL_ORE);
        blockMap.put(Blocks.LOG, Block.WOOD_LOG);
        blockMap.put(Blocks.LOG2, Block.WOOD_LOG);
        blockMap.put(Blocks.LEAVES, Block.LEAVES);
        blockMap.put(Blocks.LEAVES2, Block.LEAVES);
        blockMap.put(Blocks.SPONGE, Block.SPONGE);
        blockMap.put(Blocks.GLASS, Block.GLASS);
        blockMap.put(Blocks.LAPIS_ORE, Block.LAPIS_ORE);
        blockMap.put(Blocks.LAPIS_BLOCK, Block.LAPIS_BLOCK);
        blockMap.put(Blocks.DISPENSER, Block.DISPENSER);
        blockMap.put(Blocks.SANDSTONE, Block.SANDSTONE);
        blockMap.put(Blocks.NOTEBLOCK, Block.NOTE_BLOCK);
        blockMap.put(Blocks.BED, Block.BED);
        blockMap.put(Blocks.GOLDEN_RAIL, Block.POWERED_RAIL);
        blockMap.put(Blocks.DETECTOR_RAIL, Block.DETECTOR_RAIL);
        blockMap.put(Blocks.STICKY_PISTON, Block.STICKY_PISTON);
        blockMap.put(Blocks.WEB, Block.COBWEB);
        blockMap.put(Blocks.TALLGRASS, Block.GRASS);
        blockMap.put(Blocks.DEADBUSH, Block.GRASS);
        blockMap.put(Blocks.PISTON, Block.PISTON);
        blockMap.put(Blocks.PISTON_HEAD, Block.PISTON_HEAD);
        blockMap.put(Blocks.WOOL, Block.WOOL);
        blockMap.put(Blocks.PISTON_EXTENSION, Block.MOVING_PISTON);
        blockMap.put(Blocks.YELLOW_FLOWER, Block.FLOWER);
        blockMap.put(Blocks.RED_FLOWER, Block.FLOWER);
        blockMap.put(Blocks.BROWN_MUSHROOM, Block.BROWN_MUSHROOM);
        blockMap.put(Blocks.RED_MUSHROOM, Block.RED_MUSHROOM);
        blockMap.put(Blocks.GOLD_BLOCK, Block.GOLD_BLOCK);
        blockMap.put(Blocks.IRON_BLOCK, Block.IRON_BLOCK);
        blockMap.put(Blocks.BRICK_BLOCK, Block.BRICKS);
        blockMap.put(Blocks.TNT, Block.TNT);
        blockMap.put(Blocks.BOOKSHELF, Block.BOOKSHELF);
        blockMap.put(Blocks.MOSSY_COBBLESTONE, Block.MOSSY_COBBLESTONE);
        blockMap.put(Blocks.OBSIDIAN, Block.OBSIDIAN);
        blockMap.put(Blocks.TORCH, Block.TORCH);
        blockMap.put(Blocks.FIRE, Block.FIRE);
        blockMap.put(Blocks.MOB_SPAWNER, Block.SPAWNER);
        blockMap.put(Blocks.OAK_STAIRS, Block.WOOD_STAIRS);
        blockMap.put(Blocks.CHEST, Block.CHEST);
        blockMap.put(Blocks.REDSTONE_WIRE, Block.REDSTONE_WIRE);
        blockMap.put(Blocks.DIAMOND_ORE, Block.DIAMOND_ORE);
        blockMap.put(Blocks.DIAMOND_BLOCK, Block.DIAMOND_BLOCK);
        blockMap.put(Blocks.CRAFTING_TABLE, Block.CRAFTING_TABLE);
        blockMap.put(Blocks.WHEAT, Block.WHEAT);
        blockMap.put(Blocks.FARMLAND, Block.FARMLAND);
        blockMap.put(Blocks.FURNACE, Block.FURNACE);
        blockMap.put(Blocks.STANDING_SIGN, Block.WOOD_SIGN);
        blockMap.put(Blocks.OAK_DOOR, Block.WOOD_DOOR);
        blockMap.put(Blocks.LADDER, Block.LADDER);
        blockMap.put(Blocks.RAIL, Block.RAIL);
        blockMap.put(Blocks.STONE_STAIRS, Block.COBBLESTONE_STAIRS);
        blockMap.put(Blocks.WALL_SIGN, Block.WOOD_WALL_SIGN);
        blockMap.put(Blocks.LEVER, Block.LEVER);
        blockMap.put(Blocks.STONE_PRESSURE_PLATE, Block.STONE_PRESSURE_PLATE);
        blockMap.put(Blocks.IRON_DOOR, Block.IRON_DOOR);
        blockMap.put(Blocks.WOODEN_PRESSURE_PLATE, Block.WOOD_PRESSURE_PLATE);
        blockMap.put(Blocks.REDSTONE_ORE, Block.REDSTONE_ORE);
        blockMap.put(Blocks.REDSTONE_TORCH, Block.REDSTONE_TORCH);
        blockMap.put(Blocks.STONE_BUTTON, Block.STONE_BUTTON);
        blockMap.put(Blocks.SNOW_LAYER, Block.SNOW);
        blockMap.put(Blocks.ICE, Block.ICE);
        blockMap.put(Blocks.SNOW, Block.SNOW_BLOCK);
        blockMap.put(Blocks.CACTUS, Block.CACTUS);
        blockMap.put(Blocks.CLAY, Block.CLAY);
        blockMap.put(Blocks.REEDS, Block.SUGAR_CANE);
        blockMap.put(Blocks.JUKEBOX, Block.JUKEBOX);
        blockMap.put(Blocks.OAK_FENCE, Block.WOOD_FENCE);
        blockMap.put(Blocks.PUMPKIN, Block.PUMPKIN);
        blockMap.put(Blocks.NETHERRACK, Block.NETHERRACK);
        blockMap.put(Blocks.SOUL_SAND, Block.SOUL_SAND);
        blockMap.put(Blocks.GLOWSTONE, Block.GLOWSTONE);
        blockMap.put(Blocks.PORTAL, Block.NETHER_PORTAL);
        blockMap.put(Blocks.LIT_PUMPKIN, Block.JACK_O_LANTERN);
        blockMap.put(Blocks.CAKE, Block.CAKE);
        blockMap.put(Blocks.POWERED_REPEATER, Block.REPEATER);
        blockMap.put(Blocks.UNPOWERED_REPEATER, Block.REPEATER);
        blockMap.put(Blocks.STAINED_GLASS, Block.STAINED_GLASS);
        blockMap.put(Blocks.TRAPDOOR, Block.WOOD_TRAPDOOR);
        blockMap.put(Blocks.STONEBRICK, Block.STONE_BRICKS);
        blockMap.put(Blocks.MONSTER_EGG, Block.INFESTED_STONE);
        blockMap.put(Blocks.BROWN_MUSHROOM_BLOCK, Block.MUSHROOM_BLOCK);
        blockMap.put(Blocks.RED_MUSHROOM_BLOCK, Block.MUSHROOM_BLOCK);
        blockMap.put(Blocks.IRON_BARS, Block.IRON_BARS);
        blockMap.put(Blocks.GLASS_PANE, Block.GLASS_PANE);
        blockMap.put(Blocks.MELON_BLOCK, Block.MELON);
        blockMap.put(Blocks.PUMPKIN_STEM, Block.PUMPKIN_STEM);
        blockMap.put(Blocks.MELON_STEM, Block.MELON_STEM);
        blockMap.put(Blocks.VINE, Block.VINE);
        blockMap.put(Blocks.OAK_FENCE_GATE, Block.WOOD_FENCE_GATE);
        blockMap.put(Blocks.BRICK_STAIRS, Block.BRICK_STAIRS);
        blockMap.put(Blocks.STONE_BRICK_STAIRS, Block.STONE_BRICK_STAIRS);
        blockMap.put(Blocks.MYCELIUM, Block.DIRT);
        blockMap.put(Blocks.WATERLILY, Block.LILY_PAD);
        blockMap.put(Blocks.NETHER_BRICK, Block.NETHER_BRICKS);
        blockMap.put(Blocks.NETHER_BRICK_FENCE, Block.NETHER_BRICK_FENCE);
        blockMap.put(Blocks.NETHER_BRICK_STAIRS, Block.NETHER_BRICK_STAIRS);
        blockMap.put(Blocks.NETHER_WART, Block.NETHER_WART);
        blockMap.put(Blocks.ENCHANTING_TABLE, Block.ENCHANTING_TABLE);
        blockMap.put(Blocks.BREWING_STAND, Block.BREWING_STAND);
        blockMap.put(Blocks.CAULDRON, Block.CAULDRON);
        blockMap.put(Blocks.END_PORTAL, Block.END_PORTAL);
        blockMap.put(Blocks.END_PORTAL_FRAME, Block.END_PORTAL_FRAME);
        blockMap.put(Blocks.END_STONE, Block.END_STONE);
        blockMap.put(Blocks.DRAGON_EGG, Block.DRAGON_EGG);
        blockMap.put(Blocks.REDSTONE_LAMP, Block.REDSTONE_LAMP);
        blockMap.put(Blocks.COCOA, Block.COCOA);
        blockMap.put(Blocks.SANDSTONE_STAIRS, Block.SANDSTONE_STAIRS);
        blockMap.put(Blocks.EMERALD_ORE, Block.EMERALD_ORE);
        blockMap.put(Blocks.ENDER_CHEST, Block.ENDER_CHEST);
        blockMap.put(Blocks.TRIPWIRE_HOOK, Block.TRIPWIRE_HOOK);
        blockMap.put(Blocks.TRIPWIRE, Block.TRIPWIRE);
        blockMap.put(Blocks.EMERALD_BLOCK, Block.EMERALD_BLOCK);
        blockMap.put(Blocks.SPRUCE_STAIRS, Block.WOOD_STAIRS);
        blockMap.put(Blocks.BIRCH_STAIRS, Block.WOOD_STAIRS);
        blockMap.put(Blocks.JUNGLE_STAIRS, Block.WOOD_STAIRS);
        blockMap.put(Blocks.COMMAND_BLOCK, Block.COMMAND_BLOCK);
        blockMap.put(Blocks.BEACON, Block.BEACON);
        blockMap.put(Blocks.COBBLESTONE_WALL, Block.COBBLESTONE_WALL);
        blockMap.put(Blocks.FLOWER_POT, Block.FLOWER_POT);
        blockMap.put(Blocks.CARROTS, Block.CARROTS);
        blockMap.put(Blocks.POTATOES, Block.POTATOES);
        blockMap.put(Blocks.WOODEN_BUTTON, Block.WOOD_BUTTON);
        blockMap.put(Blocks.SKULL, Block.SKULL);
        blockMap.put(Blocks.ANVIL, Block.ANVIL);
        blockMap.put(Blocks.TRAPPED_CHEST, Block.TRAPPED_CHEST);
        blockMap.put(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, Block.LIGHT_WEIGHTED_PRESSURE_PLATE);
        blockMap.put(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, Block.HEAVY_WEIGHTED_PRESSURE_PLATE);
        blockMap.put(Blocks.POWERED_COMPARATOR, Block.COMPARATOR);
        blockMap.put(Blocks.UNPOWERED_COMPARATOR, Block.COMPARATOR);
        blockMap.put(Blocks.DAYLIGHT_DETECTOR, Block.DAYLIGHT_DETECTOR);
        blockMap.put(Blocks.REDSTONE_BLOCK, Block.REDSTONE_BLOCK);
        blockMap.put(Blocks.QUARTZ_ORE, Block.NETHER_QUARTZ_ORE);
        blockMap.put(Blocks.HOPPER, Block.HOPPER);
        blockMap.put(Blocks.QUARTZ_BLOCK, Block.QUARTZ);
        blockMap.put(Blocks.QUARTZ_STAIRS, Block.QUARTZ_STAIRS);
        blockMap.put(Blocks.ACTIVATOR_RAIL, Block.ACTIVATOR_RAIL);
        blockMap.put(Blocks.DROPPER, Block.DROPPER);
        blockMap.put(Blocks.STAINED_HARDENED_CLAY, Block.STAINED_TERRACOTTA);
        blockMap.put(Blocks.STAINED_GLASS_PANE, Block.STAINED_GLASS_PANE);
        blockMap.put(Blocks.ACACIA_STAIRS, Block.WOOD_STAIRS);
        blockMap.put(Blocks.DARK_OAK_STAIRS, Block.WOOD_STAIRS);
        blockMap.put(Blocks.SLIME_BLOCK, Block.SLIME_BLOCK);
        blockMap.put(Blocks.BARRIER, Block.BARRIER);
        blockMap.put(Blocks.IRON_TRAPDOOR, Block.IRON_TRAPDOOR);
        blockMap.put(Blocks.PRISMARINE, Block.PRISMARINE);
        blockMap.put(Blocks.SEA_LANTERN, Block.SEA_LANTERN);
        blockMap.put(Blocks.HAY_BLOCK, Block.HAY_BLOCK);
        blockMap.put(Blocks.CARPET, Block.CARPET);
        blockMap.put(Blocks.HARDENED_CLAY, Block.TERRACOTTA);
        blockMap.put(Blocks.COAL_BLOCK, Block.COAL_BLOCK);
        blockMap.put(Blocks.PACKED_ICE, Block.PACKED_ICE);
        blockMap.put(Blocks.DOUBLE_PLANT, Block.DOUBLE_PLANT);
        blockMap.put(Blocks.STANDING_BANNER, Block.STANDING_BANNER);
        blockMap.put(Blocks.WALL_BANNER, Block.WALL_BANNER);
        blockMap.put(Blocks.RED_SANDSTONE, Block.RED_SANDSTONE);
        blockMap.put(Blocks.RED_SANDSTONE_STAIRS, Block.RED_SANDSTONE_STAIRS);
        blockMap.put(Blocks.WOODEN_SLAB, Block.WOOD_SLAB);
        blockMap.put(Blocks.DOUBLE_WOODEN_SLAB, Block.WOOD_SLAB);
        blockMap.put(Blocks.STONE_SLAB, Block.STONE_SLAB);
        blockMap.put(Blocks.DOUBLE_STONE_SLAB, Block.STONE_SLAB);
        blockMap.put(Blocks.STONE_SLAB2, Block.STONE_SLAB);
        blockMap.put(Blocks.DOUBLE_STONE_SLAB2, Block.STONE_SLAB);
        blockMap.put(Blocks.PURPUR_SLAB, Block.STONE_SLAB);
        blockMap.put(Blocks.PURPUR_DOUBLE_SLAB, Block.STONE_SLAB);
        blockMap.put(Blocks.SPRUCE_FENCE_GATE, Block.WOOD_FENCE_GATE);
        blockMap.put(Blocks.BIRCH_FENCE_GATE, Block.WOOD_FENCE_GATE);
        blockMap.put(Blocks.JUNGLE_FENCE_GATE, Block.WOOD_FENCE_GATE);
        blockMap.put(Blocks.ACACIA_FENCE_GATE, Block.WOOD_FENCE_GATE);
        blockMap.put(Blocks.DARK_OAK_FENCE_GATE, Block.WOOD_FENCE_GATE);
        blockMap.put(Blocks.SPRUCE_FENCE, Block.WOOD_FENCE);
        blockMap.put(Blocks.BIRCH_FENCE, Block.WOOD_FENCE);
        blockMap.put(Blocks.JUNGLE_FENCE, Block.WOOD_FENCE);
        blockMap.put(Blocks.ACACIA_FENCE, Block.WOOD_FENCE);
        blockMap.put(Blocks.DARK_OAK_FENCE, Block.WOOD_FENCE);
        blockMap.put(Blocks.SPRUCE_DOOR, Block.WOOD_DOOR);
        blockMap.put(Blocks.BIRCH_DOOR, Block.WOOD_DOOR);
        blockMap.put(Blocks.JUNGLE_DOOR, Block.WOOD_DOOR);
        blockMap.put(Blocks.ACACIA_DOOR, Block.WOOD_DOOR);
        blockMap.put(Blocks.DARK_OAK_DOOR, Block.WOOD_DOOR);
        blockMap.put(Blocks.END_ROD, Block.END_ROD);
        blockMap.put(Blocks.CHORUS_PLANT, Block.CHORUS_PLANT);
        blockMap.put(Blocks.CHORUS_FLOWER, Block.CHORUS_FLOWER);
        blockMap.put(Blocks.PURPUR_BLOCK, Block.PURPUR_BLOCK);
        blockMap.put(Blocks.PURPUR_PILLAR, Block.PURPUR_PILLAR);
        blockMap.put(Blocks.PURPUR_STAIRS, Block.PURPUR_STAIRS);
        blockMap.put(Blocks.END_BRICKS, Block.END_STONE_BRICKS);
        blockMap.put(Blocks.BEETROOTS, Block.BEETROOTS);
        blockMap.put(Blocks.GRASS_PATH, Block.DIRT_PATH);
        blockMap.put(Blocks.END_GATEWAY, Block.END_GATEWAY);
        blockMap.put(Blocks.REPEATING_COMMAND_BLOCK, Block.REPEATING_COMMAND_BLOCK);
        blockMap.put(Blocks.CHAIN_COMMAND_BLOCK, Block.CHAIN_COMMAND_BLOCK);
        blockMap.put(Blocks.FROSTED_ICE, Block.FROSTED_ICE);
        blockMap.put(Blocks.MAGMA, Block.MAGMA_BLOCK);
        blockMap.put(Blocks.NETHER_WART_BLOCK, Block.NETHER_WART_BLOCK);
        blockMap.put(Blocks.RED_NETHER_BRICK, Block.RED_NETHER_BRICKS);
        blockMap.put(Blocks.BONE_BLOCK, Block.BONE_BLOCK);
        blockMap.put(Blocks.STRUCTURE_VOID, Block.STRUCTURE_VOID);
        blockMap.put(Blocks.OBSERVER, Block.OBSERVER);
//        blockMap.put(Blocks.SHULKER_BOX, Block.SHULKER_BOX); //default is purple in 1.12, purple in 1.18 is slightly different colored
        blockMap.put(Blocks.WHITE_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.ORANGE_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.MAGENTA_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.LIGHT_BLUE_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.YELLOW_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.LIME_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.PINK_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.GRAY_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.SILVER_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.CYAN_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.PURPLE_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.BLUE_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.BROWN_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.GREEN_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.RED_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.BLACK_SHULKER_BOX, Block.SHULKER_BOX);
        blockMap.put(Blocks.WHITE_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.ORANGE_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.MAGENTA_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.YELLOW_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.LIME_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.PINK_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.GRAY_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.SILVER_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.CYAN_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.PURPLE_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.BLUE_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.BROWN_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.GREEN_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.RED_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.BLACK_GLAZED_TERRACOTTA, Block.GLAZED_TERRACOTTA);
        blockMap.put(Blocks.CONCRETE, Block.CONCRETE);
        blockMap.put(Blocks.CONCRETE_POWDER, Block.CONCRETE_POWDER);
        blockMap.put(Blocks.STRUCTURE_BLOCK, Block.STRUCTURE_BLOCK);
    }

    // BLOCK Variant
    private static final BlockVariant.Wood[] WOODS = BlockVariant.Wood.values();
    private static final BlockVariant.Flower[] FLOWERS = BlockVariant.Flower.values();
    private static final BlockVariant.Sandstone[] SANDSTONES = BlockVariant.Sandstone.values();
    private static final BlockVariant.Grass[] GRASSES = BlockVariant.Grass.values();
    private static final BlockVariant.StoneBricks[] STONE_BRICKS = BlockVariant.StoneBricks.values();
    private static final BlockVariant.InfestedStone[] INFESTED_STONES = BlockVariant.InfestedStone.values();
    private static final BlockVariant.PotContents[] POT_CONTENTS = BlockVariant.PotContents.values();
    private static final BlockVariant.Anvil[] ANVILS = BlockVariant.Anvil.values();
    private static final BlockVariant.Prismarine[] PRISMARINES = BlockVariant.Prismarine.values();
    private static final BlockVariant.DoublePlant[] DOUBLE_PLANTS = BlockVariant.DoublePlant.values();

    @Nullable
    public static Enum<?> blockVariant(Block block, IBlockState blockState) {
        if(!blockVariantMap.containsKey(block)) return null;
        return blockVariantMap.get(block).wrap(blockState);
    }

    private static final Map<Block, CreationWrapper<IBlockState, Enum<?>>> blockVariantMap;
    static {
        blockVariantMap = new HashMap<>();

        blockVariantMap.put(Block.STONE, state -> {
            switch(state.getValue(BlockStone.VARIANT)) {
                case GRANITE: return BlockVariant.Stone.GRANITE;
                case GRANITE_SMOOTH: return BlockVariant.Stone.POLISHED_GRANITE;
                case DIORITE: return BlockVariant.Stone.DIORITE;
                case DIORITE_SMOOTH: return BlockVariant.Stone.POLISHED_DIORITE;
                case ANDESITE: return BlockVariant.Stone.ANDESITE;
                case ANDESITE_SMOOTH: return BlockVariant.Stone.POLISHED_ANDESITE;
                default: return BlockVariant.Stone.STONE;
            }
        });
        blockVariantMap.put(Block.DIRT, state -> {
            if(state.getBlock() == Blocks.GRASS) return BlockVariant.Dirt.GRASS;
            if(state.getBlock() == Blocks.MYCELIUM) return BlockVariant.Dirt.MYCELIUM;
            switch(state.getValue(BlockDirt.VARIANT)) {
                case PODZOL: return BlockVariant.Dirt.PODZOL;
                case COARSE_DIRT: return BlockVariant.Dirt.COARSE_DIRT;
                default: return BlockVariant.Dirt.DIRT;
            }
        });
        blockVariantMap.put(Block.WOOD_PLANKS, state -> WOODS[state.getValue(BlockPlanks.VARIANT).ordinal()]);
        blockVariantMap.put(Block.WOOD_SAPLING, state -> WOODS[state.getValue(BlockSapling.TYPE).ordinal()]);
        blockVariantMap.put(Block.SAND, state -> {
            if(state.getValue(BlockSand.VARIANT) == BlockSand.EnumType.SAND) return BlockVariant.Sand.YELLOW;
            return BlockVariant.Sand.RED;
        });
        blockVariantMap.put(Block.WOOD_LOG, state -> {
            if(state.getBlock() instanceof BlockNewLog) {
                if(state.getValue(BlockNewLog.VARIANT) == BlockPlanks.EnumType.ACACIA) return BlockVariant.Wood.ACACIA;
                if(state.getValue(BlockNewLog.VARIANT) == BlockPlanks.EnumType.DARK_OAK) return BlockVariant.Wood.DARK_OAK;
            }
            switch(state.getValue(BlockOldLog.VARIANT)) {
                case SPRUCE: return BlockVariant.Wood.SPRUCE;
                case BIRCH: return BlockVariant.Wood.BIRCH;
                case JUNGLE: return BlockVariant.Wood.JUNGLE;
                default: return BlockVariant.Wood.OAK;
            }
        });
        blockVariantMap.put(Block.LEAVES, state -> {
            if(state.getBlock() instanceof BlockNewLeaf) {
                if(state.getValue(BlockNewLeaf.VARIANT) == BlockPlanks.EnumType.ACACIA) return BlockVariant.Leaves.ACACIA;
                if(state.getValue(BlockNewLeaf.VARIANT) == BlockPlanks.EnumType.DARK_OAK) return BlockVariant.Leaves.DARK_OAK;
            }
            switch(state.getValue(BlockOldLeaf.VARIANT)) {
                case SPRUCE: return BlockVariant.Leaves.SPRUCE;
                case BIRCH: return BlockVariant.Leaves.BIRCH;
                case JUNGLE: return BlockVariant.Leaves.JUNGLE;
                default: return BlockVariant.Leaves.OAK;
            }
        });
        blockVariantMap.put(Block.SANDSTONE, state -> SANDSTONES[state.getValue(BlockSandStone.TYPE).ordinal()]);
        blockVariantMap.put(Block.GRASS, state -> GRASSES[state.getValue(BlockTallGrass.TYPE).ordinal()]);
        blockVariantMap.put(Block.WOOL, state -> MeshEnum.dyeColor(state.getValue(BlockColored.COLOR)));
        blockVariantMap.put(Block.FLOWER, state -> FLOWERS[state.getValue(((BlockFlower) state.getBlock()).getTypeProperty()).ordinal()]);
        blockVariantMap.put(Block.WOOD_STAIRS, state -> WOODS[state.getValue(BlockPlanks.VARIANT).ordinal()]);
        blockVariantMap.put(Block.STAINED_GLASS, state -> MeshEnum.dyeColor(state.getValue(BlockStainedGlass.COLOR)));
        blockVariantMap.put(Block.WOOD_SIGN, state -> BlockVariant.Wood.OAK);
        blockVariantMap.put(Block.WOOD_WALL_SIGN, state -> BlockVariant.Wood.OAK);
        blockVariantMap.put(Block.WOOD_PRESSURE_PLATE, state -> BlockVariant.Wood.OAK);
        blockVariantMap.put(Block.WOOD_TRAPDOOR, state -> BlockVariant.Wood.OAK);
        blockVariantMap.put(Block.STONE_BRICKS, state -> STONE_BRICKS[state.getValue(BlockStoneBrick.VARIANT).ordinal()]);
        blockVariantMap.put(Block.INFESTED_STONE, state -> INFESTED_STONES[state.getValue(BlockSilverfish.VARIANT).ordinal()]);
        blockVariantMap.put(Block.MUSHROOM_BLOCK, state -> {
            switch(state.getValue(BlockHugeMushroom.VARIANT)) {
                case STEM:
                case ALL_STEM:
                    return BlockVariant.MushroomBlock.STEM;
                default:
                    if(state.getBlock() == Blocks.RED_MUSHROOM_BLOCK) return BlockVariant.MushroomBlock.RED;
                    return BlockVariant.MushroomBlock.BROWN;
            }
        });
        blockVariantMap.put(Block.CAULDRON, state -> {
            if(state.getValue(BlockCauldron.LEVEL) > 0) return BlockVariant.CauldronContents.WATER;
            else return BlockVariant.CauldronContents.EMPTY;
        });
        blockVariantMap.put(Block.COBBLESTONE_WALL, state -> {
            if(state.getValue(BlockWall.VARIANT) == BlockWall.EnumType.MOSSY) return BlockVariant.CobblestoneWall.MOSSY_COBBLESTONE;
            return BlockVariant.CobblestoneWall.COBBLESTONE;
        });
        blockVariantMap.put(Block.FLOWER_POT, state -> POT_CONTENTS[state.getValue(BlockFlowerPot.CONTENTS).ordinal()]);
        blockVariantMap.put(Block.WOOD_BUTTON, state -> BlockVariant.Wood.OAK);
        blockVariantMap.put(Block.ANVIL, state -> ANVILS[state.getValue(BlockAnvil.DAMAGE)]);
        blockVariantMap.put(Block.QUARTZ, state -> {
            switch(state.getValue(BlockQuartz.VARIANT)) {
                case DEFAULT: return BlockVariant.Quartz.BLOCK;
                case CHISELED: return BlockVariant.Quartz.CHISELED;
                default: return BlockVariant.Quartz.PILLAR;
            }
        });
        blockVariantMap.put(Block.STAINED_TERRACOTTA, state -> MeshEnum.dyeColor(state.getValue(BlockColored.COLOR)));
        blockVariantMap.put(Block.STAINED_GLASS_PANE, state -> MeshEnum.dyeColor(state.getValue(BlockColored.COLOR)));
        blockVariantMap.put(Block.PRISMARINE, state -> PRISMARINES[state.getValue(BlockPrismarine.VARIANT).ordinal()]);
        blockVariantMap.put(Block.CARPET, state -> MeshEnum.dyeColor(state.getValue(BlockCarpet.COLOR)));
        blockVariantMap.put(Block.DOUBLE_PLANT, state -> DOUBLE_PLANTS[state.getValue(BlockDoublePlant.VARIANT).ordinal()]);
        blockVariantMap.put(Block.RED_SANDSTONE, state -> SANDSTONES[state.getValue(BlockRedSandstone.TYPE).ordinal()]);
        blockVariantMap.put(Block.WOOD_SLAB, state -> WOODS[state.getValue(BlockWoodSlab.VARIANT).ordinal()]);
        blockVariantMap.put(Block.STONE_SLAB, state -> {
            if(state.getBlock() instanceof BlockStoneSlabNew) return BlockVariant.StoneSlab.RED_SANDSTONE;
            if(state.getBlock() instanceof BlockPurpurSlab) return BlockVariant.StoneSlab.PURPUR;
            switch(state.getValue(BlockStoneSlab.VARIANT)) {
                case SAND: return BlockVariant.StoneSlab.SANDSTONE;
                case WOOD: return BlockVariant.StoneSlab.PETRIFIED_OAK;
                case COBBLESTONE: return BlockVariant.StoneSlab.COBBLESTONE;
                case BRICK: return BlockVariant.StoneSlab.BRICK;
                case SMOOTHBRICK: return BlockVariant.StoneSlab.STONE_BRICK;
                case NETHERBRICK: return BlockVariant.StoneSlab.NETHER_BRICK;
                case QUARTZ: return BlockVariant.StoneSlab.QUARTZ;
                default: return BlockVariant.StoneSlab.SMOOTH_STONE;
            }
        });
        blockVariantMap.put(Block.WOOD_FENCE_GATE, state -> WOODS[((BlockFenceGateDuck) state.getBlock()).getWoodType().ordinal()]);
        blockVariantMap.put(Block.WOOD_FENCE, state -> {
            if(state.getBlock() == Blocks.OAK_FENCE) return BlockVariant.Wood.OAK;
            if(state.getBlock() == Blocks.SPRUCE_FENCE) return BlockVariant.Wood.SPRUCE;
            if(state.getBlock() == Blocks.BIRCH_FENCE) return BlockVariant.Wood.BIRCH;
            if(state.getBlock() == Blocks.JUNGLE_FENCE) return BlockVariant.Wood.JUNGLE;
            if(state.getBlock() == Blocks.ACACIA_FENCE) return BlockVariant.Wood.ACACIA;
            return BlockVariant.Wood.DARK_OAK;
        });
        blockVariantMap.put(Block.WOOD_DOOR, state -> {
            if(state.getBlock() == Blocks.OAK_DOOR) return BlockVariant.Wood.OAK;
            if(state.getBlock() == Blocks.SPRUCE_DOOR) return BlockVariant.Wood.SPRUCE;
            if(state.getBlock() == Blocks.BIRCH_DOOR) return BlockVariant.Wood.BIRCH;
            if(state.getBlock() == Blocks.JUNGLE_DOOR) return BlockVariant.Wood.JUNGLE;
            if(state.getBlock() == Blocks.ACACIA_DOOR) return BlockVariant.Wood.ACACIA;
            return BlockVariant.Wood.DARK_OAK;
        });
        blockVariantMap.put(Block.SHULKER_BOX, state -> MeshEnum.dyeColor(BlockShulkerBox.getColorFromBlock(state.getBlock())));
        blockVariantMap.put(Block.GLAZED_TERRACOTTA, state -> MeshEnum.dyeColor(((BlockGlazedTerracottaDuck) state.getBlock()).getColor()));
        blockVariantMap.put(Block.CONCRETE, state -> MeshEnum.dyeColor(state.getValue(BlockColored.COLOR)));
        blockVariantMap.put(Block.CONCRETE_POWDER, state -> MeshEnum.dyeColor(state.getValue(BlockConcretePowder.COLOR)));
    }
}
