package cn.mcmod.sakura.compat.jei;

import java.util.List;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

public class SimpleRecipe implements IRecipeWrapper{
	private final List<List<ItemStack>> inputs;
	private final List<List<ItemStack>> output;
	  
	public SimpleRecipe(List<List<ItemStack>> inputs, List<List<ItemStack>> output) {
		this.inputs = inputs;
		this.output = output;
	}
	  
	public void getIngredients(IIngredients ingredients){
		ingredients.setInputLists(VanillaTypes.ITEM, this.inputs);
		ingredients.setOutputLists(VanillaTypes.ITEM, this.output);
	}
	  
}
