package cn.mcmod.sakura.compat.jei.category;

import com.mojang.blaze3d.vertex.PoseStack;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.block.entity.FermenterBlockEntity;
import cn.mcmod.sakura.compat.jei.JEIPlugin;
import cn.mcmod.sakura.recipes.FermenterRecipe;
import cn.mcmod_mmf.mmlib.fluid.FluidIngredient;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;

public class FermenterCategory implements IRecipeCategory<FermenterRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(SakuraMod.MODID, "fermenting");
    protected final IDrawableAnimated arrow;
    private final Component title;
    private final IDrawable background;
    private final IDrawable icon;

    public FermenterCategory(IGuiHelper helper) {
        title = new TranslatableComponent("sakura.jei.fermenting");
        ResourceLocation backgroundImage = new ResourceLocation(SakuraMod.MODID, "textures/gui/barrel.png");
        background = helper.createDrawable(backgroundImage, 32, 10, 110, 66);
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockRegistry.FERMENTER.get()));
        arrow = helper.drawableBuilder(backgroundImage, 176, 0, 24, 17).buildAnimated(200, IDrawableAnimated.StartDirection.LEFT, false);
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends FermenterRecipe> getRecipeClass() {
        return FermenterRecipe.class;
    }
    
    @Override
    public RecipeType<FermenterRecipe> getRecipeType() {
        return JEIPlugin.FERMENTER_JEI_TYPE;
    }

    @Override
    public Component getTitle() {
        return title;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }
    
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FermenterRecipe recipe, IFocusGroup focuses) {
        NonNullList<Ingredient> recipeIngredients = recipe.getIngredients();
        int borderSlotSize = 18;
        for (int row = 0; row < 3; ++row) {
                int inputIndex = row;
                if (inputIndex < recipeIngredients.size()) {
                    builder.addSlot(RecipeIngredientRole.INPUT, 23, 7 + row * borderSlotSize)
                    .addIngredients(recipeIngredients.get(inputIndex));
                }
        }
        if(recipe.getRequiredFluid() != FluidIngredient.EMPTY)
            builder.addSlot(RecipeIngredientRole.INPUT, 1, 1)
            .setFluidRenderer(FermenterBlockEntity.TANK_CAPACITY, true, 16, 64)
            .addIngredients(ForgeTypes.FLUID_STACK, recipe.getRequiredFluid().getMatchingFluidStacks());
        
        for (int row = 0; row < 3; ++row) {
            int inputIndex = row;
            if (inputIndex < recipe.getResultItemList().size()) {
                builder.addSlot(RecipeIngredientRole.OUTPUT, 71, 7 + row * borderSlotSize)
                .addItemStack(recipe.getResultItemList().get(inputIndex));
            }
        }
        if(recipe.getResultFluid() != FluidStack.EMPTY)
            builder.addSlot(RecipeIngredientRole.INPUT, 93, 1)
            .setFluidRenderer(FermenterBlockEntity.TANK_CAPACITY, true, 16, 64)
            .addIngredient(ForgeTypes.FLUID_STACK, recipe.getResultFluid());
    }

    @Override
    public void draw(FermenterRecipe recipe, PoseStack matrixStack, double mouseX, double mouseY) {
        arrow.draw(matrixStack, 44, 24);
    }
}
