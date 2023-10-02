package net.meshmc.mesh.impl.wrapper.collections;

import net.meshmc.mesh.api.AbstractMesh;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.impl.util.Mappings;
import net.meshmc.mesh.impl.wrapper.entity.EntityMesh;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class EntityList extends AbstractMesh<List<net.minecraft.entity.Entity>> implements List<Entity> {
    public EntityList(List<net.minecraft.entity.Entity> value) {
        super(value);
    }

    @Override
    public int size() {
        return getMeshValue().size();
    }

    @Override
    public boolean isEmpty() {
        return getMeshValue().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        if(o instanceof Entity) return getMeshValue().contains(((EntityMesh<?>) o).getMeshValue());
        return getMeshValue().contains(o);
    }

    @NotNull
    @Override
    public Iterator<Entity> iterator() {
        return new EntityIterator(getMeshValue().iterator());
    }

    @NotNull
    @Override
    public Object @NotNull [] toArray() {
        List<Entity> entities = new ArrayList<>();
        for(net.minecraft.entity.Entity entity: getMeshValue()) {
            entities.add(Mappings.entity(entity));
        }
        return entities.toArray();
    }

    @NotNull
    @Override
    // This works I guess? Probably don't use though
    public <T> T @NotNull [] toArray(@NotNull T[] a) {
        if (a.length < getMeshValue().size())
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(toArray(), getMeshValue().size(), a.getClass());
        System.arraycopy(toArray(), 0, a, 0, getMeshValue().size());
        if (a.length > getMeshValue().size())
            a[getMeshValue().size()] = null;
        return a;
    }

    @Override
    public boolean add(Entity entity) {
        return getMeshValue().add(((EntityMesh<?>) entity).getMeshValue());
    }

    @Override
    public boolean remove(Object o) {
        if(o instanceof Entity) return getMeshValue().remove(((EntityMesh<?>) o).getMeshValue());
        return getMeshValue().remove(o);
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        for(Object e: c) if(!contains(e)) return false;
        return true;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends Entity> c) {
        Collection<net.minecraft.entity.Entity> entityCollection = new ArrayList<>();
        for(Entity e: c) {
            entityCollection.add(((EntityMesh<?>) e).getMeshValue());
        }
        return getMeshValue().addAll(entityCollection);
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends Entity> c) {
        Collection<net.minecraft.entity.Entity> entityCollection = new ArrayList<>();
        for(Entity e: c) {
            entityCollection.add(((EntityMesh<?>) e).getMeshValue());
        }
        return getMeshValue().addAll(index, entityCollection);
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        for(Object o: c)
            if(contains(o)) {
                remove(o);
                modified = true;
            }
        return modified;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        for(Entity e: this) {
            if(!c.contains(e) && !c.contains(((EntityMesh<?>) e).getMeshValue())) {
                remove(e);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        getMeshValue().clear();
    }

    @Override
    public Entity get(int index) {
        return Mappings.entity(getMeshValue().get(index));
    }

    @Override
    public Entity set(int index, Entity element) {
        Entity original = Mappings.entity(getMeshValue().get(index));
        getMeshValue().set(index, ((EntityMesh<?>) element).getMeshValue());
        return original;
    }

    @Override
    public void add(int index, Entity element) {
        getMeshValue().add(index, ((EntityMesh<?>) element).getMeshValue());
    }

    @Override
    public Entity remove(int index) {
        return Mappings.entity(getMeshValue().remove(index));
    }

    @Override
    public int indexOf(Object o) {
        if(o instanceof Entity) return getMeshValue().indexOf(((EntityMesh<?>) o).getMeshValue());
        return getMeshValue().indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        if(o instanceof Entity) return getMeshValue().lastIndexOf(((EntityMesh<?>) o).getMeshValue());
        return getMeshValue().lastIndexOf(o);
    }

    @NotNull
    @Override
    public ListIterator<Entity> listIterator() {
        return null;
    }

    @NotNull
    @Override
    public ListIterator<Entity> listIterator(int index) {
        return null;
    }

    @NotNull
    @Override
    public List<Entity> subList(int fromIndex, int toIndex) {
        return new EntityList(getMeshValue().subList(fromIndex, toIndex));
    }
}
