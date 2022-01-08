package org.edacara.mamemisc.handler;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class MMKeyboardHandler {
    public static final MMKeyboardHandler INSTANCE = new MMKeyboardHandler();
    public static final KeyMapping KEYLS = new KeyMapping("key.getLShift", GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.misc");
    public static void register() {
        ClientRegistry.registerKeyBinding(KEYLS);
    }
}
