package net.meshmc.mesh.event.events.render;

import net.meshmc.mesh.event.MeshEvent;

/**
 * @author Tigermouthbear 1/15/22
 */
public class RenderEvent extends MeshEvent {
    // TODO: ERA?
    public enum Type {
        HUD,
        WORLD
    }

    private final Type type;
    private final float tickDelta;

    public RenderEvent(Type type, float tickDelta) {
        super("render_" + type.name());
        this.type = type;
        this.tickDelta = tickDelta;
    }

    public Type getType() {
        return type;
    }

    public float getTickDelta() {
        return tickDelta;
    }

    public static class Hud extends RenderEvent {
        public Hud(float tickDelta) {
            super(Type.HUD, tickDelta);
        }
    }

    public static class World extends RenderEvent {
        public World(float tickDelta) {
            super(Type.WORLD, tickDelta);
        }
    }
}
