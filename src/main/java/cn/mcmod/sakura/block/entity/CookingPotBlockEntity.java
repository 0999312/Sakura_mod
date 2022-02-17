package cn.mcmod.sakura.block.entity;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import cn.mcmod.sakura.container.CookingPotContainer;
import cn.mcmod.sakura.inventory.CookingPotItemHandler;
import cn.mcmod.sakura.recipes.CookingPotRecipe;
import cn.mcmod_mmf.mmlib.block.entity.HeatableBlockEntity;
import cn.mcmod_mmf.mmlib.block.entity.SyncedBlockEntity;
import cn.mcmod_mmf.mmlib.utils.LevelUtils;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class CookingPotBlockEntity extends SyncedBlockEntity implements MenuProvider, HeatableBlockEntity {

    private final ItemStackHandler inventory;
    private final LazyOptional<IItemHandler> inputHandler;
    private final LazyOptional<IItemHandler> outputHandler;

    private LazyOptional<FluidTank> fluidTank = LazyOptional.of(this::createFluidHandler);
    protected final ContainerData tileData;
    private final Object2IntOpenHashMap<ResourceLocation> experienceTracker;

    private int recipeTime;
    private int recipeTimeTotal;

    private ResourceLocation lastRecipeID;
    private boolean checkNewRecipe;

    public CookingPotBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.COOKING_POT.get(), pos, state);

        this.inventory = createHandler();
        this.inputHandler = LazyOptional.of(() -> new CookingPotItemHandler(inventory, Direction.UP));
        this.outputHandler = LazyOptional.of(() -> new CookingPotItemHandler(inventory, Direction.DOWN));
        this.tileData = createIntArray();
        this.experienceTracker = new Object2IntOpenHashMap<>();
    }


    public static void workingTick(Level level, BlockPos pos, BlockState state, CookingPotBlockEntity blockEntity) {
        boolean didInventoryChange = false;
        if (blockEntity.isHeated(level, pos) && blockEntity.hasInput()) {
            Optional<CookingPotRecipe> recipe = blockEntity.getMatchingRecipe(new RecipeWrapper(blockEntity.inventory));
            if (recipe.isPresent() && blockEntity.canWork(recipe.get())) {
                didInventoryChange = blockEntity.processRecipe(recipe.get());
            } else {
                blockEntity.recipeTime = 0;
            }
        } else if (blockEntity.recipeTime > 0) {
            blockEntity.recipeTime = 0;
        }

        if (didInventoryChange) {
            blockEntity.inventoryChanged();
        }
    }

    private boolean hasInput() {
        for (int i = 0; i < 9; ++i) {
            if (!inventory.getStackInSlot(i).isEmpty())
                return true;
        }
        return false;
    }
    
    private Optional<CookingPotRecipe> getMatchingRecipe(RecipeWrapper inventoryWrapper) {
        if (level == null) return Optional.empty();

        if (lastRecipeID != null) {
            Recipe<RecipeWrapper> recipe = level.getRecipeManager()
                    .getAllRecipesFor(CookingPotRecipe.TYPE).stream().filter(now->now.getId().equals(lastRecipeID)).findFirst().get();
            if (recipe instanceof CookingPotRecipe) {
                CookingPotRecipe cookingRecipe = (CookingPotRecipe) recipe;
                if (cookingRecipe.matchesWithFluid(this.fluidTank.orElse(new FluidTank(0)).getFluid(), inventoryWrapper, level)) {
                    return Optional.of(cookingRecipe);
                }
            }
        }

        if (checkNewRecipe) {
            Optional<CookingPotRecipe> recipe = level.getRecipeManager().getRecipeFor(CookingPotRecipe.TYPE, inventoryWrapper, level);
            if (recipe.isPresent()) {
                lastRecipeID = recipe.get().getId();
                return recipe;
            }
        }

        checkNewRecipe = false;
        return Optional.empty();
    }

    protected boolean canWork(CookingPotRecipe recipe) {
        if (hasInput()) {
            ItemStack resultStack = recipe.getResultItem();
            if (resultStack.isEmpty()) {
                return false;
            } else {
                ItemStack outputStack = inventory.getStackInSlot(9);
                if (outputStack.isEmpty()) {
                    return true;
                } else if (!outputStack.sameItem(resultStack)) {
                    return false;
                } else if (outputStack.getCount() + resultStack.getCount() <= inventory.getSlotLimit(9)) {
                    return true;
                } else {
                    return outputStack.getCount() + resultStack.getCount() <= resultStack.getMaxStackSize();
                }
            }
        } else {
            return false;
        }
    }

    private boolean processRecipe(CookingPotRecipe recipe) {
        if (level == null)
            return false;

        ++recipeTime;
        recipeTimeTotal = recipe.getRecipeTime();
        if (recipeTime < recipeTimeTotal) {
            return false;
        }

        recipeTime = 0;
        
        ItemStack resultStack = recipe.getResultItem();
        ItemStack outStack = inventory.getStackInSlot(9);
        
        if (outStack.isEmpty()) {
            inventory.setStackInSlot(9, resultStack.copy());
        } else if (outStack.sameItem(resultStack)) {
            outStack.grow(resultStack.getCount());
        }
        
        this.fluidTank.orElse(new FluidTank(0)).drain(recipe.getRequiredFluid().getRequiredAmount(), FluidAction.EXECUTE);
      
        trackRecipeExperience(recipe);

        for (int i = 0; i < 9; ++i) {
            ItemStack slotStack = inventory.getStackInSlot(i);
            if (slotStack.hasContainerItem()) {
                double x = worldPosition.getX() + 0.5;
                double y = worldPosition.getY() + 0.7;
                double z = worldPosition.getZ() + 0.5;
                LevelUtils.spawnItemEntity(level, inventory.getStackInSlot(i).getContainerItem(), x, y, z, 0F, 0.25F,0F);
            }
            if (!slotStack.isEmpty())
                slotStack.shrink(1);
        }
        return true;
    }

    public void trackRecipeExperience(@Nullable Recipe<?> recipe) {
        if (recipe != null) {
            ResourceLocation recipeID = recipe.getId();
            experienceTracker.addTo(recipeID, 1);
        }
    }

    public void clearUsedRecipes(Player player) {
        grantStoredRecipeExperience(player.level, player.position());
        experienceTracker.clear();
    }

    public void grantStoredRecipeExperience(Level world, Vec3 pos) {
        for (Object2IntMap.Entry<ResourceLocation> entry : experienceTracker.object2IntEntrySet()) {
            world.getRecipeManager().byKey(entry.getKey())
                    .ifPresent((recipe) -> LevelUtils.splitAndSpawnExperience(world, pos, entry.getIntValue(),
                            ((CookingPotRecipe) recipe).getExperience()));
        }
    }

    @Override
    @Nonnull
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        
        if (cap.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)) {
            if (side == null || side.equals(Direction.UP)) {
                return inputHandler.cast();
            } else {
                return outputHandler.cast();
            }
        }
        if (!this.isRemoved() && cap.equals(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)) {
            return this.fluidTank.cast();
        }
        return super.getCapability(cap, side);
    }

    public ItemStackHandler getInventory() {
        return inventory;
    }
    
    public NonNullList<ItemStack> getDroppableInventory() {
        NonNullList<ItemStack> drops = NonNullList.create();
        for (int i = 0; i < 10; ++i) {
                drops.add(inventory.getStackInSlot(i));
        }
        return drops;
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        inputHandler.invalidate();
        outputHandler.invalidate();
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        inventory.deserializeNBT(compound.getCompound("Inventory"));
        recipeTime = compound.getInt("RecipeTime");
        recipeTimeTotal = compound.getInt("RecipeTimeTotal");
        fluidTank.ifPresent(fluid->fluid.readFromNBT(compound.getCompound("FluidTank")));
        CompoundTag compoundRecipes = compound.getCompound("RecipesUsed");
        for (String key : compoundRecipes.getAllKeys()) {
            experienceTracker.put(new ResourceLocation(key), compoundRecipes.getInt(key));
        }
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        super.saveAdditional(compound);
        CompoundTag nbt = new CompoundTag();
        fluidTank.ifPresent(fluid->compound.put("FluidTank", nbt));
        compound.putInt("RecipeTime", recipeTime);
        compound.putInt("RecipeTimeTotal", recipeTimeTotal);
        compound.put("Inventory", inventory.serializeNBT());
        CompoundTag compoundRecipes = new CompoundTag();
        experienceTracker
                .forEach((recipeId, craftedAmount) -> compoundRecipes.putInt(recipeId.toString(), craftedAmount));
        compound.put("RecipesUsed", compoundRecipes);
    }

    private CompoundTag writeItems(CompoundTag compound) {
        super.saveAdditional(compound);
        compound.put("Inventory", inventory.serializeNBT());
        return compound;
    }

    @Override
    public CompoundTag getUpdateTag() {
        return writeItems(new CompoundTag());
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(10) {
            @Override
            protected void onContentsChanged(int slot) {
                if (slot >= 0 && slot < 9) {
                    checkNewRecipe = true;
                }
                inventoryChanged();
            }
        };
    }

    private FluidTank createFluidHandler() {
        return new FluidTank(3000) {
            @Override
            protected void onContentsChanged() {
                inventoryChanged();
            }
            
            @Override
            public boolean isFluidValid(FluidStack stack) {
                return !stack.getFluid().getAttributes().isLighterThanAir();
            }
        };
    }

    private ContainerData createIntArray() {
        return new ContainerData() {
            @Override
            public int get(int index) {
                switch (index) {
                case 0:
                    return CookingPotBlockEntity.this.recipeTime;
                case 1:
                    return CookingPotBlockEntity.this.recipeTimeTotal;
                default:
                    return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                case 0:
                    CookingPotBlockEntity.this.recipeTime = value;
                    break;
                case 1:
                    CookingPotBlockEntity.this.recipeTimeTotal = value;

                    break;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory player, Player entity) {
        return new CookingPotContainer(id, player, this, this.tileData);
    }

    @Override
    public Component getDisplayName() {
        return new TranslatableComponent("sakura.cooking_pot");
    }
    
    public boolean isHeated() {
        if (level == null) return false;
        return this.isHeated(level, worldPosition);
    }

    public LazyOptional<FluidTank> getFluidTank() {
        return fluidTank;
    }

}
