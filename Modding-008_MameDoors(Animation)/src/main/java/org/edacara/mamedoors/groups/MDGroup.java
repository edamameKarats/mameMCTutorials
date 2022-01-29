package org.edacara.mamedoors.groups;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class MDGroup  extends CreativeModeTab {

    public static final MDGroup MORE_DOORS = new MDGroup(CreativeModeTab.TABS.length, "mame_doors");

    public MDGroup(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon()
    {
        return new ItemStack(Blocks.OAK_DOOR);
    }

}
