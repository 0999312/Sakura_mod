package cn.mcmod.sakura.compat.jei;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cn.mcmod.sakura.api.recipes.BarrelRecipes;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public final class BarrelRecipeMaker {
	  public static List<BarrelRecipe> getRecipes(IJeiHelpers helpers){
	    IStackHelper stackHelper = helpers.getStackHelper();

	    List<BarrelRecipe> recipes = new ArrayList<BarrelRecipe>();

	    for (Entry<FluidStack, Map<Object[], FluidStack>> entry : BarrelRecipes.getInstance().RecipesList.entrySet()) {
	    	for(Entry<Object[], FluidStack> entry2 : entry.getValue().entrySet()){
	    	List<List<ItemStack>> inputs = new ArrayList<List<ItemStack>>();
	    	List<List<FluidStack>> fluidlist=new ArrayList<List<FluidStack>>();
	    	List<FluidStack> fluid = new ArrayList<FluidStack>();
	    	
	    	for (Object obj : entry2.getKey()) {
	    		List<ItemStack> subinputs = stackHelper.toItemStackList(obj);
		    	inputs.add(subinputs);
			}
	    	
		    fluid.add(entry.getKey());
		    fluidlist.add(fluid);
	    	
	    	BarrelRecipe newrecipe = new BarrelRecipe(inputs,fluidlist,entry2.getValue());
	    	recipes.add(newrecipe);
	    	}
	    }
	    return recipes;
	  }
}
