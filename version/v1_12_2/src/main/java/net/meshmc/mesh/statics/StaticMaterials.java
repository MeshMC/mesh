package net.meshmc.mesh.statics;

import net.meshmc.mesh.api.block.MapColor;
import net.meshmc.mesh.api.block.Material;
import net.meshmc.mesh.util.block.PistonPushReaction;

public class StaticMaterials {
    public static Material AIR() {
        return (Material) net.minecraft.block.material.Material.AIR;
    }

    public static Material AMETHYST() {
        return Material.create(MapColor.PURPLE);
    }

    public static Material ANVIL() {
        return (Material) net.minecraft.block.material.Material.ANVIL;
    }

    public static Material BAMBOO() {
        return Material.create(MapColor.OAK_TAN).setBurnable(true).setPistonPushReaction(PistonPushReaction.DESTROY);
    }

    public static Material BAMBOO_SAPLING() {
        return Material.create(MapColor.OAK_TAN).setBurnable(true).setPistonPushReaction(PistonPushReaction.DESTROY).setBlocksMovement(false);
    }

    public static Material BARRIER() {
        return (Material) net.minecraft.block.material.Material.BARRIER;
    }

    public static Material BUBBLE_COLUMN() {
        return Material.create(MapColor.WATER_BLUE).setBlocksMovement(false).setBlocksLight(false).setSolid(false).setPistonPushReaction(PistonPushReaction.DESTROY).setReplaceable(true);
    }

    public static Material CACTUS() {
        return (Material) net.minecraft.block.material.Material.CACTUS;
    }

    public static Material CAKE() {
        return (Material) net.minecraft.block.material.Material.CAKE;
    }

    public static Material CARPET() {
        return (Material) net.minecraft.block.material.Material.CARPET;
    }

    public static Material CLAY() {
        return (Material) net.minecraft.block.material.Material.CLAY;
    }

    public static Material DECORATION() {
        return (Material) net.minecraft.block.material.Material.CIRCUITS;
    }

    public static Material DRAGON_EGG() {
        return (Material) net.minecraft.block.material.Material.DRAGON_EGG;
    }

    public static Material FIRE() {
        return (Material) net.minecraft.block.material.Material.FIRE;
    }

    public static Material GLASS() {
        return (Material) net.minecraft.block.material.Material.GLASS;
    }

    public static Material GOURD() {
        return (Material) net.minecraft.block.material.Material.GOURD;
    }

    public static Material GRASS() {
        return (Material) net.minecraft.block.material.Material.GRASS;
    }

    public static Material IRON() {
        return (Material) net.minecraft.block.material.Material.IRON;
    }

    public static Material ICE() {
        return (Material) net.minecraft.block.material.Material.ICE;
    }

    public static Material ICE_DENSE() {
        return (Material) net.minecraft.block.material.Material.PACKED_ICE;
    }

    public static Material LAVA() {
        return (Material) net.minecraft.block.material.Material.LAVA;
    }

    public static Material LEAVES() {
        return (Material) net.minecraft.block.material.Material.LEAVES;
    }

    public static Material MOSS_BLOCK() {
        return Material.create(MapColor.DARK_GREEN).setPistonPushReaction(PistonPushReaction.DESTROY);
    }

    public static Material NETHER_SHOOTS() {
        return Material.create(MapColor.DARK_GREEN).setBlocksMovement(false).setBlocksLight(false).setSolid(false).setPistonPushReaction(PistonPushReaction.DESTROY).setReplaceable(true).setBurnable(true);
    }

    public static Material NETHER_WOOD() {
        return Material.create(MapColor.OAK_TAN);
    }

    public static Material PISTON() {
        return (Material) net.minecraft.block.material.Material.PISTON;
    }

    public static Material PLANT() {
        return (Material) net.minecraft.block.material.Material.PLANTS;
    }

    public static Material PLANT_REPLACEABLE() {
        return (Material) net.minecraft.block.material.Material.VINE;
    }

    public static Material PLANT_UNDERWATER() {
        return (Material) net.minecraft.block.material.Material.CORAL;
    }

    public static Material PORTAL() {
        return (Material) net.minecraft.block.material.Material.PORTAL;
    }

    public static Material REDSTONE_LIGHT() {
        return (Material) net.minecraft.block.material.Material.REDSTONE_LIGHT;
    }

    public static Material ROCK() {
        return (Material) net.minecraft.block.material.Material.ROCK;
    }

    public static Material SAND() {
        return (Material) net.minecraft.block.material.Material.SAND;
    }

    public static Material SCULK() {
        return Material.create(MapColor.BLACK);
    }

    public static Material SNOW_BLOCK() {
        return (Material) net.minecraft.block.material.Material.CRAFTED_SNOW;
    }

    public static Material SNOW_LAYER() {
        return (Material) net.minecraft.block.material.Material.SNOW;
    }

    public static Material SNOW_POWDER() {
        return Material.create(MapColor.WHITE).setSolid(false).setBlocksMovement(false);
    }

    public static Material SOIL() {
        return (Material) net.minecraft.block.material.Material.GROUND;
    }

    public static Material SPONGE() {
        return (Material) net.minecraft.block.material.Material.SPONGE;
    }

    public static Material STRUCTURE_VOID() {
        return (Material) net.minecraft.block.material.Material.STRUCTURE_VOID;
    }

    public static Material TNT() {
        return (Material) net.minecraft.block.material.Material.TNT;
    }

    public static Material WATER() {
        return (Material) net.minecraft.block.material.Material.WATER;
    }

    public static Material WEB() {
        return (Material) net.minecraft.block.material.Material.WEB;
    }

    public static Material WOOD() {
        return (Material) net.minecraft.block.material.Material.WOOD;
    }

    public static Material WOOL() {
        return (Material) net.minecraft.block.material.Material.CLOTH;
    }
}
