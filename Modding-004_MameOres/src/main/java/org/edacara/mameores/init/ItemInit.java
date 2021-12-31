package org.edacara.mameores.init;

import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mameores.MameOres;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MameOres.modid);
    public static final RegistryObject<Item> TIN_ORE = ITEMS.register("tin_ore", () ->
            new BlockItem(BlockInit.TIN_ORE.get(), new Item.Properties().tab(MameOres.mameores)));

}