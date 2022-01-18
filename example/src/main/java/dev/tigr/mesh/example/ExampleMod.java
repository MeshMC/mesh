package dev.tigr.mesh.example;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.api.entity.Entity;
import dev.tigr.mesh.api.entity.EntityType;
import dev.tigr.mesh.api.render.BufferBuilder;
import dev.tigr.mesh.api.render.Renderer;
import dev.tigr.mesh.event.MeshEvent;
import dev.tigr.mesh.event.events.TickEvent;
import dev.tigr.mesh.event.events.render.HudRenderEvent;
import dev.tigr.mesh.util.render.Color;
import dev.tigr.mesh.util.render.GlState;
import dev.tigr.mesh.util.render.LocationIdentifier;
import dev.tigr.simpleevents.listener.EventHandler;
import dev.tigr.simpleevents.listener.EventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mesh.Mod(name = "Example Mod", modid = "examplemod", version = "1.0", description = "An example mod using the Mesh platform")
public class ExampleMod {
    private static final Logger LOGGER = LogManager.getLogger("Example Mod");
    public static final Mesh MESH = Mesh.getMesh();

    private static final LocationIdentifier HELMET_IMAGE = new LocationIdentifier("examplemod", "helmet.png");
    private String text = "Hello from Mesh!";

    public void init() {
        LOGGER.info("Example Mod loaded in {} {}!",
                MESH.getLoaderType().name().toLowerCase(), MESH.getLoaderVersion());

        // woah, platform independent code!!!
        LOGGER.info("Hello {}!", MESH.getMinecraft().getSession().getUsername());

        // registering and event listener
        MESH.getEventManager().register(this);
    }

    @EventHandler
    public EventListener<TickEvent> tickEventListener = new EventListener<>(event -> {
        if(event.getType() == TickEvent.Type.CLIENT && event.getEra() == MeshEvent.Era.AFTER && MESH.getMinecraft().getWorld() != null) {
            int num = 0;
            for(Entity<?> entity: MESH.getMinecraft().getWorld().getEntities()) {
                if(entity.getEntityType() == EntityType.PLAYER) num++;
            }
            text = "Hello from Mesh, to " + num + " players!";
        }
    });

    @EventHandler
    public EventListener<HudRenderEvent> hudRenderEventListener = new EventListener<>(event -> {
        // prepare render state
        MESH.getRenderer().getRenderState()
        .alpha(false)
        .depth(false)
        .blend(true)
        .blendFunc(GlState.SourceFactor.SRC_ALPHA, GlState.DestFactor.ONE_MINUS_SRC_ALPHA)
        .cull(false)
        .texture(false);

        // draw a simple 2 colored square on the hud
        BufferBuilder<?> bufferBuilder = MESH.getRenderer().begin(Renderer.DrawMode.TRIANGLES, Renderer.VertexFormat.POSITION_COLOR);
        bufferBuilder.vertex(50, 0).color(Color.GREEN).next();
        bufferBuilder.vertex(0, 0).color(Color.GREEN).next();
        bufferBuilder.vertex(0, 50).color(Color.GREEN).next();
        bufferBuilder.vertex(0, 50).color(Color.BLUE).next();
        bufferBuilder.vertex(50, 50).color(Color.BLUE).next();
        bufferBuilder.vertex(50, 0).color(Color.BLUE).next();
        MESH.getRenderer().draw();

        // draw an image with custom color
        // QUADS isn't the best, but this demonstrates that it works
        MESH.getRenderer().getRenderState().texture(true);
        MESH.getRenderer().bindTexture(HELMET_IMAGE);
        bufferBuilder = MESH.getRenderer().begin(Renderer.DrawMode.QUADS, Renderer.VertexFormat.POSITION_TEXTURE_COLOR);
        bufferBuilder.vertex(50, 50).texture(0, 1).color(Color.RED).next();
        bufferBuilder.vertex(100, 50).texture(1, 1).color(Color.RED).next();
        bufferBuilder.vertex(100, 0).texture(1, 0).color(Color.RED).next();
        bufferBuilder.vertex(50, 0).texture(0, 0).color(Color.RED).next();
        MESH.getRenderer().draw();

        // draw text using minecraft's font renderer
        MESH.getMinecraft().getTextRenderer().drawText(text, 2, 55, Color.WHITE);
        MESH.getRenderer().getRenderState().texture(false);

        // draw a line with color
        bufferBuilder = MESH.getRenderer().begin(Renderer.DrawMode.LINES, Renderer.VertexFormat.LINES);
        bufferBuilder.vertex(100, 0).color(Color.RED).next();
        bufferBuilder.vertex(100, 50).color(Color.RED).next();
        bufferBuilder.vertex(100, 50).color(Color.GREEN).next();
        bufferBuilder.vertex(50, 50).color(Color.GREEN).next();
        MESH.getRenderer().draw();

        // reset render state
        MESH.getRenderer().getRenderState()
        .alpha(true)
        .depth(true);
    });
}
