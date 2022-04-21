package net.meshmc.mesh.api.block;

import net.meshmc.mesh.util.block.PistonPushReaction;

/**
 * @author Makrennel 04/21/2022
 *
 * 1.12.2 forge implementation of the Material interface.
 */
public interface Material {
    Material
            AIR = (Material) net.minecraft.block.material.Material.AIR,
            AMETHYST = create(MapColor.PURPLE),
            ANVIL = (Material) net.minecraft.block.material.Material.ANVIL,
            BAMBOO = create(MapColor.OAK_TAN).setBurnable(true).setPistonPushReaction(PistonPushReaction.DESTROY),
            BAMBOO_SAPLING = create(MapColor.OAK_TAN).setBurnable(true).setPistonPushReaction(PistonPushReaction.DESTROY).setBlocksMovement(false),
            BARRIER = (Material) net.minecraft.block.material.Material.BARRIER,
            BUBBLE_COLUMN = create(MapColor.WATER_BLUE).setBlocksMovement(false).setBlocksLight(false).setSolid(false).setPistonPushReaction(PistonPushReaction.DESTROY).setReplaceable(true),
            CACTUS = (Material) net.minecraft.block.material.Material.CACTUS,
            CAKE = (Material) net.minecraft.block.material.Material.CAKE,
            CARPET = (Material) net.minecraft.block.material.Material.CARPET,
            CLAY = (Material) net.minecraft.block.material.Material.CLAY,
            DECORATION = (Material) net.minecraft.block.material.Material.CIRCUITS,
            DRAGON_EGG = (Material) net.minecraft.block.material.Material.DRAGON_EGG,
            FIRE = (Material) net.minecraft.block.material.Material.FIRE,
            GLASS = (Material) net.minecraft.block.material.Material.GLASS,
            GOURD = (Material) net.minecraft.block.material.Material.GOURD,
            GRASS = (Material) net.minecraft.block.material.Material.GRASS,
            IRON = (Material) net.minecraft.block.material.Material.IRON,
            ICE = (Material) net.minecraft.block.material.Material.ICE,
            ICE_DENSE = (Material) net.minecraft.block.material.Material.PACKED_ICE,
            LAVA = (Material) net.minecraft.block.material.Material.LAVA,
            LEAVES = (Material) net.minecraft.block.material.Material.LEAVES,
            MOSS_BLOCK = create(MapColor.DARK_GREEN).setPistonPushReaction(PistonPushReaction.DESTROY),
            NETHER_SHOOTS = create(MapColor.DARK_GREEN).setBlocksMovement(false).setBlocksLight(false).setSolid(false).setPistonPushReaction(PistonPushReaction.DESTROY).setReplaceable(true).setBurnable(true),
            NETHER_WOOD = create(MapColor.OAK_TAN),
            PISTON = (Material) net.minecraft.block.material.Material.PISTON,
            PLANT = (Material) net.minecraft.block.material.Material.PLANTS,
            PLANT_REPLACEABLE = (Material) net.minecraft.block.material.Material.VINE,
            PLANT_UNDERWATER = (Material) net.minecraft.block.material.Material.CORAL,
            PORTAL = (Material) net.minecraft.block.material.Material.PORTAL,
            REDSTONE_LIGHT = (Material) net.minecraft.block.material.Material.REDSTONE_LIGHT,
            ROCK = (Material) net.minecraft.block.material.Material.ROCK,
            SAND = (Material) net.minecraft.block.material.Material.SAND,
            SCULK = create(MapColor.BLACK),
            SNOW_BLOCK = (Material) net.minecraft.block.material.Material.CRAFTED_SNOW,
            SNOW_LAYER = (Material) net.minecraft.block.material.Material.SNOW,
            SNOW_POWDER = create(MapColor.WHITE).setSolid(false).setBlocksMovement(false),
            SOIL = (Material) net.minecraft.block.material.Material.GROUND,
            SPONGE = (Material) net.minecraft.block.material.Material.SPONGE,
            STRUCTURE_VOID = (Material) net.minecraft.block.material.Material.STRUCTURE_VOID,
            TNT = (Material) net.minecraft.block.material.Material.TNT,
            WATER = (Material) net.minecraft.block.material.Material.WATER,
            WEB = (Material) net.minecraft.block.material.Material.WEB,
            WOOD = (Material) net.minecraft.block.material.Material.WOOD,
            WOOL = (Material) net.minecraft.block.material.Material.CLOTH;

    static Material create(MapColor color) {
        return (Material) new net.minecraft.block.material.Material((net.minecraft.block.material.MapColor) color);
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

