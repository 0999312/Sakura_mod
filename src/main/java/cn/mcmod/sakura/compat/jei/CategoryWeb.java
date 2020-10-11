package cn.mcmod.sakura.compat.jei;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.block.BlockLoader;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class CategoryWeb implements IRecipeCategory<IRecipeWrapper>{
	 protected final IDrawable background;
	  private final IDrawable icon;
	  public CategoryWeb(IGuiHelper helper) {
		  ResourceLocation backgroundTexture = new ResourceLocation(SakuraMain.MODID+":textures/gui/jei_compat.png");
		  this.icon = helper.createDrawableIngredient(new ItemStack(BlockLoader.STRAW_WEB));
		  this.background = helper.createDrawable(backgroundTexture, 0, 81, 93, 46);
	}
	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public String getModName() {
		return SakuraMain.NAME;
	}

	@Override
	public String getTitle() {
		return I18n.format("jei.sakura.category.straw_web", new Object[0]);
	}

	@Override
	public String getUid() {
		return "sakura.straw_web";
	}
	@Override
	public void setRecipe(IRecipeLayout arg0, IRecipeWrapper arg1, IIngredients arg2) {
		IGuiItemStackGroup items = arg0.getItemStacks();
		items.init(0, true, 13, 14);
		items.init(1, false, 62, 14);
		items.set(arg2);
	}
	public IDrawable getIcon() {
		return icon;
	}

}
