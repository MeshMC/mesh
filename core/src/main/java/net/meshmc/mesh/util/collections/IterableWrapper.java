package net.meshmc.mesh.util.collections;

import net.meshmc.mesh.api.AbstractMesh;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Used for wrapping iterables.
 *
 * It is assumed that B is a subclass of A and that all elements of the iterables
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
public class IterableWrapper<A, B> extends AbstractMesh<Iterable<B>> implements Iterable<A> {
    public IterableWrapper(Iterable<B> value) {
        super(value);
    }

    @NotNull
    @Override
    public Iterator<A> iterator() {
        return new IteratorWrapper<>(getMeshValue().iterator());
    }
}
