package org.edacara.mameores.init;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mameores.MameOres;
import org.edacara.mameores.blocks.TinOre;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MameOres.modid);
    public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore", () -> new TinOre());
}
