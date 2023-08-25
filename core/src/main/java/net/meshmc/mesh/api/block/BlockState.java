package net.meshmc.mesh.api.block;

import net.meshmc.mesh.api.AbstractMesh;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.world.World;

import java.util.function.Supplier;

/**
 * @author Makrennel 04/23/2022
 *
 * Because of differences between 1.12 and 1.18 in how block IDs work
 * a block field is used so that use of "getBlock" doesn't poll hundreds
 * of if statements repeatedly.
 *
 * It may be better performance and logic-wise to give 1.12 priority in the mappings
 * and use Utils to break down variants in both 1.12 and 1.18....
 *
 * .... but I've been doing this for so long and I just want it to be done
 *
 * TODO: more BlockState stuff
 */
public abstract class BlockState<T> extends AbstractMesh<T> {
    public BlockState(T value, Supplier<Block> block) {
        super(value);
        this.block = block.get();
    }

    protected final Block block;

    public Block getBlock() {
        return block;
    }

    public abstract Enum<?> getBlockVariant();
    public abstract <V extends Enum<?>> V getBlockVariant(Class<V> variantsEnum);

    public abstract int getLuminance();
    public abstract int getOpacity(World world, BlockPos blockPos);
    public abstract boolean isAir();
    public abstract Material getMaterial();
    public abstract MapColor getMapColor(World world, BlockPos blockPos);
    public abstract float getHardness(World world, BlockPos blockPos);
    public abstract boolean isOpaque();
}
