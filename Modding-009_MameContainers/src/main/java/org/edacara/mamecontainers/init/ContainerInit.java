package org.edacara.mamecontainers.init;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mamecontainers.MameContainers;
import org.edacara.mamecontainers.blocks.containers.MameChestMenu;
import org.edacara.mamecontainers.blocks.containers.MameMillMenu;

public class ContainerInit {
    public static final DeferredRegister<MenuType<?>> CONTAINERS
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, MameContainers.modid);
    public static final RegistryObject<MenuType<MameChestMenu>> MAMECHEST_MENU
            = CONTAINERS.register("mamechest",
            () -> IForgeMenuType.create((windowId, inv, data) -> new MameChestMenu(windowId,inv)));
    public static final RegistryObject<MenuType<MameMillMenu>> MAMEMILL_MENU
            = CONTAINERS.register("mamemill",
            () -> IForgeMenuType.create((windowId, inv, data) -> new MameMillMenu(windowId,inv)));

}
