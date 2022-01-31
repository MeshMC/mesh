package dev.tigr.mesh.impl.util;

import dev.tigr.mesh.api.AbstractMesh;
import dev.tigr.mesh.impl.mixininterface.entity.Entity;

import java.util.Iterator;

public class EntityIterable extends AbstractMesh<Iterable<net.minecraft.entity.Entity>> implements Iterable<Entity> {
    public EntityIterable(Iterable<net.minecraft.entity.Entity> value) {
        super(value);
    }

    @Override
    public Iterator<Entity> iterator() {
        return new EntityIterator(getMeshValue().iterator());
    }

    public static class EntityIterator implements Iterator<Entity> {
        private final Iterator<net.minecraft.entity.Entity> iterator;

        public EntityIterator(Iterator<net.minecraft.entity.Entity> iterator) {
            this.iterator = iterator;
        }

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
