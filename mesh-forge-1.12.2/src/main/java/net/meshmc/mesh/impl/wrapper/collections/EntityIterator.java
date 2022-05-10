package net.meshmc.mesh.impl.wrapper.collections;

import net.meshmc.mesh.api.AbstractMesh;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.impl.util.Mappings;

import java.util.Iterator;

public class EntityIterator extends AbstractMesh<Iterator<net.minecraft.entity.Entity>> implements Iterator<Entity> {
    public EntityIterator(Iterator<net.minecraft.entity.Entity> value) {
        super(value);
    }

    @Override
    public boolean hasNext() {
        return getMeshValue().hasNext();
    }

    @Override
    public Entity next() {
        return Mappings.entity(getMeshValue().next());
    }
}
