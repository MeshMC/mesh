package net.meshmc.mesh.util.collections;

import net.meshmc.mesh.api.AbstractMesh;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Used for wrapping sets.
 *
 * It is assumed that B is a subclass of A and that all elements of the set
 * are instances of B.
 *
 * It is not specified that B extends A because intellij doesn't like it
 * when B extends A by using mixin + interface which is the primary use for this
 *
 * @author Makrennel 03/13/2022
 *
 * @param <A> Superclass
 * @param <B> Must be a subclass of parameter A
 */
@SuppressWarnings("unchecked")
public class SetWrapper<A, B> extends AbstractMesh<Set<B>> implements Set<A> {
    public SetWrapper(Set<B> value) {
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
        return getMeshValue().contains(o);
    }

    @NotNull
    @Override
    public Iterator<A> iterator() {
        return new IteratorWrapper<>(getMeshValue().iterator());
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return getMeshValue().toArray();
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return getMeshValue().toArray(a);
    }

    @Override
    public boolean add(A a) {
        return getMeshValue().add((B) a);
    }

    @Override
    public boolean remove(Object o) {
        return getMeshValue().remove(o);
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return getMeshValue().containsAll(c);
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends A> c) {
        boolean changed = false;
        for(A a: c) if(add(a)) changed = true;
        return changed;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return getMeshValue().retainAll(c);
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return getMeshValue().removeAll(c);
    }

    @Override
    public void clear() {
        getMeshValue().clear();
    }
}
