package org.edacara.mamemisc.init;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.edacara.mamemisc.handler.BreakEventHandler;
import org.edacara.mamemisc.handler.MMKeyboardHandler;

public class HookEvent {
    @SubscribeEvent
    public void onBreakBlock(BlockEvent.BreakEvent event){
        long handle = Minecraft.getInstance().getWindow().getWindow();
        if(InputConstants.isKeyDown(handle, MMKeyboardHandler.KEYLS.getKey().getValue())) {
            BreakEventHandler.handleEvent(event);
        }
    }
//    @SubscribeEvent
//    public void onKeyPressed(InputEvent.KeyInputEvent event){ InputKeyEventHandler.handleEvent(event); }
}
