package cn.mcmod.sakura.inventory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public class FermenterItemHandler implements IItemHandler {
    private static final int SLOTS_INPUT = 3;
    private static final int SLOT_OUTPUT_BEGIN = 3;
    private static final int SLOT_OUTPUT_END = 5;
    private final IItemHandler itemHandler;
    private final Direction side;

    public FermenterItemHandler(IItemHandler itemHandler, @Nullable Direction side) {
        this.itemHandler = itemHandler;
        this.side = side;
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return itemHandler.isItemValid(slot, stack);
    }

    @Override
    public int getSlots() {
        return itemHandler.getSlots();
    }

    @Override
    @Nonnull
    public ItemStack getStackInSlot(int slot) {
        return itemHandler.getStackInSlot(slot);
    }

    @Override
    @Nonnull
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
        if (side == null || side.equals(Direction.UP)) {
            return (slot < SLOTS_INPUT) ? itemHandler.insertItem(slot, stack, simulate) : stack;
        } else {
            return stack;
        }
    }

    @Override
    @Nonnull
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        if (side == null || side.equals(Direction.UP)) {
            return slot < SLOTS_INPUT ? itemHandler.extractItem(slot, amount, simulate) : ItemStack.EMPTY;
        } else {
            return (slot >= SLOT_OUTPUT_BEGIN || slot <= SLOT_OUTPUT_END)  ? itemHandler.extractItem(slot, amount, simulate) : ItemStack.EMPTY;
        }
    }

    @Override
    public int getSlotLimit(int slot) {
        return itemHandler.getSlotLimit(slot);
    }
}
