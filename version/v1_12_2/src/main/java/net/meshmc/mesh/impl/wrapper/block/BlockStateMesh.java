package net.meshmc.mesh.impl.wrapper.block;

import net.meshmc.mesh.api.block.BlockState;
import net.meshmc.mesh.api.block.MapColor;
import net.meshmc.mesh.api.block.Material;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.world.World;
import net.meshmc.mesh.impl.util.Mappings;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

/**
 * @author Makrennel 04/23/2022
 */
public class BlockStateMesh extends BlockState<IBlockState> {
    public BlockStateMesh(IBlockState value) {
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
        return getMeshValue().getLightValue();
    }

    @Override
    public int getOpacity(World world, BlockPos blockPos) {
        return getMeshValue().getLightOpacity((net.minecraft.world.World) world, (net.minecraft.util.math.BlockPos) blockPos);
    }

    @Override
    public boolean isAir() {
        return getMeshValue().getBlock() == Blocks.AIR;
    }

    @Override
    public Material getMaterial() {
        return (Material) getMeshValue().getMaterial();
    }

    @Override
    public MapColor getMapColor(World world, BlockPos blockPos) {
        return (MapColor) getMeshValue().getMapColor((net.minecraft.world.World) world, (net.minecraft.util.math.BlockPos) blockPos);
    }

    @Override
    public float getHardness(World world, BlockPos blockPos) {
        return getMeshValue().getBlockHardness((net.minecraft.world.World) world, (net.minecraft.util.math.BlockPos) blockPos);
    }

    @Override
    public boolean isOpaque() {
        return getMeshValue().isOpaqueCube();
    }
}
