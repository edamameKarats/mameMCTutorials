package org.edacara.mamecontainers.init;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mamecontainers.MameContainers;
import org.edacara.mamecontainers.blocks.MameChest;
import org.edacara.mamecontainers.blocks.MameMill;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, MameContainers.modid);
    public static final RegistryObject<Block> MAMECHEST
            = BLOCKS.register("mamechest", () -> new MameChest());
    public static final RegistryObject<Block> MAMEMILL
            = BLOCKS.register("mamemill", () -> new MameMill());
}
