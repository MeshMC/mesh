package net.meshmc.mesh.impl.wrapper.util;

import net.meshmc.mesh.api.util.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;

public class KeyboardMesh extends Keyboard {
    @Override
    public boolean hasControlDown() {
        if (MinecraftClient.IS_SYSTEM_MAC) {
            return InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 343) || InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 347);
        } else {
            return InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 341) || InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 345);
        }
    }

    @Override
    public boolean hasShiftDown() {
        return InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 340) || InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 344);
    }

    @Override
    public boolean hasAltDown() {
        return InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 342) || InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 346);
    }

    @Override
    public boolean isCut(int code) {
        return code == 88 && hasControlDown() && !hasShiftDown() && !hasAltDown();
    }

    @Override
    public boolean isPaste(int code) {
        return code == 86 && hasControlDown() && !hasShiftDown() && !hasAltDown();
    }

    @Override
    public boolean isCopy(int code) {
        return code == 67 && hasControlDown() && !hasShiftDown() && !hasAltDown();
    }

    @Override
    public boolean isSelectAll(int code) {
        return code == 65 && hasControlDown() && !hasShiftDown() && !hasAltDown();
    }
}
