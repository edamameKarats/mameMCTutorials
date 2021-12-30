package org.edacara.mameitems;


import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.edacara.mameitems.groups.MITab;
import org.edacara.mameitems.init.ItemInit;

@Mod("mameitems")
public class MameItems {
    public static final String modid = "mameitems";
    public static final CreativeModeTab mameitems = new MITab();

    public MameItems(){
        ItemInit.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
