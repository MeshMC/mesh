package net.meshmc.mesh.event.events.client;

import net.meshmc.mesh.event.MeshEvent;

// TODO: FIGURE OUT A WAY TO PASS SCREEN THROUGH EVENT
// rn ares needs to know if its the main menu, so this is all this does
public class ScreenOpenedEvent extends MeshEvent {
    private final boolean mainMenu;

    public ScreenOpenedEvent(boolean mainMenu) {
        super("screen_open", null);
        this.mainMenu = mainMenu;
    }

    public boolean isMainMenu() {
        return mainMenu;
    }
}
