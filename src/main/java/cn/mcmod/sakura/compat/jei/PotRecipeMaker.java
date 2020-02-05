package cn.mcmod.sakura.compat.jei;

import java.util.ArrayList;
import java.util.List;
import cn.mcmod.sakura.api.recipes.PotRecipes;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public final class PotRecipeMaker {
	  public static List<CampingPotRecipe> getRecipes(IJeiHelpers helpers)
	  {
	    IStackHelper stackHelper = helpers.getStackHelper();
	    List<CampingPotRecipe> recipes = new ArrayList<CampingPotRecipe>();
	    for (PotRecipes recipe : PotRecipes.potRecipesList) {
	    	List<List<ItemStack>> inputs = new ArrayList<List<ItemStack>>();
	    	List<ItemStack> main = new ArrayList<ItemStack>();
	    	List<List<FluidStack>> fluidlist=new ArrayList<List<FluidStack>>();
	    	List<FluidStack> fluid = new ArrayList<FluidStack>();
	    	main = stackHelper.toItemStackList(recipe.mainItem);
	    	inputs.add(main);
	    	for (Object obj : recipe.subItems) {
	    		List<ItemStack> subinputs = stackHelper.toItemStackList(obj);
		    	inputs.add(subinputs);
			}
	    	
		    fluid.add(recipe.fluid);
		    fluidlist.add(fluid);
	    	
	    	CampingPotRecipe newrecipe = new CampingPotRecipe(inputs,fluidlist,recipe.resultItem);
	    	recipes.add(newrecipe);
	    }
	    return recipes;
	    
	  }
}
