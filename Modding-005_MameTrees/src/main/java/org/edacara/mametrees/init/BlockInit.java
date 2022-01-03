package org.edacara.mametrees.init;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mametrees.MameTrees;
import org.edacara.mametrees.blocks.MTLeaves;
import org.edacara.mametrees.blocks.MTSaplings;
import org.edacara.mametrees.growers.SakuraTreeGrower;


public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, MameTrees.modid);
    public static final RegistryObject<Block> SAKURA_LEAVES
            = BLOCKS.register("sakura_leaves", () -> new MTLeaves());
    public static final RegistryObject<Block> SAKURA_SAPLING
            = BLOCKS.register("sakura_sapling", () -> new MTSaplings(new SakuraTreeGrower()));
}
