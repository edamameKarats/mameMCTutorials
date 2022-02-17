package org.edacara.mamecontainers.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mamecontainers.MameContainers;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, MameContainers.modid);
    public static final RegistryObject<Item> MAMECHEST
            = ITEMS.register("mamechest", () ->
            new BlockItem(BlockInit.MAMECHEST.get(), new Item.Properties().tab(MameContainers.mamecontainers)));
    public static final RegistryObject<Item> MAMEMILL
            = ITEMS.register("mamemill", () ->
            new BlockItem(BlockInit.MAMEMILL.get(), new Item.Properties().tab(MameContainers.mamecontainers)));
}
