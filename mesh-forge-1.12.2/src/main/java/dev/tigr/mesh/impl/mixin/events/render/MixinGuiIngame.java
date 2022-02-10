package dev.tigr.mesh.impl.mixin.events.render;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.event.events.render.HudRenderEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraftforge.client.GuiIngameForge.*;
import static net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType.ALL;

@Mixin(GuiIngameForge.class)
public abstract class MixinGuiIngame extends GuiIngame {
    public MixinGuiIngame(Minecraft mcIn) {
        super(mcIn);
    }

    @Shadow protected abstract void renderToolHighlight(ScaledResolution res);
    @Shadow protected abstract void renderHUDText(int width, int height);
    @Shadow protected abstract void renderFPSGraph();
    @Shadow protected abstract void renderPotionIcons(ScaledResolution resolution);
    @Shadow protected abstract void renderRecordOverlay(int width, int height, float partialTicks);
    @Shadow protected abstract void renderSubtitles(ScaledResolution resolution);
    @Shadow protected abstract void renderTitle(int width, int height, float partialTicks);
    @Shadow private ScaledResolution res;
    @Shadow protected abstract void renderChat(int width, int height);
    @Shadow protected abstract boolean pre(RenderGameOverlayEvent.ElementType type);
    @Shadow private FontRenderer fontrenderer;
    @Shadow private RenderGameOverlayEvent eventParent;
    @Shadow protected abstract void renderHelmet(ScaledResolution res, float partialTicks);
    @Shadow protected abstract void renderCrosshairs(float partialTicks);
    @Shadow protected abstract void renderBossHealth();
    @Shadow public abstract void renderHealth(int width, int height);
    @Shadow protected abstract void renderArmor(int width, int height);
    @Shadow public abstract void renderFood(int width, int height);
    @Shadow protected abstract void renderHealthMount(int width, int height);
    @Shadow protected abstract void renderAir(int width, int height);
    @Shadow protected abstract void renderSleepFade(int width, int height);
    @Shadow protected abstract void renderJumpBar(int width, int height);
    @Shadow protected abstract void renderExperience(int width, int height);
    @Shadow protected abstract void renderPlayerList(int width, int height);
    @Shadow protected abstract void post(RenderGameOverlayEvent.ElementType type);
    @Shadow protected abstract void renderPortal(ScaledResolution res, float partialTicks);

    @Inject(method = "renderGameOverlay", at = @At("HEAD"), cancellable = true)
    public void renderOverlay(float partialTicks, CallbackInfo ci) {
        ci.cancel();

        res = new ScaledResolution(mc);
        eventParent = new RenderGameOverlayEvent(partialTicks, res);
        int width = res.getScaledWidth();
        int height = res.getScaledHeight();
        renderHealthMount = mc.player.getRidingEntity() instanceof EntityLivingBase;
        renderFood = mc.player.getRidingEntity() == null;
        renderJumpBar = mc.player.isRidingHorse();

        right_height = 39;
        left_height = 39;

        if (pre(ALL)) return;

        fontrenderer = mc.fontRenderer;
        mc.entityRenderer.setupOverlayRendering();
        GlStateManager.enableBlend();

        if (renderVignette && Minecraft.isFancyGraphicsEnabled())
        {
            renderVignette(mc.player.getBrightness(), res);
        }
        else
        {
            GlStateManager.enableDepth();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        }

        if (renderHelmet) renderHelmet(res, partialTicks);

        if (renderPortal && !mc.player.isPotionActive(MobEffects.NAUSEA))
        {
            renderPortal(res, partialTicks);
        }

        if (renderHotbar) renderHotbar(res, partialTicks);

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        zLevel = -90.0F;
        rand.setSeed((long)(updateCounter * 312871));

        if (renderCrosshairs) renderCrosshairs(partialTicks);
        if (renderBossHealth) renderBossHealth();

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        if (this.mc.playerController.shouldDrawHUD() && this.mc.getRenderViewEntity() instanceof EntityPlayer)
        {
            if (renderHealth) renderHealth(width, height);
            if (renderArmor)  renderArmor(width, height);
            if (renderFood)   renderFood(width, height);
            if (renderHealthMount) renderHealthMount(width, height);
            if (renderAir)    renderAir(width, height);
        }

        renderSleepFade(width, height);

        if (renderJumpBar)
        {
            renderJumpBar(width, height);
        }
        else if (renderExperiance)
        {
            renderExperience(width, height);
        }

        // Moved renderPotionIcons right after renderToolHighlight so that F3 renders after event because potions and tool text turn into white boxes if rendered after the event
        renderToolHighlight(res);
        renderPotionIcons(res);

        Mesh.getMesh().getEventManager().post(new HudRenderEvent(partialTicks));

        renderHUDText(width, height);
        renderFPSGraph();
        renderRecordOverlay(width, height, partialTicks);
        renderSubtitles(res);
        renderTitle(width, height, partialTicks);

        Scoreboard scoreboard = Minecraft.getMinecraft().world.getScoreboard();
        ScoreObjective objective = null;
        ScorePlayerTeam scoreplayerteam = scoreboard.getPlayersTeam(mc.player.getName());
        if (scoreplayerteam != null)
        {
            int slot = scoreplayerteam.getColor().getColorIndex();
            if (slot >= 0) objective = scoreboard.getObjectiveInDisplaySlot(3 + slot);
        }
        ScoreObjective scoreobjective1 = objective != null ? objective : scoreboard.getObjectiveInDisplaySlot(1);
        if (renderObjective && scoreobjective1 != null)
        {
            renderScoreboard(scoreobjective1, res);
        }

        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
        GlStateManager.disableAlpha();

        renderChat(width, height);

        renderPlayerList(width, height);

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.disableLighting();
        GlStateManager.enableAlpha();

        post(ALL);
    }
}
