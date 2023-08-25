package net.meshmc.mesh.event.events.client;

import net.meshmc.mesh.event.MeshEvent;

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
        super("tick_" + type.name(), era);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public static class Client extends TickEvent {
        public Client(Era era) {
            super(Type.CLIENT, era);
        }
    }

    public static class GameLoop extends TickEvent {
        public GameLoop(Era era) {
            super(Type.GAMELOOP, era);
        }
    }

    public static class World extends TickEvent {
        public World(Era era) {
            super(Type.WORLD, era);
        }
    }

    public static class Motion extends TickEvent {
        public Motion(Era era) {
            super(Type.MOTION, era);
        }
    }
}
