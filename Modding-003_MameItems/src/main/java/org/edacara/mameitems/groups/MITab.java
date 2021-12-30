package org.edacara.mameitems.groups;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class MITab extends CreativeModeTab {
    public MITab(){
        super("mameitems");
    }

    @Override
    public ItemStack makeIcon(){
        return new ItemStack(Items.IRON_INGOT);
    }
}
