package cn.mcmod.sakura.compat.jei;

import java.util.ArrayList;
import java.util.List;

import cn.mcmod.sakura.api.recipes.LiquidToItemRecipe;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public final class L2ISRecipeMaker {
	  public static List<CampingPotRecipe> getRecipes(IJeiHelpers helpers) {
	    IStackHelper stackHelper = helpers.getStackHelper();
	    List<CampingPotRecipe> recipes = new ArrayList<CampingPotRecipe>();
	    for (LiquidToItemRecipe recipe : LiquidToItemRecipe.RecipesList) {
	    	List<List<ItemStack>> inputs = new ArrayList<List<ItemStack>>();
	    	List<ItemStack> main = stackHelper.toItemStackList(recipe.mainItem);
	    	List<List<FluidStack>> fluidlist=new ArrayList<List<FluidStack>>();
	    	List<FluidStack> fluid = new ArrayList<FluidStack>();
	    	
	    	inputs.add(main);
		    fluid.add(recipe.getResultFluid());
		    fluidlist.add(fluid);
	    	
	    	CampingPotRecipe newrecipe = new CampingPotRecipe(inputs,fluidlist,recipe.resultItem);
	    	recipes.add(newrecipe);
	    }
	    return recipes;
	    
	  }
}
