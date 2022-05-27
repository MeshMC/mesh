package net.meshmc.mesh.util.block;

public class BlockVariant {
    public enum Wood {
        OAK,
        SPRUCE,
        BIRCH,
        JUNGLE,
        ACACIA,
        DARK_OAK,
        WARPED,
        CRIMSON
    }

    public enum Stone {
        STONE,
        GRANITE,
        POLISHED_GRANITE,
        DIORITE,
        POLISHED_DIORITE,
        ANDESITE,
        POLISHED_ANDESITE
    }

    public enum Dirt {
        DIRT,
        COARSE_DIRT,
        PODZOL,
        GRASS,
        MYCELIUM
    }

    public enum Sand {
        YELLOW,
        RED
    }

    public enum Leaves {
        OAK,
        SPRUCE,
        BIRCH,
        JUNGLE,
        ACACIA,
        DARK_OAK,
        AZALEA,
        FLOWERING_AZALEA
    }

    public enum Grass {
        DEAD_BUSH,
        GRASS,
        FERN
    }

    public enum Sandstone {
        DEFAULT,
        CHISELED,
        CUT
    }

    public enum Flower {
        DANDELION,
        POPPY,
        BLUE_ORCHID,
        ALLIUM,
        AZURE_BLUET,
        RED_TULIP,
        ORANGE_TULIP,
        WHITE_TULIP,
        PINK_TULIP,
        OXEYE_DAISY,
        CORNFLOWER,
        WITHER_ROSE,
        LILY_OF_THE_VALLEY
    }

    public enum StoneBricks {
        DEFAULT,
        MOSSY,
        CRACKED,
        CHISELED
    }

    public enum InfestedStone {
        STONE,
        COBBLESTONE,
        STONE_BRICKS,
        MOSSY_BRICKS,
        CRACKED_BRICKS,
        CHISELED_BRICKS,
        DEEPSLATE
    }

    public enum MushroomBlock {
        RED,
        BROWN,
        STEM
    }

    public enum CauldronContents {
        EMPTY,
        WATER,
        LAVA,
        SNOW
    }

    public enum CobblestoneWall {
        COBBLESTONE,
        MOSSY_COBBLESTONE
    }

    public enum PotContents {
        EMPTY,
        POPPY,
        BLUE_ORCHID,
        ALLIUM,
        AZURE_BLUET,
        RED_TULIP,
        ORANGE_TULIP,
        WHITE_TULIP,
        PINK_TULIP,
        OXEYE_DAISY,
        DANDELION,
        OAK_SAPLING,
        SPRUCE_SAPLING,
        BIRCH_SAPLING,
        JUNGLE_SAPLING,
        ACACIA_SAPLING,
        DARK_OAK_SAPLING,
        MUSHROOM_RED,
        MUSHROOM_BROWN,
        DEAD_BUSH,
        FERN,
        CACTUS,
        CORNFLOWER,
        LILY_OF_THE_VALLEY,
        WITHER_ROSE
    }

    public enum Anvil {
        NORMAL,
        CHIPPED,
        DAMAGED;

        public int getDamage() {
            return ordinal();
        }
    }

    public enum Quartz {
        BLOCK,
        SMOOTH,
        CHISELED,
        PILLAR,
        BRICKS
    }

    public enum Prismarine {
        ROUGH,
        BRICKS,
        DARK
    }

    public enum DoublePlant {
        SUNFLOWER,
        LILAC,
        GRASS,
        FERN,
        ROSE,
        PAEONIA
    }

    public enum StoneSlab {
        STONE,
        SMOOTH_STONE,
        SANDSTONE,
        CUT_SANDSTONE,
        PETRIFIED_OAK,
        COBBLESTONE,
        BRICK,
        STONE_BRICK,
        NETHER_BRICK,
        QUARTZ,
        RED_SANDSTONE,
        CUT_RED_SANDSTONE,
        PURPUR
    }
}
