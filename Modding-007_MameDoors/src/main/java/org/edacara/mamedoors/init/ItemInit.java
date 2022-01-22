package org.edacara.mamedoors.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mamedoors.MameDoors;
import org.edacara.mamedoors.groups.MDGroup;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MameDoors.modid);

    public static final RegistryObject<Item> DOOR_1x2 = ITEMS.register("door_1x2",
            () -> new BlockItem(BlockInit.DOOR_1X2.get(),new Item.Properties().tab(MDGroup.MORE_DOORS)));

}
