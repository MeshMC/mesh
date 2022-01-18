package dev.tigr.mesh.api.world;

import dev.tigr.mesh.api.entity.Entity;

import java.util.List;

/**
 * @author Tigermouthbear 1/16/22
 */
public interface ClientWorld<T> extends World<T> {
    List<Entity<?>> getEntities();
}
