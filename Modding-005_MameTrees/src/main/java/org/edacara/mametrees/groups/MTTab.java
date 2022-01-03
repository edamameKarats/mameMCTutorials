package org.edacara.mametrees.groups;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class MTTab  extends CreativeModeTab {
    public MTTab() {
        super("mametrees");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.OAK_SAPLING);
    }
}