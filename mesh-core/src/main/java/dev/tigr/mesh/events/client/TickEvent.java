package dev.tigr.mesh.events.client;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.events.Era;
import dev.tigr.simpleevents.event.Event;

/**
 * @author Makrennel 2022/01/02
 */
public class TickEvent extends Event {
    public enum Type {
        CLIENT, GAMELOOP, PLAYER, WORLD, MOTION
    }

    public final Era era;
    public final Type type;

    private TickEvent(Type type, Era era) {
        this.type = type;
        this.era = era;
    }

    public static class Client extends TickEvent {
        private Client(Era era) {
            super(Type.CLIENT, era);
        }

        public static void post(Era era) {
            Mesh.getMesh().getMinecraft().getProfiler().pushSection("mesh_" + era.name().toLowerCase() + "_client");
            Mesh.getMesh().getEventManager().post(new Client(era));
            Mesh.getMesh().getMinecraft().getProfiler().popSection();
        }
    }

    public static class GameLoop extends TickEvent {
        private GameLoop(Era era) {
            super(Type.GAMELOOP, era);
        }

        public static void post(Era era) {
            Mesh.getMesh().getMinecraft().getProfiler().pushSection("mesh_" + era.name().toLowerCase() + "_gameloop");
            Mesh.getMesh().getEventManager().post(new GameLoop(era));
            Mesh.getMesh().getMinecraft().getProfiler().popSection();
        }
    }

    public static class World extends TickEvent {
        private World(Era era) {
            super(Type.WORLD, era);
        }

        public static void post(Era era) {
            Mesh.getMesh().getMinecraft().getProfiler().pushSection("mesh_" + era.name().toLowerCase() + "_world");
            Mesh.getMesh().getEventManager().post(new World(era));
            Mesh.getMesh().getMinecraft().getProfiler().popSection();
        }
    }

    public static class Player extends TickEvent {
        public final int playerId;

        private Player(Era era, int playerId) {
            super(Type.PLAYER, era);
            this.playerId = playerId;
        }

        public static void post(Era era, int playerId) {
            Mesh.getMesh().getMinecraft().getProfiler().pushSection("mesh_" + era.name().toLowerCase() + "_player");
            Mesh.getMesh().getEventManager().post(new Player(era, playerId));
            Mesh.getMesh().getMinecraft().getProfiler().popSection();
        }
    }

    public static class Motion extends TickEvent {
        private Motion(Era era) {
            super(Type.MOTION, era);
        }

        public static void post(Era era) {
            Mesh.getMesh().getMinecraft().getProfiler().pushSection("mesh_" + era.name().toLowerCase() + "_motion");
            Mesh.getMesh().getEventManager().post(new Motion(era));
            Mesh.getMesh().getMinecraft().getProfiler().popSection();
        }
    }
}
