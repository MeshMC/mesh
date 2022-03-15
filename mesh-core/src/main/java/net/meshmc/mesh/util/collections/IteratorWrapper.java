package net.meshmc.mesh.util.collections;

import net.meshmc.mesh.api.AbstractMesh;

import java.util.Iterator;

/**
 * Used for wrapping iterators.
 *
 * It is assumed that B is a subclass of A and that all elements of the iterators
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
public class IteratorWrapper<A, B> extends AbstractMesh<Iterator<B>> implements Iterator<A> {
    public IteratorWrapper(Iterator<B> value) {
        super(value);
    }

    @Override
    public boolean hasNext() {
        return getMeshValue().hasNext();
    }

    @Override
    public A next() {
        return (A) getMeshValue().next();
    }
}
