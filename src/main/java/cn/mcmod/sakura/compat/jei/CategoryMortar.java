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

public class CategoryMortar implements IRecipeCategory<IRecipeWrapper>{
	 protected final IDrawable background;
	  private final IDrawable icon;
	  public CategoryMortar(IGuiHelper helper) {
		  ResourceLocation backgroundTexture = new ResourceLocation(SakuraMain.MODID+":textures/gui/stonemortar.png");
		  this.icon = helper.createDrawableIngredient(new ItemStack(BlockLoader.STONEMORTAR));
		  this.background = helper.createDrawable(backgroundTexture, 38, 24, 112, 39);
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
		return I18n.format("jei.sakura.category.mortar", new Object[0]);
	}

	@Override
	public String getUid() {
		return "sakura.mortar";
	}
	@Override
	public void setRecipe(IRecipeLayout arg0, IRecipeWrapper arg1, IIngredients arg2) {
		IGuiItemStackGroup items = arg0.getItemStacks();
		
		items.init(0, true, 1, 1);
		items.init(1, true, 19, 1);
		items.init(2, true, 1, 19);
		items.init(3, true, 19, 19);
		items.init(4, false, 69, 12);
		items.init(5, false, 93, 12);
	    
		items.set(arg2);
	}
	public IDrawable getIcon() {
		return icon;
	}

}
