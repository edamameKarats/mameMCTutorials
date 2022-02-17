package org.edacara.mamecontainers.blocks.containers;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.edacara.mamecontainers.init.ContainerInit;

public class MameChestMenu extends AbstractContainerMenu {

    private final Container container;
    protected final Level level;

    public MameChestMenu(int windowId, Inventory inventory) {
        this(ContainerInit.MAMECHEST_MENU.get(), windowId, inventory, new SimpleContainer(1));
    }

    public MameChestMenu(int windowId, Inventory inventory, Container container) {
        this(ContainerInit.MAMECHEST_MENU.get(), windowId, inventory, container);
    }

    public MameChestMenu(MenuType<?> menuType, int windowId, Inventory inventory, Container container) {
        super(menuType, windowId);
        checkContainerSize(container, 1);
        this.container = container;
        this.level = inventory.player.level;
        this.addSlot(new Slot(container, 0, 80, 35));
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
        }
    }

    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index != 0) {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    if (index >= 1 && index < 28) {
                        if (!this.moveItemStackTo(itemstack1, 28, 37, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (index >= 28 && index < 37 &&
                            !this.moveItemStackTo(itemstack1, 1, 28, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(itemstack1, 1, 37, false)) {
                return ItemStack.EMPTY;
            }
            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, itemstack1);
        }
        return itemstack;
    }
}