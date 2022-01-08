package org.edacara.mamemisc.handler;

import net.minecraftforge.event.world.BlockEvent;

public class BreakEventHandler {
    public static void handleEvent(BlockEvent.BreakEvent event){
        System.out.println("Handling break event!");
        System.out.println("Broken block is "+event.getState().getBlock().getName()+".");
        System.out.println("Breaker's left hand is "+ event.getPlayer().getMainHandItem().getDisplayName().getString());
    }
}
