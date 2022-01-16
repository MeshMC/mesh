package dev.tigr.mesh.event;

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
            MeshEvent meshEvent = (MeshEvent) event;
            mesh.getMinecraft().getProfiler().pushSection("mesh_" + meshEvent.getName() + (meshEvent.getEra() != null ? "_" + meshEvent.getEra().name().toLowerCase() : ""));
            T out = super.post(event);
            mesh.getMinecraft().getProfiler().popSection();
            return out;
        } else return super.post(event);
    }
}
