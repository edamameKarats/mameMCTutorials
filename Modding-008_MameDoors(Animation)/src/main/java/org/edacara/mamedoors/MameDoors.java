package org.edacara.mamedoors;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.edacara.mamedoors.init.BEInit;
import org.edacara.mamedoors.init.BlockInit;
import org.edacara.mamedoors.init.ClientInit;
import org.edacara.mamedoors.init.ItemInit;

@Mod("mamedoors")
public class MameDoors {
    public static final String modid = "mamedoors";

    public MameDoors(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        BEInit.BLOCK_ENTITIES.register(bus);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> bus.addListener(ClientInit::init));

        MinecraftForge.EVENT_BUS.register(this);
    }
}

