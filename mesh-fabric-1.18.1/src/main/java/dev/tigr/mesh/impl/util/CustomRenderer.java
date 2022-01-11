package dev.tigr.mesh.impl.util;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.tigr.mesh.util.math.Box;
import dev.tigr.mesh.util.render.Color;
import dev.tigr.mesh.util.render.IRenderStack;
import dev.tigr.mesh.util.render.IRenderer;
import dev.tigr.mesh.util.render.LocationIdentifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Matrix4f;

import java.util.HashMap;

/**
 * @author Tigermouthbear 1/10/22
 */
public class CustomRenderer extends HashMap<LocationIdentifier, AbstractTexture> implements IRenderer {
    private final CustomRenderStack renderStack = new CustomRenderStack();

    @Override
    public IRenderStack getRenderStack() {
        return renderStack;
    }

    @Override
    public void bindTexture(LocationIdentifier resourceLocation) {
        AbstractTexture texture = this.get(resourceLocation);
        if(texture == null) {
            try {
                texture = new NativeImageBackedTexture(NativeImage.read(CustomRenderer.class.getResourceAsStream(resourceLocation.getPath())));
                put(resourceLocation, texture);
            } catch(Exception e) {
                e.printStackTrace();
                return;
            }
        }

        RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
        RenderSystem.setShaderTexture(0, texture.getGlId());
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public void drawRect(double x, double y, double width, double height, Color color) {
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        Matrix4f model = getModel();
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(VertexFormat.DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        bufferBuilder.vertex(model, (float) (x + width), (float) y, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).next();
        bufferBuilder.vertex(model, (float) x, (float) y, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).next();
        bufferBuilder.vertex(model, (float) x, (float) (y + height), 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).next();
        bufferBuilder.vertex(model, (float) x, (float) (y + height), 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).next();
        bufferBuilder.vertex(model, (float) (x + width), (float) (y + height), 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).next();
        bufferBuilder.vertex(model, (float) (x + width), (float) y, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).next();
        draw();
    }

    @Override
    public void drawImage(double x, double y, double width, double height, LocationIdentifier identifier) {
        drawImage(x, y, width, height, identifier, Color.WHITE);
    }

    @Override
    public void drawImage(double x, double y, double width, double height, LocationIdentifier identifier, Color color) {
        // bind texture
        bindTexture(identifier);

        // draw it
        Matrix4f model = getModel();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(VertexFormat.DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR_TEXTURE);
        bufferBuilder.vertex(model, (float) (x + width), (float) y, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).texture(1, 0).next();
        bufferBuilder.vertex(model, (float) x, (float) y, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).texture(0, 0).next();
        bufferBuilder.vertex(model, (float) x, (float) (y + height), 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).texture(0, 1).next();
        bufferBuilder.vertex(model, (float) x, (float) (y + height), 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).texture(0, 1).next();
        bufferBuilder.vertex(model, (float) (x + width), (float) (y + height), 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).texture(1, 1).next();
        bufferBuilder.vertex(model, (float) (x + width), (float) y, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).texture(1, 0).next();
        draw(true);
    }

    @Override
    public void drawLine(double startX, double startY, double endX, double endY, int weight, Color color) {
        drawLine(startX, startY, 0, endX, endY, 0, weight, color);
    }

    public void drawLine(double startX, double startY, double startZ, double endX, double endY, double endZ, int weight, Color color) {
        RenderSystem.lineWidth(weight);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        Matrix4f model = getModel();

        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
        bufferBuilder.vertex(model, (float) startX, (float) startY, (float) startZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).next();
        bufferBuilder.vertex(model, (float) endX, (float) endY, (float) endZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).next();
        draw();
        RenderSystem.lineWidth(1);
    }

    @Override
    public void drawLineLoop(int weight, Color color, double... points) {
        if(points.length % 2 != 0) return;

        boolean first = true;
        double firstX = 0, firstY = 0, prevX = 0, prevY = 0, x, y;
        RenderSystem.lineWidth(weight);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        Matrix4f model = getModel();
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(VertexFormat.DrawMode.DEBUG_LINE_STRIP, VertexFormats.POSITION_COLOR);

        for(int i = 0; i < points.length; i += 2) {
            if(first) {
                firstX = (float) points[i];
                firstY = (float) points[i + 1];
                prevX = firstX;
                prevY = firstY;
                first = false;
            } else {
                x = (float) points[i];
                y = (float) points[i + 1];

                bufferBuilder.vertex(model, (float) prevX, (float) prevY, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).next();
                prevX = x;
                prevY = y;
                bufferBuilder.vertex(model, (float) prevX, (float) prevY, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).next();

                if(i >= points.length - 2) {
                    bufferBuilder.vertex(model, (float) prevX, (float) prevY, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).next();
                    bufferBuilder.vertex(model, (float) firstX, (float) firstY, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).next();
                }
            }
        }
        draw();
        RenderSystem.lineWidth(1);
    }

    @Override
    public void startScissor(double x, double y, double width, double height) {
        // calculate resolution for scissoring
        double scaleWidth = (double) MinecraftClient.getInstance().getWindow().getFramebufferWidth() / MinecraftClient.getInstance().getWindow().getScaledWidth();
        double scaleHeight = (double) MinecraftClient.getInstance().getWindow().getFramebufferHeight() / MinecraftClient.getInstance().getWindow().getScaledHeight();

        // enable gl scissor
        RenderSystem.enableScissor(
                (int) (x * scaleWidth),
                (MinecraftClient.getInstance().getWindow().getFramebufferHeight()) - (int) ((y + height) * scaleHeight),
                (int) (width * scaleWidth),
                (int) (height * scaleHeight)
        );
    }

    @Override
    public void stopScissor() {
        RenderSystem.disableScissor();
    }

    @Override
    public void prepare3d() {
        renderStack.push();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableDepthTest();
        RenderSystem.disableTexture();
        RenderSystem.depthMask(false);

        renderStack.rotate(MathHelper.wrapDegrees(MinecraftClient.getInstance().gameRenderer.getCamera().getPitch()), 1, 0, 0);
        renderStack.rotate((float) MathHelper.wrapDegrees(MinecraftClient.getInstance().gameRenderer.getCamera().getYaw() + 180.0), 0, 1, 0);
    }

    @Override
    public void end3d() {
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        renderStack.pop();
    }

    @Override
    public void drawBox(Box box, Color fillColor, Color lineColor, int... ignoredSides) {
        // TODO: THIS + MORE RENDERING SHIT
        /*Direction[] sides = new Direction[6];
        for(int side: ignoredSides) {
            sides[side] = Direction.byId(side);
        }
        RenderUtils.cube(new Box(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ), fillColor, lineColor, sides);*/
    }

    // fabric helpers below...
    private Matrix4f getModel() {
        return renderStack.getMatrixStack().peek().getPositionMatrix();
    }

    private void draw() {
        draw(false);
    }

    private void draw(boolean texture) {
        RenderSystem.depthMask(true);
        RenderSystem.disableDepthTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();

        if(texture) RenderSystem.enableTexture();
        else RenderSystem.disableTexture();

        // actually draw
        Tessellator.getInstance().draw();

        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.enableCull();
        RenderSystem.enableTexture();
    }
}
