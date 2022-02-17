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
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.edacara.mamecontainers.MameContainers;
import org.edacara.mamecontainers.blocks.MameMill;
import org.edacara.mamecontainers.blocks.containers.MameMillMenu;
import org.edacara.mamecontainers.init.BEInit;

public class MameMillBE extends BaseContainerBlockEntity{
    protected static final int SLOT_INPUT = 0;
    protected static final int SLOT_RESULT = 1;
    protected NonNullList<ItemStack> items = NonNullList.withSize(2, ItemStack.EMPTY);
    int cookingProgress;
    int cookingTotalTime;
    protected final ContainerData dataAccess = new ContainerData() {
        public int get(int index) {
            switch(index) {
                case 0:
                    return MameMillBE.this.cookingProgress;
                case 1:
                    return MameMillBE.this.cookingTotalTime;
                default:
                    return 0;
            }
        }
        public void set(int index, int value) {
            switch(index) {
                case 0:
                    MameMillBE.this.cookingProgress = value;
                    break;
                case 1:
                    MameMillBE.this.cookingTotalTime = value;
            }
        }
        public int getCount() {
            return 2;
        }
    };



    public MameMillBE(BlockPos blockPos, BlockState blockState) {
        super(BEInit.MAMEMILL_BE.get(), blockPos, blockState);
    }

    protected Component getDefaultName() {
        return new TranslatableComponent(MameContainers.modid +".container.mamemill");
    }

    protected AbstractContainerMenu createMenu(int windowId, Inventory inventory) {
        return new MameMillMenu(windowId, inventory, this, this.dataAccess);
    }

    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compoundTag, this.items);
        this.cookingProgress = compoundTag.getInt("CookTime");
        this.cookingTotalTime = compoundTag.getInt("CookTimeTotal");
    }

    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.putInt("CookTime", this.cookingProgress);
        compoundTag.putInt("CookTimeTotal", this.cookingTotalTime);
        ContainerHelper.saveAllItems(compoundTag, this.items);
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, MameMillBE mameMillBE) {
        if (!mameMillBE.items.get(SLOT_INPUT).isEmpty()) {

                ++mameMillBE.cookingProgress;
                if (mameMillBE.cookingProgress == mameMillBE.cookingTotalTime) {
                    mameMillBE.cookingProgress = 0;
                    mameMillBE.cookingTotalTime = 100;
                    ItemStack resultStack=mameMillBE.getItem(SLOT_INPUT).copy();
                    mameMillBE.getItem(SLOT_INPUT).shrink(1);
                    mameMillBE.setItem(SLOT_RESULT, resultStack);
                }
            blockState = blockState.setValue(MameMill.LIT, true);
            level.setBlock(blockPos, blockState, 3);
            setChanged(level, blockPos, blockState);
        }else{
            blockState = blockState.setValue(MameMill.LIT, false);
            level.setBlock(blockPos, blockState, 3);
            setChanged(level, blockPos, blockState);
        }
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
        ItemStack itemstack = this.items.get(index);
        boolean flag = !itemStack.isEmpty() && itemStack.sameItem(itemstack) && ItemStack.tagMatches(itemStack, itemstack);
        this.items.set(index, itemStack);
        if (itemStack.getCount() > this.getMaxStackSize()) {
            itemStack.setCount(this.getMaxStackSize());
        }

        if (index == SLOT_INPUT && !flag) {
            this.cookingTotalTime = 100;
            this.cookingProgress = 0;
            this.setChanged();
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
        if (slotIndex == SLOT_RESULT) {
            return false;
        }else{
            return true;
        }
    }

    public void clearContent() {
        this.items.clear();
    }
}