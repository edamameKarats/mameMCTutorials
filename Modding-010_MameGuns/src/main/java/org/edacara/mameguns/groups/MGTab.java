package org.edacara.mameguns.groups;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.edacara.mameguns.init.ItemInit;

public class MGTab extends CreativeModeTab {
    public MGTab() {
        super("mameguns");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemInit.MAME_GUN.get());
    }
}
