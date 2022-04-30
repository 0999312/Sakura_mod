package cn.mcmod.sakura.recipes.recipes.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import net.minecraftforge.fluids.FluidStack;

/**
 * @author DustW
 **/
public class RecipeFluidStack {
    @Expose
    @SerializedName("fluid_name")
    public String fluidName;
    @Expose
    public int amount;

    public RecipeFluidStack(String fluidName, int amount) {
        this.fluidName = fluidName;
        this.amount = amount;
    }

    public RecipeFluidStack(FluidStack fluidStack) {
        this(fluidStack.getFluid().getRegistryName().toString(), fluidStack.getAmount());
    }
}
