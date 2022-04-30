package cn.mcmod.sakura.compat.jei.category;

import com.mojang.blaze3d.vertex.PoseStack;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.compat.jei.JEIPlugin;
import cn.mcmod.sakura.recipes.StoneMortarRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
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
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockRegistry.STONE_MORTAR.get()));
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
    public RecipeType<StoneMortarRecipe> getRecipeType() {
        return JEIPlugin.STONE_MORTAR_JEI_TYPE;
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
    public void setRecipe(IRecipeLayoutBuilder builder, StoneMortarRecipe recipe, IFocusGroup focuses) {
      NonNullList<Ingredient> recipeIngredients = recipe.getIngredients();
      int borderSlotSize = 18;
      for (int row = 0; row < 2; ++row) {
          for (int column = 0; column < 2; ++column) {
              int inputIndex = row * 2 + column;
              if (inputIndex < recipeIngredients.size()) {
                  builder.addSlot(RecipeIngredientRole.INPUT, 1+column * borderSlotSize, 14 + row * borderSlotSize)
                  .addIngredients(recipeIngredients.get(inputIndex));
              }
          }
      }
      builder.addSlot(RecipeIngredientRole.OUTPUT, 66, 5).addItemStack(recipe.getResultItemList().get(0));
      if (recipe.getResultItemList().size() > 1) {
          builder.addSlot(RecipeIngredientRole.OUTPUT, 66, 41).addItemStack(recipe.getResultItemList().get(1));
      }
    }

    @Override
    public void draw(StoneMortarRecipe recipe, PoseStack matrixStack, double mouseX, double mouseY) {
        mortar.draw(matrixStack, 42, 20);
        basket.draw(matrixStack, 41, 36);
    }
}
