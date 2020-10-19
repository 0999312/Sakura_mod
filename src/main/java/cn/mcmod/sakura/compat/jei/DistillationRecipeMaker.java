package cn.mcmod.sakura.compat.jei;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang3.tuple.Pair;

import cn.mcmod.sakura.api.recipes.DistillationRecipes;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public final class DistillationRecipeMaker {
	  public static List<BarrelRecipe> getRecipes(IJeiHelpers helpers){
	    IStackHelper stackHelper = helpers.getStackHelper();

	    List<BarrelRecipe> recipes = new ArrayList<BarrelRecipe>();

	    for (Entry<Pair<FluidStack, Object[]>,List<FluidStack>> entry : DistillationRecipes.getInstance().RecipesList.entrySet()) {
	    	List<List<ItemStack>> inputs = new ArrayList<List<ItemStack>>();
	    	List<List<FluidStack>> fluidlist=new ArrayList<List<FluidStack>>();
	    	
	    	for (Object obj : entry.getKey().getRight()) {
	    		List<ItemStack> subinputs = stackHelper.toItemStackList(obj);
		    	inputs.add(subinputs);
			}
	    	
	    	fluidlist.add(entry.getValue());
	    	
	    	BarrelRecipe newrecipe = new BarrelRecipe(inputs,fluidlist,entry.getKey().getLeft());
	    	recipes.add(newrecipe);
	    }
	    return recipes;
	  }
}
