package net.meshmc.mesh.api.util;

import dev.tigr.simpleevents.listener.EventHandler;
import dev.tigr.simpleevents.listener.EventListener;
import net.meshmc.mesh.event.MeshEvent;
import net.meshmc.mesh.event.events.client.TickEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tigermouthbear 3/3/22
 * a collection of utilities too small to warrent their own class
 * *this will become abstract when cross platfrom features are needed*
 */
public abstract class Utilities {
    private final List<Runnable> tasks = new ArrayList<>();

    // used to schedule a task to run on the next tick
    public void schedule(Runnable runnable) {
        tasks.add(runnable);
    }

    @EventHandler
    private final EventListener<TickEvent.Client> clientTickEvent = new EventListener<>(event -> {
        System.out.println("TEST");
        if(event.getEra() == MeshEvent.Era.BEFORE && tasks.size() > 0) {
            for(Runnable runnable: tasks) runnable.run();
            tasks.clear();
        }
    });

    public abstract Keyboard getKeyboard();
}
