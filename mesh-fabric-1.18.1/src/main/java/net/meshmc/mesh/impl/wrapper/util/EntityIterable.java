package net.meshmc.mesh.impl.wrapper.util;

import net.meshmc.mesh.api.AbstractMesh;
import net.meshmc.mesh.api.entity.Entity;

import java.util.Iterator;

public class EntityIterable extends AbstractMesh<Iterable<net.minecraft.entity.Entity>> implements Iterable<Entity> {
    public EntityIterable(Iterable<net.minecraft.entity.Entity> value) {
        super(value);
    }

    @Override
    public Iterator<Entity> iterator() {
        return new EntityIterator(getMeshValue().iterator());
    }

    public record EntityIterator(Iterator<net.minecraft.entity.Entity> iterator) implements Iterator<Entity> {

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Entity next() {
            return (Entity) iterator.next();
        }
    }
}
