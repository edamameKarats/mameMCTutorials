package org.edacara.mamecontainers.blocks.be;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.edacara.mamecontainers.MameContainers;
import org.edacara.mamecontainers.blocks.containers.MameChestMenu;
import org.edacara.mamecontainers.init.BEInit;

public class MameChestBE  extends BaseContainerBlockEntity {
    protected NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);
    public MameChestBE(BlockPos blockPos, BlockState blockState) {
        super(BEInit.MAMECHEST_BE.get(), blockPos, blockState);
    }

    protected Component getDefaultName() {
        return new TranslatableComponent(MameContainers.modid +".container.mamechest");
    }

    protected AbstractContainerMenu createMenu(int windowId, Inventory inventory) {
        return new MameChestMenu(windowId, inventory, this);
    }

    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compoundTag, this.items);
    }

    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        ContainerHelper.saveAllItems(compoundTag, this.items);
    }

    public int getContainerSize() {
        return this.items.size();
    }

    public boolean isEmpty() {
        for(ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public ItemStack getItem(int index) {
        return this.items.get(index);
    }

    public ItemStack removeItem(int i, int i1) {
        return ContainerHelper.removeItem(this.items, i, i1);
    }

    public ItemStack removeItemNoUpdate(int i) {
        return ContainerHelper.takeItem(this.items, i);
    }

    public void setItem(int index, ItemStack itemStack) {
        this.items.set(index, itemStack);
        if (itemStack.getCount() > this.getMaxStackSize()) {
            itemStack.setCount(this.getMaxStackSize());
        }
    }

    public boolean stillValid(Player player) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return player.distanceToSqr((double)this.worldPosition.getX() + 0.5D,
                    (double)this.worldPosition.getY() + 0.5D,
                    (double)this.worldPosition.getZ() + 0.5D) <= 64.0D;
        }
    }

    public boolean canPlaceItem(int slotIndex, ItemStack itemStack) {
        return true;
    }

    public void clearContent() {
        this.items.clear();
    }
}