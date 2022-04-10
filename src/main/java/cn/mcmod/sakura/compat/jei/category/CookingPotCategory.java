package cn.mcmod.sakura.compat.jei.category;

import com.mojang.blaze3d.vertex.PoseStack;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.block.entity.CookingPotBlockEntity;
import cn.mcmod.sakura.compat.jei.JEIPlugin;
import cn.mcmod.sakura.recipes.CookingPotRecipe;
import cn.mcmod_mmf.mmlib.fluid.FluidIngredient;
import mezz.jei.api.constants.VanillaTypes;
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
        arrow = helper.drawableBuilder(backgroundImage, 176, 18, 24, 17).buildAnimated(200, IDrawableAnimated.StartDirection.LEFT, false);
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
    public RecipeType<CookingPotRecipe> getRecipeType() {
        return JEIPlugin.COOKING_POT_JEI_TYPE;
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
    public void setRecipe(IRecipeLayoutBuilder builder, CookingPotRecipe recipe, IFocusGroup focuses) {
        NonNullList<Ingredient> recipeIngredients = recipe.getIngredients();
        int borderSlotSize = 18;
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 3; ++column) {
                int inputIndex = row * 3 + column;
                if (inputIndex < recipeIngredients.size()) {
                    builder.addSlot(RecipeIngredientRole.INPUT, 23 + column * borderSlotSize, 1 + row * borderSlotSize)
                    .addIngredients(recipeIngredients.get(inputIndex));
                }
            }
        }
        if(recipe.getRequiredFluid() != FluidIngredient.EMPTY)
            builder.addSlot(RecipeIngredientRole.INPUT, 1, 1)
            .setFluidRenderer(CookingPotBlockEntity.TANK_CAPACITY, true, 16, 52)
            .addIngredients(VanillaTypes.FLUID, recipe.getRequiredFluid().getMatchingFluidStacks());
        
        builder.addSlot(RecipeIngredientRole.OUTPUT, 120, 22).addItemStack(recipe.getResultItem());
    }

    @Override
    public void draw(CookingPotRecipe recipe, PoseStack matrixStack, double mouseX, double mouseY) {
        arrow.draw(matrixStack, 82, 18);
        heatIndicator.draw(matrixStack, 85, 36);
    }
}
