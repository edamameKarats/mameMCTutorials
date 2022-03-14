package org.edacara.mameguns.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.edacara.mameguns.MameGuns;
import org.edacara.mameguns.renderers.MameBulletRenderer;

@Mod.EventBusSubscriber(modid = MameGuns.modid, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RendererSetup {
    @SubscribeEvent
    public static void registerEntityRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.MAME_BULLET.get(), MameBulletRenderer::new);
    }

}
