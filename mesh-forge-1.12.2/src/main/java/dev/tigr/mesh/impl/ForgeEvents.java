package dev.tigr.mesh.impl;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.event.events.render.HudRenderEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Here we listen for forge events, then repost them if they are also mesh events
 * @author Tigermouthbear 1/15/22
 */
public class ForgeEvents {
    @SubscribeEvent
    public void render2d(RenderGameOverlayEvent.Post event) {
        if(event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE
         || (Minecraft.getMinecraft().player.getRidingEntity() instanceof AbstractHorse
         && event.getType() == RenderGameOverlayEvent.ElementType.HEALTHMOUNT)) {
            Mesh.getMesh().getEventManager().post(new HudRenderEvent());
        }
    }
}
