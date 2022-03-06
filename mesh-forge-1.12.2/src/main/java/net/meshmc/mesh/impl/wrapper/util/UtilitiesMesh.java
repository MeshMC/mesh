package net.meshmc.mesh.impl.wrapper.util;

import net.meshmc.mesh.api.util.Keyboard;
import net.meshmc.mesh.api.util.Utilities;

public class UtilitiesMesh extends Utilities {
    private final KeyboardMesh keyboard = new KeyboardMesh();

    @Override
    public Keyboard getKeyboard() {
        return keyboard;
    }
}
