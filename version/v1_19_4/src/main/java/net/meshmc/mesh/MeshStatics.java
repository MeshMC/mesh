package net.meshmc.mesh;

import net.meshmc.mesh.api.block.MapColor;
import net.meshmc.mesh.api.block.Material;
import net.meshmc.mesh.api.client.Session;
import net.meshmc.mesh.api.math.*;
import net.meshmc.mesh.api.render.buffer.BufferBuilder;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.meshmc.mesh.impl.wrapper.render.BufferBuilderMesh;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.DemoScreen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.realms.gui.screen.RealmsMainScreen;
import net.minecraft.util.Identifier;

/**
 * @author Tigermouthbear 1/10/22
 */
public class MeshStatics {
    // types: legacy, mojang, msa (only on newer versions)
    public static Session createSession(String username, String uuid, String accessToken, String type) {
        return (Session) new net.minecraft.client.util.Session(username, uuid, accessToken, null, null, net.minecraft.client.util.Session.AccountType.byName(type));
    }

    public static Box createBox(double x1, double y1, double z1, double x2, double y2, double z2) {
        return (Box) new net.minecraft.util.math.Box(x1, y1, z1, x2, y2, z2);
    }

    public static Vec2f createVec2f(float x, float y) {
        return (Vec2f) new net.minecraft.util.math.Vec2f(x, y);
    }

    public static Vec3d createVec3d(double x, double y, double z) {
        return (Vec3d) new net.minecraft.util.math.Vec3d(x, y, z);
    }

    public static Vec3f createVec3f(float x, float y, float z) {
        return (Vec3f) new net.minecraft.util.math.Vec3f(x, y, z);
    }

    public static Vec3i createVec3i(int x, int y, int z) {
        return (Vec3i) new net.minecraft.util.math.Vec3i(x, y, z);
    }

    public static BlockPos createBlockPos(int x, int y, int z) {
        return (BlockPos) new net.minecraft.util.math.BlockPos(x, y, z);
    }

    public static BufferBuilder<?> createBufferBuilder(int initialCapacity) {
        return new BufferBuilderMesh(new net.minecraft.client.render.BufferBuilder(initialCapacity));
    }

    public static LocationIdentifier createLocationIdentifier(String namespace, String path) {
        return (LocationIdentifier) new Identifier(namespace, path);
    }

    public static LocationIdentifier createLocationIdentifier(String path) {
        return (LocationIdentifier) new Identifier(path);
    }

    public static Material createMaterial(MapColor mapColor) {
        return (Material) new net.minecraft.block.Material.Builder((net.minecraft.block.MapColor) mapColor).build();
    }

    public static void openChatScreen(String input) {
        MinecraftClient.getInstance().setScreen(new ChatScreen(input));
    }

    public static void openDemoScreen() {
        MinecraftClient.getInstance().setScreen(new DemoScreen());
    }

    public static void openMultiplayerScreen() {
        MinecraftClient.getInstance().setScreen(new MultiplayerScreen(MinecraftClient.getInstance().currentScreen));
    }

    public static void openOptionsScreen() {
        MinecraftClient.getInstance().setScreen(new OptionsScreen(MinecraftClient.getInstance().currentScreen, MinecraftClient.getInstance().options));
    }

    public static void openSelectWorldScreen() {
        MinecraftClient.getInstance().setScreen(new SelectWorldScreen(MinecraftClient.getInstance().currentScreen));
    }

    public static void openRealmsMainScreen() {
        MinecraftClient.getInstance().setScreen(new RealmsMainScreen(MinecraftClient.getInstance().currentScreen));
    }

    public static void openTitleScreen() {
        MinecraftClient.getInstance().setScreen(new TitleScreen());
    }

    public static LocationIdentifier EntityAbstractClientPlayer_getSkinId(String playerName) {
        return (LocationIdentifier) AbstractClientPlayerEntity.getSkinId(playerName);
    }
}
