package net.meshmc.mesh.impl.wrapper.util;

import net.meshmc.mesh.api.util.Keyboard;
import net.minecraft.client.Minecraft;

public class KeyboardMesh extends Keyboard {
    @Override
    public boolean hasControlDown() {
        if(Minecraft.IS_RUNNING_ON_MAC)
            return org.lwjgl.input.Keyboard.isKeyDown(219) || org.lwjgl.input.Keyboard.isKeyDown(220);
        else
            return org.lwjgl.input.Keyboard.isKeyDown(29) || org.lwjgl.input.Keyboard.isKeyDown(157);
    }

    @Override
    public boolean hasShiftDown() {
        return org.lwjgl.input.Keyboard.isKeyDown(42) || org.lwjgl.input.Keyboard.isKeyDown(54);
    }

    @Override
    public boolean hasAltDown() {
        return org.lwjgl.input.Keyboard.isKeyDown(56) || org.lwjgl.input.Keyboard.isKeyDown(184);
    }

    @Override
    public boolean isCut(int code) {
        return code == 45 && hasControlDown() && !hasShiftDown() && !hasAltDown();
    }

    @Override
    public boolean isPaste(int code) {
        return code == 47 && hasControlDown() && !hasShiftDown() && !hasAltDown();
    }

    @Override
    public boolean isCopy(int code) {
        return code == 46 && hasControlDown() && !hasShiftDown() && !hasAltDown();
    }

    @Override
    public boolean isSelectAll(int code) {
        return code == 30 && hasControlDown() && !hasShiftDown() && !hasAltDown();
    }
}
