package net.meshmc.mesh.api.render;

import net.meshmc.mesh.api.client.Minecraft;

public interface ScreenContext {
    // TODO: BUTTONS, OTHER SHIT
    int getWidth();
    void setWidth(int width);

    int getHeight();
    void setHeight(int height);

    Minecraft getMinecraft();
    void setMinecraft(Minecraft minecraft); // idk why you would do this?
}
