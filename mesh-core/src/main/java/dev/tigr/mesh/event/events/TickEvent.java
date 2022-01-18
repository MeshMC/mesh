package dev.tigr.mesh.event.events;

import dev.tigr.mesh.event.MeshEvent;

/**
 * All events which are called every tick
 *
 * @author Makrennel 2022/01/02
 */
public class TickEvent extends MeshEvent {
    public enum Type {
        CLIENT, GAMELOOP, WORLD, MOTION
    }

    private final Type type;

    public TickEvent(Type type, MeshEvent.Era era) {
        super("tick_" + type.name().toLowerCase(), era);
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
