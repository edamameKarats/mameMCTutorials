package org.edacara.mamecontainers.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mamecontainers.MameContainers;
import org.edacara.mamecontainers.blocks.be.MameChestBE;
import org.edacara.mamecontainers.blocks.be.MameMillBE;

public class BEInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES
            = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MameContainers.modid);
    public static final RegistryObject<BlockEntityType<MameChestBE>> MAMECHEST_BE
            = BLOCK_ENTITIES.register("mamechest",
            () -> BlockEntityType.Builder.of(MameChestBE::new, BlockInit.MAMECHEST.get()).build(null));
    public static final RegistryObject<BlockEntityType<MameMillBE>> MAMEMILL_BE
            = BLOCK_ENTITIES.register("mamemill",
            () -> BlockEntityType.Builder.of(MameMillBE::new, BlockInit.MAMEMILL.get()).build(null));
}
