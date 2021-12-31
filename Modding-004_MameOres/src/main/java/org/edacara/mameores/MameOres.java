package org.edacara.mameores;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.edacara.mameores.features.MOConfiguredFeature;
import org.edacara.mameores.features.MOPlacedFeature;
import org.edacara.mameores.groups.MOTab;
import org.edacara.mameores.init.BlockInit;
import org.edacara.mameores.init.ItemInit;

@Mod("mameores")
public class MameOres {
    public static final String modid = "mameores";
    public static final CreativeModeTab mameores = new MOTab();

    public MameOres(){
        BlockInit.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemInit.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        MOConfiguredFeature.registerConfiguredFeatures();
        MOPlacedFeature.registerPlacedFeatures();
    }
}
