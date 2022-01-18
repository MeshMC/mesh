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
import dev.tigr.mesh.util.render.Vertex;
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
        BufferBuilder<?> buffer = MESH.getRenderer().getBufferBuilder();
        buffer.begin(Renderer.DrawMode.TRIANGLES, Renderer.VertexFormat.POSITION_COLOR);
        buffer.construct(
                new Vertex(50,0, Color.GREEN),
                new Vertex(0,0, Color.GREEN),
                new Vertex(0,50, Color.GREEN),
                new Vertex(0,50, Color.BLUE),
                new Vertex(50,50, Color.BLUE),
                new Vertex(50,0, Color.BLUE)
        );
        buffer.draw();

        // draw an image with custom color
        // QUADS isn't the best, but this demonstrates that it works
        MESH.getRenderer().getRenderState().texture(true);
        MESH.getRenderer().bindTexture(HELMET_IMAGE);
        buffer.begin(Renderer.DrawMode.QUADS, Renderer.VertexFormat.POSITION_TEXTURE_COLOR);
        // for demonstration's purposes this mixes both construction methods to make a single quad
        buffer.construct(
                //x,y,z,    r,g,b,a,    u,v
                50,50,0,    1,0,0,1,    0,1,
                100,50,0,   1,0,0,1,    1,1
        );
        buffer.construct(
                new Vertex(100,0).color(1,0,0,1).texture(1,0),
                new Vertex(50,0).color(1,0,0,1).texture(0,0)
        );
        buffer.draw();

        // draw text using minecraft's font renderer
        MESH.getMinecraft().getTextRenderer().drawText(text, 2, 55, Color.WHITE);
        MESH.getRenderer().getRenderState()
                .texture(false)
                .lineWeight(4);

        // draw a line with color
        buffer.begin(Renderer.DrawMode.LINES, Renderer.VertexFormat.LINES);
        buffer.construct(
                //x,y,z,    r,g,b,a
                100,0,0,    1,0,0,1,
                100,50,0,   1,0,0,1,
                100,50,0,   0,1,0,1,
                50,50,0,    0,1,0,1
        );
        buffer.draw();

        // draw a line strip with color
        buffer.begin(Renderer.DrawMode.LINE_STRIP, Renderer.VertexFormat.POSITION_COLOR);
        buffer.construct( // TODO: Figure out how to do 1.12 gradient lines
                new Vertex(125,0).color(Color.rainbow(32, 0.333f, 1, 1)),
                new Vertex(125,75).color(Color.rainbow(32, 0, 1, 1)),
                new Vertex(0,75).color(Color.rainbow(32, 0.667f, 1, 1))
        );
        buffer.draw();

        // reset render state
        MESH.getRenderer().getRenderState()
                .alpha(true)
                .depth(true)
                .lineWeight(1);
    });
}
