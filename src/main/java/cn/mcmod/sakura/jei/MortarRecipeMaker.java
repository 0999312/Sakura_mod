package cn.mcmod.sakura.jei;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.mcmod.sakura.tileentity.TileEntityStoneMortar;
import cn.mcmod.sakura.tileentity.TileEntityStoneMortar.MortarRecipes;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public final class MortarRecipeMaker {
	  public static List<MortarRecipe> getRecipes(IJeiHelpers helpers)
	  {
	    IStackHelper stackHelper = helpers.getStackHelper(); 
	    List<MortarRecipe> recipes = new ArrayList<MortarRecipe>();

	    for (MortarRecipes recipe : TileEntityStoneMortar.mortarRecipesList) {
	    	List<List<ItemStack>> inputs = new ArrayList<List<ItemStack>>();
	    	for (Object obj : recipe.inputItems) {
	    		List<ItemStack> subinputs = stackHelper.toItemStackList(obj);
		    	inputs.add(subinputs);
			}
	    	List<List<ItemStack>> outputs = new ArrayList<List<ItemStack>>();
	    	for (ItemStack obj : recipe.resultItems) {
	    		List<ItemStack> suboutputs = stackHelper.toItemStackList(obj);
	    		outputs.add(suboutputs);
			}
	    	MortarRecipe newrecipe = new MortarRecipe(inputs,outputs);
	    	recipes.add(newrecipe);
        }
	    return recipes;
	  }
}
