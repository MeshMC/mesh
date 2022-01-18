package dev.tigr.mesh.api;

/**
 * @author Tigermouthbear 1/17/22
 * @param <T>
 */
public interface IMesh<T> {
    T getMeshValue();

    boolean isNull();

    boolean isNotNull();
}
