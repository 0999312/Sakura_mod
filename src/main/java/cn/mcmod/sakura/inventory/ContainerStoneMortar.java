package cn.mcmod.sakura.inventory;

import cn.mcmod.sakura.tileentity.TileEntityStoneMortar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerStoneMortar extends Container {
    private TileEntityStoneMortar tileCampfire;
    private int processTime;
    private int maxProcessTime;

    public ContainerStoneMortar(InventoryPlayer inventory, TileEntityStoneMortar tile) {
        tileCampfire = tile;
        addSlotToContainer(new Slot(tile, 0, 58, 36));
        addSlotToContainer(new Slot(tile, 1, 116, 36) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }
        });
        int i;

        for (i = 0; i < 3; ++i)
            for (int j = 0; j < 9; ++j)
                addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));

        for (i = 0; i < 9; ++i)
            addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
    }

    @Override
    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tileCampfire);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); ++i) {
            IContainerListener icontainerlistener = this.listeners.get(i);

            if (this.processTime != this.tileCampfire.getField(0)) {
                icontainerlistener.sendWindowProperty(this, 0, this.tileCampfire.getField(0));
            }

            if (this.maxProcessTime != this.tileCampfire.getField(1)) {
                icontainerlistener.sendWindowProperty(this, 1, this.tileCampfire.getField(1));
            }
        }

        this.processTime = this.tileCampfire.getField(0);
        this.maxProcessTime = this.tileCampfire.getField(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value) {
        this.tileCampfire.setField(id, value);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileCampfire.isUsableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotIndex == 0) {
                if (!this.mergeItemStack(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (slotIndex == 1) {
                if (!this.mergeItemStack(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!mergeItemStack(itemstack1, 2, 39, false))
                return ItemStack.EMPTY;
            if (itemstack1.getCount() == 0)
                slot.putStack(ItemStack.EMPTY);
            else
                slot.onSlotChanged();
            if (itemstack1.getCount() == itemstack.getCount())
                return ItemStack.EMPTY;

            slot.onTake(player, itemstack1);
        }
        return itemstack;
    }
}
