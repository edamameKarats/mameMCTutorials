package org.edacara.mamecontainers.slots;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class CustomResultSlot extends Slot {
    public CustomResultSlot(Container container, int index, int x, int y) {
        super(container, index, x, y);
    }
    public boolean mayPlace(ItemStack itemStack) {
        return false;
    }
}