package net.meshmc.mesh.api.block;

/**
 * @author Makrennel 23/04/2022
 * All possible block values
 *
 * TODO: make utils for blocks with multiple states
 * TODO: attach properties to blocks
 * TODO: a method for custom block creation?
 */
public class Block {
    public static final Block
    AIR = new Block(),
    /** Variants of type "Stone"*/
    STONE = new Block(),
    /** Variants of type "Dirt"*/
    DIRT = new Block(),
            COBBLESTONE = new Block(),
    /** Variants of type "Wood"*/
    WOOD_PLANKS = new Block(),
    /** Variants of type "Sand"*/
    WOOD_SAPLING = new Block(),
            BEDROCK = new Block(),
            WATER = new Block(),
            LAVA = new Block(),
    /** Variants of type "Sand"*/
    SAND = new Block(),
            GRAVEL = new Block(),
            GOLD_ORE = new Block(),
            DEEPSLATE_GOLD_ORE = new Block(),
            IRON_ORE = new Block(),
            DEEPSLATE_IRON_ORE = new Block(),
            COAL_ORE = new Block(),
            DEEPSLATE_COAL_ORE = new Block(),
            NETHER_GOLD_ORE = new Block(),
    /** Variants of type "Wood"*/
    WOOD_LOG = new Block(),
    /** Variants of type "Wood"*/
    STRIPPED_WOOD_LOG = new Block(),
    /** Variants of type "Wood"*/
    WOOD_BLOCK = new Block(),
    /** Variants of type "Wood"*/
    STRIPPED_WOOD_BLOCK = new Block(),
    /** Variants of type "Leaves"*/
    LEAVES = new Block(),
            SPONGE = new Block(),
            GLASS = new Block(),
            LAPIS_ORE = new Block(),
            DEEPSLATE_LAPIS_ORE = new Block(),
            LAPIS_BLOCK = new Block(),
            DISPENSER = new Block(),
    /** Variants of type "Sandstone"*/
    SANDSTONE = new Block(),
            NOTE_BLOCK = new Block(),
            BED = new Block(), //TODO: BedUtil
            POWERED_RAIL = new Block(),
            DETECTOR_RAIL = new Block(),
            STICKY_PISTON = new Block(),
            COBWEB = new Block(),
            GRASS = new Block(),
            FERN = new Block(),
            DEAD_BUSH = new Block(),
            SEAGRASS = new Block(),
            TALL_SEAGRASS = new Block(),
            PISTON = new Block(),
            PISTON_HEAD = new Block(),
    /** Variants of type "DyeColor"*/
    WOOL = new Block(),
            MOVING_PISTON = new Block(),
    /** Variants of type "Flower"*/
    FLOWER = new Block(),
            BROWN_MUSHROOM = new Block(),
            RED_MUSHROOM = new Block(),
            GOLD_BLOCK = new Block(),
            IRON_BLOCK = new Block(),
            BRICKS = new Block(),
            TNT = new Block(),
            BOOKSHELF = new Block(),
            MOSSY_COBBLESTONE = new Block(),
            OBSIDIAN = new Block(),
            TORCH = new Block(), //TODO: TorchUtils
            FIRE = new Block(),
            SOUL_FIRE = new Block(),
            SPAWNER = new Block(),
    /** Variants of type "Wood"*/
    WOOD_STAIRS = new Block(), //TODO: StairsUtils
            CHEST = new Block(),
            REDSTONE_WIRE = new Block(),
            DIAMOND_ORE = new Block(),
            DEEPSLATE_DIAMOND_ORE = new Block(),
            DIAMOND_BLOCK = new Block(),
            CRAFTING_TABLE = new Block(),
            WHEAT = new Block(),
            FARMLAND = new Block(),
            FURNACE = new Block(),
    /** Variants of type "Wood"*/
    WOOD_SIGN = new Block(),
    /** Variants of type "Wood"*/
    WOOD_WALL_SIGN = new Block(),
    /** Variants of type "Wood"*/
    WOOD_DOOR = new Block(),
            LADDER = new Block(),
            RAIL = new Block(),
            COBBLESTONE_STAIRS = new Block(),
            LEVER = new Block(),
            STONE_PRESSURE_PLATE = new Block(),
            IRON_DOOR = new Block(),
    /** Variants of type "Wood"*/
    WOOD_PRESSURE_PLATE = new Block(),
            REDSTONE_ORE = new Block(),
            DEEPSLATE_REDSTONE_ORE = new Block(),
            REDSTONE_TORCH = new Block(),
            STONE_BUTTON = new Block(),
            SNOW = new Block(),
            ICE = new Block(),
            SNOW_BLOCK = new Block(),
            CACTUS = new Block(),
            CLAY = new Block(),
            SUGAR_CANE = new Block(),
            JUKEBOX = new Block(),
    /** Variants of type "Wood"*/
    WOOD_FENCE = new Block(),
            PUMPKIN = new Block(),
            NETHERRACK = new Block(),
            SOUL_SAND = new Block(),
            SOUL_SOIL = new Block(),
            BASALT = new Block(),
            POLISHED_BASALT = new Block(),
            SOUL_TORCH = new Block(),
            GLOWSTONE = new Block(),
            NETHER_PORTAL = new Block(),
            CARVED_PUMPKIN = new Block(),
            JACK_O_LANTERN = new Block(),
            CAKE = new Block(),
            REPEATER = new Block(),
    /** Variants of type "DyeColor"*/
    STAINED_GLASS = new Block(),
    /** Variants of type "Wood"*/
    WOOD_TRAPDOOR = new Block(),
    /** Variants of type "StoneBricks"*/
    STONE_BRICKS = new Block(),
    /** Variants of type "InfestedStone"*/
    INFESTED_STONE = new Block(),
    /** Variants of type "MushroomBlock"*/
    MUSHROOM_BLOCK = new Block(),
            IRON_BARS = new Block(),
            CHAIN = new Block(),
            GLASS_PANE = new Block(),
            MELON = new Block(),
            PUMPKIN_STEM = new Block(), // TODO: StemUtils
            MELON_STEM = new Block(),
            VINE = new Block(),
            GLOW_LICHEN = new Block(),
    /** Variants of type "Wood"*/
    WOOD_FENCE_GATE = new Block(),
            BRICK_STAIRS = new Block(),
            STONE_BRICK_STAIRS = new Block(),
            LILY_PAD = new Block(),
            NETHER_BRICKS = new Block(),
            NETHER_BRICK_FENCE = new Block(),
            NETHER_BRICK_STAIRS = new Block(),
            NETHER_WART = new Block(),
            ENCHANTING_TABLE = new Block(),
            BREWING_STAND = new Block(),
    /** Variants of type "CauldronContents"*/
    CAULDRON = new Block(),
            END_PORTAL = new Block(),
            END_PORTAL_FRAME = new Block(),
            END_STONE = new Block(),
            DRAGON_EGG = new Block(),
            REDSTONE_LAMP = new Block(),
            COCOA = new Block(),
            SANDSTONE_STAIRS = new Block(),
            EMERALD_ORE = new Block(),
            DEEPSLATE_EMERALD_ORE = new Block(),
            ENDER_CHEST = new Block(),
            TRIPWIRE_HOOK = new Block(),
            TRIPWIRE = new Block(),
            EMERALD_BLOCK = new Block(),
            COMMAND_BLOCK = new Block(),
            BEACON = new Block(),
    /** Variants of type "CobblestoneWall"*/
    COBBLESTONE_WALL = new Block(),
    /** Variants of type "PotContents"*/
    FLOWER_POT = new Block(),
            CARROTS = new Block(),
            POTATOES = new Block(),
    /** Variants of type "Wood"*/
    WOOD_BUTTON = new Block(),
            SKULL = new Block(), //TODO: SkullUtil
//            SKELETON_WALL_SKULL = new Block(),
//            WITHER_SKELETON_SKULL = new Block(),
//            WITHER_SKELETON_WALL_SKULL = new Block(),
//            ZOMBIE_HEAD = new Block(),
//            ZOMBIE_WALL_HEAD = new Block(),
//            PLAYER_HEAD = new Block(),
//            PLAYER_WALL_HEAD = new Block(),
//            CREEPER_HEAD = new Block(),
//            CREEPER_WALL_HEAD = new Block(),
//            DRAGON_HEAD = new Block(),
//            DRAGON_WALL_HEAD = new Block(),
    /** Variants of type "Anvil"*/
    ANVIL = new Block(),
            TRAPPED_CHEST = new Block(),
            LIGHT_WEIGHTED_PRESSURE_PLATE = new Block(),
            HEAVY_WEIGHTED_PRESSURE_PLATE = new Block(),
            COMPARATOR = new Block(),
            DAYLIGHT_DETECTOR = new Block(),
            REDSTONE_BLOCK = new Block(),
            NETHER_QUARTZ_ORE = new Block(),
            HOPPER = new Block(),

    /** Variants of type "Quartz"*/
    QUARTZ = new Block(),
            QUARTZ_STAIRS = new Block(),
            ACTIVATOR_RAIL = new Block(),
            DROPPER = new Block(),
    /** Variants of type "DyeColor"*/
    STAINED_TERRACOTTA = new Block(),
    /** Variants of type "DyeColor"*/
    STAINED_GLASS_PANE = new Block(),
            SLIME_BLOCK = new Block(),
            BARRIER = new Block(),
            LIGHT = new Block(),
            IRON_TRAPDOOR = new Block(),
    /** Variants of type "Prismarine"*/
            PRISMARINE = new Block(),
            PRISMARINE_STAIRS = new Block(),
            PRISMARINE_BRICK_STAIRS = new Block(),
            DARK_PRISMARINE_STAIRS = new Block(),
            PRISMARINE_SLAB = new Block(),
            PRISMARINE_BRICK_SLAB = new Block(),
            DARK_PRISMARINE_SLAB = new Block(),
            SEA_LANTERN = new Block(),
            HAY_BLOCK = new Block(),
    /** Variants of type "DyeColor"*/
    CARPET = new Block(),
            TERRACOTTA = new Block(),
            COAL_BLOCK = new Block(),
            PACKED_ICE = new Block(),
    /** Variants of type "DoublePlant"*/
    DOUBLE_PLANT = new Block(),
            STANDING_BANNER = new Block(), //TODO: BannerUtils
            WALL_BANNER = new Block(),
    /** Variants of type "Sandstone"*/
    RED_SANDSTONE = new Block(),
            RED_SANDSTONE_STAIRS = new Block(),
    /** Variants of type "Wood"*/
    WOOD_SLAB = new Block(),
    /** Variants of type "StoneSlab"*/
    STONE_SLAB = new Block(),
            SMOOTH_STONE = new Block(),
            SMOOTH_SANDSTONE = new Block(),
            SMOOTH_RED_SANDSTONE = new Block(),
            END_ROD = new Block(),
            CHORUS_PLANT = new Block(),
            CHORUS_FLOWER = new Block(),
            PURPUR_BLOCK = new Block(),
            PURPUR_PILLAR = new Block(),
            PURPUR_STAIRS = new Block(),
            END_STONE_BRICKS = new Block(),
            BEETROOTS = new Block(),
            DIRT_PATH = new Block(),
            END_GATEWAY = new Block(),
            REPEATING_COMMAND_BLOCK = new Block(),
            CHAIN_COMMAND_BLOCK = new Block(),
            FROSTED_ICE = new Block(),
            MAGMA_BLOCK = new Block(),
            NETHER_WART_BLOCK = new Block(),
            RED_NETHER_BRICKS = new Block(),
            BONE_BLOCK = new Block(),
            STRUCTURE_VOID = new Block(),
            OBSERVER = new Block(),
    /** Variants of type "DyeColor" or null*/
    SHULKER_BOX = new Block(),
    /** Variants of type "DyeColor"*/
    GLAZED_TERRACOTTA = new Block(),
    /** Variants of type "DyeColor"*/
    CONCRETE = new Block(),
    /** Variants of type "DyeColor"*/
    CONCRETE_POWDER = new Block(),
            KELP = new Block(),
            KELP_PLANT = new Block(),
            DRIED_KELP_BLOCK = new Block(),
            TURTLE_EGG = new Block(),
            DEAD_TUBE_CORAL_BLOCK = new Block(),
            DEAD_BRAIN_CORAL_BLOCK = new Block(),
            DEAD_BUBBLE_CORAL_BLOCK = new Block(),
            DEAD_FIRE_CORAL_BLOCK = new Block(),
            DEAD_HORN_CORAL_BLOCK = new Block(),
            TUBE_CORAL_BLOCK = new Block(),
            BRAIN_CORAL_BLOCK = new Block(),
            BUBBLE_CORAL_BLOCK = new Block(),
            FIRE_CORAL_BLOCK = new Block(),
            HORN_CORAL_BLOCK = new Block(),
            DEAD_TUBE_CORAL = new Block(),
            DEAD_BRAIN_CORAL = new Block(),
            DEAD_BUBBLE_CORAL = new Block(),
            DEAD_FIRE_CORAL = new Block(),
            DEAD_HORN_CORAL = new Block(),
            TUBE_CORAL = new Block(),
            BRAIN_CORAL = new Block(),
            BUBBLE_CORAL = new Block(),
            FIRE_CORAL = new Block(),
            HORN_CORAL = new Block(),
            DEAD_TUBE_CORAL_FAN = new Block(),
            DEAD_BRAIN_CORAL_FAN = new Block(),
            DEAD_BUBBLE_CORAL_FAN = new Block(),
            DEAD_FIRE_CORAL_FAN = new Block(),
            DEAD_HORN_CORAL_FAN = new Block(),
            TUBE_CORAL_FAN = new Block(),
            BRAIN_CORAL_FAN = new Block(),
            BUBBLE_CORAL_FAN = new Block(),
            FIRE_CORAL_FAN = new Block(),
            HORN_CORAL_FAN = new Block(),
            DEAD_TUBE_CORAL_WALL_FAN = new Block(),
            DEAD_BRAIN_CORAL_WALL_FAN = new Block(),
            DEAD_BUBBLE_CORAL_WALL_FAN = new Block(),
            DEAD_FIRE_CORAL_WALL_FAN = new Block(),
            DEAD_HORN_CORAL_WALL_FAN = new Block(),
            TUBE_CORAL_WALL_FAN = new Block(),
            BRAIN_CORAL_WALL_FAN = new Block(),
            BUBBLE_CORAL_WALL_FAN = new Block(),
            FIRE_CORAL_WALL_FAN = new Block(),
            HORN_CORAL_WALL_FAN = new Block(),
            SEA_PICKLE = new Block(),
            BLUE_ICE = new Block(),
            CONDUIT = new Block(),
            BAMBOO_SAPLING = new Block(),
            BAMBOO = new Block(),
            POTTED_BAMBOO = new Block(),
            VOID_AIR = new Block(),
            CAVE_AIR = new Block(),
            BUBBLE_COLUMN = new Block(),
            POLISHED_GRANITE_STAIRS = new Block(),
            SMOOTH_RED_SANDSTONE_STAIRS = new Block(),
            MOSSY_STONE_BRICK_STAIRS = new Block(),
            POLISHED_DIORITE_STAIRS = new Block(),
            MOSSY_COBBLESTONE_STAIRS = new Block(),
            END_STONE_BRICK_STAIRS = new Block(),
            STONE_STAIRS = new Block(),
            SMOOTH_SANDSTONE_STAIRS = new Block(),
            SMOOTH_QUARTZ_STAIRS = new Block(),
            GRANITE_STAIRS = new Block(),
            ANDESITE_STAIRS = new Block(),
            RED_NETHER_BRICK_STAIRS = new Block(),
            POLISHED_ANDESITE_STAIRS = new Block(),
            DIORITE_STAIRS = new Block(),
            POLISHED_GRANITE_SLAB = new Block(),
            SMOOTH_RED_SANDSTONE_SLAB = new Block(),
            MOSSY_STONE_BRICK_SLAB = new Block(),
            POLISHED_DIORITE_SLAB = new Block(),
            MOSSY_COBBLESTONE_SLAB = new Block(),
            END_STONE_BRICK_SLAB = new Block(),
            SMOOTH_SANDSTONE_SLAB = new Block(),
            SMOOTH_QUARTZ_SLAB = new Block(),
            GRANITE_SLAB = new Block(),
            ANDESITE_SLAB = new Block(),
            RED_NETHER_BRICK_SLAB = new Block(),
            POLISHED_ANDESITE_SLAB = new Block(),
            DIORITE_SLAB = new Block(),
            BRICK_WALL = new Block(),
            PRISMARINE_WALL = new Block(),
            RED_SANDSTONE_WALL = new Block(),
            MOSSY_STONE_BRICK_WALL = new Block(),
            GRANITE_WALL = new Block(),
            STONE_BRICK_WALL = new Block(),
            NETHER_BRICK_WALL = new Block(),
            ANDESITE_WALL = new Block(),
            RED_NETHER_BRICK_WALL = new Block(),
            SANDSTONE_WALL = new Block(),
            END_STONE_BRICK_WALL = new Block(),
            DIORITE_WALL = new Block(),
            SCAFFOLDING = new Block(),
            LOOM = new Block(),
            BARREL = new Block(),
            SMOKER = new Block(),
            BLAST_FURNACE = new Block(),
            CARTOGRAPHY_TABLE = new Block(),
            FLETCHING_TABLE = new Block(),
            GRINDSTONE = new Block(),
            LECTERN = new Block(),
            SMITHING_TABLE = new Block(),
            STONECUTTER = new Block(),
            BELL = new Block(),
            LANTERN = new Block(),
            SOUL_LANTERN = new Block(),
            CAMPFIRE = new Block(),
            SOUL_CAMPFIRE = new Block(),
            SWEET_BERRY_BUSH = new Block(),
            WARPED_HYPHAE = new Block(),
            STRIPPED_WARPED_HYPHAE = new Block(),
            WARPED_NYLIUM = new Block(),
            WARPED_WART_BLOCK = new Block(),
            WARPED_ROOTS = new Block(),
            NETHER_SPROUTS = new Block(),
            CRIMSON_HYPHAE = new Block(),
            STRIPPED_CRIMSON_HYPHAE = new Block(),
            CRIMSON_NYLIUM = new Block(),
            SHROOMLIGHT = new Block(),
            WEEPING_VINES = new Block(),
            WEEPING_VINES_PLANT = new Block(),
            TWISTING_VINES = new Block(),
            TWISTING_VINES_PLANT = new Block(),
            CRIMSON_ROOTS = new Block(),
            STRUCTURE_BLOCK = new Block(),
            JIGSAW = new Block(),
            COMPOSTER = new Block(),
            TARGET = new Block(),
            BEE_NEST = new Block(),
            BEEHIVE = new Block(),
            HONEY_BLOCK = new Block(),
            HONEYCOMB_BLOCK = new Block(),
            NETHERITE_BLOCK = new Block(),
            ANCIENT_DEBRIS = new Block(),
            CRYING_OBSIDIAN = new Block(),
            RESPAWN_ANCHOR = new Block(),
            POTTED_CRIMSON_FUNGUS = new Block(),
            POTTED_WARPED_FUNGUS = new Block(),
            POTTED_CRIMSON_ROOTS = new Block(),
            POTTED_WARPED_ROOTS = new Block(),
            LODESTONE = new Block(),
            BLACKSTONE = new Block(),
            BLACKSTONE_STAIRS = new Block(),
            BLACKSTONE_WALL = new Block(),
            BLACKSTONE_SLAB = new Block(),
            POLISHED_BLACKSTONE = new Block(),
            POLISHED_BLACKSTONE_BRICKS = new Block(),
            CRACKED_POLISHED_BLACKSTONE_BRICKS = new Block(),
            CHISELED_POLISHED_BLACKSTONE = new Block(),
            POLISHED_BLACKSTONE_BRICK_SLAB = new Block(),
            POLISHED_BLACKSTONE_BRICK_STAIRS = new Block(),
            POLISHED_BLACKSTONE_BRICK_WALL = new Block(),
            GILDED_BLACKSTONE = new Block(),
            POLISHED_BLACKSTONE_STAIRS = new Block(),
            POLISHED_BLACKSTONE_SLAB = new Block(),
            POLISHED_BLACKSTONE_PRESSURE_PLATE = new Block(),
            POLISHED_BLACKSTONE_BUTTON = new Block(),
            POLISHED_BLACKSTONE_WALL = new Block(),
            CHISELED_NETHER_BRICKS = new Block(),
            CRACKED_NETHER_BRICKS = new Block(),
            QUARTZ_BRICKS = new Block(),
            CANDLE = new Block(),
            WHITE_CANDLE = new Block(),
            ORANGE_CANDLE = new Block(),
            MAGENTA_CANDLE = new Block(),
            LIGHT_BLUE_CANDLE = new Block(),
            YELLOW_CANDLE = new Block(),
            LIME_CANDLE = new Block(),
            PINK_CANDLE = new Block(),
            GRAY_CANDLE = new Block(),
            LIGHT_GRAY_CANDLE = new Block(),
            CYAN_CANDLE = new Block(),
            PURPLE_CANDLE = new Block(),
            BLUE_CANDLE = new Block(),
            BROWN_CANDLE = new Block(),
            GREEN_CANDLE = new Block(),
            RED_CANDLE = new Block(),
            BLACK_CANDLE = new Block(),
            CANDLE_CAKE = new Block(),
            WHITE_CANDLE_CAKE = new Block(),
            ORANGE_CANDLE_CAKE = new Block(),
            MAGENTA_CANDLE_CAKE = new Block(),
            LIGHT_BLUE_CANDLE_CAKE = new Block(),
            YELLOW_CANDLE_CAKE = new Block(),
            LIME_CANDLE_CAKE = new Block(),
            PINK_CANDLE_CAKE = new Block(),
            GRAY_CANDLE_CAKE = new Block(),
            LIGHT_GRAY_CANDLE_CAKE = new Block(),
            CYAN_CANDLE_CAKE = new Block(),
            PURPLE_CANDLE_CAKE = new Block(),
            BLUE_CANDLE_CAKE = new Block(),
            BROWN_CANDLE_CAKE = new Block(),
            GREEN_CANDLE_CAKE = new Block(),
            RED_CANDLE_CAKE = new Block(),
            BLACK_CANDLE_CAKE = new Block(),
            AMETHYST_BLOCK = new Block(),
            BUDDING_AMETHYST = new Block(),
            AMETHYST_CLUSTER = new Block(),
            LARGE_AMETHYST_BUD = new Block(),
            MEDIUM_AMETHYST_BUD = new Block(),
            SMALL_AMETHYST_BUD = new Block(),
            TUFF = new Block(),
            CALCITE = new Block(),
            TINTED_GLASS = new Block(),
            POWDER_SNOW = new Block(),
            SCULK_SENSOR = new Block(),
            OXIDIZED_COPPER = new Block(),
            WEATHERED_COPPER = new Block(),
            EXPOSED_COPPER = new Block(),
            COPPER_BLOCK = new Block(),
            COPPER_ORE = new Block(),
            DEEPSLATE_COPPER_ORE = new Block(),
            OXIDIZED_CUT_COPPER = new Block(),
            WEATHERED_CUT_COPPER = new Block(),
            EXPOSED_CUT_COPPER = new Block(),
            CUT_COPPER = new Block(),
            OXIDIZED_CUT_COPPER_STAIRS = new Block(),
            WEATHERED_CUT_COPPER_STAIRS = new Block(),
            EXPOSED_CUT_COPPER_STAIRS = new Block(),
            CUT_COPPER_STAIRS = new Block(),
            OXIDIZED_CUT_COPPER_SLAB = new Block(),
            WEATHERED_CUT_COPPER_SLAB = new Block(),
            EXPOSED_CUT_COPPER_SLAB = new Block(),
            CUT_COPPER_SLAB = new Block(),
            WAXED_COPPER_BLOCK = new Block(),
            WAXED_WEATHERED_COPPER = new Block(),
            WAXED_EXPOSED_COPPER = new Block(),
            WAXED_OXIDIZED_COPPER = new Block(),
            WAXED_OXIDIZED_CUT_COPPER = new Block(),
            WAXED_WEATHERED_CUT_COPPER = new Block(),
            WAXED_EXPOSED_CUT_COPPER = new Block(),
            WAXED_CUT_COPPER = new Block(),
            WAXED_OXIDIZED_CUT_COPPER_STAIRS = new Block(),
            WAXED_WEATHERED_CUT_COPPER_STAIRS = new Block(),
            WAXED_EXPOSED_CUT_COPPER_STAIRS = new Block(),
            WAXED_CUT_COPPER_STAIRS = new Block(),
            WAXED_OXIDIZED_CUT_COPPER_SLAB = new Block(),
            WAXED_WEATHERED_CUT_COPPER_SLAB = new Block(),
            WAXED_EXPOSED_CUT_COPPER_SLAB = new Block(),
            WAXED_CUT_COPPER_SLAB = new Block(),
            LIGHTNING_ROD = new Block(),
            POINTED_DRIPSTONE = new Block(),
            DRIPSTONE_BLOCK = new Block(),
            CAVE_VINES = new Block(),
            CAVE_VINES_PLANT = new Block(),
            SPORE_BLOSSOM = new Block(),
            AZALEA = new Block(),
            FLOWERING_AZALEA = new Block(),
            MOSS_CARPET = new Block(),
            MOSS_BLOCK = new Block(),
            BIG_DRIPLEAF = new Block(),
            BIG_DRIPLEAF_STEM = new Block(),
            SMALL_DRIPLEAF = new Block(),
            HANGING_ROOTS = new Block(),
            ROOTED_DIRT = new Block(),
            DEEPSLATE = new Block(),
            COBBLED_DEEPSLATE = new Block(),
            COBBLED_DEEPSLATE_STAIRS = new Block(),
            COBBLED_DEEPSLATE_SLAB = new Block(),
            COBBLED_DEEPSLATE_WALL = new Block(),
            POLISHED_DEEPSLATE = new Block(),
            POLISHED_DEEPSLATE_STAIRS = new Block(),
            POLISHED_DEEPSLATE_SLAB = new Block(),
            POLISHED_DEEPSLATE_WALL = new Block(),
            DEEPSLATE_TILES = new Block(),
            DEEPSLATE_TILE_STAIRS = new Block(),
            DEEPSLATE_TILE_SLAB = new Block(),
            DEEPSLATE_TILE_WALL = new Block(),
            DEEPSLATE_BRICKS = new Block(),
            DEEPSLATE_BRICK_STAIRS = new Block(),
            DEEPSLATE_BRICK_SLAB = new Block(),
            DEEPSLATE_BRICK_WALL = new Block(),
            CHISELED_DEEPSLATE = new Block(),
            CRACKED_DEEPSLATE_BRICKS = new Block(),
            CRACKED_DEEPSLATE_TILES = new Block(),
            INFESTED_DEEPSLATE = new Block(),
            SMOOTH_BASALT = new Block(),
            RAW_IRON_BLOCK = new Block(),
            RAW_COPPER_BLOCK = new Block(),
            RAW_GOLD_BLOCK = new Block(),
            POTTED_AZALEA_BUSH = new Block(),
            POTTED_FLOWERING_AZALEA_BUSH = new Block();
}
