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
        addSlotToContainer(new Slot(tile, 0, 40, 26));
        addSlotToContainer(new Slot(tile, 1, 58, 26));
        addSlotToContainer(new Slot(tile, 2, 40, 44));
        addSlotToContainer(new Slot(tile, 3, 58, 44));
        addSlotToContainer(new Slot(tile, 4, 108, 37) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }
        });
        addSlotToContainer(new Slot(tile, 5, 132, 37) {
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

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int index)
    {
        // 0-5: Contain inventory
        // 6-32: Player inventory
        // 33-42: Hot bar in the player inventory

        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (index >= 0 && index <= 5){
                if (!this.mergeItemStack(itemStack1, 6, 42, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemStack1, itemStack);
            }
            else if (index >= 6){
            	if (index >= 6 && index < 33){
                    if (!this.mergeItemStack(itemStack1, 33, 42, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 33 && index < 42 && !this.mergeItemStack(itemStack1, 6, 32, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemStack1, 6, 42, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemStack1.getCount() == 0)
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemStack1.getCount() == itemStack.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(par1EntityPlayer, itemStack1);
        }

        return itemStack;
    }
}
