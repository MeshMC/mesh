package net.meshmc.mesh.impl;

import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.event.events.client.InputEvent;
import net.meshmc.mesh.event.events.render.RenderEvent;
import net.meshmc.mesh.util.Keys;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;
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

    @SubscribeEvent()
    public void onMouseInput(net.minecraftforge.fml.common.gameevent.InputEvent.MouseInputEvent event) {
        Mesh.getMesh().getEventManager().post(new InputEvent.Mouse.Moved(
                Mouse.getEventX(), Minecraft.getMinecraft().displayHeight - Mouse.getEventY(),
                Mouse.getEventDX(), -Mouse.getEventDY()
        ));

        int wheel = Mouse.getDWheel();
        if(Mouse.hasWheel() && wheel != 0) {
            // TODO: FIGURE OUT SCROLL DIFFERENCES BETWEEN LATER VERSIONS
            Mesh.getMesh().getEventManager().post(new InputEvent.Mouse.Scrolled(wheel / 50D));
        }

        int button = Mouse.getEventButton();
        if(button != -1) {
            if(Mouse.getEventButtonState()) {
                Mesh.getMesh().getEventManager().post(new InputEvent.Mouse.Pressed(button));
            } else {
                Mesh.getMesh().getEventManager().post(new InputEvent.Mouse.Released(button));
            }
        }
    }

    @SubscribeEvent()
    public void onKeyInput(net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent event) {
        int code = Keyboard.getEventKey();
        if(code == 0) return; // KEY_NONE

        if(Keyboard.getEventKeyState()) {
            Mesh.getMesh().getEventManager().post(new InputEvent.Keyboard.Pressed(toKey(code)));
        } else {
            Mesh.getMesh().getEventManager().post(new InputEvent.Keyboard.Released(toKey(code)));
        }
    }

    private static int toKey(int code) {
        if(code == Keyboard.KEY_NONE) return Keys.UNKNOWN;
        if(code == Keyboard.KEY_ESCAPE) return Keys.ESCAPE;
        if(code == Keyboard.KEY_1) return Keys.ONE;
        if(code == Keyboard.KEY_2) return Keys.TWO;
        if(code == Keyboard.KEY_3) return Keys.THREE;
        if(code == Keyboard.KEY_4) return Keys.FOUR;
        if(code == Keyboard.KEY_5) return Keys.FIVE;
        if(code == Keyboard.KEY_6) return Keys.SIX;
        if(code == Keyboard.KEY_7) return Keys.SEVEN;
        if(code == Keyboard.KEY_8) return Keys.EIGHT;
        if(code == Keyboard.KEY_9) return Keys.NINE;
        if(code == Keyboard.KEY_0) return Keys.ZERO;
        if(code == Keyboard.KEY_MINUS) return Keys.MINUS;
        if(code == Keyboard.KEY_EQUALS) return Keys.EQUAL;
        if(code == Keyboard.KEY_BACK) return Keys.BACKSPACE;
        if(code == Keyboard.KEY_TAB) return Keys.TAB;
        if(code == Keyboard.KEY_Q) return Keys.Q;
        if(code == Keyboard.KEY_W) return Keys.W;
        if(code == Keyboard.KEY_E) return Keys.E;
        if(code == Keyboard.KEY_R) return Keys.R;
        if(code == Keyboard.KEY_T) return Keys.T;
        if(code == Keyboard.KEY_Y) return Keys.Y;
        if(code == Keyboard.KEY_U) return Keys.U;
        if(code == Keyboard.KEY_I) return Keys.I;
        if(code == Keyboard.KEY_O) return Keys.O;
        if(code == Keyboard.KEY_P) return Keys.P;
        if(code == Keyboard.KEY_LBRACKET) return Keys.LEFT_BRACKET;
        if(code == Keyboard.KEY_RBRACKET) return Keys.RIGHT_BRACKET;
        if(code == Keyboard.KEY_RETURN) return Keys.ENTER;
        if(code == Keyboard.KEY_LCONTROL) return Keys.LEFT_CONTROL;
        if(code == Keyboard.KEY_A) return Keys.A;
        if(code == Keyboard.KEY_S) return Keys.S;
        if(code == Keyboard.KEY_D) return Keys.D;
        if(code == Keyboard.KEY_F) return Keys.F;
        if(code == Keyboard.KEY_G) return Keys.G;
        if(code == Keyboard.KEY_H) return Keys.H;
        if(code == Keyboard.KEY_J) return Keys.J;
        if(code == Keyboard.KEY_K) return Keys.K;
        if(code == Keyboard.KEY_L) return Keys.L;
        if(code == Keyboard.KEY_SEMICOLON) return Keys.SEMICOLON;
        if(code == Keyboard.KEY_APOSTROPHE) return Keys.APOSTROPHE;
        if(code == Keyboard.KEY_GRAVE) return Keys.GRAVE_ACCENT;
        if(code == Keyboard.KEY_LSHIFT) return Keys.LEFT_SHIFT;
        if(code == Keyboard.KEY_BACKSLASH) return Keys.BACKSLASH;
        if(code == Keyboard.KEY_Z) return Keys.Z;
        if(code == Keyboard.KEY_X) return Keys.X;
        if(code == Keyboard.KEY_C) return Keys.C;
        if(code == Keyboard.KEY_V) return Keys.V;
        if(code == Keyboard.KEY_B) return Keys.B;
        if(code == Keyboard.KEY_N) return Keys.N;
        if(code == Keyboard.KEY_M) return Keys.M;
        if(code == Keyboard.KEY_COMMA) return Keys.COMMA;
        if(code == Keyboard.KEY_PERIOD) return Keys.PERIOD;
        if(code == Keyboard.KEY_SLASH) return Keys.SLASH;
        if(code == Keyboard.KEY_RSHIFT) return Keys.RIGHT_SHIFT;
        if(code == Keyboard.KEY_MULTIPLY) return Keys.KP_MULTIPLY;
        if(code == Keyboard.KEY_LMENU) return Keys.LEFT_ALT;
        if(code == Keyboard.KEY_SPACE) return Keys.SPACE;
        if(code == Keyboard.KEY_CAPITAL) return Keys.CAPS_LOCK;
        if(code == Keyboard.KEY_F1) return Keys.F1;
        if(code == Keyboard.KEY_F2) return Keys.F2;
        if(code == Keyboard.KEY_F3) return Keys.F3;
        if(code == Keyboard.KEY_F4) return Keys.F4;
        if(code == Keyboard.KEY_F5) return Keys.F5;
        if(code == Keyboard.KEY_F6) return Keys.F6;
        if(code == Keyboard.KEY_F7) return Keys.F7;
        if(code == Keyboard.KEY_F8) return Keys.F8;
        if(code == Keyboard.KEY_F9) return Keys.F9;
        if(code == Keyboard.KEY_F10) return Keys.F10;
        if(code == Keyboard.KEY_NUMLOCK) return Keys.NUM_LOCK;
        if(code == Keyboard.KEY_SCROLL) return Keys.SCROLL_LOCK;
        if(code == Keyboard.KEY_NUMPAD7) return Keys.KP_7;
        if(code == Keyboard.KEY_NUMPAD8) return Keys.KP_8;
        if(code == Keyboard.KEY_NUMPAD9) return Keys.KP_9;
        if(code == Keyboard.KEY_SUBTRACT) return Keys.KP_SUBTRACT;
        if(code == Keyboard.KEY_NUMPAD4) return Keys.KP_4;
        if(code == Keyboard.KEY_NUMPAD5) return Keys.KP_5;
        if(code == Keyboard.KEY_NUMPAD6) return Keys.KP_6;
        if(code == Keyboard.KEY_ADD) return Keys.KP_ADD;
        if(code == Keyboard.KEY_NUMPAD1) return Keys.KP_1;
        if(code == Keyboard.KEY_NUMPAD2) return Keys.KP_2;
        if(code == Keyboard.KEY_NUMPAD3) return Keys.KP_3;
        if(code == Keyboard.KEY_NUMPAD0) return Keys.KP_0;
        if(code == Keyboard.KEY_DECIMAL) return Keys.KP_DECIMAL;
        if(code == Keyboard.KEY_F11) return Keys.F11;
        if(code == Keyboard.KEY_F12) return Keys.F12;
        if(code == Keyboard.KEY_F13) return Keys.F13;
        if(code == Keyboard.KEY_F14) return Keys.F14;
        if(code == Keyboard.KEY_F15) return Keys.F15;
        if(code == Keyboard.KEY_F16) return Keys.F16;
        if(code == Keyboard.KEY_F17) return Keys.F17;
        if(code == Keyboard.KEY_F18) return Keys.F18;
        if(code == Keyboard.KEY_F19) return Keys.F19;
        if(code == Keyboard.KEY_NUMPADEQUALS) return Keys.KP_EQUAL;
        if(code == Keyboard.KEY_NUMPADENTER) return Keys.KP_ENTER;
        if(code == Keyboard.KEY_RCONTROL) return Keys.RIGHT_CONTROL;
        if(code == Keyboard.KEY_DIVIDE) return Keys.KP_DIVIDE;
        if(code == Keyboard.KEY_RMENU) return Keys.RIGHT_ALT;
        if(code == Keyboard.KEY_FUNCTION) return Keys.MENU;
        if(code == Keyboard.KEY_PAUSE) return Keys.PAUSE;
        if(code == Keyboard.KEY_HOME) return Keys.HOME;
        if(code == Keyboard.KEY_UP) return Keys.UP;
        if(code == Keyboard.KEY_PRIOR) return Keys.PAGE_UP;
        if(code == Keyboard.KEY_LEFT) return Keys.LEFT;
        if(code == Keyboard.KEY_RIGHT) return Keys.RIGHT;
        if(code == Keyboard.KEY_END) return Keys.END;
        if(code == Keyboard.KEY_DOWN) return Keys.DOWN;
        if(code == Keyboard.KEY_NEXT) return Keys.PAGE_DOWN;
        if(code == Keyboard.KEY_INSERT) return Keys.INSERT;
        if(code == Keyboard.KEY_DELETE) return Keys.DELETE;
        if(code == Keyboard.KEY_LMETA) return Keys.LEFT_SUPER;
        if(code == Keyboard.KEY_RMETA) return Keys.RIGHT_SUPER;
        return Keys.UNKNOWN;
    }
}
