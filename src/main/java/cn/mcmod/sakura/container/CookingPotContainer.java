package cn.mcmod.sakura.container;

import java.util.Objects;

import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.block.entity.CookingPotBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class CookingPotContainer extends AbstractContainerMenu {

    public final CookingPotBlockEntity tileEntity;
    public final ItemStackHandler inventory;
    private final ContainerData containerData;
    private final ContainerLevelAccess canInteractWithCallable;

    public CookingPotContainer(final int windowId, final Inventory playerInventory,
            final CookingPotBlockEntity tileEntity, ContainerData cookingPotDataIn) {
        super(ContainerRegistry.COOKING_POT.get(), windowId);
        this.tileEntity = tileEntity;
        this.inventory = tileEntity.getInventory();
        this.containerData = cookingPotDataIn;
        this.canInteractWithCallable = ContainerLevelAccess.create(tileEntity.getLevel(), tileEntity.getBlockPos());
        int startX = 8;
        int startY = 18;
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 3; ++column) {
                this.addSlot(new SlotItemHandler(inventory, (row * 2) + column, 39 + (column * 18), 17 + (row * 18)));
            }
        }

        this.addSlot(new CookingPotResultSlot(playerInventory.player, tileEntity, inventory, 4, 136, 38));

        // Main Player Inventory
        int startPlayerInvY = startY * 4 + 12;
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startX + (column * 18),
                        startPlayerInvY + (row * 18)));
            }
        }

        // Hotbar
        for (int column = 0; column < 9; ++column) {
            this.addSlot(new Slot(playerInventory, column, startX + (column * 18), 142));
        }

        this.addDataSlots(cookingPotDataIn);
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        // 0-9: Contain inventory
        // 10-36: Player inventory
        // 37-46: Hot bar in the player inventory

        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack itemStack1 = slot.getItem();
            itemStack = itemStack1.copy();

            if (index >= 0 && index <= 9) {
                if (!this.moveItemStackTo(itemStack1, 10, 46, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemStack1, itemStack);
            } else if (index >= 10) {
                if (index >= 10 && index < 37) {
                    if (!this.moveItemStackTo(itemStack1, 37, 46, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 37 && index < 46 && !this.moveItemStackTo(itemStack1, 10, 37, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemStack1, 10, 46, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack1.getCount() == 0) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemStack1.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemStack1);
        }

        return itemStack;
    }

    private static CookingPotBlockEntity getTileEntity(final Inventory playerInventory, final FriendlyByteBuf data) {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        final BlockEntity tileAtPos = playerInventory.player.level.getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof CookingPotBlockEntity) {
            return (CookingPotBlockEntity) tileAtPos;
        }
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }

    public CookingPotContainer(final int windowId, final Inventory playerInventory, final FriendlyByteBuf data) {
        this(windowId, playerInventory, getTileEntity(playerInventory, data), new SimpleContainerData(4));
    }

    @Override
    public boolean stillValid(Player playerIn) {
        return stillValid(canInteractWithCallable, playerIn, BlockRegistry.COOKING_POT.get());
    }

    @OnlyIn(Dist.CLIENT)
    public int getCookProgressionScaled() {
        int i = this.containerData.get(0);
        int j = this.containerData.get(1);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isHeated() {
        return this.tileEntity.isHeated();
    }
}
