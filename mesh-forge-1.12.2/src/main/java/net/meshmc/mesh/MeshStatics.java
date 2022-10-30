package net.meshmc.mesh;

import io.netty.buffer.Unpooled;
import net.meshmc.mesh.api.block.MapColor;
import net.meshmc.mesh.api.block.Material;
import net.meshmc.mesh.api.client.Session;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.math.*;
import net.meshmc.mesh.api.network.client.CPacketChatMessage;
import net.meshmc.mesh.api.network.client.CPacketConfirmTeleport;
import net.meshmc.mesh.api.network.client.CPacketInput;
import net.meshmc.mesh.api.network.client.CPacketSteerBoat;
import net.meshmc.mesh.api.network.client.CPacketUseEntity;
import net.meshmc.mesh.api.network.client.*;
import net.meshmc.mesh.api.render.buffer.BufferBuilder;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.wrapper.entity.EntityMesh;
import net.meshmc.mesh.impl.wrapper.render.BufferBuilderMesh;
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.*;
import net.minecraft.realms.RealmsBridge;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import org.lwjgl.util.vector.Vector3f;

import java.io.IOException;

/**
 * @author Tigermouthbear 1/10/22
 */
public class MeshStatics {
    private static final Minecraft MC = Minecraft.getMinecraft();

    // types: legacy, mojang, msa (only on newer versions)
    public static Session createSession(String username, String uuid, String accessToken, String type) {
        return (Session) new net.minecraft.util.Session(username, uuid, accessToken, type);
    }

    public static Box createBox(double x1, double y1, double z1, double x2, double y2, double z2) {
        return (Box) new AxisAlignedBB(x1, y1, z1, x2, y2, z2);
    }

    public static Vec2f createVec2f(float x, float y) {
        return (Vec2f) new net.minecraft.util.math.Vec2f(x, y);
    }

    public static Vec3d createVec3d(double x, double y, double z) {
        return (Vec3d) new net.minecraft.util.math.Vec3d(x, y, z);
    }

    public static Vec3f createVec3f(float x, float y, float z) {
        return (Vec3f) new Vector3f(x, y, z);
    }

    public static Vec3i createVec3i(int x, int y, int z) {
        return (Vec3i) new net.minecraft.util.math.Vec3i(x, y, z);
    }

    public static BlockPos createBlockPos(int x, int y, int z) {
        return (BlockPos) new net.minecraft.util.math.BlockPos(x, y, z);
    }

    public static BufferBuilder<?> createBufferBuilder(int initialCapacity) {
        return new BufferBuilderMesh(new net.minecraft.client.renderer.BufferBuilder(initialCapacity));
    }

    public static LocationIdentifier createLocationIdentifier(String namespace, String path) {
        return (LocationIdentifier) new ResourceLocation(namespace, path);
    }

    public static LocationIdentifier createLocationIdentifier(String path) {
        return (LocationIdentifier) new ResourceLocation(path);
    }

    public static Material createMaterial(MapColor mapColor) {
        return (Material) new net.minecraft.block.material.Material((net.minecraft.block.material.MapColor) mapColor);
    }

    public static void openChatScreen(String input) {
        MC.displayGuiScreen(new GuiChat(input));
    }

    public static void openDemoScreen() {
        MC.displayGuiScreen(new GuiScreenDemo());
    }

    public static void openMultiplayerScreen() {
        MC.displayGuiScreen(new GuiMultiplayer(MC.currentScreen));
    }

    public static void openOptionsScreen() {
        MC.displayGuiScreen(new GuiOptions(MC.currentScreen, MC.gameSettings));
    }

    public static void openSelectWorldScreen() {
        MC.displayGuiScreen(new GuiWorldSelection(MC.currentScreen));
    }

    public static void openRealmsMainScreen() {
        RealmsBridge realmsbridge = new RealmsBridge();
        realmsbridge.switchToRealms(MC.currentScreen);
    }

    public static void openTitleScreen() {
        MC.displayGuiScreen(new GuiMainMenu());
    }
}
