package cn.mcmod.sakura.compat.ct;

import cn.mcmod.sakura.api.recipes.MortarRecipes;
import cn.mcmod.sakura.util.SakuraRecipeRegister;
import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.oredict.IOreDictEntry;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;


@ZenClass("mods.sakura.stoneMorter")
@ZenRegister
public class CTSakuraStoneMortar {
	@ZenMethod
	public static void RemoveRecipe(IIngredient[] input) {
		if(input.length>0){
			Object[] array = new Object[input.length];
		    for(int i = 0; i < input.length;i++){
		    	if (input[i] instanceof IItemStack)
		    		array[i]=CraftTweakerMC.getItemStack(input[i]);
				else if(input[i] instanceof IOreDictEntry) 
					array[i]=((IOreDictEntry)input[i]).getName();	
			}
		    SakuraRecipeRegister.actions.add(new Removal(array));
		}
	}
	@ZenMethod
	public static void AddRecipe(IIngredient[] input,IItemStack[] output) {
		if(input.length>0&&output.length>0){
			Object[] array = new Object[input.length];
			ItemStack[] array2 = new ItemStack[input.length];
		    for(int i = 0; i < input.length;i++){
		    	if (input[i] instanceof IItemStack) 
		    		array[i]=CraftTweakerMC.getItemStack(input[i]);
				else if(input[i] instanceof IOreDictEntry) 
					array[i]=((IOreDictEntry)input[i]).getName();	
			}
		    
		    for(int i = 0; i < output.length;i++)
		    		array2[i]=CraftTweakerMC.getItemStack(output[i]);
			
		    SakuraRecipeRegister.actions.add(new Addition(array, array2));
		}
	}
	
	@ZenMethod
	public static void ClearAllRecipe() {
		SakuraRecipeRegister.actions.add(new ClearAllRecipe());
	}
	
    private static final class Removal implements IAction
    {
        private final Object[] itemInput;

        private Removal(Object[] itemInput)
        {
            this.itemInput = itemInput;
        }

        @Override
        public void apply()
        {
        	MortarRecipes.instance().ClearRecipe(itemInput);
        }

        @Override
        public String describe()
        {
            return "Removing a recipe for Stone Mortar";
        }
    }
	
    private static final class Addition implements IAction
    {
        private final Object[] itemInput;
        private final ItemStack[] itemOutput;

        private Addition(Object[] itemInput, ItemStack[] itemOutput)
        {
            this.itemInput = itemInput;
            this.itemOutput = itemOutput;
        }

        @Override
        public void apply()
        {
        	MortarRecipes.instance().addMortarRecipes(itemOutput, itemInput);
        }

        @Override
        public String describe()
        {
            return "Adding a recipe for Stone Mortar";
        }
    }

	
	private static final class ClearAllRecipe implements IAction
    {
        @Override
        public void apply()
        {
        	MortarRecipes.instance().ClearAllRecipe();
        }

        @Override
        public String describe()
        {
            return "Removing all recipes from Stone Mortar";
        }
    }
}
