package dev.tigr.mesh.events;

import dev.tigr.mesh.Mesh;
import dev.tigr.simpleevents.EventManager;

/**
 * This provides event profiling on top of the event manager
 * @author Tigermouthbear 1/10/22
 */
public class MeshEventManager extends EventManager {
    private final Mesh mesh;

    public MeshEventManager(Mesh mesh) {
        this.mesh = mesh;
    }

    @Override
    public <T> T post(T event) {
        if(event instanceof MeshEvent) {
            mesh.getMinecraft().getProfiler().pushSection("mesh_" + ((MeshEvent) event).getName() + "_" + ((MeshEvent) event).getEra().name().toLowerCase());
            T out = super.post(event);
            mesh.getMinecraft().getProfiler().popSection();
            return out;
        } else return super.post(event);
    }
}
