package dev.tigr.mesh.events.client;

import dev.tigr.mesh.events.MeshEvent;

/**
 * All events which are called every tick
 *
 * @author Makrennel 2022/01/02
 */
public class TickEvent extends MeshEvent {
    public enum Type {
        CLIENT, GAMELOOP, PLAYER, WORLD, MOTION
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
