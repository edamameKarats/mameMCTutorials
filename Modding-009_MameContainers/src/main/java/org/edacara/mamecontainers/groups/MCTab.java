package org.edacara.mamecontainers.groups;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import org.edacara.mamecontainers.init.BlockInit;

public class MCTab  extends CreativeModeTab {
    public MCTab() {
        super("mamecontainers");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(BlockInit.MAMECHEST.get());
    }
}