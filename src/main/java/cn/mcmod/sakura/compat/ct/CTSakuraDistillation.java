package cn.mcmod.sakura.compat.ct;

import cn.mcmod.sakura.api.recipes.DistillationRecipes;
import cn.mcmod.sakura.util.SakuraRecipeRegister;
import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.oredict.IOreDictEntry;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;


@ZenClass("mods.sakura.Distillation")
@ZenRegister
public class CTSakuraDistillation {
	@ZenMethod
	public static void RemoveRecipe(ILiquidStack input) {
		SakuraRecipeRegister.actions.add(new Removal(CraftTweakerMC.getLiquidStack(input)));
	}
	@ZenMethod
	public static void AddRecipe(ILiquidStack input_fluid,IIngredient[] input,ILiquidStack output) {
		if(input.length>0){
			Object[] array = new Object[input.length];
		    for(int i = 0; i < input.length;i++){
		    	if (input[i] instanceof IItemStack) 
		    		array[i]=CraftTweakerMC.getItemStack(input[i]);
				else if(input[i] instanceof IOreDictEntry) 
					array[i]=((IOreDictEntry)input[i]).getName();	
			}

		    SakuraRecipeRegister.actions.add(new Addition(array, CraftTweakerMC.getLiquidStack(output),CraftTweakerMC.getLiquidStack(input_fluid)));
		}
	}
	
	@ZenMethod
	public static void ClearAllRecipe() {
		SakuraRecipeRegister.actions.add(new ClearAllRecipe());
	}
	
    private static final class Removal implements IAction
    {
        private final FluidStack itemInput;

        private Removal(FluidStack itemInput)
        {
            this.itemInput = itemInput;
        }

        @Override
        public void apply()
        {
        	DistillationRecipes.ClearRecipe(itemInput);
        }

        @Override
        public String describe()
        {
            return "Removing a recipe for Distillation Barrel";
        }
    }
	
    private static final class Addition implements IAction
    {
        private final Object[] itemInput;
        private final FluidStack fluidOutput;
        private final FluidStack fluidInput;
        
        private Addition(Object[] itemInput, FluidStack fluidOutput,FluidStack fluidInput)
        {
            this.itemInput = itemInput;
            this.fluidOutput = fluidOutput;
            this.fluidInput = fluidInput;
        }

        @Override
        public void apply()
        {
        	DistillationRecipes.getInstance().register(fluidInput, fluidOutput, itemInput);
        }

        @Override
        public String describe()
        {
            return "Adding a recipe for Distillation Barrel";
        }
    }

	
	private static final class ClearAllRecipe implements IAction
    {
        @Override
        public void apply()
        {
        	DistillationRecipes.ClearAllRecipe();
        }

        @Override
        public String describe()
        {
            return "Removing all recipes from Distillation Barrel";
        }
    }
}
