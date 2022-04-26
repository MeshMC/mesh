package net.meshmc.mesh.impl.mixin.events.client;

import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.event.events.client.InputEvent;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class MixinKeyboard {
    @Inject(method = "onKey", at = @At("HEAD"))
    public void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci) {
        if(window == MinecraftClient.getInstance().getWindow().getHandle()) {
            if(action == 0) {
                Mesh.getMesh().getEventManager().post(new InputEvent.Keyboard.Released(key));
            } else {
                Mesh.getMesh().getEventManager().post(new InputEvent.Keyboard.Pressed(key));
            }
        }
    }
}
