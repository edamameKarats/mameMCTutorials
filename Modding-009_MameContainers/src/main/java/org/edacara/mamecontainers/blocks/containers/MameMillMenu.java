package org.edacara.mamecontainers.blocks.containers;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.edacara.mamecontainers.init.ContainerInit;
import org.edacara.mamecontainers.slots.CustomResultSlot;

public class MameMillMenu extends AbstractContainerMenu {

    private final Container container;
    private final ContainerData data;
    protected final Level level;

    public MameMillMenu(int windowId, Inventory inventory) {
        this(ContainerInit.MAMEMILL_MENU.get(), windowId, inventory,
                new SimpleContainer(2), new SimpleContainerData(2));
    }

    public MameMillMenu(int windowId, Inventory inventory, Container container, ContainerData containerData) {
        this(ContainerInit.MAMEMILL_MENU.get(), windowId, inventory, container, containerData);
    }

    public MameMillMenu(MenuType<?> menuType, int windowId, Inventory inventory, Container container,
                        ContainerData containerData) {
        super(menuType, windowId);
        checkContainerSize(container, 2);
        checkContainerDataCount(containerData, 2);
        this.container = container;
        this.data = containerData;
        this.level = inventory.player.level;
        this.addSlot(new Slot(container, 0, 56, 35));
        this.addSlot(new CustomResultSlot(container, 1, 116, 35));

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
        }

        this.addDataSlots(containerData);
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
            if (index == 1) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (index != 0) {

                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    if (index >= 2 && index < 29) {
                        if (!this.moveItemStackTo(itemstack1, 29, 38, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (index >= 29 && index < 38
                            && !this.moveItemStackTo(itemstack1, 2, 29, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(itemstack1, 2, 38, false)) {
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


    public int getBurnProgress() {
        int i = this.data.get(0);
        int j = this.data.get(1);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

}