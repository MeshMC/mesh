package net.meshmc.mesh.example

import net.meshmc.mesh.Mesh
import net.meshmc.mesh.api.render.Renderer
import net.meshmc.mesh.event.MeshEvent
import net.meshmc.mesh.event.events.client.TickEvent
import net.meshmc.mesh.event.events.render.HudRenderEvent
import net.meshmc.mesh.impl.mixininterface.entity.living.player.EntityPlayer
import net.meshmc.mesh.util.render.Color
import net.meshmc.mesh.util.render.GlState
import net.meshmc.mesh.util.render.LocationIdentifier
import net.meshmc.mesh.util.render.Vertex
import dev.tigr.simpleevents.listener.EventHandler
import dev.tigr.simpleevents.listener.EventListener
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mesh.Mod(name = "Example Mod", modid = "examplemod", version = "1.0", description = "An example mod using the Mesh platform")
class ExampleMod: Mesh.Initializer {
    companion object {
        val LOGGER: Logger = LogManager.getLogger("Example Mod")
        val MESH: Mesh = Mesh.getMesh()
    }

    override fun init() {
        LOGGER.info("Example Mod loaded in {} {}!", MESH.loaderType.name.lowercase(), MESH.loaderVersion)

        // woah, platform independent code!!!
        LOGGER.info("Hello {}!", MESH.minecraft.session.username)

        // registering an event listener
        MESH.eventManager.register(this)
    }

    private val HELMET_IMAGE =
        LocationIdentifier("examplemod", "helmet.png")
    private var text = "Hello from Mesh!"

    @field:EventHandler
    val tickEventListener = EventListener { event: TickEvent ->
        if(event.type == TickEvent.Type.CLIENT && event.era == MeshEvent.Era.AFTER && MESH.minecraft.world != null)
            text = "Hello from Mesh, to ${MESH.minecraft.world.loadedEntities.count { it is EntityPlayer }} players!"
    }

    @field:EventHandler
    val hudRenderEventListener = EventListener<HudRenderEvent> {
        // prepare render state
        MESH.renderer.renderState
        .alpha(false)
        .depth(false)
        .blend(true)
        .blendFunc(GlState.SourceFactor.SRC_ALPHA, GlState.DestFactor.ONE_MINUS_SRC_ALPHA)
        .cull(false)
        .texture(false)

        // draw a simple 2 colored square on the hud
        val buffer = MESH.renderer.bufferBuilder
        buffer.begin(Renderer.DrawMode.TRIANGLES, Renderer.VertexFormat.POSITION_COLOR)
        buffer.construct(
            Vertex(50.0,
                0.0,
                Color.GREEN),
            Vertex(0.0,
                0.0,
                Color.GREEN),
            Vertex(0.0,
                50.0,
                Color.GREEN),
            Vertex(0.0,
                50.0,
                Color.BLUE),
            Vertex(50.0,
                50.0,
                Color.BLUE),
            Vertex(50.0,
                0.0,
                Color.BLUE)
        )
        buffer.draw()

        // draw an image with custom color
        // QUADS isn't the best, but this demonstrates that it works
        MESH.renderer.renderState.texture(true)
        MESH.renderer.bindTexture(HELMET_IMAGE)
        buffer.begin(Renderer.DrawMode.QUADS, Renderer.VertexFormat.POSITION_TEXTURE_COLOR)
        // for demonstration's purposes this mixes both construction methods to make a single quad
        buffer.construct(
            // x,   y,   z       r,   g,   b,   a      u,   v
            50.0, 50.0, 0.0,    1.0, 0.0, 0.0, 1.0,   0.0, 1.0,
            100.0, 50.0, 0.0,   1.0, 0.0, 0.0, 1.0,   1.0, 1.0
        )
        buffer.construct(
            Vertex(100.0, 0.0).color(1f, 0f, 0f, 1f).texture(1f, 0f),
            Vertex(50.0, 0.0).color(1f, 0f, 0f, 1f).texture(0f, 0f)
        )
        buffer.draw()

        // draw text using minecraft's font renderer
        MESH.minecraft.textRenderer.drawText(text, 2f, 55f, Color.WHITE)
        MESH.renderer.renderState
        .texture(false)
        .lineWeight(4f)

        // draw a line with color
        buffer.begin(Renderer.DrawMode.LINES, Renderer.VertexFormat.LINES)
        buffer.construct(
                // x,   y,   z,      r,   g,   b,   a
                100.0, 00.0, 0.0,   1.0, 0.0, 0.0, 1.0,
                100.0, 50.0, 0.0,   1.0, 0.0, 0.0, 1.0,
                100.0, 50.0, 0.0,   0.0, 1.0, 0.0, 1.0,
                050.0, 50.0, 0.0,   0.0, 1.0, 0.0, 1.0
        )
        buffer.draw()

        // draw a line strip with color
        buffer.begin(Renderer.DrawMode.LINE_STRIP, Renderer.VertexFormat.POSITION_COLOR)
        buffer.construct( // TODO: Figure out how to do 1.12 gradient lines
            Vertex(125.0, 0.0)
                .color(Color.rainbow(32, 0.333f, 1f, 1f)),
            Vertex(125.0, 75.0)
                .color(Color.rainbow(32, 0f, 1f, 1f)),
            Vertex(0.0, 75.0)
                .color(Color.rainbow(32, 0.667f, 1f, 1f))
        )
        buffer.draw()

        // reset render state
        MESH.renderer.renderState
        .alpha(true)
        .depth(true)
        .lineWeight(1f)
    }
}