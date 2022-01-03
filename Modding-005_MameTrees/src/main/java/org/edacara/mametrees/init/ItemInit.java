package org.edacara.mametrees.init;

import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mametrees.MameTrees;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MameTrees.modid);

    public static final RegistryObject<Item> SAKURA_LEAVES = ITEMS.register("sakura_leaves", () ->
            new BlockItem(BlockInit.SAKURA_LEAVES.get(), new Item.Properties().tab(MameTrees.mametrees)));
    public static final RegistryObject<Item> SAKURA_SAPLING = ITEMS.register("sakura_sapling", () ->
            new BlockItem(BlockInit.SAKURA_SAPLING.get(), new Item.Properties().tab(MameTrees.mametrees)));

}