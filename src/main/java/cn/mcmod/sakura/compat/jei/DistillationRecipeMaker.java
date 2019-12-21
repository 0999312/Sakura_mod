package cn.mcmod.sakura.compat.jei;

import java.util.ArrayList;
import java.util.List;
import cn.mcmod.sakura.api.recipes.DistillationRecipes;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public final class DistillationRecipeMaker {
	  public static List<BarrelRecipe> getRecipes(IJeiHelpers helpers){
	    IStackHelper stackHelper = helpers.getStackHelper();

	    List<BarrelRecipe> recipes = new ArrayList<BarrelRecipe>();

	    for (DistillationRecipes recipe : DistillationRecipes.getRecipeRegistry()) {
	    	List<List<ItemStack>> inputs = new ArrayList<List<ItemStack>>();
	    	List<List<FluidStack>> fluidlist=new ArrayList<List<FluidStack>>();
	    	List<FluidStack> fluid = new ArrayList<FluidStack>();
	    	if(recipe.getAdditives()!=null)
	    	for (Object obj : recipe.getAdditives()) {
	    		List<ItemStack> subinputs = stackHelper.toItemStackList(obj);
		    	inputs.add(subinputs);
			}
	    	
		    fluid.add(recipe.getInput());
		    fluidlist.add(fluid);
	    	
	    	BarrelRecipe newrecipe = new BarrelRecipe(inputs,fluidlist,recipe.getOutput());
	    	recipes.add(newrecipe);
	    }
	    return recipes;
	    
	  }
}
