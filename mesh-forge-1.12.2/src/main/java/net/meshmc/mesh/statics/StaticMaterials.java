package net.meshmc.mesh.statics;

import net.meshmc.mesh.api.block.MapColor;
import net.meshmc.mesh.api.block.Material;
import net.meshmc.mesh.util.block.PistonPushReaction;

public class StaticMaterials {
    public static final Material
            AIR = (Material) net.minecraft.block.material.Material.AIR,
            AMETHYST = Material.create(MapColor.PURPLE),
            ANVIL = (Material) net.minecraft.block.material.Material.ANVIL,
            BAMBOO = Material.create(MapColor.OAK_TAN).setBurnable(true).setPistonPushReaction(PistonPushReaction.DESTROY),
            BAMBOO_SAPLING = Material.create(MapColor.OAK_TAN).setBurnable(true).setPistonPushReaction(PistonPushReaction.DESTROY).setBlocksMovement(false),
            BARRIER = (Material) net.minecraft.block.material.Material.BARRIER,
            BUBBLE_COLUMN = Material.create(MapColor.WATER_BLUE).setBlocksMovement(false).setBlocksLight(false).setSolid(false).setPistonPushReaction(PistonPushReaction.DESTROY).setReplaceable(true),
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
            MOSS_BLOCK = Material.create(MapColor.DARK_GREEN).setPistonPushReaction(PistonPushReaction.DESTROY),
            NETHER_SHOOTS = Material.create(MapColor.DARK_GREEN).setBlocksMovement(false).setBlocksLight(false).setSolid(false).setPistonPushReaction(PistonPushReaction.DESTROY).setReplaceable(true).setBurnable(true),
            NETHER_WOOD = Material.create(MapColor.OAK_TAN),
            PISTON = (Material) net.minecraft.block.material.Material.PISTON,
            PLANT = (Material) net.minecraft.block.material.Material.PLANTS,
            PLANT_REPLACEABLE = (Material) net.minecraft.block.material.Material.VINE,
            PLANT_UNDERWATER = (Material) net.minecraft.block.material.Material.CORAL,
            PORTAL = (Material) net.minecraft.block.material.Material.PORTAL,
            REDSTONE_LIGHT = (Material) net.minecraft.block.material.Material.REDSTONE_LIGHT,
            ROCK = (Material) net.minecraft.block.material.Material.ROCK,
            SAND = (Material) net.minecraft.block.material.Material.SAND,
            SCULK = Material.create(MapColor.BLACK),
            SNOW_BLOCK = (Material) net.minecraft.block.material.Material.CRAFTED_SNOW,
            SNOW_LAYER = (Material) net.minecraft.block.material.Material.SNOW,
            SNOW_POWDER = Material.create(MapColor.WHITE).setSolid(false).setBlocksMovement(false),
            SOIL = (Material) net.minecraft.block.material.Material.GROUND,
            SPONGE = (Material) net.minecraft.block.material.Material.SPONGE,
            STRUCTURE_VOID = (Material) net.minecraft.block.material.Material.STRUCTURE_VOID,
            TNT = (Material) net.minecraft.block.material.Material.TNT,
            WATER = (Material) net.minecraft.block.material.Material.WATER,
            WEB = (Material) net.minecraft.block.material.Material.WEB,
            WOOD = (Material) net.minecraft.block.material.Material.WOOD,
            WOOL = (Material) net.minecraft.block.material.Material.CLOTH;
}
