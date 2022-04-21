package net.meshmc.mesh.api.block;

import net.meshmc.mesh.util.block.PistonPushReaction;

/**
 * @author Makrennel 04/21/2022
 *
 * 1.18 fabric implementation of the Material interface.
 */
public interface Material {
    Material
            AIR = (Material) net.minecraft.block.Material.AIR,
            AMETHYST = (Material) net.minecraft.block.Material.AMETHYST,
            ANVIL = (Material) net.minecraft.block.Material.REPAIR_STATION,
            BAMBOO = (Material) net.minecraft.block.Material.BAMBOO,
            BAMBOO_SAPLING = (Material) net.minecraft.block.Material.BAMBOO_SAPLING,
            BARRIER = (Material) net.minecraft.block.Material.BARRIER,
            BUBBLE_COLUMN = (Material) net.minecraft.block.Material.BUBBLE_COLUMN,
            CACTUS = (Material) net.minecraft.block.Material.CACTUS,
            CAKE = (Material) net.minecraft.block.Material.CAKE,
            CARPET = (Material) net.minecraft.block.Material.CARPET,
            CLAY = (Material) net.minecraft.block.Material.ORGANIC_PRODUCT,
            DECORATION = (Material) net.minecraft.block.Material.DECORATION,
            DRAGON_EGG = (Material) net.minecraft.block.Material.EGG,
            FIRE = (Material) net.minecraft.block.Material.FIRE,
            GLASS = (Material) net.minecraft.block.Material.GLASS,
            GOURD = (Material) net.minecraft.block.Material.GOURD,
            GRASS = (Material) net.minecraft.block.Material.SOLID_ORGANIC,
            IRON = (Material) net.minecraft.block.Material.METAL,
            ICE = (Material) net.minecraft.block.Material.ICE,
            ICE_DENSE = (Material) net.minecraft.block.Material.DENSE_ICE,
            LAVA = (Material) net.minecraft.block.Material.LAVA,
            LEAVES = (Material) net.minecraft.block.Material.LEAVES,
            MOSS_BLOCK = (Material) net.minecraft.block.Material.MOSS_BLOCK,
            NETHER_SHOOTS = (Material) net.minecraft.block.Material.NETHER_SHOOTS,
            NETHER_WOOD = (Material) net.minecraft.block.Material.NETHER_WOOD,
            PISTON = (Material) net.minecraft.block.Material.PISTON,
            PLANT = (Material) net.minecraft.block.Material.PLANT,
            PLANT_REPLACEABLE = (Material) net.minecraft.block.Material.REPLACEABLE_PLANT,
            PLANT_UNDERWATER = (Material) net.minecraft.block.Material.UNDERWATER_PLANT,
            PORTAL = (Material) net.minecraft.block.Material.PORTAL,
            REDSTONE_LIGHT = (Material) net.minecraft.block.Material.REDSTONE_LAMP,
            ROCK = (Material) net.minecraft.block.Material.STONE,
            SAND = (Material) net.minecraft.block.Material.AGGREGATE,
            SCULK = (Material) net.minecraft.block.Material.SCULK,
            SNOW_BLOCK = (Material) net.minecraft.block.Material.SNOW_BLOCK,
            SNOW_LAYER = (Material) net.minecraft.block.Material.SNOW_LAYER,
            SNOW_POWDER = (Material) net.minecraft.block.Material.POWDER_SNOW,
            SOIL = (Material) net.minecraft.block.Material.SOIL,
            SPONGE = (Material) net.minecraft.block.Material.SPONGE,
            STRUCTURE_VOID = (Material) net.minecraft.block.Material.STRUCTURE_VOID,
            TNT = (Material) net.minecraft.block.Material.TNT,
            WATER = (Material) net.minecraft.block.Material.WATER,
            WEB = (Material) net.minecraft.block.Material.COBWEB,
            WOOD = (Material) net.minecraft.block.Material.WOOD,
            WOOL = (Material) net.minecraft.block.Material.WOOL;

    static Material create(MapColor color) {
        return (Material) new net.minecraft.block.Material.Builder((net.minecraft.block.MapColor) color).build();
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

