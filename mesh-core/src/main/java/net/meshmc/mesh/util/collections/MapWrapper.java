package net.meshmc.mesh.util.collections;

import net.meshmc.mesh.api.AbstractMesh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Used for wrapping maps.
 *
 * It is assumed that B is a subclass of A and that all elements of the map
 * are instances of B.
 *
 * It is not specified that B extends A because intellij doesn't like it
 * when B extends A by using mixin + interface which is the primary use for this
 *
 * @author Makrennel 03/13/2022
 *
 * @param <A> Superclass
 * @param <B> Must be a subclass of parameter A
 * @param <C> Superclass
 * @param <D> Must be a subclass of parameter C
 */
@SuppressWarnings("unchecked")
public class MapWrapper<A, B, C, D> extends AbstractMesh<Map<B, D>> implements Map<A, C> {
    public MapWrapper(Map<B, D> value) {
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
    public boolean containsKey(Object key) {
        return getMeshValue().containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return getMeshValue().containsValue(value);
    }

    @Override
    public C get(Object key) {
        return (C) getMeshValue().get(key);
    }

    @Nullable
    @Override
    public C put(A key, C value) {
        return (C) getMeshValue().put((B) key, (D) value);
    }

    @Override
    public C remove(Object key) {
        return (C) getMeshValue().remove(key);
    }

    @Override
    public void putAll(@NotNull Map<? extends A, ? extends C> m) {
        getMeshValue().putAll(new MapWrapper<>(m));
    }

    @Override
    public void clear() {
        getMeshValue().clear();
    }

    @NotNull
    @Override
    public Set<A> keySet() {
        return new SetWrapper<>(getMeshValue().keySet());
    }

    @NotNull
    @Override
    public Collection<C> values() {
        return new CollectionWrapper<>(getMeshValue().values());
    }

    @NotNull
    @Override
    public Set<Entry<A, C>> entrySet() {
        return new SetWrapper<>(getMeshValue().entrySet());
    }
}
