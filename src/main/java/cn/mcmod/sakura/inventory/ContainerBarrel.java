package cn.mcmod.sakura.inventory;

import cn.mcmod.sakura.tileentity.TileEntityBarrel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerBarrel extends Container {
    private TileEntityBarrel tileBarrel;
    private int processTime;
    private int maxprocessTime;

    public ContainerBarrel(InventoryPlayer inventory, TileEntityBarrel tile) {
        tileBarrel = tile;
        int i, j, k;
        for (k = 0; k < 3; ++k)
            addSlotToContainer(new Slot(tile, k, 42, 36 + (k - 1) * 18));
        addSlotToContainer(new Slot(tile, 3, 131, 12));
        addSlotToContainer(new Slot(tile, 4, 130, 56) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }
        });

        for (i = 0; i < 3; ++i)
            for (j = 0; j < 9; ++j)
                addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));

        for (i = 0; i < 9; ++i)
            addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
    }


    @Override
    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tileBarrel);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); ++i) {
            IContainerListener icontainerlistener = this.listeners.get(i);

            if (this.maxprocessTime != this.tileBarrel.getField(1)) {
                icontainerlistener.sendWindowProperty(this, 1, this.tileBarrel.getField(1));
            }

            if (this.processTime != this.tileBarrel.getField(0)) {
                icontainerlistener.sendWindowProperty(this, 0, this.tileBarrel.getField(0));
            }
        }

        this.processTime = this.tileBarrel.getField(0);
        this.maxprocessTime = this.tileBarrel.getField(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value) {
        this.tileBarrel.setField(id, value);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileBarrel.isUsableByPlayer(player);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int index)
    {
        // 0-4: Contain inventory
        // 5-31: Player inventory
        // 32-41: Hot bar in the player inventory

        ItemStack itemStack = null;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (index >= 0 && index <= 4){
                if (!this.mergeItemStack(itemStack1, 5, 42, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemStack1, itemStack);
            }
            else if (index >= 5){
            	if (index >= 5 && index < 32){
                    if (!this.mergeItemStack(itemStack1, 32, 42, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 32 && index < 42 && !this.mergeItemStack(itemStack1, 5, 32, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemStack1, 5, 42, false))
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
