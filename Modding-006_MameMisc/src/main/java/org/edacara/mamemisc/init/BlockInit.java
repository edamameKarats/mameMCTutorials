package org.edacara.mamemisc.init;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mamemisc.blocks.CustomDirt;

public class BlockInit {
    public static final DeferredRegister<Block> OW_BLOCKS = DeferredRegister.create(
            ForgeRegistries.BLOCKS, "minecraft");

    public static final RegistryObject<Block> CUSTOM_DIRT = OW_BLOCKS
            .register("dirt",
                    () -> new CustomDirt()
            );
}
