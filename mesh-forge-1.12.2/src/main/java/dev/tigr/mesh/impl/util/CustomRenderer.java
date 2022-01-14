package dev.tigr.mesh.impl.util;

import dev.tigr.mesh.api.math.Box;
import dev.tigr.mesh.util.render.Color;
import dev.tigr.mesh.util.render.IRenderStack;
import dev.tigr.mesh.util.render.IRenderer;
import dev.tigr.mesh.util.render.LocationIdentifier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Tigermouthbear 1/10/22
 */
public class CustomRenderer extends HashMap<String, DynamicTexture> implements IRenderer {
    @Override
    public IRenderStack getRenderStack() {
        return null;
    }

    @Override
    public void bindTexture(LocationIdentifier resourceLocation) {
        if(!containsKey(resourceLocation.getPath())) {
            BufferedImage bufferedImage = null;
            try {
                bufferedImage = ImageIO.read(CustomRenderer.class.getResourceAsStream(resourceLocation.getPath()));
            } catch(IOException e) {
                e.printStackTrace();
            }
            DynamicTexture dynamicTexture = new DynamicTexture(bufferedImage);
            put(resourceLocation.getPath(), dynamicTexture);
        }

        GlStateManager.bindTexture(get(resourceLocation.getPath()).getGlTextureId());
    }

    private void draw() {
        draw(false);
    }

    private void draw(boolean texture) {
        GlStateManager.color(1, 1, 1, 1);

        GlStateManager.disableDepth();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableAlpha();
        GlStateManager.disableLighting();

        GlStateManager.disableCull();
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GlStateManager.shadeModel(GL11.GL_SMOOTH);

        if(texture) GlStateManager.enableTexture2D();
        else GlStateManager.disableTexture2D();

        // actually draw
        Tessellator.getInstance().draw();

        GlStateManager.enableAlpha();
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
    }

    @Override
    public void drawRect(double x, double y, double width, double height, Color color) {
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(GL11.GL_TRIANGLES, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(x + width, y, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(x, y, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(x, y + height, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(x, y + height, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(x + width, y + height, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(x + width, y, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
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
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(GL11.GL_TRIANGLES, DefaultVertexFormats.POSITION_TEX_COLOR);
        bufferBuilder.pos(x + width, y, 0).tex(1, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(x, y, 0).tex(0, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(x, y + height, 0).tex(0, 1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(x, y + height, 0).tex(0, 1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(x + width, y + height, 0).tex(1, 1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(x + width, y, 0).tex(1, 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        draw(true);
    }

    @Override
    public void drawLine(double startX, double startY, double endX, double endY, int weight, Color color) {
        drawLine(startX, startY, 0, endX, endY, 0, weight, color);
    }

    public void drawLine(double startX, double startY, double startZ, double endX, double endY, double endZ, int weight, Color color) {
        GlStateManager.glLineWidth(weight);

        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(GL11.GL_LINES, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(startX, startY, startZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(endX, endY, endZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        draw();
    }

    @Override
    public void drawLineLoop(int weight, Color color, double... points) {
        if(points.length % 2 != 0) return;

        GlStateManager.glLineWidth(weight);

        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(GL11.GL_LINE_LOOP, DefaultVertexFormats.POSITION_COLOR);
        for(int i = 0; i < points.length; i += 2)
            bufferBuilder.pos(points[i], points[i + 1], 0).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        draw();
    }

    @Override
    public void startScissor(double x, double y, double width, double height) {
        ScaledResolution resolution = new ScaledResolution(Minecraft.getMinecraft());
        double scaleWidth = (double) Minecraft.getMinecraft().displayWidth / resolution.getScaledWidth_double();
        double scaleHeight = (double) Minecraft.getMinecraft().displayHeight / resolution.getScaledHeight_double();
        GL11.glScissor(
                (int) (x * scaleWidth),
                (Minecraft.getMinecraft().displayHeight) - (int) ((y + height) * scaleHeight),
                (int) (width * scaleWidth),
                (int) (height * scaleHeight)
        );
        GL11.glEnable(GL11.GL_SCISSOR_TEST);
    }

    @Override
    public void stopScissor() {
        GL11.glDisable(GL11.GL_SCISSOR_TEST);
    }

    @Override
    public void prepare3d() {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GlStateManager.disableAlpha();
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_DEPTH_TEST);

        GL11.glPushMatrix();
        GlStateManager.color(1, 1, 1, 1);
    }

    @Override
    public void end3d() {
        GlStateManager.color(1, 1, 1, 1);
        GL11.glPopMatrix();

        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GlStateManager.enableAlpha();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
    }

    @Override
    public void drawBox(Box<?> box, Color fillColor, Color lineColor, int... ignoredSides) {
        // TODO: THIS
        /*EnumFacing[] sides = new EnumFacing[6];
        for(int side: ignoredSides) {
            sides[side] = EnumFacing.byIndex(side);
        }
        RenderUtils.cube(new AxisAlignedBB(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ), fillColor, lineColor, sides);
         */
    }
}
