package org.edacara.mameores.groups;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class MOTab  extends CreativeModeTab {
    public MOTab() {
        super("mameores");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.IRON_ORE);
    }
}