package cn.mcmod.sakura.block.entity;

import cn.mcmod.sakura.container.DistillerContainer;
import cn.mcmod.sakura.inventory.FermenterItemHandler;
import cn.mcmod.sakura.recipes.DistillerRecipe;
import cn.mcmod.sakura.recipes.RecipeTypeRegistry;
import cn.mcmod_mmf.mmlib.block.entity.HeatableBlockEntity;
import cn.mcmod_mmf.mmlib.block.entity.SyncedBlockEntity;
import cn.mcmod_mmf.mmlib.fluid.FluidIngredient;
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.List;
import java.util.Optional;

public class DistillerBlockEntity extends SyncedBlockEntity implements MenuProvider, HeatableBlockEntity {

    public static final int TANK_CAPACITY = 8000;
    private final ItemStackHandler inventory;
    private LazyOptional<IItemHandler> inputHandler;
    private LazyOptional<IItemHandler> outputHandler;

    private LazyOptional<FluidTank> inputfluidTank;
    private LazyOptional<FluidTank> outputfluidTank;
    protected final ContainerData tileData;
    private final Object2IntOpenHashMap<ResourceLocation> experienceTracker;

    private int recipeTime;
    private int recipeTimeTotal;

    private ResourceLocation lastRecipeID;
    private boolean checkNewRecipe;

    public DistillerBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.DISTILLER.get(), pos, state);

        this.inventory = createHandler();
        this.inputHandler = LazyOptional.of(() -> new FermenterItemHandler(inventory, Direction.UP));
        this.outputHandler = LazyOptional.of(() -> new FermenterItemHandler(inventory, Direction.DOWN));
        this.tileData = createIntArray();
        this.inputfluidTank = LazyOptional.of(this::createInputFluidHandler);
        this.outputfluidTank = LazyOptional.of(this::createFluidHandler);
        this.experienceTracker = new Object2IntOpenHashMap<>();
    }

    public static void workingTick(Level level, BlockPos pos, BlockState state, DistillerBlockEntity blockEntity) {
        boolean didInventoryChange = false;
        if (blockEntity.isHeated(level, pos) && blockEntity.hasInput()) {
            Optional<DistillerRecipe> recipe = blockEntity.getMatchingRecipe(new RecipeWrapper(blockEntity.inventory));
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
        if(this.inputfluidTank.isPresent()) {
            return !this.inputfluidTank.orElse(new FluidTank(0)).isEmpty();
        }
        
        for (int i = 0; i < 3; ++i) {
            if (!inventory.getStackInSlot(i).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private Optional<DistillerRecipe> getMatchingRecipe(RecipeWrapper inventoryWrapper) {
        if (level == null) {
            return Optional.empty();
        }

        if (lastRecipeID != null) {
            Recipe<RecipeWrapper> recipe = level.getRecipeManager()
                    .getAllRecipesFor(RecipeTypeRegistry.DISTILLER_RECIPE_TYPE.get()).stream()
                    .filter(now -> now.getId().equals(lastRecipeID)).findFirst().get();
            if (recipe instanceof DistillerRecipe cookingRecipe) {
                if (cookingRecipe.matchesWithFluid(this.inputfluidTank.orElse(new FluidTank(0)).getFluid(),
                        inventoryWrapper, level)) {
                    return Optional.of(cookingRecipe);
                }
            }
        }

        if (checkNewRecipe) {
            List<DistillerRecipe> recipes = level.getRecipeManager()
                    .getRecipesFor(RecipeTypeRegistry.DISTILLER_RECIPE_TYPE.get(), inventoryWrapper, level);
            for(DistillerRecipe recipe : recipes) {
                if (recipe.matchesWithFluid(this.inputfluidTank.orElse(new FluidTank(0)).getFluid(), inventoryWrapper, level)) {
                    lastRecipeID = recipe.getId();
                    return Optional.of(recipe);
                }
            }
        }

        checkNewRecipe = false;
        return Optional.empty();
    }

    protected boolean canWork(DistillerRecipe recipe) {
        if (hasInput()) {
            NonNullList<ItemStack> resultStacks = recipe.getResultItemList();
            boolean fluid_flag = !(recipe.getResultFluid().isEmpty());
            if (this.outputfluidTank.isPresent()) {
                FluidTank outTank = this.outputfluidTank.orElse(null);
                fluid_flag = outTank.isEmpty() || recipe.getResultFluid().isEmpty() ||
                        (outTank.getFluid().isFluidEqual(recipe.getResultFluid()) && outTank.getSpace() >= recipe.getResultFluid().getAmount());
            }
            boolean flag = true;
            for (int i = 3; i < resultStacks.size() + 3; i++) {
                if (!flag)
                    break;
                ItemStack resultStack = resultStacks.get(i - 3);
                ItemStack outputStack = inventory.getStackInSlot(i);
                if (outputStack.isEmpty()) {
                    flag = true;
                } else if (!outputStack.sameItem(resultStack)) {
                    flag = false;
                } else if (outputStack.getCount() + resultStack.getCount() <= inventory.getSlotLimit(i)) {
                    flag = true;
                } else {
                    flag = outputStack.getCount() + resultStack.getCount() <= resultStack.getMaxStackSize();
                }
            }
            return fluid_flag && flag;
        }
        return false;    
    }

    private boolean processRecipe(DistillerRecipe recipe) {
        if (level == null) {
            return false;
        }

        ++recipeTime;
        recipeTimeTotal = recipe.getRecipeTime();
        if (recipeTime < recipeTimeTotal) {
            return false;
        }

        recipeTime = 0;

        NonNullList<ItemStack> resultStacks = recipe.getResultItemList();
        for (int i = 3; i < resultStacks.size() + 3; i++) {
            ItemStack outStack = inventory.getStackInSlot(i);
            if (outStack.isEmpty()) {
                inventory.setStackInSlot(i, resultStacks.get(i - 3).copy());
            } else if (outStack.sameItem(resultStacks.get(i - 3))) {
                outStack.grow(resultStacks.get(i - 3).getCount());
            }
        }

        if (recipe.getRequiredFluid() != FluidIngredient.EMPTY)
            this.inputfluidTank.orElse(new FluidTank(0)).drain(recipe.getRequiredFluid().getRequiredAmount(),
                    FluidAction.EXECUTE);
        if (!recipe.getResultFluid().isEmpty())
            this.outputfluidTank.orElse(new FluidTank(0)).fill(recipe.getResultFluid(), FluidAction.EXECUTE);

        trackRecipeExperience(recipe);

        for (int i = 0; i < 3; ++i) {
            ItemStack slotStack = inventory.getStackInSlot(i);
            if (slotStack.hasContainerItem()) {
                double x = worldPosition.getX() + 0.5;
                double y = worldPosition.getY() + 0.7;
                double z = worldPosition.getZ() + 0.5;
                LevelUtils.spawnItemEntity(level, inventory.getStackInSlot(i).getContainerItem(), x, y, z, 0F, 0.25F,
                        0F);
            }
            if (!slotStack.isEmpty()) {
                slotStack.shrink(1);
            }
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
            world.getRecipeManager().byKey(entry.getKey()).ifPresent(recipe -> LevelUtils.splitAndSpawnExperience(world,
                    pos, entry.getIntValue(), ((DistillerRecipe) recipe).getExperience()));
        }
    }

    @Override
    @Nonnull
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        if (!this.isRemoved()) {
            if (cap.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)) {
                if (side == null || side.equals(Direction.UP)) {
                    return inputHandler.cast();
                } else {
                    return outputHandler.cast();
                }
            }
            if (cap.equals(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)) {
                if(side == null || !(side.equals(Direction.NORTH)||side.equals(Direction.SOUTH)))
                    return this.inputfluidTank.cast();
                else return this.outputfluidTank.cast();
            }
        }
        return super.getCapability(cap, side);
    }

    public ItemStackHandler getInventory() {
        return inventory;
    }

    public NonNullList<ItemStack> getDroppableInventory() {
        NonNullList<ItemStack> drops = NonNullList.create();
        for (int i = 0; i < 6; ++i) {
            drops.add(inventory.getStackInSlot(i));
        }
        return drops;
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        inputHandler.invalidate();
        outputHandler.invalidate();
        inputfluidTank.invalidate();
        outputfluidTank.invalidate();
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        inventory.deserializeNBT(compound.getCompound("Inventory"));
        recipeTime = compound.getInt("RecipeTime");
        recipeTimeTotal = compound.getInt("RecipeTimeTotal");
        inputfluidTank.ifPresent(fluid -> fluid.readFromNBT(compound.getCompound("InputFluidTank")));
        outputfluidTank.ifPresent(fluid -> fluid.readFromNBT(compound.getCompound("OutputFluidTank")));
        CompoundTag compoundRecipes = compound.getCompound("RecipesUsed");
        for (String key : compoundRecipes.getAllKeys()) {
            experienceTracker.put(new ResourceLocation(key), compoundRecipes.getInt(key));
        }
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        super.saveAdditional(compound);
        CompoundTag nbt = new CompoundTag();
        compound.putInt("RecipeTime", recipeTime);
        compound.putInt("RecipeTimeTotal", recipeTimeTotal);
        compound.put("Inventory", inventory.serializeNBT());
        inputfluidTank.ifPresent(fluid -> compound.put("InputFluidTank", fluid.writeToNBT(nbt)));
        CompoundTag nbt2 = new CompoundTag();
        outputfluidTank.ifPresent(fluid -> compound.put("OutputFluidTank", fluid.writeToNBT(nbt2)));
        CompoundTag compoundRecipes = new CompoundTag();
        experienceTracker
                .forEach((recipeId, craftedAmount) -> compoundRecipes.putInt(recipeId.toString(), craftedAmount));
        compound.put("RecipesUsed", compoundRecipes);
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(6) {
            @Override
            protected void onContentsChanged(int slot) {
                if (slot >= 0 && slot < 3) {
                    checkNewRecipe = true;
                }
                inventoryChanged();
            }
        };
    }
    
    private FluidTank createInputFluidHandler() {
        return new FluidTank(TANK_CAPACITY) {
            @Override
            protected void onContentsChanged() {
                inventoryChanged();
                checkNewRecipe = true;
                super.onContentsChanged();
            }

            @Override
            public boolean isFluidValid(FluidStack stack) {
                return !stack.getFluid().getAttributes().isLighterThanAir();
            }
        };
    }

    private FluidTank createFluidHandler() {
        return new FluidTank(TANK_CAPACITY) {
            @Override
            protected void onContentsChanged() {
                inventoryChanged();
                super.onContentsChanged();
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
                    return DistillerBlockEntity.this.recipeTime;
                case 1:
                    return DistillerBlockEntity.this.recipeTimeTotal;
                default:
                    return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                case 0:
                    DistillerBlockEntity.this.recipeTime = value;
                    break;
                case 1:
                    DistillerBlockEntity.this.recipeTimeTotal = value;
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
        return new DistillerContainer(id, player, this, this.tileData);
    }
    
    public boolean isHeated() {
        if (level == null) {
            return false;
        }
        return this.isHeated(level, worldPosition);
    }

    @Override
    public Component getDisplayName() {
        return new TranslatableComponent("container.sakura.distiller");
    }

    public LazyOptional<FluidTank> getInputFluidTank() {
        return inputfluidTank;
    }

    public LazyOptional<FluidTank> getOutputFluidTank() {
        return outputfluidTank;
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        inputHandler.invalidate();
        outputHandler.invalidate();
        inputfluidTank.invalidate();
        outputfluidTank.invalidate();
    }

    @Override
    public void reviveCaps() {
        super.reviveCaps();
        inputHandler = LazyOptional.of(() -> new FermenterItemHandler(inventory, Direction.UP));
        outputHandler = LazyOptional.of(() -> new FermenterItemHandler(inventory, Direction.DOWN));
        inputfluidTank = LazyOptional.of(this::createInputFluidHandler);
        outputfluidTank = LazyOptional.of(this::createFluidHandler);
    }

}
