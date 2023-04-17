package cn.mcmod.sakura.recipes;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import cn.mcmod_mmf.mmlib.fluid.FluidIngredient;
import cn.mcmod_mmf.mmlib.recipe.AbstractRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.RecipeMatcher;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class CookingPotRecipe extends AbstractRecipe {
    @Expose
    @SerializedName("ingredients")
    public NonNullList<Ingredient> inputItems;
    @Expose
    @SerializedName("fluid")
    public FluidIngredient fluidInput;
    @Expose
    @SerializedName("result")
    public ItemStack output;

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.inputItems;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public FluidIngredient getRequiredFluid() {
        return fluidInput;
    }

    public boolean matchesWithFluid(FluidStack fluid, RecipeWrapper inv, Level worldIn) {
        if(this.getRequiredFluid() == FluidIngredient.EMPTY)
            return matches(inv, worldIn);
        return this.getRequiredFluid().test(fluid) && matches(inv, worldIn);
    }

    @Override
    public boolean matches(RecipeWrapper inv, Level worldIn) {
        List<ItemStack> inputs = Lists.newArrayList();
        int i = 0;
        for (int j = 0; j < 9; ++j) {
            ItemStack itemstack = inv.getItem(j);
            if (!itemstack.isEmpty()) {
                ++i;
                inputs.add(itemstack);
            }
        }
        return i == this.getIngredients().size() && RecipeMatcher.findMatches(inputs, this.getIngredients()) != null;
    }

    @Override
    public ItemStack assemble(RecipeWrapper inv) {
        return this.output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.getIngredients().size();
    }

    @Override
    public ItemStack getResultItem() {
        return this.output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegistry.COOKING_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeTypeRegistry.COOKING_RECIPE_TYPE.get();
    }

}
