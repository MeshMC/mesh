package net.meshmc.mesh.impl.wrapper.block;

import net.meshmc.mesh.api.block.BlockState;
import net.meshmc.mesh.api.block.MapColor;
import net.meshmc.mesh.api.block.Material;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.world.World;
import net.meshmc.mesh.impl.util.Mappings;
import net.meshmc.mesh.impl.wrapper.world.WorldMesh;
import net.minecraft.block.AbstractBlock;

/**
 * @author Makrennel 04/22/2022
 */
public class BlockStateMesh extends BlockState<AbstractBlock.AbstractBlockState> {
    public BlockStateMesh(AbstractBlock.AbstractBlockState value) {
        super(value, () -> Mappings.block(value.getBlock()));
    }

    @Override
    public Enum<?> getBlockVariant() {
        return Mappings.blockVariant(block, getMeshValue());
    }

    @SuppressWarnings("unchecked")
    @Override
    public <V extends Enum<?>> V getBlockVariant(Class<V> variantsEnum) {
        return (V) Mappings.blockVariant(block, getMeshValue());
    }

    @Override
    public int getLuminance() {
        return getMeshValue().getLuminance();
    }

    @Override
    public int getOpacity(World world, BlockPos blockPos) {
        return getMeshValue().getOpacity(((WorldMesh<?>) world).getMeshValue(), (net.minecraft.util.math.BlockPos) blockPos);
    }

    @Override
    public boolean isAir() {
        return getMeshValue().isAir();
    }

    @Override
    public Material getMaterial() {
        return (Material) getMeshValue().getMaterial();
    }

    @Override
    public MapColor getMapColor(World world, BlockPos blockPos) {
        return (MapColor) getMeshValue().getMapColor(((WorldMesh<?>) world).getMeshValue(), (net.minecraft.util.math.BlockPos) blockPos);
    }

    @Override
    public float getHardness(World world, BlockPos blockPos) {
        return getMeshValue().getHardness(((WorldMesh<?>) world).getMeshValue(), (net.minecraft.util.math.BlockPos) blockPos);
    }

    @Override
    public boolean isOpaque() {
        return getMeshValue().isOpaque();
    }
}
