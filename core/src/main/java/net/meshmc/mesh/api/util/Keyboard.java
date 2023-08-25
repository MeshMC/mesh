package net.meshmc.mesh.api.util;

/**
 * @author Tigermouthbear 3/3/22
 * provides utility functions for the keyboard
 * TODO: ADD MORE KEYBOARD UTILITY (KEYPRESS CALLBACKS)
 */
public abstract class Keyboard {
    public abstract boolean hasControlDown();

    public abstract boolean hasShiftDown();

    public abstract boolean hasAltDown();

    public abstract boolean isCut(int code);

    public abstract boolean isPaste(int code);

    public abstract boolean isCopy(int code);

    public abstract boolean isSelectAll(int code);
}
