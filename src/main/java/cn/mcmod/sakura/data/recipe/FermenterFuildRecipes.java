package cn.mcmod.sakura.data.recipe;

import cn.mcmod.sakura.recipes.recipes.object.RecipeFluidStack;
import cn.mcmod.sakura.recipes.recipes.recipe.FermenterFluidRecipe;
import cn.mcmod.sakura.recipes.recipes.register.RecipeSerializers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;

/**
 * @author DustW
 **/
public class FermenterFuildRecipes extends AvarusRecipes {
    @Override
    protected void addRecipes() {
        // todo 你研究着怎么填吧
        //addFermenterFluidRecipe(
        //        Ingredient.of(Items.IRON_INGOT),
        //        new ItemStack(AvarusItems.IRON_PLATE.get()),
        //        1,
        //        1
        //);
    }

    protected void addFermenterFluidRecipe(Ingredient input, ItemStack output, FluidStack fluidStack) {
        FermenterFluidRecipe result = new FermenterFluidRecipe();
        result.setID(defaultName(output.getItem()));
        result.type = RecipeSerializers.PLATE_RECIPE.get().getRegistryName().toString();

        result.output = output;
        result.input = input;
        result.fluidStack = new RecipeFluidStack(fluidStack);

        addRecipe(defaultName(output.getItem()), baseRecipe(result), "fermerter_fluid");
    }
}
