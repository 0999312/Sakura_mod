package cn.mcmod.sakura.api.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import cn.mcmod_mmf.mmlib.util.RecipesUtil;

public class DistillationRecipes {
	private static final DistillationRecipes RECIPE_BASE = new DistillationRecipes();
    private DistillationRecipes() {
	}
	public static DistillationRecipes getInstance() {
		return RECIPE_BASE;
	}
	public final Map<Pair<FluidStack, Object[]>,List<FluidStack>> RecipesList = Maps.newHashMap();

    public void register(FluidStack input, FluidStack output) {
    	register(input,output, new Object[]{ItemStack.EMPTY,ItemStack.EMPTY,ItemStack.EMPTY});
    }
    public void register(FluidStack input, FluidStack output, Object[] additives) {
    	Pair<FluidStack, Object[]> items = Pair.of(output, additives);
		RecipesList.put(items,Lists.newArrayList(input));
    }
	
    public void register(List<FluidStack> input, FluidStack output) {
    	register(input,output, new Object[]{ItemStack.EMPTY,ItemStack.EMPTY,ItemStack.EMPTY});
    }
    public void register(List<FluidStack> input, FluidStack output, Object[] additives) {
    	Pair<FluidStack, Object[]> items = Pair.of(output, additives);
		RecipesList.put(items,input);
    }

	public FluidStack getFluidStack(FluidStack fluid) {
		for (List<FluidStack> entry : RecipesList.values()) {
			for(FluidStack fluid_entry:entry)
				if(fluid_entry.isFluidEqual(fluid))
				return fluid_entry;
		}
		return null;
	}

	public FluidStack getResultFluidStack(FluidStack fluid, ItemStack[] inputs) {
		for (Entry<Pair<FluidStack, Object[]>,List<FluidStack>> entry : RecipesList.entrySet()) {
			for(FluidStack fluid_entry:entry.getValue())
			if(fluid_entry.isFluidEqual(fluid)) {
		            boolean flg1 = true;
	            	for (Object obj1 : entry.getKey().getRight()) {
		        		boolean flg2 = false;
		        		for (ItemStack input:inputs) {
		                	if(obj1 instanceof ItemStack){
		                		ItemStack stack1 = (ItemStack) obj1;
		    	                if (ItemStack.areItemsEqual(stack1, input)) {
		    	                    flg2 = true;
		    	                    break;
		    	                }
		                    }else if(obj1 instanceof String){
		                    	NonNullList<ItemStack> ore = OreDictionary.getOres((String) obj1);
		                    	if (!ore.isEmpty()&&RecipesUtil.getInstance().containsMatch(false, ore, input)) {
		                            flg2 = true;
		    	                    break;
		                        }
		                    }
		                }
		                if (!flg2) {
		                    flg1 = false;
		                    break;
		                }
		            }
	
		            if (flg1) {
		                return entry.getKey().getKey();
		            }
		        }
		}

		return null;
	}
  
    public void ClearRecipe(FluidStack input) {
    	for (Entry<Pair<FluidStack, Object[]>,List<FluidStack>> entry : RecipesList.entrySet()) {
    		Pair<FluidStack, Object[]> recipe = entry.getKey();
    			if(recipe.getLeft().isFluidEqual(input)) {
				RecipesList.remove(entry.getKey());
				return ;
			}
		}
		throw new NullPointerException("NO RECIPE HERE");
	}
    
    public void ClearAllRecipe() {
    	RecipesList.clear();
	}
}
