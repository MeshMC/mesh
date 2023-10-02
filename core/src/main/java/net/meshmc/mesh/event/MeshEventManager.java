package net.meshmc.mesh.event;

import dev.tigr.simpleevents.EventManager;
import net.meshmc.mesh.MeshAPI;
import net.meshmc.mesh.api.util.Profiler;

/**
 * This provides event profiling on top of the event manager
 * @author Tigermouthbear 1/10/22
 */
public class MeshEventManager extends EventManager {
    @Override
    public <T> T post(T event) {
        if(event instanceof MeshEvent) {
            MeshEvent meshEvent = (MeshEvent) event;
            Profiler<?> profiler = MeshAPI.getMinecraft().getProfiler();
            profiler.pushSection("mesh_" + meshEvent.getName() + (meshEvent.getEra() != null ? "_" + meshEvent.getEra().name().toLowerCase() : ""));
            T out = super.post(event);
            profiler.popSection();
            return out;
        } else return super.post(event);
    }
}
