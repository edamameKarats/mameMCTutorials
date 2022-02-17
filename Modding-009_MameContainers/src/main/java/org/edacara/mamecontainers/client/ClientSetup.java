package org.edacara.mamecontainers.client;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.edacara.mamecontainers.MameContainers;
import org.edacara.mamecontainers.client.screens.MameChestScreen;
import org.edacara.mamecontainers.client.screens.MameMillScreen;
import org.edacara.mamecontainers.init.ContainerInit;

@Mod.EventBusSubscriber(modid = MameContainers.modid, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void init(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(ContainerInit.MAMECHEST_MENU.get(), MameChestScreen::new);
            MenuScreens.register(ContainerInit.MAMEMILL_MENU.get(), MameMillScreen::new);
        });
    }

}
