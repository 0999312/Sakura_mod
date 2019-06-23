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
        addSlotToContainer(new Slot(tile, 0, 45, 11));
//        addSlotToContainer(new Slot(tile, 1, 40, 36));
//        addSlotToContainer(new Slot(tile, 2, 22, 36));
//        addSlotToContainer(new Slot(tile, 3, 4, 36));
//        addSlotToContainer(new Slot(tile, 4, 32, 20));
        int i,j,k,l;
        for (k = 1; k <5; ++k)
            addSlotToContainer(new Slot(tile, k, 18 + (k-1) * 18, 29));
        for (l = 5; l <9; ++l)
            addSlotToContainer(new Slot(tile, l, 18 + (l-5) * 18, 47));
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

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            switch (slotIndex) {
			case 0:
                if (!this.mergeItemStack(itemstack1, 6, 41, true)) 
                    return ItemStack.EMPTY;
			case 1:
                if (!this.mergeItemStack(itemstack1, 6, 41, true)) 
                    return ItemStack.EMPTY;
			case 2:
                if (!this.mergeItemStack(itemstack1, 6, 41, true)) 
                    return ItemStack.EMPTY;
			case 3:
                if (!this.mergeItemStack(itemstack1, 6, 41, true)) 
                    return ItemStack.EMPTY;
			case 4:
                if (!this.mergeItemStack(itemstack1, 6, 41, true)) 
                    return ItemStack.EMPTY;
			case 5:
                if (!this.mergeItemStack(itemstack1, 6, 41, true)) 
                    return ItemStack.EMPTY;
			case 6:
                if (!this.mergeItemStack(itemstack1, 6, 41, true)) 
                    return ItemStack.EMPTY;
			case 7:
                if (!this.mergeItemStack(itemstack1, 6, 41, true)) 
                    return ItemStack.EMPTY;
			case 8:
                if (!this.mergeItemStack(itemstack1, 6, 41, true)) 
                    return ItemStack.EMPTY;
			case 9:
                if (!this.mergeItemStack(itemstack1, 6, 41, true)) 
                    return ItemStack.EMPTY;
			default:
              if (!this.mergeItemStack(itemstack1, 0, 9, false)) {
              return ItemStack.EMPTY;
			}
            
                slot.onSlotChange(itemstack1, itemstack);
            }


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
