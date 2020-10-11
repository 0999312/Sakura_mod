package cn.mcmod.sakura.api.recipes;

import com.google.common.collect.Maps;

import cn.mcmod_mmf.mmlib.recipe.ItemToItemRecipeBase;

public class WebRecipe extends ItemToItemRecipeBase {
	private WebRecipe() {
		this.RecipesList = Maps.newHashMap();
	}
	private static final WebRecipe RECIPE_BASE = new WebRecipe();

	public static WebRecipe getInstance() {
		return RECIPE_BASE;
	}
}
