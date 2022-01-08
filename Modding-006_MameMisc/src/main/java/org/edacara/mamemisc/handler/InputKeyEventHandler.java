package org.edacara.mamemisc.handler;

import net.minecraftforge.client.event.InputEvent;

public class InputKeyEventHandler {
    public static void handleEvent(InputEvent.KeyInputEvent event){
        System.out.println("Some key pressed!");
        System.out.println("Pressed key is "+event.getKey());
    }
}
