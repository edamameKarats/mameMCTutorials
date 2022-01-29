package org.edacara.mamedoors.init;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.edacara.mamedoors.MameDoors;
import org.edacara.mamedoors.client.Door1x2Renderer;

@Mod.EventBusSubscriber(modid = MameDoors.modid, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientInit {

    public static void init(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            register();
        });
    }

    public static void register() {
        BlockEntityRenderers.register(BEInit.DOOR_1X2_BE.get(), Door1x2Renderer::new);
    }
}
