package cn.mcmod.sakura.api.recipes;

import cn.mcmod.sakura.util.RecipesUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DistillationRecipes {
    public static final int DEFAULT_DURATION = 9000;
    private static List<DistillationRecipes> recipeRegistry = new ArrayList<>();
    private int duration;
    private FluidStack input;
    private FluidStack output;
    private List<Object> additives;
    private List<ItemStack> transformed;

    public DistillationRecipes(FluidStack input, FluidStack output, Object[] additives, int duration) {
        this.input = input;
        this.output = output;
        this.additives = additives != null ? Arrays.asList(additives) : new ArrayList<>();
        this.duration = duration;
    }

    public DistillationRecipes(FluidStack input, FluidStack output, int duration) {
        this(input, output, null, duration);
    }

    public static void register(DistillationRecipes recipes) {
        recipeRegistry.add(recipes);
    }

    public static List<DistillationRecipes> getPossibleRecipes(FluidStack input, List<ItemStack> items) {
        List<DistillationRecipes> result = new ArrayList<>();

        for (DistillationRecipes br : recipeRegistry) {
            List<ItemStack> examine = new ArrayList<>();
            for (ItemStack item : items)
                examine.add(item.copy());

            if (br.getInput().isFluidEqual(input) && br.getInput().amount <= input.amount) {
                boolean matched = true;
                for (Object i : br.getAdditives()) {
                    boolean found = false;
                    for (ItemStack j : examine) {
                        if (i instanceof ItemStack)
                            if (((ItemStack) i).isItemEqual(j) &&
                                    ((ItemStack) i).getCount() <= j.getCount()) {
                                found = true;
                                j.setCount(j.getCount() - ((ItemStack) i).getCount());
                                break;
                            }
                        if (i instanceof String) {
                            NonNullList<ItemStack> ore = OreDictionary.getOres((String) i);
                            if (!ore.isEmpty() && RecipesUtil.containsMatch(false, ore, j)) {
                                found = true;
                                j.shrink(1);
                                break;
                            }
                        }

                    }
                    if (!found) {
                        matched = false;
                        break;
                    }
                }
                if (matched) {
                    br.transformed = examine;
                    result.add(br);
                }
            }
        }

        return result;
    }

    public static List<DistillationRecipes> getRecipeRegistry() {
        return recipeRegistry;
    }

    public FluidStack getInput() {
        return input;
    }

    public FluidStack getOutput() {
        return output;
    }

    public int getDuration() {
        return duration;
    }

    public List<Object> getAdditives() {
        return additives;
    }

    public List<ItemStack> getTransformed() {
        return transformed;
    }
    
    public static void ClearRecipe(FluidStack input) {
    	Iterator<DistillationRecipes> iter = recipeRegistry.iterator();
		while(iter.hasNext()){
			DistillationRecipes recipes = iter.next();
				if(input.equals(recipes.output))
					iter.remove();
		}
	}
    
    public static void ClearAllRecipe() {
    	recipeRegistry.clear();
	}
}
