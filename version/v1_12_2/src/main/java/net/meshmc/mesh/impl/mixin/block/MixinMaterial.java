package net.meshmc.mesh.impl.mixin.block;

import net.meshmc.mesh.api.block.MapColor;
import net.meshmc.mesh.api.block.Material;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.util.block.PistonPushReaction;
import net.minecraft.block.material.EnumPushReaction;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = net.minecraft.block.material.Material.class, priority = Integer.MAX_VALUE)
public abstract class MixinMaterial implements Material {
    @Shadow private boolean canBurn;
    @Shadow private boolean replaceable;
    @Shadow private EnumPushReaction pushReaction;
    @Mutable @Shadow @Final private net.minecraft.block.material.MapColor materialMapColor;
    @Shadow public abstract boolean isLiquid();
    @Shadow public abstract boolean isSolid();
    @Shadow public abstract boolean blocksMovement();
    @Shadow public abstract boolean blocksLight();

    Boolean isLiquid = isLiquid();
    @Inject(method = "isLiquid", at = @At("HEAD"), cancellable = true)
    private void replaceIsLiquid(CallbackInfoReturnable<Boolean> cir) {
        if(isLiquid != null) {
            cir.setReturnValue(isLiquid);
            cir.cancel();
        }
    }

    @Override
    public boolean isLiquid_() {
        return isLiquid;
    }

    @Override
    public Material setLiquid(boolean value) {
        isLiquid = value;
        return this;
    }

    boolean isSolid = isSolid();
    @Inject(method = "isSolid", at = @At("HEAD"), cancellable = true)
    private void replaceIsSolid(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(isSolid);
        cir.cancel();
    }

    @Override
    public boolean isSolid_() {
        return isSolid;
    }

    @Override
    public Material setSolid(boolean value) {
        isSolid = value;
        return this;
    }

    boolean blocksMovement = blocksMovement();
    @Inject(method = "blocksMovement", at = @At("HEAD"), cancellable = true)
    private void replaceBlocksMovement(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(blocksMovement);
        cir.cancel();
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

    boolean blocksLight = blocksLight();
    @Inject(method = "blocksLight", at = @At("HEAD"), cancellable = true)
    private void replaceBlocksLight(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(blocksLight);
        cir.cancel();
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
        return canBurn;
    }

    @Override
    public Material setBurnable(boolean value) {
        canBurn = value;
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
        return (MapColor) materialMapColor;
    }

    @Override
    public Material setColorOnMap(MapColor color) {
        materialMapColor = (net.minecraft.block.material.MapColor) color;
        return this;
    }

    @Override
    public PistonPushReaction getPistonPushReaction() {
        return MeshEnum.pistonReaction(pushReaction);
    }

    @Override
    public Material setPistonPushReaction(PistonPushReaction pistonPushReaction) {
        pushReaction = MCEnum.pistonReaction(pistonPushReaction);
        return this;
    }
}
