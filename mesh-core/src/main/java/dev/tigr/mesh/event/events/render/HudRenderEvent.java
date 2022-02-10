package dev.tigr.mesh.event.events.render;

import dev.tigr.mesh.event.MeshEvent;

/**
 * @author Tigermouthbear 1/15/22
 */
public class HudRenderEvent extends MeshEvent {
    private final float tickDelta;

    public float getTickDelta() {
        return tickDelta;
    }

    public HudRenderEvent(float tickDelta) {
        super("hud_render");
        this.tickDelta = tickDelta;
    }
}
