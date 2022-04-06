package cn.mcmod.sakura.compat.jei.category;

import java.util.Arrays;
import com.mojang.blaze3d.vertex.PoseStack;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.recipes.CookingPotRecipe;
import cn.mcmod_mmf.mmlib.fluid.FluidIngredient;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

@SuppressWarnings("removal")
public class CookingPotCategory implements IRecipeCategory<CookingPotRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(SakuraMod.MODID, "cooking");
    protected final IDrawable heatIndicator;
    protected final IDrawableAnimated arrow;
    private final Component title;
    private final IDrawable background;
    private final IDrawable icon;

    public CookingPotCategory(IGuiHelper helper) {
        title = new TranslatableComponent("sakura.jei.cooking");
        ResourceLocation backgroundImage = new ResourceLocation(SakuraMod.MODID, "textures/gui/pot.png");
        background = helper.createDrawable(backgroundImage, 16, 16, 144, 54);
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(BlockRegistry.COOKING_POT.get()));
        heatIndicator = helper.createDrawable(backgroundImage, 176, 0, 18, 18);
        arrow = helper.drawableBuilder(backgroundImage, 176, 18, 24, 17).buildAnimated(200,
                IDrawableAnimated.StartDirection.LEFT, false);
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends CookingPotRecipe> getRecipeClass() {
        return CookingPotRecipe.class;
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
    public void setIngredients(CookingPotRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        if(recipe.getRequiredFluid() != FluidIngredient.EMPTY)
            ingredients.setInputs(VanillaTypes.FLUID, recipe.getRequiredFluid().getMatchingFluidStacks());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, CookingPotRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
        NonNullList<Ingredient> recipeIngredients = recipe.getIngredients();
        int borderSlotSize = 18;
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 3; ++column) {
                int inputIndex = row * 3 + column;
                if (inputIndex < recipeIngredients.size()) {
                    itemStacks.init(inputIndex, true, 22 + column * borderSlotSize, row * borderSlotSize);
                    itemStacks.set(inputIndex, Arrays.asList(recipeIngredients.get(inputIndex).getItems()));
                }
            }
        }
        
        recipeLayout.getFluidStacks().init(0, true, 1, 1, 16, 52, 3000, true, null);
        if(recipe.getRequiredFluid() != FluidIngredient.EMPTY)
            recipeLayout.getFluidStacks().set(0, recipe.getRequiredFluid().getMatchingFluidStacks());

        itemStacks.init(9, false, 119, 21);
        itemStacks.set(9, recipe.getResultItem());
    }

    @Override
    public void draw(CookingPotRecipe recipe, PoseStack matrixStack, double mouseX, double mouseY) {
        arrow.draw(matrixStack, 82, 18);
        heatIndicator.draw(matrixStack, 85, 36);
    }
}
