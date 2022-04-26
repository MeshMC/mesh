package net.meshmc.mesh.api.block;

import net.meshmc.mesh.MeshStatics;
import net.meshmc.mesh.statics.StaticMaterials;
import net.meshmc.mesh.util.block.PistonPushReaction;

/**
 * @author Makrennel 04/21/2022
 *
 * All static fields here point to methods in a class which is not present in mesh-core builds
 */
public interface Material {
    Material
            AIR = StaticMaterials.AIR(),
            AMETHYST = StaticMaterials.AMETHYST(),
            ANVIL = StaticMaterials.ANVIL(),
            BAMBOO = StaticMaterials.BAMBOO(),
            BAMBOO_SAPLING = StaticMaterials.BAMBOO_SAPLING(),
            BARRIER = StaticMaterials.BARRIER(),
            BUBBLE_COLUMN = StaticMaterials.BUBBLE_COLUMN(),
            CACTUS = StaticMaterials.CACTUS(),
            CAKE = StaticMaterials.CAKE(),
            CARPET = StaticMaterials.CARPET(),
            CLAY = StaticMaterials.CLAY(),
            DECORATION = StaticMaterials.DECORATION(),
            DRAGON_EGG = StaticMaterials.DRAGON_EGG(),
            FIRE = StaticMaterials.FIRE(),
            GLASS = StaticMaterials.GLASS(),
            GOURD = StaticMaterials.GOURD(),
            GRASS = StaticMaterials.GRASS(),
            IRON = StaticMaterials.IRON(),
            ICE = StaticMaterials.ICE(),
            ICE_DENSE = StaticMaterials.ICE_DENSE(),
            LAVA = StaticMaterials.LAVA(),
            LEAVES = StaticMaterials.LEAVES(),
            MOSS_BLOCK = StaticMaterials.MOSS_BLOCK(),
            NETHER_SHOOTS = StaticMaterials.NETHER_SHOOTS(),
            NETHER_WOOD = StaticMaterials.NETHER_WOOD(),
            PISTON = StaticMaterials.PISTON(),
            PLANT = StaticMaterials.PLANT(),
            PLANT_REPLACEABLE = StaticMaterials.PLANT_REPLACEABLE(),
            PLANT_UNDERWATER = StaticMaterials.PLANT_UNDERWATER(),
            PORTAL = StaticMaterials.PORTAL(),
            REDSTONE_LIGHT = StaticMaterials.REDSTONE_LIGHT(),
            ROCK = StaticMaterials.ROCK(),
            SAND = StaticMaterials.SAND(),
            SCULK = StaticMaterials.SCULK(),
            SNOW_BLOCK = StaticMaterials.SNOW_BLOCK(),
            SNOW_LAYER = StaticMaterials.SNOW_LAYER(),
            SNOW_POWDER = StaticMaterials.SNOW_POWDER(),
            SOIL = StaticMaterials.SOIL(),
            SPONGE = StaticMaterials.SPONGE(),
            STRUCTURE_VOID = StaticMaterials.STRUCTURE_VOID(),
            TNT = StaticMaterials.TNT(),
            WATER = StaticMaterials.WATER(),
            WEB = StaticMaterials.WEB(),
            WOOD = StaticMaterials.WOOD(),
            WOOL = StaticMaterials.WOOL();

    static Material create(MapColor mapColor) {
        return MeshStatics.createMaterial(mapColor);
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
