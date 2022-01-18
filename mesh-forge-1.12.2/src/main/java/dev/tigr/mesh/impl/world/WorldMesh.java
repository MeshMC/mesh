package dev.tigr.mesh.impl.world;

import dev.tigr.mesh.api.AbstractMesh;
import dev.tigr.mesh.api.world.World;
import net.minecraft.client.multiplayer.WorldClient;

/**
 * @author Tigermouthbear 1/16/22
 */
public class WorldMesh<T extends net.minecraft.world.World> extends AbstractMesh<T> implements World<T> {
    public WorldMesh(T value) {
        super(value);
    }

    public static World<?> fromWorld(net.minecraft.world.World world) {
        if(world instanceof WorldClient) return new ClientWorldMesh((WorldClient) world);
        return new WorldMesh<>(world);
    }
}
