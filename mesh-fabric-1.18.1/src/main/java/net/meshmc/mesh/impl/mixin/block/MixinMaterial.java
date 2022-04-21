package net.meshmc.mesh.impl.mixin.block;

import net.meshmc.mesh.api.block.MapColor;
import net.meshmc.mesh.api.block.Material;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.util.block.PistonPushReaction;
import net.minecraft.block.piston.PistonBehavior;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = net.minecraft.block.Material.class, priority = Integer.MAX_VALUE)
public class MixinMaterial implements Material {
    @Mutable @Shadow @Final private boolean liquid;
    @Mutable @Shadow @Final private boolean solid;
    @Mutable @Shadow @Final private boolean blocksMovement;
    @Mutable @Shadow @Final private boolean blocksLight;
    @Mutable @Shadow @Final private boolean burnable;
    @Mutable @Shadow @Final private boolean replaceable;
    @Mutable @Shadow @Final private net.minecraft.block.MapColor color;
    @Mutable @Shadow @Final private PistonBehavior pistonBehavior;

    @Override
    public boolean isLiquid_() {
        return liquid;
    }

    @Override
    public Material setLiquid(boolean value) {
        liquid = value;
        return this;
    }

    @Override
    public boolean isSolid_() {
        return solid;
    }

    @Override
    public Material setSolid(boolean value) {
        solid = value;
        return this;
    }

    @Override
    public boolean doesBlockMovement() {
        return blocksMovement;
    }

    @Override
    public Material setBlocksMovement(boolean value) {
        blocksMovement = value;
        return this;
    }

    @Override
    public boolean doesBlockLight() {
        return blocksLight;
    }

    @Override
    public Material setBlocksLight(boolean value) {
        blocksLight = value;
        return this;
    }

    @Override
    public boolean isBurnable() {
        return burnable;
    }

    @Override
    public Material setBurnable(boolean value) {
        burnable = value;
        return this;
    }

    @Override
    public boolean isReplaceable() {
        return replaceable;
    }

    @Override
    public Material setReplaceable(boolean value) {
        replaceable = value;
        return this;
    }

    @Override
    public MapColor getColorOnMap() {
        return (MapColor) color;
    }

    @Override
    public Material setColorOnMap(MapColor color) {
        this.color = (net.minecraft.block.MapColor) color;
        return this;
    }

    @Override
    public PistonPushReaction getPistonPushReaction() {
        return MeshEnum.pistonReaction(pistonBehavior);
    }

    @Override
    public Material setPistonPushReaction(PistonPushReaction pistonPushReaction) {
        pistonBehavior = MCEnum.pistonReaction(pistonPushReaction);
        return this;
    }
}
