package net.meshmc.mesh.impl;

import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.event.events.client.InputEvent;
import net.meshmc.mesh.event.events.render.RenderEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Mouse;

/**
 * Here we listen for forge events, then repost them if they are also mesh events
 * @author Tigermouthbear 1/15/22
 */
public class ForgeEvents {
    @SubscribeEvent
    public void render3d(RenderWorldLastEvent event) {
        Mesh.getMesh().getEventManager().post(new RenderEvent.World(event.getPartialTicks()));
    }

    @SubscribeEvent
    public void onMouseInput(MouseEvent event) {
        Mesh.getMesh().getEventManager().post(new InputEvent.Mouse.Moved(
                event.getX(), Minecraft.getMinecraft().displayHeight - event.getY(),
                event.getDx(), -event.getDy()
        ));

        if(Mouse.hasWheel() && event.getDwheel() != 0) {
            Mesh.getMesh().getEventManager().post(new InputEvent.Mouse.Scrolled(event.getDwheel() / 50D));
        }

        if(event.getButton() != -1) {
            if(event.isButtonstate()) {
                Mesh.getMesh().getEventManager().post(new InputEvent.Mouse.Pressed(event.getButton()));
            } else {
                Mesh.getMesh().getEventManager().post(new InputEvent.Mouse.Released(event.getButton()));
            }
        }
    }
}
