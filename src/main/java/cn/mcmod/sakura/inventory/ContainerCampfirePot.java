package cn.mcmod.sakura.inventory;

import cn.mcmod.sakura.tileentity.TileEntityCampfirePot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerCampfirePot extends Container {
    private TileEntityCampfirePot tileCampfire;
    private int processTime;
    private int maxProcessTime;
    private int burnTime;

    public ContainerCampfirePot(InventoryPlayer inventory, TileEntityCampfirePot tile) {
        tileCampfire = tile;
        addSlotToContainer(new Slot(tile, 0, 45, 19));
        int i,j,k,l;
        for (k = 1; k <5; ++k)
            addSlotToContainer(new Slot(tile, k, 18 + (k-1) * 18, 37));
        for (l = 5; l <9; ++l)
            addSlotToContainer(new Slot(tile, l, 18 + (l-5) * 18, 55));
        addSlotToContainer(new Slot(tile, 9, 130, 46) {
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
        listener.sendAllWindowProperties(this, this.tileCampfire);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); ++i) {
            IContainerListener icontainerlistener = this.listeners.get(i);

            if (this.burnTime != this.tileCampfire.getField(0)) {
                icontainerlistener.sendWindowProperty(this, 0, this.tileCampfire.getField(0));
            }

            if (this.processTime != this.tileCampfire.getField(1)) {
                icontainerlistener.sendWindowProperty(this, 1, this.tileCampfire.getField(1));
            }

            if (this.maxProcessTime != this.tileCampfire.getField(2)) {
                icontainerlistener.sendWindowProperty(this, 2, this.tileCampfire.getField(2));
            }
        }

        this.burnTime = this.tileCampfire.getField(0);
        this.processTime = this.tileCampfire.getField(1);
        this.maxProcessTime = this.tileCampfire.getField(2);
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
        // 0-9: Contain inventory
        // 10-36: Player inventory
        // 37-46: Hot bar in the player inventory

        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (index >= 0 && index <= 9){
                if (!this.mergeItemStack(itemStack1, 10, 46, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemStack1, itemStack);
            }
            else if (index >= 10){
            	if (index >= 10 && index < 37){
                    if (!this.mergeItemStack(itemStack1, 37, 46, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 37 && index < 46 && !this.mergeItemStack(itemStack1, 10, 37, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemStack1, 10, 46, false))
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
