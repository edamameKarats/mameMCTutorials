package org.edacara.mamemisc;


import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.edacara.mamemisc.init.BlockInit;
import org.edacara.mamemisc.init.HookEvent;

@Mod("mamemisc")
public class MameMisc {
    public static final String modid = "mamemisc";

    public MameMisc(){
        BlockInit.OW_BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(new HookEvent());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
