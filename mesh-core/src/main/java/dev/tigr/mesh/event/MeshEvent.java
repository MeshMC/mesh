package dev.tigr.mesh.event;

import dev.tigr.simpleevents.event.Event;

/**
 * Represents an in-game event occurring in minecraft across versions
 */
public class MeshEvent extends Event {
    // when the event is posted in relation to the action
    public enum Era {
        BEFORE,
        AFTER
    }

    private final String name;
    private final Era era; // nullable

    public MeshEvent(String name, Era era) {
        this.name = name;
        this.era = era;
    }

    public MeshEvent(String name) {
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public Era getEra() {
        return era;
    }
}
