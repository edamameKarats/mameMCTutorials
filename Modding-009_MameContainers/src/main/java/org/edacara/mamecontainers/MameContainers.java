package org.edacara.mamecontainers;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.edacara.mamecontainers.client.ClientSetup;
import org.edacara.mamecontainers.groups.MCTab;
import org.edacara.mamecontainers.init.BEInit;
import org.edacara.mamecontainers.init.BlockInit;
import org.edacara.mamecontainers.init.ContainerInit;
import org.edacara.mamecontainers.init.ItemInit;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("mamecontainers")
public class MameContainers
{
    public static final String modid="mamecontainers";
    public static CreativeModeTab mamecontainers= new MCTab();

    public MameContainers() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        BEInit.BLOCK_ENTITIES.register(bus);
        ContainerInit.CONTAINERS.register(bus);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> bus.addListener(ClientSetup::init));

        MinecraftForge.EVENT_BUS.register(this);
    }

}
