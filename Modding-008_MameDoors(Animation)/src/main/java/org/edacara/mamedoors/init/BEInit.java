package org.edacara.mamedoors.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mamedoors.MameDoors;
import org.edacara.mamedoors.blocks.be.Door1x2BE;

public class BEInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES
            = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MameDoors.modid);
    public static final RegistryObject<BlockEntityType<Door1x2BE>> DOOR_1X2_BE
            = BLOCK_ENTITIES.register("door_1x2", ()
            -> BlockEntityType.Builder.of(Door1x2BE::new, BlockInit.DOOR_1X2.get()).build(null));
}
