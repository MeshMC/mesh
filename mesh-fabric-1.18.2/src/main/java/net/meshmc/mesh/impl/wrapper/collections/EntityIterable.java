package net.meshmc.mesh.impl.wrapper.collections;

import net.meshmc.mesh.api.AbstractMesh;
import net.meshmc.mesh.api.entity.Entity;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class EntityIterable extends AbstractMesh<Iterable<net.minecraft.entity.Entity>> implements Iterable<Entity> {
    public EntityIterable(Iterable<net.minecraft.entity.Entity> value) {
        super(value);
    }

    @NotNull
    @Override
    public Iterator<Entity> iterator() {
        return new EntityIterator(getMeshValue().iterator());
    }
}
