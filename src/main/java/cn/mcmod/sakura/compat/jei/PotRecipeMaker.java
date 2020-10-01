package cn.mcmod.sakura.compat.jei;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Lists;

import cn.mcmod.sakura.api.recipes.PotRecipes;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public final class PotRecipeMaker {
	  public static List<ItemFluidRecipe> getRecipes(IJeiHelpers helpers) {
	    IStackHelper stackHelper = helpers.getStackHelper();
	    List<ItemFluidRecipe> recipes = new ArrayList<ItemFluidRecipe>();
	    for (Entry<Pair<Object[], ItemStack>, List<FluidStack>> entry : PotRecipes.getInstance().RecipesList.entrySet()) {
	    	List<List<ItemStack>> inputs = new ArrayList<List<ItemStack>>();
	    	List<List<FluidStack>> fluidlist=new ArrayList<List<FluidStack>>();
	    	for (Object obj : entry.getKey().getLeft()) {
	    		List<ItemStack> subinputs = stackHelper.toItemStackList(obj);
		    	inputs.add(subinputs);
			}
	    	if(!entry.getValue().isEmpty())
	    		fluidlist.add(entry.getValue());
	    	else
	    		fluidlist.add(Lists.newArrayList(new FluidStack(FluidRegistry.WATER, 0)));
	    	ItemFluidRecipe newrecipe = new ItemFluidRecipe(inputs,fluidlist,entry.getKey().getRight());
	    	recipes.add(newrecipe);
	    }
	    return recipes;
	    
	  }
}
