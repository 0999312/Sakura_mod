package cn.mcmod.sakura.compat.jei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import cn.mcmod.sakura.api.recipes.WebRecipe;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public final class WebRecipeMaker {
	  public static List<SimpleRecipe> getRecipes(IJeiHelpers helpers)
	  {
	    IStackHelper stackHelper = helpers.getStackHelper(); 
	    List<SimpleRecipe> recipes = new ArrayList<SimpleRecipe>();

	    for (Entry<Object, ItemStack> entry : WebRecipe.getInstance().RecipesList.entrySet()) {
	    	
	    	List<ItemStack> inputs = stackHelper.toItemStackList(entry.getKey());
		    	
	    	List<ItemStack> outputs = stackHelper.toItemStackList(entry.getValue());
	    	
			
	    	SimpleRecipe newrecipe = new SimpleRecipe(Collections.singletonList(inputs),Collections.singletonList(outputs));
	    	recipes.add(newrecipe);
        }
	    return recipes;
	  }
}
