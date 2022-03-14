package org.edacara.mameguns;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.edacara.mameguns.groups.MGTab;
import org.edacara.mameguns.init.EntityInit;
import org.edacara.mameguns.init.ItemInit;
import org.edacara.mameguns.init.SoundInit;

@Mod("mameguns")
public class MameGuns
{
    public static final String modid = "mameguns";
    public static final CreativeModeTab mameguns = new MGTab();

    public MameGuns()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        SoundInit.SOUNDS.register(bus);
        EntityInit.ENTITIES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }


}
