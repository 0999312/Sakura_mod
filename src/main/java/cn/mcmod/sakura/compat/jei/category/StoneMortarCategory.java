package cn.mcmod.sakura.compat.jei.category;

import java.util.Arrays;
import com.mojang.blaze3d.vertex.PoseStack;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.recipes.StoneMortarRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
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
public class StoneMortarCategory implements IRecipeCategory<StoneMortarRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(SakuraMod.MODID, "stone_mortar");
    private final Component title;
    private final IDrawable background;
    private final IDrawable icon;
    protected final IDrawable mortar;
    protected final IDrawable basket;

    public StoneMortarCategory(IGuiHelper helper) {
        title = new TranslatableComponent("sakura.jei.stone_mortar");
        ResourceLocation backgroundImage = new ResourceLocation(SakuraMod.MODID, "textures/gui/stonemortar.png");
        background = helper.createDrawable(backgroundImage, 39, 13, 87, 62);
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(BlockRegistry.STONE_MORTAR.get()));
        mortar = helper.createDrawable(backgroundImage, 176, 0, 14, 16);
        basket = helper.createDrawable(backgroundImage, 190, 18, 16, 6);
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends StoneMortarRecipe> getRecipeClass() {
        return StoneMortarRecipe.class;
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
    public void setIngredients(StoneMortarRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutputs(VanillaTypes.ITEM, recipe.getResultItemList());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, StoneMortarRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
        NonNullList<Ingredient> recipeIngredients = recipe.getIngredients();
        int borderSlotSize = 18;
        for (int row = 0; row < 2; ++row) {
            for (int column = 0; column < 2; ++column) {
                int inputIndex = row * 2 + column;
                if (inputIndex < recipeIngredients.size()) {
                    itemStacks.init(inputIndex, true, column * borderSlotSize, 13 + row * borderSlotSize);
                    itemStacks.set(inputIndex, Arrays.asList(recipeIngredients.get(inputIndex).getItems()));
                }
            }
        }

        itemStacks.init(4, false, 65, 4);
        itemStacks.set(4, recipe.getResultItemList().get(0));
        if (recipe.getResultItemList().size() > 1) {
            itemStacks.init(5, false, 65, 40);
            itemStacks.set(5, recipe.getResultItemList().get(1));
        }
    }

    @Override
    public void draw(StoneMortarRecipe recipe, PoseStack matrixStack, double mouseX, double mouseY) {
        mortar.draw(matrixStack, 42, 20);
        basket.draw(matrixStack, 41, 36);
    }
}
