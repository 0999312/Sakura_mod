package cn.mcmod.sakura.recipes.recipes.recipe;

import cn.mcmod.sakura.recipes.recipes.base.BaseRecipe;
import cn.mcmod.sakura.recipes.recipes.object.RecipeFluidStack;
import cn.mcmod.sakura.recipes.recipes.register.RecipeSerializers;
import cn.mcmod.sakura.recipes.recipes.register.RecipeTypes;
import com.google.gson.annotations.Expose;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;
import java.util.Objects;

/**
 * @author DustW
 **/
public class FermenterFluidRecipe extends BaseRecipe<FermenterFluidRecipe> {
    @Expose
    public Ingredient input;
    @Expose
    public ItemStack output;
    @Expose
    public RecipeFluidStack fluidStack;

    @Override
    public ItemStack getResultItem() {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializers.PLATE_RECIPE.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeTypes.FERMENTER_FLUID.get();
    }

    public boolean matches(ItemStack input, FluidStack inputFluid) {
        return
                this.input.test(input) &&
                Objects.equals(this.fluidStack.fluidName, inputFluid.getFluid().getRegistryName().toString()) &&
                inputFluid.getAmount() > fluidStack.amount;
    }

    @Override
    public boolean matches(List<ItemStack> inputs) {
        return input.test(inputs.get(0));
    }
}
