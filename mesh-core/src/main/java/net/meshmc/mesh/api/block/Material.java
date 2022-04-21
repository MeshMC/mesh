package net.meshmc.mesh.api.block;

import net.meshmc.mesh.util.block.PistonPushReaction;

/**
 * @author Makrennel 04/21/2022
 *
 * This class is not present in the built jar.
 */
public interface Material {
    Material
            AIR = null,
            AMETHYST = null,
            ANVIL = null,
            BAMBOO = null,
            BAMBOO_SAPLING = null,
            BARRIER = null,
            BUBBLE_COLUMN = null,
            CACTUS = null,
            CAKE = null,
            CARPET = null,
            CLAY = null,
            DECORATION = null,
            DRAGON_EGG = null,
            FIRE = null,
            GLASS = null,
            GOURD = null,
            GRASS = null,
            IRON = null,
            ICE = null,
            ICE_DENSE = null,
            LAVA = null,
            LEAVES = null,
            MOSS_BLOCK = null,
            NETHER_SHOOTS = null,
            NETHER_WOOD = null,
            PISTON = null,
            PLANT = null,
            PLANT_REPLACEABLE = null,
            PLANT_UNDERWATER = null,
            PORTAL = null,
            REDSTONE_LIGHT = null,
            ROCK = null,
            SAND = null,
            SCULK = null,
            SNOW_BLOCK = null,
            SNOW_LAYER = null,
            SNOW_POWDER = null,
            SOIL = null,
            SPONGE = null,
            STRUCTURE_VOID = null,
            TNT = null,
            WATER = null,
            WEB = null,
            WOOD = null,
            WOOL = null;

    static Material create(MapColor color) {
        throw new RuntimeException();
    }

    boolean isLiquid_();
    Material setLiquid(boolean value);

    boolean isSolid_();
    Material setSolid(boolean value);

    boolean doesBlockMovement();
    Material setBlocksMovement(boolean value);

    boolean doesBlockLight();
    Material setBlocksLight(boolean value);

    boolean isBurnable();
    Material setBurnable(boolean value);

    boolean isReplaceable();
    Material setReplaceable(boolean value);

    MapColor getColorOnMap();
    Material setColorOnMap(MapColor color);

    PistonPushReaction getPistonPushReaction();
    Material setPistonPushReaction(PistonPushReaction pistonPushReaction);
}
