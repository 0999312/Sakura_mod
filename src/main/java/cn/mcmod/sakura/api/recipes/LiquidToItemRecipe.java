package cn.mcmod.sakura.api.recipes;

import java.util.ArrayList;
import java.util.Iterator;

import cn.mcmod.sakura.util.RecipesUtil;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

public class LiquidToItemRecipe {
    public static ArrayList<LiquidToItemRecipe> RecipesList = new ArrayList<LiquidToItemRecipe>();

    public ItemStack resultItem = ItemStack.EMPTY;
    public Object mainItem = ItemStack.EMPTY;
    public FluidStack fluid = null;

    public LiquidToItemRecipe(Object main, ItemStack result, FluidStack fluidStack) {
    	this.setPotRecipes(result, main, fluidStack);
    }

    public void setPotRecipes(ItemStack result, Object main, FluidStack fluidStack) {
        this.clear();
        if(main instanceof ItemStack || main instanceof String)
        mainItem = main;
        else throw new IllegalArgumentException("Main Item is not a ItemStack or Ore Dictionary");
        resultItem = result.copy();
        fluid = fluidStack.copy();
    }

    /**
     * 初期化
     */
    public void clear() {
        resultItem = ItemStack.EMPTY;
        mainItem = ItemStack.EMPTY;
        fluid = null;
    }

    public ItemStack getResultItemStack() {
        return resultItem.copy();
    }

    public FluidStack getResultFluid() {
        return fluid.copy();
    }

    public FluidStack getResultFluid(FluidStack fluidStack) {
        if (fluidStack.isFluidEqual(fluid)) {
            return fluidStack;
        }
		return null;
    }

    public ItemStack getResult(IInventory inventory,FluidStack fluidStack,int slot_number) {
        ItemStack retStack = ItemStack.EMPTY;
        if(getResultFluid(fluidStack)==null){
        	return resultItem.copy();
        }
        if(mainItem instanceof ItemStack){
          if (!ItemStack.areItemsEqual((ItemStack) mainItem, inventory.getStackInSlot(slot_number))) {
          return retStack;
          }	
        }else if(mainItem instanceof String){
        	String dict = (String) mainItem;
        	ItemStack result = inventory.getStackInSlot(3);
        	NonNullList<ItemStack> ore =OreDictionary.getOres(dict);
        	if(ore.isEmpty()) return retStack;
        	if (!RecipesUtil.containsMatch(true, ore, result)) return retStack;
        }
        return resultItem.copy();

    }

    public static void addRecipe(LiquidToItemRecipe recipes) {
        RecipesList.add(recipes);
    }

    public static void ClearRecipe(Object input) {
    	if(input instanceof ItemStack||input instanceof String){
    		Iterator<LiquidToItemRecipe> iter = RecipesList.iterator();
    		while(iter.hasNext()){
    			LiquidToItemRecipe recipes = iter.next();
				if(input instanceof ItemStack&&ItemStack.areItemStacksEqual((ItemStack)input, recipes.resultItem)) 
					iter.remove();
				if(input instanceof String) {
					NonNullList<ItemStack> ore = OreDictionary.getOres((String) input);
					if(RecipesUtil.containsMatch(false, ore, recipes.resultItem))
					iter.remove();
				}
			}
		}
		else throw new IllegalArgumentException("Not a itemStack or Ore Dictionary");
	}
	
    
    public static void ClearAllRecipe() {
    	RecipesList.clear();
	}
}