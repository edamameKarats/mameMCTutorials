package org.edacara.mamedoors.init;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mamedoors.MameDoors;
import org.edacara.mamedoors.blocks.Door1x2;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MameDoors.modid);
    public static final RegistryObject<Block> DOOR_1X2 = BLOCKS.register("door_1x2", () -> new Door1x2());
}
